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
public class DailyAverage {
	
    // The amount of money that the publisher made per day on this book, in dollars.
    private Double publisherRevenue;
    // The amount of money that Amazon made per day on this book, in dollars.
    private Double amazonRevenue;
    // The amount of money that the author made per day on this book, in dollars.
    private Double authorRevenue;
    // The total amount of money that was made per day on this book, in dollars.
    private Double grossSales;
    // The number of books sold per day.
    private Integer unitsSold;
    
    
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
    public Double getGrossSales() {
        return this.grossSales;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getUnitsSold() {
        return this.unitsSold;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this DailyAverage.
	
	 * @return String
	 */
	public String toString() {
		return "DailyAverage[" +publisherRevenue+", "+amazonRevenue+", "+authorRevenue+", "+grossSales+", "+unitsSold+"]";
	}
	
	/**
	 * Internal constructor to create a DailyAverage from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public DailyAverage(JSONObject json_data) {
        try {// publisher revenue
            this.publisherRevenue = ((Number)json_data.get("publisher revenue")).doubleValue();// amazon revenue
            this.amazonRevenue = ((Number)json_data.get("amazon revenue")).doubleValue();// author revenue
            this.authorRevenue = ((Number)json_data.get("author revenue")).doubleValue();// gross sales
            this.grossSales = ((Number)json_data.get("gross sales")).doubleValue();// units sold
            this.unitsSold = ((Number)json_data.get("units sold")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a DailyAverage; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a DailyAverage; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}