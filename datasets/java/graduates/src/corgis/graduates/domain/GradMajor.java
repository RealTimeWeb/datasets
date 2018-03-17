package corgis.graduates.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.graduates.domain.Employment;
import corgis.graduates.domain.Demographics;
import corgis.graduates.domain.Salaries;
import corgis.graduates.domain.Education;

/**
 * 
 */
public class GradMajor {
	
    private Employment employment;
    private Demographics demographics;
    private Salaries salaries;
    private Education education;
    // The year that this report was made for.
    private Integer year;
    
    
    /**
     * 
     * @return Employment
     */
    public Employment getEmployment() {
        return this.employment;
    }
    
    
    
    /**
     * 
     * @return Demographics
     */
    public Demographics getDemographics() {
        return this.demographics;
    }
    
    
    
    /**
     * 
     * @return Salaries
     */
    public Salaries getSalaries() {
        return this.salaries;
    }
    
    
    
    /**
     * 
     * @return Education
     */
    public Education getEducation() {
        return this.education;
    }
    
    
    
    /**
     * The year that this report was made for.
     * @return Integer
     */
    public Integer getYear() {
        return this.year;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this GradMajor.
	
	 * @return String
	 */
	public String toString() {
		return "GradMajor[" +employment+", "+demographics+", "+salaries+", "+education+", "+year+"]";
	}
	
	/**
	 * Internal constructor to create a GradMajor from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public GradMajor(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Employment
            this.employment = new Employment((JSONObject)json_data.get("Employment"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a GradMajor; the field employment was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a GradMajor; the field employment had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Demographics
            this.demographics = new Demographics((JSONObject)json_data.get("Demographics"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a GradMajor; the field demographics was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a GradMajor; the field demographics had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Salaries
            this.salaries = new Salaries((JSONObject)json_data.get("Salaries"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a GradMajor; the field salaries was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a GradMajor; the field salaries had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Education
            this.education = new Education((JSONObject)json_data.get("Education"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a GradMajor; the field education was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a GradMajor; the field education had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Year
            this.year = ((Number)json_data.get("Year")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a GradMajor; the field year was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a GradMajor; the field year had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}