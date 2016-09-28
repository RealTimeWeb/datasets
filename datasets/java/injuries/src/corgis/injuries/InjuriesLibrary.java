package corgis.injuries;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import corgis.injuries.domain.*;

import java.sql.*;

/**
 * The Occupational Safety and Health Administration (OSHA) collected work-related injury and illness data from employers within specific industry and employment size specifications from 2002 through 2011. This data collection is called the OSHA Data Initiative or ODI. The data provided is used by OSHA to calculate establishment specific injury and illness incidence rates. This searchable database contains a table with the name, address, industry, and associated Total Case Rate (TCR), Days Away, Restricted, and Transfer (DART) case rate, and the Days Away From Work (DAFWII) case rate for the establishments that provided OSHA with valid data for calendar years 2002 through 2011.
This data has been sampled down from its original size to 4%. In addition, the original dataset only has data from a small portion of all private sector establishments in the United States (80,000 out of 7.5 million total establishments). Therefore, these data are not representative of all businesses and general conclusions pertaining to all US business should not be overdrawn.
Data quality: While OSHA takes multiple steps to ensure the data collected is accurate, problems and errors invariably exist for a small percentage of establishments. OSHA does not believe the data for the establishments with the highest rates on this file are accurate in absolute terms. Efforts were made during the collection cycle to correct submission errors, however some remain unresolved. It would be a mistake to say establishments with the highest rates on this file are the 'most dangerous' or 'worst' establishments in the Nation.
Rate Calculation: An incidence rate of injuries and illnesses is computed from the following formula: (Number of injuries and illnesses X 200,000) / Employee hours worked = Incidence rate. The Total Case Rate includes all cases recorded on the OSHA Form 300 (Column G + Column H + Column I + Column J). The Days Away/Restriced/Transfer includes cases recorded in Column H + Column I. The Days Away includes cases recorded in Column H. For further information on injury and illness incidence rates, please visit the Bureau of Labor Statistics' webpage at http://www.bls.gov/iif/osheval.htm
State Participation: Not all state plan states participate in the ODI. The following states did not participate in the 2010 ODI (collection of CY 2009 data), establishment data is not available for these states: Alaska; Oregon; Puerto Rico; South Carolina; Washington; Wyoming.

 */
public class InjuriesLibrary {
    private String databasePath;
	private Connection connection;
    private JSONParser parser;
    private final int HARDWARE = 1000;
    
    public static void main(String[] args) {
        System.out.println("Testing Injuries");
        InjuriesLibrary injuriesLibrary = new InjuriesLibrary();
        
        
        System.out.println("Testing production GetReports");
        ArrayList<Report> list_of_report_1_production = injuriesLibrary.getReports(false);
        
        
        System.out.println("Testing test GetReports");
        ArrayList<Report> list_of_report_1_test = injuriesLibrary.getReports(true);
        
        
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
	public InjuriesLibrary() {
        this.databasePath = "injuries.db";
        this.connectToDatabase(this.databasePath);
	}
	
    /**
     * Create a connection to the database file, stored explicitly somewhere.
     * @param databasePath The filename of the database file.
     */
	public InjuriesLibrary(String databasePath) {
        this.databasePath = databasePath;
        this.connectToDatabase(this.databasePath);
	}
    
    
    
    /**
     * Returns injury reports for companies in the US.
    
     * @return a list[report]
     */
	public ArrayList<Report> getReports() {
        return this.getReports(true);
    }
    
    
    /**
     * Returns injury reports for companies in the US.
    
     * @return a list[report]
     */
	public ArrayList<Report> getReports(boolean test) {
        String query;
        if (test) {
            query = String.format("SELECT data FROM injuries LIMIT %d", this.HARDWARE);
        } else {
            query = "SELECT data FROM injuries";
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
        
        ArrayList<Report> result = new ArrayList<Report>();
        try {
            while (rs.next()) {
                String raw_result = rs.getString(1);
                Report parsed = null;
                if (test) {
                    parsed = new Report(((JSONObject)this.parser.parse(raw_result)));
                    
                } else {
                    parsed = new Report(((JSONObject)this.parser.parse(raw_result)));
                    
                }
                
                result.add(parsed);
                
            }
        } catch (SQLException e) {
            System.err.println("Could not iterate through query.");
    		e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Could not convert the response from getReports; a parser error occurred.");
    		e.printStackTrace();
        }
        return result;
	}
    
}