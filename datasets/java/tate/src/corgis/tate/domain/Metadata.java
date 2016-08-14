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
	
    private String credit;
    // The year that this particular art piece was acquired by the Tate art gallery. If the creation date was not known, it was replaced with "0".
    private Integer acquisitionDate;
    // The 10-year period that this particular art piece was created in. If the creation date was not known, it was replaced with "0".
    private Integer creationDecade;
    // The year that this particular art piece was created in. If the creation date was not known, it was replaced with "0".
    private Integer creationYear;
    
    
    /*
     * @return 
     */
    public String getCredit() {
        return this.credit;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getAcquisitionDate() {
        return this.acquisitionDate;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getCreationDecade() {
        return this.creationDecade;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getCreationYear() {
        return this.creationYear;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Metadata.
	
	 * @return String
	 */
	public String toString() {
		return "Metadata[" +credit+", "+acquisitionDate+", "+creationDecade+", "+creationYear+"]";
	}
	
	/**
	 * Internal constructor to create a Metadata from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Metadata(JSONObject json_data) {
        try {// credit
            this.credit = (String)json_data.get("credit");// acquisition date
            this.acquisitionDate = new Integer(((Long)json_data.get("acquisition date")).intValue());// creation decade
            this.creationDecade = new Integer(((Long)json_data.get("creation decade")).intValue());// creation year
            this.creationYear = new Integer(((Long)json_data.get("creation year")).intValue());
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Metadata; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Metadata; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}