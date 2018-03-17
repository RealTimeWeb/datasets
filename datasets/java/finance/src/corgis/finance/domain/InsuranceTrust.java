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
    // A government-administered plan for compulsory or voluntary social insurance (insurance protection of persons or their survivors against economic hazards arising from retirement, disability, death, accident, illness, unemployment, etc.) through accumulation of assets from contributions, assessments, premiums, and the like collected from employers and employees for use in making cash benefit payments to eligible persons covered by the system. Comprises Employee retirement, Unemployment compensation, Workers' compensation, and Miscellaneous (accident, sickness, and other disability benefit) systems. In exhibit statistics, each insurance trust system is treated as an entity, with its transactions including intragovernmental amounts. However, intragovernmental transactions are excluded from the insurance trust components of revenue and expenditure.
    private Integer insuranceTrust;
    // Total amount spent on securities for insurance trust.
    private Integer insuranceTrustSecuritiesTotal;
    // Cash and securities related to insurance trust.
    private Integer insuranceTrustCashAndSecurities;
    // Total amount spent on state and local securities for insurance trust.
    private Integer insuranceTrustStateAndLocalSecuritiesTotal;
    // Cash and deposits related to insurance trust.
    private Integer insuranceTrustCashAndDeposits;
    // Total amount spent on federal agency insurance trust securities.
    private Integer insuranceTrustFederalAgencySecurities;
    // Federal securities related to insurance trust.
    private Integer insuranceTrustFederalSecurities;
    // Cash payments to beneficiaries (including withdrawals of retirement contributions) of employee retirement, unemployment compensation, workers' compensation, and disability benefit social insurance programs. Excludes cost of administering insurance trust activities, state contributions of programs administered by the state or by the federal government, intergovernmental expenditure for support of locally administered employee-retirement systems, and noncontributory gratuities paid to former employees.
    private Integer insuranceTrustTotalExpenditure;
    
    
    /**
     * Other securities related to insurance trust.
     * @return Integer
     */
    public Integer getInsuranceTrustOtherSecurities() {
        return this.insuranceTrustOtherSecurities;
    }
    
    
    
    /**
     * A government-administered plan for compulsory or voluntary social insurance (insurance protection of persons or their survivors against economic hazards arising from retirement, disability, death, accident, illness, unemployment, etc.) through accumulation of assets from contributions, assessments, premiums, and the like collected from employers and employees for use in making cash benefit payments to eligible persons covered by the system. Comprises Employee retirement, Unemployment compensation, Workers' compensation, and Miscellaneous (accident, sickness, and other disability benefit) systems. In exhibit statistics, each insurance trust system is treated as an entity, with its transactions including intragovernmental amounts. However, intragovernmental transactions are excluded from the insurance trust components of revenue and expenditure.
     * @return Integer
     */
    public Integer getInsuranceTrust() {
        return this.insuranceTrust;
    }
    
    
    
    /**
     * Total amount spent on securities for insurance trust.
     * @return Integer
     */
    public Integer getInsuranceTrustSecuritiesTotal() {
        return this.insuranceTrustSecuritiesTotal;
    }
    
    
    
    /**
     * Cash and securities related to insurance trust.
     * @return Integer
     */
    public Integer getInsuranceTrustCashAndSecurities() {
        return this.insuranceTrustCashAndSecurities;
    }
    
    
    
    /**
     * Total amount spent on state and local securities for insurance trust.
     * @return Integer
     */
    public Integer getInsuranceTrustStateAndLocalSecuritiesTotal() {
        return this.insuranceTrustStateAndLocalSecuritiesTotal;
    }
    
    
    
    /**
     * Cash and deposits related to insurance trust.
     * @return Integer
     */
    public Integer getInsuranceTrustCashAndDeposits() {
        return this.insuranceTrustCashAndDeposits;
    }
    
    
    
    /**
     * Total amount spent on federal agency insurance trust securities.
     * @return Integer
     */
    public Integer getInsuranceTrustFederalAgencySecurities() {
        return this.insuranceTrustFederalAgencySecurities;
    }
    
    
    
    /**
     * Federal securities related to insurance trust.
     * @return Integer
     */
    public Integer getInsuranceTrustFederalSecurities() {
        return this.insuranceTrustFederalSecurities;
    }
    
    
    
    /**
     * Cash payments to beneficiaries (including withdrawals of retirement contributions) of employee retirement, unemployment compensation, workers' compensation, and disability benefit social insurance programs. Excludes cost of administering insurance trust activities, state contributions of programs administered by the state or by the federal government, intergovernmental expenditure for support of locally administered employee-retirement systems, and noncontributory gratuities paid to former employees.
     * @return Integer
     */
    public Integer getInsuranceTrustTotalExpenditure() {
        return this.insuranceTrustTotalExpenditure;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this InsuranceTrust.
	
	 * @return String
	 */
	public String toString() {
		return "InsuranceTrust[" +insuranceTrustOtherSecurities+", "+insuranceTrust+", "+insuranceTrustSecuritiesTotal+", "+insuranceTrustCashAndSecurities+", "+insuranceTrustStateAndLocalSecuritiesTotal+", "+insuranceTrustCashAndDeposits+", "+insuranceTrustFederalAgencySecurities+", "+insuranceTrustFederalSecurities+", "+insuranceTrustTotalExpenditure+"]";
	}
	
	/**
	 * Internal constructor to create a InsuranceTrust from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public InsuranceTrust(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Insurance Trust Other Securities
            this.insuranceTrustOtherSecurities = ((Number)json_data.get("Insurance Trust Other Securities")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a InsuranceTrust; the field insuranceTrustOtherSecurities was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a InsuranceTrust; the field insuranceTrustOtherSecurities had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Insurance Trust
            this.insuranceTrust = ((Number)json_data.get("Insurance Trust")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a InsuranceTrust; the field insuranceTrust was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a InsuranceTrust; the field insuranceTrust had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Insurance Trust Securities Total
            this.insuranceTrustSecuritiesTotal = ((Number)json_data.get("Insurance Trust Securities Total")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a InsuranceTrust; the field insuranceTrustSecuritiesTotal was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a InsuranceTrust; the field insuranceTrustSecuritiesTotal had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Insurance Trust Cash and Securities
            this.insuranceTrustCashAndSecurities = ((Number)json_data.get("Insurance Trust Cash and Securities")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a InsuranceTrust; the field insuranceTrustCashAndSecurities was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a InsuranceTrust; the field insuranceTrustCashAndSecurities had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Insurance Trust State and Local Securities Total
            this.insuranceTrustStateAndLocalSecuritiesTotal = ((Number)json_data.get("Insurance Trust State and Local Securities Total")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a InsuranceTrust; the field insuranceTrustStateAndLocalSecuritiesTotal was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a InsuranceTrust; the field insuranceTrustStateAndLocalSecuritiesTotal had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Insurance Trust Cash and Deposits
            this.insuranceTrustCashAndDeposits = ((Number)json_data.get("Insurance Trust Cash and Deposits")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a InsuranceTrust; the field insuranceTrustCashAndDeposits was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a InsuranceTrust; the field insuranceTrustCashAndDeposits had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Insurance Trust Federal Agency Securities
            this.insuranceTrustFederalAgencySecurities = ((Number)json_data.get("Insurance Trust Federal Agency Securities")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a InsuranceTrust; the field insuranceTrustFederalAgencySecurities was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a InsuranceTrust; the field insuranceTrustFederalAgencySecurities had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Insurance Trust Federal Securities
            this.insuranceTrustFederalSecurities = ((Number)json_data.get("Insurance Trust Federal Securities")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a InsuranceTrust; the field insuranceTrustFederalSecurities was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a InsuranceTrust; the field insuranceTrustFederalSecurities had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Insurance Trust Total Expenditure
            this.insuranceTrustTotalExpenditure = ((Number)json_data.get("Insurance Trust Total Expenditure")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a InsuranceTrust; the field insuranceTrustTotalExpenditure was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a InsuranceTrust; the field insuranceTrustTotalExpenditure had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}