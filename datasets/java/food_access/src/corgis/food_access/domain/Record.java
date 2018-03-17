package corgis.food_access.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.food_access.domain.VehicleAccess;
import corgis.food_access.domain.HousingData;
import corgis.food_access.domain.LowAccessPercents;
import corgis.food_access.domain.LowAccessNumbers;

/**
 * 
 */
public class Record {
	
    private String county;
    // Housing units without vehicle access and low access as specified distance
    private VehicleAccess vehicleAccess;
    private HousingData housingData;
    // Percents are number of Census Tracts with listed classification divided by total tracts for the county
    private LowAccessPercents lowAccessPercents;
    private Integer population;
    private String state;
    // Numbers are summation of the Census Tracts for each county, distances refer to distance that an individual has to travel to access supermarkets, supercenters, grocery stores, or other sources of healthy and affordable food.
    private LowAccessNumbers lowAccessNumbers;
    
    
    /**
     * 
     * @return String
     */
    public String getCounty() {
        return this.county;
    }
    
    
    
    /**
     * Housing units without vehicle access and low access as specified distance
     * @return VehicleAccess
     */
    public VehicleAccess getVehicleAccess() {
        return this.vehicleAccess;
    }
    
    
    
    /**
     * 
     * @return HousingData
     */
    public HousingData getHousingData() {
        return this.housingData;
    }
    
    
    
    /**
     * Percents are number of Census Tracts with listed classification divided by total tracts for the county
     * @return LowAccessPercents
     */
    public LowAccessPercents getLowAccessPercents() {
        return this.lowAccessPercents;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getPopulation() {
        return this.population;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getState() {
        return this.state;
    }
    
    
    
    /**
     * Numbers are summation of the Census Tracts for each county, distances refer to distance that an individual has to travel to access supermarkets, supercenters, grocery stores, or other sources of healthy and affordable food.
     * @return LowAccessNumbers
     */
    public LowAccessNumbers getLowAccessNumbers() {
        return this.lowAccessNumbers;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Record.
	
	 * @return String
	 */
	public String toString() {
		return "Record[" +county+", "+vehicleAccess+", "+housingData+", "+lowAccessPercents+", "+population+", "+state+", "+lowAccessNumbers+"]";
	}
	
	/**
	 * Internal constructor to create a Record from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Record(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // County
            this.county = (String)json_data.get("County");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Record; the field county was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Record; the field county had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Vehicle Access
            this.vehicleAccess = new VehicleAccess((JSONObject)json_data.get("Vehicle Access"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Record; the field vehicleAccess was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Record; the field vehicleAccess had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Housing Data
            this.housingData = new HousingData((JSONObject)json_data.get("Housing Data"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Record; the field housingData was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Record; the field housingData had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Low Access Percents
            this.lowAccessPercents = new LowAccessPercents((JSONObject)json_data.get("Low Access Percents"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Record; the field lowAccessPercents was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Record; the field lowAccessPercents had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Population
            this.population = ((Number)json_data.get("Population")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Record; the field population was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Record; the field population had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // State
            this.state = (String)json_data.get("State");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Record; the field state was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Record; the field state had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Low Access Numbers
            this.lowAccessNumbers = new LowAccessNumbers((JSONObject)json_data.get("Low Access Numbers"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Record; the field lowAccessNumbers was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Record; the field lowAccessNumbers had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}