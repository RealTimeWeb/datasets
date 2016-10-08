package corgis.finance;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import corgis.finance.domain.*;

import java.sql.*;

/**
 * The Annual Survey of State Government Finances provides a comprehensive summary of the annual survey findings for state governments, as well as data for individual states. The data contain detail of revenue by source, expenditure by object and function, indebtedness by term, and assets by purpose. This data goes back for almost two decades across every date.

 */
public class FinanceLibrary {
    private String databasePath;
	private Connection connection;
    private JSONParser parser;
    private final int HARDWARE = 1000;
    
    public static void main(String[] args) {
        System.out.println("Testing Finance");
        FinanceLibrary financeLibrary = new FinanceLibrary();
        
        
        System.out.println("Testing production GetFinances");
        ArrayList<Record> list_of_record_1_production = financeLibrary.getFinances(false);
        
        
        System.out.println("Testing test GetFinances");
        ArrayList<Record> list_of_record_1_test = financeLibrary.getFinances(true);
        
        
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
	public FinanceLibrary() {
        this.databasePath = "finance.db";
        this.connectToDatabase(this.databasePath);
	}
	
    /**
     * Create a connection to the database file, stored explicitly somewhere.
     * @param databasePath The filename of the database file.
     */
	public FinanceLibrary(String databasePath) {
        this.databasePath = databasePath;
        this.connectToDatabase(this.databasePath);
	}
    
    
    
    /**
     * Returns financial data about all the states.
    
     * @return a list[record]
     */
	public ArrayList<Record> getFinances() {
        return this.getFinances(true);
    }
    
    
    /**
     * Returns financial data about all the states.
    
     * @return a list[record]
     */
	public ArrayList<Record> getFinances(boolean test) {
        String query;
        if (test) {
            query = String.format("SELECT data FROM finance LIMIT %d", this.HARDWARE);
        } else {
            query = "SELECT data FROM finance";
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
        
        ArrayList<Record> result = new ArrayList<Record>();
        try {
            while (rs.next()) {
                String raw_result = rs.getString(1);
                Record parsed = null;
                if (test) {
                    parsed = new Record(((JSONObject)this.parser.parse(raw_result)));
                    
                } else {
                    parsed = new Record(((JSONObject)this.parser.parse(raw_result)));
                    
                }
                
                result.add(parsed);
                
            }
        } catch (SQLException e) {
            System.err.println("Could not iterate through query.");
    		e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Could not convert the response from getFinances; a parser error occurred.");
    		e.printStackTrace();
        }
        return result;
	}
    
}