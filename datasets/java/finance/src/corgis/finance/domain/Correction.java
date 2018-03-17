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
public class Correction {
	
    // Money paid to other governments for correctional purposes, such as prisons, that is not elsewhere classified.
    private Integer correctionNecIntergovernmental;
    // Money paid to other governments for correctional purposes, such as prisons.
    private Integer correctionIntergovernmental;
    // Total amount spent for correctional purposes, such as prisons, that is not elsewhere classified.
    private Integer correctionNecTotal;
    // Total amount spent on correctional institutions purposes, especially prisons.
    private Integer correctionInstitutionsTotal;
    // Total amount spent on correctional purposes, such as prisons.
    private Integer correctionTotal;
    
    
    /**
     * Money paid to other governments for correctional purposes, such as prisons, that is not elsewhere classified.
     * @return Integer
     */
    public Integer getCorrectionNecIntergovernmental() {
        return this.correctionNecIntergovernmental;
    }
    
    
    
    /**
     * Money paid to other governments for correctional purposes, such as prisons.
     * @return Integer
     */
    public Integer getCorrectionIntergovernmental() {
        return this.correctionIntergovernmental;
    }
    
    
    
    /**
     * Total amount spent for correctional purposes, such as prisons, that is not elsewhere classified.
     * @return Integer
     */
    public Integer getCorrectionNecTotal() {
        return this.correctionNecTotal;
    }
    
    
    
    /**
     * Total amount spent on correctional institutions purposes, especially prisons.
     * @return Integer
     */
    public Integer getCorrectionInstitutionsTotal() {
        return this.correctionInstitutionsTotal;
    }
    
    
    
    /**
     * Total amount spent on correctional purposes, such as prisons.
     * @return Integer
     */
    public Integer getCorrectionTotal() {
        return this.correctionTotal;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Correction.
	
	 * @return String
	 */
	public String toString() {
		return "Correction[" +correctionNecIntergovernmental+", "+correctionIntergovernmental+", "+correctionNecTotal+", "+correctionInstitutionsTotal+", "+correctionTotal+"]";
	}
	
	/**
	 * Internal constructor to create a Correction from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Correction(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Correction NEC Intergovernmental
            this.correctionNecIntergovernmental = ((Number)json_data.get("Correction NEC Intergovernmental")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Correction; the field correctionNecIntergovernmental was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Correction; the field correctionNecIntergovernmental had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Correction Intergovernmental
            this.correctionIntergovernmental = ((Number)json_data.get("Correction Intergovernmental")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Correction; the field correctionIntergovernmental was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Correction; the field correctionIntergovernmental had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Correction NEC Total
            this.correctionNecTotal = ((Number)json_data.get("Correction NEC Total")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Correction; the field correctionNecTotal was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Correction; the field correctionNecTotal had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Correction Institutions Total
            this.correctionInstitutionsTotal = ((Number)json_data.get("Correction Institutions Total")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Correction; the field correctionInstitutionsTotal was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Correction; the field correctionInstitutionsTotal had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Correction Total
            this.correctionTotal = ((Number)json_data.get("Correction Total")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Correction; the field correctionTotal was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Correction; the field correctionTotal had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}