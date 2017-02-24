package corgis.tate;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import corgis.tate.domain.*;

import java.sql.*;

/**
 * Tate holds the national collection of British art from 1500 to the present day and international modern and contemporary art. The collection embraces all media, from painting, drawing, sculpture and prints to photography, video and film, installation and performance. This dataset is not ordered in any particular way.
This dataset has metadata about many pieces from their collection.

 */
public class TateLibrary {
    private String databasePath;
	private Connection connection;
    private JSONParser parser;
    private final int HARDWARE = 1000;
    
    public static void main(String[] args) {
        System.out.println("Testing Tate");
        TateLibrary tateLibrary = new TateLibrary();
        
        
        System.out.println("Testing production GetArtwork");
        ArrayList<Art> list_of_art_1_production = tateLibrary.getArtwork(false);
        
        
        System.out.println("Testing test GetArtwork");
        ArrayList<Art> list_of_art_1_test = tateLibrary.getArtwork(true);
        
        
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
	public TateLibrary() {
        this.databasePath = "tate.db";
        this.connectToDatabase(this.databasePath);
	}
	
    /**
     * Create a connection to the database file, stored explicitly somewhere.
     * @param databasePath The filename of the database file.
     */
	public TateLibrary(String databasePath) {
        this.databasePath = databasePath;
        this.connectToDatabase(this.databasePath);
	}
    
    
    
    /**
     * Returns a list of all the pieces of art in the Tate collection.
    
     * @return a list[art]
     */
	public ArrayList<Art> getArtwork() {
        return this.getArtwork(true);
    }
    
    
    /**
     * Returns a list of all the pieces of art in the Tate collection.
    
     * @return a list[art]
     */
	public ArrayList<Art> getArtwork(boolean test) {
        String query;
        if (test) {
            query = String.format("SELECT data FROM tate LIMIT %d", this.HARDWARE);
        } else {
            query = "SELECT data FROM tate";
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
        
        ArrayList<Art> result = new ArrayList<Art>();
        try {
            while (rs.next()) {
                String raw_result = rs.getString(1);
                Art parsed = null;
                if (test) {
                    parsed = new Artwork(((JSONObject)this.parser.parse(raw_result)));
                    
                } else {
                    parsed = new Artwork(((JSONObject)this.parser.parse(raw_result)));
                    
                }
                
                result.add(parsed);
                
            }
        } catch (SQLException e) {
            System.err.println("Could not iterate through query.");
    		e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Could not convert the response from getArtwork; a parser error occurred.");
    		e.printStackTrace();
        }
        return result;
	}
    
}