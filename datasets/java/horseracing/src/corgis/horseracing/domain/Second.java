package corgis.horseracing.domain;

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
public class Second {
	
    private Integer gate;
    private Double place;
    private String name;
    private Double show;
    
    
    /*
     * @return 
     */
    public Integer getGate() {
        return this.gate;
    }
    
    
    
    /*
     * @return 
     */
    public Double getPlace() {
        return this.place;
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
    public Double getShow() {
        return this.show;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Second.
	
	 * @return String
	 */
	public String toString() {
		return "Second[" +gate+", "+place+", "+name+", "+show+"]";
	}
	
	/**
	 * Internal constructor to create a Second from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Second(JSONObject json_data) {
        try {// gate
            this.gate = new Integer(((Long)json_data.get("gate")).intValue());// place
            this.place = (Double)json_data.get("place");// name
            this.name = (String)json_data.get("name");// show
            this.show = (Double)json_data.get("show");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Second; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Second; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}