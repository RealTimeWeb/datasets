package corgis.education.domain;

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
public class Funding {
	
    private Long expenditures;
    private Long revenue;
    
    
    /*
     * @return 
     */
    public Long getExpenditures() {
        return this.expenditures;
    }
    
    
    
    /*
     * @return 
     */
    public Long getRevenue() {
        return this.revenue;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Funding.
	
	 * @return String
	 */
	public String toString() {
		return "Funding[" +expenditures+", "+revenue+"]";
	}
	
	/**
	 * Internal constructor to create a Funding from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Funding(JSONObject json_data) {
        try {// expenditures
            this.expenditures = ((Number)json_data.get("expenditures")).longValue();// revenue
            this.revenue = ((Number)json_data.get("revenue")).longValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Funding; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Funding; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}