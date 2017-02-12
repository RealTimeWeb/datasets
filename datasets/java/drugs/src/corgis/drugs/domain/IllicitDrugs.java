package corgis.drugs.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.drugs.domain.AbusePastMonth;
import corgis.drugs.domain.DependencePastYear;
import corgis.drugs.domain.AllExceptMarijuanaUsedPastMonth;
import corgis.drugs.domain.CocaineUsedPastYear;
import corgis.drugs.domain.UsedPastMonth;
import corgis.drugs.domain.NeedTreatmentPastYear;

/**
 * 
 */
public class IllicitDrugs {
	
    private AbusePastMonth abusePastMonth;
    private DependencePastYear dependencePastYear;
    private AllExceptMarijuanaUsedPastMonth allExceptMarijuanaUsedPastMonth;
    private CocaineUsedPastYear cocaineUsedPastYear;
    private UsedPastMonth usedPastMonth;
    private NeedTreatmentPastYear needTreatmentPastYear;
    
    
    /*
     * @return 
     */
    public AbusePastMonth getAbusePastMonth() {
        return this.abusePastMonth;
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
    public AllExceptMarijuanaUsedPastMonth getAllExceptMarijuanaUsedPastMonth() {
        return this.allExceptMarijuanaUsedPastMonth;
    }
    
    
    
    /*
     * @return 
     */
    public CocaineUsedPastYear getCocaineUsedPastYear() {
        return this.cocaineUsedPastYear;
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
    public NeedTreatmentPastYear getNeedTreatmentPastYear() {
        return this.needTreatmentPastYear;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this IllicitDrugs.
	
	 * @return String
	 */
	public String toString() {
		return "IllicitDrugs[" +abusePastMonth+", "+dependencePastYear+", "+allExceptMarijuanaUsedPastMonth+", "+cocaineUsedPastYear+", "+usedPastMonth+", "+needTreatmentPastYear+"]";
	}
	
	/**
	 * Internal constructor to create a IllicitDrugs from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public IllicitDrugs(JSONObject json_data) {
        try {// Abuse Past Month
            this.abusePastMonth = new AbusePastMonth((JSONObject)json_data.get("Abuse Past Month"));// Dependence Past Year
            this.dependencePastYear = new DependencePastYear((JSONObject)json_data.get("Dependence Past Year"));// All Except Marijuana Used Past Month
            this.allExceptMarijuanaUsedPastMonth = new AllExceptMarijuanaUsedPastMonth((JSONObject)json_data.get("All Except Marijuana Used Past Month"));// Cocaine Used Past Year
            this.cocaineUsedPastYear = new CocaineUsedPastYear((JSONObject)json_data.get("Cocaine Used Past Year"));// Used Past Month
            this.usedPastMonth = new UsedPastMonth((JSONObject)json_data.get("Used Past Month"));// Need Treatment Past Year
            this.needTreatmentPastYear = new NeedTreatmentPastYear((JSONObject)json_data.get("Need Treatment Past Year"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a IllicitDrugs; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a IllicitDrugs; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}