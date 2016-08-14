package corgis.nfl.domain;

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
public class Players {
	
    private Integer pickround;
    private Integer weight;
    private String college;
    private Integer year;
    private Double fortyyd;
    private String firstname;
    private Integer broad;
    private Integer picktotal;
    private Double arms;
    private Integer bench;
    private Integer wonderlic;
    private Double twentyss;
    private Double tenyd;
    private Double heightinches;
    private Double vertical;
    private Integer heightfeet;
    private String lastname;
    private Double nflgrade;
    private Double threecone;
    private Double hands;
    private String name;
    private Double twentyyd;
    private Integer pick;
    private Double heightinchestotal;
    private String position;
    private Integer round;
    
    
    /*
     * @return 
     */
    public Integer getPickround() {
        return this.pickround;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getWeight() {
        return this.weight;
    }
    
    
    
    /*
     * @return 
     */
    public String getCollege() {
        return this.college;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getYear() {
        return this.year;
    }
    
    
    
    /*
     * @return 
     */
    public Double getFortyyd() {
        return this.fortyyd;
    }
    
    
    
    /*
     * @return 
     */
    public String getFirstname() {
        return this.firstname;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getBroad() {
        return this.broad;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getPicktotal() {
        return this.picktotal;
    }
    
    
    
    /*
     * @return 
     */
    public Double getArms() {
        return this.arms;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getBench() {
        return this.bench;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getWonderlic() {
        return this.wonderlic;
    }
    
    
    
    /*
     * @return 
     */
    public Double getTwentyss() {
        return this.twentyss;
    }
    
    
    
    /*
     * @return 
     */
    public Double getTenyd() {
        return this.tenyd;
    }
    
    
    
    /*
     * @return 
     */
    public Double getHeightinches() {
        return this.heightinches;
    }
    
    
    
    /*
     * @return 
     */
    public Double getVertical() {
        return this.vertical;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getHeightfeet() {
        return this.heightfeet;
    }
    
    
    
    /*
     * @return 
     */
    public String getLastname() {
        return this.lastname;
    }
    
    
    
    /*
     * @return 
     */
    public Double getNflgrade() {
        return this.nflgrade;
    }
    
    
    
    /*
     * @return 
     */
    public Double getThreecone() {
        return this.threecone;
    }
    
    
    
    /*
     * @return 
     */
    public Double getHands() {
        return this.hands;
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
    public Double getTwentyyd() {
        return this.twentyyd;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getPick() {
        return this.pick;
    }
    
    
    
    /*
     * @return 
     */
    public Double getHeightinchestotal() {
        return this.heightinchestotal;
    }
    
    
    
    /*
     * @return 
     */
    public String getPosition() {
        return this.position;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getRound() {
        return this.round;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Players.
	
	 * @return String
	 */
	public String toString() {
		return "Players[" +pickround+", "+weight+", "+college+", "+year+", "+fortyyd+", "+firstname+", "+broad+", "+picktotal+", "+arms+", "+bench+", "+wonderlic+", "+twentyss+", "+tenyd+", "+heightinches+", "+vertical+", "+heightfeet+", "+lastname+", "+nflgrade+", "+threecone+", "+hands+", "+name+", "+twentyyd+", "+pick+", "+heightinchestotal+", "+position+", "+round+"]";
	}
	
	/**
	 * Internal constructor to create a Players from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Players(JSONObject json_data) {
        try {// pickround
            this.pickround = new Integer(((Long)json_data.get("pickround")).intValue());// weight
            this.weight = new Integer(((Long)json_data.get("weight")).intValue());// college
            this.college = (String)json_data.get("college");// year
            this.year = new Integer(((Long)json_data.get("year")).intValue());// fortyyd
            this.fortyyd = (Double)json_data.get("fortyyd");// firstname
            this.firstname = (String)json_data.get("firstname");// broad
            this.broad = new Integer(((Long)json_data.get("broad")).intValue());// picktotal
            this.picktotal = new Integer(((Long)json_data.get("picktotal")).intValue());// arms
            this.arms = (Double)json_data.get("arms");// bench
            this.bench = new Integer(((Long)json_data.get("bench")).intValue());// wonderlic
            this.wonderlic = new Integer(((Long)json_data.get("wonderlic")).intValue());// twentyss
            this.twentyss = (Double)json_data.get("twentyss");// tenyd
            this.tenyd = (Double)json_data.get("tenyd");// heightinches
            this.heightinches = (Double)json_data.get("heightinches");// vertical
            this.vertical = (Double)json_data.get("vertical");// heightfeet
            this.heightfeet = new Integer(((Long)json_data.get("heightfeet")).intValue());// lastname
            this.lastname = (String)json_data.get("lastname");// nflgrade
            this.nflgrade = (Double)json_data.get("nflgrade");// threecone
            this.threecone = (Double)json_data.get("threecone");// hands
            this.hands = (Double)json_data.get("hands");// name
            this.name = (String)json_data.get("name");// twentyyd
            this.twentyyd = (Double)json_data.get("twentyyd");// pick
            this.pick = new Integer(((Long)json_data.get("pick")).intValue());// heightinchestotal
            this.heightinchestotal = (Double)json_data.get("heightinchestotal");// position
            this.position = (String)json_data.get("position");// round
            this.round = new Integer(((Long)json_data.get("round")).intValue());
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Players; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Players; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}