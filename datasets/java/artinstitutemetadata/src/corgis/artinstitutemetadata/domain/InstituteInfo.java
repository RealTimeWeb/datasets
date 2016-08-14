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
public class InstituteInfo {
	
    private String rightsType;
    private String inscription;
    private String creditLine;
    private String room;
    private String text;
    private String provenance;
    private String department;
    
    
    /*
     * @return 
     */
    public String getRightsType() {
        return this.rightsType;
    }
    
    
    
    /*
     * @return 
     */
    public String getInscription() {
        return this.inscription;
    }
    
    
    
    /*
     * @return 
     */
    public String getCreditLine() {
        return this.creditLine;
    }
    
    
    
    /*
     * @return 
     */
    public String getRoom() {
        return this.room;
    }
    
    
    
    /*
     * @return 
     */
    public String getText() {
        return this.text;
    }
    
    
    
    /*
     * @return 
     */
    public String getProvenance() {
        return this.provenance;
    }
    
    
    
    /*
     * @return 
     */
    public String getDepartment() {
        return this.department;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this InstituteInfo.
	
	 * @return String
	 */
	public String toString() {
		return "InstituteInfo[" +rightsType+", "+inscription+", "+creditLine+", "+room+", "+text+", "+provenance+", "+department+"]";
	}
	
	/**
	 * Internal constructor to create a InstituteInfo from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public InstituteInfo(JSONObject json_data) {
        try {// Rights Type
            this.rightsType = (String)json_data.get("Rights Type");// Inscription
            this.inscription = (String)json_data.get("Inscription");// Credit Line
            this.creditLine = (String)json_data.get("Credit Line");// Room
            this.room = (String)json_data.get("Room");// Text
            this.text = (String)json_data.get("Text");// Provenance
            this.provenance = (String)json_data.get("Provenance");// Department
            this.department = (String)json_data.get("Department");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a InstituteInfo; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a InstituteInfo; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}