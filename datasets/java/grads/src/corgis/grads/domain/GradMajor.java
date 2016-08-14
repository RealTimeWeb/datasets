package corgis.grads.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.grads.domain.MajorInformation;
import corgis.grads.domain.Demographics;
import corgis.grads.domain.Employment;
import corgis.grads.domain.Earnings;

/**
 * 
 */
public class GradMajor {
	
    private MajorInformation majorInformation;
    private Demographics demographics;
    private Employment employment;
    private Earnings earnings;
    
    
    /*
     * @return 
     */
    public MajorInformation getMajorInformation() {
        return this.majorInformation;
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
    public Employment getEmployment() {
        return this.employment;
    }
    
    
    
    /*
     * @return 
     */
    public Earnings getEarnings() {
        return this.earnings;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this GradMajor.
	
	 * @return String
	 */
	public String toString() {
		return "GradMajor[" +majorInformation+", "+demographics+", "+employment+", "+earnings+"]";
	}
	
	/**
	 * Internal constructor to create a GradMajor from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public GradMajor(JSONObject json_data) {
        try {// Major Information
            this.majorInformation = new MajorInformation((JSONObject)json_data.get("Major Information"));// Demographics
            this.demographics = new Demographics((JSONObject)json_data.get("Demographics"));// Employment
            this.employment = new Employment((JSONObject)json_data.get("Employment"));// Earnings
            this.earnings = new Earnings((JSONObject)json_data.get("Earnings"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a GradMajor; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a GradMajor; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}