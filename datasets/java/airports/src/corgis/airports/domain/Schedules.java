package corgis.airports.domain;

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
public class Schedules {
	
    private String attendanceschedule;
    private String sequencenumber;
    
    
    /*
     * @return 
     */
    public String getAttendanceschedule() {
        return this.attendanceschedule;
    }
    
    
    
    /*
     * @return 
     */
    public String getSequencenumber() {
        return this.sequencenumber;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Schedules.
	
	 * @return String
	 */
	public String toString() {
		return "Schedules[" +attendanceschedule+", "+sequencenumber+"]";
	}
	
	/**
	 * Internal constructor to create a Schedules from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Schedules(JSONObject json_data) {
        try {// AttendanceSchedule
            this.attendanceschedule = (String)json_data.get("AttendanceSchedule");// SequenceNumber
            this.sequencenumber = (String)json_data.get("SequenceNumber");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Schedules; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Schedules; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}