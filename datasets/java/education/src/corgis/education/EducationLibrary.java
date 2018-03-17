package corgis.education;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import corgis.education.domain.*;

import java.sql.*;

/**
 * This dataset comes from the National Center for Educational Statistics' Common Core of Data. Data is available for every state and the District of Columbia from the 2009-2010 school year. The data is roughly categorized into four categories: funding, how much money is given to the school; score, how students perform academically; attendance, the rate at which students and teachers attend; enrollment, the size of the schools. Funding is given in dollars. The 'Year' field has records for Preschool, Kindergarten, and grades 1-12.

 */
public class EducationLibrary {
    private String databasePath;
	private Connection connection;
    private JSONParser parser;
    private final int HARDWARE = 1000;
    
    public static void main(String[] args) {
        System.out.println("Testing Education");
        EducationLibrary educationLibrary = new EducationLibrary();
        
        
        System.out.println("Testing production GetAllStates");
        ArrayList<StateRecord> list_of_state_record_1_production = educationLibrary.getAllStates();
        
        
        
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
	public EducationLibrary() {
        this.databasePath = "education.db";
        this.connectToDatabase(this.databasePath);
	}
	
    /**
     * Create a connection to the database file, stored explicitly somewhere.
     * @param databasePath The filename of the database file.
     */
	public EducationLibrary(String databasePath) {
        this.databasePath = databasePath;
        this.connectToDatabase(this.databasePath);
	}
    
    
    
    
    /**
     * Returns all of the data for every state into a list.
    
     * @return a list[state record]
     */
	public ArrayList<StateRecord> getAllStates() {
        String query;
        boolean test = false;
        if (test) {
            query = String.format("", this.HARDWARE);
        } else {
            query = "SELECT data FROM school";
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
        
        ArrayList<StateRecord> result = new ArrayList<StateRecord>();
        try {
            while (rs.next()) {
                String raw_result = rs.getString(1);
                StateRecord parsed = null;
                if (test) {
                    
                } else {
                    parsed = new StateRecord(((JSONObject)this.parser.parse(raw_result)));
                    
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