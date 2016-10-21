package corgis.immigration.domain;

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
public class LegalPermanantResidences {
	
    private Integer lastResidence;
    private Integer birth;
    
    
    /*
     * @return 
     */
    public Integer getLastResidence() {
        return this.lastResidence;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getBirth() {
        return this.birth;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this LegalPermanantResidences.
	
	 * @return String
	 */
	public String toString() {
		return "LegalPermanantResidences[" +lastResidence+", "+birth+"]";
	}
	
	/**
	 * Internal constructor to create a LegalPermanantResidences from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public LegalPermanantResidences(JSONObject json_data) {
        try {// Last Residence
            this.lastResidence = ((Number)json_data.get("Last Residence")).intValue();// Birth
            this.birth = ((Number)json_data.get("Birth")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a LegalPermanantResidences; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a LegalPermanantResidences; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}