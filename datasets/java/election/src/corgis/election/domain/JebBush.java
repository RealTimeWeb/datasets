package corgis.election.domain;

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
public class JebBush {
	
    private String party;
    private Integer numberOfVotes;
    private Double percentOfVotes;
    
    
    /**
     * 
     * @return String
     */
    public String getParty() {
        return this.party;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getNumberOfVotes() {
        return this.numberOfVotes;
    }
    
    
    
    /**
     * 
     * @return Double
     */
    public Double getPercentOfVotes() {
        return this.percentOfVotes;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this JebBush.
	
	 * @return String
	 */
	public String toString() {
		return "JebBush[" +party+", "+numberOfVotes+", "+percentOfVotes+"]";
	}
	
	/**
	 * Internal constructor to create a JebBush from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public JebBush(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Party
            this.party = (String)json_data.get("Party");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a JebBush; the field party was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a JebBush; the field party had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Number of Votes
            this.numberOfVotes = ((Number)json_data.get("Number of Votes")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a JebBush; the field numberOfVotes was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a JebBush; the field numberOfVotes had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Percent of Votes
            this.percentOfVotes = ((Number)json_data.get("Percent of Votes")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a JebBush; the field percentOfVotes was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a JebBush; the field percentOfVotes had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}