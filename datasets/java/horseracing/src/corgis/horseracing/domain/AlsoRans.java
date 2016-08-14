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
public class AlsoRans {
	
    private Integer gate;
    private String name;
    
    
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
    
    
    
	
	/**
	 * Creates a string based representation of this Also-Rans.
	
	 * @return String
	 */
	public String toString() {
		return "Also-Rans[" +gate+", "+name+"]";
	}
	
	/**
	 * Internal constructor to create a Also-Rans from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public AlsoRans(JSONObject json_data) {
        try {// gate
            this.gate = new Integer(((Long)json_data.get("gate")).intValue());// name
            this.name = (String)json_data.get("name");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Also-Rans; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Also-Rans; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}