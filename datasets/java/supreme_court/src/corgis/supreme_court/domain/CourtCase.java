package corgis.supreme_court.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.supreme_court.domain.Origin;
import corgis.supreme_court.domain.LowerCourt;
import corgis.supreme_court.domain.Decision;
import corgis.supreme_court.domain.Citation;
import corgis.supreme_court.domain.NaturalCourt;
import corgis.supreme_court.domain.Source;
import corgis.supreme_court.domain.Arguments;
import corgis.supreme_court.domain.Voting;
import corgis.supreme_court.domain.Issue;
import corgis.supreme_court.domain.Id;
import corgis.supreme_court.domain.Laws;

/**
 * 
 */
public class CourtCase {
	
    private Origin origin;
    private LowerCourt lowerCourt;
    private String name;
    private Boolean threeJudgeDc;
    private Integer docket;
    private Decision decision;
    private Citation citation;
    private NaturalCourt naturalCourt;
    private Source source;
    private Arguments arguments;
    private Voting voting;
    private Issue issue;
    private Id id;
    private Laws laws;
    
    
    /*
     * @return 
     */
    public Origin getOrigin() {
        return this.origin;
    }
    
    
    
    /*
     * @return 
     */
    public LowerCourt getLowerCourt() {
        return this.lowerCourt;
    }
    
    
    
    /*
     * @return 
     */
    public String getName() {
        return this.name;
    }
    
    
    
    /*
     * @return 
     */
    public Boolean getThreeJudgeDc() {
        return this.threeJudgeDc;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getDocket() {
        return this.docket;
    }
    
    
    
    /*
     * @return 
     */
    public Decision getDecision() {
        return this.decision;
    }
    
    
    
    /*
     * @return 
     */
    public Citation getCitation() {
        return this.citation;
    }
    
    
    
    /*
     * @return 
     */
    public NaturalCourt getNaturalCourt() {
        return this.naturalCourt;
    }
    
    
    
    /*
     * @return 
     */
    public Source getSource() {
        return this.source;
    }
    
    
    
    /*
     * @return 
     */
    public Arguments getArguments() {
        return this.arguments;
    }
    
    
    
    /*
     * @return 
     */
    public Voting getVoting() {
        return this.voting;
    }
    
    
    
    /*
     * @return 
     */
    public Issue getIssue() {
        return this.issue;
    }
    
    
    
    /*
     * @return 
     */
    public Id getId() {
        return this.id;
    }
    
    
    
    /*
     * @return 
     */
    public Laws getLaws() {
        return this.laws;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this CourtCase.
	
	 * @return String
	 */
	public String toString() {
		return "CourtCase[" +origin+", "+lowerCourt+", "+name+", "+threeJudgeDc+", "+docket+", "+decision+", "+citation+", "+naturalCourt+", "+source+", "+arguments+", "+voting+", "+issue+", "+id+", "+laws+"]";
	}
	
	/**
	 * Internal constructor to create a CourtCase from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public CourtCase(JSONObject json_data) {
        try {// origin
            this.origin = new Origin((JSONObject)json_data.get("origin"));// lower court
            this.lowerCourt = new LowerCourt((JSONObject)json_data.get("lower court"));// name
            this.name = (String)json_data.get("name");// 3 judge dc?
            this.threeJudgeDc = (Boolean)json_data.get("3 judge dc?");// docket
            this.docket = new Integer(((Long)json_data.get("docket")).intValue());// decision
            this.decision = new Decision((JSONObject)json_data.get("decision"));// citation
            this.citation = new Citation((JSONObject)json_data.get("citation"));// natural court
            this.naturalCourt = new NaturalCourt((JSONObject)json_data.get("natural court"));// source
            this.source = new Source((JSONObject)json_data.get("source"));// arguments
            this.arguments = new Arguments((JSONObject)json_data.get("arguments"));// voting
            this.voting = new Voting((JSONObject)json_data.get("voting"));// issue
            this.issue = new Issue((JSONObject)json_data.get("issue"));// id
            this.id = new Id((JSONObject)json_data.get("id"));// laws
            this.laws = new Laws((JSONObject)json_data.get("laws"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a CourtCase; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a CourtCase; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}