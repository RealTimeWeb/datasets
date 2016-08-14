package corgis.medalofhonor.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.medalofhonor.domain.Awarded;
import corgis.medalofhonor.domain.Birth;
import corgis.medalofhonor.domain.MilitaryRecord;
import corgis.medalofhonor.domain.Metadata;

/**
 * 
 */
public class Awardee {
	
    private Boolean death;
    private String name;
    private Awarded awarded;
    private Birth birth;
    private MilitaryRecord militaryRecord;
    private Metadata metadata;
    
    
    /*
     * @return 
     */
    public Boolean getDeath() {
        return this.death;
    }
    
    
    
    /*
     * @return 
     */
    public String getName() {
        return this.name;
    }
    
    
    
    /*
     * @return 
     */
    public Awarded getAwarded() {
        return this.awarded;
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
    public MilitaryRecord getMilitaryRecord() {
        return this.militaryRecord;
    }
    
    
    
    /*
     * @return 
     */
    public Metadata getMetadata() {
        return this.metadata;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Awardee.
	
	 * @return String
	 */
	public String toString() {
		return "Awardee[" +death+", "+name+", "+awarded+", "+birth+", "+militaryRecord+", "+metadata+"]";
	}
	
	/**
	 * Internal constructor to create a Awardee from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Awardee(JSONObject json_data) {
        try {// death
            this.death = (Boolean)json_data.get("death");// name
            this.name = (String)json_data.get("name");// awarded
            this.awarded = new Awarded((JSONObject)json_data.get("awarded"));// birth
            this.birth = new Birth((JSONObject)json_data.get("birth"));// military record
            this.militaryRecord = new MilitaryRecord((JSONObject)json_data.get("military record"));// metadata
            this.metadata = new Metadata((JSONObject)json_data.get("metadata"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Awardee; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Awardee; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}