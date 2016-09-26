package corgis.weather.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.weather.domain.Date;
import corgis.weather.domain.Station;
import corgis.weather.domain.Data;

/**
 * 
 */
public class Report {
	
    // This is a list of strings. An empty list represents no significant weather to report for that day
    private ArrayList<String> weatherConditions;
    private Date date;
    private Station station;
    private Data data;
    
    
    /*
     * @return 
     */
    public ArrayList<String> getWeatherConditions() {
        return this.weatherConditions;
    }
    
    
    
    /*
     * @return 
     */
    public Date getDate() {
        return this.date;
    }
    
    
    
    /*
     * @return 
     */
    public Station getStation() {
        return this.station;
    }
    
    
    
    /*
     * @return 
     */
    public Data getData() {
        return this.data;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Report.
	
	 * @return String
	 */
	public String toString() {
		return "Report[" +weatherConditions+", "+date+", "+station+", "+data+"]";
	}
	
	/**
	 * Internal constructor to create a Report from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Report(JSONObject json_data) {
        try {// Weather Conditions
            this.weatherConditions = new ArrayList<String>();
            Iterator<Object> weatherConditionsIter = ((List<Object>)json_data.get("Weather Conditions")).iterator();
            while (weatherConditionsIter.hasNext()) {
                this.weatherConditions.add(new String((String)weatherConditionsIter.next()));
            }// Date
            this.date = new Date((JSONObject)json_data.get("Date"));// Station
            this.station = new Station((JSONObject)json_data.get("Station"));// Data
            this.data = new Data((JSONObject)json_data.get("Data"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Report; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Report; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}