package corgis.suicide_attacks;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import corgis.suicide_attacks.domain.*;

import java.sql.*;

/**
 * The Chicago Project on Security and Terrorism (CPOST) maintains a searchable database on all suicide attacks from 1982 through September 2015. The database includes information about the location of attacks, the target type, the weapon used, and systematic information on the demographic and general biographical characteristics of suicide attackers. The database expands the breadth of the data available in English using native language sources (e.g., Arabic, Hebrew, Russian, Tamil) that are likely to have the most extensive relevant information.
The current CPOST-SAD release contains the universe of suicide attacks from 1982 through September 2015, a total of 4,814 attacks in over 40 countries. The CPOST Suicide Attack Database (CPOST-SAD) contains data on the universe of suicide attacks. For each attack, the database includes information about the geographic location, target classification, and weapon(s) used, as well as systematic information on the demographic and general biographical characteristics of suicide attackers. More information about the coding and methodology is available on the CPOST website below.
Note that multiple attackers or targets are collapsed into a single record for simplicity's sake.

 */
public class SuicideAttacksLibrary {
    private String databasePath;
	private Connection connection;
    private JSONParser parser;
    private final int HARDWARE = 1000;
    
    public static void main(String[] args) {
        System.out.println("Testing SuicideAttacks");
        SuicideAttacksLibrary suicideAttacksLibrary = new SuicideAttacksLibrary();
        
        
        System.out.println("Testing production GetAttacks");
        ArrayList<Attack> list_of_attack_1_production = suicideAttacksLibrary.getAttacks(false);
        
        
        System.out.println("Testing test GetAttacks");
        ArrayList<Attack> list_of_attack_1_test = suicideAttacksLibrary.getAttacks(true);
        
        
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
	public SuicideAttacksLibrary() {
        this.databasePath = "suicide_attacks.db";
        this.connectToDatabase(this.databasePath);
	}
	
    /**
     * Create a connection to the database file, stored explicitly somewhere.
     * @param databasePath The filename of the database file.
     */
	public SuicideAttacksLibrary(String databasePath) {
        this.databasePath = databasePath;
        this.connectToDatabase(this.databasePath);
	}
    
    
    
    /**
     * Returns a list of the attacks in the database.
    
     * @return a list[attack]
     */
	public ArrayList<Attack> getAttacks() {
        return this.getAttacks(true);
    }
    
    
    /**
     * Returns a list of the attacks in the database.
    
     * @return a list[attack]
     */
	public ArrayList<Attack> getAttacks(boolean test) {
        String query;
        if (test) {
            query = String.format("SELECT data FROM suicide_attacks LIMIT %d", this.HARDWARE);
        } else {
            query = "SELECT data FROM suicide_attacks";
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
        
        ArrayList<Attack> result = new ArrayList<Attack>();
        try {
            while (rs.next()) {
                String raw_result = rs.getString(1);
                Attack parsed = null;
                if (test) {
                    parsed = new Attack(((JSONObject)this.parser.parse(raw_result)));
                    
                } else {
                    parsed = new Attack(((JSONObject)this.parser.parse(raw_result)));
                    
                }
                
                result.add(parsed);
                
            }
        } catch (SQLException e) {
            System.err.println("Could not iterate through query.");
    		e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Could not convert the response from getAttacks; a parser error occurred.");
    		e.printStackTrace();
        }
        return result;
	}
    
}