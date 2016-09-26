package corgis.construction_spending.domain;

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
public class Public {
	
    // Lodging includes hotels, motels, resort lodging, tourist courts and cabins, and similar facilities. The annual data represents data for the whole year, adjusted for seasonal variations (i.e. winter usually has less construction). The public data represents projects undertaken by the government, as opposed to private citizens. All units are reported in millions of dollars.
    private Integer lodging;
    // Education includes preschool, primary, secondary, higher education, nursing schools, cosmetology and beauty schools, trade schools, military training facilities, schools for the handicapped, and modeling schools. The annual data represents data for the whole year, adjusted for seasonal variations (i.e. winter usually has less construction). The public data represents projects undertaken by the government, as opposed to private citizens. All units are reported in millions of dollars.
    private Integer educational;
    // This section is the total of all the other categories, and by extension the total of the residential and non-residential categories. The annual data represents data for the whole year, adjusted for seasonal variations (i.e. winter usually has less construction). The public data represents projects undertaken by the government, as opposed to private citizens. All units are reported in millions of dollars.
    private Integer totalConstruction;
    // Transportation involves all the facilities related to air, land, and water travel. The annual data represents data for the whole year, adjusted for seasonal variations (i.e. winter usually has less construction). The public data represents projects undertaken by the government, as opposed to private citizens. All units are reported in millions of dollars.
    private Integer transportation;
    // Power includes electric, gas, and oil, and also includes distribution structures. The annual data represents data for the whole year, adjusted for seasonal variations (i.e. winter usually has less construction). The public data represents projects undertaken by the government, as opposed to private citizens. All units are reported in millions of dollars.
    private Integer power;
    // Offices include financial, corporate, television, radio, and even manufacturing site offices. The annual data represents data for the whole year, adjusted for seasonal variations (i.e. winter usually has less construction). The public data represents projects undertaken by the government, as opposed to private citizens. All units are reported in millions of dollars.
    private Integer office;
    // A categorization including all of the other categories except total and residential. The annual data represents data for the whole year, adjusted for seasonal variations (i.e. winter usually has less construction). The public data represents projects undertaken by the government, as opposed to private citizens. All units are reported in millions of dollars.
    private Integer nonresidential;
    // Amusement and recreation includes theme and amusement parks, sports, fitness, performance/meeting center, social centers, parks, camps, movie theaters, studios, and a host of other locations. The annual data represents data for the whole year, adjusted for seasonal variations (i.e. winter usually has less construction). The public data represents projects undertaken by the government, as opposed to private citizens. All units are reported in millions of dollars.
    private Integer amusementAndRecreation;
    // Residential Buildings are houses, townhouses, apartments, etc. for single families, multi-families, and improvements to existing properties. The annual data represents data for the whole year, adjusted for seasonal variations (i.e. winter usually has less construction). The public data represents projects undertaken by the government, as opposed to private citizens. All units are reported in millions of dollars.
    private Integer residential;
    // Public Safety includes correctional centers, police offices, fire and rescue. The annual data represents data for the whole year, adjusted for seasonal variations (i.e. winter usually has less construction). The public data represents projects undertaken by the government, as opposed to private citizens. All units are reported in millions of dollars.
    private Integer publicSafety;
    // Conservation and development includes facilities constructed for dams/leevees, breakwaters/jettys, dredging, irrigation, mine reclamation, fish hatcheries and wetlands. The annual data represents data for the whole year, adjusted for seasonal variations (i.e. winter usually has less construction). The public data represents projects undertaken by the government, as opposed to private citizens. All units are reported in millions of dollars.
    private Integer conservationAndDevelopment;
    // Commercial includes buildings and structures used by the retail, wholesale and selected service industries. The annual data represents data for the whole year, adjusted for seasonal variations (i.e. winter usually has less construction). The public data represents projects undertaken by the government, as opposed to private citizens. All units are reported in millions of dollars.
    private Integer commercial;
    // Water Supply construction involves plants, wells, lines, pump stations, resevoirs, and tanks/towers. The annual data represents data for the whole year, adjusted for seasonal variations (i.e. winter usually has less construction). The public data represents projects undertaken by the government, as opposed to private citizens. All units are reported in millions of dollars.
    private Integer waterSupply;
    // Health Care includes hospitals, medical buildings, and special care. The annual data represents data for the whole year, adjusted for seasonal variations (i.e. winter usually has less construction). The public data represents projects undertaken by the government, as opposed to private citizens. All units are reported in millions of dollars.
    private Integer healthCare;
    // This section includes sewage, dry waste, and waste water plants and line/pump stations. The annual data represents data for the whole year, adjusted for seasonal variations (i.e. winter usually has less construction). The public data represents projects undertaken by the government, as opposed to private citizens. All units are reported in millions of dollars.
    private Integer sewageAndWasteDisposal;
    // Communication includes telephone, television, and radio, distribution and maintenance buildings and structures. The annual data represents data for the whole year, adjusted for seasonal variations (i.e. winter usually has less construction). The public data represents projects undertaken by the government, as opposed to private citizens. All units are reported in millions of dollars.
    private Integer communication;
    // Manufacturing includes a wide variety of structures, including wood industries, paper industries, food/beverage/tobacco, textiles, printing, plastic, chemical, and much more. The annual data represents data for the whole year, adjusted for seasonal variations (i.e. winter usually has less construction). The public data represents projects undertaken by the government, as opposed to private citizens. All units are reported in millions of dollars.
    private Integer manufacturing;
    // Religious includes houses of worship such as churches, chapels, mosques, and their auxiliary buildings. The annual data represents data for the whole year, adjusted for seasonal variations (i.e. winter usually has less construction). The public data represents projects undertaken by the government, as opposed to private citizens. All units are reported in millions of dollars.
    private Integer religious;
    // Highway and Street includes pavement, lighting, retaining walls, tunnels, bridges, tolls/weighs, maintenance buildings, and rest facilities. The annual data represents data for the whole year, adjusted for seasonal variations (i.e. winter usually has less construction). The public data represents projects undertaken by the government, as opposed to private citizens. All units are reported in millions of dollars.
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
	 * Creates a string based representation of this Public.
	
	 * @return String
	 */
	public String toString() {
		return "Public[" +lodging+", "+educational+", "+totalConstruction+", "+transportation+", "+power+", "+office+", "+nonresidential+", "+amusementAndRecreation+", "+residential+", "+publicSafety+", "+conservationAndDevelopment+", "+commercial+", "+waterSupply+", "+healthCare+", "+sewageAndWasteDisposal+", "+communication+", "+manufacturing+", "+religious+", "+highwayAndStreet+"]";
	}
	
	/**
	 * Internal constructor to create a Public from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Public(JSONObject json_data) {
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
    		System.err.println("Could not convert the response to a Public; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Public; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}