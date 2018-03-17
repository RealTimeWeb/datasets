package corgis.suicide_attacks.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.suicide_attacks.domain.Campaign;
import corgis.suicide_attacks.domain.Attacker;
import corgis.suicide_attacks.domain.Date;
import corgis.suicide_attacks.domain.Statistics;
import corgis.suicide_attacks.domain.Target;

/**
 * 
 */
public class Attack {
	
    private Campaign campaign;
    private Attacker attacker;
    private Date date;
    private ArrayList<String> groups;
    private Statistics statistics;
    private Target target;
    
    
    /**
     * 
     * @return Campaign
     */
    public Campaign getCampaign() {
        return this.campaign;
    }
    
    
    
    /**
     * 
     * @return Attacker
     */
    public Attacker getAttacker() {
        return this.attacker;
    }
    
    
    
    /**
     * 
     * @return Date
     */
    public Date getDate() {
        return this.date;
    }
    
    
    
    /**
     * 
     * @return ArrayList<String>
     */
    public ArrayList<String> getGroups() {
        return this.groups;
    }
    
    
    
    /**
     * 
     * @return Statistics
     */
    public Statistics getStatistics() {
        return this.statistics;
    }
    
    
    
    /**
     * 
     * @return Target
     */
    public Target getTarget() {
        return this.target;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Attack.
	
	 * @return String
	 */
	public String toString() {
		return "Attack[" +campaign+", "+attacker+", "+date+", "+groups+", "+statistics+", "+target+"]";
	}
	
	/**
	 * Internal constructor to create a Attack from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Attack(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // campaign
            this.campaign = new Campaign((JSONObject)json_data.get("campaign"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Attack; the field campaign was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Attack; the field campaign had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // attacker
            this.attacker = new Attacker((JSONObject)json_data.get("attacker"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Attack; the field attacker was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Attack; the field attacker had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // date
            this.date = new Date((JSONObject)json_data.get("date"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Attack; the field date was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Attack; the field date had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // groups
            this.groups = new ArrayList<String>();
            Iterator<Object> groupsIter = ((List<Object>)json_data.get("groups")).iterator();
            while (groupsIter.hasNext()) {
                this.groups.add(new String((String)groupsIter.next()));
            }
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Attack; the field groups was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Attack; the field groups had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // statistics
            this.statistics = new Statistics((JSONObject)json_data.get("statistics"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Attack; the field statistics was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Attack; the field statistics had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // target
            this.target = new Target((JSONObject)json_data.get("target"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Attack; the field target was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Attack; the field target had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}