package corgis.drugs.domain;

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
public class BingePastMonth {
	
    // Percentage of the population that has binged on alcohol in the past month among this age group. Binge Alcohol Use is defined as drinking five or more drinks on the same occasion (i.e., at the same time or within a couple of hours of each other) on at least 1 day in the past 30 days.
    private Double twosixplus;
    // Percentage of the population that has binged on alcohol in the past month among this age group. Binge Alcohol Use is defined as drinking five or more drinks on the same occasion (i.e., at the same time or within a couple of hours of each other) on at least 1 day in the past 30 days.
    private Double oneeightTwofive;
    // Percentage of the population that has binged on alcohol in the past month among this age group. Binge Alcohol Use is defined as drinking five or more drinks on the same occasion (i.e., at the same time or within a couple of hours of each other) on at least 1 day in the past 30 days.
    private Double onetwoOneseven;
    
    
    /*
     * @return 
     */
    public Double getTwosixplus() {
        return this.twosixplus;
    }
    
    
    
    /*
     * @return 
     */
    public Double getOneeightTwofive() {
        return this.oneeightTwofive;
    }
    
    
    
    /*
     * @return 
     */
    public Double getOnetwoOneseven() {
        return this.onetwoOneseven;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this BingePastMonth.
	
	 * @return String
	 */
	public String toString() {
		return "BingePastMonth[" +twosixplus+", "+oneeightTwofive+", "+onetwoOneseven+"]";
	}
	
	/**
	 * Internal constructor to create a BingePastMonth from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public BingePastMonth(JSONObject json_data) {
        try {// 26+
            this.twosixplus = ((Number)json_data.get("26+")).doubleValue();// 18-25
            this.oneeightTwofive = ((Number)json_data.get("18-25")).doubleValue();// 12-17
            this.onetwoOneseven = ((Number)json_data.get("12-17")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a BingePastMonth; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a BingePastMonth; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}