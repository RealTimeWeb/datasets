package corgis.school_scores.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.school_scores.domain.BetweenFourzerozeroToFivezerozero;
import corgis.school_scores.domain.BetweenTwozerozeroToThreezerozero;
import corgis.school_scores.domain.BetweenSevenzerozeroToEightzerozero;
import corgis.school_scores.domain.BetweenSixzerozeroToSevenzerozero;
import corgis.school_scores.domain.BetweenFivezerozeroToSixzerozero;
import corgis.school_scores.domain.BetweenThreezerozeroToFourzerozero;

/**
 * 
 */
public class ScoreRanges {
	
    private BetweenFourzerozeroToFivezerozero betweenFourzerozeroToFivezerozero;
    private BetweenTwozerozeroToThreezerozero betweenTwozerozeroToThreezerozero;
    private BetweenSevenzerozeroToEightzerozero betweenSevenzerozeroToEightzerozero;
    private BetweenSixzerozeroToSevenzerozero betweenSixzerozeroToSevenzerozero;
    private BetweenFivezerozeroToSixzerozero betweenFivezerozeroToSixzerozero;
    private BetweenThreezerozeroToFourzerozero betweenThreezerozeroToFourzerozero;
    
    
    /*
     * @return 
     */
    public BetweenFourzerozeroToFivezerozero getBetweenFourzerozeroToFivezerozero() {
        return this.betweenFourzerozeroToFivezerozero;
    }
    
    
    
    /*
     * @return 
     */
    public BetweenTwozerozeroToThreezerozero getBetweenTwozerozeroToThreezerozero() {
        return this.betweenTwozerozeroToThreezerozero;
    }
    
    
    
    /*
     * @return 
     */
    public BetweenSevenzerozeroToEightzerozero getBetweenSevenzerozeroToEightzerozero() {
        return this.betweenSevenzerozeroToEightzerozero;
    }
    
    
    
    /*
     * @return 
     */
    public BetweenSixzerozeroToSevenzerozero getBetweenSixzerozeroToSevenzerozero() {
        return this.betweenSixzerozeroToSevenzerozero;
    }
    
    
    
    /*
     * @return 
     */
    public BetweenFivezerozeroToSixzerozero getBetweenFivezerozeroToSixzerozero() {
        return this.betweenFivezerozeroToSixzerozero;
    }
    
    
    
    /*
     * @return 
     */
    public BetweenThreezerozeroToFourzerozero getBetweenThreezerozeroToFourzerozero() {
        return this.betweenThreezerozeroToFourzerozero;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this ScoreRanges.
	
	 * @return String
	 */
	public String toString() {
		return "ScoreRanges[" +betweenFourzerozeroToFivezerozero+", "+betweenTwozerozeroToThreezerozero+", "+betweenSevenzerozeroToEightzerozero+", "+betweenSixzerozeroToSevenzerozero+", "+betweenFivezerozeroToSixzerozero+", "+betweenThreezerozeroToFourzerozero+"]";
	}
	
	/**
	 * Internal constructor to create a ScoreRanges from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public ScoreRanges(JSONObject json_data) {
        try {// Between 400 to 500
            this.betweenFourzerozeroToFivezerozero = new BetweenFourzerozeroToFivezerozero((JSONObject)json_data.get("Between 400 to 500"));// Between 200 to 300
            this.betweenTwozerozeroToThreezerozero = new BetweenTwozerozeroToThreezerozero((JSONObject)json_data.get("Between 200 to 300"));// Between 700 to 800
            this.betweenSevenzerozeroToEightzerozero = new BetweenSevenzerozeroToEightzerozero((JSONObject)json_data.get("Between 700 to 800"));// Between 600 to 700
            this.betweenSixzerozeroToSevenzerozero = new BetweenSixzerozeroToSevenzerozero((JSONObject)json_data.get("Between 600 to 700"));// Between 500 to 600
            this.betweenFivezerozeroToSixzerozero = new BetweenFivezerozeroToSixzerozero((JSONObject)json_data.get("Between 500 to 600"));// Between 300 to 400
            this.betweenThreezerozeroToFourzerozero = new BetweenThreezerozeroToFourzerozero((JSONObject)json_data.get("Between 300 to 400"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a ScoreRanges; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a ScoreRanges; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}