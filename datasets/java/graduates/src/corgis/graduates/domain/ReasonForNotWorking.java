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
	
    // The number of people with a degree in this major during this year, who are not working because they were laid off.
    private Integer layoff;
    // The number of people with a degree in this major during this year, who are not working because of their family.
    private Integer family;
    // The number of people with a degree in this major during this year, who are not working because they were still a student.
    private Integer student;
    // The number of people with a degree in this major during this year, who are not working because they either did not need a job and/or did not want a job.
    private Integer noNeedWant;
    // The number of people with a degree in this major during this year, who are not working because there was no job available.
    private Integer noJobAvailable;
    
    
    /**
     * The number of people with a degree in this major during this year, who are not working because they were laid off.
     * @return Integer
     */
    public Integer getLayoff() {
        return this.layoff;
    }
    
    
    
    /**
     * The number of people with a degree in this major during this year, who are not working because of their family.
     * @return Integer
     */
    public Integer getFamily() {
        return this.family;
    }
    
    
    
    /**
     * The number of people with a degree in this major during this year, who are not working because they were still a student.
     * @return Integer
     */
    public Integer getStudent() {
        return this.student;
    }
    
    
    
    /**
     * The number of people with a degree in this major during this year, who are not working because they either did not need a job and/or did not want a job.
     * @return Integer
     */
    public Integer getNoNeedWant() {
        return this.noNeedWant;
    }
    
    
    
    /**
     * The number of people with a degree in this major during this year, who are not working because there was no job available.
     * @return Integer
     */
    public Integer getNoJobAvailable() {
        return this.noJobAvailable;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this ReasonForNotWorking.
	
	 * @return String
	 */
	public String toString() {
		return "ReasonForNotWorking[" +layoff+", "+family+", "+student+", "+noNeedWant+", "+noJobAvailable+"]";
	}
	
	/**
	 * Internal constructor to create a ReasonForNotWorking from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public ReasonForNotWorking(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Layoff
            this.layoff = ((Number)json_data.get("Layoff")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a ReasonForNotWorking; the field layoff was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a ReasonForNotWorking; the field layoff had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Family
            this.family = ((Number)json_data.get("Family")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a ReasonForNotWorking; the field family was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a ReasonForNotWorking; the field family had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Student
            this.student = ((Number)json_data.get("Student")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a ReasonForNotWorking; the field student was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a ReasonForNotWorking; the field student had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // No need/want
            this.noNeedWant = ((Number)json_data.get("No need/want")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a ReasonForNotWorking; the field noNeedWant was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a ReasonForNotWorking; the field noNeedWant had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // No Job Available
            this.noJobAvailable = ((Number)json_data.get("No Job Available")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a ReasonForNotWorking; the field noJobAvailable was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a ReasonForNotWorking; the field noJobAvailable had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}