package corgis.classics.domain;

import java.util.List;
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
        try {// Url
            this.url = (String)json_data.get("Url");// Downloads
            this.downloads = new Integer(((Long)json_data.get("Downloads")).intValue());// ID
            this.id = new Integer(((Long)json_data.get("ID")).intValue());// Rank
            this.rank = new Integer(((Long)json_data.get("Rank")).intValue());// Formats
            this.formats = new Formats((JSONObject)json_data.get("Formats"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Metadata; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Metadata; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}