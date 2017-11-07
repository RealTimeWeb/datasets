package corgis.cancer;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import corgis.cancer.domain.*;

import java.sql.*;

/**
 * From the United States Cancer Statistics as part of the U.S. Center for Disease Control, the following data set focuses on the crude rate for all types of cancer reported for different demograpic groups.  Significant groupings include age, gender, race and geographical area.

 */
public class CancerLibrary {
    private String databasePath;
	private Connection connection;
    private JSONParser parser;
    private final int HARDWARE = 1000;
    
    public static void main(String[] args) {
        System.out.println("Testing Cancer");
        CancerLibrary cancerLibrary = new CancerLibrary();
        
        
        System.out.println("Testing production GetReports");
        ArrayList<Report> list_of_report_1_production = cancerLibrary.getReports(false);
        
        
        System.out.println("Testing test GetReports");
        ArrayList<Report> list_of_report_1_test = cancerLibrary.getReports(true);
        
        
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
	public CancerLibrary() {
        this.databasePath = "cancer.db";
        this.connectToDatabase(this.databasePath);
	}
	
    /**
     * Create a connection to the database file, stored explicitly somewhere.
     * @param databasePath The filename of the database file.
     */
	public CancerLibrary(String databasePath) {
        this.databasePath = databasePath;
        this.connectToDatabase(this.databasePath);
	}
    
    
    
    /**
     * Returns cancer reports from the dataset.
    
     * @return a list[report]
     */
	public ArrayList<Report> getReports() {
        return this.getReports(true);
    }
    
    
    /**
     * Returns cancer reports from the dataset.
    
     * @return a list[report]
     */
	public ArrayList<Report> getReports(boolean test) {
        String query;
        if (test) {
            query = String.format("SELECT data FROM cancer LIMIT %d", this.HARDWARE);
        } else {
            query = "SELECT data FROM cancer";
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
            System.err.println("Could not convert the response from getReports; a parser error occurred.");
    		e.printStackTrace();
        }
        return result;
	}
    
}