package corgis.classics.domain;

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
public class Sentiments {
	
    private Double polarity;
    private Double subjectivity;
    
    
    /*
     * @return 
     */
    public Double getPolarity() {
        return this.polarity;
    }
    
    
    
    /*
     * @return 
     */
    public Double getSubjectivity() {
        return this.subjectivity;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Sentiments.
	
	 * @return String
	 */
	public String toString() {
		return "Sentiments[" +polarity+", "+subjectivity+"]";
	}
	
	/**
	 * Internal constructor to create a Sentiments from a  representation.
	 * @param map The raw json data that will be parsed.
	 * @return 
	 */
    public Sentiments(JSONObject json_data) {
        try {
            this.polarity = (Double)json_data.get("polarity");
            this.subjectivity = (Double)json_data.get("subjectivity");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Sentiments; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Sentiments; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}