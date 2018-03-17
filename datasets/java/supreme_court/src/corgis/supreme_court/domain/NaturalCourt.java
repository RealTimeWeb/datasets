package corgis.supreme_court.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.supreme_court.domain.Start;
import corgis.supreme_court.domain.End;

/**
 * 
 */
public class NaturalCourt {
	
    private Start start;
    private End end;
    private String chief;
    private Integer id;
    private Integer period;
    
    
    /**
     * 
     * @return Start
     */
    public Start getStart() {
        return this.start;
    }
    
    
    
    /**
     * 
     * @return End
     */
    public End getEnd() {
        return this.end;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getChief() {
        return this.chief;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getId() {
        return this.id;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getPeriod() {
        return this.period;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this NaturalCourt.
	
	 * @return String
	 */
	public String toString() {
		return "NaturalCourt[" +start+", "+end+", "+chief+", "+id+", "+period+"]";
	}
	
	/**
	 * Internal constructor to create a NaturalCourt from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public NaturalCourt(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // start
            this.start = new Start((JSONObject)json_data.get("start"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a NaturalCourt; the field start was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a NaturalCourt; the field start had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // end
            this.end = new End((JSONObject)json_data.get("end"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a NaturalCourt; the field end was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a NaturalCourt; the field end had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // chief
            this.chief = (String)json_data.get("chief");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a NaturalCourt; the field chief was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a NaturalCourt; the field chief had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // id
            this.id = ((Number)json_data.get("id")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a NaturalCourt; the field id was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a NaturalCourt; the field id had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // period
            this.period = ((Number)json_data.get("period")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a NaturalCourt; the field period was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a NaturalCourt; the field period had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}