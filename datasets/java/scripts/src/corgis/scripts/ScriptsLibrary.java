package corgis.scripts;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import corgis.scripts.domain.*;

import java.sql.*;

/**
 * {'overview': 'This dataset is all about over 600 movies. It was collected and organized by the Cornell Movie Dialogs Corpus. More information about the project is available at the CMDC site (http://www.mpi-sws.org/~cristian/Cornell_Movie-Dialogs_Corpus.html).\n', 'short': 'This dataset is all about the text scripts of over 600 movies.'}
 */
public class ScriptsLibrary {
    private String databasePath;
	private Connection connection;
    private JSONParser parser;
    private final int HARDWARE = 20;
    
    public static void main(String[] args) {
        System.out.println("Testing Scripts");
        ScriptsLibrary scriptsLibrary = new ScriptsLibrary();
        
        
        System.out.println("Testing production GetScripts");
        ArrayList<Script> list_of_script_1_production = scriptsLibrary.getScripts(false);
        
        
        System.out.println("Testing test GetScripts");
        ArrayList<Script> list_of_script_1_test = scriptsLibrary.getScripts(true);
        
        
        
        System.out.println("Testing production GetScriptByTitle");
        Script a_script_2_production = scriptsLibrary.getScriptByTitle("\"the princess bride\"");
        
        
        
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
	public ScriptsLibrary() {
        this.databasePath = "scripts.db";
        this.connectToDatabase(this.databasePath);
	}
	
    /**
     * Create a connection to the database file, stored explicitly somewhere.
     * @param databasePath The filename of the database file.
     */
	public ScriptsLibrary(String databasePath) {
        this.databasePath = databasePath;
        this.connectToDatabase(this.databasePath);
	}
    
    
    
    /**
     * Returns all the scripts
    
     * @return a list[script]
     */
	public ArrayList<Script> getScripts() {
        return this.getScripts(true);
    }
    
    
    /**
     * Returns all the scripts
    
     * @return a list[script]
     */
	public ArrayList<Script> getScripts(boolean test) {
        String query;
        if (test) {
            query = String.format("SELECT data FROM scripts LIMIT %d", this.HARDWARE);
        } else {
            query = "SELECT data FROM scripts";
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
        
        ArrayList<Script> result = new ArrayList<Script>();
        try {
            while (rs.next()) {
                String raw_result = rs.getString(1);
                Script parsed = null;
                if (test) {
                    parsed = new Script((JSONObject)this.parser.parse(raw_result).get("data"));
                    
                } else {
                    parsed = new Script((JSONObject)this.parser.parse(raw_result).get("data"));
                    
                }
                
                result.add(parsed);
                
            }
        } catch (SQLException e) {
            System.err.println("Could not iterate through query.");
    		e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Could not convert the response from getScripts; a parser error occurred.");
    		e.printStackTrace();
        }
        return result;
	}
    
    
    
    /**
     * Returns a specific script, given it's title.
    
     * @param title The title of the movie. There are only 600 movies in the database, but there are many popular ones.
     * @return a script
     */
	public Script getScriptByTitle(String title) {
        String query;
        boolean test = false;
        if (test) {
            query = String.format("", this.HARDWARE);
        } else {
            query = "SELECT data FROM scripts WHERE title=? COLLATE NOCASE LIMIT 1";
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
            preparedQuery.setString(1, title);
        } catch (SQLException e) {
            System.err.println("Could not build prepare argument: title");
    		e.printStackTrace();
        }
        try {
            rs = preparedQuery.executeQuery();
        } catch (SQLException e) {
            System.err.println("Could not execute query.");
    		e.printStackTrace();
        }
        
        Script result = null;
        try {
            while (rs.next()) {
                String raw_result = rs.getString(1);
                Script parsed = null;
                if (test) {
                    
                } else {
                    parsed = new Script((JSONObject)this.parser.parse(raw_result).get("data"));
                    
                }
                
                result = parsed;
                
            }
        } catch (SQLException e) {
            System.err.println("Could not iterate through query.");
    		e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Could not convert the response from getScriptByTitle; a parser error occurred.");
    		e.printStackTrace();
        }
        return result;
	}
    
}