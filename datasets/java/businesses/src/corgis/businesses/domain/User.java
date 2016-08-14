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
public class User {
	
    private Votes votes;
    private Integer review_Count;
    private String name;
    private String url;
    private Double average_Stars;
    private String user_Id;
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
    public Integer getReview_Count() {
        return this.review_Count;
    }
    
    
    
    /*
     * @return 
     */
    public String getName() {
        return this.name;
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
    public Double getAverage_Stars() {
        return this.average_Stars;
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
    public String getType() {
        return this.type;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this User.
	
	 * @return String
	 */
	public String toString() {
		return "User[" +votes+", "+review_Count+", "+name+", "+url+", "+average_Stars+", "+user_Id+", "+type+"]";
	}
	
	/**
	 * Internal constructor to create a User from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public User(JSONObject json_data) {
        try {// votes
            this.votes = new Votes((JSONObject)json_data.get("votes"));// review_count
            this.review_Count = new Integer(((Long)json_data.get("review_count")).intValue());// name
            this.name = (String)json_data.get("name");// url
            this.url = (String)json_data.get("url");// average_stars
            this.average_Stars = (Double)json_data.get("average_stars");// user_id
            this.user_Id = (String)json_data.get("user_id");// type
            this.type = (String)json_data.get("type");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a User; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a User; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}