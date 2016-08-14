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
public class MartinOmalley {
	
    private String party;
    private Integer numberOfVotes;
    private Double percentOfVotes;
    
    
    /*
     * @return 
     */
    public String getParty() {
        return this.party;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getNumberOfVotes() {
        return this.numberOfVotes;
    }
    
    
    
    /*
     * @return 
     */
    public Double getPercentOfVotes() {
        return this.percentOfVotes;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this MartinO'Malley.
	
	 * @return String
	 */
	public String toString() {
		return "MartinO'Malley[" +party+", "+numberOfVotes+", "+percentOfVotes+"]";
	}
	
	/**
	 * Internal constructor to create a MartinO'Malley from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public MartinOmalley(JSONObject json_data) {
        try {// Party
            this.party = (String)json_data.get("Party");// Number of Votes
            this.numberOfVotes = new Integer(((Long)json_data.get("Number of Votes")).intValue());// Percent of Votes
            this.percentOfVotes = (Double)json_data.get("Percent of Votes");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a MartinO'Malley; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a MartinO'Malley; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}