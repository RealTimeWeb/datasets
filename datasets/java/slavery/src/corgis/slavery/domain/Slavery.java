package corgis.slavery.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.slavery.domain.Sale;
import corgis.slavery.domain.Transaction;
import corgis.slavery.domain.Slave;
import corgis.slavery.domain.Payment;

/**
 * 
 */
public class Slavery {
	
    private Sale sale;
    private Transaction transaction;
    private Slave slave;
    private Payment payment;
    private String id;
    
    
    /*
     * @return 
     */
    public Sale getSale() {
        return this.sale;
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
    public Payment getPayment() {
        return this.payment;
    }
    
    
    
    /*
     * @return 
     */
    public String getId() {
        return this.id;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Slavery.
	
	 * @return String
	 */
	public String toString() {
		return "Slavery[" +sale+", "+transaction+", "+slave+", "+payment+", "+id+"]";
	}
	
	/**
	 * Internal constructor to create a Slavery from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Slavery(JSONObject json_data) {
        try {// sale
            this.sale = new Sale((JSONObject)json_data.get("sale"));// transaction
            this.transaction = new Transaction((JSONObject)json_data.get("transaction"));// slave
            this.slave = new Slave((JSONObject)json_data.get("slave"));// payment
            this.payment = new Payment((JSONObject)json_data.get("payment"));// id
            this.id = (String)json_data.get("id");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Slavery; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Slavery; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}