package corgis.cars.domain;

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
public class Identification {
	
    // A unique ID for this particular car, using the year, make, model, and transmission type.
    private String id;
    // The specific name/year for this car.
    private String modelYear;
    // The maker for this car.
    private String make;
    // Whether this is a "Manual transmission" or an "Automatic transmission". If it is unknown, it is left blank.
    private String classification;
    // The year that this car was released.
    private Integer year;
    
    
    /**
     * A unique ID for this particular car, using the year, make, model, and transmission type.
     * @return String
     */
    public String getId() {
        return this.id;
    }
    
    
    
    /**
     * The specific name/year for this car.
     * @return String
     */
    public String getModelYear() {
        return this.modelYear;
    }
    
    
    
    /**
     * The maker for this car.
     * @return String
     */
    public String getMake() {
        return this.make;
    }
    
    
    
    /**
     * Whether this is a "Manual transmission" or an "Automatic transmission". If it is unknown, it is left blank.
     * @return String
     */
    public String getClassification() {
        return this.classification;
    }
    
    
    
    /**
     * The year that this car was released.
     * @return Integer
     */
    public Integer getYear() {
        return this.year;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Identification.
	
	 * @return String
	 */
	public String toString() {
		return "Identification[" +id+", "+modelYear+", "+make+", "+classification+", "+year+"]";
	}
	
	/**
	 * Internal constructor to create a Identification from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Identification(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // ID
            this.id = (String)json_data.get("ID");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Identification; the field id was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Identification; the field id had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Model Year
            this.modelYear = (String)json_data.get("Model Year");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Identification; the field modelYear was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Identification; the field modelYear had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Make
            this.make = (String)json_data.get("Make");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Identification; the field make was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Identification; the field make had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Classification
            this.classification = (String)json_data.get("Classification");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Identification; the field classification was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Identification; the field classification had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Year
            this.year = ((Number)json_data.get("Year")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Identification; the field year was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Identification; the field year had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}