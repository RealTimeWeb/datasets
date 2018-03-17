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
	
    // The amount of money that the author made per day on this book, in dollars.
    private Double authorRevenue;
    // The amount of money that Amazon made per day on this book, in dollars.
    private Double amazonRevenue;
    // The total amount of money that was made per day on this book, in dollars.
    private Double grossSales;
    // The amount of money that the publisher made per day on this book, in dollars.
    private Double publisherRevenue;
    // The number of books sold per day.
    private Integer unitsSold;
    
    
    /**
     * The amount of money that the author made per day on this book, in dollars.
     * @return Double
     */
    public Double getAuthorRevenue() {
        return this.authorRevenue;
    }
    
    
    
    /**
     * The amount of money that Amazon made per day on this book, in dollars.
     * @return Double
     */
    public Double getAmazonRevenue() {
        return this.amazonRevenue;
    }
    
    
    
    /**
     * The total amount of money that was made per day on this book, in dollars.
     * @return Double
     */
    public Double getGrossSales() {
        return this.grossSales;
    }
    
    
    
    /**
     * The amount of money that the publisher made per day on this book, in dollars.
     * @return Double
     */
    public Double getPublisherRevenue() {
        return this.publisherRevenue;
    }
    
    
    
    /**
     * The number of books sold per day.
     * @return Integer
     */
    public Integer getUnitsSold() {
        return this.unitsSold;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this DailyAverage.
	
	 * @return String
	 */
	public String toString() {
		return "DailyAverage[" +authorRevenue+", "+amazonRevenue+", "+grossSales+", "+publisherRevenue+", "+unitsSold+"]";
	}
	
	/**
	 * Internal constructor to create a DailyAverage from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public DailyAverage(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // author revenue
            this.authorRevenue = ((Number)json_data.get("author revenue")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a DailyAverage; the field authorRevenue was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a DailyAverage; the field authorRevenue had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // amazon revenue
            this.amazonRevenue = ((Number)json_data.get("amazon revenue")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a DailyAverage; the field amazonRevenue was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a DailyAverage; the field amazonRevenue had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // gross sales
            this.grossSales = ((Number)json_data.get("gross sales")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a DailyAverage; the field grossSales was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a DailyAverage; the field grossSales had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // publisher revenue
            this.publisherRevenue = ((Number)json_data.get("publisher revenue")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a DailyAverage; the field publisherRevenue was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a DailyAverage; the field publisherRevenue had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // units sold
            this.unitsSold = ((Number)json_data.get("units sold")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a DailyAverage; the field unitsSold was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a DailyAverage; the field unitsSold had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}