package corgis.education.domain;

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
public class Other {
	
    private Integer individualizedEducationProgram;
    private Integer freeLunchEligible;
    private String ungradedStudents;
    private Integer lepEllStudents;
    private Integer reducedPriceLunchEligible;
    
    
    /*
     * @return 
     */
    public Integer getIndividualizedEducationProgram() {
        return this.individualizedEducationProgram;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getFreeLunchEligible() {
        return this.freeLunchEligible;
    }
    
    
    
    /*
     * @return 
     */
    public String getUngradedStudents() {
        return this.ungradedStudents;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getLepEllStudents() {
        return this.lepEllStudents;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getReducedPriceLunchEligible() {
        return this.reducedPriceLunchEligible;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Other.
	
	 * @return String
	 */
	public String toString() {
		return "Other[" +individualizedEducationProgram+", "+freeLunchEligible+", "+ungradedStudents+", "+lepEllStudents+", "+reducedPriceLunchEligible+"]";
	}
	
	/**
	 * Internal constructor to create a Other from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Other(JSONObject json_data) {
        try {// individualized education program
            this.individualizedEducationProgram = ((Number)json_data.get("individualized education program")).intValue();// free lunch eligible
            this.freeLunchEligible = ((Number)json_data.get("free lunch eligible")).intValue();// ungraded students
            this.ungradedStudents = (String)json_data.get("ungraded students");// lep/ell students
            this.lepEllStudents = ((Number)json_data.get("lep/ell students")).intValue();// reduced-price lunch eligible
            this.reducedPriceLunchEligible = ((Number)json_data.get("reduced-price lunch eligible")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Other; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Other; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}