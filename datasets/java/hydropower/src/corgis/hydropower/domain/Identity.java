package corgis.hydropower.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.hydropower.domain.Project;

/**
 * 
 */
public class Identity {
	
    private Project project;
    private String name;
    private String watercourse;
    
    
    /*
     * @return 
     */
    public Project getProject() {
        return this.project;
    }
    
    
    
    /*
     * @return 
     */
    public String getName() {
        return this.name;
    }
    
    
    
    /*
     * @return 
     */
    public String getWatercourse() {
        return this.watercourse;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Identity.
	
	 * @return String
	 */
	public String toString() {
		return "Identity[" +project+", "+name+", "+watercourse+"]";
	}
	
	/**
	 * Internal constructor to create a Identity from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Identity(JSONObject json_data) {
        try {// Project
            this.project = new Project((JSONObject)json_data.get("Project"));// Name
            this.name = (String)json_data.get("Name");// Watercourse
            this.watercourse = (String)json_data.get("Watercourse");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Identity; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Identity; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}