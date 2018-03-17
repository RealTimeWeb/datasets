package corgis.medal_of_honor.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.medal_of_honor.domain.Metadata;
import corgis.medal_of_honor.domain.Birth;
import corgis.medal_of_honor.domain.MilitaryRecord;
import corgis.medal_of_honor.domain.Awarded;

/**
 * 
 */
public class Awardee {
	
    private Metadata metadata;
    private Birth birth;
    private Boolean death;
    private String name;
    private MilitaryRecord militaryRecord;
    private Awarded awarded;
    
    
    /**
     * 
     * @return Metadata
     */
    public Metadata getMetadata() {
        return this.metadata;
    }
    
    
    
    /**
     * 
     * @return Birth
     */
    public Birth getBirth() {
        return this.birth;
    }
    
    
    
    /**
     * 
     * @return Boolean
     */
    public Boolean getDeath() {
        return this.death;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getName() {
        return this.name;
    }
    
    
    
    /**
     * 
     * @return MilitaryRecord
     */
    public MilitaryRecord getMilitaryRecord() {
        return this.militaryRecord;
    }
    
    
    
    /**
     * 
     * @return Awarded
     */
    public Awarded getAwarded() {
        return this.awarded;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Awardee.
	
	 * @return String
	 */
	public String toString() {
		return "Awardee[" +metadata+", "+birth+", "+death+", "+name+", "+militaryRecord+", "+awarded+"]";
	}
	
	/**
	 * Internal constructor to create a Awardee from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Awardee(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // metadata
            this.metadata = new Metadata((JSONObject)json_data.get("metadata"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Awardee; the field metadata was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Awardee; the field metadata had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // birth
            this.birth = new Birth((JSONObject)json_data.get("birth"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Awardee; the field birth was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Awardee; the field birth had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // death
            this.death = (Boolean)json_data.get("death");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Awardee; the field death was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Awardee; the field death had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // name
            this.name = (String)json_data.get("name");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Awardee; the field name was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Awardee; the field name had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // military record
            this.militaryRecord = new MilitaryRecord((JSONObject)json_data.get("military record"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Awardee; the field militaryRecord was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Awardee; the field militaryRecord had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // awarded
            this.awarded = new Awarded((JSONObject)json_data.get("awarded"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Awardee; the field awarded was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Awardee; the field awarded had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}