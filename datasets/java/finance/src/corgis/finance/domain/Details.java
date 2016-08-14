package corgis.finance.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.finance.domain.Education;
import corgis.finance.domain.Transportation;
import corgis.finance.domain.NaturalResources;
import corgis.finance.domain.Correction;
import corgis.finance.domain.Utilities;
import corgis.finance.domain.Health;
import corgis.finance.domain.PublicWelfare;
import corgis.finance.domain.FinancialAid;
import corgis.finance.domain.Welfare;
import corgis.finance.domain.Waste;
import corgis.finance.domain.Employment;
import corgis.finance.domain.Intergovernmental;
import corgis.finance.domain.InsuranceTrust;

/**
 * 
 */
public class Details {
	
    private Education education;
    private Transportation transportation;
    private NaturalResources naturalResources;
    private Correction correction;
    private Utilities utilities;
    private Health health;
    private PublicWelfare publicWelfare;
    private FinancialAid financialAid;
    private Welfare welfare;
    private Waste waste;
    private Employment employment;
    private Intergovernmental intergovernmental;
    private InsuranceTrust insuranceTrust;
    
    
    /*
     * @return 
     */
    public Education getEducation() {
        return this.education;
    }
    
    
    
    /*
     * @return 
     */
    public Transportation getTransportation() {
        return this.transportation;
    }
    
    
    
    /*
     * @return 
     */
    public NaturalResources getNaturalResources() {
        return this.naturalResources;
    }
    
    
    
    /*
     * @return 
     */
    public Correction getCorrection() {
        return this.correction;
    }
    
    
    
    /*
     * @return 
     */
    public Utilities getUtilities() {
        return this.utilities;
    }
    
    
    
    /*
     * @return 
     */
    public Health getHealth() {
        return this.health;
    }
    
    
    
    /*
     * @return 
     */
    public PublicWelfare getPublicWelfare() {
        return this.publicWelfare;
    }
    
    
    
    /*
     * @return 
     */
    public FinancialAid getFinancialAid() {
        return this.financialAid;
    }
    
    
    
    /*
     * @return 
     */
    public Welfare getWelfare() {
        return this.welfare;
    }
    
    
    
    /*
     * @return 
     */
    public Waste getWaste() {
        return this.waste;
    }
    
    
    
    /*
     * @return 
     */
    public Employment getEmployment() {
        return this.employment;
    }
    
    
    
    /*
     * @return 
     */
    public Intergovernmental getIntergovernmental() {
        return this.intergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public InsuranceTrust getInsuranceTrust() {
        return this.insuranceTrust;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Details.
	
	 * @return String
	 */
	public String toString() {
		return "Details[" +education+", "+transportation+", "+naturalResources+", "+correction+", "+utilities+", "+health+", "+publicWelfare+", "+financialAid+", "+welfare+", "+waste+", "+employment+", "+intergovernmental+", "+insuranceTrust+"]";
	}
	
	/**
	 * Internal constructor to create a Details from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Details(JSONObject json_data) {
        try {// Education
            this.education = new Education((JSONObject)json_data.get("Education"));// Transportation
            this.transportation = new Transportation((JSONObject)json_data.get("Transportation"));// Natural Resources
            this.naturalResources = new NaturalResources((JSONObject)json_data.get("Natural Resources"));// Correction
            this.correction = new Correction((JSONObject)json_data.get("Correction"));// Utilities
            this.utilities = new Utilities((JSONObject)json_data.get("Utilities"));// Health
            this.health = new Health((JSONObject)json_data.get("Health"));// Public Welfare
            this.publicWelfare = new PublicWelfare((JSONObject)json_data.get("Public Welfare"));// Financial Aid
            this.financialAid = new FinancialAid((JSONObject)json_data.get("Financial Aid"));// Welfare
            this.welfare = new Welfare((JSONObject)json_data.get("Welfare"));// Waste
            this.waste = new Waste((JSONObject)json_data.get("Waste"));// Employment
            this.employment = new Employment((JSONObject)json_data.get("Employment"));// Intergovernmental
            this.intergovernmental = new Intergovernmental((JSONObject)json_data.get("Intergovernmental"));// Insurance Trust
            this.insuranceTrust = new InsuranceTrust((JSONObject)json_data.get("Insurance Trust"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Details; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Details; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}