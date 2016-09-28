package corgis.slavery;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import corgis.slavery.domain.*;

import java.sql.*;

/**
 * This dataset has financial records of New Orleans slave sales, 1856-1861. There are almost 16,000 sales recorded in this dataset. 

 */
public class SlaveryLibrary {
    private String databasePath;
	private Connection connection;
    private JSONParser parser;
    private final int HARDWARE = 1000;
    
    public static void main(String[] args) {
        System.out.println("Testing Slavery");
        SlaveryLibrary slaveryLibrary = new SlaveryLibrary();
        
        
        System.out.println("Testing production GetTransaction");
        ArrayList<TransactionRecord> list_of_transaction_record_1_production = slaveryLibrary.getTransaction(false);
        
        
        System.out.println("Testing test GetTransaction");
        ArrayList<TransactionRecord> list_of_transaction_record_1_test = slaveryLibrary.getTransaction(true);
        
        
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
	public SlaveryLibrary() {
        this.databasePath = "slavery.db";
        this.connectToDatabase(this.databasePath);
	}
	
    /**
     * Create a connection to the database file, stored explicitly somewhere.
     * @param databasePath The filename of the database file.
     */
	public SlaveryLibrary(String databasePath) {
        this.databasePath = databasePath;
        this.connectToDatabase(this.databasePath);
	}
    
    
    
    /**
     * Returns a list of the transactions in the database.
    
     * @return a list[transaction record]
     */
	public ArrayList<TransactionRecord> getTransaction() {
        return this.getTransaction(true);
    }
    
    
    /**
     * Returns a list of the transactions in the database.
    
     * @return a list[transaction record]
     */
	public ArrayList<TransactionRecord> getTransaction(boolean test) {
        String query;
        if (test) {
            query = String.format("SELECT data FROM slavery LIMIT %d", this.HARDWARE);
        } else {
            query = "SELECT data FROM slavery";
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
        
        ArrayList<TransactionRecord> result = new ArrayList<TransactionRecord>();
        try {
            while (rs.next()) {
                String raw_result = rs.getString(1);
                TransactionRecord parsed = null;
                if (test) {
                    parsed = new TransactionRecord(((JSONObject)this.parser.parse(raw_result)));
                    
                } else {
                    parsed = new TransactionRecord(((JSONObject)this.parser.parse(raw_result)));
                    
                }
                
                result.add(parsed);
                
            }
        } catch (SQLException e) {
            System.err.println("Could not iterate through query.");
    		e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Could not convert the response from getTransaction; a parser error occurred.");
    		e.printStackTrace();
        }
        return result;
	}
    
}