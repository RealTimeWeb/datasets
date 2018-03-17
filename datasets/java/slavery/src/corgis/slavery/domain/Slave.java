package corgis.slavery.domain;

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
public class Slave {
	
    private String skinColor;
    private String name;
    // Ages that are represented as -1 stand for ages that were not available in the data that was collected.
    private Double age;
    private String gender;
    
    
    /**
     * 
     * @return String
     */
    public String getSkinColor() {
        return this.skinColor;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getName() {
        return this.name;
    }
    
    
    
    /**
     * Ages that are represented as -1 stand for ages that were not available in the data that was collected.
     * @return Double
     */
    public Double getAge() {
        return this.age;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getGender() {
        return this.gender;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Slave.
	
	 * @return String
	 */
	public String toString() {
		return "Slave[" +skinColor+", "+name+", "+age+", "+gender+"]";
	}
	
	/**
	 * Internal constructor to create a Slave from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Slave(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Skin Color
            this.skinColor = (String)json_data.get("Skin Color");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Slave; the field skinColor was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Slave; the field skinColor had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Name
            this.name = (String)json_data.get("Name");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Slave; the field name was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Slave; the field name had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Age
            this.age = ((Number)json_data.get("Age")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Slave; the field age was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Slave; the field age had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Gender
            this.gender = (String)json_data.get("Gender");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Slave; the field gender was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Slave; the field gender had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}