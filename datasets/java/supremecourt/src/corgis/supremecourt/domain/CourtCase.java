package corgis.supremecourt.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.supremecourt.domain.Origin;
import corgis.supremecourt.domain.Voting;
import corgis.supremecourt.domain.LowerCourt;
import corgis.supremecourt.domain.Laws;
import corgis.supremecourt.domain.Issue;
import corgis.supremecourt.domain.Decision;
import corgis.supremecourt.domain.Citation;
import corgis.supremecourt.domain.NaturalCourt;
import corgis.supremecourt.domain.Source;
import corgis.supremecourt.domain.Arguments;
import corgis.supremecourt.domain.Id;

/**
 * 
 */
public class CourtCase {
	
    private Origin origin;
    private Voting voting;
    private LowerCourt lowerCourt;
    private Laws laws;
    private Issue issue;
    private Decision decision;
    private Citation citation;
    private NaturalCourt naturalCourt;
    private Source source;
    private Arguments arguments;
    private Boolean threeJudgeDc;
    private Integer docket;
    private Id id;
    private String name;
    
    
    /*
     * @return 
     */
    public Origin getOrigin() {
        return this.origin;
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
    public LowerCourt getLowerCourt() {
        return this.lowerCourt;
    }
    
    
    
    /*
     * @return 
     */
    public Laws getLaws() {
        return this.laws;
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
    public Id getId() {
        return this.id;
    }
    
    
    
    /*
     * @return 
     */
    public String getName() {
        return this.name;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this CourtCase.
	
	 * @return String
	 */
	public String toString() {
		return "CourtCase[" +origin+", "+voting+", "+lowerCourt+", "+laws+", "+issue+", "+decision+", "+citation+", "+naturalCourt+", "+source+", "+arguments+", "+threeJudgeDc+", "+docket+", "+id+", "+name+"]";
	}
	
	/**
	 * Internal constructor to create a CourtCase from a  representation.
	 * @param map The raw json data that will be parsed.
	 * @return 
	 */
    public CourtCase(JSONObject json_data) {
        try {// origin
            this.origin = new Origin((JSONObject)json_data.get("origin"));// voting
            this.voting = new Voting((JSONObject)json_data.get("voting"));// lower court
            this.lowerCourt = new LowerCourt((JSONObject)json_data.get("lower court"));// laws
            this.laws = new Laws((JSONObject)json_data.get("laws"));// issue
            this.issue = new Issue((JSONObject)json_data.get("issue"));// decision
            this.decision = new Decision((JSONObject)json_data.get("decision"));// citation
            this.citation = new Citation((JSONObject)json_data.get("citation"));// natural court
            this.naturalCourt = new NaturalCourt((JSONObject)json_data.get("natural court"));// source
            this.source = new Source((JSONObject)json_data.get("source"));// arguments
            this.arguments = new Arguments((JSONObject)json_data.get("arguments"));// 3 judge dc?
            this.threeJudgeDc = (Boolean)json_data.get("3 judge dc?");// docket
            this.docket = new Integer(((Long)json_data.get("docket")).intValue());// id
            this.id = new Id((JSONObject)json_data.get("id"));// name
            this.name = (String)json_data.get("name");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a CourtCase; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a CourtCase; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}