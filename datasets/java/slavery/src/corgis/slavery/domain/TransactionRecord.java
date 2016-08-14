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
import corgis.slavery.domain.Transaction;
import corgis.slavery.domain.Slave;
import corgis.slavery.domain.Seller;

/**
 * 
 */
public class TransactionRecord {
	
    private Buyer buyer;
    private Transaction transaction;
    private Slave slave;
    private Seller seller;
    
    
    /*
     * @return 
     */
    public Buyer getBuyer() {
        return this.buyer;
    }
    
    
    
    /*
     * @return 
     */
    public Transaction getTransaction() {
        return this.transaction;
    }
    
    
    
    /*
     * @return 
     */
    public Slave getSlave() {
        return this.slave;
    }
    
    
    
    /*
     * @return 
     */
    public Seller getSeller() {
        return this.seller;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this TransactionRecord.
	
	 * @return String
	 */
	public String toString() {
		return "TransactionRecord[" +buyer+", "+transaction+", "+slave+", "+seller+"]";
	}
	
	/**
	 * Internal constructor to create a TransactionRecord from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public TransactionRecord(JSONObject json_data) {
        try {// Buyer
            this.buyer = new Buyer((JSONObject)json_data.get("Buyer"));// Transaction
            this.transaction = new Transaction((JSONObject)json_data.get("Transaction"));// Slave
            this.slave = new Slave((JSONObject)json_data.get("Slave"));// Seller
            this.seller = new Seller((JSONObject)json_data.get("Seller"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a TransactionRecord; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a TransactionRecord; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}