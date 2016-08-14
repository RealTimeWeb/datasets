package corgis.johnsongrass.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.johnsongrass.domain.Weather;

/**
 * 
 */
public class Site {
	
    private Weather weather;
    private Integer id;
    private String habitat;
    private String agricultural;
    
    
    /*
     * @return 
     */
    public Weather getWeather() {
        return this.weather;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getId() {
        return this.id;
    }
    
    
    
    /*
     * @return 
     */
    public String getHabitat() {
        return this.habitat;
    }
    
    
    
    /*
     * @return 
     */
    public String getAgricultural() {
        return this.agricultural;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Site.
	
	 * @return String
	 */
	public String toString() {
		return "Site[" +weather+", "+id+", "+habitat+", "+agricultural+"]";
	}
	
	/**
	 * Internal constructor to create a Site from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Site(JSONObject json_data) {
        try {// weather
            this.weather = new Weather((JSONObject)json_data.get("weather"));// id
            this.id = new Integer(((Long)json_data.get("id")).intValue());// habitat
            this.habitat = (String)json_data.get("habitat");// agricultural?
            this.agricultural = (String)json_data.get("agricultural?");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Site; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Site; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}