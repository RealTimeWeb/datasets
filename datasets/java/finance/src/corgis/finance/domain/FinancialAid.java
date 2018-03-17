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
	
    // Total amount spent on funds established to account for the proceeds of bond issues pending their disbursement.
    private Integer bondFundTotal;
    // Total amount of cash on hand and demand and savings or time deposits.
    private Integer cashAndDepositsTotal;
    // Total amount spent on cash contributions and subsidies to persons, not in payments for goods or services or claims against the government. For local governments, this object category comprises only direct cash assistance payments to public welfare recipients. For states, it includes also veterans' bonuses and direct cash grants for tuition, scholarships, and aid to nonpublic education institutions.
    private Integer assistanceAndSubsidies;
    // Total amount spent on cash and deposits and governmental and private securities (bonds, notes, mortgages, corporate stocks, etc., including loans and other credit paper held by state loan and investment funds) except holdings of agency and private trust funds. Includes fund investments in securities issued by government concerned but does not include interfund loans, receivables, and the value of real property and other fixed assets.
    private Integer cashAndSecuritiesTotal;
    // Total amount spent on Old Age Assistance, Temporary Assistance for Needy Families (TANF), and Medical Assistance.
    private Integer categoricalAssistanceTotalExpenditure;
    // Money paid to other governments for Old Age Assistance, Temporary Assistance for Needy Families (TANF), and Medical Assistance.
    private Integer categoricalAssistanceIntergovernmental;
    // Total amount spent on funds established specifically for the redemption of Long-term debt principal.
    private Integer sinkingFundTotal;
    // Total amount spent on stocks and bonds, notes, mortgages, and other formal evidences of indebtedness.
    private Integer securitiesTotal;
    // Total amount spent on stocks and bonds, notes, mortgages, and other formal evidences of indebtedness.
    private Integer federalAgencySecuritiesTotal;
    // Total amount spent on direct cash payments to beneficiaries of public welfare programs.
    private Integer cashAssistanceTotalExpenditure;
    // Total amount spent on long term debt. Long-term debt consists of loans and financial obligations lasting over one year.
    private Integer beginningLongTermDebtTotalOutstanding;
    // Total amount borrowed.
    private Integer borrowingTotal;
    // Money paid to other governments for cash assistance payments to public welfare recipients.
    private Integer cashAssistanceIntergovernmental;
    
    
    /**
     * Total amount spent on funds established to account for the proceeds of bond issues pending their disbursement.
     * @return Integer
     */
    public Integer getBondFundTotal() {
        return this.bondFundTotal;
    }
    
    
    
    /**
     * Total amount of cash on hand and demand and savings or time deposits.
     * @return Integer
     */
    public Integer getCashAndDepositsTotal() {
        return this.cashAndDepositsTotal;
    }
    
    
    
    /**
     * Total amount spent on cash contributions and subsidies to persons, not in payments for goods or services or claims against the government. For local governments, this object category comprises only direct cash assistance payments to public welfare recipients. For states, it includes also veterans' bonuses and direct cash grants for tuition, scholarships, and aid to nonpublic education institutions.
     * @return Integer
     */
    public Integer getAssistanceAndSubsidies() {
        return this.assistanceAndSubsidies;
    }
    
    
    
    /**
     * Total amount spent on cash and deposits and governmental and private securities (bonds, notes, mortgages, corporate stocks, etc., including loans and other credit paper held by state loan and investment funds) except holdings of agency and private trust funds. Includes fund investments in securities issued by government concerned but does not include interfund loans, receivables, and the value of real property and other fixed assets.
     * @return Integer
     */
    public Integer getCashAndSecuritiesTotal() {
        return this.cashAndSecuritiesTotal;
    }
    
    
    
    /**
     * Total amount spent on Old Age Assistance, Temporary Assistance for Needy Families (TANF), and Medical Assistance.
     * @return Integer
     */
    public Integer getCategoricalAssistanceTotalExpenditure() {
        return this.categoricalAssistanceTotalExpenditure;
    }
    
    
    
    /**
     * Money paid to other governments for Old Age Assistance, Temporary Assistance for Needy Families (TANF), and Medical Assistance.
     * @return Integer
     */
    public Integer getCategoricalAssistanceIntergovernmental() {
        return this.categoricalAssistanceIntergovernmental;
    }
    
    
    
    /**
     * Total amount spent on funds established specifically for the redemption of Long-term debt principal.
     * @return Integer
     */
    public Integer getSinkingFundTotal() {
        return this.sinkingFundTotal;
    }
    
    
    
    /**
     * Total amount spent on stocks and bonds, notes, mortgages, and other formal evidences of indebtedness.
     * @return Integer
     */
    public Integer getSecuritiesTotal() {
        return this.securitiesTotal;
    }
    
    
    
    /**
     * Total amount spent on stocks and bonds, notes, mortgages, and other formal evidences of indebtedness.
     * @return Integer
     */
    public Integer getFederalAgencySecuritiesTotal() {
        return this.federalAgencySecuritiesTotal;
    }
    
    
    
    /**
     * Total amount spent on direct cash payments to beneficiaries of public welfare programs.
     * @return Integer
     */
    public Integer getCashAssistanceTotalExpenditure() {
        return this.cashAssistanceTotalExpenditure;
    }
    
    
    
    /**
     * Total amount spent on long term debt. Long-term debt consists of loans and financial obligations lasting over one year.
     * @return Integer
     */
    public Integer getBeginningLongTermDebtTotalOutstanding() {
        return this.beginningLongTermDebtTotalOutstanding;
    }
    
    
    
    /**
     * Total amount borrowed.
     * @return Integer
     */
    public Integer getBorrowingTotal() {
        return this.borrowingTotal;
    }
    
    
    
    /**
     * Money paid to other governments for cash assistance payments to public welfare recipients.
     * @return Integer
     */
    public Integer getCashAssistanceIntergovernmental() {
        return this.cashAssistanceIntergovernmental;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this FinancialAid.
	
	 * @return String
	 */
	public String toString() {
		return "FinancialAid[" +bondFundTotal+", "+cashAndDepositsTotal+", "+assistanceAndSubsidies+", "+cashAndSecuritiesTotal+", "+categoricalAssistanceTotalExpenditure+", "+categoricalAssistanceIntergovernmental+", "+sinkingFundTotal+", "+securitiesTotal+", "+federalAgencySecuritiesTotal+", "+cashAssistanceTotalExpenditure+", "+beginningLongTermDebtTotalOutstanding+", "+borrowingTotal+", "+cashAssistanceIntergovernmental+"]";
	}
	
	/**
	 * Internal constructor to create a FinancialAid from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public FinancialAid(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Bond Fund Total
            this.bondFundTotal = ((Number)json_data.get("Bond Fund Total")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a FinancialAid; the field bondFundTotal was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a FinancialAid; the field bondFundTotal had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Cash and Deposits Total
            this.cashAndDepositsTotal = ((Number)json_data.get("Cash and Deposits Total")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a FinancialAid; the field cashAndDepositsTotal was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a FinancialAid; the field cashAndDepositsTotal had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Assistance and Subsidies
            this.assistanceAndSubsidies = ((Number)json_data.get("Assistance and Subsidies")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a FinancialAid; the field assistanceAndSubsidies was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a FinancialAid; the field assistanceAndSubsidies had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Cash and Securities Total
            this.cashAndSecuritiesTotal = ((Number)json_data.get("Cash and Securities Total")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a FinancialAid; the field cashAndSecuritiesTotal was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a FinancialAid; the field cashAndSecuritiesTotal had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Categorical Assistance Total Expenditure
            this.categoricalAssistanceTotalExpenditure = ((Number)json_data.get("Categorical Assistance Total Expenditure")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a FinancialAid; the field categoricalAssistanceTotalExpenditure was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a FinancialAid; the field categoricalAssistanceTotalExpenditure had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Categorical Assistance Intergovernmental
            this.categoricalAssistanceIntergovernmental = ((Number)json_data.get("Categorical Assistance Intergovernmental")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a FinancialAid; the field categoricalAssistanceIntergovernmental was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a FinancialAid; the field categoricalAssistanceIntergovernmental had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Sinking Fund Total
            this.sinkingFundTotal = ((Number)json_data.get("Sinking Fund Total")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a FinancialAid; the field sinkingFundTotal was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a FinancialAid; the field sinkingFundTotal had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Securities Total
            this.securitiesTotal = ((Number)json_data.get("Securities Total")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a FinancialAid; the field securitiesTotal was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a FinancialAid; the field securitiesTotal had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Federal Agency Securities Total
            this.federalAgencySecuritiesTotal = ((Number)json_data.get("Federal Agency Securities Total")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a FinancialAid; the field federalAgencySecuritiesTotal was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a FinancialAid; the field federalAgencySecuritiesTotal had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Cash Assistance Total Expenditure
            this.cashAssistanceTotalExpenditure = ((Number)json_data.get("Cash Assistance Total Expenditure")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a FinancialAid; the field cashAssistanceTotalExpenditure was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a FinancialAid; the field cashAssistanceTotalExpenditure had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Beginning Long Term Debt Total Outstanding
            this.beginningLongTermDebtTotalOutstanding = ((Number)json_data.get("Beginning Long Term Debt Total Outstanding")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a FinancialAid; the field beginningLongTermDebtTotalOutstanding was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a FinancialAid; the field beginningLongTermDebtTotalOutstanding had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Borrowing Total
            this.borrowingTotal = ((Number)json_data.get("Borrowing Total")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a FinancialAid; the field borrowingTotal was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a FinancialAid; the field borrowingTotal had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Cash Assistance Intergovernmental
            this.cashAssistanceIntergovernmental = ((Number)json_data.get("Cash Assistance Intergovernmental")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a FinancialAid; the field cashAssistanceIntergovernmental was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a FinancialAid; the field cashAssistanceIntergovernmental had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}