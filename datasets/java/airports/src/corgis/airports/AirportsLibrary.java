package corgis.airports;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import corgis.airports.domain.*;

import java.sql.*;

/**
 * {'overview': 'This dataset is all about airports.\nAdditional information, explaining the names of some of the fields, is available: <a href="http://www.faa.gov/airports/airport_safety/airportdata_5010/#datadictionaries">http://www.faa.gov/airports/airport_safety/airportdata_5010/#datadictionaries</a>\n', 'short': 'All about airports across the world, including features like runway length and geocoordinates.'}
 */
public class AirportsLibrary {
    private String databasePath;
	private Connection connection;
    private JSONParser parser;
    private final int HARDWARE = 100;
    
    public static void main(String[] args) {
        System.out.println("Testing Airports");
        AirportsLibrary airportsLibrary = new AirportsLibrary();
        
        
        System.out.println("Testing production GetAirports");
        ArrayList<Airport> list_of_airport_1_production = airportsLibrary.getAirports(false);
        
        
        System.out.println("Testing test GetAirports");
        ArrayList<Airport> list_of_airport_1_test = airportsLibrary.getAirports(true);
        
        
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
	public AirportsLibrary() {
        this.databasePath = "airports.db";
        this.connectToDatabase(this.databasePath);
	}
	
    /**
     * Create a connection to the database file, stored explicitly somewhere.
     * @param databasePath The filename of the database file.
     */
	public AirportsLibrary(String databasePath) {
        this.databasePath = databasePath;
        this.connectToDatabase(this.databasePath);
	}
    
    
    
    /**
     * Returns a list of airports around the world.
    
     * @return a list[airport]
     */
	public ArrayList<Airport> getAirports() {
        return this.getAirports(true);
    }
    
    
    /**
     * Returns a list of airports around the world.
    
     * @return a list[airport]
     */
	public ArrayList<Airport> getAirports(boolean test) {
        String query;
        if (test) {
            query = String.format("SELECT data FROM airports LIMIT %d", this.HARDWARE);
        } else {
            query = "SELECT data FROM airports";
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
        
        ArrayList<Airport> result = new ArrayList<Airport>();
        try {
            while (rs.next()) {
                String raw_result = rs.getString(1);
                Airport parsed = null;
                if (test) {
                    parsed = new Airports((JSONObject)this.parser.parse(raw_result));
                    
                } else {
                    parsed = new Airports((JSONObject)this.parser.parse(raw_result));
                    
                }
                
                result.add(parsed);
                
            }
        } catch (SQLException e) {
            System.err.println("Could not iterate through query.");
    		e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Could not convert the response from getAirports; a parser error occurred.");
    		e.printStackTrace();
        }
        return result;
	}
    
}