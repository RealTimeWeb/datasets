package corgis.tate.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.tate.domain.Artist;
import corgis.tate.domain.Data;
import corgis.tate.domain.Dimensions;
import corgis.tate.domain.Metadata;

/**
 * 
 */
public class Art {
	
    private Artist artist;
    private Data data;
    private Dimensions dimensions;
    private Metadata metadata;
    
    
    /*
     * @return 
     */
    public Artist getArtist() {
        return this.artist;
    }
    
    
    
    /*
     * @return 
     */
    public Data getData() {
        return this.data;
    }
    
    
    
    /*
     * @return 
     */
    public Dimensions getDimensions() {
        return this.dimensions;
    }
    
    
    
    /*
     * @return 
     */
    public Metadata getMetadata() {
        return this.metadata;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Art.
	
	 * @return String
	 */
	public String toString() {
		return "Art[" +artist+", "+data+", "+dimensions+", "+metadata+"]";
	}
	
	/**
	 * Internal constructor to create a Art from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Art(JSONObject json_data) {
        try {// artist
            this.artist = new Artist((JSONObject)json_data.get("artist"));// data
            this.data = new Data((JSONObject)json_data.get("data"));// dimensions
            this.dimensions = new Dimensions((JSONObject)json_data.get("dimensions"));// metadata
            this.metadata = new Metadata((JSONObject)json_data.get("metadata"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Art; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Art; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}