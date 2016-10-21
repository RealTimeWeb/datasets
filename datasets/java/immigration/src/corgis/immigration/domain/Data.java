package corgis.immigration.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.immigration.domain.Enforcement;
import corgis.immigration.domain.LegalPermanantResidences;
import corgis.immigration.domain.Refugees;
import corgis.immigration.domain.NonimmigrantAdmissions;

/**
 * 
 */
public class Data {
	
    private Enforcement enforcement;
    private LegalPermanantResidences legalPermanantResidences;
    private Integer naturalizationsBirth;
    private Refugees refugees;
    private NonimmigrantAdmissions nonimmigrantAdmissions;
    
    
    /*
     * @return 
     */
    public Enforcement getEnforcement() {
        return this.enforcement;
    }
    
    
    
    /*
     * @return 
     */
    public LegalPermanantResidences getLegalPermanantResidences() {
        return this.legalPermanantResidences;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getNaturalizationsBirth() {
        return this.naturalizationsBirth;
    }
    
    
    
    /*
     * @return 
     */
    public Refugees getRefugees() {
        return this.refugees;
    }
    
    
    
    /*
     * @return 
     */
    public NonimmigrantAdmissions getNonimmigrantAdmissions() {
        return this.nonimmigrantAdmissions;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Data.
	
	 * @return String
	 */
	public String toString() {
		return "Data[" +enforcement+", "+legalPermanantResidences+", "+naturalizationsBirth+", "+refugees+", "+nonimmigrantAdmissions+"]";
	}
	
	/**
	 * Internal constructor to create a Data from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Data(JSONObject json_data) {
        try {// Enforcement
            this.enforcement = new Enforcement((JSONObject)json_data.get("Enforcement"));// Legal permanant residences
            this.legalPermanantResidences = new LegalPermanantResidences((JSONObject)json_data.get("Legal permanant residences"));// Naturalizations (Birth)
            this.naturalizationsBirth = ((Number)json_data.get("Naturalizations (Birth)")).intValue();// Refugees
            this.refugees = new Refugees((JSONObject)json_data.get("Refugees"));// Nonimmigrant Admissions
            this.nonimmigrantAdmissions = new NonimmigrantAdmissions((JSONObject)json_data.get("Nonimmigrant Admissions"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}