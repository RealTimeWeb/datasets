package corgis.businesses.domain;

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
public class Business {
	
    private String city;
    private Integer review_Count;
    private String name;
    private ArrayList<String> neighborhoods;
    private String url;
    private String type;
    private String business_Id;
    private String full_Address;
    private ArrayList<Reviews> reviews;
    private Double latitude;
    private String state;
    private Double longitude;
    private Double stars;
    private ArrayList<String> schools;
    private Boolean open;
    private ArrayList<String> categories;
    private String photo_Url;
    
    
    /*
     * @return 
     */
    public String getCity() {
        return this.city;
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
    public ArrayList<String> getNeighborhoods() {
        return this.neighborhoods;
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
    public String getType() {
        return this.type;
    }
    
    
    
    /*
     * @return 
     */
    public String getBusiness_Id() {
        return this.business_Id;
    }
    
    
    
    /*
     * @return 
     */
    public String getFull_Address() {
        return this.full_Address;
    }
    
    
    
    /*
     * @return 
     */
    public ArrayList<Reviews> getReviews() {
        return this.reviews;
    }
    
    
    
    /*
     * @return 
     */
    public Double getLatitude() {
        return this.latitude;
    }
    
    
    
    /*
     * @return 
     */
    public String getState() {
        return this.state;
    }
    
    
    
    /*
     * @return 
     */
    public Double getLongitude() {
        return this.longitude;
    }
    
    
    
    /*
     * @return 
     */
    public Double getStars() {
        return this.stars;
    }
    
    
    
    /*
     * @return 
     */
    public ArrayList<String> getSchools() {
        return this.schools;
    }
    
    
    
    /*
     * @return 
     */
    public Boolean getOpen() {
        return this.open;
    }
    
    
    
    /*
     * @return 
     */
    public ArrayList<String> getCategories() {
        return this.categories;
    }
    
    
    
    /*
     * @return 
     */
    public String getPhoto_Url() {
        return this.photo_Url;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Business.
	
	 * @return String
	 */
	public String toString() {
		return "Business[" +city+", "+review_Count+", "+name+", "+neighborhoods+", "+url+", "+type+", "+business_Id+", "+full_Address+", "+reviews+", "+latitude+", "+state+", "+longitude+", "+stars+", "+schools+", "+open+", "+categories+", "+photo_Url+"]";
	}
	
	/**
	 * Internal constructor to create a Business from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Business(JSONObject json_data) {
        try {// city
            this.city = (String)json_data.get("city");// review_count
            this.review_Count = new Integer(((Long)json_data.get("review_count")).intValue());// name
            this.name = (String)json_data.get("name");// neighborhoods
            this.neighborhoods = new ArrayList<String>();
            Iterator<Object> neighborhoodsIter = ((List<Object>)json_data.get("neighborhoods")).iterator();
            while (neighborhoodsIter.hasNext()) {
                this.neighborhoods.add(new String((String)neighborhoodsIter.next()));
            }// url
            this.url = (String)json_data.get("url");// type
            this.type = (String)json_data.get("type");// business_id
            this.business_Id = (String)json_data.get("business_id");// full_address
            this.full_Address = (String)json_data.get("full_address");// reviews
            this.reviews = new ArrayList<Reviews>();
            Iterator<Object> reviewsIter = ((List<Object>)json_data.get("reviews")).iterator();
            while (reviewsIter.hasNext()) {
                this.reviews.add(new Reviews((JSONObject)reviewsIter.next()));
            }// latitude
            this.latitude = (Double)json_data.get("latitude");// state
            this.state = (String)json_data.get("state");// longitude
            this.longitude = (Double)json_data.get("longitude");// stars
            this.stars = (Double)json_data.get("stars");// schools
            this.schools = new ArrayList<String>();
            Iterator<Object> schoolsIter = ((List<Object>)json_data.get("schools")).iterator();
            while (schoolsIter.hasNext()) {
                this.schools.add(new String((String)schoolsIter.next()));
            }// open
            this.open = (Boolean)json_data.get("open");// categories
            this.categories = new ArrayList<String>();
            Iterator<Object> categoriesIter = ((List<Object>)json_data.get("categories")).iterator();
            while (categoriesIter.hasNext()) {
                this.categories.add(new String((String)categoriesIter.next()));
            }// photo_url
            this.photo_Url = (String)json_data.get("photo_url");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Business; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Business; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}