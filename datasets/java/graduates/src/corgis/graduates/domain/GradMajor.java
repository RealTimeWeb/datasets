package corgis.graduates.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.graduates.domain.Demographics;
import corgis.graduates.domain.Education;
import corgis.graduates.domain.Employment;
import corgis.graduates.domain.Salaries;

/**
 * 
 */
public class GradMajor {
	
    private Demographics demographics;
    private Education education;
    private Employment employment;
    private Salaries salaries;
    // The year that this report was made for.
    private Integer year;
    
    
    /*
     * @return 
     */
    public Demographics getDemographics() {
        return this.demographics;
    }
    
    
    
    /*
     * @return 
     */
    public Education getEducation() {
        return this.education;
    }
    
    
    
    /*
     * @return 
     */
    public Employment getEmployment() {
        return this.employment;
    }
    
    
    
    /*
     * @return 
     */
    public Salaries getSalaries() {
        return this.salaries;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getYear() {
        return this.year;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this GradMajor.
	
	 * @return String
	 */
	public String toString() {
		return "GradMajor[" +demographics+", "+education+", "+employment+", "+salaries+", "+year+"]";
	}
	
	/**
	 * Internal constructor to create a GradMajor from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public GradMajor(JSONObject json_data) {
        try {// Demographics
            this.demographics = new Demographics((JSONObject)json_data.get("Demographics"));// Education
            this.education = new Education((JSONObject)json_data.get("Education"));// Employment
            this.employment = new Employment((JSONObject)json_data.get("Employment"));// Salaries
            this.salaries = new Salaries((JSONObject)json_data.get("Salaries"));// Year
            this.year = ((Number)json_data.get("Year")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a GradMajor; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a GradMajor; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}