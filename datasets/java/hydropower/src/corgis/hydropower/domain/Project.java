package corgis.hydropower.domain;

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
public class Project {
	
    private String organization;
    private Integer year;
    
    
    /**
     * 
     * @return String
     */
    public String getOrganization() {
        return this.organization;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getYear() {
        return this.year;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Project.
	
	 * @return String
	 */
	public String toString() {
		return "Project[" +organization+", "+year+"]";
	}
	
	/**
	 * Internal constructor to create a Project from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Project(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Organization
            this.organization = (String)json_data.get("Organization");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Project; the field organization was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Project; the field organization had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Year
            this.year = ((Number)json_data.get("Year")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Project; the field year was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Project; the field year had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}