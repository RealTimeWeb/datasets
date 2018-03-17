package corgis.school_scores.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.school_scores.domain.AMinus;
import corgis.school_scores.domain.APlus;
import corgis.school_scores.domain.C;
import corgis.school_scores.domain.A;
import corgis.school_scores.domain.DOrLower;
import corgis.school_scores.domain.B;
import corgis.school_scores.domain.NoResponse;

/**
 * 
 */
public class Gpa {
	
    private AMinus aMinus;
    private APlus aPlus;
    private C c;
    private A a;
    private DOrLower dOrLower;
    private B b;
    private NoResponse noResponse;
    
    
    /**
     * 
     * @return AMinus
     */
    public AMinus getAMinus() {
        return this.aMinus;
    }
    
    
    
    /**
     * 
     * @return APlus
     */
    public APlus getAPlus() {
        return this.aPlus;
    }
    
    
    
    /**
     * 
     * @return C
     */
    public C getC() {
        return this.c;
    }
    
    
    
    /**
     * 
     * @return A
     */
    public A getA() {
        return this.a;
    }
    
    
    
    /**
     * 
     * @return DOrLower
     */
    public DOrLower getDOrLower() {
        return this.dOrLower;
    }
    
    
    
    /**
     * 
     * @return B
     */
    public B getB() {
        return this.b;
    }
    
    
    
    /**
     * 
     * @return NoResponse
     */
    public NoResponse getNoResponse() {
        return this.noResponse;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Gpa.
	
	 * @return String
	 */
	public String toString() {
		return "Gpa[" +aMinus+", "+aPlus+", "+c+", "+a+", "+dOrLower+", "+b+", "+noResponse+"]";
	}
	
	/**
	 * Internal constructor to create a Gpa from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Gpa(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // A minus
            this.aMinus = new AMinus((JSONObject)json_data.get("A minus"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Gpa; the field aMinus was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Gpa; the field aMinus had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // A plus
            this.aPlus = new APlus((JSONObject)json_data.get("A plus"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Gpa; the field aPlus was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Gpa; the field aPlus had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // C
            this.c = new C((JSONObject)json_data.get("C"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Gpa; the field c was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Gpa; the field c had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // A
            this.a = new A((JSONObject)json_data.get("A"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Gpa; the field a was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Gpa; the field a had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // D or lower
            this.dOrLower = new DOrLower((JSONObject)json_data.get("D or lower"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Gpa; the field dOrLower was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Gpa; the field dOrLower had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // B
            this.b = new B((JSONObject)json_data.get("B"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Gpa; the field b was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Gpa; the field b had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // No response
            this.noResponse = new NoResponse((JSONObject)json_data.get("No response"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Gpa; the field noResponse was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Gpa; the field noResponse had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}