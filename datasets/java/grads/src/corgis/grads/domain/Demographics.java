package corgis.grads.domain;

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
public class Demographics {
	
    private Integer men;
    private Double womenAsShareOfTotal;
    private Integer women;
    
    
    /*
     * @return 
     */
    public Integer getMen() {
        return this.men;
    }
    
    
    
    /*
     * @return 
     */
    public Double getWomenAsShareOfTotal() {
        return this.womenAsShareOfTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getWomen() {
        return this.women;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Demographics.
	
	 * @return String
	 */
	public String toString() {
		return "Demographics[" +men+", "+womenAsShareOfTotal+", "+women+"]";
	}
	
	/**
	 * Internal constructor to create a Demographics from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Demographics(JSONObject json_data) {
        try {// Men
            this.men = new Integer(((Long)json_data.get("Men")).intValue());// Women as Share of Total
            this.womenAsShareOfTotal = (Double)json_data.get("Women as Share of Total");// Women
            this.women = new Integer(((Long)json_data.get("Women")).intValue());
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Demographics; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Demographics; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}