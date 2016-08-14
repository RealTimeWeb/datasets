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
    private String division;
    private Integer id;
    private String label;
    
    
    /*
     * @return 
     */
    public String getMajor_Group() {
        return this.major_Group;
    }
    
    
    
    /*
     * @return 
     */
    public String getDivision() {
        return this.division;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getId() {
        return this.id;
    }
    
    
    
    /*
     * @return 
     */
    public String getLabel() {
        return this.label;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Industry.
	
	 * @return String
	 */
	public String toString() {
		return "Industry[" +major_Group+", "+division+", "+id+", "+label+"]";
	}
	
	/**
	 * Internal constructor to create a Industry from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Industry(JSONObject json_data) {
        try {// major_group
            this.major_Group = (String)json_data.get("major_group");// division
            this.division = (String)json_data.get("division");// id
            this.id = new Integer(((Long)json_data.get("id")).intValue());// label
            this.label = (String)json_data.get("label");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Industry; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Industry; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}