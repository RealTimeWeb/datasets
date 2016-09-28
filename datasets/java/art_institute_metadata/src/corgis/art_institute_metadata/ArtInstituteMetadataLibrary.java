package corgis.art_institute_metadata;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import corgis.art_institute_metadata.domain.*;

import java.sql.*;

/**
 * The Minneapolis Institute of Art's mission is to enrich the community by collecting, preserving, and making accessible outstanding works of art from the world's diverse cultures.  The following data contains information about the culture, location, and time period associated with the artist of the work in addition to descriptive information about the work as a whole.  Also added in information pertaining directly to information useful to the Minneapolis Institute of Art as it pertains to classification and location within the Institute.

 */
public class ArtInstituteMetadataLibrary {
    private String databasePath;
	private Connection connection;
    private JSONParser parser;
    private final int HARDWARE = 1000;
    
    public static void main(String[] args) {
        System.out.println("Testing ArtInstituteMetadata");
        ArtInstituteMetadataLibrary artInstituteMetadataLibrary = new ArtInstituteMetadataLibrary();
        
        
        System.out.println("Testing production GetRecords");
        ArrayList<Record> list_of_record_1_production = artInstituteMetadataLibrary.getRecords(false);
        
        
        System.out.println("Testing test GetRecords");
        ArrayList<Record> list_of_record_1_test = artInstituteMetadataLibrary.getRecords(true);
        
        
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
	public ArtInstituteMetadataLibrary() {
        this.databasePath = "art_institute_metadata.db";
        this.connectToDatabase(this.databasePath);
	}
	
    /**
     * Create a connection to the database file, stored explicitly somewhere.
     * @param databasePath The filename of the database file.
     */
	public ArtInstituteMetadataLibrary(String databasePath) {
        this.databasePath = databasePath;
        this.connectToDatabase(this.databasePath);
	}
    
    
    
    /**
     * Returns art data records from the dataset.
    
     * @return a list[record]
     */
	public ArrayList<Record> getRecords() {
        return this.getRecords(true);
    }
    
    
    /**
     * Returns art data records from the dataset.
    
     * @return a list[record]
     */
	public ArrayList<Record> getRecords(boolean test) {
        String query;
        if (test) {
            query = String.format("SELECT data FROM artdata LIMIT %d", this.HARDWARE);
        } else {
            query = "SELECT data FROM artdata";
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
            System.err.println("Could not convert the response from getRecords; a parser error occurred.");
    		e.printStackTrace();
        }
        return result;
	}
    
}