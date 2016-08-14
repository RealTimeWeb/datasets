package corgis.supremecourt.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.supremecourt.domain.MajorityAssigner;
import corgis.supremecourt.domain.MajorityWriter;

/**
 * 
 */
public class Voting {
	
    private Boolean unclear;
    private Integer minority;
    private Integer majority;
    private MajorityAssigner majorityAssigner;
    private MajorityWriter majorityWriter;
    private Boolean splitOnSecond;
    
    
    /*
     * @return 
     */
    public Boolean getUnclear() {
        return this.unclear;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getMinority() {
        return this.minority;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getMajority() {
        return this.majority;
    }
    
    
    
    /*
     * @return 
     */
    public MajorityAssigner getMajorityAssigner() {
        return this.majorityAssigner;
    }
    
    
    
    /*
     * @return 
     */
    public MajorityWriter getMajorityWriter() {
        return this.majorityWriter;
    }
    
    
    
    /*
     * @return 
     */
    public Boolean getSplitOnSecond() {
        return this.splitOnSecond;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Voting.
	
	 * @return String
	 */
	public String toString() {
		return "Voting[" +unclear+", "+minority+", "+majority+", "+majorityAssigner+", "+majorityWriter+", "+splitOnSecond+"]";
	}
	
	/**
	 * Internal constructor to create a Voting from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Voting(JSONObject json_data) {
        try {// unclear
            this.unclear = (Boolean)json_data.get("unclear");// minority
            this.minority = new Integer(((Long)json_data.get("minority")).intValue());// majority
            this.majority = new Integer(((Long)json_data.get("majority")).intValue());// majority assigner
            this.majorityAssigner = new MajorityAssigner((JSONObject)json_data.get("majority assigner"));// majority writer
            this.majorityWriter = new MajorityWriter((JSONObject)json_data.get("majority writer"));// split on second
            this.splitOnSecond = (Boolean)json_data.get("split on second");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Voting; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Voting; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}