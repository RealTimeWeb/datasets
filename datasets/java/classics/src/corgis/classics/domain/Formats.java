package corgis.classics.domain;

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
public class Formats {
	
    // Project Gutenberg makes books available in a wide variety of file formats, including raw text files, HTML web pages, audio books, etc. This field indicates the number of ways that this book is available.
    private Integer total;
    private ArrayList<String> types;
    
    
    /*
     * @return 
     */
    public Integer getTotal() {
        return this.total;
    }
    
    
    
    /*
     * @return 
     */
    public ArrayList<String> getTypes() {
        return this.types;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Formats.
	
	 * @return String
	 */
	public String toString() {
		return "Formats[" +total+", "+types+"]";
	}
	
	/**
	 * Internal constructor to create a Formats from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Formats(JSONObject json_data) {
        try {// total
            this.total = new Integer(((Long)json_data.get("total")).intValue());// types
            this.types = new ArrayList<String>();
            Iterator<Object> typesIter = ((List<Object>)json_data.get("types")).iterator();
            while (typesIter.hasNext()) {
                this.types.add(new String((String)typesIter.next()));
            }
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Formats; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Formats; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}