package corgis.drugbank;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import corgis.drugbank.domain.*;

import java.sql.*;

/**
 * {'overview': 'The DrugBank database is a unique bioinformatics and cheminformatics resource that combines detailed drug (i.e. chemical, pharmacological and pharmaceutical) data with comprehensive drug target (i.e. sequence, structure, and pathway) information.\n', 'short': 'The DrugBank database is a cheminformatics resource that combines detailed drug data with comprehensive drug target information.', 'citation': 'Wishart DS, Knox C, Guo AC, Shrivastava S, Hassanali M, Stothard P, Chang Z, Woolsey J. DrugBank: a comprehensive resource for in silico drug discovery and exploration. Nucleic Acids Res. 2006 Jan 1;34(Database issue):D668-72. 16381955'}
 */
public class DrugbankLibrary {
    private String databasePath;
	private Connection connection;
    private JSONParser parser;
    private final int HARDWARE = 1000;
    
    public static void main(String[] args) {
        System.out.println("Testing Drugbank");
        DrugbankLibrary drugbankLibrary = new DrugbankLibrary();
        
        
        System.out.println("Testing production GetDrugs");
        ArrayList<Drug> list_of_drug_1_production = drugbankLibrary.getDrugs(false);
        
        
        System.out.println("Testing test GetDrugs");
        ArrayList<Drug> list_of_drug_1_test = drugbankLibrary.getDrugs(true);
        
        
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
	public DrugbankLibrary() {
        this.databasePath = "drugbank.db";
        this.connectToDatabase(this.databasePath);
	}
	
    /**
     * Create a connection to the database file, stored explicitly somewhere.
     * @param databasePath The filename of the database file.
     */
	public DrugbankLibrary(String databasePath) {
        this.databasePath = databasePath;
        this.connectToDatabase(this.databasePath);
	}
    
    
    
    /**
     * Returns data about all the drugs in the database.
    
     * @return a list[drug]
     */
	public ArrayList<Drug> getDrugs() {
        return this.getDrugs(true);
    }
    
    
    /**
     * Returns data about all the drugs in the database.
    
     * @return a list[drug]
     */
	public ArrayList<Drug> getDrugs(boolean test) {
        String query;
        if (test) {
            query = String.format("SELECT data FROM drugbank LIMIT %d", this.HARDWARE);
        } else {
            query = "SELECT data FROM drugbank";
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
        
        ArrayList<Drug> result = new ArrayList<Drug>();
        try {
            while (rs.next()) {
                String raw_result = rs.getString(1);
                Drug parsed = null;
                if (test) {
                    parsed = new Drug((JSONObject)this.parser.parse(raw_result));
                    
                } else {
                    parsed = new Drug((JSONObject)this.parser.parse(raw_result));
                    
                }
                
                result.add(parsed);
                
            }
        } catch (SQLException e) {
            System.err.println("Could not iterate through query.");
    		e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Could not convert the response from getDrugs; a parser error occurred.");
    		e.printStackTrace();
        }
        return result;
	}
    
}