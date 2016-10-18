package corgis.education.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.education.domain.Gender;
import corgis.education.domain.Race;
import corgis.education.domain.Other;

/**
 * 
 */
public class Students {
	
    private Gender gender;
    private Integer all;
    private Race race;
    private Other other;
    // Each of these match to the different age groups for students: The first one is Preschool, the second is Kindergarten, and so on for 1st grade - 12th grade.
    private ArrayList<Integer> year;
    
    
    /*
     * @return 
     */
    public Gender getGender() {
        return this.gender;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getAll() {
        return this.all;
    }
    
    
    
    /*
     * @return 
     */
    public Race getRace() {
        return this.race;
    }
    
    
    
    /*
     * @return 
     */
    public Other getOther() {
        return this.other;
    }
    
    
    
    /*
     * @return 
     */
    public ArrayList<Integer> getYear() {
        return this.year;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Students.
	
	 * @return String
	 */
	public String toString() {
		return "Students[" +gender+", "+all+", "+race+", "+other+", "+year+"]";
	}
	
	/**
	 * Internal constructor to create a Students from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Students(JSONObject json_data) {
        try {// gender
            this.gender = new Gender((JSONObject)json_data.get("gender"));// all
            this.all = ((Number)json_data.get("all")).intValue();// race
            this.race = new Race((JSONObject)json_data.get("race"));// other
            this.other = new Other((JSONObject)json_data.get("other"));// year
            this.year = new ArrayList<Integer>();
            Iterator<Object> yearIter = ((List<Object>)json_data.get("year")).iterator();
            while (yearIter.hasNext()) {
                this.year.add(new Integer((Integer)yearIter.next()));
            }
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Students; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Students; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}