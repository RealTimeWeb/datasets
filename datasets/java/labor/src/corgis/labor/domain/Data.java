package corgis.labor.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.labor.domain.CivilianLaborForce;
import corgis.labor.domain.NotInLaborForce;
import corgis.labor.domain.Unemployed;
import corgis.labor.domain.CivilianLaborForceParticipationRate;
import corgis.labor.domain.UnemploymentRate;
import corgis.labor.domain.CivilianNoninstitutionalPopulation;
import corgis.labor.domain.Employed;
import corgis.labor.domain.EmploymentPopulationRatio;

/**
 * 
 */
public class Data {
	
    private CivilianLaborForce civilianLaborForce;
    private NotInLaborForce notInLaborForce;
    private Unemployed unemployed;
    private CivilianLaborForceParticipationRate civilianLaborForceParticipationRate;
    private UnemploymentRate unemploymentRate;
    private CivilianNoninstitutionalPopulation civilianNoninstitutionalPopulation;
    private Employed employed;
    private EmploymentPopulationRatio employmentPopulationRatio;
    
    
    /*
     * @return 
     */
    public CivilianLaborForce getCivilianLaborForce() {
        return this.civilianLaborForce;
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
    public CivilianLaborForceParticipationRate getCivilianLaborForceParticipationRate() {
        return this.civilianLaborForceParticipationRate;
    }
    
    
    
    /*
     * @return 
     */
    public UnemploymentRate getUnemploymentRate() {
        return this.unemploymentRate;
    }
    
    
    
    /*
     * @return 
     */
    public CivilianNoninstitutionalPopulation getCivilianNoninstitutionalPopulation() {
        return this.civilianNoninstitutionalPopulation;
    }
    
    
    
    /*
     * @return 
     */
    public Employed getEmployed() {
        return this.employed;
    }
    
    
    
    /*
     * @return 
     */
    public EmploymentPopulationRatio getEmploymentPopulationRatio() {
        return this.employmentPopulationRatio;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Data.
	
	 * @return String
	 */
	public String toString() {
		return "Data[" +civilianLaborForce+", "+notInLaborForce+", "+unemployed+", "+civilianLaborForceParticipationRate+", "+unemploymentRate+", "+civilianNoninstitutionalPopulation+", "+employed+", "+employmentPopulationRatio+"]";
	}
	
	/**
	 * Internal constructor to create a Data from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Data(JSONObject json_data) {
        try {// Civilian labor force
            this.civilianLaborForce = new CivilianLaborForce((JSONObject)json_data.get("Civilian labor force"));// Not in labor force
            this.notInLaborForce = new NotInLaborForce((JSONObject)json_data.get("Not in labor force"));// Unemployed
            this.unemployed = new Unemployed((JSONObject)json_data.get("Unemployed"));// Civilian labor force participation rate
            this.civilianLaborForceParticipationRate = new CivilianLaborForceParticipationRate((JSONObject)json_data.get("Civilian labor force participation rate"));// Unemployment rate
            this.unemploymentRate = new UnemploymentRate((JSONObject)json_data.get("Unemployment rate"));// Civilian noninstitutional population
            this.civilianNoninstitutionalPopulation = new CivilianNoninstitutionalPopulation((JSONObject)json_data.get("Civilian noninstitutional population"));// Employed
            this.employed = new Employed((JSONObject)json_data.get("Employed"));// Employment-population ratio
            this.employmentPopulationRatio = new EmploymentPopulationRatio((JSONObject)json_data.get("Employment-population ratio"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}