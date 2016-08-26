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
import corgis.publishers.domain.Statistics;
import corgis.publishers.domain.Daily;

/**
 * 
 */
public class Book {
	
    // The genre of the book, either "fiction", "non-fiction", "genre fiction", "childrens", "comics", or "foreign language". Some books originally had more than one genre, but this was simplified down to the most prominent genre.
    private String genre;
    private Publisher publisher;
    // The actual company that sold this book, as oppposed to the company that published it.
    private String soldBy;
    private Statistics statistics;
    private Daily daily;
    
    
    /*
     * @return 
     */
    public String getGenre() {
        return this.genre;
    }
    
    
    
    /*
     * @return 
     */
    public Publisher getPublisher() {
        return this.publisher;
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
    public Statistics getStatistics() {
        return this.statistics;
    }
    
    
    
    /*
     * @return 
     */
    public Daily getDaily() {
        return this.daily;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Book.
	
	 * @return String
	 */
	public String toString() {
		return "Book[" +genre+", "+publisher+", "+soldBy+", "+statistics+", "+daily+"]";
	}
	
	/**
	 * Internal constructor to create a Book from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Book(JSONObject json_data) {
        try {// genre
            this.genre = (String)json_data.get("genre");// publisher
            this.publisher = new Publisher((JSONObject)json_data.get("publisher"));// sold by
            this.soldBy = (String)json_data.get("sold by");// statistics
            this.statistics = new Statistics((JSONObject)json_data.get("statistics"));// daily
            this.daily = new Daily((JSONObject)json_data.get("daily"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Book; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Book; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}