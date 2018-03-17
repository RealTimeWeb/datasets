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
public class Parking {
	
    // Total amount spent on construction, purchase, maintenance, and operation of public-use parking lots, garages, parking meters, and other distinctive parking facilities on a commercial basis.
    private Integer parkingTotal;
    // Money paid to other governments for the construction, purchase, maintenance, and operation of public-use parking lots, garages, parking meters, and other distinctive parking facilities on a commercial basis.
    private Integer parkingIntergovernmental;
    
    
    /**
     * Total amount spent on construction, purchase, maintenance, and operation of public-use parking lots, garages, parking meters, and other distinctive parking facilities on a commercial basis.
     * @return Integer
     */
    public Integer getParkingTotal() {
        return this.parkingTotal;
    }
    
    
    
    /**
     * Money paid to other governments for the construction, purchase, maintenance, and operation of public-use parking lots, garages, parking meters, and other distinctive parking facilities on a commercial basis.
     * @return Integer
     */
    public Integer getParkingIntergovernmental() {
        return this.parkingIntergovernmental;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Parking.
	
	 * @return String
	 */
	public String toString() {
		return "Parking[" +parkingTotal+", "+parkingIntergovernmental+"]";
	}
	
	/**
	 * Internal constructor to create a Parking from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Parking(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Parking Total
            this.parkingTotal = ((Number)json_data.get("Parking Total")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Parking; the field parkingTotal was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Parking; the field parkingTotal had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Parking Intergovernmental
            this.parkingIntergovernmental = ((Number)json_data.get("Parking Intergovernmental")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Parking; the field parkingIntergovernmental was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Parking; the field parkingIntergovernmental had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}