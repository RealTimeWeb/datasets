package corgis.video_games.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.video_games.domain.Features;
import corgis.video_games.domain.Metrics;
import corgis.video_games.domain.Length;
import corgis.video_games.domain.Release;
import corgis.video_games.domain.Metadata;

/**
 * 
 */
public class VideoGame {
	
    private Features features;
    // The full title of this game.
    private String title;
    private Metrics metrics;
    private Length length;
    private Release release;
    private Metadata metadata;
    
    
    /*
     * @return 
     */
    public Features getFeatures() {
        return this.features;
    }
    
    
    
    /*
     * @return 
     */
    public String getTitle() {
        return this.title;
    }
    
    
    
    /*
     * @return 
     */
    public Metrics getMetrics() {
        return this.metrics;
    }
    
    
    
    /*
     * @return 
     */
    public Length getLength() {
        return this.length;
    }
    
    
    
    /*
     * @return 
     */
    public Release getRelease() {
        return this.release;
    }
    
    
    
    /*
     * @return 
     */
    public Metadata getMetadata() {
        return this.metadata;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this VideoGame.
	
	 * @return String
	 */
	public String toString() {
		return "VideoGame[" +features+", "+title+", "+metrics+", "+length+", "+release+", "+metadata+"]";
	}
	
	/**
	 * Internal constructor to create a VideoGame from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public VideoGame(JSONObject json_data) {
        try {// Features
            this.features = new Features((JSONObject)json_data.get("Features"));// Title
            this.title = (String)json_data.get("Title");// Metrics
            this.metrics = new Metrics((JSONObject)json_data.get("Metrics"));// Length
            this.length = new Length((JSONObject)json_data.get("Length"));// Release
            this.release = new Release((JSONObject)json_data.get("Release"));// Metadata
            this.metadata = new Metadata((JSONObject)json_data.get("Metadata"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a VideoGame; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a VideoGame; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}