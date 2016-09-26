package corgis.supreme_court.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.supreme_court.domain.Disposition;

/**
 * 
 */
public class CaseData {
	
    private Boolean unusual;
    private Disposition disposition;
    
    
    /*
     * @return 
     */
    public Boolean getUnusual() {
        return this.unusual;
    }
    
    
    
    /*
     * @return 
     */
    public Disposition getDisposition() {
        return this.disposition;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this CaseData.
	
	 * @return String
	 */
	public String toString() {
		return "CaseData[" +unusual+", "+disposition+"]";
	}
	
	/**
	 * Internal constructor to create a CaseData from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public CaseData(JSONObject json_data) {
        try {// unusual
            this.unusual = (Boolean)json_data.get("unusual");// disposition
            this.disposition = new Disposition((JSONObject)json_data.get("disposition"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a CaseData; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a CaseData; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}