package corgis.aids.domain;

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
public class NewHivInfections {
	
    // 15-49 Years Old
    private Double incidenceRateAmongAdults;
    // 15+ Years Old
    private Integer maleAdults;
    private Integer allAges;
    // 0-14 Years Old
    private Integer children;
    // 15+ Years Old
    private Double femaleAdults;
    // 15+ Years Old
    private Integer adults;
    
    
    /*
     * @return 
     */
    public Double getIncidenceRateAmongAdults() {
        return this.incidenceRateAmongAdults;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getMaleAdults() {
        return this.maleAdults;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getAllAges() {
        return this.allAges;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getChildren() {
        return this.children;
    }
    
    
    
    /*
     * @return 
     */
    public Double getFemaleAdults() {
        return this.femaleAdults;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getAdults() {
        return this.adults;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this NewHivInfections.
	
	 * @return String
	 */
	public String toString() {
		return "NewHivInfections[" +incidenceRateAmongAdults+", "+maleAdults+", "+allAges+", "+children+", "+femaleAdults+", "+adults+"]";
	}
	
	/**
	 * Internal constructor to create a NewHivInfections from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public NewHivInfections(JSONObject json_data) {
        try {// Incidence Rate Among Adults
            this.incidenceRateAmongAdults = (Double)json_data.get("Incidence Rate Among Adults");// Male Adults
            this.maleAdults = new Integer(((Long)json_data.get("Male Adults")).intValue());// All Ages
            this.allAges = new Integer(((Long)json_data.get("All Ages")).intValue());// Children
            this.children = new Integer(((Long)json_data.get("Children")).intValue());// Female Adults
            this.femaleAdults = (Double)json_data.get("Female Adults");// Adults
            this.adults = new Integer(((Long)json_data.get("Adults")).intValue());
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a NewHivInfections; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a NewHivInfections; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}