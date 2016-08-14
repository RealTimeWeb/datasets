package corgis.finance.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.finance.domain.FishAndGame;
import corgis.finance.domain.Parks;
import corgis.finance.domain.Forestry;
import corgis.finance.domain.Agriculture;

/**
 * 
 */
public class NaturalResources {
	
    private FishAndGame fishAndGame;
    private Integer naturalResourcesTotal;
    private Integer naturalResourcesIntergovernmental;
    private Integer naturalResourcesNecTotalExpenditure;
    private Integer naturalResourcesConstruction;
    private Parks parks;
    private Forestry forestry;
    private Integer naturalResourcesDirect;
    private Integer naturalResourcesEquipmentAndLand;
    private Agriculture agriculture;
    
    
    /*
     * @return 
     */
    public FishAndGame getFishAndGame() {
        return this.fishAndGame;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getNaturalResourcesTotal() {
        return this.naturalResourcesTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getNaturalResourcesIntergovernmental() {
        return this.naturalResourcesIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getNaturalResourcesNecTotalExpenditure() {
        return this.naturalResourcesNecTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getNaturalResourcesConstruction() {
        return this.naturalResourcesConstruction;
    }
    
    
    
    /*
     * @return 
     */
    public Parks getParks() {
        return this.parks;
    }
    
    
    
    /*
     * @return 
     */
    public Forestry getForestry() {
        return this.forestry;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getNaturalResourcesDirect() {
        return this.naturalResourcesDirect;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getNaturalResourcesEquipmentAndLand() {
        return this.naturalResourcesEquipmentAndLand;
    }
    
    
    
    /*
     * @return 
     */
    public Agriculture getAgriculture() {
        return this.agriculture;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this NaturalResources.
	
	 * @return String
	 */
	public String toString() {
		return "NaturalResources[" +fishAndGame+", "+naturalResourcesTotal+", "+naturalResourcesIntergovernmental+", "+naturalResourcesNecTotalExpenditure+", "+naturalResourcesConstruction+", "+parks+", "+forestry+", "+naturalResourcesDirect+", "+naturalResourcesEquipmentAndLand+", "+agriculture+"]";
	}
	
	/**
	 * Internal constructor to create a NaturalResources from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public NaturalResources(JSONObject json_data) {
        try {// Fish and Game
            this.fishAndGame = new FishAndGame((JSONObject)json_data.get("Fish and Game"));// Natural Resources Total
            this.naturalResourcesTotal = new Integer(((Long)json_data.get("Natural Resources Total")).intValue());// Natural Resources Intergovernmental
            this.naturalResourcesIntergovernmental = new Integer(((Long)json_data.get("Natural Resources Intergovernmental")).intValue());// Natural Resources NEC Total Expenditure
            this.naturalResourcesNecTotalExpenditure = new Integer(((Long)json_data.get("Natural Resources NEC Total Expenditure")).intValue());// Natural Resources Construction
            this.naturalResourcesConstruction = new Integer(((Long)json_data.get("Natural Resources Construction")).intValue());// Parks
            this.parks = new Parks((JSONObject)json_data.get("Parks"));// Forestry
            this.forestry = new Forestry((JSONObject)json_data.get("Forestry"));// Natural Resources Direct
            this.naturalResourcesDirect = new Integer(((Long)json_data.get("Natural Resources Direct")).intValue());// Natural Resources Equipment and Land
            this.naturalResourcesEquipmentAndLand = new Integer(((Long)json_data.get("Natural Resources Equipment and Land")).intValue());// Agriculture
            this.agriculture = new Agriculture((JSONObject)json_data.get("Agriculture"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a NaturalResources; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a NaturalResources; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}