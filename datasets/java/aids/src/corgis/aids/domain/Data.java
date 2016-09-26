package corgis.aids.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.aids.domain.HivPrevalence;
import corgis.aids.domain.PeopleLivingWithHiv;
import corgis.aids.domain.NewHivInfections;
import corgis.aids.domain.AidsRelatedDeaths;

/**
 * 
 */
public class Data {
	
    private HivPrevalence hivPrevalence;
    private PeopleLivingWithHiv peopleLivingWithHiv;
    private NewHivInfections newHivInfections;
    private AidsRelatedDeaths aidsRelatedDeaths;
    
    
    /*
     * @return 
     */
    public HivPrevalence getHivPrevalence() {
        return this.hivPrevalence;
    }
    
    
    
    /*
     * @return 
     */
    public PeopleLivingWithHiv getPeopleLivingWithHiv() {
        return this.peopleLivingWithHiv;
    }
    
    
    
    /*
     * @return 
     */
    public NewHivInfections getNewHivInfections() {
        return this.newHivInfections;
    }
    
    
    
    /*
     * @return 
     */
    public AidsRelatedDeaths getAidsRelatedDeaths() {
        return this.aidsRelatedDeaths;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Data.
	
	 * @return String
	 */
	public String toString() {
		return "Data[" +hivPrevalence+", "+peopleLivingWithHiv+", "+newHivInfections+", "+aidsRelatedDeaths+"]";
	}
	
	/**
	 * Internal constructor to create a Data from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Data(JSONObject json_data) {
        try {// HIV Prevalence
            this.hivPrevalence = new HivPrevalence((JSONObject)json_data.get("HIV Prevalence"));// People Living with HIV
            this.peopleLivingWithHiv = new PeopleLivingWithHiv((JSONObject)json_data.get("People Living with HIV"));// New HIV Infections
            this.newHivInfections = new NewHivInfections((JSONObject)json_data.get("New HIV Infections"));// AIDS-Related Deaths
            this.aidsRelatedDeaths = new AidsRelatedDeaths((JSONObject)json_data.get("AIDS-Related Deaths"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}