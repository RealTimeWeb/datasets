package corgis.soccer.domain;

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
public class Rounds {
	
    private ArrayList<Matches> matches;
    private String name;
    
    
    /*
     * @return 
     */
    public ArrayList<Matches> getMatches() {
        return this.matches;
    }
    
    
    
    /*
     * @return 
     */
    public String getName() {
        return this.name;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Rounds.
	
	 * @return String
	 */
	public String toString() {
		return "Rounds[" +matches+", "+name+"]";
	}
	
	/**
	 * Internal constructor to create a Rounds from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Rounds(JSONObject json_data) {
        try {// matches
            this.matches = new ArrayList<Matches>();
            Iterator<Object> matchesIter = ((List<Object>)json_data.get("matches")).iterator();
            while (matchesIter.hasNext()) {
                this.matches.add(new Matches((JSONObject)matchesIter.next()));
            }// name
            this.name = (String)json_data.get("name");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Rounds; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Rounds; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}