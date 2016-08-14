package corgis.medalofhonor.domain;

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
	
    private String enteredServiceAt;
    private String company;
    private String organization;
    private String rank;
    private String division;
    
    
    /*
     * @return 
     */
    public String getEnteredServiceAt() {
        return this.enteredServiceAt;
    }
    
    
    
    /*
     * @return 
     */
    public String getCompany() {
        return this.company;
    }
    
    
    
    /*
     * @return 
     */
    public String getOrganization() {
        return this.organization;
    }
    
    
    
    /*
     * @return 
     */
    public String getRank() {
        return this.rank;
    }
    
    
    
    /*
     * @return 
     */
    public String getDivision() {
        return this.division;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this MilitaryRecord.
	
	 * @return String
	 */
	public String toString() {
		return "MilitaryRecord[" +enteredServiceAt+", "+company+", "+organization+", "+rank+", "+division+"]";
	}
	
	/**
	 * Internal constructor to create a MilitaryRecord from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public MilitaryRecord(JSONObject json_data) {
        try {// entered service at
            this.enteredServiceAt = (String)json_data.get("entered service at");// company
            this.company = (String)json_data.get("company");// organization
            this.organization = (String)json_data.get("organization");// rank
            this.rank = (String)json_data.get("rank");// division
            this.division = (String)json_data.get("division");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a MilitaryRecord; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a MilitaryRecord; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}