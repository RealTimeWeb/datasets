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
public class Sentiments {
	
    // Sentiment analysis attempts to determine the attitude of a speaker or a writer with respect to some topic or the overall contextual polarity of a document. Polarity in particular refers to how positive or negative the author is towards the content.
    private Double polarity;
    // Sentiment analysis attempts to determine the attitude of a speaker or a writer with respect to some topic or the overall contextual polarity of a document. Subjectivity (as opposed to Objectivity) in particular refers to whether the text is opinionated or attempts to stay factual.
    private Double subjectivity;
    
    
    /**
     * Sentiment analysis attempts to determine the attitude of a speaker or a writer with respect to some topic or the overall contextual polarity of a document. Polarity in particular refers to how positive or negative the author is towards the content.
     * @return Double
     */
    public Double getPolarity() {
        return this.polarity;
    }
    
    
    
    /**
     * Sentiment analysis attempts to determine the attitude of a speaker or a writer with respect to some topic or the overall contextual polarity of a document. Subjectivity (as opposed to Objectivity) in particular refers to whether the text is opinionated or attempts to stay factual.
     * @return Double
     */
    public Double getSubjectivity() {
        return this.subjectivity;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Sentiments.
	
	 * @return String
	 */
	public String toString() {
		return "Sentiments[" +polarity+", "+subjectivity+"]";
	}
	
	/**
	 * Internal constructor to create a Sentiments from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Sentiments(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // polarity
            this.polarity = ((Number)json_data.get("polarity")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Sentiments; the field polarity was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Sentiments; the field polarity had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // subjectivity
            this.subjectivity = ((Number)json_data.get("subjectivity")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Sentiments; the field subjectivity was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Sentiments; the field subjectivity had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}