package corgis.billionaires.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.billionaires.domain.Demographics;
import corgis.billionaires.domain.Location;
import corgis.billionaires.domain.Company;
import corgis.billionaires.domain.Wealth;

/**
 * 
 */
public class Billionaire {
	
    // The name of the billionaire.
    private String name;
    private Demographics demographics;
    // The rank of this billionaire compared to the rest of the billionaires reported on. A lower rank means they make more money.
    private Integer rank;
    private Location location;
    // The year that data about this billionaire was collected.
    private Integer year;
    private Company company;
    private Wealth wealth;
    
    
    /*
     * @return 
     */
    public String getName() {
        return this.name;
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
    public Company getCompany() {
        return this.company;
    }
    
    
    
    /*
     * @return 
     */
    public Wealth getWealth() {
        return this.wealth;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Billionaire.
	
	 * @return String
	 */
	public String toString() {
		return "Billionaire[" +name+", "+demographics+", "+rank+", "+location+", "+year+", "+company+", "+wealth+"]";
	}
	
	/**
	 * Internal constructor to create a Billionaire from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Billionaire(JSONObject json_data) {
        try {// name
            this.name = (String)json_data.get("name");// demographics
            this.demographics = new Demographics((JSONObject)json_data.get("demographics"));// rank
            this.rank = ((Number)json_data.get("rank")).intValue();// location
            this.location = new Location((JSONObject)json_data.get("location"));// year
            this.year = ((Number)json_data.get("year")).intValue();// company
            this.company = new Company((JSONObject)json_data.get("company"));// wealth
            this.wealth = new Wealth((JSONObject)json_data.get("wealth"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Billionaire; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Billionaire; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}