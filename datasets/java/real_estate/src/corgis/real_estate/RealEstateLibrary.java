package corgis.real_estate;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import corgis.real_estate.domain.*;

import java.sql.*;

/**
 * Real Estate Across the United States (REXUS) is the primary tool used by PBS to track and manage the government's real property assets and to store inventory data, building data, customer data, and lease information. STAR manages aspects of real property space management, including identification of all building space and daily management of 22,000 assignments for all property to its client Federal agencies. This data set contains PBS building inventory that consists of both owned and leased buildings with active and excess status.

 */
public class RealEstateLibrary {
    private String databasePath;
	private Connection connection;
    private JSONParser parser;
    private final int HARDWARE = 1000;
    
    public static void main(String[] args) {
        System.out.println("Testing RealEstate");
        RealEstateLibrary realEstateLibrary = new RealEstateLibrary();
        
        
        System.out.println("Testing production GetBuildings");
        ArrayList<Building> list_of_building_1_production = realEstateLibrary.getBuildings(false);
        
        
        System.out.println("Testing test GetBuildings");
        ArrayList<Building> list_of_building_1_test = realEstateLibrary.getBuildings(true);
        
        
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
	public RealEstateLibrary() {
        this.databasePath = "real_estate.db";
        this.connectToDatabase(this.databasePath);
	}
	
    /**
     * Create a connection to the database file, stored explicitly somewhere.
     * @param databasePath The filename of the database file.
     */
	public RealEstateLibrary(String databasePath) {
        this.databasePath = databasePath;
        this.connectToDatabase(this.databasePath);
	}
    
    
    
    /**
     * Returns a list of the buildings in the database.
    
     * @return a list[building]
     */
	public ArrayList<Building> getBuildings() {
        return this.getBuildings(true);
    }
    
    
    /**
     * Returns a list of the buildings in the database.
    
     * @return a list[building]
     */
	public ArrayList<Building> getBuildings(boolean test) {
        String query;
        if (test) {
            query = String.format("SELECT data FROM real_estate LIMIT %d", this.HARDWARE);
        } else {
            query = "SELECT data FROM real_estate";
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
        
        ArrayList<Building> result = new ArrayList<Building>();
        try {
            while (rs.next()) {
                String raw_result = rs.getString(1);
                Building parsed = null;
                if (test) {
                    parsed = new Building(((JSONObject)this.parser.parse(raw_result)));
                    
                } else {
                    parsed = new Building(((JSONObject)this.parser.parse(raw_result)));
                    
                }
                
                result.add(parsed);
                
            }
        } catch (SQLException e) {
            System.err.println("Could not iterate through query.");
    		e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Could not convert the response from getBuildings; a parser error occurred.");
    		e.printStackTrace();
        }
        return result;
	}
    
}