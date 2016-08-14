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
    // The number of times this book has been downloaded from Project Gutenberg, as of the last update (circa Spring 2016).
    private Integer downloads;
    // Every book on Project Gutenberg has a unique ID number. You can use this number to check the book on project gutenberg (e.g., book 110 is http://www.gutenberg.org/ebooks/110).
    private Integer id;
    // The rank of this book in comparison to other books on Gutenberg, measured by number of downloads. A lower rank indicatest that that book is more popular.
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
	 * @param json_data The raw json data that will be parsed.
	 */
    public Metadata(JSONObject json_data) {
        try {// url
            this.url = (String)json_data.get("url");// downloads
            this.downloads = new Integer(((Long)json_data.get("downloads")).intValue());// id
            this.id = new Integer(((Long)json_data.get("id")).intValue());// rank
            this.rank = new Integer(((Long)json_data.get("rank")).intValue());// formats
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