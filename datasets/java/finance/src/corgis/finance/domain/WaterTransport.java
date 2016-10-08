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
	
    private Integer waterTransportIntergovernmental;
    private Integer waterTransportTotalExpenditure;
    
    
    /*
     * @return 
     */
    public Integer getWaterTransportIntergovernmental() {
        return this.waterTransportIntergovernmental;
    }
    
    
    
    /*
     * @return 
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
        try {// Water Transport Intergovernmental
            this.waterTransportIntergovernmental = ((Number)json_data.get("Water Transport Intergovernmental")).intValue();// Water Transport Total Expenditure
            this.waterTransportTotalExpenditure = ((Number)json_data.get("Water Transport Total Expenditure")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a WaterTransport; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a WaterTransport; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}