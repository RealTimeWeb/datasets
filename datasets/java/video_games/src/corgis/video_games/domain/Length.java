package corgis.video_games.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.video_games.domain.MainStory;
import corgis.video_games.domain.AllPlaystyles;
import corgis.video_games.domain.MainPlusExtras;
import corgis.video_games.domain.Completionists;

/**
 * 
 */
public class Length {
	
    private MainStory mainStory;
    private AllPlaystyles allPlaystyles;
    private MainPlusExtras mainPlusExtras;
    private Completionists completionists;
    
    
    /**
     * 
     * @return MainStory
     */
    public MainStory getMainStory() {
        return this.mainStory;
    }
    
    
    
    /**
     * 
     * @return AllPlaystyles
     */
    public AllPlaystyles getAllPlaystyles() {
        return this.allPlaystyles;
    }
    
    
    
    /**
     * 
     * @return MainPlusExtras
     */
    public MainPlusExtras getMainPlusExtras() {
        return this.mainPlusExtras;
    }
    
    
    
    /**
     * 
     * @return Completionists
     */
    public Completionists getCompletionists() {
        return this.completionists;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Length.
	
	 * @return String
	 */
	public String toString() {
		return "Length[" +mainStory+", "+allPlaystyles+", "+mainPlusExtras+", "+completionists+"]";
	}
	
	/**
	 * Internal constructor to create a Length from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Length(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Main Story
            this.mainStory = new MainStory((JSONObject)json_data.get("Main Story"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Length; the field mainStory was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Length; the field mainStory had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // All PlayStyles
            this.allPlaystyles = new AllPlaystyles((JSONObject)json_data.get("All PlayStyles"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Length; the field allPlaystyles was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Length; the field allPlaystyles had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Main + Extras
            this.mainPlusExtras = new MainPlusExtras((JSONObject)json_data.get("Main + Extras"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Length; the field mainPlusExtras was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Length; the field mainPlusExtras had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Completionists
            this.completionists = new Completionists((JSONObject)json_data.get("Completionists"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Length; the field completionists was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Length; the field completionists had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}