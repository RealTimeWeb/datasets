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
	
    // Lawful permanent residents (LPRs), also known as "green card" holders, are non-citizens who are lawfully authorized to live permanently within the United States. This is the number that had their last residence in the associated country.
    private Integer lastResidence;
    // Lawful permanent residents (LPRs), also known as "green card" holders, are non-citizens who are lawfully authorized to live permanently within the United States. This is the number that were from the associated country where they were originally born.
    private Integer birth;
    
    
    /**
     * Lawful permanent residents (LPRs), also known as "green card" holders, are non-citizens who are lawfully authorized to live permanently within the United States. This is the number that had their last residence in the associated country.
     * @return Integer
     */
    public Integer getLastResidence() {
        return this.lastResidence;
    }
    
    
    
    /**
     * Lawful permanent residents (LPRs), also known as "green card" holders, are non-citizens who are lawfully authorized to live permanently within the United States. This is the number that were from the associated country where they were originally born.
     * @return Integer
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
        //System.out.println(json_data);
        
        try {
            // Last Residence
            this.lastResidence = ((Number)json_data.get("Last Residence")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a LegalPermanantResidences; the field lastResidence was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a LegalPermanantResidences; the field lastResidence had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Birth
            this.birth = ((Number)json_data.get("Birth")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a LegalPermanantResidences; the field birth was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a LegalPermanantResidences; the field birth had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}