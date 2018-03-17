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
public class Statistics {
	
    // The cost of this book on Amazon, in dollars.
    private Double salePrice;
    // The number of people who have reviewed this book.
    private Integer totalReviews;
    // The ranking of this book, compared to other books. A higher rank indicates a more popular book.
    private Integer salesRank;
    // The average rating of this book, on a five-point scale, as determined by customers.
    private Double averageRating;
    
    
    /**
     * The cost of this book on Amazon, in dollars.
     * @return Double
     */
    public Double getSalePrice() {
        return this.salePrice;
    }
    
    
    
    /**
     * The number of people who have reviewed this book.
     * @return Integer
     */
    public Integer getTotalReviews() {
        return this.totalReviews;
    }
    
    
    
    /**
     * The ranking of this book, compared to other books. A higher rank indicates a more popular book.
     * @return Integer
     */
    public Integer getSalesRank() {
        return this.salesRank;
    }
    
    
    
    /**
     * The average rating of this book, on a five-point scale, as determined by customers.
     * @return Double
     */
    public Double getAverageRating() {
        return this.averageRating;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Statistics.
	
	 * @return String
	 */
	public String toString() {
		return "Statistics[" +salePrice+", "+totalReviews+", "+salesRank+", "+averageRating+"]";
	}
	
	/**
	 * Internal constructor to create a Statistics from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Statistics(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // sale price
            this.salePrice = ((Number)json_data.get("sale price")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Statistics; the field salePrice was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Statistics; the field salePrice had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // total reviews
            this.totalReviews = ((Number)json_data.get("total reviews")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Statistics; the field totalReviews was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Statistics; the field totalReviews had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // sales rank
            this.salesRank = ((Number)json_data.get("sales rank")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Statistics; the field salesRank was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Statistics; the field salesRank had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // average rating
            this.averageRating = ((Number)json_data.get("average rating")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Statistics; the field averageRating was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Statistics; the field averageRating had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}