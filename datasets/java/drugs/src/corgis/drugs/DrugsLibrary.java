package corgis.drugs;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import corgis.drugs.domain.*;

import java.sql.*;

/**
 * {'overview': "This dataset is about substance abuse (cigarettes, marijuana, cocaine, alcohol) among different age groups and states. The units are in 1000s of people. The 'CI' refers to 'Confidence Intervals'.\n", 'short': 'This dataset is about substance abuse (cigarettes, marijuana, cocaine, alcohol) among different age groups and states.', 'citation': "<a href='https://nsduhweb.rti.org/respweb/homepage.cfm'>https://nsduhweb.rti.org/respweb/homepage.cfm</a>"}
 */
public class DrugsLibrary {
    private String databasePath;
	private Connection connection;
    private JSONParser parser;
    private final int HARDWARE = 100;
    
    public static void main(String[] args) {
        System.out.println("Testing Drugs");
        DrugsLibrary drugsLibrary = new DrugsLibrary();
        
        
        System.out.println("Testing production GetSurveys");
        ArrayList<Survey> list_of_survey_1_production = drugsLibrary.getSurveys("'Cigarette Use'");
        
        
        
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
	public DrugsLibrary() {
        this.databasePath = "drugs.db";
        this.connectToDatabase(this.databasePath);
	}
	
    /**
     * Create a connection to the database file, stored explicitly somewhere.
     * @param databasePath The filename of the database file.
     */
	public DrugsLibrary(String databasePath) {
        this.databasePath = databasePath;
        this.connectToDatabase(this.databasePath);
	}
    
    
    
    
    /**
     * Given one of the survey questions, returns the associated data from respondents.
    
     * @param question The name of the survey question. Must be one of 'Cocaine Year', 'Alcohol Month', 'Cigarette Use', 'Alcohol Risk', 'Illicit/Alcohol Dependence or Abuse', 'Marijuana New', 'Illicit Dependence', 'Alcohol Dependence', 'Tobacco Use', 'Alcohol Binge', 'Marijuana Risk', 'Alcohol Abuse', 'Marijuana Month', 'Illicit Dependence or Abuse', 'Smoking Risk', 'Illicit Month', 'Alcohol Treatment', 'Nonmarijuana Illicit', 'Pain Relievers', 'Marijuana Year', 'Illicit Treatment', 'Depression'.
     * @return a list[survey]
     */
	public ArrayList<Survey> getSurveys(String question) {
        String query;
        boolean test = false;
        if (test) {
            query = String.format("", this.HARDWARE);
        } else {
            query = "SELECT data FROM drugs WHERE name=? COLLATE NOCASE";
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
            preparedQuery.setString(1, question);
        } catch (SQLException e) {
            System.err.println("Could not build prepare argument: question");
    		e.printStackTrace();
        }
        try {
            rs = preparedQuery.executeQuery();
        } catch (SQLException e) {
            System.err.println("Could not execute query.");
    		e.printStackTrace();
        }
        
        ArrayList<Survey> result = new ArrayList<Survey>();
        try {
            while (rs.next()) {
                String raw_result = rs.getString(1);
                Survey parsed = null;
                if (test) {
                    
                } else {
                    parsed = new Survey((JSONObject)this.parser.parse(raw_result));
                    
                }
                
                result.add(parsed);
                
            }
        } catch (SQLException e) {
            System.err.println("Could not iterate through query.");
    		e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Could not convert the response from getSurveys; a parser error occurred.");
    		e.printStackTrace();
        }
        return result;
	}
    
}