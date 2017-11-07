package corgis.aids;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import corgis.aids.domain.*;

import java.sql.*;

/**
 * The UNAIDS Organization is an entity of the United Nations that looks to reduce the transmission of AIDS and provide resources to those currently affected by the disease.  The following data set contains information on the number of those affected by the disease, new cases of the disease being reported, and AIDS-related deaths for a large set of countries over the course of 1990 - 2015.

 */
public class AidsLibrary {
    private String databasePath;
	private Connection connection;
    private JSONParser parser;
    private final int HARDWARE = 1000;
    
    public static void main(String[] args) {
        System.out.println("Testing Aids");
        AidsLibrary aidsLibrary = new AidsLibrary();
        
        
        System.out.println("Testing production GetReports");
        ArrayList<Report> list_of_report_1_production = aidsLibrary.getReports(false);
        
        
        System.out.println("Testing test GetReports");
        ArrayList<Report> list_of_report_1_test = aidsLibrary.getReports(true);
        
        
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
	public AidsLibrary() {
        this.databasePath = "aids.db";
        this.connectToDatabase(this.databasePath);
	}
	
    /**
     * Create a connection to the database file, stored explicitly somewhere.
     * @param databasePath The filename of the database file.
     */
	public AidsLibrary(String databasePath) {
        this.databasePath = databasePath;
        this.connectToDatabase(this.databasePath);
	}
    
    
    
    /**
     * Returns aids reports from the dataset.
    
     * @return a list[report]
     */
	public ArrayList<Report> getReports() {
        return this.getReports(true);
    }
    
    
    /**
     * Returns aids reports from the dataset.
    
     * @return a list[report]
     */
	public ArrayList<Report> getReports(boolean test) {
        String query;
        if (test) {
            query = String.format("SELECT data FROM aids LIMIT %d", this.HARDWARE);
        } else {
            query = "SELECT data FROM aids";
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