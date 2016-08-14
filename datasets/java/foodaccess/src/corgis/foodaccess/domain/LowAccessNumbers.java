package corgis.foodaccess.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.foodaccess.domain.Seniors;
import corgis.foodaccess.domain.LowIncomePeople;
import corgis.foodaccess.domain.Children;
import corgis.foodaccess.domain.People;

/**
 * 
 */
public class LowAccessNumbers {
	
    // Age 65+
    private Seniors seniors;
    // Low income is defined as annual family income at or below 200 percent of the Federal poverty threshold for family size.
    private LowIncomePeople lowIncomePeople;
    // Age 0-17
    private Children children;
    private People people;
    
    
    /*
     * @return 
     */
    public Seniors getSeniors() {
        return this.seniors;
    }
    
    
    
    /*
     * @return 
     */
    public LowIncomePeople getLowIncomePeople() {
        return this.lowIncomePeople;
    }
    
    
    
    /*
     * @return 
     */
    public Children getChildren() {
        return this.children;
    }
    
    
    
    /*
     * @return 
     */
    public People getPeople() {
        return this.people;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this LowAccessNumbers.
	
	 * @return String
	 */
	public String toString() {
		return "LowAccessNumbers[" +seniors+", "+lowIncomePeople+", "+children+", "+people+"]";
	}
	
	/**
	 * Internal constructor to create a LowAccessNumbers from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public LowAccessNumbers(JSONObject json_data) {
        try {// Seniors
            this.seniors = new Seniors((JSONObject)json_data.get("Seniors"));// Low Income People
            this.lowIncomePeople = new LowIncomePeople((JSONObject)json_data.get("Low Income People"));// Children
            this.children = new Children((JSONObject)json_data.get("Children"));// People
            this.people = new People((JSONObject)json_data.get("People"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a LowAccessNumbers; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a LowAccessNumbers; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}