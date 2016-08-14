package corgis.suicideattacks.domain;

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
	
    private String occupation;
    private String gender;
    private String education;
    private String marital;
    private String religion;
    
    
    /*
     * @return 
     */
    public String getOccupation() {
        return this.occupation;
    }
    
    
    
    /*
     * @return 
     */
    public String getGender() {
        return this.gender;
    }
    
    
    
    /*
     * @return 
     */
    public String getEducation() {
        return this.education;
    }
    
    
    
    /*
     * @return 
     */
    public String getMarital() {
        return this.marital;
    }
    
    
    
    /*
     * @return 
     */
    public String getReligion() {
        return this.religion;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Demographics.
	
	 * @return String
	 */
	public String toString() {
		return "Demographics[" +occupation+", "+gender+", "+education+", "+marital+", "+religion+"]";
	}
	
	/**
	 * Internal constructor to create a Demographics from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Demographics(JSONObject json_data) {
        try {// occupation
            this.occupation = (String)json_data.get("occupation");// gender
            this.gender = (String)json_data.get("gender");// education
            this.education = (String)json_data.get("education");// marital
            this.marital = (String)json_data.get("marital");// religion
            this.religion = (String)json_data.get("religion");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Demographics; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Demographics; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}