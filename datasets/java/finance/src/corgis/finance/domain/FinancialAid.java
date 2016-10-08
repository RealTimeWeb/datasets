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
public class FinancialAid {
	
    private Integer federalAgencySecuritiesTotal;
    private Integer beginningLongTermDebtTotalOutstanding;
    private Integer categoricalAssistanceTotalExpenditure;
    private Integer cashAssistanceTotalExpenditure;
    private Integer categoricalAssistanceIntergovernmental;
    private Integer cashAndSecuritiesTotal;
    private Integer assistanceAndSubsidies;
    private Integer cashAssistanceIntergovernmental;
    private Integer borrowingTotal;
    private Integer sinkingFundTotal;
    private Integer securitiesTotal;
    private Integer bondFundTotal;
    private Integer cashAndDepositsTotal;
    
    
    /*
     * @return 
     */
    public Integer getFederalAgencySecuritiesTotal() {
        return this.federalAgencySecuritiesTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getBeginningLongTermDebtTotalOutstanding() {
        return this.beginningLongTermDebtTotalOutstanding;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getCategoricalAssistanceTotalExpenditure() {
        return this.categoricalAssistanceTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getCashAssistanceTotalExpenditure() {
        return this.cashAssistanceTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getCategoricalAssistanceIntergovernmental() {
        return this.categoricalAssistanceIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getCashAndSecuritiesTotal() {
        return this.cashAndSecuritiesTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getAssistanceAndSubsidies() {
        return this.assistanceAndSubsidies;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getCashAssistanceIntergovernmental() {
        return this.cashAssistanceIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getBorrowingTotal() {
        return this.borrowingTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getSinkingFundTotal() {
        return this.sinkingFundTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getSecuritiesTotal() {
        return this.securitiesTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getBondFundTotal() {
        return this.bondFundTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getCashAndDepositsTotal() {
        return this.cashAndDepositsTotal;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this FinancialAid.
	
	 * @return String
	 */
	public String toString() {
		return "FinancialAid[" +federalAgencySecuritiesTotal+", "+beginningLongTermDebtTotalOutstanding+", "+categoricalAssistanceTotalExpenditure+", "+cashAssistanceTotalExpenditure+", "+categoricalAssistanceIntergovernmental+", "+cashAndSecuritiesTotal+", "+assistanceAndSubsidies+", "+cashAssistanceIntergovernmental+", "+borrowingTotal+", "+sinkingFundTotal+", "+securitiesTotal+", "+bondFundTotal+", "+cashAndDepositsTotal+"]";
	}
	
	/**
	 * Internal constructor to create a FinancialAid from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public FinancialAid(JSONObject json_data) {
        try {// Federal Agency Securities Total
            this.federalAgencySecuritiesTotal = ((Number)json_data.get("Federal Agency Securities Total")).intValue();// Beginning Long Term Debt Total Outstanding
            this.beginningLongTermDebtTotalOutstanding = ((Number)json_data.get("Beginning Long Term Debt Total Outstanding")).intValue();// Categorical Assistance Total Expenditure
            this.categoricalAssistanceTotalExpenditure = ((Number)json_data.get("Categorical Assistance Total Expenditure")).intValue();// Cash Assistance Total Expenditure
            this.cashAssistanceTotalExpenditure = ((Number)json_data.get("Cash Assistance Total Expenditure")).intValue();// Categorical Assistance Intergovernmental
            this.categoricalAssistanceIntergovernmental = ((Number)json_data.get("Categorical Assistance Intergovernmental")).intValue();// Cash and Securities Total
            this.cashAndSecuritiesTotal = ((Number)json_data.get("Cash and Securities Total")).intValue();// Assistance and Subsidies
            this.assistanceAndSubsidies = ((Number)json_data.get("Assistance and Subsidies")).intValue();// Cash Assistance Intergovernmental
            this.cashAssistanceIntergovernmental = ((Number)json_data.get("Cash Assistance Intergovernmental")).intValue();// Borrowing Total
            this.borrowingTotal = ((Number)json_data.get("Borrowing Total")).intValue();// Sinking Fund Total
            this.sinkingFundTotal = ((Number)json_data.get("Sinking Fund Total")).intValue();// Securities Total
            this.securitiesTotal = ((Number)json_data.get("Securities Total")).intValue();// Bond Fund Total
            this.bondFundTotal = ((Number)json_data.get("Bond Fund Total")).intValue();// Cash and Deposits Total
            this.cashAndDepositsTotal = ((Number)json_data.get("Cash and Deposits Total")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a FinancialAid; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a FinancialAid; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}