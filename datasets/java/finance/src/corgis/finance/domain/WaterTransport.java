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
public class WaterTransport {
	
    // Money paid to other governments for the construction, maintenance, operation, and support of canals and other waterways, harbors, docks, wharves, and related marine terminal facilities.
    private Integer waterTransportIntergovernmental;
    // Total amount spent on construction, maintenance, operation, and support of canals and other waterways, harbors, docks, wharves, and related marine terminal facilities.
    private Integer waterTransportTotalExpenditure;
    
    
    /**
     * Money paid to other governments for the construction, maintenance, operation, and support of canals and other waterways, harbors, docks, wharves, and related marine terminal facilities.
     * @return Integer
     */
    public Integer getWaterTransportIntergovernmental() {
        return this.waterTransportIntergovernmental;
    }
    
    
    
    /**
     * Total amount spent on construction, maintenance, operation, and support of canals and other waterways, harbors, docks, wharves, and related marine terminal facilities.
     * @return Integer
     */
    public Integer getWaterTransportTotalExpenditure() {
        return this.waterTransportTotalExpenditure;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this WaterTransport.
	
	 * @return String
	 */
	public String toString() {
		return "WaterTransport[" +waterTransportIntergovernmental+", "+waterTransportTotalExpenditure+"]";
	}
	
	/**
	 * Internal constructor to create a WaterTransport from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public WaterTransport(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Water Transport Intergovernmental
            this.waterTransportIntergovernmental = ((Number)json_data.get("Water Transport Intergovernmental")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a WaterTransport; the field waterTransportIntergovernmental was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a WaterTransport; the field waterTransportIntergovernmental had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Water Transport Total Expenditure
            this.waterTransportTotalExpenditure = ((Number)json_data.get("Water Transport Total Expenditure")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a WaterTransport; the field waterTransportTotalExpenditure was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a WaterTransport; the field waterTransportTotalExpenditure had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}