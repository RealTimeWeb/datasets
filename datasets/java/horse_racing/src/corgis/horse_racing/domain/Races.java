package corgis.horse_racing.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.horse_racing.domain.Third;
import corgis.horse_racing.domain.Sixth;
import corgis.horse_racing.domain.Seventh;
import corgis.horse_racing.domain.Ninth;
import corgis.horse_racing.domain.Second;
import corgis.horse_racing.domain.Fourth;
import corgis.horse_racing.domain.Tenth;
import corgis.horse_racing.domain.Eighth;
import corgis.horse_racing.domain.Fifth;
import corgis.horse_racing.domain.First;

/**
 * 
 */
public class Races {
	
    private Third third;
    private Sixth sixth;
    private Seventh seventh;
    private Ninth ninth;
    private Second second;
    private Fourth fourth;
    private Tenth tenth;
    private Eighth eighth;
    private Fifth fifth;
    private First first;
    
    
    /*
     * @return 
     */
    public Third getThird() {
        return this.third;
    }
    
    
    
    /*
     * @return 
     */
    public Sixth getSixth() {
        return this.sixth;
    }
    
    
    
    /*
     * @return 
     */
    public Seventh getSeventh() {
        return this.seventh;
    }
    
    
    
    /*
     * @return 
     */
    public Ninth getNinth() {
        return this.ninth;
    }
    
    
    
    /*
     * @return 
     */
    public Second getSecond() {
        return this.second;
    }
    
    
    
    /*
     * @return 
     */
    public Fourth getFourth() {
        return this.fourth;
    }
    
    
    
    /*
     * @return 
     */
    public Tenth getTenth() {
        return this.tenth;
    }
    
    
    
    /*
     * @return 
     */
    public Eighth getEighth() {
        return this.eighth;
    }
    
    
    
    /*
     * @return 
     */
    public Fifth getFifth() {
        return this.fifth;
    }
    
    
    
    /*
     * @return 
     */
    public First getFirst() {
        return this.first;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Races.
	
	 * @return String
	 */
	public String toString() {
		return "Races[" +third+", "+sixth+", "+seventh+", "+ninth+", "+second+", "+fourth+", "+tenth+", "+eighth+", "+fifth+", "+first+"]";
	}
	
	/**
	 * Internal constructor to create a Races from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Races(JSONObject json_data) {
        try {// third
            this.third = new Third((JSONObject)json_data.get("third"));// sixth
            this.sixth = new Sixth((JSONObject)json_data.get("sixth"));// seventh
            this.seventh = new Seventh((JSONObject)json_data.get("seventh"));// ninth
            this.ninth = new Ninth((JSONObject)json_data.get("ninth"));// second
            this.second = new Second((JSONObject)json_data.get("second"));// fourth
            this.fourth = new Fourth((JSONObject)json_data.get("fourth"));// tenth
            this.tenth = new Tenth((JSONObject)json_data.get("tenth"));// eighth
            this.eighth = new Eighth((JSONObject)json_data.get("eighth"));// fifth
            this.fifth = new Fifth((JSONObject)json_data.get("fifth"));// first
            this.first = new First((JSONObject)json_data.get("first"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Races; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Races; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}