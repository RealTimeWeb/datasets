package corgis.finance.domain;

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
public class FishAndGame {
	
    // Total amount spent on conservation, promotion, and development of fish and game.
    private Integer fishAndGameTotalExpenditure;
    // Money paid to other governments for the conservation, promotion, and development of fish and game.
    private Integer fishAndGameIntergovernmental;
    
    
    /**
     * Total amount spent on conservation, promotion, and development of fish and game.
     * @return Integer
     */
    public Integer getFishAndGameTotalExpenditure() {
        return this.fishAndGameTotalExpenditure;
    }
    
    
    
    /**
     * Money paid to other governments for the conservation, promotion, and development of fish and game.
     * @return Integer
     */
    public Integer getFishAndGameIntergovernmental() {
        return this.fishAndGameIntergovernmental;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this FishAndGame.
	
	 * @return String
	 */
	public String toString() {
		return "FishAndGame[" +fishAndGameTotalExpenditure+", "+fishAndGameIntergovernmental+"]";
	}
	
	/**
	 * Internal constructor to create a FishAndGame from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public FishAndGame(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Fish and Game Total Expenditure
            this.fishAndGameTotalExpenditure = ((Number)json_data.get("Fish and Game Total Expenditure")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a FishAndGame; the field fishAndGameTotalExpenditure was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a FishAndGame; the field fishAndGameTotalExpenditure had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Fish and Game Intergovernmental
            this.fishAndGameIntergovernmental = ((Number)json_data.get("Fish and Game Intergovernmental")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a FishAndGame; the field fishAndGameIntergovernmental was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a FishAndGame; the field fishAndGameIntergovernmental had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}