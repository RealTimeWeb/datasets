package corgis.finance.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.finance.domain.Agriculture;
import corgis.finance.domain.FishAndGame;
import corgis.finance.domain.Parks;
import corgis.finance.domain.Forestry;

/**
 * 
 */
public class NaturalResources {
	
    // Payments to employees, suppliers, contractors, beneficiaries, and other final recipients of government payments (i.e., all expenditure other than Intergovernmental expenditure) for conservation, promotion, and development of natural resources, such as soil, water, forests, minerals, and wildlife. Includes irrigation, drainage, flood control, forestry and fire protection, soil reclamation, soil and water conservation, fish and game programs, and agricultural fairs.
    private Integer naturalResourcesDirect;
    // Total amount spent on construction for the support of natural resources.
    private Integer naturalResourcesConstruction;
    private Agriculture agriculture;
    private FishAndGame fishAndGame;
    // Total amount spent on conservation, promotion, and development of natural resources, such as soil, water, forests, minerals, and wildlife. Includes irrigation, drainage, flood control, forestry and fire protection, soil reclamation, soil and water conservation, fish and game programs, and agricultural fairs.
    private Integer naturalResourcesTotal;
    private Parks parks;
    // Total amount spent (Not elsewhere classified) on the conservation, promotion, and development of natural resources, such as soil, water, forests, minerals, and wildlife. Includes irrigation, drainage, flood control, forestry and fire protection, soil reclamation, soil and water conservation, fish and game programs, and agricultural fairs.
    private Integer naturalResourcesNecTotalExpenditure;
    // Money paid to other governments for the conservation, promotion, and development of natural resources, such as soil, water, forests, minerals, and wildlife. Includes irrigation, drainage, flood control, forestry and fire protection, soil reclamation, soil and water conservation, fish and game programs, and agricultural fairs.
    private Integer naturalResourcesIntergovernmental;
    // Total amount spent on equipment and land to support natural resources.
    private Integer naturalResourcesEquipmentAndLand;
    private Forestry forestry;
    
    
    /**
     * Payments to employees, suppliers, contractors, beneficiaries, and other final recipients of government payments (i.e., all expenditure other than Intergovernmental expenditure) for conservation, promotion, and development of natural resources, such as soil, water, forests, minerals, and wildlife. Includes irrigation, drainage, flood control, forestry and fire protection, soil reclamation, soil and water conservation, fish and game programs, and agricultural fairs.
     * @return Integer
     */
    public Integer getNaturalResourcesDirect() {
        return this.naturalResourcesDirect;
    }
    
    
    
    /**
     * Total amount spent on construction for the support of natural resources.
     * @return Integer
     */
    public Integer getNaturalResourcesConstruction() {
        return this.naturalResourcesConstruction;
    }
    
    
    
    /**
     * 
     * @return Agriculture
     */
    public Agriculture getAgriculture() {
        return this.agriculture;
    }
    
    
    
    /**
     * 
     * @return FishAndGame
     */
    public FishAndGame getFishAndGame() {
        return this.fishAndGame;
    }
    
    
    
    /**
     * Total amount spent on conservation, promotion, and development of natural resources, such as soil, water, forests, minerals, and wildlife. Includes irrigation, drainage, flood control, forestry and fire protection, soil reclamation, soil and water conservation, fish and game programs, and agricultural fairs.
     * @return Integer
     */
    public Integer getNaturalResourcesTotal() {
        return this.naturalResourcesTotal;
    }
    
    
    
    /**
     * 
     * @return Parks
     */
    public Parks getParks() {
        return this.parks;
    }
    
    
    
    /**
     * Total amount spent (Not elsewhere classified) on the conservation, promotion, and development of natural resources, such as soil, water, forests, minerals, and wildlife. Includes irrigation, drainage, flood control, forestry and fire protection, soil reclamation, soil and water conservation, fish and game programs, and agricultural fairs.
     * @return Integer
     */
    public Integer getNaturalResourcesNecTotalExpenditure() {
        return this.naturalResourcesNecTotalExpenditure;
    }
    
    
    
    /**
     * Money paid to other governments for the conservation, promotion, and development of natural resources, such as soil, water, forests, minerals, and wildlife. Includes irrigation, drainage, flood control, forestry and fire protection, soil reclamation, soil and water conservation, fish and game programs, and agricultural fairs.
     * @return Integer
     */
    public Integer getNaturalResourcesIntergovernmental() {
        return this.naturalResourcesIntergovernmental;
    }
    
    
    
    /**
     * Total amount spent on equipment and land to support natural resources.
     * @return Integer
     */
    public Integer getNaturalResourcesEquipmentAndLand() {
        return this.naturalResourcesEquipmentAndLand;
    }
    
    
    
    /**
     * 
     * @return Forestry
     */
    public Forestry getForestry() {
        return this.forestry;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this NaturalResources.
	
	 * @return String
	 */
	public String toString() {
		return "NaturalResources[" +naturalResourcesDirect+", "+naturalResourcesConstruction+", "+agriculture+", "+fishAndGame+", "+naturalResourcesTotal+", "+parks+", "+naturalResourcesNecTotalExpenditure+", "+naturalResourcesIntergovernmental+", "+naturalResourcesEquipmentAndLand+", "+forestry+"]";
	}
	
	/**
	 * Internal constructor to create a NaturalResources from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public NaturalResources(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Natural Resources Direct
            this.naturalResourcesDirect = ((Number)json_data.get("Natural Resources Direct")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a NaturalResources; the field naturalResourcesDirect was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a NaturalResources; the field naturalResourcesDirect had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Natural Resources Construction
            this.naturalResourcesConstruction = ((Number)json_data.get("Natural Resources Construction")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a NaturalResources; the field naturalResourcesConstruction was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a NaturalResources; the field naturalResourcesConstruction had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Agriculture
            this.agriculture = new Agriculture((JSONObject)json_data.get("Agriculture"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a NaturalResources; the field agriculture was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a NaturalResources; the field agriculture had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Fish and Game
            this.fishAndGame = new FishAndGame((JSONObject)json_data.get("Fish and Game"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a NaturalResources; the field fishAndGame was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a NaturalResources; the field fishAndGame had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Natural Resources Total
            this.naturalResourcesTotal = ((Number)json_data.get("Natural Resources Total")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a NaturalResources; the field naturalResourcesTotal was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a NaturalResources; the field naturalResourcesTotal had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Parks
            this.parks = new Parks((JSONObject)json_data.get("Parks"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a NaturalResources; the field parks was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a NaturalResources; the field parks had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Natural Resources NEC Total Expenditure
            this.naturalResourcesNecTotalExpenditure = ((Number)json_data.get("Natural Resources NEC Total Expenditure")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a NaturalResources; the field naturalResourcesNecTotalExpenditure was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a NaturalResources; the field naturalResourcesNecTotalExpenditure had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Natural Resources Intergovernmental
            this.naturalResourcesIntergovernmental = ((Number)json_data.get("Natural Resources Intergovernmental")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a NaturalResources; the field naturalResourcesIntergovernmental was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a NaturalResources; the field naturalResourcesIntergovernmental had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Natural Resources Equipment and Land
            this.naturalResourcesEquipmentAndLand = ((Number)json_data.get("Natural Resources Equipment and Land")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a NaturalResources; the field naturalResourcesEquipmentAndLand was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a NaturalResources; the field naturalResourcesEquipmentAndLand had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Forestry
            this.forestry = new Forestry((JSONObject)json_data.get("Forestry"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a NaturalResources; the field forestry was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a NaturalResources; the field forestry had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}