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
public class MainStory {
	
    // The number of players that reported completing the main game storyline.
    private Integer polled;
    // The mean time that players reported completing the main game storyline, in hours.
    private Double average;
    // The slowest time that players reported completing the main game storyline, in hours.
    private Double leisure;
    // The fastest time that players reported completing the main game storyline, in hours.
    private Double rushed;
    // The median time that players reported completing the main game storyline, in hours.
    private Double median;
    
    
    /**
     * The number of players that reported completing the main game storyline.
     * @return Integer
     */
    public Integer getPolled() {
        return this.polled;
    }
    
    
    
    /**
     * The mean time that players reported completing the main game storyline, in hours.
     * @return Double
     */
    public Double getAverage() {
        return this.average;
    }
    
    
    
    /**
     * The slowest time that players reported completing the main game storyline, in hours.
     * @return Double
     */
    public Double getLeisure() {
        return this.leisure;
    }
    
    
    
    /**
     * The fastest time that players reported completing the main game storyline, in hours.
     * @return Double
     */
    public Double getRushed() {
        return this.rushed;
    }
    
    
    
    /**
     * The median time that players reported completing the main game storyline, in hours.
     * @return Double
     */
    public Double getMedian() {
        return this.median;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this MainStory.
	
	 * @return String
	 */
	public String toString() {
		return "MainStory[" +polled+", "+average+", "+leisure+", "+rushed+", "+median+"]";
	}
	
	/**
	 * Internal constructor to create a MainStory from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public MainStory(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Polled
            this.polled = ((Number)json_data.get("Polled")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a MainStory; the field polled was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a MainStory; the field polled had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Average
            this.average = ((Number)json_data.get("Average")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a MainStory; the field average was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a MainStory; the field average had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Leisure
            this.leisure = ((Number)json_data.get("Leisure")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a MainStory; the field leisure was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a MainStory; the field leisure had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Rushed
            this.rushed = ((Number)json_data.get("Rushed")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a MainStory; the field rushed was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a MainStory; the field rushed had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Median
            this.median = ((Number)json_data.get("Median")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a MainStory; the field median was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a MainStory; the field median had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}