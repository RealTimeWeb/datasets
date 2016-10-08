package corgis.medal_of_honor.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.medal_of_honor.domain.Location;
import corgis.medal_of_honor.domain.Date;

/**
 * 
 */
public class Awarded {
	
    private String issued;
    private String citation;
    private Integer generalOrderNumber;
    private String accreditedTo;
    private Location location;
    private Date date;
    
    
    /*
     * @return 
     */
    public String getIssued() {
        return this.issued;
    }
    
    
    
    /*
     * @return 
     */
    public String getCitation() {
        return this.citation;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getGeneralOrderNumber() {
        return this.generalOrderNumber;
    }
    
    
    
    /*
     * @return 
     */
    public String getAccreditedTo() {
        return this.accreditedTo;
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
    public Date getDate() {
        return this.date;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Awarded.
	
	 * @return String
	 */
	public String toString() {
		return "Awarded[" +issued+", "+citation+", "+generalOrderNumber+", "+accreditedTo+", "+location+", "+date+"]";
	}
	
	/**
	 * Internal constructor to create a Awarded from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Awarded(JSONObject json_data) {
        try {// issued
            this.issued = (String)json_data.get("issued");// citation
            this.citation = (String)json_data.get("citation");// General Order number
            this.generalOrderNumber = ((Number)json_data.get("General Order number")).intValue();// accredited to
            this.accreditedTo = (String)json_data.get("accredited to");// location
            this.location = new Location((JSONObject)json_data.get("location"));// date
            this.date = new Date((JSONObject)json_data.get("date"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Awarded; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Awarded; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}