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
	
    private Integer numberOfAdultSlaves;
    private String date;
    private Integer numberOfChildSlaves;
    private Integer numberOfTotalSlavesPurchased;
    private SaleDetails saleDetails;
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getNumberOfAdultSlaves() {
        return this.numberOfAdultSlaves;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getDate() {
        return this.date;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getNumberOfChildSlaves() {
        return this.numberOfChildSlaves;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getNumberOfTotalSlavesPurchased() {
        return this.numberOfTotalSlavesPurchased;
    }
    
    
    
    /**
     * 
     * @return SaleDetails
     */
    public SaleDetails getSaleDetails() {
        return this.saleDetails;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Transaction.
	
	 * @return String
	 */
	public String toString() {
		return "Transaction[" +numberOfAdultSlaves+", "+date+", "+numberOfChildSlaves+", "+numberOfTotalSlavesPurchased+", "+saleDetails+"]";
	}
	
	/**
	 * Internal constructor to create a Transaction from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Transaction(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Number of Adult Slaves
            this.numberOfAdultSlaves = ((Number)json_data.get("Number of Adult Slaves")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Transaction; the field numberOfAdultSlaves was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Transaction; the field numberOfAdultSlaves had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Date
            this.date = (String)json_data.get("Date");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Transaction; the field date was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Transaction; the field date had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Number of Child Slaves
            this.numberOfChildSlaves = ((Number)json_data.get("Number of Child Slaves")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Transaction; the field numberOfChildSlaves was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Transaction; the field numberOfChildSlaves had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Number of Total Slaves Purchased
            this.numberOfTotalSlavesPurchased = ((Number)json_data.get("Number of Total Slaves Purchased")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Transaction; the field numberOfTotalSlavesPurchased was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Transaction; the field numberOfTotalSlavesPurchased had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Sale Details
            this.saleDetails = new SaleDetails((JSONObject)json_data.get("Sale Details"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Transaction; the field saleDetails was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Transaction; the field saleDetails had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}