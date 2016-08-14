package corgis.baseball.domain;

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
public class Stats {
	
    private Integer runs;
    private Integer attendance;
    private Integer atBats;
    private Integer wins;
    private Integer losses;
    private Integer hits;
    private Integer rank;
    private Integer errors;
    private Integer games;
    private Integer year;
    private Integer homeGames;
    
    
    /*
     * @return 
     */
    public Integer getRuns() {
        return this.runs;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getAttendance() {
        return this.attendance;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getAtBats() {
        return this.atBats;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getWins() {
        return this.wins;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getLosses() {
        return this.losses;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getHits() {
        return this.hits;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getRank() {
        return this.rank;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getErrors() {
        return this.errors;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getGames() {
        return this.games;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getYear() {
        return this.year;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getHomeGames() {
        return this.homeGames;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Stats.
	
	 * @return String
	 */
	public String toString() {
		return "Stats[" +runs+", "+attendance+", "+atBats+", "+wins+", "+losses+", "+hits+", "+rank+", "+errors+", "+games+", "+year+", "+homeGames+"]";
	}
	
	/**
	 * Internal constructor to create a Stats from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Stats(JSONObject json_data) {
        try {// runs
            this.runs = new Integer(((Long)json_data.get("runs")).intValue());// attendance
            this.attendance = new Integer(((Long)json_data.get("attendance")).intValue());// at bats
            this.atBats = new Integer(((Long)json_data.get("at bats")).intValue());// wins
            this.wins = new Integer(((Long)json_data.get("wins")).intValue());// losses
            this.losses = new Integer(((Long)json_data.get("losses")).intValue());// hits
            this.hits = new Integer(((Long)json_data.get("hits")).intValue());// rank
            this.rank = new Integer(((Long)json_data.get("rank")).intValue());// errors
            this.errors = new Integer(((Long)json_data.get("errors")).intValue());// games
            this.games = new Integer(((Long)json_data.get("games")).intValue());// year
            this.year = new Integer(((Long)json_data.get("year")).intValue());// home games
            this.homeGames = new Integer(((Long)json_data.get("home games")).intValue());
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Stats; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Stats; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}