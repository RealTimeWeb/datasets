package corgis.construction_permits.domain;

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
public class NumberOfPermits {
	
    private Integer twoUnits;
    private Integer fiveplusUnits;
    private Integer threeFourUnits;
    private Integer oneUnit;
    
    
    /*
     * @return 
     */
    public Integer getTwoUnits() {
        return this.twoUnits;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getFiveplusUnits() {
        return this.fiveplusUnits;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getThreeFourUnits() {
        return this.threeFourUnits;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getOneUnit() {
        return this.oneUnit;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this #OfPermits.
	
	 * @return String
	 */
	public String toString() {
		return "#OfPermits[" +twoUnits+", "+fiveplusUnits+", "+threeFourUnits+", "+oneUnit+"]";
	}
	
	/**
	 * Internal constructor to create a #OfPermits from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public NumberOfPermits(JSONObject json_data) {
        try {// 2 units
            this.twoUnits = ((Number)json_data.get("2 units")).intValue();// 5+ units
            this.fiveplusUnits = ((Number)json_data.get("5+ units")).intValue();// 3-4 units
            this.threeFourUnits = ((Number)json_data.get("3-4 units")).intValue();// 1 unit
            this.oneUnit = ((Number)json_data.get("1 unit")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a #OfPermits; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a #OfPermits; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}