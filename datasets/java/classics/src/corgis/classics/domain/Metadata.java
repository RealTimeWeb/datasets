package corgis.classics.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.classics.domain.Formats;

/**
 * 
 */
public class Metadata {
	
    private String url;
    private Integer downloads;
    private Integer id;
    private Integer rank;
    private Formats formats;
    
    
    /*
     * @return 
     */
    public String getUrl() {
        return this.url;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getDownloads() {
        return this.downloads;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getId() {
        return this.id;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getRank() {
        return this.rank;
    }
    
    
    
    /*
     * @return 
     */
    public Formats getFormats() {
        return this.formats;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Metadata.
	
	 * @return String
	 */
	public String toString() {
		return "Metadata[" +url+", "+downloads+", "+id+", "+rank+", "+formats+"]";
	}
	
	/**
	 * Internal constructor to create a Metadata from a  representation.
	 * @param map The raw json data that will be parsed.
	 * @return 
	 */
    public Metadata(JSONObject json_data) {
        try {
            this.url = (String)json_data.get("url");
            this.downloads = (Integer)json_data.get("downloads");
            this.id = (Integer)json_data.get("id");
            this.rank = (Integer)json_data.get("rank");
            this.formats = new Formats((JSONObject)json_data.get("formats"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Metadata; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Metadata; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}