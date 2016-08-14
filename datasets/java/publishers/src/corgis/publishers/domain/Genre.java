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
public class Genre {
	
    private Boolean comics;
    private Boolean fiction;
    private Boolean nonfiction;
    private Boolean foreignLanguage;
    private Boolean genreFiction;
    private Boolean children;
    
    
    /*
     * @return 
     */
    public Boolean getComics() {
        return this.comics;
    }
    
    
    
    /*
     * @return 
     */
    public Boolean getFiction() {
        return this.fiction;
    }
    
    
    
    /*
     * @return 
     */
    public Boolean getNonfiction() {
        return this.nonfiction;
    }
    
    
    
    /*
     * @return 
     */
    public Boolean getForeignLanguage() {
        return this.foreignLanguage;
    }
    
    
    
    /*
     * @return 
     */
    public Boolean getGenreFiction() {
        return this.genreFiction;
    }
    
    
    
    /*
     * @return 
     */
    public Boolean getChildren() {
        return this.children;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Genre.
	
	 * @return String
	 */
	public String toString() {
		return "Genre[" +comics+", "+fiction+", "+nonfiction+", "+foreignLanguage+", "+genreFiction+", "+children+"]";
	}
	
	/**
	 * Internal constructor to create a Genre from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Genre(JSONObject json_data) {
        try {// comics
            this.comics = (Boolean)json_data.get("comics");// fiction
            this.fiction = (Boolean)json_data.get("fiction");// nonfiction
            this.nonfiction = (Boolean)json_data.get("nonfiction");// foreign language
            this.foreignLanguage = (Boolean)json_data.get("foreign language");// genre fiction
            this.genreFiction = (Boolean)json_data.get("genre fiction");// children
            this.children = (Boolean)json_data.get("children");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Genre; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Genre; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}