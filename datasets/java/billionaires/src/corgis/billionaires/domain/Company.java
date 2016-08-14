package corgis.billionaires.domain;

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
public class Company {
	
    private String sector;
    private Integer founded;
    private String type;
    private String name;
    private String relationship;
    
    
    /*
     * @return 
     */
    public String getSector() {
        return this.sector;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getFounded() {
        return this.founded;
    }
    
    
    
    /*
     * @return 
     */
    public String getType() {
        return this.type;
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
    public String getRelationship() {
        return this.relationship;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Company.
	
	 * @return String
	 */
	public String toString() {
		return "Company[" +sector+", "+founded+", "+type+", "+name+", "+relationship+"]";
	}
	
	/**
	 * Internal constructor to create a Company from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Company(JSONObject json_data) {
        try {// sector
            this.sector = (String)json_data.get("sector");// founded
            this.founded = new Integer(((Long)json_data.get("founded")).intValue());// type
            this.type = (String)json_data.get("type");// name
            this.name = (String)json_data.get("name");// relationship
            this.relationship = (String)json_data.get("relationship");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Company; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Company; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}