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
	
    private Integer aidsRelatedDeathsAllAges;
    private Integer aidsRelatedDeathsAmongMaleAdults;
    private Integer aidsOrphans;
    private Integer aidsRelatedDeathsAmongAdults;
    private Integer aidsRelatedDeathsAmongFemaleAdults;
    private Integer aidsRelatedDeathsAmongChildren;
    
    
    /*
     * @return 
     */
    public Integer getAidsRelatedDeathsAllAges() {
        return this.aidsRelatedDeathsAllAges;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getAidsRelatedDeathsAmongMaleAdults() {
        return this.aidsRelatedDeathsAmongMaleAdults;
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
    public Integer getAidsRelatedDeathsAmongAdults() {
        return this.aidsRelatedDeathsAmongAdults;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getAidsRelatedDeathsAmongFemaleAdults() {
        return this.aidsRelatedDeathsAmongFemaleAdults;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getAidsRelatedDeathsAmongChildren() {
        return this.aidsRelatedDeathsAmongChildren;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Aids-RelatedDeaths.
	
	 * @return String
	 */
	public String toString() {
		return "Aids-RelatedDeaths[" +aidsRelatedDeathsAllAges+", "+aidsRelatedDeathsAmongMaleAdults+", "+aidsOrphans+", "+aidsRelatedDeathsAmongAdults+", "+aidsRelatedDeathsAmongFemaleAdults+", "+aidsRelatedDeathsAmongChildren+"]";
	}
	
	/**
	 * Internal constructor to create a Aids-RelatedDeaths from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public AidsRelatedDeaths(JSONObject json_data) {
        try {// AIDS-Related Deaths All Ages
            this.aidsRelatedDeathsAllAges = new Integer(((Long)json_data.get("AIDS-Related Deaths All Ages")).intValue());// AIDS-Related Deaths Among Male Adults
            this.aidsRelatedDeathsAmongMaleAdults = new Integer(((Long)json_data.get("AIDS-Related Deaths Among Male Adults")).intValue());// AIDS Orphans
            this.aidsOrphans = new Integer(((Long)json_data.get("AIDS Orphans")).intValue());// AIDS-Related Deaths Among Adults
            this.aidsRelatedDeathsAmongAdults = new Integer(((Long)json_data.get("AIDS-Related Deaths Among Adults")).intValue());// AIDS-Related Deaths Among Female Adults
            this.aidsRelatedDeathsAmongFemaleAdults = new Integer(((Long)json_data.get("AIDS-Related Deaths Among Female Adults")).intValue());// AIDS-Related Deaths Among Children
            this.aidsRelatedDeathsAmongChildren = new Integer(((Long)json_data.get("AIDS-Related Deaths Among Children")).intValue());
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Aids-RelatedDeaths; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Aids-RelatedDeaths; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}