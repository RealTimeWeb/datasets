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
public class Forestry {
	
    // Money paid to other governments for the support of forestry.
    private Integer forestryIntergovernmental;
    // Total amount spent on the support of foresty.
    private Integer forestryTotalExpenditure;
    
    
    /**
     * Money paid to other governments for the support of forestry.
     * @return Integer
     */
    public Integer getForestryIntergovernmental() {
        return this.forestryIntergovernmental;
    }
    
    
    
    /**
     * Total amount spent on the support of foresty.
     * @return Integer
     */
    public Integer getForestryTotalExpenditure() {
        return this.forestryTotalExpenditure;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Forestry.
	
	 * @return String
	 */
	public String toString() {
		return "Forestry[" +forestryIntergovernmental+", "+forestryTotalExpenditure+"]";
	}
	
	/**
	 * Internal constructor to create a Forestry from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Forestry(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Forestry Intergovernmental
            this.forestryIntergovernmental = ((Number)json_data.get("Forestry Intergovernmental")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Forestry; the field forestryIntergovernmental was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Forestry; the field forestryIntergovernmental had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Forestry Total Expenditure
            this.forestryTotalExpenditure = ((Number)json_data.get("Forestry Total Expenditure")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Forestry; the field forestryTotalExpenditure was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Forestry; the field forestryTotalExpenditure had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}