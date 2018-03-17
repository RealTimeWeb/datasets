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
public class Features {
	
    // The maximum number of players that can play this game.
    private Integer maxPlayers;
    // Whether this is a hand-held game.
    private Boolean handheld;
    // Whether this game supports online play.
    private Boolean online;
    // Whether this game is available on multiple platforms.
    private Boolean multiplatform;
    
    
    /**
     * The maximum number of players that can play this game.
     * @return Integer
     */
    public Integer getMaxPlayers() {
        return this.maxPlayers;
    }
    
    
    
    /**
     * Whether this is a hand-held game.
     * @return Boolean
     */
    public Boolean getHandheld() {
        return this.handheld;
    }
    
    
    
    /**
     * Whether this game supports online play.
     * @return Boolean
     */
    public Boolean getOnline() {
        return this.online;
    }
    
    
    
    /**
     * Whether this game is available on multiple platforms.
     * @return Boolean
     */
    public Boolean getMultiplatform() {
        return this.multiplatform;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Features.
	
	 * @return String
	 */
	public String toString() {
		return "Features[" +maxPlayers+", "+handheld+", "+online+", "+multiplatform+"]";
	}
	
	/**
	 * Internal constructor to create a Features from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Features(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Max Players
            this.maxPlayers = ((Number)json_data.get("Max Players")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Features; the field maxPlayers was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Features; the field maxPlayers had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Handheld?
            this.handheld = (Boolean)json_data.get("Handheld?");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Features; the field handheld was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Features; the field handheld had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Online?
            this.online = (Boolean)json_data.get("Online?");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Features; the field online was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Features; the field online had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Multiplatform?
            this.multiplatform = (Boolean)json_data.get("Multiplatform?");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Features; the field multiplatform was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Features; the field multiplatform had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}