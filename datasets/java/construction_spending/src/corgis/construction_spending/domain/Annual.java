package corgis.construction_spending.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.construction_spending.domain.Combined;
import corgis.construction_spending.domain.Private_;
import corgis.construction_spending.domain.Public_;

/**
 * 
 */
public class Annual {
	
    private Combined combined;
    private Private_ private_;
    private Public_ public_;
    
    
    /*
     * @return 
     */
    public Combined getCombined() {
        return this.combined;
    }
    
    
    
    /*
     * @return 
     */
    public Private_ getPrivate_() {
        return this.private_;
    }
    
    
    
    /*
     * @return 
     */
    public Public_ getPublic_() {
        return this.public_;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Annual.
	
	 * @return String
	 */
	public String toString() {
		return "Annual[" +combined+", "+private_+", "+public_+"]";
	}
	
	/**
	 * Internal constructor to create a Annual from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Annual(JSONObject json_data) {
        try {// combined
            this.combined = new Combined((JSONObject)json_data.get("combined"));// private
            this.private_ = new Private_((JSONObject)json_data.get("private"));// public
            this.public_ = new Public_((JSONObject)json_data.get("public"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Annual; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Annual; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}