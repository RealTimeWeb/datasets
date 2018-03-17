package corgis.billionaires.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.billionaires.domain.Company;
import corgis.billionaires.domain.Wealth;
import corgis.billionaires.domain.Demographics;
import corgis.billionaires.domain.Location;

/**
 * 
 */
public class Billionaire {
	
    private Company company;
    // The rank of this billionaire compared to the rest of the billionaires reported on. A lower rank means they make more money.
    private Integer rank;
    private Wealth wealth;
    // The name of the billionaire.
    private String name;
    private Demographics demographics;
    private Location location;
    // The year that data about this billionaire was collected.
    private Integer year;
    
    
    /**
     * 
     * @return Company
     */
    public Company getCompany() {
        return this.company;
    }
    
    
    
    /**
     * The rank of this billionaire compared to the rest of the billionaires reported on. A lower rank means they make more money.
     * @return Integer
     */
    public Integer getRank() {
        return this.rank;
    }
    
    
    
    /**
     * 
     * @return Wealth
     */
    public Wealth getWealth() {
        return this.wealth;
    }
    
    
    
    /**
     * The name of the billionaire.
     * @return String
     */
    public String getName() {
        return this.name;
    }
    
    
    
    /**
     * 
     * @return Demographics
     */
    public Demographics getDemographics() {
        return this.demographics;
    }
    
    
    
    /**
     * 
     * @return Location
     */
    public Location getLocation() {
        return this.location;
    }
    
    
    
    /**
     * The year that data about this billionaire was collected.
     * @return Integer
     */
    public Integer getYear() {
        return this.year;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Billionaire.
	
	 * @return String
	 */
	public String toString() {
		return "Billionaire[" +company+", "+rank+", "+wealth+", "+name+", "+demographics+", "+location+", "+year+"]";
	}
	
	/**
	 * Internal constructor to create a Billionaire from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Billionaire(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // company
            this.company = new Company((JSONObject)json_data.get("company"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Billionaire; the field company was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Billionaire; the field company had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // rank
            this.rank = ((Number)json_data.get("rank")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Billionaire; the field rank was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Billionaire; the field rank had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // wealth
            this.wealth = new Wealth((JSONObject)json_data.get("wealth"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Billionaire; the field wealth was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Billionaire; the field wealth had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // name
            this.name = (String)json_data.get("name");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Billionaire; the field name was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Billionaire; the field name had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // demographics
            this.demographics = new Demographics((JSONObject)json_data.get("demographics"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Billionaire; the field demographics was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Billionaire; the field demographics had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // location
            this.location = new Location((JSONObject)json_data.get("location"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Billionaire; the field location was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Billionaire; the field location had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // year
            this.year = ((Number)json_data.get("year")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Billionaire; the field year was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Billionaire; the field year had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}