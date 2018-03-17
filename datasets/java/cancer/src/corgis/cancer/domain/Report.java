package corgis.cancer.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.cancer.domain.Data;
import corgis.cancer.domain.Age;

/**
 * 
 */
public class Report {
	
    private Data data;
    private Age age;
    // The area of the country (typically the name of the state) for this report.
    private String area;
    // The 4-digit year that this report was created for.
    private Integer year;
    
    
    /**
     * 
     * @return Data
     */
    public Data getData() {
        return this.data;
    }
    
    
    
    /**
     * 
     * @return Age
     */
    public Age getAge() {
        return this.age;
    }
    
    
    
    /**
     * The area of the country (typically the name of the state) for this report.
     * @return String
     */
    public String getArea() {
        return this.area;
    }
    
    
    
    /**
     * The 4-digit year that this report was created for.
     * @return Integer
     */
    public Integer getYear() {
        return this.year;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Report.
	
	 * @return String
	 */
	public String toString() {
		return "Report[" +data+", "+age+", "+area+", "+year+"]";
	}
	
	/**
	 * Internal constructor to create a Report from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Report(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Data
            this.data = new Data((JSONObject)json_data.get("Data"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Report; the field data was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Report; the field data had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Age
            this.age = new Age((JSONObject)json_data.get("Age"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Report; the field age was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Report; the field age had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Area
            this.area = (String)json_data.get("Area");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Report; the field area was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Report; the field area had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Year
            this.year = ((Number)json_data.get("Year")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Report; the field year was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Report; the field year had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}