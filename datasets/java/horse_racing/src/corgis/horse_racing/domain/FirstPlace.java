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
public class FirstPlace {
	
    private Integer gate;
    private Double win;
    private Double place;
    private String name;
    private Double show;
    
    
    /*
     * @return 
     */
    public Integer getGate() {
        return this.gate;
    }
    
    
    
    /*
     * @return 
     */
    public Double getWin() {
        return this.win;
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
    public Double getShow() {
        return this.show;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this FirstPlace.
	
	 * @return String
	 */
	public String toString() {
		return "FirstPlace[" +gate+", "+win+", "+place+", "+name+", "+show+"]";
	}
	
	/**
	 * Internal constructor to create a FirstPlace from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public FirstPlace(JSONObject json_data) {
        try {// gate
            this.gate = new Integer(((Long)json_data.get("gate")).intValue());// win
            this.win = (Double)json_data.get("win");// place
            this.place = (Double)json_data.get("place");// name
            this.name = (String)json_data.get("name");// show
            this.show = (Double)json_data.get("show");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a FirstPlace; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a FirstPlace; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}