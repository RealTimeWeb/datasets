package corgis.horse_racing.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.horse_racing.domain.Trifecta;
import corgis.horse_racing.domain.Third;
import corgis.horse_racing.domain.Daily_Double;
import corgis.horse_racing.domain.Exacta;
import corgis.horse_racing.domain.Second;
import corgis.horse_racing.domain.First;

/**
 * 
 */
public class Nine {
	
    private ArrayList<String> scratched;
    private ArrayList<AlsoRans> alsoRans;
    private Trifecta trifecta;
    private Third third;
    private Daily_Double daily_Double;
    private Exacta exacta;
    private Second second;
    private String superfecta;
    private First first;
    
    
    /*
     * @return 
     */
    public ArrayList<String> getScratched() {
        return this.scratched;
    }
    
    
    
    /*
     * @return 
     */
    public ArrayList<AlsoRans> getAlsoRans() {
        return this.alsoRans;
    }
    
    
    
    /*
     * @return 
     */
    public Trifecta getTrifecta() {
        return this.trifecta;
    }
    
    
    
    /*
     * @return 
     */
    public Third getThird() {
        return this.third;
    }
    
    
    
    /*
     * @return 
     */
    public Daily_Double getDaily_Double() {
        return this.daily_Double;
    }
    
    
    
    /*
     * @return 
     */
    public Exacta getExacta() {
        return this.exacta;
    }
    
    
    
    /*
     * @return 
     */
    public Second getSecond() {
        return this.second;
    }
    
    
    
    /*
     * @return 
     */
    public String getSuperfecta() {
        return this.superfecta;
    }
    
    
    
    /*
     * @return 
     */
    public First getFirst() {
        return this.first;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this 9.
	
	 * @return String
	 */
	public String toString() {
		return "9[" +scratched+", "+alsoRans+", "+trifecta+", "+third+", "+daily_Double+", "+exacta+", "+second+", "+superfecta+", "+first+"]";
	}
	
	/**
	 * Internal constructor to create a 9 from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Nine(JSONObject json_data) {
        try {// scratched
            this.scratched = new ArrayList<String>();
            Iterator<Object> scratchedIter = ((List<Object>)json_data.get("scratched")).iterator();
            while (scratchedIter.hasNext()) {
                this.scratched.add(new String((String)scratchedIter.next()));
            }// also-rans
            this.alsoRans = new ArrayList<AlsoRans>();
            Iterator<Object> alsoRansIter = ((List<Object>)json_data.get("also rans")).iterator();
            while (alsoRansIter.hasNext()) {
                this.alsoRans.add(new AlsoRans((JSONObject)alsoRansIter.next()));
            }// trifecta
            this.trifecta = new Trifecta((JSONObject)json_data.get("trifecta"));// third
            this.third = new Third((JSONObject)json_data.get("third"));// daily_double
            this.daily_Double = new Daily_Double((JSONObject)json_data.get("daily_double"));// exacta
            this.exacta = new Exacta((JSONObject)json_data.get("exacta"));// second
            this.second = new Second((JSONObject)json_data.get("second"));// superfecta
            this.superfecta = (String)json_data.get("superfecta");// first
            this.first = new First((JSONObject)json_data.get("first"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a 9; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a 9; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}