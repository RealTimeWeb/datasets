package corgis.drugs.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.drugs.domain.NewUsers;
import corgis.drugs.domain.UsedPastMonth;
import corgis.drugs.domain.UsedPastYear;
import corgis.drugs.domain.PerceptionsOfRisk;

/**
 * 
 */
public class Marijuana {
	
    private NewUsers newUsers;
    private UsedPastMonth usedPastMonth;
    private UsedPastYear usedPastYear;
    private PerceptionsOfRisk perceptionsOfRisk;
    
    
    /*
     * @return 
     */
    public NewUsers getNewUsers() {
        return this.newUsers;
    }
    
    
    
    /*
     * @return 
     */
    public UsedPastMonth getUsedPastMonth() {
        return this.usedPastMonth;
    }
    
    
    
    /*
     * @return 
     */
    public UsedPastYear getUsedPastYear() {
        return this.usedPastYear;
    }
    
    
    
    /*
     * @return 
     */
    public PerceptionsOfRisk getPerceptionsOfRisk() {
        return this.perceptionsOfRisk;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Marijuana.
	
	 * @return String
	 */
	public String toString() {
		return "Marijuana[" +newUsers+", "+usedPastMonth+", "+usedPastYear+", "+perceptionsOfRisk+"]";
	}
	
	/**
	 * Internal constructor to create a Marijuana from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Marijuana(JSONObject json_data) {
        try {// New Users
            this.newUsers = new NewUsers((JSONObject)json_data.get("New Users"));// Used Past Month
            this.usedPastMonth = new UsedPastMonth((JSONObject)json_data.get("Used Past Month"));// Used Past Year
            this.usedPastYear = new UsedPastYear((JSONObject)json_data.get("Used Past Year"));// Perceptions of Risk
            this.perceptionsOfRisk = new PerceptionsOfRisk((JSONObject)json_data.get("Perceptions of Risk"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Marijuana; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Marijuana; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}