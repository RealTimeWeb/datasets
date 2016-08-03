package corgis.publishers.domain;

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
public class Publisher {
	
    private Boolean indie;
    private Boolean smallMedium;
    private Boolean amazon;
    private Boolean singleAuthor;
    private Boolean bigFive;
    
    
    /*
     * @return 
     */
    public Boolean getIndie() {
        return this.indie;
    }
    
    
    
    /*
     * @return 
     */
    public Boolean getSmallMedium() {
        return this.smallMedium;
    }
    
    
    
    /*
     * @return 
     */
    public Boolean getAmazon() {
        return this.amazon;
    }
    
    
    
    /*
     * @return 
     */
    public Boolean getSingleAuthor() {
        return this.singleAuthor;
    }
    
    
    
    /*
     * @return 
     */
    public Boolean getBigFive() {
        return this.bigFive;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Publisher.
	
	 * @return String
	 */
	public String toString() {
		return "Publisher[" +indie+", "+smallMedium+", "+amazon+", "+singleAuthor+", "+bigFive+"]";
	}
	
	/**
	 * Internal constructor to create a Publisher from a  representation.
	 * @param map The raw json data that will be parsed.
	 * @return 
	 */
    public Publisher(JSONObject json_data) {
        try {// indie
            this.indie = (Boolean)json_data.get("indie");// small/medium
            this.smallMedium = (Boolean)json_data.get("small/medium");// amazon
            this.amazon = (Boolean)json_data.get("amazon");// single author
            this.singleAuthor = (Boolean)json_data.get("single author");// big five
            this.bigFive = (Boolean)json_data.get("big five");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Publisher; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Publisher; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}