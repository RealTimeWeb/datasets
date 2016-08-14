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
public class Data {
	
    private ArrayList<Rounds> rounds;
    private String year;
    
    
    /*
     * @return 
     */
    public ArrayList<Rounds> getRounds() {
        return this.rounds;
    }
    
    
    
    /*
     * @return 
     */
    public String getYear() {
        return this.year;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Data.
	
	 * @return String
	 */
	public String toString() {
		return "Data[" +rounds+", "+year+"]";
	}
	
	/**
	 * Internal constructor to create a Data from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Data(JSONObject json_data) {
        try {// rounds
            this.rounds = new ArrayList<Rounds>();
            Iterator<Object> roundsIter = ((List<Object>)json_data.get("rounds")).iterator();
            while (roundsIter.hasNext()) {
                this.rounds.add(new Rounds((JSONObject)roundsIter.next()));
            }// year
            this.year = (String)json_data.get("year");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}