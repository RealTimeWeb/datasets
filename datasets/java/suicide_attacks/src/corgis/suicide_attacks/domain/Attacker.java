package corgis.suicide_attacks.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.suicide_attacks.domain.Birth;
import corgis.suicide_attacks.domain.Demographics;

/**
 * 
 */
public class Attacker {
	
    private Birth birth;
    private Demographics demographics;
    private String name;
    private Integer age;
    
    
    /**
     * 
     * @return Birth
     */
    public Birth getBirth() {
        return this.birth;
    }
    
    
    
    /**
     * 
     * @return Demographics
     */
    public Demographics getDemographics() {
        return this.demographics;
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
     * @return Integer
     */
    public Integer getAge() {
        return this.age;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Attacker.
	
	 * @return String
	 */
	public String toString() {
		return "Attacker[" +birth+", "+demographics+", "+name+", "+age+"]";
	}
	
	/**
	 * Internal constructor to create a Attacker from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Attacker(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // birth
            this.birth = new Birth((JSONObject)json_data.get("birth"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Attacker; the field birth was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Attacker; the field birth had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // demographics
            this.demographics = new Demographics((JSONObject)json_data.get("demographics"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Attacker; the field demographics was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Attacker; the field demographics had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // name
            this.name = (String)json_data.get("name");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Attacker; the field name was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Attacker; the field name had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // age
            this.age = ((Number)json_data.get("age")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Attacker; the field age was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Attacker; the field age had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}