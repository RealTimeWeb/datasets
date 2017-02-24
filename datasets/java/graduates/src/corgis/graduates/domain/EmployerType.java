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
    // The number of people with a degree in this major during this year who described their Employer Type as "Business/Industry".
    private Integer businessIndustry;
    // The number of people with a degree in this major during this year who described their Employer Type as "Government".
    private Integer government;
    
    
    /*
     * @return 
     */
    public Integer getEducationalInstitution() {
        return this.educationalInstitution;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getBusinessIndustry() {
        return this.businessIndustry;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getGovernment() {
        return this.government;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this EmployerType.
	
	 * @return String
	 */
	public String toString() {
		return "EmployerType[" +educationalInstitution+", "+businessIndustry+", "+government+"]";
	}
	
	/**
	 * Internal constructor to create a EmployerType from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public EmployerType(JSONObject json_data) {
        try {// Educational Institution
            this.educationalInstitution = ((Number)json_data.get("Educational Institution")).intValue();// Business/Industry
            this.businessIndustry = ((Number)json_data.get("Business/Industry")).intValue();// Government
            this.government = ((Number)json_data.get("Government")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a EmployerType; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a EmployerType; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}