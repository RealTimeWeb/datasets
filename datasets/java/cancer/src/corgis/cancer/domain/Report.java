package corgis.cancer.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.cancer.domain.Age;
import corgis.cancer.domain.Data;

/**
 * 
 */
public class Report {
	
    private Age age;
    private Integer year;
    private Data data;
    private String area;
    
    
    /*
     * @return 
     */
    public Age getAge() {
        return this.age;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getYear() {
        return this.year;
    }
    
    
    
    /*
     * @return 
     */
    public Data getData() {
        return this.data;
    }
    
    
    
    /*
     * @return 
     */
    public String getArea() {
        return this.area;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Report.
	
	 * @return String
	 */
	public String toString() {
		return "Report[" +age+", "+year+", "+data+", "+area+"]";
	}
	
	/**
	 * Internal constructor to create a Report from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Report(JSONObject json_data) {
        try {// Age
            this.age = new Age((JSONObject)json_data.get("Age"));// Year
            this.year = ((Number)json_data.get("Year")).intValue();// Data
            this.data = new Data((JSONObject)json_data.get("Data"));// Area
            this.area = (String)json_data.get("Area");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Report; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Report; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}