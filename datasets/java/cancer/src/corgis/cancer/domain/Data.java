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
	
    // The number of incidences of cancer in this particular group.
    private Integer count;
    // The estimated number of people with cancer adjusted by the population. This adjustment makes it easy to compare cancer rates between different locations and over time.
    private Double crudeRate;
    // A number representing the upper bound for the Crude Rate. It is unlikely that the actual rate is higher than this number.
    private Double crudeCiUpper;
    // A number representing the lower bound for the Crude Rate. It is unlikely that the actual rate is lower than this number.
    private Double crudeCiLower;
    // The gender of people in this particular report.
    private String sex;
    // The races reported in this particular report.
    private String race;
    // The type of event reported here - whether the participants lived or died.
    private String eventType;
    // The number of people present in this report.
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
            this.crudeRate = ((Number)json_data.get("Crude Rate")).doubleValue();// Crude CI Upper
            this.crudeCiUpper = ((Number)json_data.get("Crude CI Upper")).doubleValue();// Crude CI Lower
            this.crudeCiLower = ((Number)json_data.get("Crude CI Lower")).doubleValue();// Sex
            this.sex = (String)json_data.get("Sex");// Race
            this.race = (String)json_data.get("Race");// Event Type
            this.eventType = (String)json_data.get("Event Type");// Population
            this.population = ((Number)json_data.get("Population")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}