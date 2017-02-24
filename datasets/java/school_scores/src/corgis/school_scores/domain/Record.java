package corgis.school_scores.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.school_scores.domain.Gender;
import corgis.school_scores.domain.Gpa;
import corgis.school_scores.domain.State;
import corgis.school_scores.domain.AcademicSubjects;
import corgis.school_scores.domain.FamilyIncome;
import corgis.school_scores.domain.Total;
import corgis.school_scores.domain.ScoreRanges;

/**
 * 
 */
public class Record {
	
    private Gender gender;
    // The year of this report.
    private Integer year;
    private Gpa gpa;
    private State state;
    private AcademicSubjects academicSubjects;
    private FamilyIncome familyIncome;
    private Total total;
    private ScoreRanges scoreRanges;
    
    
    /*
     * @return 
     */
    public Gender getGender() {
        return this.gender;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getYear() {
        return this.year;
    }
    
    
    
    /*
     * @return 
     */
    public Gpa getGpa() {
        return this.gpa;
    }
    
    
    
    /*
     * @return 
     */
    public State getState() {
        return this.state;
    }
    
    
    
    /*
     * @return 
     */
    public AcademicSubjects getAcademicSubjects() {
        return this.academicSubjects;
    }
    
    
    
    /*
     * @return 
     */
    public FamilyIncome getFamilyIncome() {
        return this.familyIncome;
    }
    
    
    
    /*
     * @return 
     */
    public Total getTotal() {
        return this.total;
    }
    
    
    
    /*
     * @return 
     */
    public ScoreRanges getScoreRanges() {
        return this.scoreRanges;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Record.
	
	 * @return String
	 */
	public String toString() {
		return "Record[" +gender+", "+year+", "+gpa+", "+state+", "+academicSubjects+", "+familyIncome+", "+total+", "+scoreRanges+"]";
	}
	
	/**
	 * Internal constructor to create a Record from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Record(JSONObject json_data) {
        try {// Gender
            this.gender = new Gender((JSONObject)json_data.get("Gender"));// Year
            this.year = ((Number)json_data.get("Year")).intValue();// GPA
            this.gpa = new Gpa((JSONObject)json_data.get("GPA"));// State
            this.state = new State((JSONObject)json_data.get("State"));// Academic Subjects
            this.academicSubjects = new AcademicSubjects((JSONObject)json_data.get("Academic Subjects"));// Family Income
            this.familyIncome = new FamilyIncome((JSONObject)json_data.get("Family Income"));// Total
            this.total = new Total((JSONObject)json_data.get("Total"));// Score Ranges
            this.scoreRanges = new ScoreRanges((JSONObject)json_data.get("Score Ranges"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Record; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Record; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}