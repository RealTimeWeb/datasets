package corgis.classics.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.classics.domain.Publication;
import corgis.classics.domain.Author;

/**
 * 
 */
public class Bibliography {
	
    private Publication publication;
    private String title;
    private Author author;
    private ArrayList<String> languages;
    private ArrayList<String> subjects;
    private ArrayList<String> congressClassifications;
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
    public String getTitle() {
        return this.title;
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
    public ArrayList<String> getLanguages() {
        return this.languages;
    }
    
    
    
    /*
     * @return 
     */
    public ArrayList<String> getSubjects() {
        return this.subjects;
    }
    
    
    
    /*
     * @return 
     */
    public ArrayList<String> getCongressClassifications() {
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
		return "Bibliography[" +publication+", "+title+", "+author+", "+languages+", "+subjects+", "+congressClassifications+", "+type+"]";
	}
	
	/**
	 * Internal constructor to create a Bibliography from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Bibliography(JSONObject json_data) {
        try {// publication
            this.publication = new Publication((JSONObject)json_data.get("publication"));// title
            this.title = (String)json_data.get("title");// author
            this.author = new Author((JSONObject)json_data.get("author"));// languages
            this.languages = new ArrayList<String>();
            Iterator<Object> languagesIter = ((List<Object>)json_data.get("languages")).iterator();
            while (languagesIter.hasNext()) {
                this.languages.add(new String((String)languagesIter.next()));
            }// subjects
            this.subjects = new ArrayList<String>();
            Iterator<Object> subjectsIter = ((List<Object>)json_data.get("subjects")).iterator();
            while (subjectsIter.hasNext()) {
                this.subjects.add(new String((String)subjectsIter.next()));
            }// congress classifications
            this.congressClassifications = new ArrayList<String>();
            Iterator<Object> congressClassificationsIter = ((List<Object>)json_data.get("congress classifications")).iterator();
            while (congressClassificationsIter.hasNext()) {
                this.congressClassifications.add(new String((String)congressClassificationsIter.next()));
            }// type
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