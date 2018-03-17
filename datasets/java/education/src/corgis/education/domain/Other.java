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
	
    private Integer lepEllStudents;
    private Integer reducedPriceLunchEligible;
    private Integer freeLunchEligible;
    private String ungradedStudents;
    private Integer individualizedEducationProgram;
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getLepEllStudents() {
        return this.lepEllStudents;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getReducedPriceLunchEligible() {
        return this.reducedPriceLunchEligible;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getFreeLunchEligible() {
        return this.freeLunchEligible;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getUngradedStudents() {
        return this.ungradedStudents;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getIndividualizedEducationProgram() {
        return this.individualizedEducationProgram;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Other.
	
	 * @return String
	 */
	public String toString() {
		return "Other[" +lepEllStudents+", "+reducedPriceLunchEligible+", "+freeLunchEligible+", "+ungradedStudents+", "+individualizedEducationProgram+"]";
	}
	
	/**
	 * Internal constructor to create a Other from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Other(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // lep/ell students
            this.lepEllStudents = ((Number)json_data.get("lep/ell students")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Other; the field lepEllStudents was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Other; the field lepEllStudents had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // reduced-price lunch eligible
            this.reducedPriceLunchEligible = ((Number)json_data.get("reduced-price lunch eligible")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Other; the field reducedPriceLunchEligible was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Other; the field reducedPriceLunchEligible had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // free lunch eligible
            this.freeLunchEligible = ((Number)json_data.get("free lunch eligible")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Other; the field freeLunchEligible was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Other; the field freeLunchEligible had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // ungraded students
            this.ungradedStudents = (String)json_data.get("ungraded students");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Other; the field ungradedStudents was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Other; the field ungradedStudents had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // individualized education program
            this.individualizedEducationProgram = ((Number)json_data.get("individualized education program")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Other; the field individualizedEducationProgram was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Other; the field individualizedEducationProgram had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}