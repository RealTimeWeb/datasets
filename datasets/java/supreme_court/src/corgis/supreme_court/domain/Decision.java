package corgis.supreme_court.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.supreme_court.domain.Case_;
import corgis.supreme_court.domain.AdminAction;
import corgis.supreme_court.domain.Date;

/**
 * 
 */
public class Decision {
	
    private Boolean precedentAltered;
    private Case_ case_;
    private String direction;
    private String unconstitutional;
    private String authorityOne;
    private String authorityTwo;
    private AdminAction adminAction;
    private String jurisdiction;
    private Integer term;
    private Date date;
    private String winningParty;
    private String type;
    private Boolean dissentAgrees;
    
    
    /*
     * @return 
     */
    public Boolean getPrecedentAltered() {
        return this.precedentAltered;
    }
    
    
    
    /*
     * @return 
     */
    public Case_ getCase_() {
        return this.case_;
    }
    
    
    
    /*
     * @return 
     */
    public String getDirection() {
        return this.direction;
    }
    
    
    
    /*
     * @return 
     */
    public String getUnconstitutional() {
        return this.unconstitutional;
    }
    
    
    
    /*
     * @return 
     */
    public String getAuthorityOne() {
        return this.authorityOne;
    }
    
    
    
    /*
     * @return 
     */
    public String getAuthorityTwo() {
        return this.authorityTwo;
    }
    
    
    
    /*
     * @return 
     */
    public AdminAction getAdminAction() {
        return this.adminAction;
    }
    
    
    
    /*
     * @return 
     */
    public String getJurisdiction() {
        return this.jurisdiction;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getTerm() {
        return this.term;
    }
    
    
    
    /*
     * @return 
     */
    public Date getDate() {
        return this.date;
    }
    
    
    
    /*
     * @return 
     */
    public String getWinningParty() {
        return this.winningParty;
    }
    
    
    
    /*
     * @return 
     */
    public String getType() {
        return this.type;
    }
    
    
    
    /*
     * @return 
     */
    public Boolean getDissentAgrees() {
        return this.dissentAgrees;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Decision.
	
	 * @return String
	 */
	public String toString() {
		return "Decision[" +precedentAltered+", "+case_+", "+direction+", "+unconstitutional+", "+authorityOne+", "+authorityTwo+", "+adminAction+", "+jurisdiction+", "+term+", "+date+", "+winningParty+", "+type+", "+dissentAgrees+"]";
	}
	
	/**
	 * Internal constructor to create a Decision from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Decision(JSONObject json_data) {
        try {// precedent altered?
            this.precedentAltered = (Boolean)json_data.get("precedent altered?");// case
            this.case_ = new Case_((JSONObject)json_data.get("case"));// direction
            this.direction = (String)json_data.get("direction");// unconstitutional
            this.unconstitutional = (String)json_data.get("unconstitutional");// authority 1
            this.authorityOne = (String)json_data.get("authority 1");// authority 2
            this.authorityTwo = (String)json_data.get("authority 2");// admin action
            this.adminAction = new AdminAction((JSONObject)json_data.get("admin action"));// jurisdiction
            this.jurisdiction = (String)json_data.get("jurisdiction");// term
            this.term = ((Number)json_data.get("term")).intValue();// date
            this.date = new Date((JSONObject)json_data.get("date"));// winning party
            this.winningParty = (String)json_data.get("winning party");// type
            this.type = (String)json_data.get("type");// dissent agrees
            this.dissentAgrees = (Boolean)json_data.get("dissent agrees");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Decision; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Decision; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}