package corgis.finance.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.finance.domain.Totals;
import corgis.finance.domain.Details;

/**
 * 
 */
public class Record {
	
    private String state;
    private Totals totals;
    // NEC - Not Elsewhere Defined
    private Details details;
    private Integer year;
    
    
    /*
     * @return 
     */
    public String getState() {
        return this.state;
    }
    
    
    
    /*
     * @return 
     */
    public Totals getTotals() {
        return this.totals;
    }
    
    
    
    /*
     * @return 
     */
    public Details getDetails() {
        return this.details;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getYear() {
        return this.year;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Record.
	
	 * @return String
	 */
	public String toString() {
		return "Record[" +state+", "+totals+", "+details+", "+year+"]";
	}
	
	/**
	 * Internal constructor to create a Record from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Record(JSONObject json_data) {
        try {// State
            this.state = (String)json_data.get("State");// Totals
            this.totals = new Totals((JSONObject)json_data.get("Totals"));// Details
            this.details = new Details((JSONObject)json_data.get("Details"));// Year
            this.year = new Integer(((Long)json_data.get("Year")).intValue());
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Record; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Record; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}