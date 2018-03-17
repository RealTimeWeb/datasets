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
public class Demographics {
	
    // A string representing their gender.
    private String gender;
    // The current age of the billionaire. Ages that are represented as -1 stand for ages that were not available in the data that was collected.
    private Integer age;
    
    
    /**
     * A string representing their gender.
     * @return String
     */
    public String getGender() {
        return this.gender;
    }
    
    
    
    /**
     * The current age of the billionaire. Ages that are represented as -1 stand for ages that were not available in the data that was collected.
     * @return Integer
     */
    public Integer getAge() {
        return this.age;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Demographics.
	
	 * @return String
	 */
	public String toString() {
		return "Demographics[" +gender+", "+age+"]";
	}
	
	/**
	 * Internal constructor to create a Demographics from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Demographics(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // gender
            this.gender = (String)json_data.get("gender");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Demographics; the field gender was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Demographics; the field gender had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // age
            this.age = ((Number)json_data.get("age")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Demographics; the field age was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Demographics; the field age had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}