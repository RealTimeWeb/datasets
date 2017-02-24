package corgis.graduates.domain;

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
public class ReasonWorkingOutsideField {
	
    // The number of people with a degree in this major during this year, who are working outside of the field associated with their major, and who did so because there was no job available in their field.
    private Integer noJobAvailable;
    // The number of people with a degree in this major during this year, who are working outside of the field associated with their major, and who did so because of the job location.
    private Integer jobLocation;
    // The number of people with a degree in this major during this year, who are working outside of the field associated with their major, and who did so because of working conditions.
    private Integer workingConditions;
    // The number of people with a degree in this major during this year, who are working outside of the field associated with their major, and who did so because they wanted a career change.
    private Integer careerChange;
    // The number of people with a degree in this major during this year, who are working outside of the field associated with their major, and who did so because of family-related issues.
    private Integer familyRelated;
    // The number of people with a degree in this major during this year, who are working outside of the field associated with their major, and who did so because of other reasons.
    private Integer other;
    // The number of people with a degree in this major during this year, who are working outside of the field associated with their major, and who did so because of pay or promotion opportunities.
    private Integer payPromotion;
    
    
    /*
     * @return 
     */
    public Integer getNoJobAvailable() {
        return this.noJobAvailable;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getJobLocation() {
        return this.jobLocation;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getWorkingConditions() {
        return this.workingConditions;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getCareerChange() {
        return this.careerChange;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getFamilyRelated() {
        return this.familyRelated;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getOther() {
        return this.other;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getPayPromotion() {
        return this.payPromotion;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this ReasonWorkingOutsideField.
	
	 * @return String
	 */
	public String toString() {
		return "ReasonWorkingOutsideField[" +noJobAvailable+", "+jobLocation+", "+workingConditions+", "+careerChange+", "+familyRelated+", "+other+", "+payPromotion+"]";
	}
	
	/**
	 * Internal constructor to create a ReasonWorkingOutsideField from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public ReasonWorkingOutsideField(JSONObject json_data) {
        try {// No Job Available
            this.noJobAvailable = ((Number)json_data.get("No Job Available")).intValue();// Job Location
            this.jobLocation = ((Number)json_data.get("Job Location")).intValue();// Working Conditions
            this.workingConditions = ((Number)json_data.get("Working Conditions")).intValue();// Career Change
            this.careerChange = ((Number)json_data.get("Career Change")).intValue();// Family-related
            this.familyRelated = ((Number)json_data.get("Family-related")).intValue();// Other
            this.other = ((Number)json_data.get("Other")).intValue();// Pay/Promotion
            this.payPromotion = ((Number)json_data.get("Pay/Promotion")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a ReasonWorkingOutsideField; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a ReasonWorkingOutsideField; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}