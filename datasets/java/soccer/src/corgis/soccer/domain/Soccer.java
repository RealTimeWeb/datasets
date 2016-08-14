package corgis.soccer.domain;

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
public class Soccer {
	
    private ArrayList<Data> data;
    private String name;
    
    
    /*
     * @return 
     */
    public ArrayList<Data> getData() {
        return this.data;
    }
    
    
    
    /*
     * @return 
     */
    public String getName() {
        return this.name;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Soccer.
	
	 * @return String
	 */
	public String toString() {
		return "Soccer[" +data+", "+name+"]";
	}
	
	/**
	 * Internal constructor to create a Soccer from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Soccer(JSONObject json_data) {
        try {// data
            this.data = new ArrayList<Data>();
            Iterator<Object> dataIter = ((List<Object>)json_data.get("data")).iterator();
            while (dataIter.hasNext()) {
                this.data.add(new Data((JSONObject)dataIter.next()));
            }// name
            this.name = (String)json_data.get("name");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Soccer; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Soccer; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}