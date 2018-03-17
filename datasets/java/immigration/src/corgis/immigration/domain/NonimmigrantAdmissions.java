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
public class NonimmigrantAdmissions {
	
    // Nonimmigrants are foreign nationals granted temporary admission into the United States. The major purposes for which nonimmigrant admission may be authorized include temporary visits for business or pleasure, academic or vocational study, temporary employment, or to act as a representative of a foreign government or international organization, among others. This is the number that had their last residence in the associated country.
    private Integer lastResidence;
    // Nonimmigrants are foreign nationals granted temporary admission into the United States. The major purposes for which nonimmigrant admission may be authorized include temporary visits for business or pleasure, academic or vocational study, temporary employment, or to act as a representative of a foreign government or international organization, among others. This is the number that were entered this year from the associated country.
    private Integer birth;
    
    
    /**
     * Nonimmigrants are foreign nationals granted temporary admission into the United States. The major purposes for which nonimmigrant admission may be authorized include temporary visits for business or pleasure, academic or vocational study, temporary employment, or to act as a representative of a foreign government or international organization, among others. This is the number that had their last residence in the associated country.
     * @return Integer
     */
    public Integer getLastResidence() {
        return this.lastResidence;
    }
    
    
    
    /**
     * Nonimmigrants are foreign nationals granted temporary admission into the United States. The major purposes for which nonimmigrant admission may be authorized include temporary visits for business or pleasure, academic or vocational study, temporary employment, or to act as a representative of a foreign government or international organization, among others. This is the number that were entered this year from the associated country.
     * @return Integer
     */
    public Integer getBirth() {
        return this.birth;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this NonimmigrantAdmissions.
	
	 * @return String
	 */
	public String toString() {
		return "NonimmigrantAdmissions[" +lastResidence+", "+birth+"]";
	}
	
	/**
	 * Internal constructor to create a NonimmigrantAdmissions from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public NonimmigrantAdmissions(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Last Residence
            this.lastResidence = ((Number)json_data.get("Last Residence")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a NonimmigrantAdmissions; the field lastResidence was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a NonimmigrantAdmissions; the field lastResidence had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Birth
            this.birth = ((Number)json_data.get("Birth")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a NonimmigrantAdmissions; the field birth was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a NonimmigrantAdmissions; the field birth had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}