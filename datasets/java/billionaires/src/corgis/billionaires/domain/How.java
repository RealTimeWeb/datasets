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
	
    // Whether the money came from emerging markets.
    private Boolean fromEmerging;
    // Whether the billionaire was the founder of their company.
    private Boolean wasFounder;
    // The way that this money was inherited (or not inherited). Inheritance can come from a spouse, the father, or from multiple generations within a family (either 3, 4, or 5+).
    private String inherited;
    // A category representing where their money came from.
    private String category;
    // The specific industry this billionaire profitted from.
    private String industry;
    // Whether the money came from politics.
    private Boolean wasPolitical;
    
    
    /**
     * Whether the money came from emerging markets.
     * @return Boolean
     */
    public Boolean getFromEmerging() {
        return this.fromEmerging;
    }
    
    
    
    /**
     * Whether the billionaire was the founder of their company.
     * @return Boolean
     */
    public Boolean getWasFounder() {
        return this.wasFounder;
    }
    
    
    
    /**
     * The way that this money was inherited (or not inherited). Inheritance can come from a spouse, the father, or from multiple generations within a family (either 3, 4, or 5+).
     * @return String
     */
    public String getInherited() {
        return this.inherited;
    }
    
    
    
    /**
     * A category representing where their money came from.
     * @return String
     */
    public String getCategory() {
        return this.category;
    }
    
    
    
    /**
     * The specific industry this billionaire profitted from.
     * @return String
     */
    public String getIndustry() {
        return this.industry;
    }
    
    
    
    /**
     * Whether the money came from politics.
     * @return Boolean
     */
    public Boolean getWasPolitical() {
        return this.wasPolitical;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this How.
	
	 * @return String
	 */
	public String toString() {
		return "How[" +fromEmerging+", "+wasFounder+", "+inherited+", "+category+", "+industry+", "+wasPolitical+"]";
	}
	
	/**
	 * Internal constructor to create a How from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public How(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // from emerging
            this.fromEmerging = (Boolean)json_data.get("from emerging");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a How; the field fromEmerging was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a How; the field fromEmerging had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // was founder
            this.wasFounder = (Boolean)json_data.get("was founder");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a How; the field wasFounder was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a How; the field wasFounder had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // inherited
            this.inherited = (String)json_data.get("inherited");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a How; the field inherited was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a How; the field inherited had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // category
            this.category = (String)json_data.get("category");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a How; the field category was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a How; the field category had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // industry
            this.industry = (String)json_data.get("industry");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a How; the field industry was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a How; the field industry had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // was political
            this.wasPolitical = (Boolean)json_data.get("was political");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a How; the field wasPolitical was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a How; the field wasPolitical had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}