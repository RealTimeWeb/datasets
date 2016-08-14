package corgis.drugbank.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


/**
 * 
 */
public class Properties {
	
    private String waterSolubility;
    private Double isoelectricPoint;
    private String logp;
    private String cacotwoPermeability;
    private String logs;
    private String pka;
    private String boilingPoint;
    private Double hydrophobicity;
    private String molecularFormula;
    private String molecularWeight;
    private String meltingPoint;
    
    
    /*
     * @return 
     */
    public String getWaterSolubility() {
        return this.waterSolubility;
    }
    
    
    
    /*
     * @return 
     */
    public Double getIsoelectricPoint() {
        return this.isoelectricPoint;
    }
    
    
    
    /*
     * @return 
     */
    public String getLogp() {
        return this.logp;
    }
    
    
    
    /*
     * @return 
     */
    public String getCacotwoPermeability() {
        return this.cacotwoPermeability;
    }
    
    
    
    /*
     * @return 
     */
    public String getLogs() {
        return this.logs;
    }
    
    
    
    /*
     * @return 
     */
    public String getPka() {
        return this.pka;
    }
    
    
    
    /*
     * @return 
     */
    public String getBoilingPoint() {
        return this.boilingPoint;
    }
    
    
    
    /*
     * @return 
     */
    public Double getHydrophobicity() {
        return this.hydrophobicity;
    }
    
    
    
    /*
     * @return 
     */
    public String getMolecularFormula() {
        return this.molecularFormula;
    }
    
    
    
    /*
     * @return 
     */
    public String getMolecularWeight() {
        return this.molecularWeight;
    }
    
    
    
    /*
     * @return 
     */
    public String getMeltingPoint() {
        return this.meltingPoint;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Properties.
	
	 * @return String
	 */
	public String toString() {
		return "Properties[" +waterSolubility+", "+isoelectricPoint+", "+logp+", "+cacotwoPermeability+", "+logs+", "+pka+", "+boilingPoint+", "+hydrophobicity+", "+molecularFormula+", "+molecularWeight+", "+meltingPoint+"]";
	}
	
	/**
	 * Internal constructor to create a Properties from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Properties(JSONObject json_data) {
        try {// water solubility
            this.waterSolubility = (String)json_data.get("water solubility");// isoelectric point
            this.isoelectricPoint = (Double)json_data.get("isoelectric point");// logp
            this.logp = (String)json_data.get("logp");// caco2 permeability
            this.cacotwoPermeability = (String)json_data.get("caco2 permeability");// logs
            this.logs = (String)json_data.get("logs");// pka
            this.pka = (String)json_data.get("pka");// boiling point
            this.boilingPoint = (String)json_data.get("boiling point");// hydrophobicity
            this.hydrophobicity = (Double)json_data.get("hydrophobicity");// molecular formula
            this.molecularFormula = (String)json_data.get("molecular formula");// molecular weight
            this.molecularWeight = (String)json_data.get("molecular weight");// melting point
            this.meltingPoint = (String)json_data.get("melting point");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Properties; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Properties; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}