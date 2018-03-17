package corgis.global_development.domain;

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
public class Infrastructure {
	
    private Double telephoneLinesPerOnezerozeroPeople;
    private Double mobileCellularSubscriptions;
    private Double telephoneLines;
    private Double mobileCellularSubscriptionsPerOnezerozeroPeople;
    
    
    /**
     * 
     * @return Double
     */
    public Double getTelephoneLinesPerOnezerozeroPeople() {
        return this.telephoneLinesPerOnezerozeroPeople;
    }
    
    
    
    /**
     * 
     * @return Double
     */
    public Double getMobileCellularSubscriptions() {
        return this.mobileCellularSubscriptions;
    }
    
    
    
    /**
     * 
     * @return Double
     */
    public Double getTelephoneLines() {
        return this.telephoneLines;
    }
    
    
    
    /**
     * 
     * @return Double
     */
    public Double getMobileCellularSubscriptionsPerOnezerozeroPeople() {
        return this.mobileCellularSubscriptionsPerOnezerozeroPeople;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Infrastructure.
	
	 * @return String
	 */
	public String toString() {
		return "Infrastructure[" +telephoneLinesPerOnezerozeroPeople+", "+mobileCellularSubscriptions+", "+telephoneLines+", "+mobileCellularSubscriptionsPerOnezerozeroPeople+"]";
	}
	
	/**
	 * Internal constructor to create a Infrastructure from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Infrastructure(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Telephone Lines per 100 People
            this.telephoneLinesPerOnezerozeroPeople = ((Number)json_data.get("Telephone Lines per 100 People")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Infrastructure; the field telephoneLinesPerOnezerozeroPeople was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Infrastructure; the field telephoneLinesPerOnezerozeroPeople had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Mobile Cellular Subscriptions
            this.mobileCellularSubscriptions = ((Number)json_data.get("Mobile Cellular Subscriptions")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Infrastructure; the field mobileCellularSubscriptions was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Infrastructure; the field mobileCellularSubscriptions had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Telephone Lines
            this.telephoneLines = ((Number)json_data.get("Telephone Lines")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Infrastructure; the field telephoneLines was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Infrastructure; the field telephoneLines had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Mobile Cellular Subscriptions per 100 People
            this.mobileCellularSubscriptionsPerOnezerozeroPeople = ((Number)json_data.get("Mobile Cellular Subscriptions per 100 People")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Infrastructure; the field mobileCellularSubscriptionsPerOnezerozeroPeople was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Infrastructure; the field mobileCellularSubscriptionsPerOnezerozeroPeople had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}