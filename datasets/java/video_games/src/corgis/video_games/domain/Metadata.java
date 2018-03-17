package corgis.video_games.domain;

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
public class Metadata {
	
    // Whether this game was based off a previously licensed entity.
    private Boolean licensed;
    // The list of genres that this game belongs to.
    private ArrayList<String> genres;
    // The list of publishers who created this game
    private ArrayList<String> publishers;
    // Whether this game is a sequel to another game.
    private Boolean sequel;
    
    
    /**
     * Whether this game was based off a previously licensed entity.
     * @return Boolean
     */
    public Boolean getLicensed() {
        return this.licensed;
    }
    
    
    
    /**
     * The list of genres that this game belongs to.
     * @return ArrayList<String>
     */
    public ArrayList<String> getGenres() {
        return this.genres;
    }
    
    
    
    /**
     * The list of publishers who created this game
     * @return ArrayList<String>
     */
    public ArrayList<String> getPublishers() {
        return this.publishers;
    }
    
    
    
    /**
     * Whether this game is a sequel to another game.
     * @return Boolean
     */
    public Boolean getSequel() {
        return this.sequel;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Metadata.
	
	 * @return String
	 */
	public String toString() {
		return "Metadata[" +licensed+", "+genres+", "+publishers+", "+sequel+"]";
	}
	
	/**
	 * Internal constructor to create a Metadata from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Metadata(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Licensed?
            this.licensed = (Boolean)json_data.get("Licensed?");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Metadata; the field licensed was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Metadata; the field licensed had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Genres
            this.genres = new ArrayList<String>();
            Iterator<Object> genresIter = ((List<Object>)json_data.get("Genres")).iterator();
            while (genresIter.hasNext()) {
                this.genres.add(new String((String)genresIter.next()));
            }
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Metadata; the field genres was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Metadata; the field genres had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Publishers
            this.publishers = new ArrayList<String>();
            Iterator<Object> publishersIter = ((List<Object>)json_data.get("Publishers")).iterator();
            while (publishersIter.hasNext()) {
                this.publishers.add(new String((String)publishersIter.next()));
            }
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Metadata; the field publishers was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Metadata; the field publishers had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Sequel?
            this.sequel = (Boolean)json_data.get("Sequel?");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Metadata; the field sequel was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Metadata; the field sequel had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}