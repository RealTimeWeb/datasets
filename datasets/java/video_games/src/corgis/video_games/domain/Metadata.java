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
	
    // The list of publishers who created this game
    private ArrayList<String> publishers;
    // The list of genres that this game belongs to.
    private ArrayList<String> genres;
    // Whether this game was based off a previously licensed entity.
    private Boolean licensed;
    // Whether this game is a sequel to another game.
    private Boolean sequel;
    
    
    /*
     * @return 
     */
    public ArrayList<String> getPublishers() {
        return this.publishers;
    }
    
    
    
    /*
     * @return 
     */
    public ArrayList<String> getGenres() {
        return this.genres;
    }
    
    
    
    /*
     * @return 
     */
    public Boolean getLicensed() {
        return this.licensed;
    }
    
    
    
    /*
     * @return 
     */
    public Boolean getSequel() {
        return this.sequel;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Metadata.
	
	 * @return String
	 */
	public String toString() {
		return "Metadata[" +publishers+", "+genres+", "+licensed+", "+sequel+"]";
	}
	
	/**
	 * Internal constructor to create a Metadata from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Metadata(JSONObject json_data) {
        try {// Publishers
            this.publishers = new ArrayList<String>();
            Iterator<Object> publishersIter = ((List<Object>)json_data.get("Publishers")).iterator();
            while (publishersIter.hasNext()) {
                this.publishers.add(new String((String)publishersIter.next()));
            }// Genres
            this.genres = new ArrayList<String>();
            Iterator<Object> genresIter = ((List<Object>)json_data.get("Genres")).iterator();
            while (genresIter.hasNext()) {
                this.genres.add(new String((String)genresIter.next()));
            }// Licensed?
            this.licensed = (Boolean)json_data.get("Licensed?");// Sequel?
            this.sequel = (Boolean)json_data.get("Sequel?");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Metadata; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Metadata; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}