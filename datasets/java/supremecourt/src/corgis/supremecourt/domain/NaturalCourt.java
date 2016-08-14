package corgis.supremecourt.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.supremecourt.domain.Start;
import corgis.supremecourt.domain.End;

/**
 * 
 */
public class NaturalCourt {
	
    private Start start;
    private String chief;
    private End end;
    private Integer period;
    private Integer id;
    
    
    /*
     * @return 
     */
    public Start getStart() {
        return this.start;
    }
    
    
    
    /*
     * @return 
     */
    public String getChief() {
        return this.chief;
    }
    
    
    
    /*
     * @return 
     */
    public End getEnd() {
        return this.end;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getPeriod() {
        return this.period;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getId() {
        return this.id;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this NaturalCourt.
	
	 * @return String
	 */
	public String toString() {
		return "NaturalCourt[" +start+", "+chief+", "+end+", "+period+", "+id+"]";
	}
	
	/**
	 * Internal constructor to create a NaturalCourt from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public NaturalCourt(JSONObject json_data) {
        try {// start
            this.start = new Start((JSONObject)json_data.get("start"));// chief
            this.chief = (String)json_data.get("chief");// end
            this.end = new End((JSONObject)json_data.get("end"));// period
            this.period = new Integer(((Long)json_data.get("period")).intValue());// id
            this.id = new Integer(((Long)json_data.get("id")).intValue());
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a NaturalCourt; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a NaturalCourt; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}