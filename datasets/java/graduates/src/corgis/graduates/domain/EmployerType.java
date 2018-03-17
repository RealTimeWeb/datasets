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
public class EmployerType {
	
    // The number of people with a degree in this major during this year who described their Employer Type as an "Educational Institution".
    private Integer educationalInstitution;
    // The number of people with a degree in this major during this year who described their Employer Type as "Government".
    private Integer government;
    // The number of people with a degree in this major during this year who described their Employer Type as "Business/Industry".
    private Integer businessIndustry;
    
    
    /**
     * The number of people with a degree in this major during this year who described their Employer Type as an "Educational Institution".
     * @return Integer
     */
    public Integer getEducationalInstitution() {
        return this.educationalInstitution;
    }
    
    
    
    /**
     * The number of people with a degree in this major during this year who described their Employer Type as "Government".
     * @return Integer
     */
    public Integer getGovernment() {
        return this.government;
    }
    
    
    
    /**
     * The number of people with a degree in this major during this year who described their Employer Type as "Business/Industry".
     * @return Integer
     */
    public Integer getBusinessIndustry() {
        return this.businessIndustry;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this EmployerType.
	
	 * @return String
	 */
	public String toString() {
		return "EmployerType[" +educationalInstitution+", "+government+", "+businessIndustry+"]";
	}
	
	/**
	 * Internal constructor to create a EmployerType from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public EmployerType(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Educational Institution
            this.educationalInstitution = ((Number)json_data.get("Educational Institution")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a EmployerType; the field educationalInstitution was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a EmployerType; the field educationalInstitution had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Government
            this.government = ((Number)json_data.get("Government")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a EmployerType; the field government was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a EmployerType; the field government had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Business/Industry
            this.businessIndustry = ((Number)json_data.get("Business/Industry")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a EmployerType; the field businessIndustry was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a EmployerType; the field businessIndustry had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}