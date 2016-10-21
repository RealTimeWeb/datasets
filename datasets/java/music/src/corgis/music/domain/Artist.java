package corgis.music.domain;

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
public class Artist {
	
    private Double terms_Freq;
    private String terms;
    private String name;
    private Double familiarity;
    private Double longitude;
    private String id;
    private String location;
    private Double latitude;
    private String similar;
    private Double hotttnesss;
    
    
    /*
     * @return 
     */
    public Double getTerms_Freq() {
        return this.terms_Freq;
    }
    
    
    
    /*
     * @return 
     */
    public String getTerms() {
        return this.terms;
    }
    
    
    
    /*
     * @return 
     */
    public String getName() {
        return this.name;
    }
    
    
    
    /*
     * @return 
     */
    public Double getFamiliarity() {
        return this.familiarity;
    }
    
    
    
    /*
     * @return 
     */
    public Double getLongitude() {
        return this.longitude;
    }
    
    
    
    /*
     * @return 
     */
    public String getId() {
        return this.id;
    }
    
    
    
    /*
     * @return 
     */
    public String getLocation() {
        return this.location;
    }
    
    
    
    /*
     * @return 
     */
    public Double getLatitude() {
        return this.latitude;
    }
    
    
    
    /*
     * @return 
     */
    public String getSimilar() {
        return this.similar;
    }
    
    
    
    /*
     * @return 
     */
    public Double getHotttnesss() {
        return this.hotttnesss;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Artist.
	
	 * @return String
	 */
	public String toString() {
		return "Artist[" +terms_Freq+", "+terms+", "+name+", "+familiarity+", "+longitude+", "+id+", "+location+", "+latitude+", "+similar+", "+hotttnesss+"]";
	}
	
	/**
	 * Internal constructor to create a Artist from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Artist(JSONObject json_data) {
        try {// terms_freq
            this.terms_Freq = ((Number)json_data.get("terms_freq")).doubleValue();// terms
            this.terms = (String)json_data.get("terms");// name
            this.name = (String)json_data.get("name");// familiarity
            this.familiarity = ((Number)json_data.get("familiarity")).doubleValue();// longitude
            this.longitude = ((Number)json_data.get("longitude")).doubleValue();// id
            this.id = (String)json_data.get("id");// location
            this.location = (String)json_data.get("location");// latitude
            this.latitude = ((Number)json_data.get("latitude")).doubleValue();// similar
            this.similar = (String)json_data.get("similar");// hotttnesss
            this.hotttnesss = ((Number)json_data.get("hotttnesss")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Artist; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Artist; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}