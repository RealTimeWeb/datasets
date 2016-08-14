package corgis.artinstitutemetadata.domain;

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
public class Description {
	
    private String style;
    private String medium;
    private String classification;
    private String shortDescription;
    private String signed;
    private String dated;
    private String dimension;
    
    
    /*
     * @return 
     */
    public String getStyle() {
        return this.style;
    }
    
    
    
    /*
     * @return 
     */
    public String getMedium() {
        return this.medium;
    }
    
    
    
    /*
     * @return 
     */
    public String getClassification() {
        return this.classification;
    }
    
    
    
    /*
     * @return 
     */
    public String getShortDescription() {
        return this.shortDescription;
    }
    
    
    
    /*
     * @return 
     */
    public String getSigned() {
        return this.signed;
    }
    
    
    
    /*
     * @return 
     */
    public String getDated() {
        return this.dated;
    }
    
    
    
    /*
     * @return 
     */
    public String getDimension() {
        return this.dimension;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Description.
	
	 * @return String
	 */
	public String toString() {
		return "Description[" +style+", "+medium+", "+classification+", "+shortDescription+", "+signed+", "+dated+", "+dimension+"]";
	}
	
	/**
	 * Internal constructor to create a Description from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Description(JSONObject json_data) {
        try {// Style
            this.style = (String)json_data.get("Style");// Medium
            this.medium = (String)json_data.get("Medium");// Classification
            this.classification = (String)json_data.get("Classification");// Short Description
            this.shortDescription = (String)json_data.get("Short Description");// Signed
            this.signed = (String)json_data.get("Signed");// Dated
            this.dated = (String)json_data.get("Dated");// Dimension
            this.dimension = (String)json_data.get("Dimension");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Description; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Description; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}