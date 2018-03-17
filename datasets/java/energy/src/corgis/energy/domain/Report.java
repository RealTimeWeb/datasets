package corgis.energy.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.energy.domain.Price;
import corgis.energy.domain.Consumption;
import corgis.energy.domain.Expenditure;
import corgis.energy.domain.Production;

/**
 * 
 */
public class Report {
	
    private Price price;
    private Consumption consumption;
    // The state that this report was made for.
    private String state;
    private Expenditure expenditure;
    private Production production;
    // The year that this report was made.
    private Integer year;
    
    
    /**
     * 
     * @return Price
     */
    public Price getPrice() {
        return this.price;
    }
    
    
    
    /**
     * 
     * @return Consumption
     */
    public Consumption getConsumption() {
        return this.consumption;
    }
    
    
    
    /**
     * The state that this report was made for.
     * @return String
     */
    public String getState() {
        return this.state;
    }
    
    
    
    /**
     * 
     * @return Expenditure
     */
    public Expenditure getExpenditure() {
        return this.expenditure;
    }
    
    
    
    /**
     * 
     * @return Production
     */
    public Production getProduction() {
        return this.production;
    }
    
    
    
    /**
     * The year that this report was made.
     * @return Integer
     */
    public Integer getYear() {
        return this.year;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Report.
	
	 * @return String
	 */
	public String toString() {
		return "Report[" +price+", "+consumption+", "+state+", "+expenditure+", "+production+", "+year+"]";
	}
	
	/**
	 * Internal constructor to create a Report from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Report(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Price
            this.price = new Price((JSONObject)json_data.get("Price"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Report; the field price was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Report; the field price had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Consumption
            this.consumption = new Consumption((JSONObject)json_data.get("Consumption"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Report; the field consumption was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Report; the field consumption had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // State
            this.state = (String)json_data.get("State");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Report; the field state was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Report; the field state had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Expenditure
            this.expenditure = new Expenditure((JSONObject)json_data.get("Expenditure"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Report; the field expenditure was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Report; the field expenditure had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Production
            this.production = new Production((JSONObject)json_data.get("Production"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Report; the field production was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Report; the field production had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Year
            this.year = ((Number)json_data.get("Year")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Report; the field year was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Report; the field year had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}