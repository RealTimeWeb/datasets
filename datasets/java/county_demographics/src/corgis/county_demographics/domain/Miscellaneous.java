package corgis.county_demographics.domain;

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
	
    // 2014
    private Integer buildingPermits;
    // minutes, workers aged 16+, 2009-2013
    private Double meanTravelTimeToWork;
    // percent, 2009-2013
    private Double livingInSameHousePlusoneYears;
    // $100,000 of dollars, 2007
    private Integer manufacturersShipments;
    // 2009-2013
    private Integer veterans;
    // Square Miles, 2010
    private Double landArea;
    // 2014
    private Double percentFemale;
    // percent 2009-2013
    private Double foreignBorn;
    // age 5+, percent, 2009-2013
    private Double languageOtherThanEnglishAtHome;
    
    
    /**
     * 2014
     * @return Integer
     */
    public Integer getBuildingPermits() {
        return this.buildingPermits;
    }
    
    
    
    /**
     * minutes, workers aged 16+, 2009-2013
     * @return Double
     */
    public Double getMeanTravelTimeToWork() {
        return this.meanTravelTimeToWork;
    }
    
    
    
    /**
     * percent, 2009-2013
     * @return Double
     */
    public Double getLivingInSameHousePlusoneYears() {
        return this.livingInSameHousePlusoneYears;
    }
    
    
    
    /**
     * $100,000 of dollars, 2007
     * @return Integer
     */
    public Integer getManufacturersShipments() {
        return this.manufacturersShipments;
    }
    
    
    
    /**
     * 2009-2013
     * @return Integer
     */
    public Integer getVeterans() {
        return this.veterans;
    }
    
    
    
    /**
     * Square Miles, 2010
     * @return Double
     */
    public Double getLandArea() {
        return this.landArea;
    }
    
    
    
    /**
     * 2014
     * @return Double
     */
    public Double getPercentFemale() {
        return this.percentFemale;
    }
    
    
    
    /**
     * percent 2009-2013
     * @return Double
     */
    public Double getForeignBorn() {
        return this.foreignBorn;
    }
    
    
    
    /**
     * age 5+, percent, 2009-2013
     * @return Double
     */
    public Double getLanguageOtherThanEnglishAtHome() {
        return this.languageOtherThanEnglishAtHome;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Miscellaneous.
	
	 * @return String
	 */
	public String toString() {
		return "Miscellaneous[" +buildingPermits+", "+meanTravelTimeToWork+", "+livingInSameHousePlusoneYears+", "+manufacturersShipments+", "+veterans+", "+landArea+", "+percentFemale+", "+foreignBorn+", "+languageOtherThanEnglishAtHome+"]";
	}
	
	/**
	 * Internal constructor to create a Miscellaneous from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Miscellaneous(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Building Permits
            this.buildingPermits = ((Number)json_data.get("Building Permits")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Miscellaneous; the field buildingPermits was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Miscellaneous; the field buildingPermits had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Mean Travel Time to Work
            this.meanTravelTimeToWork = ((Number)json_data.get("Mean Travel Time to Work")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Miscellaneous; the field meanTravelTimeToWork was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Miscellaneous; the field meanTravelTimeToWork had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Living in Same House +1 Years
            this.livingInSameHousePlusoneYears = ((Number)json_data.get("Living in Same House +1 Years")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Miscellaneous; the field livingInSameHousePlusoneYears was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Miscellaneous; the field livingInSameHousePlusoneYears had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Manufacturers Shipments
            this.manufacturersShipments = ((Number)json_data.get("Manufacturers Shipments")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Miscellaneous; the field manufacturersShipments was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Miscellaneous; the field manufacturersShipments had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Veterans
            this.veterans = ((Number)json_data.get("Veterans")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Miscellaneous; the field veterans was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Miscellaneous; the field veterans had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Land Area
            this.landArea = ((Number)json_data.get("Land Area")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Miscellaneous; the field landArea was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Miscellaneous; the field landArea had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Percent Female
            this.percentFemale = ((Number)json_data.get("Percent Female")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Miscellaneous; the field percentFemale was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Miscellaneous; the field percentFemale had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Foreign Born
            this.foreignBorn = ((Number)json_data.get("Foreign Born")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Miscellaneous; the field foreignBorn was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Miscellaneous; the field foreignBorn had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Language Other than English at Home
            this.languageOtherThanEnglishAtHome = ((Number)json_data.get("Language Other than English at Home")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Miscellaneous; the field languageOtherThanEnglishAtHome was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Miscellaneous; the field languageOtherThanEnglishAtHome had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}