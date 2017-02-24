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
public class Status {
	
    // The number of people with a degree in this major during this year, who are not in the labor force (e.g., retired, students, those taking care of children).
    private Integer notInLaborForce;
    // The number of people with a degree in this major during this year, who are unemployed.
    private Integer unemployed;
    // The number of people with a degree in this major during this year, who are employed.
    private Integer employed;
    
    
    /*
     * @return 
     */
    public Integer getNotInLaborForce() {
        return this.notInLaborForce;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getUnemployed() {
        return this.unemployed;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getEmployed() {
        return this.employed;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Status.
	
	 * @return String
	 */
	public String toString() {
		return "Status[" +notInLaborForce+", "+unemployed+", "+employed+"]";
	}
	
	/**
	 * Internal constructor to create a Status from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Status(JSONObject json_data) {
        try {// Not in Labor Force
            this.notInLaborForce = ((Number)json_data.get("Not in Labor Force")).intValue();// Unemployed
            this.unemployed = ((Number)json_data.get("Unemployed")).intValue();// Employed
            this.employed = ((Number)json_data.get("Employed")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Status; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Status; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}