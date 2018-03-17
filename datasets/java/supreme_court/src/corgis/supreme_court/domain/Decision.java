package corgis.supreme_court.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.supreme_court.domain.AdminAction;
import corgis.supreme_court.domain.Date;
import corgis.supreme_court.domain.Case_;

/**
 * 
 */
public class Decision {
	
    private String winningParty;
    private String direction;
    private Integer term;
    private String unconstitutional;
    private AdminAction adminAction;
    private String authorityOne;
    private Date date;
    private Boolean precedentAltered;
    private String type;
    private Boolean dissentAgrees;
    private String jurisdiction;
    private String authorityTwo;
    private Case_ case_;
    
    
    /**
     * 
     * @return String
     */
    public String getWinningParty() {
        return this.winningParty;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getDirection() {
        return this.direction;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getTerm() {
        return this.term;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getUnconstitutional() {
        return this.unconstitutional;
    }
    
    
    
    /**
     * 
     * @return AdminAction
     */
    public AdminAction getAdminAction() {
        return this.adminAction;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getAuthorityOne() {
        return this.authorityOne;
    }
    
    
    
    /**
     * 
     * @return Date
     */
    public Date getDate() {
        return this.date;
    }
    
    
    
    /**
     * 
     * @return Boolean
     */
    public Boolean getPrecedentAltered() {
        return this.precedentAltered;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getType() {
        return this.type;
    }
    
    
    
    /**
     * 
     * @return Boolean
     */
    public Boolean getDissentAgrees() {
        return this.dissentAgrees;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getJurisdiction() {
        return this.jurisdiction;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getAuthorityTwo() {
        return this.authorityTwo;
    }
    
    
    
    /**
     * 
     * @return Case_
     */
    public Case_ getCase_() {
        return this.case_;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Decision.
	
	 * @return String
	 */
	public String toString() {
		return "Decision[" +winningParty+", "+direction+", "+term+", "+unconstitutional+", "+adminAction+", "+authorityOne+", "+date+", "+precedentAltered+", "+type+", "+dissentAgrees+", "+jurisdiction+", "+authorityTwo+", "+case_+"]";
	}
	
	/**
	 * Internal constructor to create a Decision from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Decision(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // winning party
            this.winningParty = (String)json_data.get("winning party");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Decision; the field winningParty was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Decision; the field winningParty had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // direction
            this.direction = (String)json_data.get("direction");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Decision; the field direction was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Decision; the field direction had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // term
            this.term = ((Number)json_data.get("term")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Decision; the field term was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Decision; the field term had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // unconstitutional
            this.unconstitutional = (String)json_data.get("unconstitutional");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Decision; the field unconstitutional was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Decision; the field unconstitutional had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // admin action
            this.adminAction = new AdminAction((JSONObject)json_data.get("admin action"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Decision; the field adminAction was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Decision; the field adminAction had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // authority 1
            this.authorityOne = (String)json_data.get("authority 1");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Decision; the field authorityOne was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Decision; the field authorityOne had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // date
            this.date = new Date((JSONObject)json_data.get("date"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Decision; the field date was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Decision; the field date had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // precedent altered?
            this.precedentAltered = (Boolean)json_data.get("precedent altered?");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Decision; the field precedentAltered was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Decision; the field precedentAltered had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // type
            this.type = (String)json_data.get("type");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Decision; the field type was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Decision; the field type had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // dissent agrees
            this.dissentAgrees = (Boolean)json_data.get("dissent agrees");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Decision; the field dissentAgrees was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Decision; the field dissentAgrees had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // jurisdiction
            this.jurisdiction = (String)json_data.get("jurisdiction");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Decision; the field jurisdiction was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Decision; the field jurisdiction had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // authority 2
            this.authorityTwo = (String)json_data.get("authority 2");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Decision; the field authorityTwo was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Decision; the field authorityTwo had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // case
            this.case_ = new Case_((JSONObject)json_data.get("case"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Decision; the field case_ was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Decision; the field case_ had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}