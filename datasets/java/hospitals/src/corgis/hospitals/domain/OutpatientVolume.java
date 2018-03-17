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
	
    private Integer musculoskeletal;
    private Integer cardiovascular;
    private Integer skin;
    private Integer genitourinary;
    private Integer eye;
    private Integer nervousSystem;
    private Integer gastrointestinal;
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getMusculoskeletal() {
        return this.musculoskeletal;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getCardiovascular() {
        return this.cardiovascular;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getSkin() {
        return this.skin;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getGenitourinary() {
        return this.genitourinary;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getEye() {
        return this.eye;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getNervousSystem() {
        return this.nervousSystem;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getGastrointestinal() {
        return this.gastrointestinal;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this OutpatientVolume.
	
	 * @return String
	 */
	public String toString() {
		return "OutpatientVolume[" +musculoskeletal+", "+cardiovascular+", "+skin+", "+genitourinary+", "+eye+", "+nervousSystem+", "+gastrointestinal+"]";
	}
	
	/**
	 * Internal constructor to create a OutpatientVolume from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public OutpatientVolume(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Musculoskeletal
            this.musculoskeletal = ((Number)json_data.get("Musculoskeletal")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a OutpatientVolume; the field musculoskeletal was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a OutpatientVolume; the field musculoskeletal had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Cardiovascular
            this.cardiovascular = ((Number)json_data.get("Cardiovascular")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a OutpatientVolume; the field cardiovascular was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a OutpatientVolume; the field cardiovascular had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Skin
            this.skin = ((Number)json_data.get("Skin")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a OutpatientVolume; the field skin was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a OutpatientVolume; the field skin had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Genitourinary
            this.genitourinary = ((Number)json_data.get("Genitourinary")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a OutpatientVolume; the field genitourinary was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a OutpatientVolume; the field genitourinary had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Eye
            this.eye = ((Number)json_data.get("Eye")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a OutpatientVolume; the field eye was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a OutpatientVolume; the field eye had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Nervous System
            this.nervousSystem = ((Number)json_data.get("Nervous System")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a OutpatientVolume; the field nervousSystem was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a OutpatientVolume; the field nervousSystem had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Gastrointestinal
            this.gastrointestinal = ((Number)json_data.get("Gastrointestinal")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a OutpatientVolume; the field gastrointestinal was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a OutpatientVolume; the field gastrointestinal had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}