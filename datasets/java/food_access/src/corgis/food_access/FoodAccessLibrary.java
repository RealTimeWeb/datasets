package corgis.food_access;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import corgis.food_access.domain.*;

import java.sql.*;

/**
 * From the United States Department of Agriculture's Economic Research Service, the dataset contains information about US county's ability to access supermarkets, supercenters, grocery stores, or other sources of healthy and affordable food.  Most measures of how individuals and neighborhoods are able to access food are based on the following indicators: 
    - Accessibility to sources of healthy food, as measured by distance to a store or by the number of stores in an area.
    - Individual-level resources that may affect accessibility, such as family income or vehicle availability.
    - Neighborhood-level indicators of resources, such as the average income of the neighborhood and the availability of public transportation.  

 */
public class FoodAccessLibrary {
    private String databasePath;
	private Connection connection;
    private JSONParser parser;
    private final int HARDWARE = 1000;
    
    public static void main(String[] args) {
        System.out.println("Testing FoodAccess");
        FoodAccessLibrary foodAccessLibrary = new FoodAccessLibrary();
        
        
        System.out.println("Testing production GetRecords");
        ArrayList<Record> list_of_record_1_production = foodAccessLibrary.getRecords(false);
        
        
        System.out.println("Testing test GetRecords");
        ArrayList<Record> list_of_record_1_test = foodAccessLibrary.getRecords(true);
        
        
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
	public FoodAccessLibrary() {
        this.databasePath = "food_access.db";
        this.connectToDatabase(this.databasePath);
	}
	
    /**
     * Create a connection to the database file, stored explicitly somewhere.
     * @param databasePath The filename of the database file.
     */
	public FoodAccessLibrary(String databasePath) {
        this.databasePath = databasePath;
        this.connectToDatabase(this.databasePath);
	}
    
    
    
    /**
     * Returns food access records from the dataset.
    
     * @return a list[record]
     */
	public ArrayList<Record> getRecords() {
        return this.getRecords(true);
    }
    
    
    /**
     * Returns food access records from the dataset.
    
     * @return a list[record]
     */
	public ArrayList<Record> getRecords(boolean test) {
        String query;
        if (test) {
            query = String.format("SELECT data FROM food_access LIMIT %d", this.HARDWARE);
        } else {
            query = "SELECT data FROM food_access";
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
        
        ArrayList<Record> result = new ArrayList<Record>();
        try {
            while (rs.next()) {
                String raw_result = rs.getString(1);
                Record parsed = null;
                if (test) {
                    parsed = new Record(((JSONObject)this.parser.parse(raw_result)));
                    
                } else {
                    parsed = new Record(((JSONObject)this.parser.parse(raw_result)));
                    
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