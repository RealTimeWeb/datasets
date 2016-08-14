package corgis.books;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import corgis.books.domain.*;

import java.sql.*;

/**
 * {'overview': "This data set contains information about different books written by different authors pertaining to a variety of genres.  Information about the books includes page count, whether it's a paperback, and the price of the book.\n", 'short': 'Records about different books and different attributes associated with them.'}
 */
public class BooksLibrary {
    private String databasePath;
	private Connection connection;
    private JSONParser parser;
    private final int HARDWARE = 1000;
    
    public static void main(String[] args) {
        System.out.println("Testing Books");
        BooksLibrary booksLibrary = new BooksLibrary();
        
        
        System.out.println("Testing production GetBooks");
        ArrayList<Books> list_of_books_1_production = booksLibrary.getBooks();
        
        
        
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
	public BooksLibrary() {
        this.databasePath = "books.db";
        this.connectToDatabase(this.databasePath);
	}
	
    /**
     * Create a connection to the database file, stored explicitly somewhere.
     * @param databasePath The filename of the database file.
     */
	public BooksLibrary(String databasePath) {
        this.databasePath = databasePath;
        this.connectToDatabase(this.databasePath);
	}
    
    
    
    
    /**
     * Gets a list of all the books in the database.
    
     * @return a list[books]
     */
	public ArrayList<Books> getBooks() {
        String query;
        boolean test = false;
        if (test) {
            query = String.format("", this.HARDWARE);
        } else {
            query = "SELECT data FROM books";
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
        
        ArrayList<Books> result = new ArrayList<Books>();
        try {
            while (rs.next()) {
                String raw_result = rs.getString(1);
                Books parsed = null;
                if (test) {
                    
                } else {
                    parsed = new Book((JSONObject)this.parser.parse(raw_result));
                    
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