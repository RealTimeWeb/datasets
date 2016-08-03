package corgis.supremecourt.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.supremecourt.domain.DateReargued;
import corgis.supremecourt.domain.DateArgued;
import corgis.supremecourt.domain.Respondent;
import corgis.supremecourt.domain.Petitioner;

/**
 * 
 */
public class Arguments {
	
    private DateReargued dateReargued;
    private DateArgued dateArgued;
    private Respondent respondent;
    private Petitioner petitioner;
    
    
    /*
     * @return 
     */
    public DateReargued getDateReargued() {
        return this.dateReargued;
    }
    
    
    
    /*
     * @return 
     */
    public DateArgued getDateArgued() {
        return this.dateArgued;
    }
    
    
    
    /*
     * @return 
     */
    public Respondent getRespondent() {
        return this.respondent;
    }
    
    
    
    /*
     * @return 
     */
    public Petitioner getPetitioner() {
        return this.petitioner;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Arguments.
	
	 * @return String
	 */
	public String toString() {
		return "Arguments[" +dateReargued+", "+dateArgued+", "+respondent+", "+petitioner+"]";
	}
	
	/**
	 * Internal constructor to create a Arguments from a  representation.
	 * @param map The raw json data that will be parsed.
	 * @return 
	 */
    public Arguments(JSONObject json_data) {
        try {// date reargued
            this.dateReargued = new DateReargued((JSONObject)json_data.get("date reargued"));// date argued
            this.dateArgued = new DateArgued((JSONObject)json_data.get("date argued"));// respondent
            this.respondent = new Respondent((JSONObject)json_data.get("respondent"));// petitioner
            this.petitioner = new Petitioner((JSONObject)json_data.get("petitioner"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Arguments; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Arguments; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}