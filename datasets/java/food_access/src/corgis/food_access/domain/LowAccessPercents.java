package corgis.food_access.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.food_access.domain.LowIncomeAndLowAccess;
import corgis.food_access.domain.LowAccessOnly;

/**
 * 
 */
public class LowAccessPercents {
	
    // Low income is defined as annual family income at or below 200 percent of the Federal poverty threshold for family size.
    private LowIncomeAndLowAccess lowIncomeAndLowAccess;
    private LowAccessOnly lowAccessOnly;
    
    
    /**
     * Low income is defined as annual family income at or below 200 percent of the Federal poverty threshold for family size.
     * @return LowIncomeAndLowAccess
     */
    public LowIncomeAndLowAccess getLowIncomeAndLowAccess() {
        return this.lowIncomeAndLowAccess;
    }
    
    
    
    /**
     * 
     * @return LowAccessOnly
     */
    public LowAccessOnly getLowAccessOnly() {
        return this.lowAccessOnly;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this LowAccessPercents.
	
	 * @return String
	 */
	public String toString() {
		return "LowAccessPercents[" +lowIncomeAndLowAccess+", "+lowAccessOnly+"]";
	}
	
	/**
	 * Internal constructor to create a LowAccessPercents from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public LowAccessPercents(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Low Income and Low Access
            this.lowIncomeAndLowAccess = new LowIncomeAndLowAccess((JSONObject)json_data.get("Low Income and Low Access"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a LowAccessPercents; the field lowIncomeAndLowAccess was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a LowAccessPercents; the field lowIncomeAndLowAccess had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Low Access Only
            this.lowAccessOnly = new LowAccessOnly((JSONObject)json_data.get("Low Access Only"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a LowAccessPercents; the field lowAccessOnly was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a LowAccessPercents; the field lowAccessOnly had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}