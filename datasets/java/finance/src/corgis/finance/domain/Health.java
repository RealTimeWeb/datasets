package corgis.finance.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.finance.domain.Hospitals;

/**
 * 
 */
public class Health {
	
    private Integer healthTotalExpenditure;
    private Hospitals hospitals;
    private Integer healthIntergovernmental;
    
    
    /*
     * @return 
     */
    public Integer getHealthTotalExpenditure() {
        return this.healthTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Hospitals getHospitals() {
        return this.hospitals;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getHealthIntergovernmental() {
        return this.healthIntergovernmental;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Health.
	
	 * @return String
	 */
	public String toString() {
		return "Health[" +healthTotalExpenditure+", "+hospitals+", "+healthIntergovernmental+"]";
	}
	
	/**
	 * Internal constructor to create a Health from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Health(JSONObject json_data) {
        try {// Health Total Expenditure
            this.healthTotalExpenditure = new Integer(((Long)json_data.get("Health Total Expenditure")).intValue());// Hospitals
            this.hospitals = new Hospitals((JSONObject)json_data.get("Hospitals"));// Health Intergovernmental
            this.healthIntergovernmental = new Integer(((Long)json_data.get("Health Intergovernmental")).intValue());
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Health; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Health; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}