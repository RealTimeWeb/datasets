package corgis.finance.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.finance.domain.Health;
import corgis.finance.domain.InsuranceTrust;
import corgis.finance.domain.Utilities;
import corgis.finance.domain.Employment;
import corgis.finance.domain.PublicWelfare;
import corgis.finance.domain.FinancialAid;
import corgis.finance.domain.Waste;
import corgis.finance.domain.Welfare;
import corgis.finance.domain.Intergovernmental;
import corgis.finance.domain.Correction;
import corgis.finance.domain.NaturalResources;
import corgis.finance.domain.Transportation;
import corgis.finance.domain.Education;

/**
 * 
 */
public class Details {
	
    private Health health;
    private InsuranceTrust insuranceTrust;
    private Utilities utilities;
    private Employment employment;
    private PublicWelfare publicWelfare;
    private FinancialAid financialAid;
    private Waste waste;
    private Welfare welfare;
    private Intergovernmental intergovernmental;
    private Correction correction;
    private NaturalResources naturalResources;
    private Transportation transportation;
    private Education education;
    
    
    /**
     * 
     * @return Health
     */
    public Health getHealth() {
        return this.health;
    }
    
    
    
    /**
     * 
     * @return InsuranceTrust
     */
    public InsuranceTrust getInsuranceTrust() {
        return this.insuranceTrust;
    }
    
    
    
    /**
     * 
     * @return Utilities
     */
    public Utilities getUtilities() {
        return this.utilities;
    }
    
    
    
    /**
     * 
     * @return Employment
     */
    public Employment getEmployment() {
        return this.employment;
    }
    
    
    
    /**
     * 
     * @return PublicWelfare
     */
    public PublicWelfare getPublicWelfare() {
        return this.publicWelfare;
    }
    
    
    
    /**
     * 
     * @return FinancialAid
     */
    public FinancialAid getFinancialAid() {
        return this.financialAid;
    }
    
    
    
    /**
     * 
     * @return Waste
     */
    public Waste getWaste() {
        return this.waste;
    }
    
    
    
    /**
     * 
     * @return Welfare
     */
    public Welfare getWelfare() {
        return this.welfare;
    }
    
    
    
    /**
     * 
     * @return Intergovernmental
     */
    public Intergovernmental getIntergovernmental() {
        return this.intergovernmental;
    }
    
    
    
    /**
     * 
     * @return Correction
     */
    public Correction getCorrection() {
        return this.correction;
    }
    
    
    
    /**
     * 
     * @return NaturalResources
     */
    public NaturalResources getNaturalResources() {
        return this.naturalResources;
    }
    
    
    
    /**
     * 
     * @return Transportation
     */
    public Transportation getTransportation() {
        return this.transportation;
    }
    
    
    
    /**
     * 
     * @return Education
     */
    public Education getEducation() {
        return this.education;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Details.
	
	 * @return String
	 */
	public String toString() {
		return "Details[" +health+", "+insuranceTrust+", "+utilities+", "+employment+", "+publicWelfare+", "+financialAid+", "+waste+", "+welfare+", "+intergovernmental+", "+correction+", "+naturalResources+", "+transportation+", "+education+"]";
	}
	
	/**
	 * Internal constructor to create a Details from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Details(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Health
            this.health = new Health((JSONObject)json_data.get("Health"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Details; the field health was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Details; the field health had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Insurance Trust
            this.insuranceTrust = new InsuranceTrust((JSONObject)json_data.get("Insurance Trust"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Details; the field insuranceTrust was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Details; the field insuranceTrust had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Utilities
            this.utilities = new Utilities((JSONObject)json_data.get("Utilities"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Details; the field utilities was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Details; the field utilities had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Employment
            this.employment = new Employment((JSONObject)json_data.get("Employment"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Details; the field employment was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Details; the field employment had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Public Welfare
            this.publicWelfare = new PublicWelfare((JSONObject)json_data.get("Public Welfare"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Details; the field publicWelfare was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Details; the field publicWelfare had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Financial Aid
            this.financialAid = new FinancialAid((JSONObject)json_data.get("Financial Aid"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Details; the field financialAid was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Details; the field financialAid had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Waste
            this.waste = new Waste((JSONObject)json_data.get("Waste"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Details; the field waste was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Details; the field waste had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Welfare
            this.welfare = new Welfare((JSONObject)json_data.get("Welfare"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Details; the field welfare was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Details; the field welfare had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Intergovernmental
            this.intergovernmental = new Intergovernmental((JSONObject)json_data.get("Intergovernmental"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Details; the field intergovernmental was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Details; the field intergovernmental had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Correction
            this.correction = new Correction((JSONObject)json_data.get("Correction"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Details; the field correction was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Details; the field correction had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Natural Resources
            this.naturalResources = new NaturalResources((JSONObject)json_data.get("Natural Resources"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Details; the field naturalResources was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Details; the field naturalResources had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Transportation
            this.transportation = new Transportation((JSONObject)json_data.get("Transportation"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Details; the field transportation was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Details; the field transportation had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Education
            this.education = new Education((JSONObject)json_data.get("Education"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Details; the field education was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Details; the field education had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}