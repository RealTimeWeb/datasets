package corgis.election;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import corgis.election.domain.*;

import java.sql.*;

/**
 * Data about the results was collected from CNN's 2016 election center.  Each county has the breakdown of how many votes each candidate recieved in that county and what percentage of the total vote from that county that the candidate recieved.  The candidate's political party is also represented.  

 */
public class ElectionLibrary {
    private String databasePath;
	private Connection connection;
    private JSONParser parser;
    private final int HARDWARE = 1000;
    
    public static void main(String[] args) {
        System.out.println("Testing Election");
        ElectionLibrary electionLibrary = new ElectionLibrary();
        
        
        System.out.println("Testing production GetResults");
        ArrayList<Result> list_of_result_1_production = electionLibrary.getResults(false);
        
        
        System.out.println("Testing test GetResults");
        ArrayList<Result> list_of_result_1_test = electionLibrary.getResults(true);
        
        
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
	public ElectionLibrary() {
        this.databasePath = "election.db";
        this.connectToDatabase(this.databasePath);
	}
	
    /**
     * Create a connection to the database file, stored explicitly somewhere.
     * @param databasePath The filename of the database file.
     */
	public ElectionLibrary(String databasePath) {
        this.databasePath = databasePath;
        this.connectToDatabase(this.databasePath);
	}
    
    
    
    /**
     * Returns the result of each primary for every county from the dataset.
    
     * @return a list[result]
     */
	public ArrayList<Result> getResults() {
        return this.getResults(true);
    }
    
    
    /**
     * Returns the result of each primary for every county from the dataset.
    
     * @return a list[result]
     */
	public ArrayList<Result> getResults(boolean test) {
        String query;
        if (test) {
            query = String.format("SELECT data FROM election LIMIT %d", this.HARDWARE);
        } else {
            query = "SELECT data FROM election";
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
        
        ArrayList<Result> result = new ArrayList<Result>();
        try {
            while (rs.next()) {
                String raw_result = rs.getString(1);
                Result parsed = null;
                if (test) {
                    parsed = new Result(((JSONObject)this.parser.parse(raw_result)));
                    
                } else {
                    parsed = new Result(((JSONObject)this.parser.parse(raw_result)));
                    
                }
                
                result.add(parsed);
                
            }
        } catch (SQLException e) {
            System.err.println("Could not iterate through query.");
    		e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Could not convert the response from getResults; a parser error occurred.");
    		e.printStackTrace();
        }
        return result;
	}
    
}