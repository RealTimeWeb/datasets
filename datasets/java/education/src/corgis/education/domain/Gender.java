package corgis.education.domain;

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
public class Gender {
	
    private Integer male;
    private Integer female;
    
    
    /*
     * @return 
     */
    public Integer getMale() {
        return this.male;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getFemale() {
        return this.female;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Gender.
	
	 * @return String
	 */
	public String toString() {
		return "Gender[" +male+", "+female+"]";
	}
	
	/**
	 * Internal constructor to create a Gender from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Gender(JSONObject json_data) {
        try {// male
            this.male = new Integer(((Long)json_data.get("male")).intValue());// female
            this.female = new Integer(((Long)json_data.get("female")).intValue());
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Gender; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Gender; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}