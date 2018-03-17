package corgis.supreme_court.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.supreme_court.domain.Voting;
import corgis.supreme_court.domain.Id;
import corgis.supreme_court.domain.LowerCourt;
import corgis.supreme_court.domain.Laws;
import corgis.supreme_court.domain.Citation;
import corgis.supreme_court.domain.Issue;
import corgis.supreme_court.domain.Origin;
import corgis.supreme_court.domain.NaturalCourt;
import corgis.supreme_court.domain.Arguments;
import corgis.supreme_court.domain.Decision;
import corgis.supreme_court.domain.Source;

/**
 * 
 */
public class CourtCase {
	
    private Voting voting;
    private Id id;
    private LowerCourt lowerCourt;
    private Laws laws;
    private Citation citation;
    private Issue issue;
    private Origin origin;
    private NaturalCourt naturalCourt;
    private String name;
    private Integer docket;
    private Arguments arguments;
    private Decision decision;
    private Source source;
    private Boolean threeJudgeDc;
    
    
    /**
     * 
     * @return Voting
     */
    public Voting getVoting() {
        return this.voting;
    }
    
    
    
    /**
     * 
     * @return Id
     */
    public Id getId() {
        return this.id;
    }
    
    
    
    /**
     * 
     * @return LowerCourt
     */
    public LowerCourt getLowerCourt() {
        return this.lowerCourt;
    }
    
    
    
    /**
     * 
     * @return Laws
     */
    public Laws getLaws() {
        return this.laws;
    }
    
    
    
    /**
     * 
     * @return Citation
     */
    public Citation getCitation() {
        return this.citation;
    }
    
    
    
    /**
     * 
     * @return Issue
     */
    public Issue getIssue() {
        return this.issue;
    }
    
    
    
    /**
     * 
     * @return Origin
     */
    public Origin getOrigin() {
        return this.origin;
    }
    
    
    
    /**
     * 
     * @return NaturalCourt
     */
    public NaturalCourt getNaturalCourt() {
        return this.naturalCourt;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getName() {
        return this.name;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getDocket() {
        return this.docket;
    }
    
    
    
    /**
     * 
     * @return Arguments
     */
    public Arguments getArguments() {
        return this.arguments;
    }
    
    
    
    /**
     * 
     * @return Decision
     */
    public Decision getDecision() {
        return this.decision;
    }
    
    
    
    /**
     * 
     * @return Source
     */
    public Source getSource() {
        return this.source;
    }
    
    
    
    /**
     * 
     * @return Boolean
     */
    public Boolean getThreeJudgeDc() {
        return this.threeJudgeDc;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this CourtCase.
	
	 * @return String
	 */
	public String toString() {
		return "CourtCase[" +voting+", "+id+", "+lowerCourt+", "+laws+", "+citation+", "+issue+", "+origin+", "+naturalCourt+", "+name+", "+docket+", "+arguments+", "+decision+", "+source+", "+threeJudgeDc+"]";
	}
	
	/**
	 * Internal constructor to create a CourtCase from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public CourtCase(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // voting
            this.voting = new Voting((JSONObject)json_data.get("voting"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a CourtCase; the field voting was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a CourtCase; the field voting had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // id
            this.id = new Id((JSONObject)json_data.get("id"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a CourtCase; the field id was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a CourtCase; the field id had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // lower court
            this.lowerCourt = new LowerCourt((JSONObject)json_data.get("lower court"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a CourtCase; the field lowerCourt was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a CourtCase; the field lowerCourt had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // laws
            this.laws = new Laws((JSONObject)json_data.get("laws"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a CourtCase; the field laws was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a CourtCase; the field laws had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // citation
            this.citation = new Citation((JSONObject)json_data.get("citation"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a CourtCase; the field citation was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a CourtCase; the field citation had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // issue
            this.issue = new Issue((JSONObject)json_data.get("issue"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a CourtCase; the field issue was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a CourtCase; the field issue had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // origin
            this.origin = new Origin((JSONObject)json_data.get("origin"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a CourtCase; the field origin was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a CourtCase; the field origin had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // natural court
            this.naturalCourt = new NaturalCourt((JSONObject)json_data.get("natural court"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a CourtCase; the field naturalCourt was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a CourtCase; the field naturalCourt had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // name
            this.name = (String)json_data.get("name");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a CourtCase; the field name was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a CourtCase; the field name had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // docket
            this.docket = ((Number)json_data.get("docket")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a CourtCase; the field docket was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a CourtCase; the field docket had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // arguments
            this.arguments = new Arguments((JSONObject)json_data.get("arguments"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a CourtCase; the field arguments was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a CourtCase; the field arguments had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // decision
            this.decision = new Decision((JSONObject)json_data.get("decision"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a CourtCase; the field decision was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a CourtCase; the field decision had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // source
            this.source = new Source((JSONObject)json_data.get("source"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a CourtCase; the field source was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a CourtCase; the field source had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // 3 judge dc?
            this.threeJudgeDc = (Boolean)json_data.get("3 judge dc?");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a CourtCase; the field threeJudgeDc was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a CourtCase; the field threeJudgeDc had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}