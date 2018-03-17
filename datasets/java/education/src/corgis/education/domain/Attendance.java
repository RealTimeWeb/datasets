package corgis.education.domain;

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
public class Attendance {
	
    private Integer averageStudentRate;
    private Double averageTeacherRate;
    private Double averageMinutes;
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getAverageStudentRate() {
        return this.averageStudentRate;
    }
    
    
    
    /**
     * 
     * @return Double
     */
    public Double getAverageTeacherRate() {
        return this.averageTeacherRate;
    }
    
    
    
    /**
     * 
     * @return Double
     */
    public Double getAverageMinutes() {
        return this.averageMinutes;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Attendance.
	
	 * @return String
	 */
	public String toString() {
		return "Attendance[" +averageStudentRate+", "+averageTeacherRate+", "+averageMinutes+"]";
	}
	
	/**
	 * Internal constructor to create a Attendance from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Attendance(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // average student rate
            this.averageStudentRate = ((Number)json_data.get("average student rate")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Attendance; the field averageStudentRate was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Attendance; the field averageStudentRate had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // average teacher rate
            this.averageTeacherRate = ((Number)json_data.get("average teacher rate")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Attendance; the field averageTeacherRate was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Attendance; the field averageTeacherRate had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // average minutes
            this.averageMinutes = ((Number)json_data.get("average minutes")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Attendance; the field averageMinutes was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Attendance; the field averageMinutes had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}