package corgis.slavery.domain;

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
public class Payment {
	
    private String price;
    private String annualInterestRate;
    private String flag;
    private String predicatedMonthlyRate;
    private String credit;
    private String downPayment;
    private String monthlyDiscountRate;
    private String maximumMonthsOfCredit;
    private String method;
    
    
    /*
     * @return 
     */
    public String getPrice() {
        return this.price;
    }
    
    
    
    /*
     * @return 
     */
    public String getAnnualInterestRate() {
        return this.annualInterestRate;
    }
    
    
    
    /*
     * @return 
     */
    public String getFlag() {
        return this.flag;
    }
    
    
    
    /*
     * @return 
     */
    public String getPredicatedMonthlyRate() {
        return this.predicatedMonthlyRate;
    }
    
    
    
    /*
     * @return 
     */
    public String getCredit() {
        return this.credit;
    }
    
    
    
    /*
     * @return 
     */
    public String getDownPayment() {
        return this.downPayment;
    }
    
    
    
    /*
     * @return 
     */
    public String getMonthlyDiscountRate() {
        return this.monthlyDiscountRate;
    }
    
    
    
    /*
     * @return 
     */
    public String getMaximumMonthsOfCredit() {
        return this.maximumMonthsOfCredit;
    }
    
    
    
    /*
     * @return 
     */
    public String getMethod() {
        return this.method;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Payment.
	
	 * @return String
	 */
	public String toString() {
		return "Payment[" +price+", "+annualInterestRate+", "+flag+", "+predicatedMonthlyRate+", "+credit+", "+downPayment+", "+monthlyDiscountRate+", "+maximumMonthsOfCredit+", "+method+"]";
	}
	
	/**
	 * Internal constructor to create a Payment from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Payment(JSONObject json_data) {
        try {// price
            this.price = (String)json_data.get("price");// annual interest rate
            this.annualInterestRate = (String)json_data.get("annual interest rate");// flag
            this.flag = (String)json_data.get("flag");// predicated monthly rate
            this.predicatedMonthlyRate = (String)json_data.get("predicated monthly rate");// credit
            this.credit = (String)json_data.get("credit");// down payment
            this.downPayment = (String)json_data.get("down payment");// monthly discount rate
            this.monthlyDiscountRate = (String)json_data.get("monthly discount rate");// maximum months of credit
            this.maximumMonthsOfCredit = (String)json_data.get("maximum months of credit");// method
            this.method = (String)json_data.get("method");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Payment; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Payment; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}