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
public class Fat {
	
    // A saturated fat is a type of fat in which the fatty acids all have single bonds. Measured in grams (g).
    private Double saturatedFat;
    // Fatty acids that have one double bond in the fatty acid chain with all of the remainder carbon atoms being single-bonded. Measured in grams (g).
    private Double monosaturatedFat;
    // Lipids comprise a group of naturally occurring molecules that include fats, waxes, sterols, fat-soluble vitamins (such as vitamins A, D, E, and K), monoglycerides, diglycerides, triglycerides, phospholipids, and others. The main biological functions of lipids include storing energy, signaling, and acting as structural components of cell membranes. Measured in grams (g).
    private Double totalLipid;
    // Lipids in which the constituent hydrocarbon chain possesses two or more carbon-carbon double bonds. Polyunsaturated fat can be found mostly in nuts, seeds, fish, algae, leafy greens, and krill. "Unsaturated" refers to the fact that the molecules contain less than the maximum amount of hydrogen (if there were no double bonds). Measured in grams (g).
    private Double polysaturatedFat;
    
    
    /*
     * @return 
     */
    public Double getSaturatedFat() {
        return this.saturatedFat;
    }
    
    
    
    /*
     * @return 
     */
    public Double getMonosaturatedFat() {
        return this.monosaturatedFat;
    }
    
    
    
    /*
     * @return 
     */
    public Double getTotalLipid() {
        return this.totalLipid;
    }
    
    
    
    /*
     * @return 
     */
    public Double getPolysaturatedFat() {
        return this.polysaturatedFat;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Fat.
	
	 * @return String
	 */
	public String toString() {
		return "Fat[" +saturatedFat+", "+monosaturatedFat+", "+totalLipid+", "+polysaturatedFat+"]";
	}
	
	/**
	 * Internal constructor to create a Fat from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Fat(JSONObject json_data) {
        try {// Saturated Fat
            this.saturatedFat = ((Number)json_data.get("Saturated Fat")).doubleValue();// Monosaturated Fat
            this.monosaturatedFat = ((Number)json_data.get("Monosaturated Fat")).doubleValue();// Total Lipid
            this.totalLipid = ((Number)json_data.get("Total Lipid")).doubleValue();// Polysaturated Fat
            this.polysaturatedFat = ((Number)json_data.get("Polysaturated Fat")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Fat; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Fat; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}