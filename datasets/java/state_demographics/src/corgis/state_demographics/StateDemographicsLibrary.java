package corgis.state_demographics;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import corgis.state_demographics.domain.*;

import java.sql.*;

/**
 * The following data set is summarized information obtained about states in the United States from 2007 through 2014 through the United States Census Bureau. However, this data is not available for these years; just the summarized data as of 2015. Information described in the data includes the age distributions, the education levels, employment statistics, ethnicity percents, houseold information, income, and other miscellneous statistics.

 */
public class StateDemographicsLibrary {
    private String databasePath;
	private Connection connection;
    private JSONParser parser;
    private final int HARDWARE = 1000;
    
    public static void main(String[] args) {
        System.out.println("Testing StateDemographics");
        StateDemographicsLibrary stateDemographicsLibrary = new StateDemographicsLibrary();
        
        
        System.out.println("Testing production GetAllStates");
        ArrayList<Report> list_of_report_1_production = stateDemographicsLibrary.getAllStates(false);
        
        
        System.out.println("Testing test GetAllStates");
        ArrayList<Report> list_of_report_1_test = stateDemographicsLibrary.getAllStates(true);
        
        
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
	public StateDemographicsLibrary() {
        this.databasePath = "state_demographics.db";
        this.connectToDatabase(this.databasePath);
	}
	
    /**
     * Create a connection to the database file, stored explicitly somewhere.
     * @param databasePath The filename of the database file.
     */
	public StateDemographicsLibrary(String databasePath) {
        this.databasePath = databasePath;
        this.connectToDatabase(this.databasePath);
	}
    
    
    
    /**
     * Returns the report for each state from the dataset.
    
     * @return a list[report]
     */
	public ArrayList<Report> getAllStates() {
        return this.getAllStates(true);
    }
    
    
    /**
     * Returns the report for each state from the dataset.
    
     * @return a list[report]
     */
	public ArrayList<Report> getAllStates(boolean test) {
        String query;
        if (test) {
            query = String.format("SELECT data FROM demographics LIMIT %d", this.HARDWARE);
        } else {
            query = "SELECT data FROM demographics";
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
        
        ArrayList<Report> result = new ArrayList<Report>();
        try {
            while (rs.next()) {
                String raw_result = rs.getString(1);
                Report parsed = null;
                if (test) {
                    parsed = new Report(((JSONObject)this.parser.parse(raw_result)));
                    
                } else {
                    parsed = new Report(((JSONObject)this.parser.parse(raw_result)));
                    
                }
                
                result.add(parsed);
                
            }
        } catch (SQLException e) {
            System.err.println("Could not iterate through query.");
    		e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Could not convert the response from getAllStates; a parser error occurred.");
    		e.printStackTrace();
        }
        return result;
	}
    
}