package corgis.supreme_court;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import corgis.supreme_court.domain.*;

import java.sql.*;

/**
 * <p> The U.S. Supreme Court Database traces its history back about two decades ago, when Harold J. Spaeth asked the National Science Foundation to fund a database that would be so rich in content that multiple users - even those with vastly distinct projects and purposes in mind - could draw on it. Professor Spaeth's goal was at once refreshingly simple and extremely ambitious: to produce a database that would include and classify every single vote by a Supreme Court justice in all argued cases over a five-decade period. After securing the funding, Spaeth collected and coded the data, performed reliability checks, and eventually amassed the Database. In the late 1980s, he made it (and the documentation necessary to use it) publicly available. </p><p> Since then, Professor Spaeth has not only updated it each term; he has also continued to perform reliability analyses, thereby ensuring its integrity with each release, and added new variables. Today's version of the Database houses 247 pieces of information for each case, roughly broken down into six categories: (1) identification variables (e.g., citations and docket numbers); (2) background variables (e.g., how the Court took jurisdiction, origin and source of the case, the reason the Court agreed to decide it); (3) chronological variables (e.g., the date of decision, term of Court, natural court); (4) substantive variables (e.g., legal provisions, issues, direction of decision); (5) outcome variables (e.g., disposition of the case, winning party, formal alteration of precedent, declaration of unconstitutionality); and (6) voting and opinion variables (e.g., how the individual justices voted, their opinions and interagreements). </p><p> Case Centered data provides case level information; i.e., each row in the database corresponds to a dispute. These data do not contain specific justice vote information. </p><p> A tremendously helpful resource for learning more about the dataset is the codebook: <a href='http://supremecourtdatabase.org/documentation.php?s=1'>http://supremecourtdatabase.org/documentation.php?s=1</a>. </p>

 */
public class SupremeCourtLibrary {
    private String databasePath;
	private Connection connection;
    private JSONParser parser;
    private final int HARDWARE = 1000;
    
    public static void main(String[] args) {
        System.out.println("Testing SupremeCourt");
        SupremeCourtLibrary supremeCourtLibrary = new SupremeCourtLibrary();
        
        
        System.out.println("Testing production GetCases");
        ArrayList<CourtCase> list_of_court_case_1_production = supremeCourtLibrary.getCases(false);
        
        
        System.out.println("Testing test GetCases");
        ArrayList<CourtCase> list_of_court_case_1_test = supremeCourtLibrary.getCases(true);
        
        
    }
    
    private void connectToDatabase(String databasePath) {
        this.connection = null;
        try {
            this.connection = DriverManager.getConnection("jdbc:sqlite:"+databasePath);
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        this.parser =  new JSONParser();
    }
	
    /**
     * Create a connection to the database file in its standard position.
     */
	public SupremeCourtLibrary() {
        this.databasePath = "supreme_court.db";
        this.connectToDatabase(this.databasePath);
	}
	
    /**
     * Create a connection to the database file, stored explicitly somewhere.
     * @param databasePath The filename of the database file.
     */
	public SupremeCourtLibrary(String databasePath) {
        this.databasePath = databasePath;
        this.connectToDatabase(this.databasePath);
	}
    
    
    
    /**
     * Returns a list of the court cases in the database.
    
     * @return a list[court case]
     */
	public ArrayList<CourtCase> getCases() {
        return this.getCases(true);
    }
    
    
    /**
     * Returns a list of the court cases in the database.
    
     * @return a list[court case]
     */
	public ArrayList<CourtCase> getCases(boolean test) {
        String query;
        if (test) {
            query = String.format("SELECT data FROM supreme_court LIMIT %d", this.HARDWARE);
        } else {
            query = "SELECT data FROM supreme_court";
        }
        PreparedStatement preparedQuery = null;
        ResultSet rs = null;
        try {
            preparedQuery = this.connection.prepareStatement(query);
        } catch (SQLException e) {
            System.err.println("Could not build SQL query for local database.");
    		e.printStackTrace();
        }
        try {
            rs = preparedQuery.executeQuery();
        } catch (SQLException e) {
            System.err.println("Could not execute query.");
    		e.printStackTrace();
        }
        
        ArrayList<CourtCase> result = new ArrayList<CourtCase>();
        try {
            while (rs.next()) {
                String raw_result = rs.getString(1);
                CourtCase parsed = null;
                if (test) {
                    parsed = new CourtCase(((JSONObject)this.parser.parse(raw_result)));
                    
                } else {
                    parsed = new CourtCase(((JSONObject)this.parser.parse(raw_result)));
                    
                }
                
                result.add(parsed);
                
            }
        } catch (SQLException e) {
            System.err.println("Could not iterate through query.");
    		e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Could not convert the response from getCases; a parser error occurred.");
    		e.printStackTrace();
        }
        return result;
	}
    
}