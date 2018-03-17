package corgis.tate.domain;

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
	
    private String url;
    private String title;
    private String medium;
    private String thumbnail;
    
    
    /**
     * 
     * @return String
     */
    public String getUrl() {
        return this.url;
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
     * @return String
     */
    public String getMedium() {
        return this.medium;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getThumbnail() {
        return this.thumbnail;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Data.
	
	 * @return String
	 */
	public String toString() {
		return "Data[" +url+", "+title+", "+medium+", "+thumbnail+"]";
	}
	
	/**
	 * Internal constructor to create a Data from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Data(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // url
            this.url = (String)json_data.get("url");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field url was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field url had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // title
            this.title = (String)json_data.get("title");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field title was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field title had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // medium
            this.medium = (String)json_data.get("medium");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field medium was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field medium had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // thumbnail
            this.thumbnail = (String)json_data.get("thumbnail");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field thumbnail was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field thumbnail had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}