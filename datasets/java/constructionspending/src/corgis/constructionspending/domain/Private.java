package corgis.constructionspending.domain;

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
public class Private {
	
    private Integer lodging;
    private Integer educational;
    private Integer totalConstruction;
    private Integer transportation;
    private Integer power;
    private Integer office;
    private Integer nonresidential;
    private Integer amusementAndRecreation;
    private Integer residential;
    private Integer publicSafety;
    private Integer conservationAndDevelopment;
    private Integer commercial;
    private Integer waterSupply;
    private Integer healthCare;
    private Integer sewageAndWasteDisposal;
    private Integer communication;
    private Integer manufacturing;
    private Integer religious;
    private Integer highwayAndStreet;
    
    
    /*
     * @return 
     */
    public Integer getLodging() {
        return this.lodging;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getEducational() {
        return this.educational;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getTotalConstruction() {
        return this.totalConstruction;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getTransportation() {
        return this.transportation;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getPower() {
        return this.power;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getOffice() {
        return this.office;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getNonresidential() {
        return this.nonresidential;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getAmusementAndRecreation() {
        return this.amusementAndRecreation;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getResidential() {
        return this.residential;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getPublicSafety() {
        return this.publicSafety;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getConservationAndDevelopment() {
        return this.conservationAndDevelopment;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getCommercial() {
        return this.commercial;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getWaterSupply() {
        return this.waterSupply;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getHealthCare() {
        return this.healthCare;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getSewageAndWasteDisposal() {
        return this.sewageAndWasteDisposal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getCommunication() {
        return this.communication;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getManufacturing() {
        return this.manufacturing;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getReligious() {
        return this.religious;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getHighwayAndStreet() {
        return this.highwayAndStreet;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Private.
	
	 * @return String
	 */
	public String toString() {
		return "Private[" +lodging+", "+educational+", "+totalConstruction+", "+transportation+", "+power+", "+office+", "+nonresidential+", "+amusementAndRecreation+", "+residential+", "+publicSafety+", "+conservationAndDevelopment+", "+commercial+", "+waterSupply+", "+healthCare+", "+sewageAndWasteDisposal+", "+communication+", "+manufacturing+", "+religious+", "+highwayAndStreet+"]";
	}
	
	/**
	 * Internal constructor to create a Private from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Private(JSONObject json_data) {
        try {// lodging
            this.lodging = new Integer(((Long)json_data.get("lodging")).intValue());// educational
            this.educational = new Integer(((Long)json_data.get("educational")).intValue());// total construction
            this.totalConstruction = new Integer(((Long)json_data.get("total construction")).intValue());// transportation
            this.transportation = new Integer(((Long)json_data.get("transportation")).intValue());// power
            this.power = new Integer(((Long)json_data.get("power")).intValue());// office
            this.office = new Integer(((Long)json_data.get("office")).intValue());// nonresidential
            this.nonresidential = new Integer(((Long)json_data.get("nonresidential")).intValue());// amusement and recreation
            this.amusementAndRecreation = new Integer(((Long)json_data.get("amusement and recreation")).intValue());// residential
            this.residential = new Integer(((Long)json_data.get("residential")).intValue());// public safety
            this.publicSafety = new Integer(((Long)json_data.get("public safety")).intValue());// conservation and development
            this.conservationAndDevelopment = new Integer(((Long)json_data.get("conservation and development")).intValue());// commercial
            this.commercial = new Integer(((Long)json_data.get("commercial")).intValue());// water supply
            this.waterSupply = new Integer(((Long)json_data.get("water supply")).intValue());// health care
            this.healthCare = new Integer(((Long)json_data.get("health care")).intValue());// sewage and waste disposal
            this.sewageAndWasteDisposal = new Integer(((Long)json_data.get("sewage and waste disposal")).intValue());// communication
            this.communication = new Integer(((Long)json_data.get("communication")).intValue());// manufacturing
            this.manufacturing = new Integer(((Long)json_data.get("manufacturing")).intValue());// religious
            this.religious = new Integer(((Long)json_data.get("religious")).intValue());// highway and street
            this.highwayAndStreet = new Integer(((Long)json_data.get("highway and street")).intValue());
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Private; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Private; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}