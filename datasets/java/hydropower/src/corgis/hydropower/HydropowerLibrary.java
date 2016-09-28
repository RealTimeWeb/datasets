package corgis.hydropower;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import corgis.hydropower.domain.*;

import java.sql.*;

/**
 * Recent Federal policies and legislation focus on moving the nation towards a cleaner energy economy that includes developing environmentally appropriate renewable energy projects involving solar, wind and waves, geothermal, biofuels, and hydropower.  The 2010 Federal Memorandum of Understanding for Hydropower and the Energy Policy Act of 2005 direct the U.S. Department of Reclamation to evaluate development of new hydropower projects at Federally-owned facilities and upgrade or rehabilitate existing hydropower generation facilities, as a contribution to the nation's clean energy goals.  The following data describes the facilities currently being operated that contribute to nationwide renewable energy strategies.

 */
public class HydropowerLibrary {
    private String databasePath;
	private Connection connection;
    private JSONParser parser;
    private final int HARDWARE = 1000;
    
    public static void main(String[] args) {
        System.out.println("Testing Hydropower");
        HydropowerLibrary hydropowerLibrary = new HydropowerLibrary();
        
        
        System.out.println("Testing production GetDams");
        ArrayList<Dam> list_of_dam_1_production = hydropowerLibrary.getDams();
        
        
        
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
	public HydropowerLibrary() {
        this.databasePath = "hydropower.db";
        this.connectToDatabase(this.databasePath);
	}
	
    /**
     * Create a connection to the database file, stored explicitly somewhere.
     * @param databasePath The filename of the database file.
     */
	public HydropowerLibrary(String databasePath) {
        this.databasePath = databasePath;
        this.connectToDatabase(this.databasePath);
	}
    
    
    
    
    /**
     * Returns dams from the dataset.
    
     * @return a list[dam]
     */
	public ArrayList<Dam> getDams() {
        String query;
        boolean test = false;
        if (test) {
            query = String.format("", this.HARDWARE);
        } else {
            query = "SELECT data FROM hydropower";
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
        
        ArrayList<Dam> result = new ArrayList<Dam>();
        try {
            while (rs.next()) {
                String raw_result = rs.getString(1);
                Dam parsed = null;
                if (test) {
                    
                } else {
                    parsed = new Dam(((JSONObject)this.parser.parse(raw_result)));
                    
                }
                
                result.add(parsed);
                
            }
        } catch (SQLException e) {
            System.err.println("Could not iterate through query.");
    		e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Could not convert the response from getDams; a parser error occurred.");
    		e.printStackTrace();
        }
        return result;
	}
    
}