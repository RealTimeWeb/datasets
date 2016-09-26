package corgis.graduates;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import corgis.graduates.domain.*;

import java.sql.*;

/**
 * {'overview': "This library comes from FiveThirtyEight's story on earnings of college majors based on data from the American Community Survey 2010-2012 Public Use Microdata Series.  Included is information about employment numbers, major information, and the earnings of different majors.\n", 'short': 'This library holds data about employment of new graduates by major.', 'citation': 'http://www.census.gov/acs/www/data_documentation/pums_documentation/ <br> https://github.com/fivethirtyeight/data/tree/master/college-majors'}
 */
public class GraduatesLibrary {
    private String databasePath;
	private Connection connection;
    private JSONParser parser;
    private final int HARDWARE = 1000;
    
    public static void main(String[] args) {
        System.out.println("Testing Graduates");
        GraduatesLibrary graduatesLibrary = new GraduatesLibrary();
        
        
        System.out.println("Testing production GetMajors");
        ArrayList<GradMajor> list_of_grad_major_1_production = graduatesLibrary.getMajors();
        
        
        
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
	public GraduatesLibrary() {
        this.databasePath = "graduates.db";
        this.connectToDatabase(this.databasePath);
	}
	
    /**
     * Create a connection to the database file, stored explicitly somewhere.
     * @param databasePath The filename of the database file.
     */
	public GraduatesLibrary(String databasePath) {
        this.databasePath = databasePath;
        this.connectToDatabase(this.databasePath);
	}
    
    
    
    
    /**
     * Returns information about all recorded majors.
    
     * @return a list[grad major]
     */
	public ArrayList<GradMajor> getMajors() {
        String query;
        boolean test = false;
        if (test) {
            query = String.format("", this.HARDWARE);
        } else {
            query = "SELECT data FROM graduates";
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
        
        ArrayList<GradMajor> result = new ArrayList<GradMajor>();
        try {
            while (rs.next()) {
                String raw_result = rs.getString(1);
                GradMajor parsed = null;
                if (test) {
                    
                } else {
                    parsed = new GradMajor(((JSONObject)this.parser.parse(raw_result)));
                    
                }
                
                result.add(parsed);
                
            }
        } catch (SQLException e) {
            System.err.println("Could not iterate through query.");
    		e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Could not convert the response from getMajors; a parser error occurred.");
    		e.printStackTrace();
        }
        return result;
	}
    
}