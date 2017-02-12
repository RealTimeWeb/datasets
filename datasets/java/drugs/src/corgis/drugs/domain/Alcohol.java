package corgis.drugs.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.drugs.domain.AbusePastYear;
import corgis.drugs.domain.BingePastMonth;
import corgis.drugs.domain.PerceptionsOfRisk;
import corgis.drugs.domain.DependencePastYear;
import corgis.drugs.domain.InMinors;
import corgis.drugs.domain.UsePastMonth;
import corgis.drugs.domain.NeedTreatmentPastYear;

/**
 * 
 */
public class Alcohol {
	
    private AbusePastYear abusePastYear;
    private BingePastMonth bingePastMonth;
    private PerceptionsOfRisk perceptionsOfRisk;
    private DependencePastYear dependencePastYear;
    private InMinors inMinors;
    private UsePastMonth usePastMonth;
    private NeedTreatmentPastYear needTreatmentPastYear;
    
    
    /*
     * @return 
     */
    public AbusePastYear getAbusePastYear() {
        return this.abusePastYear;
    }
    
    
    
    /*
     * @return 
     */
    public BingePastMonth getBingePastMonth() {
        return this.bingePastMonth;
    }
    
    
    
    /*
     * @return 
     */
    public PerceptionsOfRisk getPerceptionsOfRisk() {
        return this.perceptionsOfRisk;
    }
    
    
    
    /*
     * @return 
     */
    public DependencePastYear getDependencePastYear() {
        return this.dependencePastYear;
    }
    
    
    
    /*
     * @return 
     */
    public InMinors getInMinors() {
        return this.inMinors;
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
    public NeedTreatmentPastYear getNeedTreatmentPastYear() {
        return this.needTreatmentPastYear;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Alcohol.
	
	 * @return String
	 */
	public String toString() {
		return "Alcohol[" +abusePastYear+", "+bingePastMonth+", "+perceptionsOfRisk+", "+dependencePastYear+", "+inMinors+", "+usePastMonth+", "+needTreatmentPastYear+"]";
	}
	
	/**
	 * Internal constructor to create a Alcohol from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Alcohol(JSONObject json_data) {
        try {// Abuse Past Year
            this.abusePastYear = new AbusePastYear((JSONObject)json_data.get("Abuse Past Year"));// Binge Past Month
            this.bingePastMonth = new BingePastMonth((JSONObject)json_data.get("Binge Past Month"));// Perceptions of Risk
            this.perceptionsOfRisk = new PerceptionsOfRisk((JSONObject)json_data.get("Perceptions of Risk"));// Dependence Past Year
            this.dependencePastYear = new DependencePastYear((JSONObject)json_data.get("Dependence Past Year"));// In Minors
            this.inMinors = new InMinors((JSONObject)json_data.get("In Minors"));// Use Past Month
            this.usePastMonth = new UsePastMonth((JSONObject)json_data.get("Use Past Month"));// Need Treatment Past Year
            this.needTreatmentPastYear = new NeedTreatmentPastYear((JSONObject)json_data.get("Need Treatment Past Year"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Alcohol; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Alcohol; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}