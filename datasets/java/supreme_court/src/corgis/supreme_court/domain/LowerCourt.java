package corgis.supreme_court.domain;

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
public class LowerCourt {
	
    private String reasons;
    private String direction;
    private String disposition;
    private Boolean disagreement;
    
    
    /**
     * 
     * @return String
     */
    public String getReasons() {
        return this.reasons;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getDirection() {
        return this.direction;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getDisposition() {
        return this.disposition;
    }
    
    
    
    /**
     * 
     * @return Boolean
     */
    public Boolean getDisagreement() {
        return this.disagreement;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this LowerCourt.
	
	 * @return String
	 */
	public String toString() {
		return "LowerCourt[" +reasons+", "+direction+", "+disposition+", "+disagreement+"]";
	}
	
	/**
	 * Internal constructor to create a LowerCourt from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public LowerCourt(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // reasons
            this.reasons = (String)json_data.get("reasons");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a LowerCourt; the field reasons was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a LowerCourt; the field reasons had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // direction
            this.direction = (String)json_data.get("direction");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a LowerCourt; the field direction was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a LowerCourt; the field direction had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // disposition
            this.disposition = (String)json_data.get("disposition");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a LowerCourt; the field disposition was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a LowerCourt; the field disposition had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // disagreement?
            this.disagreement = (Boolean)json_data.get("disagreement?");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a LowerCourt; the field disagreement was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a LowerCourt; the field disagreement had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}