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
	
    // Whether this game supports online play.
    private Boolean online;
    // Whether this game is available on multiple platforms.
    private Boolean multiplatform;
    // The maximum number of players that can play this game.
    private Integer maxPlayers;
    // Whether this is a hand-held game.
    private Boolean handheld;
    
    
    /*
     * @return 
     */
    public Boolean getOnline() {
        return this.online;
    }
    
    
    
    /*
     * @return 
     */
    public Boolean getMultiplatform() {
        return this.multiplatform;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getMaxPlayers() {
        return this.maxPlayers;
    }
    
    
    
    /*
     * @return 
     */
    public Boolean getHandheld() {
        return this.handheld;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Features.
	
	 * @return String
	 */
	public String toString() {
		return "Features[" +online+", "+multiplatform+", "+maxPlayers+", "+handheld+"]";
	}
	
	/**
	 * Internal constructor to create a Features from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Features(JSONObject json_data) {
        try {// Online?
            this.online = (Boolean)json_data.get("Online?");// Multiplatform?
            this.multiplatform = (Boolean)json_data.get("Multiplatform?");// Max Players
            this.maxPlayers = ((Number)json_data.get("Max Players")).intValue();// Handheld?
            this.handheld = (Boolean)json_data.get("Handheld?");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Features; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Features; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}