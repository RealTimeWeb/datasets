package corgis.drugs.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.drugs.domain.PainRelieversAbusePastYear;
import corgis.drugs.domain.IllicitDrugs;
import corgis.drugs.domain.Marijuana;
import corgis.drugs.domain.Tobacco;
import corgis.drugs.domain.Alcohol;

/**
 * 
 */
public class Rates {
	
    private PainRelieversAbusePastYear painRelieversAbusePastYear;
    private IllicitDrugs illicitDrugs;
    private Marijuana marijuana;
    private Tobacco tobacco;
    private Alcohol alcohol;
    
    
    /*
     * @return 
     */
    public PainRelieversAbusePastYear getPainRelieversAbusePastYear() {
        return this.painRelieversAbusePastYear;
    }
    
    
    
    /*
     * @return 
     */
    public IllicitDrugs getIllicitDrugs() {
        return this.illicitDrugs;
    }
    
    
    
    /*
     * @return 
     */
    public Marijuana getMarijuana() {
        return this.marijuana;
    }
    
    
    
    /*
     * @return 
     */
    public Tobacco getTobacco() {
        return this.tobacco;
    }
    
    
    
    /*
     * @return 
     */
    public Alcohol getAlcohol() {
        return this.alcohol;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Rates.
	
	 * @return String
	 */
	public String toString() {
		return "Rates[" +painRelieversAbusePastYear+", "+illicitDrugs+", "+marijuana+", "+tobacco+", "+alcohol+"]";
	}
	
	/**
	 * Internal constructor to create a Rates from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Rates(JSONObject json_data) {
        try {// Pain Relievers Abuse Past Year
            this.painRelieversAbusePastYear = new PainRelieversAbusePastYear((JSONObject)json_data.get("Pain Relievers Abuse Past Year"));// Illicit Drugs
            this.illicitDrugs = new IllicitDrugs((JSONObject)json_data.get("Illicit Drugs"));// Marijuana
            this.marijuana = new Marijuana((JSONObject)json_data.get("Marijuana"));// Tobacco
            this.tobacco = new Tobacco((JSONObject)json_data.get("Tobacco"));// Alcohol
            this.alcohol = new Alcohol((JSONObject)json_data.get("Alcohol"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Rates; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Rates; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}