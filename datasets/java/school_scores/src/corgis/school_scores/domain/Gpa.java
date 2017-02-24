package corgis.school_scores.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.school_scores.domain.A;
import corgis.school_scores.domain.C;
import corgis.school_scores.domain.B;
import corgis.school_scores.domain.NoResponse;
import corgis.school_scores.domain.DOrLower;
import corgis.school_scores.domain.APlus;
import corgis.school_scores.domain.AMinus;

/**
 * 
 */
public class Gpa {
	
    private A a;
    private C c;
    private B b;
    private NoResponse noResponse;
    private DOrLower dOrLower;
    private APlus aPlus;
    private AMinus aMinus;
    
    
    /*
     * @return 
     */
    public A getA() {
        return this.a;
    }
    
    
    
    /*
     * @return 
     */
    public C getC() {
        return this.c;
    }
    
    
    
    /*
     * @return 
     */
    public B getB() {
        return this.b;
    }
    
    
    
    /*
     * @return 
     */
    public NoResponse getNoResponse() {
        return this.noResponse;
    }
    
    
    
    /*
     * @return 
     */
    public DOrLower getDOrLower() {
        return this.dOrLower;
    }
    
    
    
    /*
     * @return 
     */
    public APlus getAPlus() {
        return this.aPlus;
    }
    
    
    
    /*
     * @return 
     */
    public AMinus getAMinus() {
        return this.aMinus;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Gpa.
	
	 * @return String
	 */
	public String toString() {
		return "Gpa[" +a+", "+c+", "+b+", "+noResponse+", "+dOrLower+", "+aPlus+", "+aMinus+"]";
	}
	
	/**
	 * Internal constructor to create a Gpa from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Gpa(JSONObject json_data) {
        try {// A
            this.a = new A((JSONObject)json_data.get("A"));// C
            this.c = new C((JSONObject)json_data.get("C"));// B
            this.b = new B((JSONObject)json_data.get("B"));// No response
            this.noResponse = new NoResponse((JSONObject)json_data.get("No response"));// D or lower
            this.dOrLower = new DOrLower((JSONObject)json_data.get("D or lower"));// A plus
            this.aPlus = new APlus((JSONObject)json_data.get("A plus"));// A minus
            this.aMinus = new AMinus((JSONObject)json_data.get("A minus"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Gpa; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Gpa; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}