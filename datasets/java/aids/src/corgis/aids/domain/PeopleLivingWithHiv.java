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
	
    // The number of Adult Women (greater than 15 years old) suffering from AIDS in this year.
    private Integer femaleAdults;
    // The number of Children (less than 15 years old) suffering from AIDS in this year.
    private Integer children;
    // The total number of people suffering from AIDS in this year.
    private Integer total;
    // The number of Adult Men (greater than 15 years old) suffering from AIDS in this year.
    private Integer maleAdults;
    // The number of Adults (greater than 15 years old) suffering from AIDS in this year.
    private Integer adults;
    
    
    /**
     * The number of Adult Women (greater than 15 years old) suffering from AIDS in this year.
     * @return Integer
     */
    public Integer getFemaleAdults() {
        return this.femaleAdults;
    }
    
    
    
    /**
     * The number of Children (less than 15 years old) suffering from AIDS in this year.
     * @return Integer
     */
    public Integer getChildren() {
        return this.children;
    }
    
    
    
    /**
     * The total number of people suffering from AIDS in this year.
     * @return Integer
     */
    public Integer getTotal() {
        return this.total;
    }
    
    
    
    /**
     * The number of Adult Men (greater than 15 years old) suffering from AIDS in this year.
     * @return Integer
     */
    public Integer getMaleAdults() {
        return this.maleAdults;
    }
    
    
    
    /**
     * The number of Adults (greater than 15 years old) suffering from AIDS in this year.
     * @return Integer
     */
    public Integer getAdults() {
        return this.adults;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this PeopleLivingWithHiv.
	
	 * @return String
	 */
	public String toString() {
		return "PeopleLivingWithHiv[" +femaleAdults+", "+children+", "+total+", "+maleAdults+", "+adults+"]";
	}
	
	/**
	 * Internal constructor to create a PeopleLivingWithHiv from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public PeopleLivingWithHiv(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Female Adults
            this.femaleAdults = ((Number)json_data.get("Female Adults")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a PeopleLivingWithHiv; the field femaleAdults was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a PeopleLivingWithHiv; the field femaleAdults had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Children
            this.children = ((Number)json_data.get("Children")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a PeopleLivingWithHiv; the field children was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a PeopleLivingWithHiv; the field children had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Total
            this.total = ((Number)json_data.get("Total")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a PeopleLivingWithHiv; the field total was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a PeopleLivingWithHiv; the field total had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Male Adults
            this.maleAdults = ((Number)json_data.get("Male Adults")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a PeopleLivingWithHiv; the field maleAdults was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a PeopleLivingWithHiv; the field maleAdults had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Adults
            this.adults = ((Number)json_data.get("Adults")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a PeopleLivingWithHiv; the field adults was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a PeopleLivingWithHiv; the field adults had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}