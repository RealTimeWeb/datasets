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
            this.polysyllables = new Integer(((Long)json_data.get("polysyllables")).intValue());// characters
            this.characters = new Integer(((Long)json_data.get("characters")).intValue());// average sentence length
            this.averageSentenceLength = (Double)json_data.get("average sentence length");// words
            this.words = new Integer(((Long)json_data.get("words")).intValue());// sentences
            this.sentences = new Integer(((Long)json_data.get("sentences")).intValue());// syllables
            this.syllables = (Double)json_data.get("syllables");// average sentence per word
            this.averageSentencePerWord = (Double)json_data.get("average sentence per word");// average letter per word
            this.averageLetterPerWord = (Double)json_data.get("average letter per word");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Statistics; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Statistics; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}