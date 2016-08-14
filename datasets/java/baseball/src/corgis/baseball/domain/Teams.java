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
public class Teams {
	
    private ArrayList<Stats> stats;
    private String id;
    private String name;
    
    
    /*
     * @return 
     */
    public ArrayList<Stats> getStats() {
        return this.stats;
    }
    
    
    
    /*
     * @return 
     */
    public String getId() {
        return this.id;
    }
    
    
    
    /*
     * @return 
     */
    public String getName() {
        return this.name;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Teams.
	
	 * @return String
	 */
	public String toString() {
		return "Teams[" +stats+", "+id+", "+name+"]";
	}
	
	/**
	 * Internal constructor to create a Teams from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Teams(JSONObject json_data) {
        try {// stats
            this.stats = new ArrayList<Stats>();
            Iterator<Object> statsIter = ((List<Object>)json_data.get("stats")).iterator();
            while (statsIter.hasNext()) {
                this.stats.add(new Stats((JSONObject)statsIter.next()));
            }// id
            this.id = (String)json_data.get("id");// name
            this.name = (String)json_data.get("name");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Teams; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Teams; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}