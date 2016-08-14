package corgis.broadway.domain;

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
public class Production {
	
    private Integer gross;
    private Integer attendance;
    // The percentage of how well the theatre was filled.
    private String capacity;
    // The name of the theatre.
    private String theatre;
    private String show;
    // The total number of performances of this showing.
    private Integer performances;
    private Integer previews;
    private Integer year;
    // The total number of people who can fit in this theatre.
    private String date;
    private Integer month;
    private Integer day;
    
    
    /*
     * @return 
     */
    public Integer getGross() {
        return this.gross;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getAttendance() {
        return this.attendance;
    }
    
    
    
    /*
     * @return 
     */
    public String getCapacity() {
        return this.capacity;
    }
    
    
    
    /*
     * @return 
     */
    public String getTheatre() {
        return this.theatre;
    }
    
    
    
    /*
     * @return 
     */
    public String getShow() {
        return this.show;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getPerformances() {
        return this.performances;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getPreviews() {
        return this.previews;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getYear() {
        return this.year;
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
    public Integer getMonth() {
        return this.month;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getDay() {
        return this.day;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Production.
	
	 * @return String
	 */
	public String toString() {
		return "Production[" +gross+", "+attendance+", "+capacity+", "+theatre+", "+show+", "+performances+", "+previews+", "+year+", "+date+", "+month+", "+day+"]";
	}
	
	/**
	 * Internal constructor to create a Production from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Production(JSONObject json_data) {
        try {// gross
            this.gross = new Integer(((Long)json_data.get("gross")).intValue());// attendance
            this.attendance = new Integer(((Long)json_data.get("attendance")).intValue());// capacity
            this.capacity = (String)json_data.get("capacity");// theatre
            this.theatre = (String)json_data.get("theatre");// show
            this.show = (String)json_data.get("show");// performances
            this.performances = new Integer(((Long)json_data.get("performances")).intValue());// previews
            this.previews = new Integer(((Long)json_data.get("previews")).intValue());// year
            this.year = new Integer(((Long)json_data.get("year")).intValue());// date
            this.date = (String)json_data.get("date");// month
            this.month = new Integer(((Long)json_data.get("month")).intValue());// day
            this.day = new Integer(((Long)json_data.get("day")).intValue());
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Production; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Production; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}