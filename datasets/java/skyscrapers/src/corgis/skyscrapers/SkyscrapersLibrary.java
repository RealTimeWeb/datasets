package corgis.skyscrapers;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import corgis.skyscrapers.domain.*;

import java.sql.*;

/**
 * Collected statistics about the tallest buildings all over the world, including the materials used to develop them, the purpose of the buildings, and more.

 */
public class SkyscrapersLibrary {
    private String databasePath;
	private Connection connection;
    private JSONParser parser;
    private final int HARDWARE = 1000;
    
    public static void main(String[] args) {
        System.out.println("Testing Skyscrapers");
        SkyscrapersLibrary skyscrapersLibrary = new SkyscrapersLibrary();
        
        
        System.out.println("Testing production GetSkyscrapers");
        ArrayList<Skyscraper> list_of_skyscraper_1_production = skyscrapersLibrary.getSkyscrapers(false);
        
        
        System.out.println("Testing test GetSkyscrapers");
        ArrayList<Skyscraper> list_of_skyscraper_1_test = skyscrapersLibrary.getSkyscrapers(true);
        
        
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
	public SkyscrapersLibrary() {
        this.databasePath = "skyscrapers.db";
        this.connectToDatabase(this.databasePath);
	}
	
    /**
     * Create a connection to the database file, stored explicitly somewhere.
     * @param databasePath The filename of the database file.
     */
	public SkyscrapersLibrary(String databasePath) {
        this.databasePath = databasePath;
        this.connectToDatabase(this.databasePath);
	}
    
    
    
    /**
     * Returns a list of the skyscrapers in the database.
    
     * @return a list[skyscraper]
     */
	public ArrayList<Skyscraper> getSkyscrapers() {
        return this.getSkyscrapers(true);
    }
    
    
    /**
     * Returns a list of the skyscrapers in the database.
    
     * @return a list[skyscraper]
     */
	public ArrayList<Skyscraper> getSkyscrapers(boolean test) {
        String query;
        if (test) {
            query = String.format("SELECT data FROM skyscrapers LIMIT %d", this.HARDWARE);
        } else {
            query = "SELECT data FROM skyscrapers";
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
        
        ArrayList<Skyscraper> result = new ArrayList<Skyscraper>();
        try {
            while (rs.next()) {
                String raw_result = rs.getString(1);
                Skyscraper parsed = null;
                if (test) {
                    parsed = new Skyscraper(((JSONObject)this.parser.parse(raw_result)));
                    
                } else {
                    parsed = new Skyscraper(((JSONObject)this.parser.parse(raw_result)));
                    
                }
                
                result.add(parsed);
                
            }
        } catch (SQLException e) {
            System.err.println("Could not iterate through query.");
    		e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Could not convert the response from getSkyscrapers; a parser error occurred.");
    		e.printStackTrace();
        }
        return result;
	}
    
}