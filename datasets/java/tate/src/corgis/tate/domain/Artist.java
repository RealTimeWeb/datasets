package corgis.tate.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.tate.domain.Death;
import corgis.tate.domain.Birth;

/**
 * 
 */
public class Artist {
	
    // The recorded gender of the artist, either "Male", "Female", or a blank string.
    private String gender;
    private Death death;
    private String role;
    private String name;
    private Birth birth;
    
    
    /*
     * @return 
     */
    public String getGender() {
        return this.gender;
    }
    
    
    
    /*
     * @return 
     */
    public Death getDeath() {
        return this.death;
    }
    
    
    
    /*
     * @return 
     */
    public String getRole() {
        return this.role;
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
    public Birth getBirth() {
        return this.birth;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Artist.
	
	 * @return String
	 */
	public String toString() {
		return "Artist[" +gender+", "+death+", "+role+", "+name+", "+birth+"]";
	}
	
	/**
	 * Internal constructor to create a Artist from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Artist(JSONObject json_data) {
        try {// gender
            this.gender = (String)json_data.get("gender");// death
            this.death = new Death((JSONObject)json_data.get("death"));// role
            this.role = (String)json_data.get("role");// name
            this.name = (String)json_data.get("name");// birth
            this.birth = new Birth((JSONObject)json_data.get("birth"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Artist; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Artist; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}