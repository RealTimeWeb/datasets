package corgis.horseracing.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.horseracing.domain.Third;
import corgis.horseracing.domain.Pick_Three;
import corgis.horseracing.domain.Exacta;
import corgis.horseracing.domain.Daily_Double;
import corgis.horseracing.domain.Second;
import corgis.horseracing.domain.First;

/**
 * 
 */
public class Three {
	
    private ArrayList<String> scratched;
    private ArrayList<AlsoRans> alsoRans;
    private String trifecta;
    private Third third;
    private Pick_Three pick_Three;
    private Exacta exacta;
    private Daily_Double daily_Double;
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
    public String getTrifecta() {
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
    public Pick_Three getPick_Three() {
        return this.pick_Three;
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
    public Daily_Double getDaily_Double() {
        return this.daily_Double;
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
	 * Creates a string based representation of this 3.
	
	 * @return String
	 */
	public String toString() {
		return "3[" +scratched+", "+alsoRans+", "+trifecta+", "+third+", "+pick_Three+", "+exacta+", "+daily_Double+", "+second+", "+superfecta+", "+first+"]";
	}
	
	/**
	 * Internal constructor to create a 3 from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Three(JSONObject json_data) {
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
            this.trifecta = (String)json_data.get("trifecta");// third
            this.third = new Third((JSONObject)json_data.get("third"));// pick_3
            this.pick_Three = new Pick_Three((JSONObject)json_data.get("pick_3"));// exacta
            this.exacta = new Exacta((JSONObject)json_data.get("exacta"));// daily_double
            this.daily_Double = new Daily_Double((JSONObject)json_data.get("daily_double"));// second
            this.second = new Second((JSONObject)json_data.get("second"));// superfecta
            this.superfecta = (String)json_data.get("superfecta");// first
            this.first = new First((JSONObject)json_data.get("first"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a 3; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a 3; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}