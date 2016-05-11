package corgis.music.domain;

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
	 * @param map The raw json data that will be parsed.
	 * @return 
	 */
    public Artist(JSONObject json_data) {
        try {
            this.terms_Freq = (Double)json_data.get("terms_freq");
            this.terms = (String)json_data.get("terms");
            this.name = (String)json_data.get("name");
            this.familiarity = (Double)json_data.get("familiarity");
            this.longitude = (Double)json_data.get("longitude");
            this.id = (String)json_data.get("id");
            this.location = (String)json_data.get("location");
            this.latitude = (Double)json_data.get("latitude");
            this.similar = (String)json_data.get("similar");
            this.hotttnesss = (Double)json_data.get("hotttnesss");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Artist; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Artist; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}