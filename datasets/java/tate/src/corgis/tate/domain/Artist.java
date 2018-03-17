package corgis.tate.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.tate.domain.Birth;
import corgis.tate.domain.Death;

/**
 * 
 */
public class Artist {
	
    private String role;
    private Birth birth;
    private Death death;
    // The recorded gender of the artist, either "Male", "Female", or a blank string.
    private String gender;
    private String name;
    
    
    /**
     * 
     * @return String
     */
    public String getRole() {
        return this.role;
    }
    
    
    
    /**
     * 
     * @return Birth
     */
    public Birth getBirth() {
        return this.birth;
    }
    
    
    
    /**
     * 
     * @return Death
     */
    public Death getDeath() {
        return this.death;
    }
    
    
    
    /**
     * The recorded gender of the artist, either "Male", "Female", or a blank string.
     * @return String
     */
    public String getGender() {
        return this.gender;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getName() {
        return this.name;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Artist.
	
	 * @return String
	 */
	public String toString() {
		return "Artist[" +role+", "+birth+", "+death+", "+gender+", "+name+"]";
	}
	
	/**
	 * Internal constructor to create a Artist from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Artist(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // role
            this.role = (String)json_data.get("role");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Artist; the field role was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Artist; the field role had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // birth
            this.birth = new Birth((JSONObject)json_data.get("birth"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Artist; the field birth was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Artist; the field birth had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // death
            this.death = new Death((JSONObject)json_data.get("death"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Artist; the field death was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Artist; the field death had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // gender
            this.gender = (String)json_data.get("gender");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Artist; the field gender was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Artist; the field gender had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // name
            this.name = (String)json_data.get("name");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Artist; the field name was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Artist; the field name had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}