package corgis.classics.domain;

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
public class Difficulty {
	
    // This is a comment that I've incorporated into the explorer.
    private Double fleschReadingEase;
    private Double automatedReadabilityIndex;
    private Double colemanLiauIndex;
    private Double fleschKincaidGrade;
    private Double linsearWriteFormula;
    private Double daleChallReadabilityScore;
    private Double gunningFog;
    private Double smogIndex;
    private Integer difficultWords;
    
    
    /*
     * @return 
     */
    public Double getFleschReadingEase() {
        return this.fleschReadingEase;
    }
    
    
    
    /*
     * @return 
     */
    public Double getAutomatedReadabilityIndex() {
        return this.automatedReadabilityIndex;
    }
    
    
    
    /*
     * @return 
     */
    public Double getColemanLiauIndex() {
        return this.colemanLiauIndex;
    }
    
    
    
    /*
     * @return 
     */
    public Double getFleschKincaidGrade() {
        return this.fleschKincaidGrade;
    }
    
    
    
    /*
     * @return 
     */
    public Double getLinsearWriteFormula() {
        return this.linsearWriteFormula;
    }
    
    
    
    /*
     * @return 
     */
    public Double getDaleChallReadabilityScore() {
        return this.daleChallReadabilityScore;
    }
    
    
    
    /*
     * @return 
     */
    public Double getGunningFog() {
        return this.gunningFog;
    }
    
    
    
    /*
     * @return 
     */
    public Double getSmogIndex() {
        return this.smogIndex;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getDifficultWords() {
        return this.difficultWords;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Difficulty.
	
	 * @return String
	 */
	public String toString() {
		return "Difficulty[" +fleschReadingEase+", "+automatedReadabilityIndex+", "+colemanLiauIndex+", "+fleschKincaidGrade+", "+linsearWriteFormula+", "+daleChallReadabilityScore+", "+gunningFog+", "+smogIndex+", "+difficultWords+"]";
	}
	
	/**
	 * Internal constructor to create a Difficulty from a  representation.
	 * @param map The raw json data that will be parsed.
	 * @return 
	 */
    public Difficulty(JSONObject json_data) {
        try {
            this.fleschReadingEase = (Double)json_data.get("flesch reading ease");
            this.automatedReadabilityIndex = (Double)json_data.get("automated readability index");
            this.colemanLiauIndex = (Double)json_data.get("coleman liau index");
            this.fleschKincaidGrade = (Double)json_data.get("flesch kincaid grade");
            this.linsearWriteFormula = (Double)json_data.get("linsear write formula");
            this.daleChallReadabilityScore = (Double)json_data.get("dale chall readability score");
            this.gunningFog = (Double)json_data.get("gunning fog");
            this.smogIndex = (Double)json_data.get("smog index");
            this.difficultWords = (Integer)json_data.get("difficult words");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Difficulty; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Difficulty; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}