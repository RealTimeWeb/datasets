package corgis.constructionspending.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.constructionspending.domain.Combined;
import corgis.constructionspending.domain.Private;
import corgis.constructionspending.domain.Public;

/**
 * 
 */
public class Current {
	
    private Combined combined;
    private Private private;
    private Public public;
    
    
    /*
     * @return 
     */
    public Combined getCombined() {
        return this.combined;
    }
    
    
    
    /*
     * @return 
     */
    public Private getPrivate() {
        return this.private;
    }
    
    
    
    /*
     * @return 
     */
    public Public getPublic() {
        return this.public;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Current.
	
	 * @return String
	 */
	public String toString() {
		return "Current[" +combined+", "+private+", "+public+"]";
	}
	
	/**
	 * Internal constructor to create a Current from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Current(JSONObject json_data) {
        try {// combined
            this.combined = new Combined((JSONObject)json_data.get("combined"));// private
            this.private = new Private((JSONObject)json_data.get("private"));// public
            this.public = new Public((JSONObject)json_data.get("public"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Current; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Current; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}