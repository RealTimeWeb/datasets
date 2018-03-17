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
	
    // The type of event reported here - whether the participants lived or died.
    private String eventType;
    // A number representing the lower bound for the Crude Rate. It is unlikely that the actual rate is lower than this number.
    private Double crudeCiLower;
    // The number of incidences of cancer in this particular group.
    private Integer count;
    // A number representing the upper bound for the Crude Rate. It is unlikely that the actual rate is higher than this number.
    private Double crudeCiUpper;
    // The number of people present in this report.
    private Integer population;
    // The estimated number of people with cancer adjusted by the population. This adjustment makes it easy to compare cancer rates between different locations and over time.
    private Double crudeRate;
    // The gender of people in this particular report.
    private String sex;
    // The races reported in this particular report.
    private String race;
    
    
    /**
     * The type of event reported here - whether the participants lived or died.
     * @return String
     */
    public String getEventType() {
        return this.eventType;
    }
    
    
    
    /**
     * A number representing the lower bound for the Crude Rate. It is unlikely that the actual rate is lower than this number.
     * @return Double
     */
    public Double getCrudeCiLower() {
        return this.crudeCiLower;
    }
    
    
    
    /**
     * The number of incidences of cancer in this particular group.
     * @return Integer
     */
    public Integer getCount() {
        return this.count;
    }
    
    
    
    /**
     * A number representing the upper bound for the Crude Rate. It is unlikely that the actual rate is higher than this number.
     * @return Double
     */
    public Double getCrudeCiUpper() {
        return this.crudeCiUpper;
    }
    
    
    
    /**
     * The number of people present in this report.
     * @return Integer
     */
    public Integer getPopulation() {
        return this.population;
    }
    
    
    
    /**
     * The estimated number of people with cancer adjusted by the population. This adjustment makes it easy to compare cancer rates between different locations and over time.
     * @return Double
     */
    public Double getCrudeRate() {
        return this.crudeRate;
    }
    
    
    
    /**
     * The gender of people in this particular report.
     * @return String
     */
    public String getSex() {
        return this.sex;
    }
    
    
    
    /**
     * The races reported in this particular report.
     * @return String
     */
    public String getRace() {
        return this.race;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Data.
	
	 * @return String
	 */
	public String toString() {
		return "Data[" +eventType+", "+crudeCiLower+", "+count+", "+crudeCiUpper+", "+population+", "+crudeRate+", "+sex+", "+race+"]";
	}
	
	/**
	 * Internal constructor to create a Data from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Data(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Event Type
            this.eventType = (String)json_data.get("Event Type");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field eventType was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field eventType had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Crude CI Lower
            this.crudeCiLower = ((Number)json_data.get("Crude CI Lower")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field crudeCiLower was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field crudeCiLower had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Count
            this.count = ((Number)json_data.get("Count")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field count was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field count had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Crude CI Upper
            this.crudeCiUpper = ((Number)json_data.get("Crude CI Upper")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field crudeCiUpper was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field crudeCiUpper had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Population
            this.population = ((Number)json_data.get("Population")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field population was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field population had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Crude Rate
            this.crudeRate = ((Number)json_data.get("Crude Rate")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field crudeRate was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field crudeRate had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Sex
            this.sex = (String)json_data.get("Sex");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field sex was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field sex had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Race
            this.race = (String)json_data.get("Race");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field race was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field race had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}