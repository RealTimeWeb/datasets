package corgis.health;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import corgis.health.domain.*;

import java.sql.*;

/**
 * This library holds data about reports of diseases in America.

 */
public class HealthLibrary {
    private String databasePath;
	private Connection connection;
    private JSONParser parser;
    private final int HARDWARE = 1000;
    
    public static void main(String[] args) {
        System.out.println("Testing Health");
        HealthLibrary healthLibrary = new HealthLibrary();
        
        
        System.out.println("Testing production GetAllReports");
        ArrayList<Report> list_of_report_1_production = healthLibrary.getAllReports(false);
        
        
        System.out.println("Testing test GetAllReports");
        ArrayList<Report> list_of_report_1_test = healthLibrary.getAllReports(true);
        
        
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
	public HealthLibrary() {
        this.databasePath = "health.db";
        this.connectToDatabase(this.databasePath);
	}
	
    /**
     * Create a connection to the database file, stored explicitly somewhere.
     * @param databasePath The filename of the database file.
     */
	public HealthLibrary(String databasePath) {
        this.databasePath = databasePath;
        this.connectToDatabase(this.databasePath);
	}
    
    
    
    /**
     * Returns information about the status of disease for all locations, diseases, and years.
    
     * @return a list[report]
     */
	public ArrayList<Report> getAllReports() {
        return this.getAllReports(true);
    }
    
    
    /**
     * Returns information about the status of disease for all locations, diseases, and years.
    
     * @return a list[report]
     */
	public ArrayList<Report> getAllReports(boolean test) {
        String query;
        if (test) {
            query = String.format("SELECT data FROM health ORDER BY year, location, disease ASC LIMIT %d", this.HARDWARE);
        } else {
            query = "SELECT data FROM health ORDER BY year, location, disease ASC";
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
            System.err.println("Could not convert the response from getAllReports; a parser error occurred.");
    		e.printStackTrace();
        }
        return result;
	}
    
}