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
public class ReasonForNotWorking {
	
    // The number of people with a degree in this major during this year, who are not working because they either did not need a job and/or did not want a job.
    private Integer noNeedWant;
    // The number of people with a degree in this major during this year, who are not working because they were laid off.
    private Integer layoff;
    // The number of people with a degree in this major during this year, who are not working because of their family.
    private Integer family;
    // The number of people with a degree in this major during this year, who are not working because there was no job available.
    private Integer noJobAvailable;
    // The number of people with a degree in this major during this year, who are not working because they were still a student.
    private Integer student;
    
    
    /*
     * @return 
     */
    public Integer getNoNeedWant() {
        return this.noNeedWant;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getLayoff() {
        return this.layoff;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getFamily() {
        return this.family;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getNoJobAvailable() {
        return this.noJobAvailable;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getStudent() {
        return this.student;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this ReasonForNotWorking.
	
	 * @return String
	 */
	public String toString() {
		return "ReasonForNotWorking[" +noNeedWant+", "+layoff+", "+family+", "+noJobAvailable+", "+student+"]";
	}
	
	/**
	 * Internal constructor to create a ReasonForNotWorking from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public ReasonForNotWorking(JSONObject json_data) {
        try {// No need/want
            this.noNeedWant = ((Number)json_data.get("No need/want")).intValue();// Layoff
            this.layoff = ((Number)json_data.get("Layoff")).intValue();// Family
            this.family = ((Number)json_data.get("Family")).intValue();// No Job Available
            this.noJobAvailable = ((Number)json_data.get("No Job Available")).intValue();// Student
            this.student = ((Number)json_data.get("Student")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a ReasonForNotWorking; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a ReasonForNotWorking; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}