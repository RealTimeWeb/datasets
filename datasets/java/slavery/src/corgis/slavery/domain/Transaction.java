package corgis.slavery.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.slavery.domain.SaleDetails;

/**
 * 
 */
public class Transaction {
	
    private String date;
    private Integer numberOfTotalSlavesPurchased;
    private Integer numberOfAdultSlaves;
    private Integer numberOfChildSlaves;
    private SaleDetails saleDetails;
    
    
    /*
     * @return 
     */
    public String getDate() {
        return this.date;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getNumberOfTotalSlavesPurchased() {
        return this.numberOfTotalSlavesPurchased;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getNumberOfAdultSlaves() {
        return this.numberOfAdultSlaves;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getNumberOfChildSlaves() {
        return this.numberOfChildSlaves;
    }
    
    
    
    /*
     * @return 
     */
    public SaleDetails getSaleDetails() {
        return this.saleDetails;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Transaction.
	
	 * @return String
	 */
	public String toString() {
		return "Transaction[" +date+", "+numberOfTotalSlavesPurchased+", "+numberOfAdultSlaves+", "+numberOfChildSlaves+", "+saleDetails+"]";
	}
	
	/**
	 * Internal constructor to create a Transaction from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Transaction(JSONObject json_data) {
        try {// Date
            this.date = (String)json_data.get("Date");// Number of Total Slaves Purchased
            this.numberOfTotalSlavesPurchased = ((Number)json_data.get("Number of Total Slaves Purchased")).intValue();// Number of Adult Slaves
            this.numberOfAdultSlaves = ((Number)json_data.get("Number of Adult Slaves")).intValue();// Number of Child Slaves
            this.numberOfChildSlaves = ((Number)json_data.get("Number of Child Slaves")).intValue();// Sale Details
            this.saleDetails = new SaleDetails((JSONObject)json_data.get("Sale Details"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Transaction; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Transaction; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}