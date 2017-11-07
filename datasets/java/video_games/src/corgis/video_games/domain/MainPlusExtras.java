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
public class MainPlusExtras {
	
    // The mean time that players reported completing the main game and major extra parts of the game, in hours.
    private Double average;
    // The median time that players reported completing the main game and major extra parts of the game, in hours.
    private Double median;
    // The number of players that reported completing the main game and major extra parts of the game.
    private Integer polled;
    // The slowest time that players reported completing the main game and major extra parts of the game, in hours.
    private Double leisure;
    // The fastest time that players reported completing the main game and major extra parts of the game, in hours.
    private Double rushed;
    
    
    /*
     * @return 
     */
    public Double getAverage() {
        return this.average;
    }
    
    
    
    /*
     * @return 
     */
    public Double getMedian() {
        return this.median;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getPolled() {
        return this.polled;
    }
    
    
    
    /*
     * @return 
     */
    public Double getLeisure() {
        return this.leisure;
    }
    
    
    
    /*
     * @return 
     */
    public Double getRushed() {
        return this.rushed;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Main+Extras.
	
	 * @return String
	 */
	public String toString() {
		return "Main+Extras[" +average+", "+median+", "+polled+", "+leisure+", "+rushed+"]";
	}
	
	/**
	 * Internal constructor to create a Main+Extras from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public MainPlusExtras(JSONObject json_data) {
        try {// Average
            this.average = ((Number)json_data.get("Average")).doubleValue();// Median
            this.median = ((Number)json_data.get("Median")).doubleValue();// Polled
            this.polled = ((Number)json_data.get("Polled")).intValue();// Leisure
            this.leisure = ((Number)json_data.get("Leisure")).doubleValue();// Rushed
            this.rushed = ((Number)json_data.get("Rushed")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Main+Extras; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Main+Extras; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}