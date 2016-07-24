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
	
    private Integer polysyllables;
    private Double averageLetterPerWord;
    private Double averageSentenceLength;
    private Integer characters;
    private Integer words;
    private Integer sentences;
    private Double averageSentencePerWord;
    private Double syllables;
    
    
    /*
     * @return 
     */
    public Integer getPolysyllables() {
        return this.polysyllables;
    }
    
    
    
    /*
     * @return 
     */
    public Double getAverageLetterPerWord() {
        return this.averageLetterPerWord;
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
    public Integer getCharacters() {
        return this.characters;
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
    public Double getAverageSentencePerWord() {
        return this.averageSentencePerWord;
    }
    
    
    
    /*
     * @return 
     */
    public Double getSyllables() {
        return this.syllables;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Statistics.
	
	 * @return String
	 */
	public String toString() {
		return "Statistics[" +polysyllables+", "+averageLetterPerWord+", "+averageSentenceLength+", "+characters+", "+words+", "+sentences+", "+averageSentencePerWord+", "+syllables+"]";
	}
	
	/**
	 * Internal constructor to create a Statistics from a  representation.
	 * @param map The raw json data that will be parsed.
	 * @return 
	 */
    public Statistics(JSONObject json_data) {
        try {// Polysyllables
            this.polysyllables = new Integer(((Long)json_data.get("Polysyllables")).intValue());// Average Letter per Word
            this.averageLetterPerWord = (Double)json_data.get("Average Letter per Word");// Average Sentence Length
            this.averageSentenceLength = (Double)json_data.get("Average Sentence Length");// Characters
            this.characters = new Integer(((Long)json_data.get("Characters")).intValue());// Words
            this.words = new Integer(((Long)json_data.get("Words")).intValue());// Sentences
            this.sentences = new Integer(((Long)json_data.get("Sentences")).intValue());// Average Sentence per Word
            this.averageSentencePerWord = (Double)json_data.get("Average Sentence per Word");// Syllables
            this.syllables = (Double)json_data.get("Syllables");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Statistics; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Statistics; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}