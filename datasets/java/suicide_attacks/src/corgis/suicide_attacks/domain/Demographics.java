package corgis.suicide_attacks.domain;

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
	
    private String education;
    private String religion;
    private String occupation;
    private String gender;
    private String marital;
    
    
    /**
     * 
     * @return String
     */
    public String getEducation() {
        return this.education;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getReligion() {
        return this.religion;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getOccupation() {
        return this.occupation;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getGender() {
        return this.gender;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getMarital() {
        return this.marital;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Demographics.
	
	 * @return String
	 */
	public String toString() {
		return "Demographics[" +education+", "+religion+", "+occupation+", "+gender+", "+marital+"]";
	}
	
	/**
	 * Internal constructor to create a Demographics from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Demographics(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // education
            this.education = (String)json_data.get("education");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Demographics; the field education was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Demographics; the field education had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // religion
            this.religion = (String)json_data.get("religion");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Demographics; the field religion was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Demographics; the field religion had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // occupation
            this.occupation = (String)json_data.get("occupation");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Demographics; the field occupation was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Demographics; the field occupation had the wrong structure.");
    		e.printStackTrace();
        }
        
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
            // marital
            this.marital = (String)json_data.get("marital");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Demographics; the field marital was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Demographics; the field marital had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}