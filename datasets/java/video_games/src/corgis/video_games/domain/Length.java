package corgis.video_games.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.video_games.domain.MainPlusExtras;
import corgis.video_games.domain.AllPlaystyles;
import corgis.video_games.domain.MainStory;
import corgis.video_games.domain.Completionists;

/**
 * 
 */
public class Length {
	
    private MainPlusExtras mainPlusExtras;
    private AllPlaystyles allPlaystyles;
    private MainStory mainStory;
    private Completionists completionists;
    
    
    /*
     * @return 
     */
    public MainPlusExtras getMainPlusExtras() {
        return this.mainPlusExtras;
    }
    
    
    
    /*
     * @return 
     */
    public AllPlaystyles getAllPlaystyles() {
        return this.allPlaystyles;
    }
    
    
    
    /*
     * @return 
     */
    public MainStory getMainStory() {
        return this.mainStory;
    }
    
    
    
    /*
     * @return 
     */
    public Completionists getCompletionists() {
        return this.completionists;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Length.
	
	 * @return String
	 */
	public String toString() {
		return "Length[" +mainPlusExtras+", "+allPlaystyles+", "+mainStory+", "+completionists+"]";
	}
	
	/**
	 * Internal constructor to create a Length from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Length(JSONObject json_data) {
        try {// Main + Extras
            this.mainPlusExtras = new MainPlusExtras((JSONObject)json_data.get("Main + Extras"));// All PlayStyles
            this.allPlaystyles = new AllPlaystyles((JSONObject)json_data.get("All PlayStyles"));// Main Story
            this.mainStory = new MainStory((JSONObject)json_data.get("Main Story"));// Completionists
            this.completionists = new Completionists((JSONObject)json_data.get("Completionists"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Length; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Length; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}