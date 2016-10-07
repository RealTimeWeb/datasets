package corgis.horse_racing.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.horse_racing.domain.SecondPlace;
import corgis.horse_racing.domain.Exacta;
import corgis.horse_racing.domain.DailyDouble;
import corgis.horse_racing.domain.Superfecta;
import corgis.horse_racing.domain.FirstPlace;
import corgis.horse_racing.domain.ThirdPlace;

/**
 * 
 */
public class Fourth {
	
    private ArrayList<String> scratched;
    private ArrayList<AlsoRans> alsoRans;
    private String trifecta;
    private SecondPlace secondPlace;
    private Exacta exacta;
    private DailyDouble dailyDouble;
    private Superfecta superfecta;
    private FirstPlace firstPlace;
    private ThirdPlace thirdPlace;
    
    
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
    public SecondPlace getSecondPlace() {
        return this.secondPlace;
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
    public DailyDouble getDailyDouble() {
        return this.dailyDouble;
    }
    
    
    
    /*
     * @return 
     */
    public Superfecta getSuperfecta() {
        return this.superfecta;
    }
    
    
    
    /*
     * @return 
     */
    public FirstPlace getFirstPlace() {
        return this.firstPlace;
    }
    
    
    
    /*
     * @return 
     */
    public ThirdPlace getThirdPlace() {
        return this.thirdPlace;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Fourth.
	
	 * @return String
	 */
	public String toString() {
		return "Fourth[" +scratched+", "+alsoRans+", "+trifecta+", "+secondPlace+", "+exacta+", "+dailyDouble+", "+superfecta+", "+firstPlace+", "+thirdPlace+"]";
	}
	
	/**
	 * Internal constructor to create a Fourth from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Fourth(JSONObject json_data) {
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
            this.trifecta = (String)json_data.get("trifecta");// second place
            this.secondPlace = new SecondPlace((JSONObject)json_data.get("second place"));// exacta
            this.exacta = new Exacta((JSONObject)json_data.get("exacta"));// daily double
            this.dailyDouble = new DailyDouble((JSONObject)json_data.get("daily double"));// superfecta
            this.superfecta = new Superfecta((JSONObject)json_data.get("superfecta"));// first place
            this.firstPlace = new FirstPlace((JSONObject)json_data.get("first place"));// third place
            this.thirdPlace = new ThirdPlace((JSONObject)json_data.get("third place"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Fourth; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Fourth; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}