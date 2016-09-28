package corgis.retail_services;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import corgis.retail_services.domain.*;

import java.sql.*;

/**
 * The Advance Monthly and Monthly Retail Trade Surveys (MARTS and MRTS), the Annual Retail Trade Survey (ARTS), and the Quarterly E-Commerce Report work together to produce the most comprehensive data available on retail economic activity in the United States. More detailed descriptions of these programs can be found by choosing one of the links to the left.
Regular quality control and verification takes place between MARTS, MRTS, and ARTS annually and between these programs and the Economic Census of Retail Trade every five years. Each year when annual data become available, we compare and resolve differences between the data collected on the monthly and annual surveys. We refer to this process as the monthly-to-annual reconciliation. At the same time, we benchmark the monthly estimates using results of the annual survey. ARTS estimates are then benchmarked to data maintained by the Economic Census of Retail Trade. This process of benchmarking retail data over all four programs ensures consistency in our estimates.
The Business Expenses Supplement is an addition to the 2007 Annual Retail Trade Survey. Its purpose is to compile statistics on detailed business operating expenses. The United States Code, Title 13, authorizes this program as part of the Economic Census. This coverage was previously part of the predecessor Business Expenses Survey. Detailed expenses are collected every five years. 

 */
public class RetailServicesLibrary {
    private String databasePath;
	private Connection connection;
    private JSONParser parser;
    private final int HARDWARE = 1000;
    
    public static void main(String[] args) {
        System.out.println("Testing RetailServices");
        RetailServicesLibrary retailServicesLibrary = new RetailServicesLibrary();
        
        
        System.out.println("Testing production GetReport");
        ArrayList<Report> list_of_report_1_production = retailServicesLibrary.getReport(false);
        
        
        System.out.println("Testing test GetReport");
        ArrayList<Report> list_of_report_1_test = retailServicesLibrary.getReport(true);
        
        
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
	public RetailServicesLibrary() {
        this.databasePath = "retail_services.db";
        this.connectToDatabase(this.databasePath);
	}
	
    /**
     * Create a connection to the database file, stored explicitly somewhere.
     * @param databasePath The filename of the database file.
     */
	public RetailServicesLibrary(String databasePath) {
        this.databasePath = databasePath;
        this.connectToDatabase(this.databasePath);
	}
    
    
    
    /**
     * Returns sales, inventory, and ratio data for every month.
    
     * @return a list[report]
     */
	public ArrayList<Report> getReport() {
        return this.getReport(true);
    }
    
    
    /**
     * Returns sales, inventory, and ratio data for every month.
    
     * @return a list[report]
     */
	public ArrayList<Report> getReport(boolean test) {
        String query;
        if (test) {
            query = String.format("SELECT data FROM retail_services LIMIT %d", this.HARDWARE);
        } else {
            query = "SELECT data FROM retail_services";
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
            System.err.println("Could not convert the response from getReport; a parser error occurred.");
    		e.printStackTrace();
        }
        return result;
	}
    
}