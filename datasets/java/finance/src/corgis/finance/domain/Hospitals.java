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
public class Hospitals {
	
    // Direct expenditure for compensation of own officers and employees and for supplies, materials, and contractual services except amounts for capital outlay related to hospitals.
    private Integer hospitalsTotalCurrent;
    // Total amount spent on construction for hospitals.
    private Integer hospitalsTotalConstruction;
    // Money paid to other governments for the financing, construction acquisition, maintenance or operation of hospital facilities, provision of hospital care, and support of public or private hospitals.
    private Integer hospitalsTotalIntergovernmental;
    // Total amount spent on own hospitals. Own hospitals are facilities administered directly by the government concerned.
    private Integer ownHospitalsTotalExpenditure;
    // Total amount spent on non-Owned hospitals. These hospitals refer to support for hospital services in private hospitals or other governments.
    private Integer hospitalOtherTotalExpenditure;
    // Total amount spent on equipment and land related to hospitals.
    private Integer hospitalsTotalEquipmentAndLand;
    // Money paid to other governments for non-Owned hospitals. These hospitals refer to support for hospital services in private hospitals or other governments.
    private Integer hospitalOtherIntergovernmental;
    // Total amount spent on financing, construction acquisition, maintenance or operation of hospital facilities, provision of hospital care, and support of public or private hospitals.
    private Integer hospitalsTotalExpenditure;
    
    
    /**
     * Direct expenditure for compensation of own officers and employees and for supplies, materials, and contractual services except amounts for capital outlay related to hospitals.
     * @return Integer
     */
    public Integer getHospitalsTotalCurrent() {
        return this.hospitalsTotalCurrent;
    }
    
    
    
    /**
     * Total amount spent on construction for hospitals.
     * @return Integer
     */
    public Integer getHospitalsTotalConstruction() {
        return this.hospitalsTotalConstruction;
    }
    
    
    
    /**
     * Money paid to other governments for the financing, construction acquisition, maintenance or operation of hospital facilities, provision of hospital care, and support of public or private hospitals.
     * @return Integer
     */
    public Integer getHospitalsTotalIntergovernmental() {
        return this.hospitalsTotalIntergovernmental;
    }
    
    
    
    /**
     * Total amount spent on own hospitals. Own hospitals are facilities administered directly by the government concerned.
     * @return Integer
     */
    public Integer getOwnHospitalsTotalExpenditure() {
        return this.ownHospitalsTotalExpenditure;
    }
    
    
    
    /**
     * Total amount spent on non-Owned hospitals. These hospitals refer to support for hospital services in private hospitals or other governments.
     * @return Integer
     */
    public Integer getHospitalOtherTotalExpenditure() {
        return this.hospitalOtherTotalExpenditure;
    }
    
    
    
    /**
     * Total amount spent on equipment and land related to hospitals.
     * @return Integer
     */
    public Integer getHospitalsTotalEquipmentAndLand() {
        return this.hospitalsTotalEquipmentAndLand;
    }
    
    
    
    /**
     * Money paid to other governments for non-Owned hospitals. These hospitals refer to support for hospital services in private hospitals or other governments.
     * @return Integer
     */
    public Integer getHospitalOtherIntergovernmental() {
        return this.hospitalOtherIntergovernmental;
    }
    
    
    
    /**
     * Total amount spent on financing, construction acquisition, maintenance or operation of hospital facilities, provision of hospital care, and support of public or private hospitals.
     * @return Integer
     */
    public Integer getHospitalsTotalExpenditure() {
        return this.hospitalsTotalExpenditure;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Hospitals.
	
	 * @return String
	 */
	public String toString() {
		return "Hospitals[" +hospitalsTotalCurrent+", "+hospitalsTotalConstruction+", "+hospitalsTotalIntergovernmental+", "+ownHospitalsTotalExpenditure+", "+hospitalOtherTotalExpenditure+", "+hospitalsTotalEquipmentAndLand+", "+hospitalOtherIntergovernmental+", "+hospitalsTotalExpenditure+"]";
	}
	
	/**
	 * Internal constructor to create a Hospitals from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Hospitals(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Hospitals Total Current
            this.hospitalsTotalCurrent = ((Number)json_data.get("Hospitals Total Current")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Hospitals; the field hospitalsTotalCurrent was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Hospitals; the field hospitalsTotalCurrent had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Hospitals Total Construction
            this.hospitalsTotalConstruction = ((Number)json_data.get("Hospitals Total Construction")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Hospitals; the field hospitalsTotalConstruction was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Hospitals; the field hospitalsTotalConstruction had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Hospitals Total Intergovernmental
            this.hospitalsTotalIntergovernmental = ((Number)json_data.get("Hospitals Total Intergovernmental")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Hospitals; the field hospitalsTotalIntergovernmental was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Hospitals; the field hospitalsTotalIntergovernmental had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Own Hospitals Total Expenditure
            this.ownHospitalsTotalExpenditure = ((Number)json_data.get("Own Hospitals Total Expenditure")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Hospitals; the field ownHospitalsTotalExpenditure was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Hospitals; the field ownHospitalsTotalExpenditure had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Hospital-Other Total Expenditure
            this.hospitalOtherTotalExpenditure = ((Number)json_data.get("Hospital-Other Total Expenditure")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Hospitals; the field hospitalOtherTotalExpenditure was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Hospitals; the field hospitalOtherTotalExpenditure had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Hospitals Total Equipment and land
            this.hospitalsTotalEquipmentAndLand = ((Number)json_data.get("Hospitals Total Equipment and land")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Hospitals; the field hospitalsTotalEquipmentAndLand was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Hospitals; the field hospitalsTotalEquipmentAndLand had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Hospital-Other Intergovernmental
            this.hospitalOtherIntergovernmental = ((Number)json_data.get("Hospital-Other Intergovernmental")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Hospitals; the field hospitalOtherIntergovernmental was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Hospitals; the field hospitalOtherIntergovernmental had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Hospitals Total Expenditure
            this.hospitalsTotalExpenditure = ((Number)json_data.get("Hospitals Total Expenditure")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Hospitals; the field hospitalsTotalExpenditure was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Hospitals; the field hospitalsTotalExpenditure had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}