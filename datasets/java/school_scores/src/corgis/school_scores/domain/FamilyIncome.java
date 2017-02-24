package corgis.school_scores.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.school_scores.domain.BetweenFourzeroSixzerok;
import corgis.school_scores.domain.MoreThanOnezerozerok;
import corgis.school_scores.domain.LessThanTwozerok;
import corgis.school_scores.domain.BetweenSixzeroEightzerok;
import corgis.school_scores.domain.BetweenTwozeroFourzerok;
import corgis.school_scores.domain.BetweenEightzeroOnezerozerok;

/**
 * 
 */
public class FamilyIncome {
	
    private BetweenFourzeroSixzerok betweenFourzeroSixzerok;
    private MoreThanOnezerozerok moreThanOnezerozerok;
    private LessThanTwozerok lessThanTwozerok;
    private BetweenSixzeroEightzerok betweenSixzeroEightzerok;
    private BetweenTwozeroFourzerok betweenTwozeroFourzerok;
    private BetweenEightzeroOnezerozerok betweenEightzeroOnezerozerok;
    
    
    /*
     * @return 
     */
    public BetweenFourzeroSixzerok getBetweenFourzeroSixzerok() {
        return this.betweenFourzeroSixzerok;
    }
    
    
    
    /*
     * @return 
     */
    public MoreThanOnezerozerok getMoreThanOnezerozerok() {
        return this.moreThanOnezerozerok;
    }
    
    
    
    /*
     * @return 
     */
    public LessThanTwozerok getLessThanTwozerok() {
        return this.lessThanTwozerok;
    }
    
    
    
    /*
     * @return 
     */
    public BetweenSixzeroEightzerok getBetweenSixzeroEightzerok() {
        return this.betweenSixzeroEightzerok;
    }
    
    
    
    /*
     * @return 
     */
    public BetweenTwozeroFourzerok getBetweenTwozeroFourzerok() {
        return this.betweenTwozeroFourzerok;
    }
    
    
    
    /*
     * @return 
     */
    public BetweenEightzeroOnezerozerok getBetweenEightzeroOnezerozerok() {
        return this.betweenEightzeroOnezerozerok;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this FamilyIncome.
	
	 * @return String
	 */
	public String toString() {
		return "FamilyIncome[" +betweenFourzeroSixzerok+", "+moreThanOnezerozerok+", "+lessThanTwozerok+", "+betweenSixzeroEightzerok+", "+betweenTwozeroFourzerok+", "+betweenEightzeroOnezerozerok+"]";
	}
	
	/**
	 * Internal constructor to create a FamilyIncome from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public FamilyIncome(JSONObject json_data) {
        try {// Between 40-60k
            this.betweenFourzeroSixzerok = new BetweenFourzeroSixzerok((JSONObject)json_data.get("Between 40-60k"));// More than 100k
            this.moreThanOnezerozerok = new MoreThanOnezerozerok((JSONObject)json_data.get("More than 100k"));// Less than 20k
            this.lessThanTwozerok = new LessThanTwozerok((JSONObject)json_data.get("Less than 20k"));// Between 60-80k
            this.betweenSixzeroEightzerok = new BetweenSixzeroEightzerok((JSONObject)json_data.get("Between 60-80k"));// Between 20-40k
            this.betweenTwozeroFourzerok = new BetweenTwozeroFourzerok((JSONObject)json_data.get("Between 20-40k"));// Between 80-100k
            this.betweenEightzeroOnezerozerok = new BetweenEightzeroOnezerozerok((JSONObject)json_data.get("Between 80-100k"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a FamilyIncome; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a FamilyIncome; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}