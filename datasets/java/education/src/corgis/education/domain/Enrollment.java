package corgis.education.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.education.domain.Students;

/**
 * 
 */
public class Enrollment {
	
    private Double staff;
    private Double studentTeacherRatio;
    private Students students;
    private Double teachers;
    private Integer schools;
    
    
    /**
     * 
     * @return Double
     */
    public Double getStaff() {
        return this.staff;
    }
    
    
    
    /**
     * 
     * @return Double
     */
    public Double getStudentTeacherRatio() {
        return this.studentTeacherRatio;
    }
    
    
    
    /**
     * 
     * @return Students
     */
    public Students getStudents() {
        return this.students;
    }
    
    
    
    /**
     * 
     * @return Double
     */
    public Double getTeachers() {
        return this.teachers;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getSchools() {
        return this.schools;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Enrollment.
	
	 * @return String
	 */
	public String toString() {
		return "Enrollment[" +staff+", "+studentTeacherRatio+", "+students+", "+teachers+", "+schools+"]";
	}
	
	/**
	 * Internal constructor to create a Enrollment from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Enrollment(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // staff
            this.staff = ((Number)json_data.get("staff")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Enrollment; the field staff was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Enrollment; the field staff had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // student teacher ratio
            this.studentTeacherRatio = ((Number)json_data.get("student teacher ratio")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Enrollment; the field studentTeacherRatio was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Enrollment; the field studentTeacherRatio had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // students
            this.students = new Students((JSONObject)json_data.get("students"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Enrollment; the field students was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Enrollment; the field students had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // teachers
            this.teachers = ((Number)json_data.get("teachers")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Enrollment; the field teachers was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Enrollment; the field teachers had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // schools
            this.schools = ((Number)json_data.get("schools")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Enrollment; the field schools was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Enrollment; the field schools had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}