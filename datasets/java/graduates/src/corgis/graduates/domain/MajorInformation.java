package corgis.graduates.domain;

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
public class MajorInformation {
	
    private Integer majorCode;
    private Integer rankByMedianEarnings;
    private String major;
    private Integer totalNumberInMajor;
    private String majorCategory;
    
    
    /*
     * @return 
     */
    public Integer getMajorCode() {
        return this.majorCode;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getRankByMedianEarnings() {
        return this.rankByMedianEarnings;
    }
    
    
    
    /*
     * @return 
     */
    public String getMajor() {
        return this.major;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getTotalNumberInMajor() {
        return this.totalNumberInMajor;
    }
    
    
    
    /*
     * @return 
     */
    public String getMajorCategory() {
        return this.majorCategory;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this MajorInformation.
	
	 * @return String
	 */
	public String toString() {
		return "MajorInformation[" +majorCode+", "+rankByMedianEarnings+", "+major+", "+totalNumberInMajor+", "+majorCategory+"]";
	}
	
	/**
	 * Internal constructor to create a MajorInformation from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public MajorInformation(JSONObject json_data) {
        try {// Major Code
            this.majorCode = ((Number)json_data.get("Major Code")).intValue();// Rank by Median Earnings
            this.rankByMedianEarnings = ((Number)json_data.get("Rank by Median Earnings")).intValue();// Major
            this.major = (String)json_data.get("Major");// Total Number in Major
            this.totalNumberInMajor = ((Number)json_data.get("Total Number in Major")).intValue();// Major Category
            this.majorCategory = (String)json_data.get("Major Category");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a MajorInformation; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a MajorInformation; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}