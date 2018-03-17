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
	
    // The number of times this book has been downloaded from Project Gutenberg, as of the last update (circa Spring 2016).
    private Integer downloads;
    // The rank of this book in comparison to other books on Gutenberg, measured by number of downloads. A lower rank indicatest that that book is more popular.
    private Integer rank;
    private String url;
    private Formats formats;
    // Every book on Project Gutenberg has a unique ID number. You can use this number to check the book on project gutenberg (e.g., book 110 is <a href="http://www.gutenberg.org/ebooks/110">http://www.gutenberg.org/ebooks/110</a>).
    private Integer id;
    
    
    /**
     * The number of times this book has been downloaded from Project Gutenberg, as of the last update (circa Spring 2016).
     * @return Integer
     */
    public Integer getDownloads() {
        return this.downloads;
    }
    
    
    
    /**
     * The rank of this book in comparison to other books on Gutenberg, measured by number of downloads. A lower rank indicatest that that book is more popular.
     * @return Integer
     */
    public Integer getRank() {
        return this.rank;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getUrl() {
        return this.url;
    }
    
    
    
    /**
     * 
     * @return Formats
     */
    public Formats getFormats() {
        return this.formats;
    }
    
    
    
    /**
     * Every book on Project Gutenberg has a unique ID number. You can use this number to check the book on project gutenberg (e.g., book 110 is <a href="http://www.gutenberg.org/ebooks/110">http://www.gutenberg.org/ebooks/110</a>).
     * @return Integer
     */
    public Integer getId() {
        return this.id;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Metadata.
	
	 * @return String
	 */
	public String toString() {
		return "Metadata[" +downloads+", "+rank+", "+url+", "+formats+", "+id+"]";
	}
	
	/**
	 * Internal constructor to create a Metadata from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Metadata(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // downloads
            this.downloads = ((Number)json_data.get("downloads")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Metadata; the field downloads was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Metadata; the field downloads had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // rank
            this.rank = ((Number)json_data.get("rank")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Metadata; the field rank was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Metadata; the field rank had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // url
            this.url = (String)json_data.get("url");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Metadata; the field url was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Metadata; the field url had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // formats
            this.formats = new Formats((JSONObject)json_data.get("formats"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Metadata; the field formats was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Metadata; the field formats had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // id
            this.id = ((Number)json_data.get("id")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Metadata; the field id was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Metadata; the field id had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}