package corgis.finance.domain;

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
public class Record {
	
    // unicode , state
    private String state;
    // list[dict] , data
    private ArrayList<Data> data;
    
    
    /*
     * @return 
     */
    public String getState() {
        return this.state;
    }
    
    
    
    /*
     * @return 
     */
    public ArrayList<Data> getData() {
        return this.data;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Record.
	
	 * @return String
	 */
	public String toString() {
		return "Record[" +state+", "+data+"]";
	}
	
	/**
	 * Internal constructor to create a Record from a  representation.
	 * @param map The raw json data that will be parsed.
	 * @return 
	 */
    public Record(JSONObject json_data) {
        try {// state
            this.state = (String)json_data.get("state");// data
            this.data = new ArrayList<Data>();
            Iterator<Object> dataIter = ((List<Object>)json_data.get("data")).iterator();
            while (dataIter.hasNext()) {
                this.data.add(new Data((Map<String, Object>)dataIter.next()));
            }
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Record; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Record; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}