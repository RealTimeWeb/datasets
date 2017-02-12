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
public class AbusePastYear {
	
    // The estimated number of people (in thousands) that have a dependence on or abused alcohol in the past year among this age group. Dependence or abuse is based on definitions found in the 4th edition of the Diagnostic and Statistical Manual of Mental Disorders (DSM-IV).
    private Integer twosixplus;
    // The estimated number of people (in thousands) that have a dependence on or abused alcohol in the past year among this age group. Dependence or abuse is based on definitions found in the 4th edition of the Diagnostic and Statistical Manual of Mental Disorders (DSM-IV).
    private Integer oneeightTwofive;
    // The estimated number of people (in thousands) that have a dependence on or abused alcohol in the past year among this age group. Dependence or abuse is based on definitions found in the 4th edition of the Diagnostic and Statistical Manual of Mental Disorders (DSM-IV).
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
	 * Creates a string based representation of this AbusePastYear.
	
	 * @return String
	 */
	public String toString() {
		return "AbusePastYear[" +twosixplus+", "+oneeightTwofive+", "+onetwoOneseven+"]";
	}
	
	/**
	 * Internal constructor to create a AbusePastYear from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public AbusePastYear(JSONObject json_data) {
        try {// 26+
            this.twosixplus = ((Number)json_data.get("26+")).intValue();// 18-25
            this.oneeightTwofive = ((Number)json_data.get("18-25")).intValue();// 12-17
            this.onetwoOneseven = ((Number)json_data.get("12-17")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a AbusePastYear; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a AbusePastYear; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}