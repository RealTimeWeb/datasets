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
public class Highways {
	
    // Money paid to other governments for the construction, maintenance, and operation of highways, streets, and related structures, including toll highways, bridges, tunnels, ferries, street lighting and snow and ice removal. However, highway policing and traffic control are classed under Police protection.
    private Integer regularHighwaysIntergovernmental;
    // Total amount spent on the support of construction, maintenance, and operation toll highways.
    private Integer tollHighwaysTotalExpenditure;
    // Payments to employees, suppliers, contractors, beneficiaries, and other final recipients of government payments (i.e., all expenditure other than Intergovernmental expenditure) for the support of construction, maintenance, and operation of highways, streets, and related structures, including toll highways, bridges, tunnels, ferries, street lighting and snow and ice removal. However, highway policing and traffic control are classed under Police protection.
    private Integer highwaysDirect;
    // Money paid to other governments for the support of construction, maintenance, and operation of highways, streets, and related structures, including toll highways, bridges, tunnels, ferries, street lighting and snow and ice removal. However, highway policing and traffic control are classed under Police protection.
    private Integer highwaysIntergovernmental;
    // Total amount spent on the support of construction, maintenance, and operation of highways, streets, and related structures, including toll highways, bridges, tunnels, ferries, street lighting and snow and ice removal. However, highway policing and traffic control are classed under Police protection.
    private Integer highwaysTotalExpenditure;
    // Total amount spent on highways land and equipment.
    private Integer highwaysLandAndEquipment;
    // Total amount spent on highway construction.
    private Integer highwaysConstructionTotal;
    // Total amount spent on regular highways.
    private Integer regularHighwaysTotalExpenditure;
    
    
    /*
     * @return 
     */
    public Integer getRegularHighwaysIntergovernmental() {
        return this.regularHighwaysIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getTollHighwaysTotalExpenditure() {
        return this.tollHighwaysTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getHighwaysDirect() {
        return this.highwaysDirect;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getHighwaysIntergovernmental() {
        return this.highwaysIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getHighwaysTotalExpenditure() {
        return this.highwaysTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getHighwaysLandAndEquipment() {
        return this.highwaysLandAndEquipment;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getHighwaysConstructionTotal() {
        return this.highwaysConstructionTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getRegularHighwaysTotalExpenditure() {
        return this.regularHighwaysTotalExpenditure;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Highways.
	
	 * @return String
	 */
	public String toString() {
		return "Highways[" +regularHighwaysIntergovernmental+", "+tollHighwaysTotalExpenditure+", "+highwaysDirect+", "+highwaysIntergovernmental+", "+highwaysTotalExpenditure+", "+highwaysLandAndEquipment+", "+highwaysConstructionTotal+", "+regularHighwaysTotalExpenditure+"]";
	}
	
	/**
	 * Internal constructor to create a Highways from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Highways(JSONObject json_data) {
        try {// Regular Highways Intergovernmental
            this.regularHighwaysIntergovernmental = ((Number)json_data.get("Regular Highways Intergovernmental")).intValue();// Toll Highways Total Expenditure
            this.tollHighwaysTotalExpenditure = ((Number)json_data.get("Toll Highways Total Expenditure")).intValue();// Highways Direct
            this.highwaysDirect = ((Number)json_data.get("Highways Direct")).intValue();// Highways Intergovernmental
            this.highwaysIntergovernmental = ((Number)json_data.get("Highways Intergovernmental")).intValue();// Highways Total Expenditure
            this.highwaysTotalExpenditure = ((Number)json_data.get("Highways Total Expenditure")).intValue();// Highways Land and Equipment
            this.highwaysLandAndEquipment = ((Number)json_data.get("Highways Land and Equipment")).intValue();// Highways Construction Total
            this.highwaysConstructionTotal = ((Number)json_data.get("Highways Construction Total")).intValue();// Regular Highways Total Expenditure
            this.regularHighwaysTotalExpenditure = ((Number)json_data.get("Regular Highways Total Expenditure")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Highways; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Highways; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}