package corgis.graduates.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.graduates.domain.ReasonWorkingOutsideField;
import corgis.graduates.domain.EmployerType;
import corgis.graduates.domain.Status;
import corgis.graduates.domain.WorkActivity;
import corgis.graduates.domain.ReasonForNotWorking;

/**
 * 
 */
public class Employment {
	
    private ReasonWorkingOutsideField reasonWorkingOutsideField;
    private EmployerType employerType;
    private Status status;
    private WorkActivity workActivity;
    private ReasonForNotWorking reasonForNotWorking;
    
    
    /**
     * 
     * @return ReasonWorkingOutsideField
     */
    public ReasonWorkingOutsideField getReasonWorkingOutsideField() {
        return this.reasonWorkingOutsideField;
    }
    
    
    
    /**
     * 
     * @return EmployerType
     */
    public EmployerType getEmployerType() {
        return this.employerType;
    }
    
    
    
    /**
     * 
     * @return Status
     */
    public Status getStatus() {
        return this.status;
    }
    
    
    
    /**
     * 
     * @return WorkActivity
     */
    public WorkActivity getWorkActivity() {
        return this.workActivity;
    }
    
    
    
    /**
     * 
     * @return ReasonForNotWorking
     */
    public ReasonForNotWorking getReasonForNotWorking() {
        return this.reasonForNotWorking;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Employment.
	
	 * @return String
	 */
	public String toString() {
		return "Employment[" +reasonWorkingOutsideField+", "+employerType+", "+status+", "+workActivity+", "+reasonForNotWorking+"]";
	}
	
	/**
	 * Internal constructor to create a Employment from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Employment(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Reason Working Outside Field
            this.reasonWorkingOutsideField = new ReasonWorkingOutsideField((JSONObject)json_data.get("Reason Working Outside Field"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Employment; the field reasonWorkingOutsideField was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Employment; the field reasonWorkingOutsideField had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Employer Type
            this.employerType = new EmployerType((JSONObject)json_data.get("Employer Type"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Employment; the field employerType was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Employment; the field employerType had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Status
            this.status = new Status((JSONObject)json_data.get("Status"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Employment; the field status was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Employment; the field status had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Work Activity
            this.workActivity = new WorkActivity((JSONObject)json_data.get("Work Activity"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Employment; the field workActivity was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Employment; the field workActivity had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Reason for Not Working
            this.reasonForNotWorking = new ReasonForNotWorking((JSONObject)json_data.get("Reason for Not Working"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Employment; the field reasonForNotWorking was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Employment; the field reasonForNotWorking had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}