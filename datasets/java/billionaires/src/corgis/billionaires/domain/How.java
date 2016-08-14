package corgis.billionaires.domain;

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
public class How {
	
    private String category;
    private Boolean fromEmerging;
    private String industry;
    private Boolean wasPolitical;
    private Boolean inherited;
    private Boolean wasFounder;
    
    
    /*
     * @return 
     */
    public String getCategory() {
        return this.category;
    }
    
    
    
    /*
     * @return 
     */
    public Boolean getFromEmerging() {
        return this.fromEmerging;
    }
    
    
    
    /*
     * @return 
     */
    public String getIndustry() {
        return this.industry;
    }
    
    
    
    /*
     * @return 
     */
    public Boolean getWasPolitical() {
        return this.wasPolitical;
    }
    
    
    
    /*
     * @return 
     */
    public Boolean getInherited() {
        return this.inherited;
    }
    
    
    
    /*
     * @return 
     */
    public Boolean getWasFounder() {
        return this.wasFounder;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this How.
	
	 * @return String
	 */
	public String toString() {
		return "How[" +category+", "+fromEmerging+", "+industry+", "+wasPolitical+", "+inherited+", "+wasFounder+"]";
	}
	
	/**
	 * Internal constructor to create a How from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public How(JSONObject json_data) {
        try {// category
            this.category = (String)json_data.get("category");// from emerging
            this.fromEmerging = (Boolean)json_data.get("from emerging");// industry
            this.industry = (String)json_data.get("industry");// was political
            this.wasPolitical = (Boolean)json_data.get("was political");// inherited
            this.inherited = (Boolean)json_data.get("inherited");// was founder
            this.wasFounder = (Boolean)json_data.get("was founder");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a How; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a How; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}