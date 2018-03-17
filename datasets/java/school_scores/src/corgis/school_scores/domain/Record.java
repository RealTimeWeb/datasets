package corgis.school_scores.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.school_scores.domain.AcademicSubjects;
import corgis.school_scores.domain.FamilyIncome;
import corgis.school_scores.domain.Total;
import corgis.school_scores.domain.Gender;
import corgis.school_scores.domain.State;
import corgis.school_scores.domain.Gpa;
import corgis.school_scores.domain.ScoreRanges;

/**
 * 
 */
public class Record {
	
    private AcademicSubjects academicSubjects;
    private FamilyIncome familyIncome;
    private Total total;
    private Gender gender;
    private State state;
    // The year of this report.
    private Integer year;
    private Gpa gpa;
    private ScoreRanges scoreRanges;
    
    
    /**
     * 
     * @return AcademicSubjects
     */
    public AcademicSubjects getAcademicSubjects() {
        return this.academicSubjects;
    }
    
    
    
    /**
     * 
     * @return FamilyIncome
     */
    public FamilyIncome getFamilyIncome() {
        return this.familyIncome;
    }
    
    
    
    /**
     * 
     * @return Total
     */
    public Total getTotal() {
        return this.total;
    }
    
    
    
    /**
     * 
     * @return Gender
     */
    public Gender getGender() {
        return this.gender;
    }
    
    
    
    /**
     * 
     * @return State
     */
    public State getState() {
        return this.state;
    }
    
    
    
    /**
     * The year of this report.
     * @return Integer
     */
    public Integer getYear() {
        return this.year;
    }
    
    
    
    /**
     * 
     * @return Gpa
     */
    public Gpa getGpa() {
        return this.gpa;
    }
    
    
    
    /**
     * 
     * @return ScoreRanges
     */
    public ScoreRanges getScoreRanges() {
        return this.scoreRanges;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Record.
	
	 * @return String
	 */
	public String toString() {
		return "Record[" +academicSubjects+", "+familyIncome+", "+total+", "+gender+", "+state+", "+year+", "+gpa+", "+scoreRanges+"]";
	}
	
	/**
	 * Internal constructor to create a Record from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Record(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Academic Subjects
            this.academicSubjects = new AcademicSubjects((JSONObject)json_data.get("Academic Subjects"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Record; the field academicSubjects was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Record; the field academicSubjects had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Family Income
            this.familyIncome = new FamilyIncome((JSONObject)json_data.get("Family Income"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Record; the field familyIncome was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Record; the field familyIncome had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Total
            this.total = new Total((JSONObject)json_data.get("Total"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Record; the field total was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Record; the field total had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Gender
            this.gender = new Gender((JSONObject)json_data.get("Gender"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Record; the field gender was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Record; the field gender had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // State
            this.state = new State((JSONObject)json_data.get("State"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Record; the field state was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Record; the field state had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Year
            this.year = ((Number)json_data.get("Year")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Record; the field year was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Record; the field year had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // GPA
            this.gpa = new Gpa((JSONObject)json_data.get("GPA"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Record; the field gpa was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Record; the field gpa had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Score Ranges
            this.scoreRanges = new ScoreRanges((JSONObject)json_data.get("Score Ranges"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Record; the field scoreRanges was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Record; the field scoreRanges had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}