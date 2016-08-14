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
public class Lines {
	
    private String text;
    private String character_Id;
    private String line_Id;
    
    
    /*
     * @return 
     */
    public String getText() {
        return this.text;
    }
    
    
    
    /*
     * @return 
     */
    public String getCharacter_Id() {
        return this.character_Id;
    }
    
    
    
    /*
     * @return 
     */
    public String getLine_Id() {
        return this.line_Id;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Lines.
	
	 * @return String
	 */
	public String toString() {
		return "Lines[" +text+", "+character_Id+", "+line_Id+"]";
	}
	
	/**
	 * Internal constructor to create a Lines from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Lines(JSONObject json_data) {
        try {// text
            this.text = (String)json_data.get("text");// character_id
            this.character_Id = (String)json_data.get("character_id");// line_id
            this.line_Id = (String)json_data.get("line_id");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Lines; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Lines; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}