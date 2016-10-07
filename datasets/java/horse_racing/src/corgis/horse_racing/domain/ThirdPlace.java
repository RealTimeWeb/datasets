package corgis.horse_racing.domain;

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
public class ThirdPlace {
	
    private Integer gate;
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
	 * Creates a string based representation of this ThirdPlace.
	
	 * @return String
	 */
	public String toString() {
		return "ThirdPlace[" +gate+", "+name+", "+show+"]";
	}
	
	/**
	 * Internal constructor to create a ThirdPlace from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public ThirdPlace(JSONObject json_data) {
        try {// gate
            this.gate = new Integer(((Long)json_data.get("gate")).intValue());// name
            this.name = (String)json_data.get("name");// show
            this.show = (Double)json_data.get("show");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a ThirdPlace; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a ThirdPlace; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}