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
public class Target {
	
    private Boolean assassination;
    private String name;
    private String country;
    private String weapon;
    private String location;
    private String type;
    
    
    /*
     * @return 
     */
    public Boolean getAssassination() {
        return this.assassination;
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
    public String getCountry() {
        return this.country;
    }
    
    
    
    /*
     * @return 
     */
    public String getWeapon() {
        return this.weapon;
    }
    
    
    
    /*
     * @return 
     */
    public String getLocation() {
        return this.location;
    }
    
    
    
    /*
     * @return 
     */
    public String getType() {
        return this.type;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Target.
	
	 * @return String
	 */
	public String toString() {
		return "Target[" +assassination+", "+name+", "+country+", "+weapon+", "+location+", "+type+"]";
	}
	
	/**
	 * Internal constructor to create a Target from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Target(JSONObject json_data) {
        try {// assassination?
            this.assassination = (Boolean)json_data.get("assassination?");// name
            this.name = (String)json_data.get("name");// country
            this.country = (String)json_data.get("country");// weapon
            this.weapon = (String)json_data.get("weapon");// location
            this.location = (String)json_data.get("location");// type
            this.type = (String)json_data.get("type");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Target; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Target; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}