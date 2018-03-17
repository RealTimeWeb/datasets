package corgis.labor.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.labor.domain.BlackOrAfricanAmerican;
import corgis.labor.domain.White;
import corgis.labor.domain.Asian;

/**
 * 
 */
public class CivilianLaborForce {
	
    private BlackOrAfricanAmerican blackOrAfricanAmerican;
    private White white;
    private Asian asian;
    
    
    /**
     * 
     * @return BlackOrAfricanAmerican
     */
    public BlackOrAfricanAmerican getBlackOrAfricanAmerican() {
        return this.blackOrAfricanAmerican;
    }
    
    
    
    /**
     * 
     * @return White
     */
    public White getWhite() {
        return this.white;
    }
    
    
    
    /**
     * 
     * @return Asian
     */
    public Asian getAsian() {
        return this.asian;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this CivilianLaborForce.
	
	 * @return String
	 */
	public String toString() {
		return "CivilianLaborForce[" +blackOrAfricanAmerican+", "+white+", "+asian+"]";
	}
	
	/**
	 * Internal constructor to create a CivilianLaborForce from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public CivilianLaborForce(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Black or African American
            this.blackOrAfricanAmerican = new BlackOrAfricanAmerican((JSONObject)json_data.get("Black or African American"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a CivilianLaborForce; the field blackOrAfricanAmerican was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a CivilianLaborForce; the field blackOrAfricanAmerican had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // White
            this.white = new White((JSONObject)json_data.get("White"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a CivilianLaborForce; the field white was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a CivilianLaborForce; the field white had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Asian
            this.asian = new Asian((JSONObject)json_data.get("Asian"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a CivilianLaborForce; the field asian was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a CivilianLaborForce; the field asian had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}