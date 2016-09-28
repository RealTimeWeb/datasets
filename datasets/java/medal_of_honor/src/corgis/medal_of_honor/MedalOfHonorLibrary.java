package corgis.medal_of_honor;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import corgis.medal_of_honor.domain.*;

import java.sql.*;

/**
 * This dataset has records for the awarding of the United States Medal of Honor. The Medal of Honor is the United States of America's highest military honor, awarded for personal acts of valor above and beyond the call of duty. The medal is awarded by the President of the United States in the name of the U.S. Congress to U.S. military personnel only. There are three versions of the medal, one for the Army, one for the Navy, and one for the Air Force.[5] Personnel of the Marine Corps and Coast Guard receive the Navy version.
The dataset was collected from the official military site, and includes records about how the medal was awarded and characteristics of the recipient. Unfortunately, because of the nature of century-old record keeping, many of the records are incomplete. While a very interesting dataset, it does have some missing data. 

 */
public class MedalOfHonorLibrary {
    private String databasePath;
	private Connection connection;
    private JSONParser parser;
    private final int HARDWARE = 1000;
    
    public static void main(String[] args) {
        System.out.println("Testing MedalOfHonor");
        MedalOfHonorLibrary medalOfHonorLibrary = new MedalOfHonorLibrary();
        
        
        System.out.println("Testing production GetAwardees");
        ArrayList<Awardee> list_of_awardee_1_production = medalOfHonorLibrary.getAwardees(false);
        
        
        System.out.println("Testing test GetAwardees");
        ArrayList<Awardee> list_of_awardee_1_test = medalOfHonorLibrary.getAwardees(true);
        
        
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
	public MedalOfHonorLibrary() {
        this.databasePath = "medal_of_honor.db";
        this.connectToDatabase(this.databasePath);
	}
	
    /**
     * Create a connection to the database file, stored explicitly somewhere.
     * @param databasePath The filename of the database file.
     */
	public MedalOfHonorLibrary(String databasePath) {
        this.databasePath = databasePath;
        this.connectToDatabase(this.databasePath);
	}
    
    
    
    /**
     * Returns a list of the awardees in the database.
    
     * @return a list[awardee]
     */
	public ArrayList<Awardee> getAwardees() {
        return this.getAwardees(true);
    }
    
    
    /**
     * Returns a list of the awardees in the database.
    
     * @return a list[awardee]
     */
	public ArrayList<Awardee> getAwardees(boolean test) {
        String query;
        if (test) {
            query = String.format("SELECT data FROM medal_of_honor LIMIT %d", this.HARDWARE);
        } else {
            query = "SELECT data FROM medal_of_honor";
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
        
        ArrayList<Awardee> result = new ArrayList<Awardee>();
        try {
            while (rs.next()) {
                String raw_result = rs.getString(1);
                Awardee parsed = null;
                if (test) {
                    parsed = new Awardee(((JSONObject)this.parser.parse(raw_result)));
                    
                } else {
                    parsed = new Awardee(((JSONObject)this.parser.parse(raw_result)));
                    
                }
                
                result.add(parsed);
                
            }
        } catch (SQLException e) {
            System.err.println("Could not iterate through query.");
    		e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Could not convert the response from getAwardees; a parser error occurred.");
    		e.printStackTrace();
        }
        return result;
	}
    
}