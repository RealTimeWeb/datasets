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
	
    private Integer biracial;
    private Integer hispanic;
    private Integer black;
    private Integer asian;
    private Integer white;
    private Integer nativeAmerican;
    
    
    /*
     * @return 
     */
    public Integer getBiracial() {
        return this.biracial;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getHispanic() {
        return this.hispanic;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getBlack() {
        return this.black;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getAsian() {
        return this.asian;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getWhite() {
        return this.white;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getNativeAmerican() {
        return this.nativeAmerican;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Race.
	
	 * @return String
	 */
	public String toString() {
		return "Race[" +biracial+", "+hispanic+", "+black+", "+asian+", "+white+", "+nativeAmerican+"]";
	}
	
	/**
	 * Internal constructor to create a Race from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Race(JSONObject json_data) {
        try {// biracial
            this.biracial = ((Number)json_data.get("biracial")).intValue();// hispanic
            this.hispanic = ((Number)json_data.get("hispanic")).intValue();// black
            this.black = ((Number)json_data.get("black")).intValue();// asian
            this.asian = ((Number)json_data.get("asian")).intValue();// white
            this.white = ((Number)json_data.get("white")).intValue();// native american
            this.nativeAmerican = ((Number)json_data.get("native american")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Race; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Race; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}