package corgis.labor.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.labor.domain.White;
import corgis.labor.domain.BlackOrAfricanAmerican;
import corgis.labor.domain.Asian;

/**
 * 
 */
public class CivilianLaborForceParticipationRate {
	
    private White white;
    private BlackOrAfricanAmerican blackOrAfricanAmerican;
    private Asian asian;
    
    
    /*
     * @return 
     */
    public White getWhite() {
        return this.white;
    }
    
    
    
    /*
     * @return 
     */
    public BlackOrAfricanAmerican getBlackOrAfricanAmerican() {
        return this.blackOrAfricanAmerican;
    }
    
    
    
    /*
     * @return 
     */
    public Asian getAsian() {
        return this.asian;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this CivilianLaborForceParticipationRate.
	
	 * @return String
	 */
	public String toString() {
		return "CivilianLaborForceParticipationRate[" +white+", "+blackOrAfricanAmerican+", "+asian+"]";
	}
	
	/**
	 * Internal constructor to create a CivilianLaborForceParticipationRate from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public CivilianLaborForceParticipationRate(JSONObject json_data) {
        try {// White
            this.white = new White((JSONObject)json_data.get("White"));// Black or African American
            this.blackOrAfricanAmerican = new BlackOrAfricanAmerican((JSONObject)json_data.get("Black or African American"));// Asian
            this.asian = new Asian((JSONObject)json_data.get("Asian"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a CivilianLaborForceParticipationRate; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a CivilianLaborForceParticipationRate; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}