package corgis.classics.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.classics.domain.Publication;
import corgis.classics.domain.Author;
import corgis.classics.domain.Languages;
import corgis.classics.domain.Subjects;
import corgis.classics.domain.CongressClassifications;

/**
 * 
 */
public class Bibliography {
	
    private Publication publication;
    private Author author;
    private String title;
    private Languages languages;
    private Subjects subjects;
    private CongressClassifications congressClassifications;
    private String type;
    
    
    /*
     * @return 
     */
    public Publication getPublication() {
        return this.publication;
    }
    
    
    
    /*
     * @return 
     */
    public Author getAuthor() {
        return this.author;
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
    public Languages getLanguages() {
        return this.languages;
    }
    
    
    
    /*
     * @return 
     */
    public Subjects getSubjects() {
        return this.subjects;
    }
    
    
    
    /*
     * @return 
     */
    public CongressClassifications getCongressClassifications() {
        return this.congressClassifications;
    }
    
    
    
    /*
     * @return 
     */
    public String getType() {
        return this.type;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Bibliography.
	
	 * @return String
	 */
	public String toString() {
		return "Bibliography[" +publication+", "+author+", "+title+", "+languages+", "+subjects+", "+congressClassifications+", "+type+"]";
	}
	
	/**
	 * Internal constructor to create a Bibliography from a  representation.
	 * @param map The raw json data that will be parsed.
	 * @return 
	 */
    public Bibliography(JSONObject json_data) {
        try {
            this.publication = new Publication((JSONObject)json_data.get("publication"));
            this.author = new Author((JSONObject)json_data.get("author"));
            this.title = (String)json_data.get("title");
            this.languages = new Languages((JSONObject)json_data.get("languages"));
            this.subjects = new Subjects((JSONObject)json_data.get("subjects"));
            this.congressClassifications = new CongressClassifications((JSONObject)json_data.get("congress classifications"));
            this.type = (String)json_data.get("type");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Bibliography; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Bibliography; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}