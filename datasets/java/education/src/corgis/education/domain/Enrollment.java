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
	
    private Integer schools;
    private Students students;
    private Double studentTeacherRatio;
    private Double teachers;
    private Double staff;
    
    
    /*
     * @return 
     */
    public Integer getSchools() {
        return this.schools;
    }
    
    
    
    /*
     * @return 
     */
    public Students getStudents() {
        return this.students;
    }
    
    
    
    /*
     * @return 
     */
    public Double getStudentTeacherRatio() {
        return this.studentTeacherRatio;
    }
    
    
    
    /*
     * @return 
     */
    public Double getTeachers() {
        return this.teachers;
    }
    
    
    
    /*
     * @return 
     */
    public Double getStaff() {
        return this.staff;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Enrollment.
	
	 * @return String
	 */
	public String toString() {
		return "Enrollment[" +schools+", "+students+", "+studentTeacherRatio+", "+teachers+", "+staff+"]";
	}
	
	/**
	 * Internal constructor to create a Enrollment from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Enrollment(JSONObject json_data) {
        try {// schools
            this.schools = new Integer(((Long)json_data.get("schools")).intValue());// students
            this.students = new Students((JSONObject)json_data.get("students"));// student teacher ratio
            this.studentTeacherRatio = (Double)json_data.get("student teacher ratio");// teachers
            this.teachers = (Double)json_data.get("teachers");// staff
            this.staff = (Double)json_data.get("staff");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Enrollment; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Enrollment; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}