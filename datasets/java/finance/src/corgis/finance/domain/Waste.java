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
	
    // Money paid to other governments for street cleaning, solid waste collection and disposal, and provision of sanitary landfills.
    private Integer solidWasteManagementIntergovernmental;
    // Total amount spent on the provision of sanitary and storm sewers and sewage disposal facilities and services, and payments to other governments for such purposes.
    private Integer solidWasteManagementTotalExpenditure;
    // Total amount spent on the provision of sanitary and storm sewers and sewage disposal facilities and services, and payments to other governments for such purposes.
    private Integer sewerageTotalExpenditure;
    // Money paid to other governments for the provision of sanitary and storm sewers and sewage disposal facilities and services, and payments to other governments for such purposes.
    private Integer sewerageIntergovernmental;
    
    
    /**
     * Money paid to other governments for street cleaning, solid waste collection and disposal, and provision of sanitary landfills.
     * @return Integer
     */
    public Integer getSolidWasteManagementIntergovernmental() {
        return this.solidWasteManagementIntergovernmental;
    }
    
    
    
    /**
     * Total amount spent on the provision of sanitary and storm sewers and sewage disposal facilities and services, and payments to other governments for such purposes.
     * @return Integer
     */
    public Integer getSolidWasteManagementTotalExpenditure() {
        return this.solidWasteManagementTotalExpenditure;
    }
    
    
    
    /**
     * Total amount spent on the provision of sanitary and storm sewers and sewage disposal facilities and services, and payments to other governments for such purposes.
     * @return Integer
     */
    public Integer getSewerageTotalExpenditure() {
        return this.sewerageTotalExpenditure;
    }
    
    
    
    /**
     * Money paid to other governments for the provision of sanitary and storm sewers and sewage disposal facilities and services, and payments to other governments for such purposes.
     * @return Integer
     */
    public Integer getSewerageIntergovernmental() {
        return this.sewerageIntergovernmental;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Waste.
	
	 * @return String
	 */
	public String toString() {
		return "Waste[" +solidWasteManagementIntergovernmental+", "+solidWasteManagementTotalExpenditure+", "+sewerageTotalExpenditure+", "+sewerageIntergovernmental+"]";
	}
	
	/**
	 * Internal constructor to create a Waste from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Waste(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Solid Waste Management Intergovernmental
            this.solidWasteManagementIntergovernmental = ((Number)json_data.get("Solid Waste Management Intergovernmental")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Waste; the field solidWasteManagementIntergovernmental was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Waste; the field solidWasteManagementIntergovernmental had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Solid Waste Management Total Expenditure
            this.solidWasteManagementTotalExpenditure = ((Number)json_data.get("Solid Waste Management Total Expenditure")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Waste; the field solidWasteManagementTotalExpenditure was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Waste; the field solidWasteManagementTotalExpenditure had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Sewerage Total Expenditure
            this.sewerageTotalExpenditure = ((Number)json_data.get("Sewerage Total Expenditure")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Waste; the field sewerageTotalExpenditure was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Waste; the field sewerageTotalExpenditure had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Sewerage Intergovernmental
            this.sewerageIntergovernmental = ((Number)json_data.get("Sewerage Intergovernmental")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Waste; the field sewerageIntergovernmental was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Waste; the field sewerageIntergovernmental had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}