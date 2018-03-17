package corgis.education.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.education.domain.Race;
import corgis.education.domain.Other;
import corgis.education.domain.Gender;

/**
 * 
 */
public class Students {
	
    private Integer all;
    private Race race;
    private Other other;
    private Gender gender;
    // Each of these match to the different age groups for students: The first one is Preschool, the second is Kindergarten, and so on for 1st grade - 12th grade.
    private ArrayList<Integer> year;
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getAll() {
        return this.all;
    }
    
    
    
    /**
     * 
     * @return Race
     */
    public Race getRace() {
        return this.race;
    }
    
    
    
    /**
     * 
     * @return Other
     */
    public Other getOther() {
        return this.other;
    }
    
    
    
    /**
     * 
     * @return Gender
     */
    public Gender getGender() {
        return this.gender;
    }
    
    
    
    /**
     * Each of these match to the different age groups for students: The first one is Preschool, the second is Kindergarten, and so on for 1st grade - 12th grade.
     * @return ArrayList<Integer>
     */
    public ArrayList<Integer> getYear() {
        return this.year;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Students.
	
	 * @return String
	 */
	public String toString() {
		return "Students[" +all+", "+race+", "+other+", "+gender+", "+year+"]";
	}
	
	/**
	 * Internal constructor to create a Students from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Students(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // all
            this.all = ((Number)json_data.get("all")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Students; the field all was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Students; the field all had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // race
            this.race = new Race((JSONObject)json_data.get("race"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Students; the field race was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Students; the field race had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // other
            this.other = new Other((JSONObject)json_data.get("other"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Students; the field other was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Students; the field other had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // gender
            this.gender = new Gender((JSONObject)json_data.get("gender"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Students; the field gender was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Students; the field gender had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // year
            this.year = new ArrayList<Integer>();
            Iterator<Object> yearIter = ((List<Object>)json_data.get("year")).iterator();
            while (yearIter.hasNext()) {
                this.year.add(new Integer((Integer)yearIter.next()));
            }
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Students; the field year was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Students; the field year had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}