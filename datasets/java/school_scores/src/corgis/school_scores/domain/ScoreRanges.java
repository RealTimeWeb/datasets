package corgis.school_scores.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.school_scores.domain.BetweenFivezerozeroToSixzerozero;
import corgis.school_scores.domain.BetweenFourzerozeroToFivezerozero;
import corgis.school_scores.domain.BetweenThreezerozeroToFourzerozero;
import corgis.school_scores.domain.BetweenSevenzerozeroToEightzerozero;
import corgis.school_scores.domain.BetweenSixzerozeroToSevenzerozero;
import corgis.school_scores.domain.BetweenTwozerozeroToThreezerozero;

/**
 * 
 */
public class ScoreRanges {
	
    private BetweenFivezerozeroToSixzerozero betweenFivezerozeroToSixzerozero;
    private BetweenFourzerozeroToFivezerozero betweenFourzerozeroToFivezerozero;
    private BetweenThreezerozeroToFourzerozero betweenThreezerozeroToFourzerozero;
    private BetweenSevenzerozeroToEightzerozero betweenSevenzerozeroToEightzerozero;
    private BetweenSixzerozeroToSevenzerozero betweenSixzerozeroToSevenzerozero;
    private BetweenTwozerozeroToThreezerozero betweenTwozerozeroToThreezerozero;
    
    
    /**
     * 
     * @return BetweenFivezerozeroToSixzerozero
     */
    public BetweenFivezerozeroToSixzerozero getBetweenFivezerozeroToSixzerozero() {
        return this.betweenFivezerozeroToSixzerozero;
    }
    
    
    
    /**
     * 
     * @return BetweenFourzerozeroToFivezerozero
     */
    public BetweenFourzerozeroToFivezerozero getBetweenFourzerozeroToFivezerozero() {
        return this.betweenFourzerozeroToFivezerozero;
    }
    
    
    
    /**
     * 
     * @return BetweenThreezerozeroToFourzerozero
     */
    public BetweenThreezerozeroToFourzerozero getBetweenThreezerozeroToFourzerozero() {
        return this.betweenThreezerozeroToFourzerozero;
    }
    
    
    
    /**
     * 
     * @return BetweenSevenzerozeroToEightzerozero
     */
    public BetweenSevenzerozeroToEightzerozero getBetweenSevenzerozeroToEightzerozero() {
        return this.betweenSevenzerozeroToEightzerozero;
    }
    
    
    
    /**
     * 
     * @return BetweenSixzerozeroToSevenzerozero
     */
    public BetweenSixzerozeroToSevenzerozero getBetweenSixzerozeroToSevenzerozero() {
        return this.betweenSixzerozeroToSevenzerozero;
    }
    
    
    
    /**
     * 
     * @return BetweenTwozerozeroToThreezerozero
     */
    public BetweenTwozerozeroToThreezerozero getBetweenTwozerozeroToThreezerozero() {
        return this.betweenTwozerozeroToThreezerozero;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this ScoreRanges.
	
	 * @return String
	 */
	public String toString() {
		return "ScoreRanges[" +betweenFivezerozeroToSixzerozero+", "+betweenFourzerozeroToFivezerozero+", "+betweenThreezerozeroToFourzerozero+", "+betweenSevenzerozeroToEightzerozero+", "+betweenSixzerozeroToSevenzerozero+", "+betweenTwozerozeroToThreezerozero+"]";
	}
	
	/**
	 * Internal constructor to create a ScoreRanges from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public ScoreRanges(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Between 500 to 600
            this.betweenFivezerozeroToSixzerozero = new BetweenFivezerozeroToSixzerozero((JSONObject)json_data.get("Between 500 to 600"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a ScoreRanges; the field betweenFivezerozeroToSixzerozero was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a ScoreRanges; the field betweenFivezerozeroToSixzerozero had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Between 400 to 500
            this.betweenFourzerozeroToFivezerozero = new BetweenFourzerozeroToFivezerozero((JSONObject)json_data.get("Between 400 to 500"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a ScoreRanges; the field betweenFourzerozeroToFivezerozero was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a ScoreRanges; the field betweenFourzerozeroToFivezerozero had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Between 300 to 400
            this.betweenThreezerozeroToFourzerozero = new BetweenThreezerozeroToFourzerozero((JSONObject)json_data.get("Between 300 to 400"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a ScoreRanges; the field betweenThreezerozeroToFourzerozero was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a ScoreRanges; the field betweenThreezerozeroToFourzerozero had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Between 700 to 800
            this.betweenSevenzerozeroToEightzerozero = new BetweenSevenzerozeroToEightzerozero((JSONObject)json_data.get("Between 700 to 800"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a ScoreRanges; the field betweenSevenzerozeroToEightzerozero was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a ScoreRanges; the field betweenSevenzerozeroToEightzerozero had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Between 600 to 700
            this.betweenSixzerozeroToSevenzerozero = new BetweenSixzerozeroToSevenzerozero((JSONObject)json_data.get("Between 600 to 700"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a ScoreRanges; the field betweenSixzerozeroToSevenzerozero was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a ScoreRanges; the field betweenSixzerozeroToSevenzerozero had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Between 200 to 300
            this.betweenTwozerozeroToThreezerozero = new BetweenTwozerozeroToThreezerozero((JSONObject)json_data.get("Between 200 to 300"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a ScoreRanges; the field betweenTwozerozeroToThreezerozero was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a ScoreRanges; the field betweenTwozerozeroToThreezerozero had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}