package corgis.tate.domain;

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
public class Metadata {
	
    // The year that this particular art piece was acquired by the Tate art gallery. If the creation date was not known, it was replaced with "0".
    private Integer acquisitionDate;
    // The 10-year period that this particular art piece was created in. If the creation date was not known, it was replaced with "0".
    private Integer creationDecade;
    // The year that this particular art piece was created in. If the creation date was not known, it was replaced with "0".
    private Integer creationYear;
    private String credit;
    
    
    /**
     * The year that this particular art piece was acquired by the Tate art gallery. If the creation date was not known, it was replaced with "0".
     * @return Integer
     */
    public Integer getAcquisitionDate() {
        return this.acquisitionDate;
    }
    
    
    
    /**
     * The 10-year period that this particular art piece was created in. If the creation date was not known, it was replaced with "0".
     * @return Integer
     */
    public Integer getCreationDecade() {
        return this.creationDecade;
    }
    
    
    
    /**
     * The year that this particular art piece was created in. If the creation date was not known, it was replaced with "0".
     * @return Integer
     */
    public Integer getCreationYear() {
        return this.creationYear;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getCredit() {
        return this.credit;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Metadata.
	
	 * @return String
	 */
	public String toString() {
		return "Metadata[" +acquisitionDate+", "+creationDecade+", "+creationYear+", "+credit+"]";
	}
	
	/**
	 * Internal constructor to create a Metadata from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Metadata(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // acquisition date
            this.acquisitionDate = ((Number)json_data.get("acquisition date")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Metadata; the field acquisitionDate was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Metadata; the field acquisitionDate had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // creation decade
            this.creationDecade = ((Number)json_data.get("creation decade")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Metadata; the field creationDecade was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Metadata; the field creationDecade had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // creation year
            this.creationYear = ((Number)json_data.get("creation year")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Metadata; the field creationYear was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Metadata; the field creationYear had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // credit
            this.credit = (String)json_data.get("credit");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Metadata; the field credit was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Metadata; the field credit had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}