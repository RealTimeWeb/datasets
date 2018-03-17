package corgis.immigration.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.immigration.domain.Refugees;
import corgis.immigration.domain.LegalPermanantResidences;
import corgis.immigration.domain.NonimmigrantAdmissions;
import corgis.immigration.domain.Enforcement;

/**
 * 
 */
public class Data {
	
    private Refugees refugees;
    // Naturalization is the process by which U.S. citizenship is granted to a foreign citizen or national after he or she fulfills the requirements established by Congress in the Immigration and Nationality Act (INA). This is the number that became naturalized in this year from the associated country. Note that this is not the number of naturally-born citizens, which is a different form of citizenship.
    private Integer naturalizationsBirth;
    private LegalPermanantResidences legalPermanantResidences;
    private NonimmigrantAdmissions nonimmigrantAdmissions;
    private Enforcement enforcement;
    
    
    /**
     * 
     * @return Refugees
     */
    public Refugees getRefugees() {
        return this.refugees;
    }
    
    
    
    /**
     * Naturalization is the process by which U.S. citizenship is granted to a foreign citizen or national after he or she fulfills the requirements established by Congress in the Immigration and Nationality Act (INA). This is the number that became naturalized in this year from the associated country. Note that this is not the number of naturally-born citizens, which is a different form of citizenship.
     * @return Integer
     */
    public Integer getNaturalizationsBirth() {
        return this.naturalizationsBirth;
    }
    
    
    
    /**
     * 
     * @return LegalPermanantResidences
     */
    public LegalPermanantResidences getLegalPermanantResidences() {
        return this.legalPermanantResidences;
    }
    
    
    
    /**
     * 
     * @return NonimmigrantAdmissions
     */
    public NonimmigrantAdmissions getNonimmigrantAdmissions() {
        return this.nonimmigrantAdmissions;
    }
    
    
    
    /**
     * 
     * @return Enforcement
     */
    public Enforcement getEnforcement() {
        return this.enforcement;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Data.
	
	 * @return String
	 */
	public String toString() {
		return "Data[" +refugees+", "+naturalizationsBirth+", "+legalPermanantResidences+", "+nonimmigrantAdmissions+", "+enforcement+"]";
	}
	
	/**
	 * Internal constructor to create a Data from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Data(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Refugees
            this.refugees = new Refugees((JSONObject)json_data.get("Refugees"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field refugees was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field refugees had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Naturalizations (Birth)
            this.naturalizationsBirth = ((Number)json_data.get("Naturalizations (Birth)")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field naturalizationsBirth was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field naturalizationsBirth had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Legal permanant residences
            this.legalPermanantResidences = new LegalPermanantResidences((JSONObject)json_data.get("Legal permanant residences"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field legalPermanantResidences was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field legalPermanantResidences had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Nonimmigrant Admissions
            this.nonimmigrantAdmissions = new NonimmigrantAdmissions((JSONObject)json_data.get("Nonimmigrant Admissions"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field nonimmigrantAdmissions was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field nonimmigrantAdmissions had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Enforcement
            this.enforcement = new Enforcement((JSONObject)json_data.get("Enforcement"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field enforcement was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field enforcement had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}