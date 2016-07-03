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
public class Data {
	
    // dict , totals
    private Totals totals;
    // dict , details
    private Details details;
    // int , year
    private Integer year;
    
    
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
	 * Creates a string based representation of this Data.
	
	 * @return String
	 */
	public String toString() {
		return "Data[" +totals+", "+details+", "+year+"]";
	}
	
	/**
	 * Internal constructor to create a Data from a  representation.
	 * @param map The raw json data that will be parsed.
	 * @return 
	 */
    public Data(JSONObject json_data) {
        try {// totals
            this.totals = new Totals((JSONObject)json_data.get("totals"));// details
            this.details = new Details((JSONObject)json_data.get("details"));// year
            this.year = new Integer(((Long)json_data.get("year")).intValue());
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}