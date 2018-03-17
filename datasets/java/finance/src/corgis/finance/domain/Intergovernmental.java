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
public class Intergovernmental {
	
    // Money paid overall.
    private Integer intergovernmentalExpenditure;
    // Money paid to school districts.
    private Integer intergovernmentalToSchoolDistricts;
    // Money paid to municipalities.
    private Integer intergovernmentalToMunicipalities;
    // Money paid to states.
    private Integer intergovernmentalToState;
    // Money paid to counties.
    private Integer intergovernmentalToCounties;
    // Money paid to special districts.
    private Integer intergovernmentalToSpecialDistricts;
    // Other kinds of money.
    private Integer intergovernmentalToCombinedAndUnallocable;
    // Money paid to townships.
    private Integer intergovernmentalToTownships;
    // Money paid to federal governments.
    private Integer intergovernmentalToFederal;
    // Money paid to local governments.
    private Integer intergovernmentalToLocal;
    
    
    /**
     * Money paid overall.
     * @return Integer
     */
    public Integer getIntergovernmentalExpenditure() {
        return this.intergovernmentalExpenditure;
    }
    
    
    
    /**
     * Money paid to school districts.
     * @return Integer
     */
    public Integer getIntergovernmentalToSchoolDistricts() {
        return this.intergovernmentalToSchoolDistricts;
    }
    
    
    
    /**
     * Money paid to municipalities.
     * @return Integer
     */
    public Integer getIntergovernmentalToMunicipalities() {
        return this.intergovernmentalToMunicipalities;
    }
    
    
    
    /**
     * Money paid to states.
     * @return Integer
     */
    public Integer getIntergovernmentalToState() {
        return this.intergovernmentalToState;
    }
    
    
    
    /**
     * Money paid to counties.
     * @return Integer
     */
    public Integer getIntergovernmentalToCounties() {
        return this.intergovernmentalToCounties;
    }
    
    
    
    /**
     * Money paid to special districts.
     * @return Integer
     */
    public Integer getIntergovernmentalToSpecialDistricts() {
        return this.intergovernmentalToSpecialDistricts;
    }
    
    
    
    /**
     * Other kinds of money.
     * @return Integer
     */
    public Integer getIntergovernmentalToCombinedAndUnallocable() {
        return this.intergovernmentalToCombinedAndUnallocable;
    }
    
    
    
    /**
     * Money paid to townships.
     * @return Integer
     */
    public Integer getIntergovernmentalToTownships() {
        return this.intergovernmentalToTownships;
    }
    
    
    
    /**
     * Money paid to federal governments.
     * @return Integer
     */
    public Integer getIntergovernmentalToFederal() {
        return this.intergovernmentalToFederal;
    }
    
    
    
    /**
     * Money paid to local governments.
     * @return Integer
     */
    public Integer getIntergovernmentalToLocal() {
        return this.intergovernmentalToLocal;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Intergovernmental.
	
	 * @return String
	 */
	public String toString() {
		return "Intergovernmental[" +intergovernmentalExpenditure+", "+intergovernmentalToSchoolDistricts+", "+intergovernmentalToMunicipalities+", "+intergovernmentalToState+", "+intergovernmentalToCounties+", "+intergovernmentalToSpecialDistricts+", "+intergovernmentalToCombinedAndUnallocable+", "+intergovernmentalToTownships+", "+intergovernmentalToFederal+", "+intergovernmentalToLocal+"]";
	}
	
	/**
	 * Internal constructor to create a Intergovernmental from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Intergovernmental(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Intergovernmental Expenditure
            this.intergovernmentalExpenditure = ((Number)json_data.get("Intergovernmental Expenditure")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Intergovernmental; the field intergovernmentalExpenditure was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Intergovernmental; the field intergovernmentalExpenditure had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Intergovernmental to School Districts
            this.intergovernmentalToSchoolDistricts = ((Number)json_data.get("Intergovernmental to School Districts")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Intergovernmental; the field intergovernmentalToSchoolDistricts was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Intergovernmental; the field intergovernmentalToSchoolDistricts had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Intergovernmental to Municipalities
            this.intergovernmentalToMunicipalities = ((Number)json_data.get("Intergovernmental to Municipalities")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Intergovernmental; the field intergovernmentalToMunicipalities was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Intergovernmental; the field intergovernmentalToMunicipalities had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Intergovernmental to State
            this.intergovernmentalToState = ((Number)json_data.get("Intergovernmental to State")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Intergovernmental; the field intergovernmentalToState was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Intergovernmental; the field intergovernmentalToState had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Intergovernmental to Counties
            this.intergovernmentalToCounties = ((Number)json_data.get("Intergovernmental to Counties")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Intergovernmental; the field intergovernmentalToCounties was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Intergovernmental; the field intergovernmentalToCounties had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Intergovernmental to Special Districts
            this.intergovernmentalToSpecialDistricts = ((Number)json_data.get("Intergovernmental to Special Districts")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Intergovernmental; the field intergovernmentalToSpecialDistricts was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Intergovernmental; the field intergovernmentalToSpecialDistricts had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Intergovernmental to Combined and Unallocable
            this.intergovernmentalToCombinedAndUnallocable = ((Number)json_data.get("Intergovernmental to Combined and Unallocable")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Intergovernmental; the field intergovernmentalToCombinedAndUnallocable was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Intergovernmental; the field intergovernmentalToCombinedAndUnallocable had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Intergovernmental to Townships
            this.intergovernmentalToTownships = ((Number)json_data.get("Intergovernmental to Townships")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Intergovernmental; the field intergovernmentalToTownships was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Intergovernmental; the field intergovernmentalToTownships had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Intergovernmental to Federal
            this.intergovernmentalToFederal = ((Number)json_data.get("Intergovernmental to Federal")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Intergovernmental; the field intergovernmentalToFederal was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Intergovernmental; the field intergovernmentalToFederal had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Intergovernmental to Local
            this.intergovernmentalToLocal = ((Number)json_data.get("Intergovernmental to Local")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Intergovernmental; the field intergovernmentalToLocal was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Intergovernmental; the field intergovernmentalToLocal had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}