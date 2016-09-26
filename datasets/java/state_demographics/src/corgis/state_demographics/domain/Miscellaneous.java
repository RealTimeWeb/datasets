package corgis.state_demographics.domain;

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
public class Miscellaneous {
	
    // $100,000 of dollars, 2007
    private Integer manufacturersShipments;
    // percent 2009-2013
    private Double foreignBorn;
    // 2014
    private Double percentFemale;
    // age 5+, percent, 2009-2013
    private Double languageOtherThanEnglishAtHome;
    // percent, 2009-2013
    private Double livingInSameHousePlusoneYears;
    // minutes, workers aged 16+, 2009-2013
    private Double meanTravelTimeToWork;
    // 2014
    private Integer buildingPermits;
    // 2009-2013
    private Integer veterans;
    // Square Miles, 2010
    private Double landArea;
    
    
    /*
     * @return 
     */
    public Integer getManufacturersShipments() {
        return this.manufacturersShipments;
    }
    
    
    
    /*
     * @return 
     */
    public Double getForeignBorn() {
        return this.foreignBorn;
    }
    
    
    
    /*
     * @return 
     */
    public Double getPercentFemale() {
        return this.percentFemale;
    }
    
    
    
    /*
     * @return 
     */
    public Double getLanguageOtherThanEnglishAtHome() {
        return this.languageOtherThanEnglishAtHome;
    }
    
    
    
    /*
     * @return 
     */
    public Double getLivingInSameHousePlusoneYears() {
        return this.livingInSameHousePlusoneYears;
    }
    
    
    
    /*
     * @return 
     */
    public Double getMeanTravelTimeToWork() {
        return this.meanTravelTimeToWork;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getBuildingPermits() {
        return this.buildingPermits;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getVeterans() {
        return this.veterans;
    }
    
    
    
    /*
     * @return 
     */
    public Double getLandArea() {
        return this.landArea;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Miscellaneous.
	
	 * @return String
	 */
	public String toString() {
		return "Miscellaneous[" +manufacturersShipments+", "+foreignBorn+", "+percentFemale+", "+languageOtherThanEnglishAtHome+", "+livingInSameHousePlusoneYears+", "+meanTravelTimeToWork+", "+buildingPermits+", "+veterans+", "+landArea+"]";
	}
	
	/**
	 * Internal constructor to create a Miscellaneous from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Miscellaneous(JSONObject json_data) {
        try {// Manufacturers Shipments
            this.manufacturersShipments = new Integer(((Long)json_data.get("Manufacturers Shipments")).intValue());// Foreign Born
            this.foreignBorn = (Double)json_data.get("Foreign Born");// Percent Female
            this.percentFemale = (Double)json_data.get("Percent Female");// Language Other than English at Home
            this.languageOtherThanEnglishAtHome = (Double)json_data.get("Language Other than English at Home");// Living in Same House +1 Years
            this.livingInSameHousePlusoneYears = (Double)json_data.get("Living in Same House +1 Years");// Mean Travel Time to Work
            this.meanTravelTimeToWork = (Double)json_data.get("Mean Travel Time to Work");// Building Permits
            this.buildingPermits = new Integer(((Long)json_data.get("Building Permits")).intValue());// Veterans
            this.veterans = new Integer(((Long)json_data.get("Veterans")).intValue());// Land Area
            this.landArea = (Double)json_data.get("Land Area");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Miscellaneous; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Miscellaneous; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}