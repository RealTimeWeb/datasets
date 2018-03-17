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
	
    // The total sales made on this game, measured in millions of dollars.
    private Double sales;
    // A typical "used" price for this game (i.e. previously returned and sold), measured in dollars. It is unclear where this number originally came from.
    private Double usedPrice;
    // a typical review score for this game, out of 100.
    private Integer reviewScore;
    
    
    /**
     * The total sales made on this game, measured in millions of dollars.
     * @return Double
     */
    public Double getSales() {
        return this.sales;
    }
    
    
    
    /**
     * A typical "used" price for this game (i.e. previously returned and sold), measured in dollars. It is unclear where this number originally came from.
     * @return Double
     */
    public Double getUsedPrice() {
        return this.usedPrice;
    }
    
    
    
    /**
     * a typical review score for this game, out of 100.
     * @return Integer
     */
    public Integer getReviewScore() {
        return this.reviewScore;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Metrics.
	
	 * @return String
	 */
	public String toString() {
		return "Metrics[" +sales+", "+usedPrice+", "+reviewScore+"]";
	}
	
	/**
	 * Internal constructor to create a Metrics from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Metrics(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Sales
            this.sales = ((Number)json_data.get("Sales")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Metrics; the field sales was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Metrics; the field sales had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Used Price
            this.usedPrice = ((Number)json_data.get("Used Price")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Metrics; the field usedPrice was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Metrics; the field usedPrice had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Review Score
            this.reviewScore = ((Number)json_data.get("Review Score")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Metrics; the field reviewScore was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Metrics; the field reviewScore had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}