package corgis.county_demographics.domain;

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
	
    private Double hispanicOwned;
    private Double nativeHawaiianAndOtherPacificIslanderOwned;
    private Integer total;
    private Double blackOwned;
    private Double womenOwned;
    private Double americanIndianOwned;
    private Double asianOwned;
    
    
    /**
     * 
     * @return Double
     */
    public Double getHispanicOwned() {
        return this.hispanicOwned;
    }
    
    
    
    /**
     * 
     * @return Double
     */
    public Double getNativeHawaiianAndOtherPacificIslanderOwned() {
        return this.nativeHawaiianAndOtherPacificIslanderOwned;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getTotal() {
        return this.total;
    }
    
    
    
    /**
     * 
     * @return Double
     */
    public Double getBlackOwned() {
        return this.blackOwned;
    }
    
    
    
    /**
     * 
     * @return Double
     */
    public Double getWomenOwned() {
        return this.womenOwned;
    }
    
    
    
    /**
     * 
     * @return Double
     */
    public Double getAmericanIndianOwned() {
        return this.americanIndianOwned;
    }
    
    
    
    /**
     * 
     * @return Double
     */
    public Double getAsianOwned() {
        return this.asianOwned;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Firms.
	
	 * @return String
	 */
	public String toString() {
		return "Firms[" +hispanicOwned+", "+nativeHawaiianAndOtherPacificIslanderOwned+", "+total+", "+blackOwned+", "+womenOwned+", "+americanIndianOwned+", "+asianOwned+"]";
	}
	
	/**
	 * Internal constructor to create a Firms from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Firms(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Hispanic-Owned
            this.hispanicOwned = ((Number)json_data.get("Hispanic-Owned")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Firms; the field hispanicOwned was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Firms; the field hispanicOwned had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Native Hawaiian and Other Pacific Islander-Owned
            this.nativeHawaiianAndOtherPacificIslanderOwned = ((Number)json_data.get("Native Hawaiian and Other Pacific Islander-Owned")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Firms; the field nativeHawaiianAndOtherPacificIslanderOwned was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Firms; the field nativeHawaiianAndOtherPacificIslanderOwned had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Total
            this.total = ((Number)json_data.get("Total")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Firms; the field total was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Firms; the field total had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Black-Owned
            this.blackOwned = ((Number)json_data.get("Black-Owned")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Firms; the field blackOwned was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Firms; the field blackOwned had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Women-Owned
            this.womenOwned = ((Number)json_data.get("Women-Owned")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Firms; the field womenOwned was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Firms; the field womenOwned had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // American Indian-Owned
            this.americanIndianOwned = ((Number)json_data.get("American Indian-Owned")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Firms; the field americanIndianOwned was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Firms; the field americanIndianOwned had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Asian-Owned
            this.asianOwned = ((Number)json_data.get("Asian-Owned")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Firms; the field asianOwned was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Firms; the field asianOwned had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}