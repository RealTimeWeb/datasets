package corgis.school_scores.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.school_scores.domain.ForeignLanguages;
import corgis.school_scores.domain.ArtsMusic;
import corgis.school_scores.domain.Mathematics;
import corgis.school_scores.domain.SocialSciencesHistory;
import corgis.school_scores.domain.NaturalSciences;
import corgis.school_scores.domain.English;

/**
 * 
 */
public class AcademicSubjects {
	
    private ForeignLanguages foreignLanguages;
    private ArtsMusic artsMusic;
    private Mathematics mathematics;
    private SocialSciencesHistory socialSciencesHistory;
    private NaturalSciences naturalSciences;
    private English english;
    
    
    /**
     * 
     * @return ForeignLanguages
     */
    public ForeignLanguages getForeignLanguages() {
        return this.foreignLanguages;
    }
    
    
    
    /**
     * 
     * @return ArtsMusic
     */
    public ArtsMusic getArtsMusic() {
        return this.artsMusic;
    }
    
    
    
    /**
     * 
     * @return Mathematics
     */
    public Mathematics getMathematics() {
        return this.mathematics;
    }
    
    
    
    /**
     * 
     * @return SocialSciencesHistory
     */
    public SocialSciencesHistory getSocialSciencesHistory() {
        return this.socialSciencesHistory;
    }
    
    
    
    /**
     * 
     * @return NaturalSciences
     */
    public NaturalSciences getNaturalSciences() {
        return this.naturalSciences;
    }
    
    
    
    /**
     * 
     * @return English
     */
    public English getEnglish() {
        return this.english;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this AcademicSubjects.
	
	 * @return String
	 */
	public String toString() {
		return "AcademicSubjects[" +foreignLanguages+", "+artsMusic+", "+mathematics+", "+socialSciencesHistory+", "+naturalSciences+", "+english+"]";
	}
	
	/**
	 * Internal constructor to create a AcademicSubjects from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public AcademicSubjects(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Foreign Languages
            this.foreignLanguages = new ForeignLanguages((JSONObject)json_data.get("Foreign Languages"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a AcademicSubjects; the field foreignLanguages was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a AcademicSubjects; the field foreignLanguages had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Arts/Music
            this.artsMusic = new ArtsMusic((JSONObject)json_data.get("Arts/Music"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a AcademicSubjects; the field artsMusic was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a AcademicSubjects; the field artsMusic had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Mathematics
            this.mathematics = new Mathematics((JSONObject)json_data.get("Mathematics"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a AcademicSubjects; the field mathematics was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a AcademicSubjects; the field mathematics had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Social Sciences/History
            this.socialSciencesHistory = new SocialSciencesHistory((JSONObject)json_data.get("Social Sciences/History"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a AcademicSubjects; the field socialSciencesHistory was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a AcademicSubjects; the field socialSciencesHistory had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Natural Sciences
            this.naturalSciences = new NaturalSciences((JSONObject)json_data.get("Natural Sciences"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a AcademicSubjects; the field naturalSciences was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a AcademicSubjects; the field naturalSciences had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // English
            this.english = new English((JSONObject)json_data.get("English"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a AcademicSubjects; the field english was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a AcademicSubjects; the field english had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}