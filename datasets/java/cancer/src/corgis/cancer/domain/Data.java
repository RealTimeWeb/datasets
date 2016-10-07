package corgis.cancer.domain;

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
public class Data {
	
    private Integer count;
    private Double crudeRate;
    private Double crudeCiUpper;
    private Double crudeCiLower;
    private String sex;
    private String race;
    private String eventType;
    private Integer population;
    
    
    /*
     * @return 
     */
    public Integer getCount() {
        return this.count;
    }
    
    
    
    /*
     * @return 
     */
    public Double getCrudeRate() {
        return this.crudeRate;
    }
    
    
    
    /*
     * @return 
     */
    public Double getCrudeCiUpper() {
        return this.crudeCiUpper;
    }
    
    
    
    /*
     * @return 
     */
    public Double getCrudeCiLower() {
        return this.crudeCiLower;
    }
    
    
    
    /*
     * @return 
     */
    public String getSex() {
        return this.sex;
    }
    
    
    
    /*
     * @return 
     */
    public String getRace() {
        return this.race;
    }
    
    
    
    /*
     * @return 
     */
    public String getEventType() {
        return this.eventType;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getPopulation() {
        return this.population;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Data.
	
	 * @return String
	 */
	public String toString() {
		return "Data[" +count+", "+crudeRate+", "+crudeCiUpper+", "+crudeCiLower+", "+sex+", "+race+", "+eventType+", "+population+"]";
	}
	
	/**
	 * Internal constructor to create a Data from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Data(JSONObject json_data) {
        try {// Count
            this.count = ((Number)json_data.get("Count")).intValue();// Crude Rate
            this.crudeRate = (Double)json_data.get("Crude Rate");// Crude CI Upper
            this.crudeCiUpper = (Double)json_data.get("Crude CI Upper");// Crude CI Lower
            this.crudeCiLower = (Double)json_data.get("Crude CI Lower");// Sex
            this.sex = (String)json_data.get("Sex");// Race
            this.race = (String)json_data.get("Race");// Event Type
            this.eventType = (String)json_data.get("Event Type");// Population
            this.population = new Integer(((Long)json_data.get("Population")).intValue());
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}