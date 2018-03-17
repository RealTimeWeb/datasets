package corgis.business_dynamics;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import corgis.business_dynamics.domain.*;

import java.sql.*;

/**
 * <p>The Business Dynamics Statistics (BDS) includes measures of establishment openings and closings, firm startups, job creation and destruction by firm size, age, and industrial sector, and several other statistics on business dynamics. The U.S. economy is comprised of over 6 million establishments with paid employees. The population of these businesses is constantly churning -- some businesses grow, others decline and yet others close. New businesses are constantly replenishing this pool. The BDS series provide annual statistics on gross job gains and losses for the entire economy and by industrial sector, state, and MSA. These data track changes in employment at the establishment level, and thus provide a picture of the dynamics underlying aggregate net employment growth.</p>
<p>There is a longstanding interest in the contribution of small businesses to job and productivity growth in the U.S. Some recent research suggests that it is business age rather than size that is the critical factor. The BDS permits exploring the respective contributions of both firm age and size.</p>
<p>BDS is based on data going back through 1976. This allows business dynamics to be tracked, measured and analyzed for young firms in their first critical years as well as for more mature firms including those that are in the process of reinventing themselves in an ever changing economic environment.</p>
<p>If you need help understanding the terms used, check out <a href='https://www.census.gov/ces/dataproducts/bds/definitions.html' target=_blank>these definitions.</a></p>

 */
public class BusinessDynamicsLibrary {
    private String databasePath;
	private Connection connection;
    private JSONParser parser;
    private final int HARDWARE = 1000;
    
    public static void main(String[] args) {
        System.out.println("Testing BusinessDynamics");
        BusinessDynamicsLibrary businessDynamicsLibrary = new BusinessDynamicsLibrary();
        
        
        System.out.println("Testing production GetBusinesses");
        ArrayList<Record> list_of_record_1_production = businessDynamicsLibrary.getBusinesses(false);
        
        
        System.out.println("Testing test GetBusinesses");
        ArrayList<Record> list_of_record_1_test = businessDynamicsLibrary.getBusinesses(true);
        
        
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
	public BusinessDynamicsLibrary() {
        this.databasePath = "business_dynamics.db";
        this.connectToDatabase(this.databasePath);
	}
	
    /**
     * Create a connection to the database file, stored explicitly somewhere.
     * @param databasePath The filename of the database file.
     */
	public BusinessDynamicsLibrary(String databasePath) {
        this.databasePath = databasePath;
        this.connectToDatabase(this.databasePath);
	}
    
    
    
    /**
     * Returns financial data about all the states.
    
     * @return a list[record]
     */
	public ArrayList<Record> getBusinesses() {
        return this.getBusinesses(true);
    }
    
    
    /**
     * Returns financial data about all the states.
    
     * @return a list[record]
     */
	public ArrayList<Record> getBusinesses(boolean test) {
        String query;
        if (test) {
            query = String.format("SELECT data FROM business_dynamics LIMIT %d", this.HARDWARE);
        } else {
            query = "SELECT data FROM business_dynamics";
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
        
        ArrayList<Record> result = new ArrayList<Record>();
        try {
            while (rs.next()) {
                String raw_result = rs.getString(1);
                Record parsed = null;
                if (test) {
                    parsed = new Record(((JSONObject)this.parser.parse(raw_result)));
                    
                } else {
                    parsed = new Record(((JSONObject)this.parser.parse(raw_result)));
                    
                }
                
                result.add(parsed);
                
            }
        } catch (SQLException e) {
            System.err.println("Could not iterate through query.");
    		e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Could not convert the response from getBusinesses; a parser error occurred.");
    		e.printStackTrace();
        }
        return result;
	}
    
}