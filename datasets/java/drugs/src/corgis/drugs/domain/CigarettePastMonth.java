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
public class CigarettePastMonth {
	
    // The estimated number of people (in thousands) that have used Cigarettes in the past month, among this age group.
    private Integer twosixplus;
    // The estimated number of people (in thousands) that have used Cigarettes in the past month, among this age group.
    private Integer oneeightTwofive;
    // The estimated number of people (in thousands) that have used Cigarettes in the past month, among this age group.
    private Integer onetwoOneseven;
    
    
    /*
     * @return 
     */
    public Integer getTwosixplus() {
        return this.twosixplus;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getOneeightTwofive() {
        return this.oneeightTwofive;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getOnetwoOneseven() {
        return this.onetwoOneseven;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this CigarettePastMonth.
	
	 * @return String
	 */
	public String toString() {
		return "CigarettePastMonth[" +twosixplus+", "+oneeightTwofive+", "+onetwoOneseven+"]";
	}
	
	/**
	 * Internal constructor to create a CigarettePastMonth from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public CigarettePastMonth(JSONObject json_data) {
        try {// 26+
            this.twosixplus = ((Number)json_data.get("26+")).intValue();// 18-25
            this.oneeightTwofive = ((Number)json_data.get("18-25")).intValue();// 12-17
            this.onetwoOneseven = ((Number)json_data.get("12-17")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a CigarettePastMonth; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a CigarettePastMonth; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}