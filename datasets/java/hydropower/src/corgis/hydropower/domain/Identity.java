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
	
    private String watercourse;
    private String name;
    private Project project;
    
    
    /**
     * 
     * @return String
     */
    public String getWatercourse() {
        return this.watercourse;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getName() {
        return this.name;
    }
    
    
    
    /**
     * 
     * @return Project
     */
    public Project getProject() {
        return this.project;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Identity.
	
	 * @return String
	 */
	public String toString() {
		return "Identity[" +watercourse+", "+name+", "+project+"]";
	}
	
	/**
	 * Internal constructor to create a Identity from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Identity(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Watercourse
            this.watercourse = (String)json_data.get("Watercourse");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Identity; the field watercourse was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Identity; the field watercourse had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Name
            this.name = (String)json_data.get("Name");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Identity; the field name was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Identity; the field name had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Project
            this.project = new Project((JSONObject)json_data.get("Project"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Identity; the field project was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Identity; the field project had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}