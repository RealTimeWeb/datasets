package corgis.supremecourt.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.supremecourt.domain.Jurisdiction;
import corgis.supremecourt.domain.AuthorityOne;
import corgis.supremecourt.domain.AdminAction;
import corgis.supremecourt.domain.CaseData;
import corgis.supremecourt.domain.Date;

/**
 * 
 */
public class Decision {
	
    private Boolean precedentAltered;
    private String direction;
    private Jurisdiction jurisdiction;
    private AuthorityOne authorityOne;
    private String authorityTwo;
    private AdminAction adminAction;
    private String unconstitutional;
    private Integer term;
    private CaseData caseData;
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
    public String getDirection() {
        return this.direction;
    }
    
    
    
    /*
     * @return 
     */
    public Jurisdiction getJurisdiction() {
        return this.jurisdiction;
    }
    
    
    
    /*
     * @return 
     */
    public AuthorityOne getAuthorityOne() {
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
    public String getUnconstitutional() {
        return this.unconstitutional;
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
    public CaseData getCaseData() {
        return this.caseData;
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
		return "Decision[" +precedentAltered+", "+direction+", "+jurisdiction+", "+authorityOne+", "+authorityTwo+", "+adminAction+", "+unconstitutional+", "+term+", "+caseData+", "+date+", "+winningParty+", "+type+", "+dissentAgrees+"]";
	}
	
	/**
	 * Internal constructor to create a Decision from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Decision(JSONObject json_data) {
        try {// precedent altered?
            this.precedentAltered = (Boolean)json_data.get("precedent altered?");// direction
            this.direction = (String)json_data.get("direction");// jurisdiction
            this.jurisdiction = new Jurisdiction((JSONObject)json_data.get("jurisdiction"));// authority 1
            this.authorityOne = new AuthorityOne((JSONObject)json_data.get("authority 1"));// authority 2
            this.authorityTwo = (String)json_data.get("authority 2");// admin action
            this.adminAction = new AdminAction((JSONObject)json_data.get("admin action"));// unconstitutional
            this.unconstitutional = (String)json_data.get("unconstitutional");// term
            this.term = new Integer(((Long)json_data.get("term")).intValue());// case data
            this.caseData = new CaseData((JSONObject)json_data.get("case data"));// date
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