package corgis.retail_services.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.retail_services.domain.Inventories;
import corgis.retail_services.domain.Ratio;
import corgis.retail_services.domain.Sales;

/**
 * 
 */
public class Data {
	
    private Inventories inventories;
    private Ratio ratio;
    private Sales sales;
    
    
    /*
     * @return 
     */
    public Inventories getInventories() {
        return this.inventories;
    }
    
    
    
    /*
     * @return 
     */
    public Ratio getRatio() {
        return this.ratio;
    }
    
    
    
    /*
     * @return 
     */
    public Sales getSales() {
        return this.sales;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Data.
	
	 * @return String
	 */
	public String toString() {
		return "Data[" +inventories+", "+ratio+", "+sales+"]";
	}
	
	/**
	 * Internal constructor to create a Data from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Data(JSONObject json_data) {
        try {// inventories
            this.inventories = new Inventories((JSONObject)json_data.get("inventories"));// ratio
            this.ratio = new Ratio((JSONObject)json_data.get("ratio"));// sales
            this.sales = new Sales((JSONObject)json_data.get("sales"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}