package corgis.labor.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.labor.domain.Counts;
import corgis.labor.domain.ParticipationRate;

/**
 * 
 */
public class BlackOrAfricanAmerican {
	
    private Counts counts;
    private ParticipationRate participationRate;
    
    
    /**
     * 
     * @return Counts
     */
    public Counts getCounts() {
        return this.counts;
    }
    
    
    
    /**
     * 
     * @return ParticipationRate
     */
    public ParticipationRate getParticipationRate() {
        return this.participationRate;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this BlackOrAfricanAmerican.
	
	 * @return String
	 */
	public String toString() {
		return "BlackOrAfricanAmerican[" +counts+", "+participationRate+"]";
	}
	
	/**
	 * Internal constructor to create a BlackOrAfricanAmerican from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public BlackOrAfricanAmerican(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Counts
            this.counts = new Counts((JSONObject)json_data.get("Counts"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a BlackOrAfricanAmerican; the field counts was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a BlackOrAfricanAmerican; the field counts had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Participation Rate
            this.participationRate = new ParticipationRate((JSONObject)json_data.get("Participation Rate"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a BlackOrAfricanAmerican; the field participationRate was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a BlackOrAfricanAmerican; the field participationRate had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}