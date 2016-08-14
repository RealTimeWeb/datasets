package corgis.baseball.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.baseball.domain.Birth;
import corgis.baseball.domain.Attributes;

/**
 * 
 */
public class Players {
	
    private String name;
    private Birth birth;
    private ArrayList<Salaries> salaries;
    private ArrayList<Pitching> pitching;
    private Attributes attributes;
    private ArrayList<Fielding> fielding;
    private ArrayList<Batting> batting;
    
    
    /*
     * @return 
     */
    public String getName() {
        return this.name;
    }
    
    
    
    /*
     * @return 
     */
    public Birth getBirth() {
        return this.birth;
    }
    
    
    
    /*
     * @return 
     */
    public ArrayList<Salaries> getSalaries() {
        return this.salaries;
    }
    
    
    
    /*
     * @return 
     */
    public ArrayList<Pitching> getPitching() {
        return this.pitching;
    }
    
    
    
    /*
     * @return 
     */
    public Attributes getAttributes() {
        return this.attributes;
    }
    
    
    
    /*
     * @return 
     */
    public ArrayList<Fielding> getFielding() {
        return this.fielding;
    }
    
    
    
    /*
     * @return 
     */
    public ArrayList<Batting> getBatting() {
        return this.batting;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Players.
	
	 * @return String
	 */
	public String toString() {
		return "Players[" +name+", "+birth+", "+salaries+", "+pitching+", "+attributes+", "+fielding+", "+batting+"]";
	}
	
	/**
	 * Internal constructor to create a Players from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Players(JSONObject json_data) {
        try {// name
            this.name = (String)json_data.get("name");// birth
            this.birth = new Birth((JSONObject)json_data.get("birth"));// salaries
            this.salaries = new ArrayList<Salaries>();
            Iterator<Object> salariesIter = ((List<Object>)json_data.get("salaries")).iterator();
            while (salariesIter.hasNext()) {
                this.salaries.add(new Salaries((JSONObject)salariesIter.next()));
            }// pitching
            this.pitching = new ArrayList<Pitching>();
            Iterator<Object> pitchingIter = ((List<Object>)json_data.get("pitching")).iterator();
            while (pitchingIter.hasNext()) {
                this.pitching.add(new Pitching((JSONObject)pitchingIter.next()));
            }// attributes
            this.attributes = new Attributes((JSONObject)json_data.get("attributes"));// fielding
            this.fielding = new ArrayList<Fielding>();
            Iterator<Object> fieldingIter = ((List<Object>)json_data.get("fielding")).iterator();
            while (fieldingIter.hasNext()) {
                this.fielding.add(new Fielding((JSONObject)fieldingIter.next()));
            }// batting
            this.batting = new ArrayList<Batting>();
            Iterator<Object> battingIter = ((List<Object>)json_data.get("batting")).iterator();
            while (battingIter.hasNext()) {
                this.batting.add(new Batting((JSONObject)battingIter.next()));
            }
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Players; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Players; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}