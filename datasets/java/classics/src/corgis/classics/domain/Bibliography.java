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
    private Author author;
    private String title;
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
		return "Bibliography[" +publication+", "+author+", "+title+", "+languages+", "+subjects+", "+congressClassifications+", "+type+"]";
	}
	
	/**
	 * Internal constructor to create a Bibliography from a  representation.
	 * @param map The raw json data that will be parsed.
	 * @return 
	 */
    public Bibliography(JSONObject json_data) {
        try {// Publication
            this.publication = new Publication((JSONObject)json_data.get("Publication"));// Author
            this.author = new Author((JSONObject)json_data.get("Author"));// Title
            this.title = (String)json_data.get("Title");// Languages
            this.languages = new ArrayList<String>();
            Iterator<Object> languagesIter = ((List<Object>)json_data.get("Languages")).iterator();
            while (languagesIter.hasNext()) {
                this.languages.add(new String((String)languagesIter.next()));
            }// Subjects
            this.subjects = new ArrayList<String>();
            Iterator<Object> subjectsIter = ((List<Object>)json_data.get("Subjects")).iterator();
            while (subjectsIter.hasNext()) {
                this.subjects.add(new String((String)subjectsIter.next()));
            }// Congress Classifications
            this.congressClassifications = new ArrayList<String>();
            Iterator<Object> congressClassificationsIter = ((List<Object>)json_data.get("Congress Classifications")).iterator();
            while (congressClassificationsIter.hasNext()) {
                this.congressClassifications.add(new String((String)congressClassificationsIter.next()));
            }// Type
            this.type = (String)json_data.get("Type");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Bibliography; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Bibliography; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}