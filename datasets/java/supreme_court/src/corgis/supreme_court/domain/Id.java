package corgis.supreme_court.domain;

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
public class Id {
	
    private String docket;
    private String case_;
    private String vote;
    private String caseIssues;
    
    
    /**
     * 
     * @return String
     */
    public String getDocket() {
        return this.docket;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getCase_() {
        return this.case_;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getVote() {
        return this.vote;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getCaseIssues() {
        return this.caseIssues;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Id.
	
	 * @return String
	 */
	public String toString() {
		return "Id[" +docket+", "+case_+", "+vote+", "+caseIssues+"]";
	}
	
	/**
	 * Internal constructor to create a Id from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Id(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // docket
            this.docket = (String)json_data.get("docket");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Id; the field docket was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Id; the field docket had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // case
            this.case_ = (String)json_data.get("case");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Id; the field case_ was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Id; the field case_ had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // vote
            this.vote = (String)json_data.get("vote");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Id; the field vote was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Id; the field vote had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // case issues
            this.caseIssues = (String)json_data.get("case issues");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Id; the field caseIssues was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Id; the field caseIssues had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}