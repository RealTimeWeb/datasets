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
    private Double averageSentencePerWord;
    private Double averageLetterPerWord;
    private Double syllables;
    private Integer sentences;
    private Integer words;
    
    
    /**
     * The number of words that have 3 or more syllables.
     * @return Integer
     */
    public Integer getPolysyllables() {
        return this.polysyllables;
    }
    
    
    
    /**
     * Characters are letters and symbols in a text, not the number of people.
     * @return Integer
     */
    public Integer getCharacters() {
        return this.characters;
    }
    
    
    
    /**
     * 
     * @return Double
     */
    public Double getAverageSentenceLength() {
        return this.averageSentenceLength;
    }
    
    
    
    /**
     * 
     * @return Double
     */
    public Double getAverageSentencePerWord() {
        return this.averageSentencePerWord;
    }
    
    
    
    /**
     * 
     * @return Double
     */
    public Double getAverageLetterPerWord() {
        return this.averageLetterPerWord;
    }
    
    
    
    /**
     * 
     * @return Double
     */
    public Double getSyllables() {
        return this.syllables;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getSentences() {
        return this.sentences;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getWords() {
        return this.words;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Statistics.
	
	 * @return String
	 */
	public String toString() {
		return "Statistics[" +polysyllables+", "+characters+", "+averageSentenceLength+", "+averageSentencePerWord+", "+averageLetterPerWord+", "+syllables+", "+sentences+", "+words+"]";
	}
	
	/**
	 * Internal constructor to create a Statistics from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Statistics(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // polysyllables
            this.polysyllables = ((Number)json_data.get("polysyllables")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Statistics; the field polysyllables was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Statistics; the field polysyllables had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // characters
            this.characters = ((Number)json_data.get("characters")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Statistics; the field characters was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Statistics; the field characters had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // average sentence length
            this.averageSentenceLength = ((Number)json_data.get("average sentence length")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Statistics; the field averageSentenceLength was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Statistics; the field averageSentenceLength had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // average sentence per word
            this.averageSentencePerWord = ((Number)json_data.get("average sentence per word")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Statistics; the field averageSentencePerWord was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Statistics; the field averageSentencePerWord had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // average letter per word
            this.averageLetterPerWord = ((Number)json_data.get("average letter per word")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Statistics; the field averageLetterPerWord was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Statistics; the field averageLetterPerWord had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // syllables
            this.syllables = ((Number)json_data.get("syllables")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Statistics; the field syllables was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Statistics; the field syllables had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // sentences
            this.sentences = ((Number)json_data.get("sentences")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Statistics; the field sentences was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Statistics; the field sentences had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // words
            this.words = ((Number)json_data.get("words")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Statistics; the field words was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Statistics; the field words had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}