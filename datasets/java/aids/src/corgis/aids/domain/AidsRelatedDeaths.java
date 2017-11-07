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
	
    // All adults (older than 15 years of age) who have died of aids.
    private Integer adults;
    // The total number of deaths caused by AIDS in this year.
    private Integer allAges;
    // Children who have been orphaned from AIDS (parents died of AIDS) below 17 years of age.
    private Integer aidsOrphans;
    // Children who have died of AIDS below 14 years of age.
    private Integer children;
    // Female adults (older than 15 years of age) who have died of aids.
    private Integer femaleAdults;
    // Male adults (older than 15 years of age) who have died of aids.
    private Integer maleAdults;
    
    
    /*
     * @return 
     */
    public Integer getAdults() {
        return this.adults;
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
    public Integer getMaleAdults() {
        return this.maleAdults;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Aids-RelatedDeaths.
	
	 * @return String
	 */
	public String toString() {
		return "Aids-RelatedDeaths[" +adults+", "+allAges+", "+aidsOrphans+", "+children+", "+femaleAdults+", "+maleAdults+"]";
	}
	
	/**
	 * Internal constructor to create a Aids-RelatedDeaths from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public AidsRelatedDeaths(JSONObject json_data) {
        try {// Adults
            this.adults = ((Number)json_data.get("Adults")).intValue();// All Ages
            this.allAges = ((Number)json_data.get("All Ages")).intValue();// AIDS Orphans
            this.aidsOrphans = ((Number)json_data.get("AIDS Orphans")).intValue();// Children
            this.children = ((Number)json_data.get("Children")).intValue();// Female Adults
            this.femaleAdults = ((Number)json_data.get("Female Adults")).intValue();// Male Adults
            this.maleAdults = ((Number)json_data.get("Male Adults")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Aids-RelatedDeaths; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Aids-RelatedDeaths; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}