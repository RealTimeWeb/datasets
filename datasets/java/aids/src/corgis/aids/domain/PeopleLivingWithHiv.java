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
public class PeopleLivingWithHiv {
	
    // The number of Adult Men (greater than 15 years old) suffering from AIDS in this year.
    private Integer maleAdults;
    // The total number of people suffering from AIDS in this year.
    private Integer total;
    // The number of Children (less than 15 years old) suffering from AIDS in this year.
    private Integer children;
    // The number of Adult Women (greater than 15 years old) suffering from AIDS in this year.
    private Integer femaleAdults;
    // The number of Adults (greater than 15 years old) suffering from AIDS in this year.
    private Integer adults;
    
    
    /*
     * @return 
     */
    public Integer getMaleAdults() {
        return this.maleAdults;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getTotal() {
        return this.total;
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
    public Integer getFemaleAdults() {
        return this.femaleAdults;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getAdults() {
        return this.adults;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this PeopleLivingWithHiv.
	
	 * @return String
	 */
	public String toString() {
		return "PeopleLivingWithHiv[" +maleAdults+", "+total+", "+children+", "+femaleAdults+", "+adults+"]";
	}
	
	/**
	 * Internal constructor to create a PeopleLivingWithHiv from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public PeopleLivingWithHiv(JSONObject json_data) {
        try {// Male Adults
            this.maleAdults = ((Number)json_data.get("Male Adults")).intValue();// Total
            this.total = ((Number)json_data.get("Total")).intValue();// Children
            this.children = ((Number)json_data.get("Children")).intValue();// Female Adults
            this.femaleAdults = ((Number)json_data.get("Female Adults")).intValue();// Adults
            this.adults = ((Number)json_data.get("Adults")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a PeopleLivingWithHiv; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a PeopleLivingWithHiv; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}