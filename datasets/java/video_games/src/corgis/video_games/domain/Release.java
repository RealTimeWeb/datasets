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
	
    // The ESRB rating for this game, either E (for Everyone), T (for Teen), or M (for Mature).
    private String rating;
    // The name of the console that this particular game was released for. Note that the dataset contains multiple copies of the same game, released for different consoles.
    private String console;
    // Whether this game is a re-release of an earlier one.
    private Boolean reRelease;
    // The year that this game was released.
    private Integer year;
    
    
    /*
     * @return 
     */
    public String getRating() {
        return this.rating;
    }
    
    
    
    /*
     * @return 
     */
    public String getConsole() {
        return this.console;
    }
    
    
    
    /*
     * @return 
     */
    public Boolean getReRelease() {
        return this.reRelease;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getYear() {
        return this.year;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Release.
	
	 * @return String
	 */
	public String toString() {
		return "Release[" +rating+", "+console+", "+reRelease+", "+year+"]";
	}
	
	/**
	 * Internal constructor to create a Release from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Release(JSONObject json_data) {
        try {// Rating
            this.rating = (String)json_data.get("Rating");// Console
            this.console = (String)json_data.get("Console");// Re-release?
            this.reRelease = (Boolean)json_data.get("Re-release?");// Year
            this.year = ((Number)json_data.get("Year")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Release; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Release; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}