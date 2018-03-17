package corgis.classics.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.classics.domain.Metadata;
import corgis.classics.domain.Bibliography;
import corgis.classics.domain.Metrics;

/**
 * 
 */
public class Book {
	
    private Metadata metadata;
    private Bibliography bibliography;
    private Metrics metrics;
    
    
    /**
     * 
     * @return Metadata
     */
    public Metadata getMetadata() {
        return this.metadata;
    }
    
    
    
    /**
     * 
     * @return Bibliography
     */
    public Bibliography getBibliography() {
        return this.bibliography;
    }
    
    
    
    /**
     * 
     * @return Metrics
     */
    public Metrics getMetrics() {
        return this.metrics;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Book.
	
	 * @return String
	 */
	public String toString() {
		return "Book[" +metadata+", "+bibliography+", "+metrics+"]";
	}
	
	/**
	 * Internal constructor to create a Book from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Book(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // metadata
            this.metadata = new Metadata((JSONObject)json_data.get("metadata"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Book; the field metadata was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Book; the field metadata had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // bibliography
            this.bibliography = new Bibliography((JSONObject)json_data.get("bibliography"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Book; the field bibliography was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Book; the field bibliography had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // metrics
            this.metrics = new Metrics((JSONObject)json_data.get("metrics"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Book; the field metrics was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Book; the field metrics had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}