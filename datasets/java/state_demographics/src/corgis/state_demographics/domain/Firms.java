package corgis.state_demographics.domain;

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
public class Firms {
	
    private Integer total;
    private Double hispanicOwned;
    private Double nativeHawaiianAndOtherPacificIslanderOwned;
    private Double americanIndianOwned;
    private Double blackOwned;
    private Double asianOwned;
    private Double womenOwned;
    
    
    /*
     * @return 
     */
    public Integer getTotal() {
        return this.total;
    }
    
    
    
    /*
     * @return 
     */
    public Double getHispanicOwned() {
        return this.hispanicOwned;
    }
    
    
    
    /*
     * @return 
     */
    public Double getNativeHawaiianAndOtherPacificIslanderOwned() {
        return this.nativeHawaiianAndOtherPacificIslanderOwned;
    }
    
    
    
    /*
     * @return 
     */
    public Double getAmericanIndianOwned() {
        return this.americanIndianOwned;
    }
    
    
    
    /*
     * @return 
     */
    public Double getBlackOwned() {
        return this.blackOwned;
    }
    
    
    
    /*
     * @return 
     */
    public Double getAsianOwned() {
        return this.asianOwned;
    }
    
    
    
    /*
     * @return 
     */
    public Double getWomenOwned() {
        return this.womenOwned;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Firms.
	
	 * @return String
	 */
	public String toString() {
		return "Firms[" +total+", "+hispanicOwned+", "+nativeHawaiianAndOtherPacificIslanderOwned+", "+americanIndianOwned+", "+blackOwned+", "+asianOwned+", "+womenOwned+"]";
	}
	
	/**
	 * Internal constructor to create a Firms from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Firms(JSONObject json_data) {
        try {// Total
            this.total = ((Number)json_data.get("Total")).intValue();// Hispanic-Owned
            this.hispanicOwned = ((Number)json_data.get("Hispanic-Owned")).doubleValue();// Native Hawaiian and Other Pacific Islander-Owned
            this.nativeHawaiianAndOtherPacificIslanderOwned = ((Number)json_data.get("Native Hawaiian and Other Pacific Islander-Owned")).doubleValue();// American Indian-Owned
            this.americanIndianOwned = ((Number)json_data.get("American Indian-Owned")).doubleValue();// Black-Owned
            this.blackOwned = ((Number)json_data.get("Black-Owned")).doubleValue();// Asian-Owned
            this.asianOwned = ((Number)json_data.get("Asian-Owned")).doubleValue();// Women-Owned
            this.womenOwned = ((Number)json_data.get("Women-Owned")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Firms; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Firms; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}