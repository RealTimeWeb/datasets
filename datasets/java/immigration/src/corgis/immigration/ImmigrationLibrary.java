package corgis.immigration;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import corgis.immigration.domain.*;

import java.sql.*;

/**
 * The Yearbook of Immigration Statistics is a compendium of tables that provides data on foreign nationals who, during a fiscal year, were granted lawful permanent residence (i.e., admitted as immigrants or became legal permanent residents), were admitted into the United States on a temporary basis (e.g., tourists, students, or workers), applied for asylum or refugee status, or were naturalized. The Yearbook also presents data on immigration enforcement actions, including alien apprehensions, removals, and returns. This data ranges from 2005-2014 and covers immigration from many countries.

 */
public class ImmigrationLibrary {
    private String databasePath;
	private Connection connection;
    private JSONParser parser;
    private final int HARDWARE = 1000;
    
    public static void main(String[] args) {
        System.out.println("Testing Immigration");
        ImmigrationLibrary immigrationLibrary = new ImmigrationLibrary();
        
        
        System.out.println("Testing production GetRecords");
        ArrayList<Record> list_of_record_1_production = immigrationLibrary.getRecords();
        
        
        
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
	public ImmigrationLibrary() {
        this.databasePath = "immigration.db";
        this.connectToDatabase(this.databasePath);
	}
	
    /**
     * Create a connection to the database file, stored explicitly somewhere.
     * @param databasePath The filename of the database file.
     */
	public ImmigrationLibrary(String databasePath) {
        this.databasePath = databasePath;
        this.connectToDatabase(this.databasePath);
	}
    
    
    
    
    /**
     * Returns data about immigration from all the years and countries.
    
     * @return a list[record]
     */
	public ArrayList<Record> getRecords() {
        String query;
        boolean test = false;
        if (test) {
            query = String.format("", this.HARDWARE);
        } else {
            query = "SELECT data FROM immigration";
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