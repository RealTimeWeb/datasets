package corgis.suicide_attacks.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.suicide_attacks.domain.Demographics;
import corgis.suicide_attacks.domain.Birth;

/**
 * 
 */
public class Attacker {
	
    private Integer age;
    private Demographics demographics;
    private Birth birth;
    private String name;
    
    
    /*
     * @return 
     */
    public Integer getAge() {
        return this.age;
    }
    
    
    
    /*
     * @return 
     */
    public Demographics getDemographics() {
        return this.demographics;
    }
    
    
    
    /*
     * @return 
     */
    public Birth getBirth() {
        return this.birth;
    }
    
    
    
    /*
     * @return 
     */
    public String getName() {
        return this.name;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Attacker.
	
	 * @return String
	 */
	public String toString() {
		return "Attacker[" +age+", "+demographics+", "+birth+", "+name+"]";
	}
	
	/**
	 * Internal constructor to create a Attacker from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Attacker(JSONObject json_data) {
        try {// age
            this.age = ((Number)json_data.get("age")).intValue();// demographics
            this.demographics = new Demographics((JSONObject)json_data.get("demographics"));// birth
            this.birth = new Birth((JSONObject)json_data.get("birth"));// name
            this.name = (String)json_data.get("name");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Attacker; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Attacker; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}