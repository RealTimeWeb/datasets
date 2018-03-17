package corgis.education.domain;

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
public class Race {
	
    private Integer nativeAmerican;
    private Integer black;
    private Integer biracial;
    private Integer hispanic;
    private Integer asian;
    private Integer white;
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getNativeAmerican() {
        return this.nativeAmerican;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getBlack() {
        return this.black;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getBiracial() {
        return this.biracial;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getHispanic() {
        return this.hispanic;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getAsian() {
        return this.asian;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getWhite() {
        return this.white;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Race.
	
	 * @return String
	 */
	public String toString() {
		return "Race[" +nativeAmerican+", "+black+", "+biracial+", "+hispanic+", "+asian+", "+white+"]";
	}
	
	/**
	 * Internal constructor to create a Race from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Race(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // native american
            this.nativeAmerican = ((Number)json_data.get("native american")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Race; the field nativeAmerican was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Race; the field nativeAmerican had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // black
            this.black = ((Number)json_data.get("black")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Race; the field black was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Race; the field black had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // biracial
            this.biracial = ((Number)json_data.get("biracial")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Race; the field biracial was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Race; the field biracial had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // hispanic
            this.hispanic = ((Number)json_data.get("hispanic")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Race; the field hispanic was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Race; the field hispanic had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // asian
            this.asian = ((Number)json_data.get("asian")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Race; the field asian was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Race; the field asian had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // white
            this.white = ((Number)json_data.get("white")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Race; the field white was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Race; the field white had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}