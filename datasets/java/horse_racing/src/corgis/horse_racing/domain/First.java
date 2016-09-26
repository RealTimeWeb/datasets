package corgis.horse_racing.domain;

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
public class First {
	
    private Integer gate;
    private Double show;
    private Double place;
    private String name;
    private Double win;
    
    
    /*
     * @return 
     */
    public Integer getGate() {
        return this.gate;
    }
    
    
    
    /*
     * @return 
     */
    public Double getShow() {
        return this.show;
    }
    
    
    
    /*
     * @return 
     */
    public Double getPlace() {
        return this.place;
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
    public Double getWin() {
        return this.win;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this First.
	
	 * @return String
	 */
	public String toString() {
		return "First[" +gate+", "+show+", "+place+", "+name+", "+win+"]";
	}
	
	/**
	 * Internal constructor to create a First from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public First(JSONObject json_data) {
        try {// gate
            this.gate = new Integer(((Long)json_data.get("gate")).intValue());// show
            this.show = (Double)json_data.get("show");// place
            this.place = (Double)json_data.get("place");// name
            this.name = (String)json_data.get("name");// win
            this.win = (Double)json_data.get("win");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a First; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a First; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}