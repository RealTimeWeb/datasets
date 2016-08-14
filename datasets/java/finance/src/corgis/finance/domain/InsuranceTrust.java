package corgis.finance.domain;

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
public class InsuranceTrust {
	
    private Integer insuranceTrustOtherSecurities;
    private Integer insuranceTrustCashAndDeposits;
    private Integer insuranceTrustStateAndLocalSecuritiesTotal;
    private Integer insuranceTrustSecuritiesTotal;
    private Integer insuranceTrustFederalAgencySecurities;
    private Integer insuranceTrustTotalExpenditure;
    private Integer insuranceTrust;
    private Integer insuranceTrustCashAndSecurities;
    private Integer insuranceTrustFederalSecurities;
    
    
    /*
     * @return 
     */
    public Integer getInsuranceTrustOtherSecurities() {
        return this.insuranceTrustOtherSecurities;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getInsuranceTrustCashAndDeposits() {
        return this.insuranceTrustCashAndDeposits;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getInsuranceTrustStateAndLocalSecuritiesTotal() {
        return this.insuranceTrustStateAndLocalSecuritiesTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getInsuranceTrustSecuritiesTotal() {
        return this.insuranceTrustSecuritiesTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getInsuranceTrustFederalAgencySecurities() {
        return this.insuranceTrustFederalAgencySecurities;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getInsuranceTrustTotalExpenditure() {
        return this.insuranceTrustTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getInsuranceTrust() {
        return this.insuranceTrust;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getInsuranceTrustCashAndSecurities() {
        return this.insuranceTrustCashAndSecurities;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getInsuranceTrustFederalSecurities() {
        return this.insuranceTrustFederalSecurities;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this InsuranceTrust.
	
	 * @return String
	 */
	public String toString() {
		return "InsuranceTrust[" +insuranceTrustOtherSecurities+", "+insuranceTrustCashAndDeposits+", "+insuranceTrustStateAndLocalSecuritiesTotal+", "+insuranceTrustSecuritiesTotal+", "+insuranceTrustFederalAgencySecurities+", "+insuranceTrustTotalExpenditure+", "+insuranceTrust+", "+insuranceTrustCashAndSecurities+", "+insuranceTrustFederalSecurities+"]";
	}
	
	/**
	 * Internal constructor to create a InsuranceTrust from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public InsuranceTrust(JSONObject json_data) {
        try {// Insurance Trust Other Securities
            this.insuranceTrustOtherSecurities = new Integer(((Long)json_data.get("Insurance Trust Other Securities")).intValue());// Insurance Trust Cash and Deposits
            this.insuranceTrustCashAndDeposits = new Integer(((Long)json_data.get("Insurance Trust Cash and Deposits")).intValue());// Insurance Trust State and Local Securities Total
            this.insuranceTrustStateAndLocalSecuritiesTotal = new Integer(((Long)json_data.get("Insurance Trust State and Local Securities Total")).intValue());// Insurance Trust Securities Total
            this.insuranceTrustSecuritiesTotal = new Integer(((Long)json_data.get("Insurance Trust Securities Total")).intValue());// Insurance Trust Federal Agency Securities
            this.insuranceTrustFederalAgencySecurities = new Integer(((Long)json_data.get("Insurance Trust Federal Agency Securities")).intValue());// Insurance Trust Total Expenditure
            this.insuranceTrustTotalExpenditure = new Integer(((Long)json_data.get("Insurance Trust Total Expenditure")).intValue());// Insurance Trust
            this.insuranceTrust = new Integer(((Long)json_data.get("Insurance Trust")).intValue());// Insurance Trust Cash and Securities
            this.insuranceTrustCashAndSecurities = new Integer(((Long)json_data.get("Insurance Trust Cash and Securities")).intValue());// Insurance Trust Federal Securities
            this.insuranceTrustFederalSecurities = new Integer(((Long)json_data.get("Insurance Trust Federal Securities")).intValue());
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a InsuranceTrust; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a InsuranceTrust; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}