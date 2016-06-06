package corgis.classics;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import corgis.classics.domain.*;

import java.sql.*;

/**
 * {'overview': "Project Gutenberg (PG) is a volunteer effort to digitize and archive cultural works, to 'encourage the creation and distribution of eBooks'. It was founded in 1971 by Michael S. Hart and is the oldest digital library. This dataset is a collection of the top 1000 most popular books on Project Gutenberg, as determined by downloads. Each book has information about its authorship, publication date, congressional classication, and a few other fields. It also has some simple, computed statistics based on common metrics such as sentiment analysis, Flesch Kincaid Reading level, and average sentence length. \n", 'short': 'Records and computed statistics about the top 1000 books on Project Gutenberg.', 'citation': 'https://www.gutenberg.org/ebooks/search/?sort_order=downloads'}
 */
public class ClassicsLibrary {
    private String databasePath;
	private Connection connection;
    private JSONParser parser;
    private final int HARDWARE = 1000;
    
    public static void main(String[] args) {
        System.out.println("Testing Classics");
        ClassicsLibrary classicsLibrary = new ClassicsLibrary();
        
        
        System.out.println("Testing production GetBooks");
        ArrayList<Classic> list_of_classic_1_production = classicsLibrary.getBooks(false);
        
        
        System.out.println("Testing test GetBooks");
        ArrayList<Classic> list_of_classic_1_test = classicsLibrary.getBooks(true);
        
        
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
	public ClassicsLibrary() {
        this.databasePath = "classics.db";
        this.connectToDatabase(this.databasePath);
	}
	
    /**
     * Create a connection to the database file, stored explicitly somewhere.
     * @param databasePath The filename of the database file.
     */
	public ClassicsLibrary(String databasePath) {
        this.databasePath = databasePath;
        this.connectToDatabase(this.databasePath);
	}
    
    
    
    /**
     * Returns books from the dataset.
    
     * @return a list[classic]
     */
	public ArrayList<Classic> getBooks() {
        return this.getBooks(true);
    }
    
    
    /**
     * Returns books from the dataset.
    
     * @return a list[classic]
     */
	public ArrayList<Classic> getBooks(boolean test) {
        String query;
        if (test) {
            query = String.format("SELECT data FROM classics LIMIT %d", this.HARDWARE);
        } else {
            query = "SELECT data FROM classics";
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
        
        ArrayList<Classic> result = new ArrayList<Classic>();
        try {
            while (rs.next()) {
                String raw_result = rs.getString(1);
                Classics parsed = null;
                if (test) {
                    parsed = new Classic((JSONObject)this.parser.parse(raw_result));
                    
                } else {
                    parsed = new Classic((JSONObject)this.parser.parse(raw_result));
                    
                }
                
                result.add(parsed);
                
            }
        } catch (SQLException e) {
            System.err.println("Could not iterate through query.");
    		e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Could not convert the response from getBooks; a parser error occurred.");
    		e.printStackTrace();
        }
        return result;
	}
    
}