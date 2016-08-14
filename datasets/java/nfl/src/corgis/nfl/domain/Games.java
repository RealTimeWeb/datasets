package corgis.nfl.domain;

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
public class Games {
	
    private String home_Team;
    private String away_Team;
    private Integer temperature;
    private Integer wind_Chill;
    private Integer humidity;
    private String weather;
    private Integer home_Score;
    private String date;
    private Integer away_Score;
    private String id;
    private Integer wind_Mph;
    
    
    /*
     * @return 
     */
    public String getHome_Team() {
        return this.home_Team;
    }
    
    
    
    /*
     * @return 
     */
    public String getAway_Team() {
        return this.away_Team;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getTemperature() {
        return this.temperature;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getWind_Chill() {
        return this.wind_Chill;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getHumidity() {
        return this.humidity;
    }
    
    
    
    /*
     * @return 
     */
    public String getWeather() {
        return this.weather;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getHome_Score() {
        return this.home_Score;
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
    public Integer getAway_Score() {
        return this.away_Score;
    }
    
    
    
    /*
     * @return 
     */
    public String getId() {
        return this.id;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getWind_Mph() {
        return this.wind_Mph;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Games.
	
	 * @return String
	 */
	public String toString() {
		return "Games[" +home_Team+", "+away_Team+", "+temperature+", "+wind_Chill+", "+humidity+", "+weather+", "+home_Score+", "+date+", "+away_Score+", "+id+", "+wind_Mph+"]";
	}
	
	/**
	 * Internal constructor to create a Games from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Games(JSONObject json_data) {
        try {// home_team
            this.home_Team = (String)json_data.get("home_team");// away_team
            this.away_Team = (String)json_data.get("away_team");// temperature
            this.temperature = new Integer(((Long)json_data.get("temperature")).intValue());// wind_chill
            this.wind_Chill = new Integer(((Long)json_data.get("wind_chill")).intValue());// humidity
            this.humidity = new Integer(((Long)json_data.get("humidity")).intValue());// weather
            this.weather = (String)json_data.get("weather");// home_score
            this.home_Score = new Integer(((Long)json_data.get("home_score")).intValue());// date
            this.date = (String)json_data.get("date");// away_score
            this.away_Score = new Integer(((Long)json_data.get("away_score")).intValue());// id
            this.id = (String)json_data.get("id");// wind_mph
            this.wind_Mph = new Integer(((Long)json_data.get("wind_mph")).intValue());
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Games; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Games; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}