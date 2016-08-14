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
	
    private String gender;
    // Ages that are represented as -1 stand for ages that were not available in the data that was collected.
    private Double age;
    private String skinColor;
    private String name;
    
    
    /*
     * @return 
     */
    public String getGender() {
        return this.gender;
    }
    
    
    
    /*
     * @return 
     */
    public Double getAge() {
        return this.age;
    }
    
    
    
    /*
     * @return 
     */
    public String getSkinColor() {
        return this.skinColor;
    }
    
    
    
    /*
     * @return 
     */
    public String getName() {
        return this.name;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Slave.
	
	 * @return String
	 */
	public String toString() {
		return "Slave[" +gender+", "+age+", "+skinColor+", "+name+"]";
	}
	
	/**
	 * Internal constructor to create a Slave from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Slave(JSONObject json_data) {
        try {// Gender
            this.gender = (String)json_data.get("Gender");// Age
            this.age = (Double)json_data.get("Age");// Skin Color
            this.skinColor = (String)json_data.get("Skin Color");// Name
            this.name = (String)json_data.get("Name");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Slave; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Slave; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}