package corgis.billionaires.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.billionaires.domain.Wealth;
import corgis.billionaires.domain.Company;
import corgis.billionaires.domain.Location;
import corgis.billionaires.domain.Demographics;

/**
 * 
 */
public class Billionaires {
	
    private Wealth wealth;
    private Company company;
    private Integer rank;
    private Location location;
    private Integer year;
    private Demographics demographics;
    private String name;
    
    
    /*
     * @return 
     */
    public Wealth getWealth() {
        return this.wealth;
    }
    
    
    
    /*
     * @return 
     */
    public Company getCompany() {
        return this.company;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getRank() {
        return this.rank;
    }
    
    
    
    /*
     * @return 
     */
    public Location getLocation() {
        return this.location;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getYear() {
        return this.year;
    }
    
    
    
    /*
     * @return 
     */
    public Demographics getDemographics() {
        return this.demographics;
    }
    
    
    
    /*
     * @return 
     */
    public String getName() {
        return this.name;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Billionaires.
	
	 * @return String
	 */
	public String toString() {
		return "Billionaires[" +wealth+", "+company+", "+rank+", "+location+", "+year+", "+demographics+", "+name+"]";
	}
	
	/**
	 * Internal constructor to create a Billionaires from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Billionaires(JSONObject json_data) {
        try {// wealth
            this.wealth = new Wealth((JSONObject)json_data.get("wealth"));// company
            this.company = new Company((JSONObject)json_data.get("company"));// rank
            this.rank = new Integer(((Long)json_data.get("rank")).intValue());// location
            this.location = new Location((JSONObject)json_data.get("location"));// year
            this.year = new Integer(((Long)json_data.get("year")).intValue());// demographics
            this.demographics = new Demographics((JSONObject)json_data.get("demographics"));// name
            this.name = (String)json_data.get("name");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Billionaires; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Billionaires; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}