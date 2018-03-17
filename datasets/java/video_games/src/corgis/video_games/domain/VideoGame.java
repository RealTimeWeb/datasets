package corgis.video_games.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.video_games.domain.Metrics;
import corgis.video_games.domain.Release;
import corgis.video_games.domain.Features;
import corgis.video_games.domain.Length;
import corgis.video_games.domain.Metadata;

/**
 * 
 */
public class VideoGame {
	
    private Metrics metrics;
    private Release release;
    private Features features;
    // The full title of this game.
    private String title;
    private Length length;
    private Metadata metadata;
    
    
    /**
     * 
     * @return Metrics
     */
    public Metrics getMetrics() {
        return this.metrics;
    }
    
    
    
    /**
     * 
     * @return Release
     */
    public Release getRelease() {
        return this.release;
    }
    
    
    
    /**
     * 
     * @return Features
     */
    public Features getFeatures() {
        return this.features;
    }
    
    
    
    /**
     * The full title of this game.
     * @return String
     */
    public String getTitle() {
        return this.title;
    }
    
    
    
    /**
     * 
     * @return Length
     */
    public Length getLength() {
        return this.length;
    }
    
    
    
    /**
     * 
     * @return Metadata
     */
    public Metadata getMetadata() {
        return this.metadata;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this VideoGame.
	
	 * @return String
	 */
	public String toString() {
		return "VideoGame[" +metrics+", "+release+", "+features+", "+title+", "+length+", "+metadata+"]";
	}
	
	/**
	 * Internal constructor to create a VideoGame from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public VideoGame(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Metrics
            this.metrics = new Metrics((JSONObject)json_data.get("Metrics"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a VideoGame; the field metrics was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a VideoGame; the field metrics had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Release
            this.release = new Release((JSONObject)json_data.get("Release"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a VideoGame; the field release was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a VideoGame; the field release had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Features
            this.features = new Features((JSONObject)json_data.get("Features"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a VideoGame; the field features was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a VideoGame; the field features had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Title
            this.title = (String)json_data.get("Title");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a VideoGame; the field title was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a VideoGame; the field title had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Length
            this.length = new Length((JSONObject)json_data.get("Length"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a VideoGame; the field length was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a VideoGame; the field length had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Metadata
            this.metadata = new Metadata((JSONObject)json_data.get("Metadata"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a VideoGame; the field metadata was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a VideoGame; the field metadata had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}