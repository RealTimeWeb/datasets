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
	
    // A category representing where their money came from.
    private String category;
    // Whether the money came from emerging markets.
    private Boolean fromEmerging;
    // The specific industry this billionaire profitted from.
    private String industry;
    // Whether the money came from politics.
    private Boolean wasPolitical;
    // The way that this money was inherited (or not inherited). Inheritance can come from a spouse, the father, or from multiple generations within a family (either 3, 4, or 5+).
    private String inherited;
    // Whether the billionaire was the founder of their company.
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
    public String getInherited() {
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
            this.inherited = (String)json_data.get("inherited");// was founder
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