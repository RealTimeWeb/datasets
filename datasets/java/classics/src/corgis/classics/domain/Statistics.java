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
public class Statistics {
	
    // The number of words that have 3 or more syllables.
    private Integer polysyllables;
    // Characters are letters and symbols in a text, not the number of people.
    private Integer characters;
    private Double averageSentenceLength;
    private Integer words;
    private Integer sentences;
    private Double syllables;
    private Double averageSentencePerWord;
    private Double averageLetterPerWord;
    
    
    /*
     * @return 
     */
    public Integer getPolysyllables() {
        return this.polysyllables;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getCharacters() {
        return this.characters;
    }
    
    
    
    /*
     * @return 
     */
    public Double getAverageSentenceLength() {
        return this.averageSentenceLength;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getWords() {
        return this.words;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getSentences() {
        return this.sentences;
    }
    
    
    
    /*
     * @return 
     */
    public Double getSyllables() {
        return this.syllables;
    }
    
    
    
    /*
     * @return 
     */
    public Double getAverageSentencePerWord() {
        return this.averageSentencePerWord;
    }
    
    
    
    /*
     * @return 
     */
    public Double getAverageLetterPerWord() {
        return this.averageLetterPerWord;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Statistics.
	
	 * @return String
	 */
	public String toString() {
		return "Statistics[" +polysyllables+", "+characters+", "+averageSentenceLength+", "+words+", "+sentences+", "+syllables+", "+averageSentencePerWord+", "+averageLetterPerWord+"]";
	}
	
	/**
	 * Internal constructor to create a Statistics from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Statistics(JSONObject json_data) {
        try {// polysyllables
            this.polysyllables = ((Number)json_data.get("polysyllables")).intValue();// characters
            this.characters = ((Number)json_data.get("characters")).intValue();// average sentence length
            this.averageSentenceLength = ((Number)json_data.get("average sentence length")).doubleValue();// words
            this.words = ((Number)json_data.get("words")).intValue();// sentences
            this.sentences = ((Number)json_data.get("sentences")).intValue();// syllables
            this.syllables = ((Number)json_data.get("syllables")).doubleValue();// average sentence per word
            this.averageSentencePerWord = ((Number)json_data.get("average sentence per word")).doubleValue();// average letter per word
            this.averageLetterPerWord = ((Number)json_data.get("average letter per word")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Statistics; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Statistics; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}