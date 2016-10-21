package corgis.graduates.domain;

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
public class EarningsBreakdown {
	
    private Integer medianEarnings;
    private Integer sevenfivethPercentileOfEarnings;
    private Integer twofivethPercentileOfEarnings;
    
    
    /*
     * @return 
     */
    public Integer getMedianEarnings() {
        return this.medianEarnings;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getSevenfivethPercentileOfEarnings() {
        return this.sevenfivethPercentileOfEarnings;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getTwofivethPercentileOfEarnings() {
        return this.twofivethPercentileOfEarnings;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this EarningsBreakdown.
	
	 * @return String
	 */
	public String toString() {
		return "EarningsBreakdown[" +medianEarnings+", "+sevenfivethPercentileOfEarnings+", "+twofivethPercentileOfEarnings+"]";
	}
	
	/**
	 * Internal constructor to create a EarningsBreakdown from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public EarningsBreakdown(JSONObject json_data) {
        try {// Median Earnings
            this.medianEarnings = ((Number)json_data.get("Median Earnings")).intValue();// 75th Percentile of Earnings
            this.sevenfivethPercentileOfEarnings = ((Number)json_data.get("75th Percentile of Earnings")).intValue();// 25th Percentile of Earnings
            this.twofivethPercentileOfEarnings = ((Number)json_data.get("25th Percentile of Earnings")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a EarningsBreakdown; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a EarningsBreakdown; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}