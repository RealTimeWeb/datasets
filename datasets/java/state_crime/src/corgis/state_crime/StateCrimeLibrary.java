package corgis.state_crime;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import corgis.state_crime.domain.*;

import java.sql.*;

/**
 * From the Unified Crime Reporting Statistics and under the collaboration of the U.S. Department of Justice and the Federal Bureau of Investigation information crime statistics are available for public review.  The following data set has information on the crime rates and totals for states across the United States for a wide range of years.  The crime reports are divided into two main categories: property and violent crime.  Property crime refers to burglary, larceny, and motor related crime while violent crime refers to assault, murder, rape, and robbery. These reports go from 1960 to 2012.

 */
public class StateCrimeLibrary {
    private String databasePath;
	private Connection connection;
    private JSONParser parser;
    private final int HARDWARE = 1000;
    
    public static void main(String[] args) {
        System.out.println("Testing StateCrime");
        StateCrimeLibrary stateCrimeLibrary = new StateCrimeLibrary();
        
        
        System.out.println("Testing production GetAllCrimes");
        ArrayList<Report> list_of_report_1_production = stateCrimeLibrary.getAllCrimes(false);
        
        
        System.out.println("Testing test GetAllCrimes");
        ArrayList<Report> list_of_report_1_test = stateCrimeLibrary.getAllCrimes(true);
        
        
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
	public StateCrimeLibrary() {
        this.databasePath = "state_crime.db";
        this.connectToDatabase(this.databasePath);
	}
	
    /**
     * Create a connection to the database file, stored explicitly somewhere.
     * @param databasePath The filename of the database file.
     */
	public StateCrimeLibrary(String databasePath) {
        this.databasePath = databasePath;
        this.connectToDatabase(this.databasePath);
	}
    
    
    
    /**
     * Gets a list of all the crime reports in the database.
    
     * @return a list[report]
     */
	public ArrayList<Report> getAllCrimes() {
        return this.getAllCrimes(true);
    }
    
    
    /**
     * Gets a list of all the crime reports in the database.
    
     * @return a list[report]
     */
	public ArrayList<Report> getAllCrimes(boolean test) {
        String query;
        if (test) {
            query = String.format("SELECT data FROM crime LIMIT %d", this.HARDWARE);
        } else {
            query = "SELECT data FROM crime";
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
            System.err.println("Could not convert the response from getAllCrimes; a parser error occurred.");
    		e.printStackTrace();
        }
        return result;
	}
    
}