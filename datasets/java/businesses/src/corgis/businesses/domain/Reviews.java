package corgis.businesses.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.businesses.domain.Votes;

/**
 * 
 */
public class Reviews {
	
    private Votes votes;
    private String user_Id;
    private String review_Id;
    private String text;
    private Integer stars;
    private String date;
    private String type;
    
    
    /*
     * @return 
     */
    public Votes getVotes() {
        return this.votes;
    }
    
    
    
    /*
     * @return 
     */
    public String getUser_Id() {
        return this.user_Id;
    }
    
    
    
    /*
     * @return 
     */
    public String getReview_Id() {
        return this.review_Id;
    }
    
    
    
    /*
     * @return 
     */
    public String getText() {
        return this.text;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getStars() {
        return this.stars;
    }
    
    
    
    /*
     * @return 
     */
    public String getDate() {
        return this.date;
    }
    
    
    
    /*
     * @return 
     */
    public String getType() {
        return this.type;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Reviews.
	
	 * @return String
	 */
	public String toString() {
		return "Reviews[" +votes+", "+user_Id+", "+review_Id+", "+text+", "+stars+", "+date+", "+type+"]";
	}
	
	/**
	 * Internal constructor to create a Reviews from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Reviews(JSONObject json_data) {
        try {// votes
            this.votes = new Votes((JSONObject)json_data.get("votes"));// user_id
            this.user_Id = (String)json_data.get("user_id");// review_id
            this.review_Id = (String)json_data.get("review_id");// text
            this.text = (String)json_data.get("text");// stars
            this.stars = new Integer(((Long)json_data.get("stars")).intValue());// date
            this.date = (String)json_data.get("date");// type
            this.type = (String)json_data.get("type");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Reviews; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Reviews; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}