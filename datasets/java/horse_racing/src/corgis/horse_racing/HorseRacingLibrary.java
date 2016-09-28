package corgis.horse_racing;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import corgis.horse_racing.domain.*;

import java.sql.*;

/**
 * Data about horse races at Churchill Downs.

 */
public class HorseRacingLibrary {
    private String databasePath;
	private Connection connection;
    private JSONParser parser;
    private final int HARDWARE = 1000;
    
    public static void main(String[] args) {
        System.out.println("Testing HorseRacing");
        HorseRacingLibrary horseRacingLibrary = new HorseRacingLibrary();
        
        
        System.out.println("Testing production GetRaces");
        ArrayList<Race> list_of_race_1_production = horseRacingLibrary.getRaces();
        
        
        
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
	public HorseRacingLibrary() {
        this.databasePath = "horse_racing.db";
        this.connectToDatabase(this.databasePath);
	}
	
    /**
     * Create a connection to the database file, stored explicitly somewhere.
     * @param databasePath The filename of the database file.
     */
	public HorseRacingLibrary(String databasePath) {
        this.databasePath = databasePath;
        this.connectToDatabase(this.databasePath);
	}
    
    
    
    
    /**
     * Returns information about all the races
    
     * @return a list[race]
     */
	public ArrayList<Race> getRaces() {
        String query;
        boolean test = false;
        if (test) {
            query = String.format("", this.HARDWARE);
        } else {
            query = "SELECT data FROM races";
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
        
        ArrayList<Race> result = new ArrayList<Race>();
        try {
            while (rs.next()) {
                String raw_result = rs.getString(1);
                Race parsed = null;
                if (test) {
                    
                } else {
                    parsed = new Race(((JSONObject)this.parser.parse(raw_result)));
                    
                }
                
                result.add(parsed);
                
            }
        } catch (SQLException e) {
            System.err.println("Could not iterate through query.");
    		e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Could not convert the response from getRaces; a parser error occurred.");
    		e.printStackTrace();
        }
        return result;
	}
    
}