package corgis.books.domain;

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
public class Book {
	
    private Integer pageCount;
    private String title;
    private Double price;
    private Boolean paperback;
    private String author;
    
    
    /*
     * @return 
     */
    public Integer getPageCount() {
        return this.pageCount;
    }
    
    
    
    /*
     * @return 
     */
    public String getTitle() {
        return this.title;
    }
    
    
    
    /*
     * @return 
     */
    public Double getPrice() {
        return this.price;
    }
    
    
    
    /*
     * @return 
     */
    public Boolean getPaperback() {
        return this.paperback;
    }
    
    
    
    /*
     * @return 
     */
    public String getAuthor() {
        return this.author;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Book.
	
	 * @return String
	 */
	public String toString() {
		return "Book[" +pageCount+", "+title+", "+price+", "+paperback+", "+author+"]";
	}
	
	/**
	 * Internal constructor to create a Book from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Book(JSONObject json_data) {
        try {// page count
            this.pageCount = new Integer(((Long)json_data.get("page count")).intValue());// title
            this.title = (String)json_data.get("title");// price
            this.price = (Double)json_data.get("price");// paperback
            this.paperback = (Boolean)json_data.get("paperback");// author
            this.author = (String)json_data.get("author");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Book; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Book; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}