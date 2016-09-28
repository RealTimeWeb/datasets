package corgis.construction_spending;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import corgis.construction_spending.domain.*;

import java.sql.*;

/**
 * The Value of Construction Put in Place Survey (VIP) provides monthly estimates of the total dollar value of construction work done in the U.S. The United States Code, Title 13, authorizes this program. The survey covers construction work done each month on new structures or improvements to existing structures for private and public sectors. Data estimates include the cost of labor and materials, cost of architectural and engineering work, overhead costs, interest and taxes paid during construction, and contractor's profits. Data collection and estimation activities begin on the first day after the reference month and continue for about three weeks. Reported data and estimates are for activity taking place during the previous calendar month. The survey has been conducted monthly since 1964. <br><br><b>Why isn't the 'total construction' the sum of the other categories?</b> It is! the trick is that the 'residential' and "nonresidential" categories are supposed to be below the 'total construction' level, and the other categories are below those two categories. This example of the data should make it more clear: <a href='http://www.census.gov/construction/c30/pdf/tot.pdf'>http://www.census.gov/construction/c30/pdf/tot.pdf</a>.<br><br>More information about the nature of the construction projects is also <a href='https://www.census.gov/construction/c30/definitions.html'>available.</a>

 */
public class ConstructionSpendingLibrary {
    private String databasePath;
	private Connection connection;
    private JSONParser parser;
    private final int HARDWARE = 1000;
    
    public static void main(String[] args) {
        System.out.println("Testing ConstructionSpending");
        ConstructionSpendingLibrary constructionSpendingLibrary = new ConstructionSpendingLibrary();
        
        
        System.out.println("Testing production GetSpending");
        ArrayList<Spending> list_of_spending_1_production = constructionSpendingLibrary.getSpending(false);
        
        
        System.out.println("Testing test GetSpending");
        ArrayList<Spending> list_of_spending_1_test = constructionSpendingLibrary.getSpending(true);
        
        
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
	public ConstructionSpendingLibrary() {
        this.databasePath = "construction_spending.db";
        this.connectToDatabase(this.databasePath);
	}
	
    /**
     * Create a connection to the database file, stored explicitly somewhere.
     * @param databasePath The filename of the database file.
     */
	public ConstructionSpendingLibrary(String databasePath) {
        this.databasePath = databasePath;
        this.connectToDatabase(this.databasePath);
	}
    
    
    
    /**
     * Returns spending data from every year.
    
     * @return a list[spending]
     */
	public ArrayList<Spending> getSpending() {
        return this.getSpending(true);
    }
    
    
    /**
     * Returns spending data from every year.
    
     * @return a list[spending]
     */
	public ArrayList<Spending> getSpending(boolean test) {
        String query;
        if (test) {
            query = String.format("SELECT data FROM construction_spending LIMIT %d", this.HARDWARE);
        } else {
            query = "SELECT data FROM construction_spending";
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
        
        ArrayList<Spending> result = new ArrayList<Spending>();
        try {
            while (rs.next()) {
                String raw_result = rs.getString(1);
                Spending parsed = null;
                if (test) {
                    parsed = new Spending(((JSONObject)this.parser.parse(raw_result)));
                    
                } else {
                    parsed = new Spending(((JSONObject)this.parser.parse(raw_result)));
                    
                }
                
                result.add(parsed);
                
            }
        } catch (SQLException e) {
            System.err.println("Could not iterate through query.");
    		e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Could not convert the response from getSpending; a parser error occurred.");
    		e.printStackTrace();
        }
        return result;
	}
    
}