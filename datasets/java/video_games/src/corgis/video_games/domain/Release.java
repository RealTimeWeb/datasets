package corgis.video_games.domain;

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
public class Release {
	
    // The name of the console that this particular game was released for. Note that the dataset contains multiple copies of the same game, released for different consoles.
    private String console;
    // The ESRB rating for this game, either E (for Everyone), T (for Teen), or M (for Mature).
    private String rating;
    // Whether this game is a re-release of an earlier one.
    private Boolean reRelease;
    // The year that this game was released.
    private Integer year;
    
    
    /**
     * The name of the console that this particular game was released for. Note that the dataset contains multiple copies of the same game, released for different consoles.
     * @return String
     */
    public String getConsole() {
        return this.console;
    }
    
    
    
    /**
     * The ESRB rating for this game, either E (for Everyone), T (for Teen), or M (for Mature).
     * @return String
     */
    public String getRating() {
        return this.rating;
    }
    
    
    
    /**
     * Whether this game is a re-release of an earlier one.
     * @return Boolean
     */
    public Boolean getReRelease() {
        return this.reRelease;
    }
    
    
    
    /**
     * The year that this game was released.
     * @return Integer
     */
    public Integer getYear() {
        return this.year;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Release.
	
	 * @return String
	 */
	public String toString() {
		return "Release[" +console+", "+rating+", "+reRelease+", "+year+"]";
	}
	
	/**
	 * Internal constructor to create a Release from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Release(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Console
            this.console = (String)json_data.get("Console");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Release; the field console was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Release; the field console had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Rating
            this.rating = (String)json_data.get("Rating");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Release; the field rating was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Release; the field rating had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Re-release?
            this.reRelease = (Boolean)json_data.get("Re-release?");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Release; the field reRelease was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Release; the field reRelease had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Year
            this.year = ((Number)json_data.get("Year")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Release; the field year was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Release; the field year had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}