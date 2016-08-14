package corgis.soccer.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.soccer.domain.Date;
import corgis.soccer.domain.Home;
import corgis.soccer.domain.Away;

/**
 * 
 */
public class Matches {
	
    private Date date;
    private Home home;
    private Away away;
    
    
    /*
     * @return 
     */
    public Date getDate() {
        return this.date;
    }
    
    
    
    /*
     * @return 
     */
    public Home getHome() {
        return this.home;
    }
    
    
    
    /*
     * @return 
     */
    public Away getAway() {
        return this.away;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Matches.
	
	 * @return String
	 */
	public String toString() {
		return "Matches[" +date+", "+home+", "+away+"]";
	}
	
	/**
	 * Internal constructor to create a Matches from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Matches(JSONObject json_data) {
        try {// date
            this.date = new Date((JSONObject)json_data.get("date"));// home
            this.home = new Home((JSONObject)json_data.get("home"));// away
            this.away = new Away((JSONObject)json_data.get("away"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Matches; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Matches; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}