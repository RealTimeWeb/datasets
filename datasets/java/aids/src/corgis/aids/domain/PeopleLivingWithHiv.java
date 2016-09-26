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
	
    // 15+ Years Old
    private Integer maleAdults;
    private Integer total;
    // 0-14 Years Old
    private Integer children;
    // 15+ Years Old
    private Integer femaleAdults;
    // 15+ Years Old
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
            this.maleAdults = new Integer(((Long)json_data.get("Male Adults")).intValue());// Total
            this.total = new Integer(((Long)json_data.get("Total")).intValue());// Children
            this.children = new Integer(((Long)json_data.get("Children")).intValue());// Female Adults
            this.femaleAdults = new Integer(((Long)json_data.get("Female Adults")).intValue());// Adults
            this.adults = new Integer(((Long)json_data.get("Adults")).intValue());
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a PeopleLivingWithHiv; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a PeopleLivingWithHiv; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}