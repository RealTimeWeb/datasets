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
	
    private Integer forestryIntergovernmental;
    private Integer forestryTotalExpenditure;
    
    
    /*
     * @return 
     */
    public Integer getForestryIntergovernmental() {
        return this.forestryIntergovernmental;
    }
    
    
    
    /*
     * @return 
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
        try {// Forestry Intergovernmental
            this.forestryIntergovernmental = new Integer(((Long)json_data.get("Forestry Intergovernmental")).intValue());// Forestry Total Expenditure
            this.forestryTotalExpenditure = new Integer(((Long)json_data.get("Forestry Total Expenditure")).intValue());
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Forestry; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Forestry; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}