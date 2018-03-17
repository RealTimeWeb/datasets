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
	
    // The name of the artist.
    private String name;
    // The frequency of this term.
    private Double terms_Freq;
    // Unknown.
    private Double similar;
    // The term most associated with this artist.
    private String terms;
    // A measure of 0..1 for how familiar the artist is to listeners.
    private Double familiarity;
    // A unique ID for this artist.
    private String id;
    // The home location's latitude of this artist.
    private Integer latitude;
    // A measure of the artists's popularity, when downloaded (in December 2010). Measured on a scale of 0 to 1.
    private Double hotttnesss;
    // Unknown.
    private Integer location;
    // The home location's longitude of this artist.
    private Integer longitude;
    
    
    /*
     * @return 
     */
    public String getName() {
        return this.name;
    }
    
    
    
    /*
     * @return 
     */
    public Double getTerms_Freq() {
        return this.terms_Freq;
    }
    
    
    
    /*
     * @return 
     */
    public Double getSimilar() {
        return this.similar;
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
    public Double getFamiliarity() {
        return this.familiarity;
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
    public Integer getLatitude() {
        return this.latitude;
    }
    
    
    
    /*
     * @return 
     */
    public Double getHotttnesss() {
        return this.hotttnesss;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getLocation() {
        return this.location;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getLongitude() {
        return this.longitude;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Artist.
	
	 * @return String
	 */
	public String toString() {
		return "Artist[" +name+", "+terms_Freq+", "+similar+", "+terms+", "+familiarity+", "+id+", "+latitude+", "+hotttnesss+", "+location+", "+longitude+"]";
	}
	
	/**
	 * Internal constructor to create a Artist from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Artist(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // name
            this.name = (String)json_data.get("name");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Artist; the field name was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Artist; the field name had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // terms_freq
            this.terms_Freq = ((Number)json_data.get("terms_freq")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Artist; the field terms_Freq was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Artist; the field terms_Freq had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // similar
            this.similar = ((Number)json_data.get("similar")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Artist; the field similar was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Artist; the field similar had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // terms
            this.terms = (String)json_data.get("terms");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Artist; the field terms was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Artist; the field terms had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // familiarity
            this.familiarity = ((Number)json_data.get("familiarity")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Artist; the field familiarity was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Artist; the field familiarity had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // id
            this.id = (String)json_data.get("id");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Artist; the field id was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Artist; the field id had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // latitude
            this.latitude = ((Number)json_data.get("latitude")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Artist; the field latitude was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Artist; the field latitude had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // hotttnesss
            this.hotttnesss = ((Number)json_data.get("hotttnesss")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Artist; the field hotttnesss was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Artist; the field hotttnesss had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // location
            this.location = ((Number)json_data.get("location")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Artist; the field location was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Artist; the field location had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // longitude
            this.longitude = ((Number)json_data.get("longitude")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Artist; the field longitude was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Artist; the field longitude had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}