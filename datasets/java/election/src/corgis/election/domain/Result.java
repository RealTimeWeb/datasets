package corgis.election.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.election.domain.Location;
import corgis.election.domain.VoteData;

/**
 * 
 */
public class Result {
	
    private Location location;
    private VoteData voteData;
    
    
    /**
     * 
     * @return Location
     */
    public Location getLocation() {
        return this.location;
    }
    
    
    
    /**
     * 
     * @return VoteData
     */
    public VoteData getVoteData() {
        return this.voteData;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Result.
	
	 * @return String
	 */
	public String toString() {
		return "Result[" +location+", "+voteData+"]";
	}
	
	/**
	 * Internal constructor to create a Result from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Result(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Location
            this.location = new Location((JSONObject)json_data.get("Location"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Result; the field location was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Result; the field location had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Vote Data
            this.voteData = new VoteData((JSONObject)json_data.get("Vote Data"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Result; the field voteData was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Result; the field voteData had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}