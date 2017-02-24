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
import corgis.labor.domain.Unemployed;
import corgis.labor.domain.CivilianLaborForce;
import corgis.labor.domain.Employed;

/**
 * 
 */
public class Data {
	
    private CivilianNoninstitutionalPopulation civilianNoninstitutionalPopulation;
    private NotInLaborForce notInLaborForce;
    private Unemployed unemployed;
    private CivilianLaborForce civilianLaborForce;
    private Employed employed;
    
    
    /*
     * @return 
     */
    public CivilianNoninstitutionalPopulation getCivilianNoninstitutionalPopulation() {
        return this.civilianNoninstitutionalPopulation;
    }
    
    
    
    /*
     * @return 
     */
    public NotInLaborForce getNotInLaborForce() {
        return this.notInLaborForce;
    }
    
    
    
    /*
     * @return 
     */
    public Unemployed getUnemployed() {
        return this.unemployed;
    }
    
    
    
    /*
     * @return 
     */
    public CivilianLaborForce getCivilianLaborForce() {
        return this.civilianLaborForce;
    }
    
    
    
    /*
     * @return 
     */
    public Employed getEmployed() {
        return this.employed;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Data.
	
	 * @return String
	 */
	public String toString() {
		return "Data[" +civilianNoninstitutionalPopulation+", "+notInLaborForce+", "+unemployed+", "+civilianLaborForce+", "+employed+"]";
	}
	
	/**
	 * Internal constructor to create a Data from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Data(JSONObject json_data) {
        try {// Civilian Noninstitutional Population
            this.civilianNoninstitutionalPopulation = new CivilianNoninstitutionalPopulation((JSONObject)json_data.get("Civilian Noninstitutional Population"));// Not In Labor Force
            this.notInLaborForce = new NotInLaborForce((JSONObject)json_data.get("Not In Labor Force"));// Unemployed
            this.unemployed = new Unemployed((JSONObject)json_data.get("Unemployed"));// Civilian Labor Force
            this.civilianLaborForce = new CivilianLaborForce((JSONObject)json_data.get("Civilian Labor Force"));// Employed
            this.employed = new Employed((JSONObject)json_data.get("Employed"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}