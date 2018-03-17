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
	
    private Integer longitude;
    private Double similar;
    private String name;
    private Double hotttnesss;
    private Integer latitude;
    private Double terms_Freq;
    private String id;
    private String terms;
    private Integer location;
    private Double familiarity;
    
    
    /*
     * @return 
     */
    public Integer getLongitude() {
        return this.longitude;
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
    public String getName() {
        return this.name;
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
    public Integer getLatitude() {
        return this.latitude;
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
    public String getId() {
        return this.id;
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
    public Integer getLocation() {
        return this.location;
    }
    
    
    
    /*
     * @return 
     */
    public Double getFamiliarity() {
        return this.familiarity;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Artist.
	
	 * @return String
	 */
	public String toString() {
		return "Artist[" +longitude+", "+similar+", "+name+", "+hotttnesss+", "+latitude+", "+terms_Freq+", "+id+", "+terms+", "+location+", "+familiarity+"]";
	}
	
	/**
	 * Internal constructor to create a Artist from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Artist(JSONObject json_data) {
        //System.out.println(json_data);
        
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
            // familiarity
            this.familiarity = ((Number)json_data.get("familiarity")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Artist; the field familiarity was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Artist; the field familiarity had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}