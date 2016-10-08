package corgis.construction_permits;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import corgis.construction_permits.domain.*;

import java.sql.*;

/**
 * This dataset provides data on the number and valuation of new housing units authorized by building permits. Data are available monthly at the national, regional, divisional, and state level. The data are from the Building Permits Survey. The United States Code, Title 13, authorizes this survey, provides for voluntary responses, and provides an exception to confidentiality for public records.

 */
public class ConstructionPermitsLibrary {
    private String databasePath;
	private Connection connection;
    private JSONParser parser;
    private final int HARDWARE = 1000;
    
    public static void main(String[] args) {
        System.out.println("Testing ConstructionPermits");
        ConstructionPermitsLibrary constructionPermitsLibrary = new ConstructionPermitsLibrary();
        
        
        System.out.println("Testing production GetRecords");
        ArrayList<Permit> list_of_permit_1_production = constructionPermitsLibrary.getRecords(false);
        
        
        System.out.println("Testing test GetRecords");
        ArrayList<Permit> list_of_permit_1_test = constructionPermitsLibrary.getRecords(true);
        
        
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
	public ConstructionPermitsLibrary() {
        this.databasePath = "construction_permits.db";
        this.connectToDatabase(this.databasePath);
	}
	
    /**
     * Create a connection to the database file, stored explicitly somewhere.
     * @param databasePath The filename of the database file.
     */
	public ConstructionPermitsLibrary(String databasePath) {
        this.databasePath = databasePath;
        this.connectToDatabase(this.databasePath);
	}
    
    
    
    /**
     * Returns permit data from every year.
    
     * @return a list[permit]
     */
	public ArrayList<Permit> getRecords() {
        return this.getRecords(true);
    }
    
    
    /**
     * Returns permit data from every year.
    
     * @return a list[permit]
     */
	public ArrayList<Permit> getRecords(boolean test) {
        String query;
        if (test) {
            query = String.format("SELECT data FROM construction_permits LIMIT %d", this.HARDWARE);
        } else {
            query = "SELECT data FROM construction_permits";
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
        
        ArrayList<Permit> result = new ArrayList<Permit>();
        try {
            while (rs.next()) {
                String raw_result = rs.getString(1);
                Permit parsed = null;
                if (test) {
                    parsed = new Permit(((JSONObject)this.parser.parse(raw_result)));
                    
                } else {
                    parsed = new Permit(((JSONObject)this.parser.parse(raw_result)));
                    
                }
                
                result.add(parsed);
                
            }
        } catch (SQLException e) {
            System.err.println("Could not iterate through query.");
    		e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Could not convert the response from getRecords; a parser error occurred.");
    		e.printStackTrace();
        }
        return result;
	}
    
}