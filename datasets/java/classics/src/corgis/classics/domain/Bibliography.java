package corgis.classics.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.classics.domain.Author;
import corgis.classics.domain.Publication;

/**
 * 
 */
public class Bibliography {
	
    private Author author;
    private ArrayList<String> congressClassifications;
    private Publication publication;
    private ArrayList<String> subjects;
    private String title;
    private ArrayList<String> languages;
    private String type;
    
    
    /**
     * 
     * @return Author
     */
    public Author getAuthor() {
        return this.author;
    }
    
    
    
    /**
     * 
     * @return ArrayList<String>
     */
    public ArrayList<String> getCongressClassifications() {
        return this.congressClassifications;
    }
    
    
    
    /**
     * 
     * @return Publication
     */
    public Publication getPublication() {
        return this.publication;
    }
    
    
    
    /**
     * 
     * @return ArrayList<String>
     */
    public ArrayList<String> getSubjects() {
        return this.subjects;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getTitle() {
        return this.title;
    }
    
    
    
    /**
     * 
     * @return ArrayList<String>
     */
    public ArrayList<String> getLanguages() {
        return this.languages;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getType() {
        return this.type;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Bibliography.
	
	 * @return String
	 */
	public String toString() {
		return "Bibliography[" +author+", "+congressClassifications+", "+publication+", "+subjects+", "+title+", "+languages+", "+type+"]";
	}
	
	/**
	 * Internal constructor to create a Bibliography from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Bibliography(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // author
            this.author = new Author((JSONObject)json_data.get("author"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Bibliography; the field author was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Bibliography; the field author had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // congress classifications
            this.congressClassifications = new ArrayList<String>();
            Iterator<Object> congressClassificationsIter = ((List<Object>)json_data.get("congress classifications")).iterator();
            while (congressClassificationsIter.hasNext()) {
                this.congressClassifications.add(new String((String)congressClassificationsIter.next()));
            }
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Bibliography; the field congressClassifications was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Bibliography; the field congressClassifications had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // publication
            this.publication = new Publication((JSONObject)json_data.get("publication"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Bibliography; the field publication was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Bibliography; the field publication had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // subjects
            this.subjects = new ArrayList<String>();
            Iterator<Object> subjectsIter = ((List<Object>)json_data.get("subjects")).iterator();
            while (subjectsIter.hasNext()) {
                this.subjects.add(new String((String)subjectsIter.next()));
            }
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Bibliography; the field subjects was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Bibliography; the field subjects had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // title
            this.title = (String)json_data.get("title");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Bibliography; the field title was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Bibliography; the field title had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // languages
            this.languages = new ArrayList<String>();
            Iterator<Object> languagesIter = ((List<Object>)json_data.get("languages")).iterator();
            while (languagesIter.hasNext()) {
                this.languages.add(new String((String)languagesIter.next()));
            }
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Bibliography; the field languages was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Bibliography; the field languages had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // type
            this.type = (String)json_data.get("type");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Bibliography; the field type was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Bibliography; the field type had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}