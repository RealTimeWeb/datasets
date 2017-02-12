package corgis.drugs.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.drugs.domain.CigarettePastMonth;
import corgis.drugs.domain.UsePastMonth;
import corgis.drugs.domain.PerceptionsOfRisk;

/**
 * 
 */
public class Tobacco {
	
    private CigarettePastMonth cigarettePastMonth;
    private UsePastMonth usePastMonth;
    private PerceptionsOfRisk perceptionsOfRisk;
    
    
    /*
     * @return 
     */
    public CigarettePastMonth getCigarettePastMonth() {
        return this.cigarettePastMonth;
    }
    
    
    
    /*
     * @return 
     */
    public UsePastMonth getUsePastMonth() {
        return this.usePastMonth;
    }
    
    
    
    /*
     * @return 
     */
    public PerceptionsOfRisk getPerceptionsOfRisk() {
        return this.perceptionsOfRisk;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Tobacco.
	
	 * @return String
	 */
	public String toString() {
		return "Tobacco[" +cigarettePastMonth+", "+usePastMonth+", "+perceptionsOfRisk+"]";
	}
	
	/**
	 * Internal constructor to create a Tobacco from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Tobacco(JSONObject json_data) {
        try {// Cigarette Past Month
            this.cigarettePastMonth = new CigarettePastMonth((JSONObject)json_data.get("Cigarette Past Month"));// Use Past Month
            this.usePastMonth = new UsePastMonth((JSONObject)json_data.get("Use Past Month"));// Perceptions of Risk
            this.perceptionsOfRisk = new PerceptionsOfRisk((JSONObject)json_data.get("Perceptions of Risk"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Tobacco; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Tobacco; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}