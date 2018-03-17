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
	
    private Double daysAway;
    private Double daysAwayRestrictedTransfer;
    private Double totalCaseRate;
    
    
    /**
     * 
     * @return Double
     */
    public Double getDaysAway() {
        return this.daysAway;
    }
    
    
    
    /**
     * 
     * @return Double
     */
    public Double getDaysAwayRestrictedTransfer() {
        return this.daysAwayRestrictedTransfer;
    }
    
    
    
    /**
     * 
     * @return Double
     */
    public Double getTotalCaseRate() {
        return this.totalCaseRate;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Statistics.
	
	 * @return String
	 */
	public String toString() {
		return "Statistics[" +daysAway+", "+daysAwayRestrictedTransfer+", "+totalCaseRate+"]";
	}
	
	/**
	 * Internal constructor to create a Statistics from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Statistics(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // days away
            this.daysAway = ((Number)json_data.get("days away")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Statistics; the field daysAway was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Statistics; the field daysAway had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // days away/restricted/transfer
            this.daysAwayRestrictedTransfer = ((Number)json_data.get("days away/restricted/transfer")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Statistics; the field daysAwayRestrictedTransfer was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Statistics; the field daysAwayRestrictedTransfer had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // total case rate
            this.totalCaseRate = ((Number)json_data.get("total case rate")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Statistics; the field totalCaseRate was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Statistics; the field totalCaseRate had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}