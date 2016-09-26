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
public class AidsRelatedDeaths {
	
    // 15+ Years Old
    private Integer maleAdults;
    private Integer allAges;
    // 0-17 Years Old
    private Integer aidsOrphans;
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
    public Integer getAllAges() {
        return this.allAges;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getAidsOrphans() {
        return this.aidsOrphans;
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
	 * Creates a string based representation of this Aids-RelatedDeaths.
	
	 * @return String
	 */
	public String toString() {
		return "Aids-RelatedDeaths[" +maleAdults+", "+allAges+", "+aidsOrphans+", "+children+", "+femaleAdults+", "+adults+"]";
	}
	
	/**
	 * Internal constructor to create a Aids-RelatedDeaths from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public AidsRelatedDeaths(JSONObject json_data) {
        try {// Male Adults
            this.maleAdults = new Integer(((Long)json_data.get("Male Adults")).intValue());// All Ages
            this.allAges = new Integer(((Long)json_data.get("All Ages")).intValue());// AIDS Orphans
            this.aidsOrphans = new Integer(((Long)json_data.get("AIDS Orphans")).intValue());// Children
            this.children = new Integer(((Long)json_data.get("Children")).intValue());// Female Adults
            this.femaleAdults = new Integer(((Long)json_data.get("Female Adults")).intValue());// Adults
            this.adults = new Integer(((Long)json_data.get("Adults")).intValue());
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Aids-RelatedDeaths; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Aids-RelatedDeaths; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}