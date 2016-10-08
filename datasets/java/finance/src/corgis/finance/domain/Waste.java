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
public class Waste {
	
    private Integer sewerageTotalExpenditure;
    private Integer solidWasteManagementIntergovernmental;
    private Integer sewerageIntergovernmental;
    private Integer solidWasteManagementTotalExpenditure;
    
    
    /*
     * @return 
     */
    public Integer getSewerageTotalExpenditure() {
        return this.sewerageTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getSolidWasteManagementIntergovernmental() {
        return this.solidWasteManagementIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getSewerageIntergovernmental() {
        return this.sewerageIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getSolidWasteManagementTotalExpenditure() {
        return this.solidWasteManagementTotalExpenditure;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Waste.
	
	 * @return String
	 */
	public String toString() {
		return "Waste[" +sewerageTotalExpenditure+", "+solidWasteManagementIntergovernmental+", "+sewerageIntergovernmental+", "+solidWasteManagementTotalExpenditure+"]";
	}
	
	/**
	 * Internal constructor to create a Waste from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Waste(JSONObject json_data) {
        try {// Sewerage Total Expenditure
            this.sewerageTotalExpenditure = ((Number)json_data.get("Sewerage Total Expenditure")).intValue();// Solid Waste Management Intergovernmental
            this.solidWasteManagementIntergovernmental = ((Number)json_data.get("Solid Waste Management Intergovernmental")).intValue();// Sewerage Intergovernmental
            this.sewerageIntergovernmental = ((Number)json_data.get("Sewerage Intergovernmental")).intValue();// Solid Waste Management Total Expenditure
            this.solidWasteManagementTotalExpenditure = ((Number)json_data.get("Solid Waste Management Total Expenditure")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Waste; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Waste; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}