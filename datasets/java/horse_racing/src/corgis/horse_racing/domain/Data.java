package corgis.horse_racing.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.horse_racing.domain.Onezero;
import corgis.horse_racing.domain.One;
import corgis.horse_racing.domain.Three;
import corgis.horse_racing.domain.Two;
import corgis.horse_racing.domain.Five;
import corgis.horse_racing.domain.Four;
import corgis.horse_racing.domain.Seven;
import corgis.horse_racing.domain.Six;
import corgis.horse_racing.domain.Nine;
import corgis.horse_racing.domain.Eight;

/**
 * 
 */
public class Data {
	
    private Onezero onezero;
    private One one;
    private Three three;
    private Two two;
    private Five five;
    private Four four;
    private Seven seven;
    private Six six;
    private Nine nine;
    private Eight eight;
    
    
    /*
     * @return 
     */
    public Onezero getOnezero() {
        return this.onezero;
    }
    
    
    
    /*
     * @return 
     */
    public One getOne() {
        return this.one;
    }
    
    
    
    /*
     * @return 
     */
    public Three getThree() {
        return this.three;
    }
    
    
    
    /*
     * @return 
     */
    public Two getTwo() {
        return this.two;
    }
    
    
    
    /*
     * @return 
     */
    public Five getFive() {
        return this.five;
    }
    
    
    
    /*
     * @return 
     */
    public Four getFour() {
        return this.four;
    }
    
    
    
    /*
     * @return 
     */
    public Seven getSeven() {
        return this.seven;
    }
    
    
    
    /*
     * @return 
     */
    public Six getSix() {
        return this.six;
    }
    
    
    
    /*
     * @return 
     */
    public Nine getNine() {
        return this.nine;
    }
    
    
    
    /*
     * @return 
     */
    public Eight getEight() {
        return this.eight;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Data.
	
	 * @return String
	 */
	public String toString() {
		return "Data[" +onezero+", "+one+", "+three+", "+two+", "+five+", "+four+", "+seven+", "+six+", "+nine+", "+eight+"]";
	}
	
	/**
	 * Internal constructor to create a Data from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Data(JSONObject json_data) {
        try {// 10
            this.onezero = new Onezero((JSONObject)json_data.get("10"));// 1
            this.one = new One((JSONObject)json_data.get("1"));// 3
            this.three = new Three((JSONObject)json_data.get("3"));// 2
            this.two = new Two((JSONObject)json_data.get("2"));// 5
            this.five = new Five((JSONObject)json_data.get("5"));// 4
            this.four = new Four((JSONObject)json_data.get("4"));// 7
            this.seven = new Seven((JSONObject)json_data.get("7"));// 6
            this.six = new Six((JSONObject)json_data.get("6"));// 9
            this.nine = new Nine((JSONObject)json_data.get("9"));// 8
            this.eight = new Eight((JSONObject)json_data.get("8"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}