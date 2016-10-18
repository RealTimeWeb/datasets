package corgis.finance.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.finance.domain.Airports;
import corgis.finance.domain.Highways;
import corgis.finance.domain.WaterTransport;
import corgis.finance.domain.Parking;

/**
 * 
 */
public class Transportation {
	
    private Integer transitSubsidyIntergovernmental;
    private Airports airports;
    private Integer transitSubsidyTotalExpenditure;
    private Highways highways;
    private WaterTransport waterTransport;
    private Parking parking;
    
    
    /*
     * @return 
     */
    public Integer getTransitSubsidyIntergovernmental() {
        return this.transitSubsidyIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Airports getAirports() {
        return this.airports;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getTransitSubsidyTotalExpenditure() {
        return this.transitSubsidyTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Highways getHighways() {
        return this.highways;
    }
    
    
    
    /*
     * @return 
     */
    public WaterTransport getWaterTransport() {
        return this.waterTransport;
    }
    
    
    
    /*
     * @return 
     */
    public Parking getParking() {
        return this.parking;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Transportation.
	
	 * @return String
	 */
	public String toString() {
		return "Transportation[" +transitSubsidyIntergovernmental+", "+airports+", "+transitSubsidyTotalExpenditure+", "+highways+", "+waterTransport+", "+parking+"]";
	}
	
	/**
	 * Internal constructor to create a Transportation from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Transportation(JSONObject json_data) {
        try {// Transit Subsidy Intergovernmental
            this.transitSubsidyIntergovernmental = ((Number)json_data.get("Transit Subsidy Intergovernmental")).intValue();// Airports
            this.airports = new Airports((JSONObject)json_data.get("Airports"));// Transit Subsidy Total Expenditure
            this.transitSubsidyTotalExpenditure = ((Number)json_data.get("Transit Subsidy Total Expenditure")).intValue();// Highways
            this.highways = new Highways((JSONObject)json_data.get("Highways"));// Water Transport
            this.waterTransport = new WaterTransport((JSONObject)json_data.get("Water Transport"));// Parking
            this.parking = new Parking((JSONObject)json_data.get("Parking"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Transportation; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Transportation; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}