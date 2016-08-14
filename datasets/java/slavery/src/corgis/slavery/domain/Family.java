package corgis.slavery.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.slavery.domain.Number;

/**
 * 
 */
public class Family {
	
    private ArrayList<Children> children;
    private String relationship;
    private Number number;
    
    
    /*
     * @return 
     */
    public ArrayList<Children> getChildren() {
        return this.children;
    }
    
    
    
    /*
     * @return 
     */
    public String getRelationship() {
        return this.relationship;
    }
    
    
    
    /*
     * @return 
     */
    public Number getNumber() {
        return this.number;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Family.
	
	 * @return String
	 */
	public String toString() {
		return "Family[" +children+", "+relationship+", "+number+"]";
	}
	
	/**
	 * Internal constructor to create a Family from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Family(JSONObject json_data) {
        try {// children
            this.children = new ArrayList<Children>();
            Iterator<Object> childrenIter = ((List<Object>)json_data.get("children")).iterator();
            while (childrenIter.hasNext()) {
                this.children.add(new Children((JSONObject)childrenIter.next()));
            }// relationship
            this.relationship = (String)json_data.get("relationship");// number
            this.number = new Number((JSONObject)json_data.get("number"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Family; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Family; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}