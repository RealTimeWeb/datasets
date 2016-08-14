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
	
    // 0-14 Years Old
    private Integer newHivInfectionsAmongChildren;
    // 15-49 Years Old
    private Double incidenceRateAmongAdults;
    // 15+ Years Old
    private Integer newHivInfectionsAmongAdults;
    private Integer newHivInfectionsAllAges;
    // 15+ Years Old
    private Double newHivInfectionsAmongFemaleAdults;
    // 15+ Years Old
    private Integer newHivInfectionsAmongMaleAdults;
    
    
    /*
     * @return 
     */
    public Integer getNewHivInfectionsAmongChildren() {
        return this.newHivInfectionsAmongChildren;
    }
    
    
    
    /*
     * @return 
     */
    public Double getIncidenceRateAmongAdults() {
        return this.incidenceRateAmongAdults;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getNewHivInfectionsAmongAdults() {
        return this.newHivInfectionsAmongAdults;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getNewHivInfectionsAllAges() {
        return this.newHivInfectionsAllAges;
    }
    
    
    
    /*
     * @return 
     */
    public Double getNewHivInfectionsAmongFemaleAdults() {
        return this.newHivInfectionsAmongFemaleAdults;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getNewHivInfectionsAmongMaleAdults() {
        return this.newHivInfectionsAmongMaleAdults;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this NewHivInfections.
	
	 * @return String
	 */
	public String toString() {
		return "NewHivInfections[" +newHivInfectionsAmongChildren+", "+incidenceRateAmongAdults+", "+newHivInfectionsAmongAdults+", "+newHivInfectionsAllAges+", "+newHivInfectionsAmongFemaleAdults+", "+newHivInfectionsAmongMaleAdults+"]";
	}
	
	/**
	 * Internal constructor to create a NewHivInfections from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public NewHivInfections(JSONObject json_data) {
        try {// New HIV Infections Among Children
            this.newHivInfectionsAmongChildren = new Integer(((Long)json_data.get("New HIV Infections Among Children")).intValue());// Incidence Rate Among Adults
            this.incidenceRateAmongAdults = (Double)json_data.get("Incidence Rate Among Adults");// New HIV Infections Among Adults
            this.newHivInfectionsAmongAdults = new Integer(((Long)json_data.get("New HIV Infections Among Adults")).intValue());// New HIV Infections All Ages
            this.newHivInfectionsAllAges = new Integer(((Long)json_data.get("New HIV Infections All Ages")).intValue());// New HIV Infections Among Female Adults
            this.newHivInfectionsAmongFemaleAdults = (Double)json_data.get("New HIV Infections Among Female Adults");// New HIV Infections Among Male Adults
            this.newHivInfectionsAmongMaleAdults = new Integer(((Long)json_data.get("New HIV Infections Among Male Adults")).intValue());
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a NewHivInfections; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a NewHivInfections; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}