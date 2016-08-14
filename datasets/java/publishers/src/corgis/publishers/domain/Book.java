package corgis.publishers.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.publishers.domain.Publisher;
import corgis.publishers.domain.Daily;
import corgis.publishers.domain.Genre;

/**
 * 
 */
public class Book {
	
    private Publisher publisher;
    private Integer totalReviews;
    private String soldBy;
    private Daily daily;
    private Double salePrice;
    private Integer salesRank;
    private Genre genre;
    private Double averageRating;
    
    
    /*
     * @return 
     */
    public Publisher getPublisher() {
        return this.publisher;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getTotalReviews() {
        return this.totalReviews;
    }
    
    
    
    /*
     * @return 
     */
    public String getSoldBy() {
        return this.soldBy;
    }
    
    
    
    /*
     * @return 
     */
    public Daily getDaily() {
        return this.daily;
    }
    
    
    
    /*
     * @return 
     */
    public Double getSalePrice() {
        return this.salePrice;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getSalesRank() {
        return this.salesRank;
    }
    
    
    
    /*
     * @return 
     */
    public Genre getGenre() {
        return this.genre;
    }
    
    
    
    /*
     * @return 
     */
    public Double getAverageRating() {
        return this.averageRating;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Book.
	
	 * @return String
	 */
	public String toString() {
		return "Book[" +publisher+", "+totalReviews+", "+soldBy+", "+daily+", "+salePrice+", "+salesRank+", "+genre+", "+averageRating+"]";
	}
	
	/**
	 * Internal constructor to create a Book from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Book(JSONObject json_data) {
        try {// publisher
            this.publisher = new Publisher((JSONObject)json_data.get("publisher"));// total reviews
            this.totalReviews = new Integer(((Long)json_data.get("total reviews")).intValue());// sold by
            this.soldBy = (String)json_data.get("sold by");// daily
            this.daily = new Daily((JSONObject)json_data.get("daily"));// sale price
            this.salePrice = (Double)json_data.get("sale price");// sales rank
            this.salesRank = new Integer(((Long)json_data.get("sales rank")).intValue());// genre
            this.genre = new Genre((JSONObject)json_data.get("genre"));// average rating
            this.averageRating = (Double)json_data.get("average rating");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Book; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Book; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}