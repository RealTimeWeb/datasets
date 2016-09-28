package corgis.billionaires;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import corgis.billionaires.domain.*;

import java.sql.*;

/**
 * Researchers have compiled a multi-decade database of the super-rich. Building off the Forbes World's Billionaires lists from 1996-2014, scholars at Peterson Institute for International Economics have added a couple dozen more variables about each billionaire - including whether they were self-made or inherited their wealth. (Roughly half of European billionaires and one-third of U.S. billionaires got a significant financial boost from family, the authors estimate.)

 */
public class BillionairesLibrary {
    private String databasePath;
	private Connection connection;
    private JSONParser parser;
    private final int HARDWARE = 1000;
    
    public static void main(String[] args) {
        System.out.println("Testing Billionaires");
        BillionairesLibrary billionairesLibrary = new BillionairesLibrary();
        
        
        System.out.println("Testing production GetBillionaires");
        ArrayList<Billionaire> list_of_billionaire_1_production = billionairesLibrary.getBillionaires();
        
        
        
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
	public BillionairesLibrary() {
        this.databasePath = "billionaires.db";
        this.connectToDatabase(this.databasePath);
	}
	
    /**
     * Create a connection to the database file, stored explicitly somewhere.
     * @param databasePath The filename of the database file.
     */
	public BillionairesLibrary(String databasePath) {
        this.databasePath = databasePath;
        this.connectToDatabase(this.databasePath);
	}
    
    
    
    
    /**
     * Returns information about all the billionaires.
    
     * @return a list[billionaire]
     */
	public ArrayList<Billionaire> getBillionaires() {
        String query;
        boolean test = false;
        if (test) {
            query = String.format("", this.HARDWARE);
        } else {
            query = "SELECT data FROM billionaires";
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
        
        ArrayList<Billionaire> result = new ArrayList<Billionaire>();
        try {
            while (rs.next()) {
                String raw_result = rs.getString(1);
                Billionaire parsed = null;
                if (test) {
                    
                } else {
                    parsed = new Billionaire(((JSONObject)this.parser.parse(raw_result)));
                    
                }
                
                result.add(parsed);
                
            }
        } catch (SQLException e) {
            System.err.println("Could not iterate through query.");
    		e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Could not convert the response from getBillionaires; a parser error occurred.");
    		e.printStackTrace();
        }
        return result;
	}
    
}