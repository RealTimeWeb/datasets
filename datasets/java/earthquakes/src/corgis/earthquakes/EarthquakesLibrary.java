package corgis.earthquakes;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import corgis.earthquakes.domain.*;

import java.sql.*;

/**
 * Earthquake records from around the world collected from the United States Geological Survey.  Important details about the earthquake such as distance, gap, magnitude, depth and significance are included to properly describe the earthquake.  Additionally, data about exact geological coordinates and a relative description of the earthquake's location is included. The earthquakes collected are from the past month.

 */
public class EarthquakesLibrary {
    private String databasePath;
	private Connection connection;
    private JSONParser parser;
    private final int HARDWARE = 1000;
    
    public static void main(String[] args) {
        System.out.println("Testing Earthquakes");
        EarthquakesLibrary earthquakesLibrary = new EarthquakesLibrary();
        
        
        System.out.println("Testing production GetEarthquakes");
        ArrayList<Earthquake> list_of_earthquake_1_production = earthquakesLibrary.getEarthquakes();
        
        
        
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
	public EarthquakesLibrary() {
        this.databasePath = "earthquakes.db";
        this.connectToDatabase(this.databasePath);
	}
	
    /**
     * Create a connection to the database file, stored explicitly somewhere.
     * @param databasePath The filename of the database file.
     */
	public EarthquakesLibrary(String databasePath) {
        this.databasePath = databasePath;
        this.connectToDatabase(this.databasePath);
	}
    
    
    
    
    /**
     * Returns earthquakes from the dataset.
    
     * @return a list[earthquake]
     */
	public ArrayList<Earthquake> getEarthquakes() {
        String query;
        boolean test = false;
        if (test) {
            query = String.format("", this.HARDWARE);
        } else {
            query = "SELECT data FROM earthquakes";
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
        
        ArrayList<Earthquake> result = new ArrayList<Earthquake>();
        try {
            while (rs.next()) {
                String raw_result = rs.getString(1);
                Earthquake parsed = null;
                if (test) {
                    
                } else {
                    parsed = new Earthquake(((JSONObject)this.parser.parse(raw_result)));
                    
                }
                
                result.add(parsed);
                
            }
        } catch (SQLException e) {
            System.err.println("Could not iterate through query.");
    		e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Could not convert the response from getEarthquakes; a parser error occurred.");
    		e.printStackTrace();
        }
        return result;
	}
    
}