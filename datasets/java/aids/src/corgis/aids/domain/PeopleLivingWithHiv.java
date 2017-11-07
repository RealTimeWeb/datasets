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
	
    // The number of Adults (greater than 15 years old) suffering from AIDS in this year.
    private Integer adults;
    // The total number of people suffering from AIDS in this year.
    private Integer total;
    // The number of Adult Men (greater than 15 years old) suffering from AIDS in this year.
    private Integer maleAdults;
    // The number of Adult Women (greater than 15 years old) suffering from AIDS in this year.
    private Integer femaleAdults;
    // The number of Children (less than 15 years old) suffering from AIDS in this year.
    private Integer children;
    
    
    /*
     * @return 
     */
    public Integer getAdults() {
        return this.adults;
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
    public Integer getMaleAdults() {
        return this.maleAdults;
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
    public Integer getChildren() {
        return this.children;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this PeopleLivingWithHiv.
	
	 * @return String
	 */
	public String toString() {
		return "PeopleLivingWithHiv[" +adults+", "+total+", "+maleAdults+", "+femaleAdults+", "+children+"]";
	}
	
	/**
	 * Internal constructor to create a PeopleLivingWithHiv from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public PeopleLivingWithHiv(JSONObject json_data) {
        try {// Adults
            this.adults = ((Number)json_data.get("Adults")).intValue();// Total
            this.total = ((Number)json_data.get("Total")).intValue();// Male Adults
            this.maleAdults = ((Number)json_data.get("Male Adults")).intValue();// Female Adults
            this.femaleAdults = ((Number)json_data.get("Female Adults")).intValue();// Children
            this.children = ((Number)json_data.get("Children")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a PeopleLivingWithHiv; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a PeopleLivingWithHiv; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}