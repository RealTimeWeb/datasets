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
	
    private Integer correctionIntergovernmental;
    private Integer correctionNecIntergovernmental;
    private Integer correctionNecTotal;
    private Integer correctionTotal;
    private Integer correctionInstitutionsTotal;
    
    
    /*
     * @return 
     */
    public Integer getCorrectionIntergovernmental() {
        return this.correctionIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getCorrectionNecIntergovernmental() {
        return this.correctionNecIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getCorrectionNecTotal() {
        return this.correctionNecTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getCorrectionTotal() {
        return this.correctionTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getCorrectionInstitutionsTotal() {
        return this.correctionInstitutionsTotal;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Correction.
	
	 * @return String
	 */
	public String toString() {
		return "Correction[" +correctionIntergovernmental+", "+correctionNecIntergovernmental+", "+correctionNecTotal+", "+correctionTotal+", "+correctionInstitutionsTotal+"]";
	}
	
	/**
	 * Internal constructor to create a Correction from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Correction(JSONObject json_data) {
        try {// Correction Intergovernmental
            this.correctionIntergovernmental = new Integer(((Long)json_data.get("Correction Intergovernmental")).intValue());// Correction NEC Intergovernmental
            this.correctionNecIntergovernmental = new Integer(((Long)json_data.get("Correction NEC Intergovernmental")).intValue());// Correction NEC Total
            this.correctionNecTotal = new Integer(((Long)json_data.get("Correction NEC Total")).intValue());// Correction Total
            this.correctionTotal = new Integer(((Long)json_data.get("Correction Total")).intValue());// Correction Institutions Total
            this.correctionInstitutionsTotal = new Integer(((Long)json_data.get("Correction Institutions Total")).intValue());
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Correction; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Correction; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}