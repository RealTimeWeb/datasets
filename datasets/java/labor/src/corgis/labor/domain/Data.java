package corgis.labor.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.labor.domain.CivilianNoninstitutionalPopulation;
import corgis.labor.domain.NotInLaborForce;
import corgis.labor.domain.Employed;
import corgis.labor.domain.CivilianLaborForce;
import corgis.labor.domain.Unemployed;

/**
 * 
 */
public class Data {
	
    private CivilianNoninstitutionalPopulation civilianNoninstitutionalPopulation;
    private NotInLaborForce notInLaborForce;
    private Employed employed;
    private CivilianLaborForce civilianLaborForce;
    private Unemployed unemployed;
    
    
    /**
     * 
     * @return CivilianNoninstitutionalPopulation
     */
    public CivilianNoninstitutionalPopulation getCivilianNoninstitutionalPopulation() {
        return this.civilianNoninstitutionalPopulation;
    }
    
    
    
    /**
     * 
     * @return NotInLaborForce
     */
    public NotInLaborForce getNotInLaborForce() {
        return this.notInLaborForce;
    }
    
    
    
    /**
     * 
     * @return Employed
     */
    public Employed getEmployed() {
        return this.employed;
    }
    
    
    
    /**
     * 
     * @return CivilianLaborForce
     */
    public CivilianLaborForce getCivilianLaborForce() {
        return this.civilianLaborForce;
    }
    
    
    
    /**
     * 
     * @return Unemployed
     */
    public Unemployed getUnemployed() {
        return this.unemployed;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Data.
	
	 * @return String
	 */
	public String toString() {
		return "Data[" +civilianNoninstitutionalPopulation+", "+notInLaborForce+", "+employed+", "+civilianLaborForce+", "+unemployed+"]";
	}
	
	/**
	 * Internal constructor to create a Data from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Data(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Civilian Noninstitutional Population
            this.civilianNoninstitutionalPopulation = new CivilianNoninstitutionalPopulation((JSONObject)json_data.get("Civilian Noninstitutional Population"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field civilianNoninstitutionalPopulation was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field civilianNoninstitutionalPopulation had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Not In Labor Force
            this.notInLaborForce = new NotInLaborForce((JSONObject)json_data.get("Not In Labor Force"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field notInLaborForce was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field notInLaborForce had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Employed
            this.employed = new Employed((JSONObject)json_data.get("Employed"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field employed was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field employed had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Civilian Labor Force
            this.civilianLaborForce = new CivilianLaborForce((JSONObject)json_data.get("Civilian Labor Force"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field civilianLaborForce was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field civilianLaborForce had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Unemployed
            this.unemployed = new Unemployed((JSONObject)json_data.get("Unemployed"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field unemployed was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field unemployed had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}