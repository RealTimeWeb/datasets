package corgis.injuries.domain;

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
public class Statistics {
	
    private Double totalCaseRate;
    private Double daysAway;
    private Double daysAwayRestrictedTransfer;
    
    
    /*
     * @return 
     */
    public Double getTotalCaseRate() {
        return this.totalCaseRate;
    }
    
    
    
    /*
     * @return 
     */
    public Double getDaysAway() {
        return this.daysAway;
    }
    
    
    
    /*
     * @return 
     */
    public Double getDaysAwayRestrictedTransfer() {
        return this.daysAwayRestrictedTransfer;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Statistics.
	
	 * @return String
	 */
	public String toString() {
		return "Statistics[" +totalCaseRate+", "+daysAway+", "+daysAwayRestrictedTransfer+"]";
	}
	
	/**
	 * Internal constructor to create a Statistics from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Statistics(JSONObject json_data) {
        try {// total case rate
            this.totalCaseRate = (Double)json_data.get("total case rate");// days away
            this.daysAway = (Double)json_data.get("days away");// days away/restricted/transfer
            this.daysAwayRestrictedTransfer = (Double)json_data.get("days away/restricted/transfer");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Statistics; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Statistics; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}