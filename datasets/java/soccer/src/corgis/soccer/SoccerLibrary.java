package corgis.soccer;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import corgis.soccer.domain.*;

import java.sql.*;

/**
 * {'overview': 'Free open public domain soccer data (football). Leagues include the English Premier League, Deutsche Bundesliga, Spanish Primera Division ("La Liga"), Italian Serie A, and more.\n', 'citation': 'https://github.com/openfootball/football.json', 'short': 'Free open public domain soccer data (football). Leagues include the English Premier League, Deutsche Bundesliga, Spanish Primera Division ("La Liga"), Italian Serie A, and more.\n'}
 */
public class SoccerLibrary {
    private String databasePath;
	private Connection connection;
    private JSONParser parser;
    private final int HARDWARE = 1000;
    
    public static void main(String[] args) {
        System.out.println("Testing Soccer");
        SoccerLibrary soccerLibrary = new SoccerLibrary();
        
        
        System.out.println("Testing production GetGames");
        Record a_record_1_production = soccerLibrary.getGames("'Austrian Bundesliga'");
        
        
        
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
	public SoccerLibrary() {
        this.databasePath = "soccer.db";
        this.connectToDatabase(this.databasePath);
	}
	
    /**
     * Create a connection to the database file, stored explicitly somewhere.
     * @param databasePath The filename of the database file.
     */
	public SoccerLibrary(String databasePath) {
        this.databasePath = databasePath;
        this.connectToDatabase(this.databasePath);
	}
    
    
    
    
    /**
     * Returns information about all of the soccer games for a given league.
    
     * @param league The league you want information about. Must be one of "Austrian Bundesliga", "Austrian Erste Liga", "English Premier League", "Spanish Primera Division", "Deutsche Bundesliga", "Deutsche Bundesliga 2", or "Italian Serie A".
     * @return a record
     */
	public Record getGames(String league) {
        String query;
        boolean test = false;
        if (test) {
            query = String.format("", this.HARDWARE);
        } else {
            query = "SELECT data FROM soccer WHERE name=?";
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
            preparedQuery.setString(1, league);
        } catch (SQLException e) {
            System.err.println("Could not build prepare argument: league");
    		e.printStackTrace();
        }
        try {
            rs = preparedQuery.executeQuery();
        } catch (SQLException e) {
            System.err.println("Could not execute query.");
    		e.printStackTrace();
        }
        
        Record result = null;
        try {
            while (rs.next()) {
                String raw_result = rs.getString(1);
                Record parsed = null;
                if (test) {
                    
                } else {
                    parsed = new Soccer((JSONObject)this.parser.parse(raw_result).get("data"));
                    
                }
                
                result = parsed;
                
            }
        } catch (SQLException e) {
            System.err.println("Could not iterate through query.");
    		e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Could not convert the response from getGames; a parser error occurred.");
    		e.printStackTrace();
        }
        return result;
	}
    
}