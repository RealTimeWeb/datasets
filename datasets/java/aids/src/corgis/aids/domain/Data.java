package corgis.aids.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.aids.domain.AidsRelatedDeaths;
import corgis.aids.domain.HivPrevalence;
import corgis.aids.domain.PeopleLivingWithHiv;
import corgis.aids.domain.NewHivInfections;

/**
 * 
 */
public class Data {
	
    private AidsRelatedDeaths aidsRelatedDeaths;
    private HivPrevalence hivPrevalence;
    private PeopleLivingWithHiv peopleLivingWithHiv;
    private NewHivInfections newHivInfections;
    
    
    /**
     * 
     * @return AidsRelatedDeaths
     */
    public AidsRelatedDeaths getAidsRelatedDeaths() {
        return this.aidsRelatedDeaths;
    }
    
    
    
    /**
     * 
     * @return HivPrevalence
     */
    public HivPrevalence getHivPrevalence() {
        return this.hivPrevalence;
    }
    
    
    
    /**
     * 
     * @return PeopleLivingWithHiv
     */
    public PeopleLivingWithHiv getPeopleLivingWithHiv() {
        return this.peopleLivingWithHiv;
    }
    
    
    
    /**
     * 
     * @return NewHivInfections
     */
    public NewHivInfections getNewHivInfections() {
        return this.newHivInfections;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Data.
	
	 * @return String
	 */
	public String toString() {
		return "Data[" +aidsRelatedDeaths+", "+hivPrevalence+", "+peopleLivingWithHiv+", "+newHivInfections+"]";
	}
	
	/**
	 * Internal constructor to create a Data from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Data(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // AIDS-Related Deaths
            this.aidsRelatedDeaths = new AidsRelatedDeaths((JSONObject)json_data.get("AIDS-Related Deaths"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field aidsRelatedDeaths was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field aidsRelatedDeaths had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // HIV Prevalence
            this.hivPrevalence = new HivPrevalence((JSONObject)json_data.get("HIV Prevalence"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field hivPrevalence was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field hivPrevalence had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // People Living with HIV
            this.peopleLivingWithHiv = new PeopleLivingWithHiv((JSONObject)json_data.get("People Living with HIV"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field peopleLivingWithHiv was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field peopleLivingWithHiv had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // New HIV Infections
            this.newHivInfections = new NewHivInfections((JSONObject)json_data.get("New HIV Infections"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field newHivInfections was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field newHivInfections had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}