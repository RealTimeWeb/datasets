package corgis.school_scores.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.school_scores.domain.BetweenSixzeroEightzerok;
import corgis.school_scores.domain.LessThanTwozerok;
import corgis.school_scores.domain.BetweenTwozeroFourzerok;
import corgis.school_scores.domain.BetweenFourzeroSixzerok;
import corgis.school_scores.domain.MoreThanOnezerozerok;
import corgis.school_scores.domain.BetweenEightzeroOnezerozerok;

/**
 * 
 */
public class FamilyIncome {
	
    private BetweenSixzeroEightzerok betweenSixzeroEightzerok;
    private LessThanTwozerok lessThanTwozerok;
    private BetweenTwozeroFourzerok betweenTwozeroFourzerok;
    private BetweenFourzeroSixzerok betweenFourzeroSixzerok;
    private MoreThanOnezerozerok moreThanOnezerozerok;
    private BetweenEightzeroOnezerozerok betweenEightzeroOnezerozerok;
    
    
    /**
     * 
     * @return BetweenSixzeroEightzerok
     */
    public BetweenSixzeroEightzerok getBetweenSixzeroEightzerok() {
        return this.betweenSixzeroEightzerok;
    }
    
    
    
    /**
     * 
     * @return LessThanTwozerok
     */
    public LessThanTwozerok getLessThanTwozerok() {
        return this.lessThanTwozerok;
    }
    
    
    
    /**
     * 
     * @return BetweenTwozeroFourzerok
     */
    public BetweenTwozeroFourzerok getBetweenTwozeroFourzerok() {
        return this.betweenTwozeroFourzerok;
    }
    
    
    
    /**
     * 
     * @return BetweenFourzeroSixzerok
     */
    public BetweenFourzeroSixzerok getBetweenFourzeroSixzerok() {
        return this.betweenFourzeroSixzerok;
    }
    
    
    
    /**
     * 
     * @return MoreThanOnezerozerok
     */
    public MoreThanOnezerozerok getMoreThanOnezerozerok() {
        return this.moreThanOnezerozerok;
    }
    
    
    
    /**
     * 
     * @return BetweenEightzeroOnezerozerok
     */
    public BetweenEightzeroOnezerozerok getBetweenEightzeroOnezerozerok() {
        return this.betweenEightzeroOnezerozerok;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this FamilyIncome.
	
	 * @return String
	 */
	public String toString() {
		return "FamilyIncome[" +betweenSixzeroEightzerok+", "+lessThanTwozerok+", "+betweenTwozeroFourzerok+", "+betweenFourzeroSixzerok+", "+moreThanOnezerozerok+", "+betweenEightzeroOnezerozerok+"]";
	}
	
	/**
	 * Internal constructor to create a FamilyIncome from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public FamilyIncome(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Between 60-80k
            this.betweenSixzeroEightzerok = new BetweenSixzeroEightzerok((JSONObject)json_data.get("Between 60-80k"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a FamilyIncome; the field betweenSixzeroEightzerok was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a FamilyIncome; the field betweenSixzeroEightzerok had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Less than 20k
            this.lessThanTwozerok = new LessThanTwozerok((JSONObject)json_data.get("Less than 20k"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a FamilyIncome; the field lessThanTwozerok was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a FamilyIncome; the field lessThanTwozerok had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Between 20-40k
            this.betweenTwozeroFourzerok = new BetweenTwozeroFourzerok((JSONObject)json_data.get("Between 20-40k"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a FamilyIncome; the field betweenTwozeroFourzerok was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a FamilyIncome; the field betweenTwozeroFourzerok had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Between 40-60k
            this.betweenFourzeroSixzerok = new BetweenFourzeroSixzerok((JSONObject)json_data.get("Between 40-60k"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a FamilyIncome; the field betweenFourzeroSixzerok was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a FamilyIncome; the field betweenFourzeroSixzerok had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // More than 100k
            this.moreThanOnezerozerok = new MoreThanOnezerozerok((JSONObject)json_data.get("More than 100k"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a FamilyIncome; the field moreThanOnezerozerok was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a FamilyIncome; the field moreThanOnezerozerok had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Between 80-100k
            this.betweenEightzeroOnezerozerok = new BetweenEightzeroOnezerozerok((JSONObject)json_data.get("Between 80-100k"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a FamilyIncome; the field betweenEightzeroOnezerozerok was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a FamilyIncome; the field betweenEightzeroOnezerozerok had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}