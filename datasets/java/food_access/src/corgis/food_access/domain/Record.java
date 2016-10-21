package corgis.food_access.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.food_access.domain.LowAccessNumbers;
import corgis.food_access.domain.VehicleAccess;
import corgis.food_access.domain.HousingData;
import corgis.food_access.domain.LowAccessPercents;

/**
 * 
 */
public class Record {
	
    // Numbers are summation of the Census Tracts for each county, distances refer to distance that an individual has to travel to access supermarkets, supercenters, grocery stores, or other sources of healthy and affordable food.
    private LowAccessNumbers lowAccessNumbers;
    // Housing units without vehicle access and low access as specified distance
    private VehicleAccess vehicleAccess;
    private HousingData housingData;
    private String county;
    // Percents are number of Census Tracts with listed classification divided by total tracts for the county
    private LowAccessPercents lowAccessPercents;
    private String state;
    private Integer population;
    
    
    /*
     * @return 
     */
    public LowAccessNumbers getLowAccessNumbers() {
        return this.lowAccessNumbers;
    }
    
    
    
    /*
     * @return 
     */
    public VehicleAccess getVehicleAccess() {
        return this.vehicleAccess;
    }
    
    
    
    /*
     * @return 
     */
    public HousingData getHousingData() {
        return this.housingData;
    }
    
    
    
    /*
     * @return 
     */
    public String getCounty() {
        return this.county;
    }
    
    
    
    /*
     * @return 
     */
    public LowAccessPercents getLowAccessPercents() {
        return this.lowAccessPercents;
    }
    
    
    
    /*
     * @return 
     */
    public String getState() {
        return this.state;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getPopulation() {
        return this.population;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Record.
	
	 * @return String
	 */
	public String toString() {
		return "Record[" +lowAccessNumbers+", "+vehicleAccess+", "+housingData+", "+county+", "+lowAccessPercents+", "+state+", "+population+"]";
	}
	
	/**
	 * Internal constructor to create a Record from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Record(JSONObject json_data) {
        try {// Low Access Numbers
            this.lowAccessNumbers = new LowAccessNumbers((JSONObject)json_data.get("Low Access Numbers"));// Vehicle Access
            this.vehicleAccess = new VehicleAccess((JSONObject)json_data.get("Vehicle Access"));// Housing Data
            this.housingData = new HousingData((JSONObject)json_data.get("Housing Data"));// County
            this.county = (String)json_data.get("County");// Low Access Percents
            this.lowAccessPercents = new LowAccessPercents((JSONObject)json_data.get("Low Access Percents"));// State
            this.state = (String)json_data.get("State");// Population
            this.population = ((Number)json_data.get("Population")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Record; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Record; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}