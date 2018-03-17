package corgis.supreme_court.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.supreme_court.domain.DateReargued;
import corgis.supreme_court.domain.Respondent;
import corgis.supreme_court.domain.Petitioner;
import corgis.supreme_court.domain.DateArgued;

/**
 * 
 */
public class Arguments {
	
    private DateReargued dateReargued;
    private Respondent respondent;
    private Petitioner petitioner;
    private DateArgued dateArgued;
    
    
    /**
     * 
     * @return DateReargued
     */
    public DateReargued getDateReargued() {
        return this.dateReargued;
    }
    
    
    
    /**
     * 
     * @return Respondent
     */
    public Respondent getRespondent() {
        return this.respondent;
    }
    
    
    
    /**
     * 
     * @return Petitioner
     */
    public Petitioner getPetitioner() {
        return this.petitioner;
    }
    
    
    
    /**
     * 
     * @return DateArgued
     */
    public DateArgued getDateArgued() {
        return this.dateArgued;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Arguments.
	
	 * @return String
	 */
	public String toString() {
		return "Arguments[" +dateReargued+", "+respondent+", "+petitioner+", "+dateArgued+"]";
	}
	
	/**
	 * Internal constructor to create a Arguments from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Arguments(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // date reargued
            this.dateReargued = new DateReargued((JSONObject)json_data.get("date reargued"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Arguments; the field dateReargued was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Arguments; the field dateReargued had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // respondent
            this.respondent = new Respondent((JSONObject)json_data.get("respondent"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Arguments; the field respondent was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Arguments; the field respondent had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // petitioner
            this.petitioner = new Petitioner((JSONObject)json_data.get("petitioner"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Arguments; the field petitioner was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Arguments; the field petitioner had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // date argued
            this.dateArgued = new DateArgued((JSONObject)json_data.get("date argued"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Arguments; the field dateArgued was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Arguments; the field dateArgued had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}