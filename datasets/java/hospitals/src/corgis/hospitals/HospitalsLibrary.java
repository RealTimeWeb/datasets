package corgis.hospitals;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import corgis.hospitals.domain.*;

import java.sql.*;

/**
 * Medicare has collected data on many different hospitals throughout the country to allow users to compare the quality of these institutions before using their services.  Data includes descriptions of the location of the hospitals, information about the hospitals' emergency services and type of hospital, and outpatient volume for the different wards of the hospitals.

 */
public class HospitalsLibrary {
    private String databasePath;
	private Connection connection;
    private JSONParser parser;
    private final int HARDWARE = 1000;
    
    public static void main(String[] args) {
        System.out.println("Testing Hospitals");
        HospitalsLibrary hospitalsLibrary = new HospitalsLibrary();
        
        
        System.out.println("Testing production GetHospitals");
        ArrayList<Hospital> list_of_hospital_1_production = hospitalsLibrary.getHospitals(false);
        
        
        System.out.println("Testing test GetHospitals");
        ArrayList<Hospital> list_of_hospital_1_test = hospitalsLibrary.getHospitals(true);
        
        
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
	public HospitalsLibrary() {
        this.databasePath = "hospitals.db";
        this.connectToDatabase(this.databasePath);
	}
	
    /**
     * Create a connection to the database file, stored explicitly somewhere.
     * @param databasePath The filename of the database file.
     */
	public HospitalsLibrary(String databasePath) {
        this.databasePath = databasePath;
        this.connectToDatabase(this.databasePath);
	}
    
    
    
    /**
     * Returns hospitals from the dataset.
    
     * @return a list[hospital]
     */
	public ArrayList<Hospital> getHospitals() {
        return this.getHospitals(true);
    }
    
    
    /**
     * Returns hospitals from the dataset.
    
     * @return a list[hospital]
     */
	public ArrayList<Hospital> getHospitals(boolean test) {
        String query;
        if (test) {
            query = String.format("SELECT data FROM hospitals LIMIT %d", this.HARDWARE);
        } else {
            query = "SELECT data FROM hospitals";
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
        
        ArrayList<Hospital> result = new ArrayList<Hospital>();
        try {
            while (rs.next()) {
                String raw_result = rs.getString(1);
                Hospital parsed = null;
                if (test) {
                    parsed = new Hospital(((JSONObject)this.parser.parse(raw_result)));
                    
                } else {
                    parsed = new Hospital(((JSONObject)this.parser.parse(raw_result)));
                    
                }
                
                result.add(parsed);
                
            }
        } catch (SQLException e) {
            System.err.println("Could not iterate through query.");
    		e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Could not convert the response from getHospitals; a parser error occurred.");
    		e.printStackTrace();
        }
        return result;
	}
    
}