package corgis.suicideattacks.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.suicideattacks.domain.Statistics;
import corgis.suicideattacks.domain.Target;
import corgis.suicideattacks.domain.Campaign;
import corgis.suicideattacks.domain.Attacker;
import corgis.suicideattacks.domain.Date;

/**
 * 
 */
public class Attack {
	
    private Statistics statistics;
    private Target target;
    private Campaign campaign;
    private Attacker attacker;
    private ArrayList<String> groups;
    private Date date;
    
    
    /*
     * @return 
     */
    public Statistics getStatistics() {
        return this.statistics;
    }
    
    
    
    /*
     * @return 
     */
    public Target getTarget() {
        return this.target;
    }
    
    
    
    /*
     * @return 
     */
    public Campaign getCampaign() {
        return this.campaign;
    }
    
    
    
    /*
     * @return 
     */
    public Attacker getAttacker() {
        return this.attacker;
    }
    
    
    
    /*
     * @return 
     */
    public ArrayList<String> getGroups() {
        return this.groups;
    }
    
    
    
    /*
     * @return 
     */
    public Date getDate() {
        return this.date;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Attack.
	
	 * @return String
	 */
	public String toString() {
		return "Attack[" +statistics+", "+target+", "+campaign+", "+attacker+", "+groups+", "+date+"]";
	}
	
	/**
	 * Internal constructor to create a Attack from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Attack(JSONObject json_data) {
        try {// statistics
            this.statistics = new Statistics((JSONObject)json_data.get("statistics"));// target
            this.target = new Target((JSONObject)json_data.get("target"));// campaign
            this.campaign = new Campaign((JSONObject)json_data.get("campaign"));// attacker
            this.attacker = new Attacker((JSONObject)json_data.get("attacker"));// groups
            this.groups = new ArrayList<String>();
            Iterator<Object> groupsIter = ((List<Object>)json_data.get("groups")).iterator();
            while (groupsIter.hasNext()) {
                this.groups.add(new String((String)groupsIter.next()));
            }// date
            this.date = new Date((JSONObject)json_data.get("date"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Attack; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Attack; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}