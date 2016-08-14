package corgis.weather.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.weather.domain.Data;

/**
 * 
 */
public class Report {
	
    private ArrayList<WeatherConditions> weatherConditions;
    private String city;
    private String stationsState;
    private String station;
    private String date;
    private Data data;
    
    
    /*
     * @return 
     */
    public ArrayList<WeatherConditions> getWeatherConditions() {
        return this.weatherConditions;
    }
    
    
    
    /*
     * @return 
     */
    public String getCity() {
        return this.city;
    }
    
    
    
    /*
     * @return 
     */
    public String getStationsState() {
        return this.stationsState;
    }
    
    
    
    /*
     * @return 
     */
    public String getStation() {
        return this.station;
    }
    
    
    
    /*
     * @return 
     */
    public String getDate() {
        return this.date;
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
		return "Report[" +weatherConditions+", "+city+", "+stationsState+", "+station+", "+date+", "+data+"]";
	}
	
	/**
	 * Internal constructor to create a Report from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Report(JSONObject json_data) {
        try {// Weather Conditions
            this.weatherConditions = new ArrayList<WeatherConditions>();
            Iterator<Object> weatherConditionsIter = ((List<Object>)json_data.get("Weather Conditions")).iterator();
            while (weatherConditionsIter.hasNext()) {
                this.weatherConditions.add(new WeatherConditions((JSONObject)weatherConditionsIter.next()));
            }// City
            this.city = (String)json_data.get("City");// Station's State
            this.stationsState = (String)json_data.get("Station's State");// Station
            this.station = (String)json_data.get("Station");// Date
            this.date = (String)json_data.get("Date");// Data
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