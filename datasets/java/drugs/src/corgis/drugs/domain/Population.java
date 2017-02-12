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
public class Population {
	
    // Estimated population for this age group (26 years old or older) in this year from US Census data for this state.
    private Integer twosixplus;
    // Estimated population for this age group (18 to 25 year olds) in this year from US Census data for this state.
    private Integer oneeightTwofive;
    // Estimated population for this age group (12 to 17 year olds) in this year from US Census data for this state.
    private Integer onetwoOneseven;
    // Estimated population for this age group (12 to 20 year olds) in this year from US Census data for this state.
    private Integer onetwoTwozero;
    
    
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
    
    
    
    /*
     * @return 
     */
    public Integer getOnetwoTwozero() {
        return this.onetwoTwozero;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Population.
	
	 * @return String
	 */
	public String toString() {
		return "Population[" +twosixplus+", "+oneeightTwofive+", "+onetwoOneseven+", "+onetwoTwozero+"]";
	}
	
	/**
	 * Internal constructor to create a Population from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Population(JSONObject json_data) {
        try {// 26+
            this.twosixplus = ((Number)json_data.get("26+")).intValue();// 18-25
            this.oneeightTwofive = ((Number)json_data.get("18-25")).intValue();// 12-17
            this.onetwoOneseven = ((Number)json_data.get("12-17")).intValue();// 12-20
            this.onetwoTwozero = ((Number)json_data.get("12-20")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Population; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Population; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}