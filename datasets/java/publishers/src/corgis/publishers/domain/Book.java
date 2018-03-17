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
import corgis.publishers.domain.DailyAverage;

/**
 * 
 */
public class Book {
	
    // The genre of the book, either "fiction", "nonfiction", "genre fiction", "children", "comics", or "foreign language". Some books originally had more than one genre, but this was simplified down to the most prominent genre.
    private String genre;
    private Publisher publisher;
    // The actual company that sold this book, as oppposed to the company that published it.
    private String soldBy;
    private Statistics statistics;
    private DailyAverage dailyAverage;
    
    
    /**
     * The genre of the book, either "fiction", "nonfiction", "genre fiction", "children", "comics", or "foreign language". Some books originally had more than one genre, but this was simplified down to the most prominent genre.
     * @return String
     */
    public String getGenre() {
        return this.genre;
    }
    
    
    
    /**
     * 
     * @return Publisher
     */
    public Publisher getPublisher() {
        return this.publisher;
    }
    
    
    
    /**
     * The actual company that sold this book, as oppposed to the company that published it.
     * @return String
     */
    public String getSoldBy() {
        return this.soldBy;
    }
    
    
    
    /**
     * 
     * @return Statistics
     */
    public Statistics getStatistics() {
        return this.statistics;
    }
    
    
    
    /**
     * 
     * @return DailyAverage
     */
    public DailyAverage getDailyAverage() {
        return this.dailyAverage;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Book.
	
	 * @return String
	 */
	public String toString() {
		return "Book[" +genre+", "+publisher+", "+soldBy+", "+statistics+", "+dailyAverage+"]";
	}
	
	/**
	 * Internal constructor to create a Book from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Book(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // genre
            this.genre = (String)json_data.get("genre");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Book; the field genre was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Book; the field genre had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // publisher
            this.publisher = new Publisher((JSONObject)json_data.get("publisher"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Book; the field publisher was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Book; the field publisher had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // sold by
            this.soldBy = (String)json_data.get("sold by");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Book; the field soldBy was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Book; the field soldBy had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // statistics
            this.statistics = new Statistics((JSONObject)json_data.get("statistics"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Book; the field statistics was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Book; the field statistics had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // daily average
            this.dailyAverage = new DailyAverage((JSONObject)json_data.get("daily average"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Book; the field dailyAverage was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Book; the field dailyAverage had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}