package corgis.medal_of_honor.domain;

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
public class MilitaryRecord {
	
    private String company;
    private String rank;
    private String division;
    private String organization;
    private String enteredServiceAt;
    
    
    /**
     * 
     * @return String
     */
    public String getCompany() {
        return this.company;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getRank() {
        return this.rank;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getDivision() {
        return this.division;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getOrganization() {
        return this.organization;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getEnteredServiceAt() {
        return this.enteredServiceAt;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this MilitaryRecord.
	
	 * @return String
	 */
	public String toString() {
		return "MilitaryRecord[" +company+", "+rank+", "+division+", "+organization+", "+enteredServiceAt+"]";
	}
	
	/**
	 * Internal constructor to create a MilitaryRecord from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public MilitaryRecord(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // company
            this.company = (String)json_data.get("company");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a MilitaryRecord; the field company was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a MilitaryRecord; the field company had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // rank
            this.rank = (String)json_data.get("rank");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a MilitaryRecord; the field rank was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a MilitaryRecord; the field rank had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // division
            this.division = (String)json_data.get("division");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a MilitaryRecord; the field division was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a MilitaryRecord; the field division had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // organization
            this.organization = (String)json_data.get("organization");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a MilitaryRecord; the field organization was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a MilitaryRecord; the field organization had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // entered service at
            this.enteredServiceAt = (String)json_data.get("entered service at");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a MilitaryRecord; the field enteredServiceAt was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a MilitaryRecord; the field enteredServiceAt had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}