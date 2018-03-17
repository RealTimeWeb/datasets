package corgis.education.domain;

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
public class Score {
	
    private ArrayList<Math> math;
    private ArrayList<Reading> reading;
    private ArrayList<Science> science;
    private ArrayList<Writing> writing;
    
    
    /**
     * 
     * @return ArrayList<Math>
     */
    public ArrayList<Math> getMath() {
        return this.math;
    }
    
    
    
    /**
     * 
     * @return ArrayList<Reading>
     */
    public ArrayList<Reading> getReading() {
        return this.reading;
    }
    
    
    
    /**
     * 
     * @return ArrayList<Science>
     */
    public ArrayList<Science> getScience() {
        return this.science;
    }
    
    
    
    /**
     * 
     * @return ArrayList<Writing>
     */
    public ArrayList<Writing> getWriting() {
        return this.writing;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Score.
	
	 * @return String
	 */
	public String toString() {
		return "Score[" +math+", "+reading+", "+science+", "+writing+"]";
	}
	
	/**
	 * Internal constructor to create a Score from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Score(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // math
            this.math = new ArrayList<Math>();
            Iterator<Object> mathIter = ((List<Object>)json_data.get("math")).iterator();
            while (mathIter.hasNext()) {
                this.math.add(new Math((JSONObject)mathIter.next()));
            }
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Score; the field math was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Score; the field math had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // reading
            this.reading = new ArrayList<Reading>();
            Iterator<Object> readingIter = ((List<Object>)json_data.get("reading")).iterator();
            while (readingIter.hasNext()) {
                this.reading.add(new Reading((JSONObject)readingIter.next()));
            }
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Score; the field reading was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Score; the field reading had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // science
            this.science = new ArrayList<Science>();
            Iterator<Object> scienceIter = ((List<Object>)json_data.get("science")).iterator();
            while (scienceIter.hasNext()) {
                this.science.add(new Science((JSONObject)scienceIter.next()));
            }
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Score; the field science was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Score; the field science had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // writing
            this.writing = new ArrayList<Writing>();
            Iterator<Object> writingIter = ((List<Object>)json_data.get("writing")).iterator();
            while (writingIter.hasNext()) {
                this.writing.add(new Writing((JSONObject)writingIter.next()));
            }
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Score; the field writing was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Score; the field writing had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}