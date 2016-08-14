package corgis.johnsongrass;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import corgis.johnsongrass.domain.*;

import java.sql.*;

/**
 * {'overview': "~500 Johnsongrass genotypes were collected from 70 sites throughout the USA and grown in a common garden in Blacksburg. Height and biomass were recorded at the end of the growing season. The growth of each genotype can be related to the habitat it was collected in, the temperature and precipitation of its homesite, whether it was collected in an agricultural habitat, and which genetic cluster the genotype belongs to.\nThis dataset was created and published by Daniel Z. Atwater, U. Uzay Sezen, Valorie Goff, Wenqian Kong, Andrew H. Paterson and Jacob N. Barney.  Their website is at <a href='https://weedeco.ppws.vt.edu/'>https://weedeco.ppws.vt.edu/</a>.\n", 'short': 'This dataset comes from Plant Genome Mapping Laboratory of Virginia Tech. It is about Johnson Grass collected around the region.', 'citation': "Atwater, Daniel Z., et al. 'Reconstructing changes in the genotype, phenotype, and climatic niche of an introduced species.' Ecography (2015)."}
 */
public class JohnsonGrassLibrary {
    private String databasePath;
	private Connection connection;
    private JSONParser parser;
    private final int HARDWARE = 1000;
    
    public static void main(String[] args) {
        System.out.println("Testing JohnsonGrass");
        JohnsonGrassLibrary johnsonGrassLibrary = new JohnsonGrassLibrary();
        
        
        System.out.println("Testing production GetJohnsongrass");
        ArrayList<Johnsongrass> list_of_johnsongrass_1_production = johnsonGrassLibrary.getJohnsongrass();
        
        
        
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
	public JohnsonGrassLibrary() {
        this.databasePath = "johnsongrass.db";
        this.connectToDatabase(this.databasePath);
	}
	
    /**
     * Create a connection to the database file, stored explicitly somewhere.
     * @param databasePath The filename of the database file.
     */
	public JohnsonGrassLibrary(String databasePath) {
        this.databasePath = databasePath;
        this.connectToDatabase(this.databasePath);
	}
    
    
    
    
    /**
     * Returns a list of the johnsongrass in the database.
    
     * @return a list[johnsongrass]
     */
	public ArrayList<Johnsongrass> getJohnsongrass() {
        String query;
        boolean test = false;
        if (test) {
            query = String.format("", this.HARDWARE);
        } else {
            query = "SELECT data FROM johnsongrass";
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
        
        ArrayList<Johnsongrass> result = new ArrayList<Johnsongrass>();
        try {
            while (rs.next()) {
                String raw_result = rs.getString(1);
                Johnsongrass parsed = null;
                if (test) {
                    
                } else {
                    parsed = new Johnsongrass((JSONObject)this.parser.parse(raw_result));
                    
                }
                
                result.add(parsed);
                
            }
        } catch (SQLException e) {
            System.err.println("Could not iterate through query.");
    		e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Could not convert the response from getJohnsongrass; a parser error occurred.");
    		e.printStackTrace();
        }
        return result;
	}
    
}