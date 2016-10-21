package corgis.injuries.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.injuries.domain.Address;
import corgis.injuries.domain.Industry;
import corgis.injuries.domain.Statistics;
import corgis.injuries.domain.Business;

/**
 * 
 */
public class Report {
	
    private Address address;
    private Industry industry;
    private Statistics statistics;
    private Business business;
    private Integer year;
    
    
    /*
     * @return 
     */
    public Address getAddress() {
        return this.address;
    }
    
    
    
    /*
     * @return 
     */
    public Industry getIndustry() {
        return this.industry;
    }
    
    
    
    /*
     * @return 
     */
    public Statistics getStatistics() {
        return this.statistics;
    }
    
    
    
    /*
     * @return 
     */
    public Business getBusiness() {
        return this.business;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getYear() {
        return this.year;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Report.
	
	 * @return String
	 */
	public String toString() {
		return "Report[" +address+", "+industry+", "+statistics+", "+business+", "+year+"]";
	}
	
	/**
	 * Internal constructor to create a Report from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Report(JSONObject json_data) {
        try {// address
            this.address = new Address((JSONObject)json_data.get("address"));// industry
            this.industry = new Industry((JSONObject)json_data.get("industry"));// statistics
            this.statistics = new Statistics((JSONObject)json_data.get("statistics"));// business
            this.business = new Business((JSONObject)json_data.get("business"));// year
            this.year = ((Number)json_data.get("year")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Report; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Report; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}