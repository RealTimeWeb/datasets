package corgis.retail_services.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.retail_services.domain.Sales;
import corgis.retail_services.domain.Ratio;
import corgis.retail_services.domain.Inventories;

/**
 * 
 */
public class Data {
	
    private Sales sales;
    private Ratio ratio;
    private Inventories inventories;
    
    
    /**
     * 
     * @return Sales
     */
    public Sales getSales() {
        return this.sales;
    }
    
    
    
    /**
     * 
     * @return Ratio
     */
    public Ratio getRatio() {
        return this.ratio;
    }
    
    
    
    /**
     * 
     * @return Inventories
     */
    public Inventories getInventories() {
        return this.inventories;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Data.
	
	 * @return String
	 */
	public String toString() {
		return "Data[" +sales+", "+ratio+", "+inventories+"]";
	}
	
	/**
	 * Internal constructor to create a Data from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Data(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // sales
            this.sales = new Sales((JSONObject)json_data.get("sales"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field sales was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field sales had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // ratio
            this.ratio = new Ratio((JSONObject)json_data.get("ratio"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field ratio was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field ratio had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // inventories
            this.inventories = new Inventories((JSONObject)json_data.get("inventories"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field inventories was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field inventories had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}