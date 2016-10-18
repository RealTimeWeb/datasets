package corgis.drug_bank.domain;

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
    private Integer logp;
    private Integer cacotwoPermeability;
    private String logs;
    private Integer pka;
    private Integer boilingPoint;
    private Double hydrophobicity;
    private String molecularFormula;
    private Double molecularWeight;
    private Double meltingPoint;
    
    
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
    public Integer getLogp() {
        return this.logp;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getCacotwoPermeability() {
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
    public Integer getPka() {
        return this.pka;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getBoilingPoint() {
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
    public Double getMolecularWeight() {
        return this.molecularWeight;
    }
    
    
    
    /*
     * @return 
     */
    public Double getMeltingPoint() {
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
            this.isoelectricPoint = ((Number)json_data.get("isoelectric point")).doubleValue();// logp
            this.logp = ((Number)json_data.get("logp")).intValue();// caco2 permeability
            this.cacotwoPermeability = ((Number)json_data.get("caco2 permeability")).intValue();// logs
            this.logs = (String)json_data.get("logs");// pka
            this.pka = ((Number)json_data.get("pka")).intValue();// boiling point
            this.boilingPoint = ((Number)json_data.get("boiling point")).intValue();// hydrophobicity
            this.hydrophobicity = ((Number)json_data.get("hydrophobicity")).doubleValue();// molecular formula
            this.molecularFormula = (String)json_data.get("molecular formula");// molecular weight
            this.molecularWeight = ((Number)json_data.get("molecular weight")).doubleValue();// melting point
            this.meltingPoint = ((Number)json_data.get("melting point")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Properties; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Properties; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}