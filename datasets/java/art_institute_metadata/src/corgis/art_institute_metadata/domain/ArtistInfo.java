package corgis.art_institute_metadata.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


/**
 * 
 */
public class ArtistInfo {
	
    // Their country of origin.
    private String country;
    // The continent they were born on.
    private String continent;
    // The range of time they have lived so far, represented as a string like "Nationality, Birth - Death".
    private String yearsLiving;
    // The name of the artist
    private String artist;
    // The artists' nationality.
    private String nationality;
    
    
    /*
     * @return 
     */
    public String getCountry() {
        return this.country;
    }
    
    
    
    /*
     * @return 
     */
    public String getContinent() {
        return this.continent;
    }
    
    
    
    /*
     * @return 
     */
    public String getYearsLiving() {
        return this.yearsLiving;
    }
    
    
    
    /*
     * @return 
     */
    public String getArtist() {
        return this.artist;
    }
    
    
    
    /*
     * @return 
     */
    public String getNationality() {
        return this.nationality;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this ArtistInfo.
	
	 * @return String
	 */
	public String toString() {
		return "ArtistInfo[" +country+", "+continent+", "+yearsLiving+", "+artist+", "+nationality+"]";
	}
	
	/**
	 * Internal constructor to create a ArtistInfo from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public ArtistInfo(JSONObject json_data) {
        try {// Country
            this.country = (String)json_data.get("Country");// Continent
            this.continent = (String)json_data.get("Continent");// Years Living
            this.yearsLiving = (String)json_data.get("Years Living");// Artist
            this.artist = (String)json_data.get("Artist");// Nationality
            this.nationality = (String)json_data.get("Nationality");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a ArtistInfo; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a ArtistInfo; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}