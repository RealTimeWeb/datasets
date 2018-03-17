package corgis.finance.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.finance.domain.WaterTransport;
import corgis.finance.domain.Parking;
import corgis.finance.domain.Airports;
import corgis.finance.domain.Highways;

/**
 * 
 */
public class Transportation {
	
    private WaterTransport waterTransport;
    // Money paid to other governments in support of subway, bus, surface rail and street railroad, and other passenger transportation systems., including public support of a private utility or railroad and intergovernmental subsidy payments. Excludes amounts paid by a parent government to its dependent transit utility.
    private Integer transitSubsidyIntergovernmental;
    // Total amount spent in support of subway, bus, surface rail and street railroad, and other passenger transportation systems., including public support of a private utility or railroad and intergovernmental subsidy payments. Excludes amounts paid by a parent government to its dependent transit utility.
    private Integer transitSubsidyTotalExpenditure;
    private Parking parking;
    private Airports airports;
    private Highways highways;
    
    
    /**
     * 
     * @return WaterTransport
     */
    public WaterTransport getWaterTransport() {
        return this.waterTransport;
    }
    
    
    
    /**
     * Money paid to other governments in support of subway, bus, surface rail and street railroad, and other passenger transportation systems., including public support of a private utility or railroad and intergovernmental subsidy payments. Excludes amounts paid by a parent government to its dependent transit utility.
     * @return Integer
     */
    public Integer getTransitSubsidyIntergovernmental() {
        return this.transitSubsidyIntergovernmental;
    }
    
    
    
    /**
     * Total amount spent in support of subway, bus, surface rail and street railroad, and other passenger transportation systems., including public support of a private utility or railroad and intergovernmental subsidy payments. Excludes amounts paid by a parent government to its dependent transit utility.
     * @return Integer
     */
    public Integer getTransitSubsidyTotalExpenditure() {
        return this.transitSubsidyTotalExpenditure;
    }
    
    
    
    /**
     * 
     * @return Parking
     */
    public Parking getParking() {
        return this.parking;
    }
    
    
    
    /**
     * 
     * @return Airports
     */
    public Airports getAirports() {
        return this.airports;
    }
    
    
    
    /**
     * 
     * @return Highways
     */
    public Highways getHighways() {
        return this.highways;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Transportation.
	
	 * @return String
	 */
	public String toString() {
		return "Transportation[" +waterTransport+", "+transitSubsidyIntergovernmental+", "+transitSubsidyTotalExpenditure+", "+parking+", "+airports+", "+highways+"]";
	}
	
	/**
	 * Internal constructor to create a Transportation from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Transportation(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Water Transport
            this.waterTransport = new WaterTransport((JSONObject)json_data.get("Water Transport"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Transportation; the field waterTransport was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Transportation; the field waterTransport had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Transit Subsidy Intergovernmental
            this.transitSubsidyIntergovernmental = ((Number)json_data.get("Transit Subsidy Intergovernmental")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Transportation; the field transitSubsidyIntergovernmental was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Transportation; the field transitSubsidyIntergovernmental had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Transit Subsidy Total Expenditure
            this.transitSubsidyTotalExpenditure = ((Number)json_data.get("Transit Subsidy Total Expenditure")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Transportation; the field transitSubsidyTotalExpenditure was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Transportation; the field transitSubsidyTotalExpenditure had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Parking
            this.parking = new Parking((JSONObject)json_data.get("Parking"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Transportation; the field parking was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Transportation; the field parking had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Airports
            this.airports = new Airports((JSONObject)json_data.get("Airports"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Transportation; the field airports was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Transportation; the field airports had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Highways
            this.highways = new Highways((JSONObject)json_data.get("Highways"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Transportation; the field highways was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Transportation; the field highways had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}