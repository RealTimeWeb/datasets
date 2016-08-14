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
 * {'overview': 'This dataset has financial records of New Orleans slave sales, 1856-1861. There are almost 16,000 sales recorded in this dataset. \n', 'provenance': 'These data were collected from the office of the Orleans parish Civil Clerk of Court. The sample includes all slave sales recorded by the register of conveyance from October 1856 to August 1861. The construction of the dataset is similar to that employed previously by Fogel and Engerman (1976). The unit of observation is the individual with the exception of children who were bundled with their mothers. \n', 'citation': 'Calomiris, Charles W., and Jonathan Pritchett. 2016. "Betting on Secession: Quantifying Political Events Surrounding Slavery and the Civil War." American Economic Review, 106(1): 1-23.\n', 'short': 'This dataset has financial records of New Orleans slave sales, 1856-1861. There are almost 16,000 sales recorded in this dataset.'}
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
        ArrayList<TracsactionRecord> list_of_tracsaction_record_1_production = slaveryLibrary.getTransaction(false);
        
        
        System.out.println("Testing test GetTransaction");
        ArrayList<TracsactionRecord> list_of_tracsaction_record_1_test = slaveryLibrary.getTransaction(true);
        
        
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
    
     * @return a list[tracsaction record]
     */
	public ArrayList<TracsactionRecord> getTransaction() {
        return this.getTransaction(true);
    }
    
    
    /**
     * Returns a list of the transactions in the database.
    
     * @return a list[tracsaction record]
     */
	public ArrayList<TracsactionRecord> getTransaction(boolean test) {
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
        
        ArrayList<TracsactionRecord> result = new ArrayList<TracsactionRecord>();
        try {
            while (rs.next()) {
                String raw_result = rs.getString(1);
                TracsactionRecord parsed = null;
                if (test) {
                    parsed = new TransactionRecord((JSONObject)this.parser.parse(raw_result));
                    
                } else {
                    parsed = new TransactionRecord((JSONObject)this.parser.parse(raw_result));
                    
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