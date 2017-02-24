package corgis.graduates.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.graduates.domain.Status;
import corgis.graduates.domain.EmployerType;
import corgis.graduates.domain.ReasonWorkingOutsideField;
import corgis.graduates.domain.ReasonForNotWorking;
import corgis.graduates.domain.WorkActivity;

/**
 * 
 */
public class Employment {
	
    private Status status;
    private EmployerType employerType;
    private ReasonWorkingOutsideField reasonWorkingOutsideField;
    private ReasonForNotWorking reasonForNotWorking;
    private WorkActivity workActivity;
    
    
    /*
     * @return 
     */
    public Status getStatus() {
        return this.status;
    }
    
    
    
    /*
     * @return 
     */
    public EmployerType getEmployerType() {
        return this.employerType;
    }
    
    
    
    /*
     * @return 
     */
    public ReasonWorkingOutsideField getReasonWorkingOutsideField() {
        return this.reasonWorkingOutsideField;
    }
    
    
    
    /*
     * @return 
     */
    public ReasonForNotWorking getReasonForNotWorking() {
        return this.reasonForNotWorking;
    }
    
    
    
    /*
     * @return 
     */
    public WorkActivity getWorkActivity() {
        return this.workActivity;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Employment.
	
	 * @return String
	 */
	public String toString() {
		return "Employment[" +status+", "+employerType+", "+reasonWorkingOutsideField+", "+reasonForNotWorking+", "+workActivity+"]";
	}
	
	/**
	 * Internal constructor to create a Employment from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Employment(JSONObject json_data) {
        try {// Status
            this.status = new Status((JSONObject)json_data.get("Status"));// Employer Type
            this.employerType = new EmployerType((JSONObject)json_data.get("Employer Type"));// Reason Working Outside Field
            this.reasonWorkingOutsideField = new ReasonWorkingOutsideField((JSONObject)json_data.get("Reason Working Outside Field"));// Reason for Not Working
            this.reasonForNotWorking = new ReasonForNotWorking((JSONObject)json_data.get("Reason for Not Working"));// Work Activity
            this.workActivity = new WorkActivity((JSONObject)json_data.get("Work Activity"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Employment; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Employment; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}