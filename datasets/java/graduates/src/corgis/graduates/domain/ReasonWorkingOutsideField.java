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
	
    // The number of people with a degree in this major during this year, who are working outside of the field associated with their major, and who did so because of pay or promotion opportunities.
    private Integer payPromotion;
    // The number of people with a degree in this major during this year, who are working outside of the field associated with their major, and who did so because of family-related issues.
    private Integer familyRelated;
    // The number of people with a degree in this major during this year, who are working outside of the field associated with their major, and who did so because they wanted a career change.
    private Integer careerChange;
    // The number of people with a degree in this major during this year, who are working outside of the field associated with their major, and who did so because of the job location.
    private Integer jobLocation;
    // The number of people with a degree in this major during this year, who are working outside of the field associated with their major, and who did so because of other reasons.
    private Integer other;
    // The number of people with a degree in this major during this year, who are working outside of the field associated with their major, and who did so because of working conditions.
    private Integer workingConditions;
    // The number of people with a degree in this major during this year, who are working outside of the field associated with their major, and who did so because there was no job available in their field.
    private Integer noJobAvailable;
    
    
    /**
     * The number of people with a degree in this major during this year, who are working outside of the field associated with their major, and who did so because of pay or promotion opportunities.
     * @return Integer
     */
    public Integer getPayPromotion() {
        return this.payPromotion;
    }
    
    
    
    /**
     * The number of people with a degree in this major during this year, who are working outside of the field associated with their major, and who did so because of family-related issues.
     * @return Integer
     */
    public Integer getFamilyRelated() {
        return this.familyRelated;
    }
    
    
    
    /**
     * The number of people with a degree in this major during this year, who are working outside of the field associated with their major, and who did so because they wanted a career change.
     * @return Integer
     */
    public Integer getCareerChange() {
        return this.careerChange;
    }
    
    
    
    /**
     * The number of people with a degree in this major during this year, who are working outside of the field associated with their major, and who did so because of the job location.
     * @return Integer
     */
    public Integer getJobLocation() {
        return this.jobLocation;
    }
    
    
    
    /**
     * The number of people with a degree in this major during this year, who are working outside of the field associated with their major, and who did so because of other reasons.
     * @return Integer
     */
    public Integer getOther() {
        return this.other;
    }
    
    
    
    /**
     * The number of people with a degree in this major during this year, who are working outside of the field associated with their major, and who did so because of working conditions.
     * @return Integer
     */
    public Integer getWorkingConditions() {
        return this.workingConditions;
    }
    
    
    
    /**
     * The number of people with a degree in this major during this year, who are working outside of the field associated with their major, and who did so because there was no job available in their field.
     * @return Integer
     */
    public Integer getNoJobAvailable() {
        return this.noJobAvailable;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this ReasonWorkingOutsideField.
	
	 * @return String
	 */
	public String toString() {
		return "ReasonWorkingOutsideField[" +payPromotion+", "+familyRelated+", "+careerChange+", "+jobLocation+", "+other+", "+workingConditions+", "+noJobAvailable+"]";
	}
	
	/**
	 * Internal constructor to create a ReasonWorkingOutsideField from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public ReasonWorkingOutsideField(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Pay/Promotion
            this.payPromotion = ((Number)json_data.get("Pay/Promotion")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a ReasonWorkingOutsideField; the field payPromotion was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a ReasonWorkingOutsideField; the field payPromotion had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Family-related
            this.familyRelated = ((Number)json_data.get("Family-related")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a ReasonWorkingOutsideField; the field familyRelated was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a ReasonWorkingOutsideField; the field familyRelated had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Career Change
            this.careerChange = ((Number)json_data.get("Career Change")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a ReasonWorkingOutsideField; the field careerChange was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a ReasonWorkingOutsideField; the field careerChange had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Job Location
            this.jobLocation = ((Number)json_data.get("Job Location")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a ReasonWorkingOutsideField; the field jobLocation was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a ReasonWorkingOutsideField; the field jobLocation had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Other
            this.other = ((Number)json_data.get("Other")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a ReasonWorkingOutsideField; the field other was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a ReasonWorkingOutsideField; the field other had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Working Conditions
            this.workingConditions = ((Number)json_data.get("Working Conditions")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a ReasonWorkingOutsideField; the field workingConditions was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a ReasonWorkingOutsideField; the field workingConditions had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // No Job Available
            this.noJobAvailable = ((Number)json_data.get("No Job Available")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a ReasonWorkingOutsideField; the field noJobAvailable was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a ReasonWorkingOutsideField; the field noJobAvailable had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}