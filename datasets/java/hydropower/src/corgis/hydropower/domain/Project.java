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
    
    
    /*
     * @return 
     */
    public String getOrganization() {
        return this.organization;
    }
    
    
    
    /*
     * @return 
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
        try {// Organization
            this.organization = (String)json_data.get("Organization");// Year
            this.year = ((Number)json_data.get("Year")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Project; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Project; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}