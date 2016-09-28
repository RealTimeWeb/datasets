package corgis.state_fragility;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import corgis.state_fragility.domain.*;

import java.sql.*;

/**
 * The Center for Systemic Peace was founded in 1997 to engage in global systems analysis to minimize the effects of political violence in the world as a whole.  The following data set shows the state fragility for countries with a population greater than 500,000 in 2013.  The State Fragility Index scores countries on two main categories, effectiveness and legitimacy.  These are then broken down into four dimensions: Security, Political, Economic, and Social.  The State Fragility Index score is the sum of the individual country's effectiveness score and their legitimacy score.  Each of these scores are the summation of the four dimensions within the category.  

 */
public class StateFragilityLibrary {
    private String databasePath;
	private Connection connection;
    private JSONParser parser;
    private final int HARDWARE = 1000;
    
    public static void main(String[] args) {
        System.out.println("Testing StateFragility");
        StateFragilityLibrary stateFragilityLibrary = new StateFragilityLibrary();
        
        
        System.out.println("Testing production GetScores");
        ArrayList<Score> list_of_score_1_production = stateFragilityLibrary.getScores(false);
        
        
        System.out.println("Testing test GetScores");
        ArrayList<Score> list_of_score_1_test = stateFragilityLibrary.getScores(true);
        
        
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
	public StateFragilityLibrary() {
        this.databasePath = "state_fragility.db";
        this.connectToDatabase(this.databasePath);
	}
	
    /**
     * Create a connection to the database file, stored explicitly somewhere.
     * @param databasePath The filename of the database file.
     */
	public StateFragilityLibrary(String databasePath) {
        this.databasePath = databasePath;
        this.connectToDatabase(this.databasePath);
	}
    
    
    
    /**
     * Returns state fragility scores from the dataset.
    
     * @return a list[score]
     */
	public ArrayList<Score> getScores() {
        return this.getScores(true);
    }
    
    
    /**
     * Returns state fragility scores from the dataset.
    
     * @return a list[score]
     */
	public ArrayList<Score> getScores(boolean test) {
        String query;
        if (test) {
            query = String.format("SELECT data FROM fragility LIMIT %d", this.HARDWARE);
        } else {
            query = "SELECT data FROM fragility";
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
        
        ArrayList<Score> result = new ArrayList<Score>();
        try {
            while (rs.next()) {
                String raw_result = rs.getString(1);
                Score parsed = null;
                if (test) {
                    parsed = new Score(((JSONObject)this.parser.parse(raw_result)));
                    
                } else {
                    parsed = new Score(((JSONObject)this.parser.parse(raw_result)));
                    
                }
                
                result.add(parsed);
                
            }
        } catch (SQLException e) {
            System.err.println("Could not iterate through query.");
    		e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Could not convert the response from getScores; a parser error occurred.");
    		e.printStackTrace();
        }
        return result;
	}
    
}