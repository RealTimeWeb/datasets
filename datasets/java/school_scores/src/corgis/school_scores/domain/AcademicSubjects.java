package corgis.school_scores.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.school_scores.domain.SocialSciencesHistory;
import corgis.school_scores.domain.NaturalSciences;
import corgis.school_scores.domain.ArtsMusic;
import corgis.school_scores.domain.ForeignLanguages;
import corgis.school_scores.domain.English;
import corgis.school_scores.domain.Mathematics;

/**
 * 
 */
public class AcademicSubjects {
	
    private SocialSciencesHistory socialSciencesHistory;
    private NaturalSciences naturalSciences;
    private ArtsMusic artsMusic;
    private ForeignLanguages foreignLanguages;
    private English english;
    private Mathematics mathematics;
    
    
    /*
     * @return 
     */
    public SocialSciencesHistory getSocialSciencesHistory() {
        return this.socialSciencesHistory;
    }
    
    
    
    /*
     * @return 
     */
    public NaturalSciences getNaturalSciences() {
        return this.naturalSciences;
    }
    
    
    
    /*
     * @return 
     */
    public ArtsMusic getArtsMusic() {
        return this.artsMusic;
    }
    
    
    
    /*
     * @return 
     */
    public ForeignLanguages getForeignLanguages() {
        return this.foreignLanguages;
    }
    
    
    
    /*
     * @return 
     */
    public English getEnglish() {
        return this.english;
    }
    
    
    
    /*
     * @return 
     */
    public Mathematics getMathematics() {
        return this.mathematics;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this AcademicSubjects.
	
	 * @return String
	 */
	public String toString() {
		return "AcademicSubjects[" +socialSciencesHistory+", "+naturalSciences+", "+artsMusic+", "+foreignLanguages+", "+english+", "+mathematics+"]";
	}
	
	/**
	 * Internal constructor to create a AcademicSubjects from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public AcademicSubjects(JSONObject json_data) {
        try {// Social Sciences/History
            this.socialSciencesHistory = new SocialSciencesHistory((JSONObject)json_data.get("Social Sciences/History"));// Natural Sciences
            this.naturalSciences = new NaturalSciences((JSONObject)json_data.get("Natural Sciences"));// Arts/Music
            this.artsMusic = new ArtsMusic((JSONObject)json_data.get("Arts/Music"));// Foreign Languages
            this.foreignLanguages = new ForeignLanguages((JSONObject)json_data.get("Foreign Languages"));// English
            this.english = new English((JSONObject)json_data.get("English"));// Mathematics
            this.mathematics = new Mathematics((JSONObject)json_data.get("Mathematics"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a AcademicSubjects; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a AcademicSubjects; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}