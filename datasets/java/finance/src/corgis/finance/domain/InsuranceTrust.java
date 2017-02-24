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
	
    // Other securities related to insurance trust.
    private Integer insuranceTrustOtherSecurities;
    // Cash and deposits related to insurance trust.
    private Integer insuranceTrustCashAndDeposits;
    // Total amount spent on state and local securities for insurance trust.
    private Integer insuranceTrustStateAndLocalSecuritiesTotal;
    // Total amount spent on securities for insurance trust.
    private Integer insuranceTrustSecuritiesTotal;
    // Total amount spent on federal agency insurance trust securities.
    private Integer insuranceTrustFederalAgencySecurities;
    // Cash payments to beneficiaries (including withdrawals of retirement contributions) of employee retirement, unemployment compensation, workers' compensation, and disability benefit social insurance programs. Excludes cost of administering insurance trust activities, state contributions of programs administered by the state or by the federal government, intergovernmental expenditure for support of locally administered employee-retirement systems, and noncontributory gratuities paid to former employees.
    private Integer insuranceTrustTotalExpenditure;
    // A government-administered plan for compulsory or voluntary social insurance (insurance protection of persons or their survivors against economic hazards arising from retirement, disability, death, accident, illness, unemployment, etc.) through accumulation of assets from contributions, assessments, premiums, and the like collected from employers and employees for use in making cash benefit payments to eligible persons covered by the system. Comprises Employee retirement, Unemployment compensation, Workers' compensation, and Miscellaneous (accident, sickness, and other disability benefit) systems. In exhibit statistics, each insurance trust system is treated as an entity, with its transactions including intragovernmental amounts. However, intragovernmental transactions are excluded from the insurance trust components of revenue and expenditure.
    private Integer insuranceTrust;
    // Cash and securities related to insurance trust.
    private Integer insuranceTrustCashAndSecurities;
    // Federal securities related to insurance trust.
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
            this.insuranceTrustOtherSecurities = ((Number)json_data.get("Insurance Trust Other Securities")).intValue();// Insurance Trust Cash and Deposits
            this.insuranceTrustCashAndDeposits = ((Number)json_data.get("Insurance Trust Cash and Deposits")).intValue();// Insurance Trust State and Local Securities Total
            this.insuranceTrustStateAndLocalSecuritiesTotal = ((Number)json_data.get("Insurance Trust State and Local Securities Total")).intValue();// Insurance Trust Securities Total
            this.insuranceTrustSecuritiesTotal = ((Number)json_data.get("Insurance Trust Securities Total")).intValue();// Insurance Trust Federal Agency Securities
            this.insuranceTrustFederalAgencySecurities = ((Number)json_data.get("Insurance Trust Federal Agency Securities")).intValue();// Insurance Trust Total Expenditure
            this.insuranceTrustTotalExpenditure = ((Number)json_data.get("Insurance Trust Total Expenditure")).intValue();// Insurance Trust
            this.insuranceTrust = ((Number)json_data.get("Insurance Trust")).intValue();// Insurance Trust Cash and Securities
            this.insuranceTrustCashAndSecurities = ((Number)json_data.get("Insurance Trust Cash and Securities")).intValue();// Insurance Trust Federal Securities
            this.insuranceTrustFederalSecurities = ((Number)json_data.get("Insurance Trust Federal Securities")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a InsuranceTrust; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a InsuranceTrust; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}