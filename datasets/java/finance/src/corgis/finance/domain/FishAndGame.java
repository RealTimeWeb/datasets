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
	
    // Money paid to other governments for the conservation, promotion, and development of fish and game.
    private Integer fishAndGameIntergovernmental;
    // Total amount spent on conservation, promotion, and development of fish and game.
    private Integer fishAndGameTotalExpenditure;
    
    
    /*
     * @return 
     */
    public Integer getFishAndGameIntergovernmental() {
        return this.fishAndGameIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getFishAndGameTotalExpenditure() {
        return this.fishAndGameTotalExpenditure;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this FishAndGame.
	
	 * @return String
	 */
	public String toString() {
		return "FishAndGame[" +fishAndGameIntergovernmental+", "+fishAndGameTotalExpenditure+"]";
	}
	
	/**
	 * Internal constructor to create a FishAndGame from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public FishAndGame(JSONObject json_data) {
        try {// Fish and Game Intergovernmental
            this.fishAndGameIntergovernmental = ((Number)json_data.get("Fish and Game Intergovernmental")).intValue();// Fish and Game Total Expenditure
            this.fishAndGameTotalExpenditure = ((Number)json_data.get("Fish and Game Total Expenditure")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a FishAndGame; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a FishAndGame; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}