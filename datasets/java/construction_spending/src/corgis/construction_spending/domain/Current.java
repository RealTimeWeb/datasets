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
public class Current {
	
    private Combined combined;
    private Private_ private_;
    private Public_ public_;
    
    
    /**
     * 
     * @return Combined
     */
    public Combined getCombined() {
        return this.combined;
    }
    
    
    
    /**
     * 
     * @return Private_
     */
    public Private_ getPrivate_() {
        return this.private_;
    }
    
    
    
    /**
     * 
     * @return Public_
     */
    public Public_ getPublic_() {
        return this.public_;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Current.
	
	 * @return String
	 */
	public String toString() {
		return "Current[" +combined+", "+private_+", "+public_+"]";
	}
	
	/**
	 * Internal constructor to create a Current from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Current(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // combined
            this.combined = new Combined((JSONObject)json_data.get("combined"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Current; the field combined was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Current; the field combined had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // private
            this.private_ = new Private_((JSONObject)json_data.get("private"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Current; the field private_ was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Current; the field private_ had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // public
            this.public_ = new Public_((JSONObject)json_data.get("public"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Current; the field public_ was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Current; the field public_ had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}