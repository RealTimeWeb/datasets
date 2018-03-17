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
	
    // Total amount spent on outpatient health services, other than hospital care, including: public health administration; research and education; categorical health programs; treatment and immunization clinics; nursing; environmental health activities such as air and water pollution control; ambulance service if provided separately from fire protection services, and other general public health activities such as mosquito abatement. School health services provided by health agencies (rather than school agencies) are included here. Sewage treatment operations are classified under Sewerage.
    private Integer healthTotalExpenditure;
    // Money paid to other governments for the health.
    private Integer healthIntergovernmental;
    private Hospitals hospitals;
    
    
    /**
     * Total amount spent on outpatient health services, other than hospital care, including: public health administration; research and education; categorical health programs; treatment and immunization clinics; nursing; environmental health activities such as air and water pollution control; ambulance service if provided separately from fire protection services, and other general public health activities such as mosquito abatement. School health services provided by health agencies (rather than school agencies) are included here. Sewage treatment operations are classified under Sewerage.
     * @return Integer
     */
    public Integer getHealthTotalExpenditure() {
        return this.healthTotalExpenditure;
    }
    
    
    
    /**
     * Money paid to other governments for the health.
     * @return Integer
     */
    public Integer getHealthIntergovernmental() {
        return this.healthIntergovernmental;
    }
    
    
    
    /**
     * 
     * @return Hospitals
     */
    public Hospitals getHospitals() {
        return this.hospitals;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Health.
	
	 * @return String
	 */
	public String toString() {
		return "Health[" +healthTotalExpenditure+", "+healthIntergovernmental+", "+hospitals+"]";
	}
	
	/**
	 * Internal constructor to create a Health from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Health(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Health Total Expenditure
            this.healthTotalExpenditure = ((Number)json_data.get("Health Total Expenditure")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Health; the field healthTotalExpenditure was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Health; the field healthTotalExpenditure had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Health Intergovernmental
            this.healthIntergovernmental = ((Number)json_data.get("Health Intergovernmental")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Health; the field healthIntergovernmental was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Health; the field healthIntergovernmental had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Hospitals
            this.hospitals = new Hospitals((JSONObject)json_data.get("Hospitals"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Health; the field hospitals was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Health; the field hospitals had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}