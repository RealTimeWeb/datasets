package corgis.classics.domain;

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
public class Difficulty {
	
    private Double fleschReadingEase;
    private Double automatedReadabilityIndex;
    private Double colemanLiauIndex;
    private Double fleschKincaidGrade;
    private Double linearWriteFormula;
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
    public Double getLinearWriteFormula() {
        return this.linearWriteFormula;
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
		return "Difficulty[" +fleschReadingEase+", "+automatedReadabilityIndex+", "+colemanLiauIndex+", "+fleschKincaidGrade+", "+linearWriteFormula+", "+daleChallReadabilityScore+", "+gunningFog+", "+smogIndex+", "+difficultWords+"]";
	}
	
	/**
	 * Internal constructor to create a Difficulty from a  representation.
	 * @param map The raw json data that will be parsed.
	 * @return 
	 */
    public Difficulty(JSONObject json_data) {
        try {// Flesch Reading Ease
            this.fleschReadingEase = (Double)json_data.get("Flesch Reading Ease");// Automated Readability Index
            this.automatedReadabilityIndex = (Double)json_data.get("Automated Readability Index");// Coleman Liau Index
            this.colemanLiauIndex = (Double)json_data.get("Coleman Liau Index");// Flesch Kincaid Grade
            this.fleschKincaidGrade = (Double)json_data.get("Flesch Kincaid Grade");// Linear Write Formula
            this.linearWriteFormula = (Double)json_data.get("Linear Write Formula");// Dale Chall Readability Score
            this.daleChallReadabilityScore = (Double)json_data.get("Dale Chall Readability Score");// Gunning Fog
            this.gunningFog = (Double)json_data.get("Gunning Fog");// Smog Index
            this.smogIndex = (Double)json_data.get("Smog Index");// Difficult Words
            this.difficultWords = new Integer(((Long)json_data.get("Difficult Words")).intValue());
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Difficulty; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Difficulty; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}