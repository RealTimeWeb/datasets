package corgis.hospitals.domain;

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
public class OutpatientVolume {
	
    private Integer genitourinary;
    private Integer eye;
    private Integer nervousSystem;
    private Integer musculoskeletal;
    private Integer skin;
    private Integer gastrointestinal;
    private Integer cardiovascular;
    
    
    /*
     * @return 
     */
    public Integer getGenitourinary() {
        return this.genitourinary;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getEye() {
        return this.eye;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getNervousSystem() {
        return this.nervousSystem;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getMusculoskeletal() {
        return this.musculoskeletal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getSkin() {
        return this.skin;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getGastrointestinal() {
        return this.gastrointestinal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getCardiovascular() {
        return this.cardiovascular;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this OutpatientVolume.
	
	 * @return String
	 */
	public String toString() {
		return "OutpatientVolume[" +genitourinary+", "+eye+", "+nervousSystem+", "+musculoskeletal+", "+skin+", "+gastrointestinal+", "+cardiovascular+"]";
	}
	
	/**
	 * Internal constructor to create a OutpatientVolume from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public OutpatientVolume(JSONObject json_data) {
        try {// Genitourinary
            this.genitourinary = new Integer(((Long)json_data.get("Genitourinary")).intValue());// Eye
            this.eye = new Integer(((Long)json_data.get("Eye")).intValue());// Nervous System
            this.nervousSystem = new Integer(((Long)json_data.get("Nervous System")).intValue());// Musculoskeletal
            this.musculoskeletal = new Integer(((Long)json_data.get("Musculoskeletal")).intValue());// Skin
            this.skin = new Integer(((Long)json_data.get("Skin")).intValue());// Gastrointestinal
            this.gastrointestinal = new Integer(((Long)json_data.get("Gastrointestinal")).intValue());// Cardiovascular
            this.cardiovascular = new Integer(((Long)json_data.get("Cardiovascular")).intValue());
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a OutpatientVolume; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a OutpatientVolume; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}