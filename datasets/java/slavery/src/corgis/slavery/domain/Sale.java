package corgis.slavery.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.slavery.domain.Buyer;
import corgis.slavery.domain.Seller;

/**
 * 
 */
public class Sale {
	
    private String date;
    private Buyer buyer;
    private Seller seller;
    
    
    /*
     * @return 
     */
    public String getDate() {
        return this.date;
    }
    
    
    
    /*
     * @return 
     */
    public Buyer getBuyer() {
        return this.buyer;
    }
    
    
    
    /*
     * @return 
     */
    public Seller getSeller() {
        return this.seller;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Sale.
	
	 * @return String
	 */
	public String toString() {
		return "Sale[" +date+", "+buyer+", "+seller+"]";
	}
	
	/**
	 * Internal constructor to create a Sale from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Sale(JSONObject json_data) {
        try {// date
            this.date = (String)json_data.get("date");// buyer
            this.buyer = new Buyer((JSONObject)json_data.get("buyer"));// seller
            this.seller = new Seller((JSONObject)json_data.get("seller"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Sale; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Sale; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}