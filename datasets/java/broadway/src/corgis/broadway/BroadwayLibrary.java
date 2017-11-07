package corgis.broadway;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import corgis.broadway.domain.*;

import java.sql.*;

/**
 * This library holds data about over Broadway shows, grouped over weeklong periods. Only shows that reported capacity were included, so the dataset stretches back to the 1990s. The dataset is made available by the Broadway League (the national trade association for the Broadway industry), and you can view the data online at http://www.broadwayleague.com/. This dataset 

 */
public class BroadwayLibrary {
    private String databasePath;
	private Connection connection;
    private JSONParser parser;
    private final int HARDWARE = 1000;
    
    public static void main(String[] args) {
        System.out.println("Testing Broadway");
        BroadwayLibrary broadwayLibrary = new BroadwayLibrary();
        
        
        System.out.println("Testing production GetShows");
        ArrayList<Production> list_of_production_1_production = broadwayLibrary.getShows(false);
        
        
        System.out.println("Testing test GetShows");
        ArrayList<Production> list_of_production_1_test = broadwayLibrary.getShows(true);
        
        
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
	public BroadwayLibrary() {
        this.databasePath = "broadway.db";
        this.connectToDatabase(this.databasePath);
	}
	
    /**
     * Create a connection to the database file, stored explicitly somewhere.
     * @param databasePath The filename of the database file.
     */
	public BroadwayLibrary(String databasePath) {
        this.databasePath = databasePath;
        this.connectToDatabase(this.databasePath);
	}
    
    
    
    /**
     * Returns information about all the shows
    
     * @return a list[production]
     */
	public ArrayList<Production> getShows() {
        return this.getShows(true);
    }
    
    
    /**
     * Returns information about all the shows
    
     * @return a list[production]
     */
	public ArrayList<Production> getShows(boolean test) {
        String query;
        if (test) {
            query = String.format("SELECT data FROM broadway LIMIT %d", this.HARDWARE);
        } else {
            query = "SELECT data FROM broadway";
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
        
        ArrayList<Production> result = new ArrayList<Production>();
        try {
            while (rs.next()) {
                String raw_result = rs.getString(1);
                Production parsed = null;
                if (test) {
                    parsed = new Production(((JSONObject)this.parser.parse(raw_result)));
                    
                } else {
                    parsed = new Production(((JSONObject)this.parser.parse(raw_result)));
                    
                }
                
                result.add(parsed);
                
            }
        } catch (SQLException e) {
            System.err.println("Could not iterate through query.");
    		e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Could not convert the response from getShows; a parser error occurred.");
    		e.printStackTrace();
        }
        return result;
	}
    
}