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
	
    // Total amount spent on stocks and bonds, notes, mortgages, and other formal evidences of indebtedness.
    private Integer federalAgencySecuritiesTotal;
    // Total amount spent on long term debt. Long-term debt consists of loans and financial obligations lasting over one year.
    private Integer beginningLongTermDebtTotalOutstanding;
    // Total amount spent on Old Age Assistance, Temporary Assistance for Needy Families (TANF), and Medical Assistance.
    private Integer categoricalAssistanceTotalExpenditure;
    // Total amount spent on direct cash payments to beneficiaries of public welfare programs.
    private Integer cashAssistanceTotalExpenditure;
    // Money paid to other governments for Old Age Assistance, Temporary Assistance for Needy Families (TANF), and Medical Assistance.
    private Integer categoricalAssistanceIntergovernmental;
    // Total amount spent on cash and deposits and governmental and private securities (bonds, notes, mortgages, corporate stocks, etc., including loans and other credit paper held by state loan and investment funds) except holdings of agency and private trust funds. Includes fund investments in securities issued by government concerned but does not include interfund loans, receivables, and the value of real property and other fixed assets.
    private Integer cashAndSecuritiesTotal;
    // Total amount spent on cash contributions and subsidies to persons, not in payments for goods or services or claims against the government. For local governments, this object category comprises only direct cash assistance payments to public welfare recipients. For states, it includes also veterans' bonuses and direct cash grants for tuition, scholarships, and aid to nonpublic education institutions.
    private Integer assistanceAndSubsidies;
    // Money paid to other governments for cash assistance payments to public welfare recipients.
    private Integer cashAssistanceIntergovernmental;
    // Total amount borrowed.
    private Integer borrowingTotal;
    // Total amount spent on funds established specifically for the redemption of Long-term debt principal.
    private Integer sinkingFundTotal;
    // Total amount spent on stocks and bonds, notes, mortgages, and other formal evidences of indebtedness.
    private Integer securitiesTotal;
    // Total amount spent on funds established to account for the proceeds of bond issues pending their disbursement.
    private Integer bondFundTotal;
    // Total amount of cash on hand and demand and savings or time deposits.
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