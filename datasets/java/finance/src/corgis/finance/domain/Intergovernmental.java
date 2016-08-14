package corgis.finance.domain;

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
public class Intergovernmental {
	
    private Integer intergovernmentalToCombinedAndUnallocable;
    private Integer intergovernmentalToFederal;
    private Integer intergovernmentalToMunicipalities;
    private Integer intergovernmentalToCounties;
    private Integer intergovernmentalToState;
    private Integer intergovernmentalToTownships;
    private Integer intergovernmentalToSpecialDistricts;
    private Integer intergovernmentalExpenditure;
    private Integer intergovernmentalToLocal;
    private Integer intergovernmentalToSchoolDistricts;
    
    
    /*
     * @return 
     */
    public Integer getIntergovernmentalToCombinedAndUnallocable() {
        return this.intergovernmentalToCombinedAndUnallocable;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getIntergovernmentalToFederal() {
        return this.intergovernmentalToFederal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getIntergovernmentalToMunicipalities() {
        return this.intergovernmentalToMunicipalities;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getIntergovernmentalToCounties() {
        return this.intergovernmentalToCounties;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getIntergovernmentalToState() {
        return this.intergovernmentalToState;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getIntergovernmentalToTownships() {
        return this.intergovernmentalToTownships;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getIntergovernmentalToSpecialDistricts() {
        return this.intergovernmentalToSpecialDistricts;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getIntergovernmentalExpenditure() {
        return this.intergovernmentalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getIntergovernmentalToLocal() {
        return this.intergovernmentalToLocal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getIntergovernmentalToSchoolDistricts() {
        return this.intergovernmentalToSchoolDistricts;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Intergovernmental.
	
	 * @return String
	 */
	public String toString() {
		return "Intergovernmental[" +intergovernmentalToCombinedAndUnallocable+", "+intergovernmentalToFederal+", "+intergovernmentalToMunicipalities+", "+intergovernmentalToCounties+", "+intergovernmentalToState+", "+intergovernmentalToTownships+", "+intergovernmentalToSpecialDistricts+", "+intergovernmentalExpenditure+", "+intergovernmentalToLocal+", "+intergovernmentalToSchoolDistricts+"]";
	}
	
	/**
	 * Internal constructor to create a Intergovernmental from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Intergovernmental(JSONObject json_data) {
        try {// Intergovernmental to Combined and Unallocable
            this.intergovernmentalToCombinedAndUnallocable = new Integer(((Long)json_data.get("Intergovernmental to Combined and Unallocable")).intValue());// Intergovernmental to Federal
            this.intergovernmentalToFederal = new Integer(((Long)json_data.get("Intergovernmental to Federal")).intValue());// Intergovernmental to Municipalities
            this.intergovernmentalToMunicipalities = new Integer(((Long)json_data.get("Intergovernmental to Municipalities")).intValue());// Intergovernmental to Counties
            this.intergovernmentalToCounties = new Integer(((Long)json_data.get("Intergovernmental to Counties")).intValue());// Intergovernmental to State
            this.intergovernmentalToState = new Integer(((Long)json_data.get("Intergovernmental to State")).intValue());// Intergovernmental to Townships
            this.intergovernmentalToTownships = new Integer(((Long)json_data.get("Intergovernmental to Townships")).intValue());// Intergovernmental to Special Districts
            this.intergovernmentalToSpecialDistricts = new Integer(((Long)json_data.get("Intergovernmental to Special Districts")).intValue());// Intergovernmental Expenditure
            this.intergovernmentalExpenditure = new Integer(((Long)json_data.get("Intergovernmental Expenditure")).intValue());// Intergovernmental to Local
            this.intergovernmentalToLocal = new Integer(((Long)json_data.get("Intergovernmental to Local")).intValue());// Intergovernmental to School Districts
            this.intergovernmentalToSchoolDistricts = new Integer(((Long)json_data.get("Intergovernmental to School Districts")).intValue());
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Intergovernmental; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Intergovernmental; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}