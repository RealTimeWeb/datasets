package corgis.business_dynamics.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.business_dynamics.domain.JobDestruction;
import corgis.business_dynamics.domain.JobCreation;
import corgis.business_dynamics.domain.Calculated;
import corgis.business_dynamics.domain.FirmExits;
import corgis.business_dynamics.domain.Establishments;

/**
 * 
 */
public class Data {
	
    private JobDestruction jobDestruction;
    // The number of firms in this state during this year.
    private Integer numberOfFirms;
    private JobCreation jobCreation;
    private Calculated calculated;
    private FirmExits firmExits;
    private Establishments establishments;
    // The Davis-Haltiwanger-Schuh (DHS) denominator is the two-period trailing moving average of employment, intended to prevent transitory shocks from distorting net growth. In other words, this value roughly represents the employment for the area, but is resistant to sudden, spiking growth.
    private Integer dhsDenominator;
    
    
    /*
     * @return 
     */
    public JobDestruction getJobDestruction() {
        return this.jobDestruction;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getNumberOfFirms() {
        return this.numberOfFirms;
    }
    
    
    
    /*
     * @return 
     */
    public JobCreation getJobCreation() {
        return this.jobCreation;
    }
    
    
    
    /*
     * @return 
     */
    public Calculated getCalculated() {
        return this.calculated;
    }
    
    
    
    /*
     * @return 
     */
    public FirmExits getFirmExits() {
        return this.firmExits;
    }
    
    
    
    /*
     * @return 
     */
    public Establishments getEstablishments() {
        return this.establishments;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getDhsDenominator() {
        return this.dhsDenominator;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Data.
	
	 * @return String
	 */
	public String toString() {
		return "Data[" +jobDestruction+", "+numberOfFirms+", "+jobCreation+", "+calculated+", "+firmExits+", "+establishments+", "+dhsDenominator+"]";
	}
	
	/**
	 * Internal constructor to create a Data from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Data(JSONObject json_data) {
        try {// Job Destruction
            this.jobDestruction = new JobDestruction((JSONObject)json_data.get("Job Destruction"));// Number of Firms
            this.numberOfFirms = ((Number)json_data.get("Number of Firms")).intValue();// Job Creation
            this.jobCreation = new JobCreation((JSONObject)json_data.get("Job Creation"));// Calculated
            this.calculated = new Calculated((JSONObject)json_data.get("Calculated"));// Firm Exits
            this.firmExits = new FirmExits((JSONObject)json_data.get("Firm Exits"));// Establishments
            this.establishments = new Establishments((JSONObject)json_data.get("Establishments"));// DHS Denominator
            this.dhsDenominator = ((Number)json_data.get("DHS Denominator")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}