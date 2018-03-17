package corgis.immigration.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.immigration.domain.Data;

/**
 * 
 */
public class Record {
	
    private Data data;
    // The country that these immigrants came from to USA, or are going to from the USA.
    private String country;
    // The year that this immigration data comes from.
    private Integer year;
    
    
    /**
     * 
     * @return Data
     */
    public Data getData() {
        return this.data;
    }
    
    
    
    /**
     * The country that these immigrants came from to USA, or are going to from the USA.
     * @return String
     */
    public String getCountry() {
        return this.country;
    }
    
    
    
    /**
     * The year that this immigration data comes from.
     * @return Integer
     */
    public Integer getYear() {
        return this.year;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Record.
	
	 * @return String
	 */
	public String toString() {
		return "Record[" +data+", "+country+", "+year+"]";
	}
	
	/**
	 * Internal constructor to create a Record from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Record(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Data
            this.data = new Data((JSONObject)json_data.get("Data"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Record; the field data was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Record; the field data had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Country
            this.country = (String)json_data.get("Country");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Record; the field country was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Record; the field country had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Year
            this.year = ((Number)json_data.get("Year")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Record; the field year was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Record; the field year had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}