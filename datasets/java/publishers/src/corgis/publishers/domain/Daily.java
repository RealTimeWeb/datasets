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
public class Daily {
	
    private Double publisherRevenue;
    private Double amazonRevenue;
    private Double authorRevenue;
    private Integer unitsSold;
    private Double grossSales;
    
    
    /*
     * @return 
     */
    public Double getPublisherRevenue() {
        return this.publisherRevenue;
    }
    
    
    
    /*
     * @return 
     */
    public Double getAmazonRevenue() {
        return this.amazonRevenue;
    }
    
    
    
    /*
     * @return 
     */
    public Double getAuthorRevenue() {
        return this.authorRevenue;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getUnitsSold() {
        return this.unitsSold;
    }
    
    
    
    /*
     * @return 
     */
    public Double getGrossSales() {
        return this.grossSales;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Daily.
	
	 * @return String
	 */
	public String toString() {
		return "Daily[" +publisherRevenue+", "+amazonRevenue+", "+authorRevenue+", "+unitsSold+", "+grossSales+"]";
	}
	
	/**
	 * Internal constructor to create a Daily from a  representation.
	 * @param map The raw json data that will be parsed.
	 * @return 
	 */
    public Daily(JSONObject json_data) {
        try {// publisher revenue
            this.publisherRevenue = (Double)json_data.get("publisher revenue");// amazon revenue
            this.amazonRevenue = (Double)json_data.get("amazon revenue");// author revenue
            this.authorRevenue = (Double)json_data.get("author revenue");// units sold
            this.unitsSold = new Integer(((Long)json_data.get("units sold")).intValue());// gross sales
            this.grossSales = (Double)json_data.get("gross sales");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Daily; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Daily; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}