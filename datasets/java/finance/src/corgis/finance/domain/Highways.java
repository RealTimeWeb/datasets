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
	
    private Integer regularHighwaysIntergovernmental;
    private Integer tollHighwaysTotalExpenditure;
    private Integer highwaysDirect;
    private Integer highwaysIntergovernmental;
    private Integer highwaysTotalExpenditure;
    private Integer highwaysLandAndEquipment;
    private Integer highwaysConstructionTotal;
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
            this.regularHighwaysIntergovernmental = new Integer(((Long)json_data.get("Regular Highways Intergovernmental")).intValue());// Toll Highways Total Expenditure
            this.tollHighwaysTotalExpenditure = new Integer(((Long)json_data.get("Toll Highways Total Expenditure")).intValue());// Highways Direct
            this.highwaysDirect = new Integer(((Long)json_data.get("Highways Direct")).intValue());// Highways Intergovernmental
            this.highwaysIntergovernmental = new Integer(((Long)json_data.get("Highways Intergovernmental")).intValue());// Highways Total Expenditure
            this.highwaysTotalExpenditure = new Integer(((Long)json_data.get("Highways Total Expenditure")).intValue());// Highways Land and Equipment
            this.highwaysLandAndEquipment = new Integer(((Long)json_data.get("Highways Land and Equipment")).intValue());// Highways Construction Total
            this.highwaysConstructionTotal = new Integer(((Long)json_data.get("Highways Construction Total")).intValue());// Regular Highways Total Expenditure
            this.regularHighwaysTotalExpenditure = new Integer(((Long)json_data.get("Regular Highways Total Expenditure")).intValue());
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Highways; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Highways; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}