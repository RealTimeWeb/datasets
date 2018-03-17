package corgis.billionaires.domain;

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
public class Company {
	
    // The year that the company was founded.
    private Integer founded;
    // The billionaires relationship to the company.
    private String relationship;
    // The sector of the business, or what segment of the economy they fit into.
    private String sector;
    // The name of the company.
    private String name;
    // The type of business for this company.
    private String type;
    
    
    /**
     * The year that the company was founded.
     * @return Integer
     */
    public Integer getFounded() {
        return this.founded;
    }
    
    
    
    /**
     * The billionaires relationship to the company.
     * @return String
     */
    public String getRelationship() {
        return this.relationship;
    }
    
    
    
    /**
     * The sector of the business, or what segment of the economy they fit into.
     * @return String
     */
    public String getSector() {
        return this.sector;
    }
    
    
    
    /**
     * The name of the company.
     * @return String
     */
    public String getName() {
        return this.name;
    }
    
    
    
    /**
     * The type of business for this company.
     * @return String
     */
    public String getType() {
        return this.type;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Company.
	
	 * @return String
	 */
	public String toString() {
		return "Company[" +founded+", "+relationship+", "+sector+", "+name+", "+type+"]";
	}
	
	/**
	 * Internal constructor to create a Company from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Company(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // founded
            this.founded = ((Number)json_data.get("founded")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Company; the field founded was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Company; the field founded had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // relationship
            this.relationship = (String)json_data.get("relationship");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Company; the field relationship was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Company; the field relationship had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // sector
            this.sector = (String)json_data.get("sector");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Company; the field sector was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Company; the field sector had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // name
            this.name = (String)json_data.get("name");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Company; the field name was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Company; the field name had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // type
            this.type = (String)json_data.get("type");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Company; the field type was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Company; the field type had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}