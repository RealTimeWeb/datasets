package corgis.scripts.domain;

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
public class Data {
	
    private Double rating;
    private Integer votes;
    private String movie_Id;
    private String title;
    private String url;
    private ArrayList<Lines> lines;
    private ArrayList<String> genres;
    private ArrayList<Characters> characters;
    private Integer year;
    
    
    /*
     * @return 
     */
    public Double getRating() {
        return this.rating;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getVotes() {
        return this.votes;
    }
    
    
    
    /*
     * @return 
     */
    public String getMovie_Id() {
        return this.movie_Id;
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
    public String getUrl() {
        return this.url;
    }
    
    
    
    /*
     * @return 
     */
    public ArrayList<Lines> getLines() {
        return this.lines;
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
    public ArrayList<Characters> getCharacters() {
        return this.characters;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getYear() {
        return this.year;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Data.
	
	 * @return String
	 */
	public String toString() {
		return "Data[" +rating+", "+votes+", "+movie_Id+", "+title+", "+url+", "+lines+", "+genres+", "+characters+", "+year+"]";
	}
	
	/**
	 * Internal constructor to create a Data from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Data(JSONObject json_data) {
        try {// rating
            this.rating = (Double)json_data.get("rating");// votes
            this.votes = new Integer(((Long)json_data.get("votes")).intValue());// movie_id
            this.movie_Id = (String)json_data.get("movie_id");// title
            this.title = (String)json_data.get("title");// url
            this.url = (String)json_data.get("url");// lines
            this.lines = new ArrayList<Lines>();
            Iterator<Object> linesIter = ((List<Object>)json_data.get("lines")).iterator();
            while (linesIter.hasNext()) {
                this.lines.add(new Lines((JSONObject)linesIter.next()));
            }// genres
            this.genres = new ArrayList<String>();
            Iterator<Object> genresIter = ((List<Object>)json_data.get("genres")).iterator();
            while (genresIter.hasNext()) {
                this.genres.add(new String((String)genresIter.next()));
            }// characters
            this.characters = new ArrayList<Characters>();
            Iterator<Object> charactersIter = ((List<Object>)json_data.get("characters")).iterator();
            while (charactersIter.hasNext()) {
                this.characters.add(new Characters((JSONObject)charactersIter.next()));
            }// year
            this.year = new Integer(((Long)json_data.get("year")).intValue());
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}