package corgis.video_games.domain;

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
public class Metrics {
	
    // A typical "used" price for this game (i.e. previously returned and sold), measured in dollars. It is unclear where this number originally came from.
    private Double usedPrice;
    // The total sales made on this game, measured in millions of dollars.
    private Double sales;
    // a typical review score for this game, out of 100.
    private Integer reviewScore;
    
    
    /*
     * @return 
     */
    public Double getUsedPrice() {
        return this.usedPrice;
    }
    
    
    
    /*
     * @return 
     */
    public Double getSales() {
        return this.sales;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getReviewScore() {
        return this.reviewScore;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Metrics.
	
	 * @return String
	 */
	public String toString() {
		return "Metrics[" +usedPrice+", "+sales+", "+reviewScore+"]";
	}
	
	/**
	 * Internal constructor to create a Metrics from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Metrics(JSONObject json_data) {
        try {// Used Price
            this.usedPrice = ((Number)json_data.get("Used Price")).doubleValue();// Sales
            this.sales = ((Number)json_data.get("Sales")).doubleValue();// Review Score
            this.reviewScore = ((Number)json_data.get("Review Score")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Metrics; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Metrics; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}