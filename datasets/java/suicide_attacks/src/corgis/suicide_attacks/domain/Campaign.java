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
public class Campaign {
	
    private ArrayList<String> sides;
    private String name;
    
    
    /**
     * 
     * @return ArrayList<String>
     */
    public ArrayList<String> getSides() {
        return this.sides;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getName() {
        return this.name;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Campaign.
	
	 * @return String
	 */
	public String toString() {
		return "Campaign[" +sides+", "+name+"]";
	}
	
	/**
	 * Internal constructor to create a Campaign from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Campaign(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // sides
            this.sides = new ArrayList<String>();
            Iterator<Object> sidesIter = ((List<Object>)json_data.get("sides")).iterator();
            while (sidesIter.hasNext()) {
                this.sides.add(new String((String)sidesIter.next()));
            }
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Campaign; the field sides was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Campaign; the field sides had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // name
            this.name = (String)json_data.get("name");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Campaign; the field name was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Campaign; the field name had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}