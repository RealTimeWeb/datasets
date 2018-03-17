package corgis.injuries.domain;

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
public class Industry {
	
    private String major_Group;
    private Integer id;
    private String label;
    private String division;
    
    
    /**
     * 
     * @return String
     */
    public String getMajor_Group() {
        return this.major_Group;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getId() {
        return this.id;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getLabel() {
        return this.label;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getDivision() {
        return this.division;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Industry.
	
	 * @return String
	 */
	public String toString() {
		return "Industry[" +major_Group+", "+id+", "+label+", "+division+"]";
	}
	
	/**
	 * Internal constructor to create a Industry from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Industry(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // major_group
            this.major_Group = (String)json_data.get("major_group");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Industry; the field major_Group was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Industry; the field major_Group had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // id
            this.id = ((Number)json_data.get("id")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Industry; the field id was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Industry; the field id had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // label
            this.label = (String)json_data.get("label");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Industry; the field label was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Industry; the field label had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // division
            this.division = (String)json_data.get("division");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Industry; the field division was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Industry; the field division had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}