package corgis.food.domain;

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
public class Vitamins {
	
    private Integer vitaminAIu;
    private Double vitaminC;
    private Double vitaminBonetwo;
    private Double vitaminBsix;
    private Integer vitaminARae;
    private Double vitaminE;
    private Double vitaminK;
    
    
    /*
     * @return 
     */
    public Integer getVitaminAIu() {
        return this.vitaminAIu;
    }
    
    
    
    /*
     * @return 
     */
    public Double getVitaminC() {
        return this.vitaminC;
    }
    
    
    
    /*
     * @return 
     */
    public Double getVitaminBonetwo() {
        return this.vitaminBonetwo;
    }
    
    
    
    /*
     * @return 
     */
    public Double getVitaminBsix() {
        return this.vitaminBsix;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getVitaminARae() {
        return this.vitaminARae;
    }
    
    
    
    /*
     * @return 
     */
    public Double getVitaminE() {
        return this.vitaminE;
    }
    
    
    
    /*
     * @return 
     */
    public Double getVitaminK() {
        return this.vitaminK;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Vitamins.
	
	 * @return String
	 */
	public String toString() {
		return "Vitamins[" +vitaminAIu+", "+vitaminC+", "+vitaminBonetwo+", "+vitaminBsix+", "+vitaminARae+", "+vitaminE+", "+vitaminK+"]";
	}
	
	/**
	 * Internal constructor to create a Vitamins from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Vitamins(JSONObject json_data) {
        try {// Vitamin A - IU
            this.vitaminAIu = new Integer(((Long)json_data.get("Vitamin A - IU")).intValue());// Vitamin C
            this.vitaminC = (Double)json_data.get("Vitamin C");// Vitamin B12
            this.vitaminBonetwo = (Double)json_data.get("Vitamin B12");// Vitamin B6
            this.vitaminBsix = (Double)json_data.get("Vitamin B6");// Vitamin A - RAE
            this.vitaminARae = new Integer(((Long)json_data.get("Vitamin A - RAE")).intValue());// Vitamin E
            this.vitaminE = (Double)json_data.get("Vitamin E");// Vitamin K
            this.vitaminK = (Double)json_data.get("Vitamin K");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Vitamins; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Vitamins; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}