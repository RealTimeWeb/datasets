package corgis.immigration.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.immigration.domain.Illegals;
import corgis.immigration.domain.Naturalizations;
import corgis.immigration.domain.Permanants;

/**
 * 
 */
public class Record {
	
    private Illegals illegals;
    private Naturalizations naturalizations;
    private Permanants permanants;
    private Integer year;
    
    
    /*
     * @return 
     */
    public Illegals getIllegals() {
        return this.illegals;
    }
    
    
    
    /*
     * @return 
     */
    public Naturalizations getNaturalizations() {
        return this.naturalizations;
    }
    
    
    
    /*
     * @return 
     */
    public Permanants getPermanants() {
        return this.permanants;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getYear() {
        return this.year;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Record.
	
	 * @return String
	 */
	public String toString() {
		return "Record[" +illegals+", "+naturalizations+", "+permanants+", "+year+"]";
	}
	
	/**
	 * Internal constructor to create a Record from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Record(JSONObject json_data) {
        try {// illegals
            this.illegals = new Illegals((JSONObject)json_data.get("illegals"));// naturalizations
            this.naturalizations = new Naturalizations((JSONObject)json_data.get("naturalizations"));// permanants
            this.permanants = new Permanants((JSONObject)json_data.get("permanants"));// year
            this.year = new Integer(((Long)json_data.get("year")).intValue());
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Record; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Record; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}