package corgis.scripts.domain;

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
public class Characters {
	
    private String gender;
    private String character_Id;
    private String name;
    private Integer credited_Position;
    
    
    /*
     * @return 
     */
    public String getGender() {
        return this.gender;
    }
    
    
    
    /*
     * @return 
     */
    public String getCharacter_Id() {
        return this.character_Id;
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
    public Integer getCredited_Position() {
        return this.credited_Position;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Characters.
	
	 * @return String
	 */
	public String toString() {
		return "Characters[" +gender+", "+character_Id+", "+name+", "+credited_Position+"]";
	}
	
	/**
	 * Internal constructor to create a Characters from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Characters(JSONObject json_data) {
        try {// gender
            this.gender = (String)json_data.get("gender");// character_id
            this.character_Id = (String)json_data.get("character_id");// name
            this.name = (String)json_data.get("name");// credited_position
            this.credited_Position = new Integer(((Long)json_data.get("credited_position")).intValue());
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Characters; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Characters; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}