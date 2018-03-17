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
    private String location;
    private String weapon;
    private String country;
    private String type;
    
    
    /**
     * 
     * @return Boolean
     */
    public Boolean getAssassination() {
        return this.assassination;
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
     * @return String
     */
    public String getLocation() {
        return this.location;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getWeapon() {
        return this.weapon;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getCountry() {
        return this.country;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getType() {
        return this.type;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Target.
	
	 * @return String
	 */
	public String toString() {
		return "Target[" +assassination+", "+name+", "+location+", "+weapon+", "+country+", "+type+"]";
	}
	
	/**
	 * Internal constructor to create a Target from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Target(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // assassination?
            this.assassination = (Boolean)json_data.get("assassination?");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Target; the field assassination was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Target; the field assassination had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // name
            this.name = (String)json_data.get("name");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Target; the field name was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Target; the field name had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // location
            this.location = (String)json_data.get("location");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Target; the field location was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Target; the field location had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // weapon
            this.weapon = (String)json_data.get("weapon");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Target; the field weapon was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Target; the field weapon had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // country
            this.country = (String)json_data.get("country");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Target; the field country was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Target; the field country had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // type
            this.type = (String)json_data.get("type");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Target; the field type was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Target; the field type had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}