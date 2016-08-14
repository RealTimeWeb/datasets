package corgis.drugs.domain;

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
public class Data {
	
    private Integer youngCi;
    private Integer medium;
    private Integer old;
    private Integer mediumCi;
    private Integer young;
    private String state;
    private Integer oldCi;
    
    
    /*
     * @return 
     */
    public Integer getYoungCi() {
        return this.youngCi;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getMedium() {
        return this.medium;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getOld() {
        return this.old;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getMediumCi() {
        return this.mediumCi;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getYoung() {
        return this.young;
    }
    
    
    
    /*
     * @return 
     */
    public String getState() {
        return this.state;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getOldCi() {
        return this.oldCi;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Data.
	
	 * @return String
	 */
	public String toString() {
		return "Data[" +youngCi+", "+medium+", "+old+", "+mediumCi+", "+young+", "+state+", "+oldCi+"]";
	}
	
	/**
	 * Internal constructor to create a Data from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Data(JSONObject json_data) {
        try {// Young CI
            this.youngCi = new Integer(((Long)json_data.get("Young CI")).intValue());// Medium
            this.medium = new Integer(((Long)json_data.get("Medium")).intValue());// Old
            this.old = new Integer(((Long)json_data.get("Old")).intValue());// Medium CI
            this.mediumCi = new Integer(((Long)json_data.get("Medium CI")).intValue());// Young
            this.young = new Integer(((Long)json_data.get("Young")).intValue());// State
            this.state = (String)json_data.get("State");// Old CI
            this.oldCi = new Integer(((Long)json_data.get("Old CI")).intValue());
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}