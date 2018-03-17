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
public class Totals {
	
    // Amounts from local governments: for shares in financial support of programs administered by the state; for reimbursements of services performed or expenditures made for them by the state; for application to debt services on state debt issued for their benefit; and for repayment of advances and contingent loans extended to them. Does not include local government contributions to state-administered employee retirement or other insurance trust systems, which are classified as insurance trust revenue, or agency transactions (see Agency and private trust transactions). Excludes proceeds from interest on local government securities held by the state and proceeds from state taxes on local government facilities.
    private Integer localIntergovernmental;
    // Revenue from contributions required of employers and employees for financing social insurance programs operated by the government (see Insurance trust system, below) and earnings on assets held for such systems. Excludes any contributions by a government - either as employer contributions or for general financial support - to a social insurance system it administers. Note that tax proceeds, donations, and any forms of revenue other than those enumerated above are classified as general revenue, even though such amounts may be received specifically for insurance trust purposes.
    private Integer insuranceTrustRevenue;
    // Intergovernmental revenue received by a government directly from the federal government. For local governments, excludes federal aid channeled through state governments, which is considered as Intergovernmental revenue from state government.
    private Integer federalIntergovernmental;
    // All amounts of money received by a government from external sources--net of refunds and other correcting transactions--other than from issuance of debt, liquidation of investments, and as agency and private trust transactions. Note that revenue excludes noncash transactions such as receipt of services, commodities, or other "receipts in kind."
    private Integer revenue;
    // Sales and gross receipts taxes imposed on sales of particular commodities or services or gross receipts of particular businesses, separately and apart from the application of general sales and gross receipts taxes. Specific selective sales taxes included are alcoholic beverages, amusements, insurance, motor fuels, parimutuels, public utilities, tobacco products, and others.
    private Integer selectiveSalesTax;
    // Apparatus, furnishings, motor vehicles, office machines, and the like having an expected life of more than 5 years. Equipment expenditure consists only of amounts for purchase of equipment, including both additional equipment and replacements. Expenditures for facilities that are integral parts of structures are classified as expenditure for construction or for purchase of land and existing structures.
    private Integer equipmentAndLand;
    private Integer employeeRetirementRevenue;
    // Sales or gross receipts taxes which are applicable with only specified exceptions to all types of goods and services, or all gross income, whether at a single rate or at classified rates. Taxes imposed distinctively upon sales or gross receipts from selected commodities, services, or business are reported separately under categories one through eight below.
    private Integer salesTax;
    // All government revenue except Liquor stores revenue, Insurance trust revenue, and Utility revenue. The basis for distinction is not the fund or administrative unit receiving particular amounts, but rather the nature of the revenue sources concerned.
    private Integer generalRevenue;
    // Amounts received from other governments as fiscal aid in the form of shared revenues and grants-in -aid, as reimbursements for performance of general government functions and specific services for the paying government (e.g., care of prisoners or contractual research), or in lieu of taxes, Excludes amounts received from other governments for sale of property, commodities, and utility services. All intergovernmental revenue is classified as General revenue.
    private Integer intergovernmental;
    // Provision and operation of commercial facilities not classified under particular functions. Includes a bank (North Dakota), and cement plant, hail insurance systems, and the like.
    private Integer miscellaneousCommercialActivity;
    // Revenue from sale of utility commodities and services to the public and to other governments. Does not include amounts from sales to the parent government. Also excludes income from utility fund investments and from other nonoperating properties (treated as General revenue). Any monies from taxes, special assessments, and intergovernmental revenue are classified as General revenue, not Utility revenue.
    private Integer utilityRevenue;
    // General expenditure for purposes and activities not falling within any standard functional category and unallocated amounts relating to two or more functions.
    private Integer miscellaneous;
    // Compulsory contributions exacted by a government for public purposes except employee and employee assessments for retirement and social insurance purposes, which are classified as insurance trust revenue. All tax revenue is classified as general revenue and comprises amounts received (including interest and penalties but excluding protested amounts and refunds) from all taxes imposed by a government. Note that local government tax revenue excludes any amounts from shares of state-imposed and collected taxes, which are classified as Intergovernmental revenue.
    private Integer tax;
    // Revenue related to Unemployment Compensation.
    private Integer unemploymentCompRevenue;
    // Taxes exacted (either for revenue raising or for regulation) as a condition to the exercise of a business or nonbusiness privilege, at a flat rate or measured by such bases as capital stock, capital surplus, number of business units, or capacity. Excludes taxes measured directly by transactions, gross or net income, or value of property except those to which only nominal rates apply. "License" based on these latter measures, other than those at nominal rates, are classified according to the measure concerned. Includes "fees" related to licensing activities - automobile inspection, gasoline and oil inspection, professional examinations and licenses, etc. - as well as license taxes producing substantial revenue.
    private Integer licenseTax;
    // Production of fixed works and structures additions, replacements, and major alterations, including planning and design of specific projects, site improvements, and provision of equipment and facilities that are integral parts of a structure. Includes contract construction, undertaken on a contract basis by private contractors, and force account construction, undertaken with direct use of material and labor by the government.
    private Integer construction;
    // Charges imposed for providing current services or for the sale of products in connection with general government activities.
    private Integer charges;
    // Direct expenditure for contract or force account construction of buildings,grounds, and other improvements, and purchase of equipment, land, and existing structures. Includes amounts for additions, replacements, and major alterations to fixed works and structures. However, expenditure for repairs to such works and structures is classified as current operation expenditure.
    private Integer capitalOutlay;
    // All intergovernmental revenue received from the state government. For local governments, includes amounts originally from the federal government but channeled through the state.
    private Integer stateIntergovernmental;
    // All amounts of money paid out by a government--net of recoveries and other correcting transactions--other than for retirement of debt, investment in securities, extension of credit, or as agency transactions. Note that expenditure includes only external transactions of a government and excludes non-cash transactions such as the provision of perquisites or other payments in kind.
    private Integer expenditure;
    // Revenue related to Worker's Compensation.
    private Integer workersCompRevenue;
    // Amounts paid to other governments as fiscal aid in the form of shared revenues and grants-in-aid, as reimbursements for performance of general government activities and for specific services for the paying government, or in lieu of taxes. Excludes amounts paid to other governments for purchase of commodities, property, or utility services, any tax imposed and paid as such, and employer contributions for social insurance - e.g., contributions to the Federal Government for Old Age, Survivors', Disability, and Health Insurance for government employees.
    private Integer generalExpenditure;
    // Other revenue related to ITR.
    private Integer otherInsuranceTrustRevenue;
    
    
    /**
     * Amounts from local governments: for shares in financial support of programs administered by the state; for reimbursements of services performed or expenditures made for them by the state; for application to debt services on state debt issued for their benefit; and for repayment of advances and contingent loans extended to them. Does not include local government contributions to state-administered employee retirement or other insurance trust systems, which are classified as insurance trust revenue, or agency transactions (see Agency and private trust transactions). Excludes proceeds from interest on local government securities held by the state and proceeds from state taxes on local government facilities.
     * @return Integer
     */
    public Integer getLocalIntergovernmental() {
        return this.localIntergovernmental;
    }
    
    
    
    /**
     * Revenue from contributions required of employers and employees for financing social insurance programs operated by the government (see Insurance trust system, below) and earnings on assets held for such systems. Excludes any contributions by a government - either as employer contributions or for general financial support - to a social insurance system it administers. Note that tax proceeds, donations, and any forms of revenue other than those enumerated above are classified as general revenue, even though such amounts may be received specifically for insurance trust purposes.
     * @return Integer
     */
    public Integer getInsuranceTrustRevenue() {
        return this.insuranceTrustRevenue;
    }
    
    
    
    /**
     * Intergovernmental revenue received by a government directly from the federal government. For local governments, excludes federal aid channeled through state governments, which is considered as Intergovernmental revenue from state government.
     * @return Integer
     */
    public Integer getFederalIntergovernmental() {
        return this.federalIntergovernmental;
    }
    
    
    
    /**
     * All amounts of money received by a government from external sources--net of refunds and other correcting transactions--other than from issuance of debt, liquidation of investments, and as agency and private trust transactions. Note that revenue excludes noncash transactions such as receipt of services, commodities, or other "receipts in kind."
     * @return Integer
     */
    public Integer getRevenue() {
        return this.revenue;
    }
    
    
    
    /**
     * Sales and gross receipts taxes imposed on sales of particular commodities or services or gross receipts of particular businesses, separately and apart from the application of general sales and gross receipts taxes. Specific selective sales taxes included are alcoholic beverages, amusements, insurance, motor fuels, parimutuels, public utilities, tobacco products, and others.
     * @return Integer
     */
    public Integer getSelectiveSalesTax() {
        return this.selectiveSalesTax;
    }
    
    
    
    /**
     * Apparatus, furnishings, motor vehicles, office machines, and the like having an expected life of more than 5 years. Equipment expenditure consists only of amounts for purchase of equipment, including both additional equipment and replacements. Expenditures for facilities that are integral parts of structures are classified as expenditure for construction or for purchase of land and existing structures.
     * @return Integer
     */
    public Integer getEquipmentAndLand() {
        return this.equipmentAndLand;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getEmployeeRetirementRevenue() {
        return this.employeeRetirementRevenue;
    }
    
    
    
    /**
     * Sales or gross receipts taxes which are applicable with only specified exceptions to all types of goods and services, or all gross income, whether at a single rate or at classified rates. Taxes imposed distinctively upon sales or gross receipts from selected commodities, services, or business are reported separately under categories one through eight below.
     * @return Integer
     */
    public Integer getSalesTax() {
        return this.salesTax;
    }
    
    
    
    /**
     * All government revenue except Liquor stores revenue, Insurance trust revenue, and Utility revenue. The basis for distinction is not the fund or administrative unit receiving particular amounts, but rather the nature of the revenue sources concerned.
     * @return Integer
     */
    public Integer getGeneralRevenue() {
        return this.generalRevenue;
    }
    
    
    
    /**
     * Amounts received from other governments as fiscal aid in the form of shared revenues and grants-in -aid, as reimbursements for performance of general government functions and specific services for the paying government (e.g., care of prisoners or contractual research), or in lieu of taxes, Excludes amounts received from other governments for sale of property, commodities, and utility services. All intergovernmental revenue is classified as General revenue.
     * @return Integer
     */
    public Integer getIntergovernmental() {
        return this.intergovernmental;
    }
    
    
    
    /**
     * Provision and operation of commercial facilities not classified under particular functions. Includes a bank (North Dakota), and cement plant, hail insurance systems, and the like.
     * @return Integer
     */
    public Integer getMiscellaneousCommercialActivity() {
        return this.miscellaneousCommercialActivity;
    }
    
    
    
    /**
     * Revenue from sale of utility commodities and services to the public and to other governments. Does not include amounts from sales to the parent government. Also excludes income from utility fund investments and from other nonoperating properties (treated as General revenue). Any monies from taxes, special assessments, and intergovernmental revenue are classified as General revenue, not Utility revenue.
     * @return Integer
     */
    public Integer getUtilityRevenue() {
        return this.utilityRevenue;
    }
    
    
    
    /**
     * General expenditure for purposes and activities not falling within any standard functional category and unallocated amounts relating to two or more functions.
     * @return Integer
     */
    public Integer getMiscellaneous() {
        return this.miscellaneous;
    }
    
    
    
    /**
     * Compulsory contributions exacted by a government for public purposes except employee and employee assessments for retirement and social insurance purposes, which are classified as insurance trust revenue. All tax revenue is classified as general revenue and comprises amounts received (including interest and penalties but excluding protested amounts and refunds) from all taxes imposed by a government. Note that local government tax revenue excludes any amounts from shares of state-imposed and collected taxes, which are classified as Intergovernmental revenue.
     * @return Integer
     */
    public Integer getTax() {
        return this.tax;
    }
    
    
    
    /**
     * Revenue related to Unemployment Compensation.
     * @return Integer
     */
    public Integer getUnemploymentCompRevenue() {
        return this.unemploymentCompRevenue;
    }
    
    
    
    /**
     * Taxes exacted (either for revenue raising or for regulation) as a condition to the exercise of a business or nonbusiness privilege, at a flat rate or measured by such bases as capital stock, capital surplus, number of business units, or capacity. Excludes taxes measured directly by transactions, gross or net income, or value of property except those to which only nominal rates apply. "License" based on these latter measures, other than those at nominal rates, are classified according to the measure concerned. Includes "fees" related to licensing activities - automobile inspection, gasoline and oil inspection, professional examinations and licenses, etc. - as well as license taxes producing substantial revenue.
     * @return Integer
     */
    public Integer getLicenseTax() {
        return this.licenseTax;
    }
    
    
    
    /**
     * Production of fixed works and structures additions, replacements, and major alterations, including planning and design of specific projects, site improvements, and provision of equipment and facilities that are integral parts of a structure. Includes contract construction, undertaken on a contract basis by private contractors, and force account construction, undertaken with direct use of material and labor by the government.
     * @return Integer
     */
    public Integer getConstruction() {
        return this.construction;
    }
    
    
    
    /**
     * Charges imposed for providing current services or for the sale of products in connection with general government activities.
     * @return Integer
     */
    public Integer getCharges() {
        return this.charges;
    }
    
    
    
    /**
     * Direct expenditure for contract or force account construction of buildings,grounds, and other improvements, and purchase of equipment, land, and existing structures. Includes amounts for additions, replacements, and major alterations to fixed works and structures. However, expenditure for repairs to such works and structures is classified as current operation expenditure.
     * @return Integer
     */
    public Integer getCapitalOutlay() {
        return this.capitalOutlay;
    }
    
    
    
    /**
     * All intergovernmental revenue received from the state government. For local governments, includes amounts originally from the federal government but channeled through the state.
     * @return Integer
     */
    public Integer getStateIntergovernmental() {
        return this.stateIntergovernmental;
    }
    
    
    
    /**
     * All amounts of money paid out by a government--net of recoveries and other correcting transactions--other than for retirement of debt, investment in securities, extension of credit, or as agency transactions. Note that expenditure includes only external transactions of a government and excludes non-cash transactions such as the provision of perquisites or other payments in kind.
     * @return Integer
     */
    public Integer getExpenditure() {
        return this.expenditure;
    }
    
    
    
    /**
     * Revenue related to Worker's Compensation.
     * @return Integer
     */
    public Integer getWorkersCompRevenue() {
        return this.workersCompRevenue;
    }
    
    
    
    /**
     * Amounts paid to other governments as fiscal aid in the form of shared revenues and grants-in-aid, as reimbursements for performance of general government activities and for specific services for the paying government, or in lieu of taxes. Excludes amounts paid to other governments for purchase of commodities, property, or utility services, any tax imposed and paid as such, and employer contributions for social insurance - e.g., contributions to the Federal Government for Old Age, Survivors', Disability, and Health Insurance for government employees.
     * @return Integer
     */
    public Integer getGeneralExpenditure() {
        return this.generalExpenditure;
    }
    
    
    
    /**
     * Other revenue related to ITR.
     * @return Integer
     */
    public Integer getOtherInsuranceTrustRevenue() {
        return this.otherInsuranceTrustRevenue;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Totals.
	
	 * @return String
	 */
	public String toString() {
		return "Totals[" +localIntergovernmental+", "+insuranceTrustRevenue+", "+federalIntergovernmental+", "+revenue+", "+selectiveSalesTax+", "+equipmentAndLand+", "+employeeRetirementRevenue+", "+salesTax+", "+generalRevenue+", "+intergovernmental+", "+miscellaneousCommercialActivity+", "+utilityRevenue+", "+miscellaneous+", "+tax+", "+unemploymentCompRevenue+", "+licenseTax+", "+construction+", "+charges+", "+capitalOutlay+", "+stateIntergovernmental+", "+expenditure+", "+workersCompRevenue+", "+generalExpenditure+", "+otherInsuranceTrustRevenue+"]";
	}
	
	/**
	 * Internal constructor to create a Totals from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Totals(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Local intergovernmental
            this.localIntergovernmental = ((Number)json_data.get("Local intergovernmental")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Totals; the field localIntergovernmental was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Totals; the field localIntergovernmental had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Insurance trust  revenue
            this.insuranceTrustRevenue = ((Number)json_data.get("Insurance trust  revenue")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Totals; the field insuranceTrustRevenue was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Totals; the field insuranceTrustRevenue had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Federal intergovernmental
            this.federalIntergovernmental = ((Number)json_data.get("Federal intergovernmental")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Totals; the field federalIntergovernmental was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Totals; the field federalIntergovernmental had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Revenue
            this.revenue = ((Number)json_data.get("Revenue")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Totals; the field revenue was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Totals; the field revenue had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Selective sales tax
            this.selectiveSalesTax = ((Number)json_data.get("Selective sales tax")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Totals; the field selectiveSalesTax was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Totals; the field selectiveSalesTax had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Equipment and land
            this.equipmentAndLand = ((Number)json_data.get("Equipment and land")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Totals; the field equipmentAndLand was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Totals; the field equipmentAndLand had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Employee retirement revenue
            this.employeeRetirementRevenue = ((Number)json_data.get("Employee retirement revenue")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Totals; the field employeeRetirementRevenue was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Totals; the field employeeRetirementRevenue had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Sales tax
            this.salesTax = ((Number)json_data.get("Sales tax")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Totals; the field salesTax was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Totals; the field salesTax had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // General revenue
            this.generalRevenue = ((Number)json_data.get("General revenue")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Totals; the field generalRevenue was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Totals; the field generalRevenue had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Intergovernmental
            this.intergovernmental = ((Number)json_data.get("Intergovernmental")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Totals; the field intergovernmental was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Totals; the field intergovernmental had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Miscellaneous commercial activity
            this.miscellaneousCommercialActivity = ((Number)json_data.get("Miscellaneous commercial activity")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Totals; the field miscellaneousCommercialActivity was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Totals; the field miscellaneousCommercialActivity had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Utility revenue
            this.utilityRevenue = ((Number)json_data.get("Utility revenue")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Totals; the field utilityRevenue was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Totals; the field utilityRevenue had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Miscellaneous
            this.miscellaneous = ((Number)json_data.get("Miscellaneous")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Totals; the field miscellaneous was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Totals; the field miscellaneous had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Tax
            this.tax = ((Number)json_data.get("Tax")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Totals; the field tax was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Totals; the field tax had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Unemployment comp revenue
            this.unemploymentCompRevenue = ((Number)json_data.get("Unemployment comp revenue")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Totals; the field unemploymentCompRevenue was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Totals; the field unemploymentCompRevenue had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // License tax
            this.licenseTax = ((Number)json_data.get("License tax")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Totals; the field licenseTax was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Totals; the field licenseTax had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Construction
            this.construction = ((Number)json_data.get("Construction")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Totals; the field construction was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Totals; the field construction had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Charges
            this.charges = ((Number)json_data.get("Charges")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Totals; the field charges was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Totals; the field charges had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Capital outlay
            this.capitalOutlay = ((Number)json_data.get("Capital outlay")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Totals; the field capitalOutlay was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Totals; the field capitalOutlay had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // State intergovernmental
            this.stateIntergovernmental = ((Number)json_data.get("State intergovernmental")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Totals; the field stateIntergovernmental was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Totals; the field stateIntergovernmental had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Expenditure
            this.expenditure = ((Number)json_data.get("Expenditure")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Totals; the field expenditure was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Totals; the field expenditure had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Worker's comp revenue
            this.workersCompRevenue = ((Number)json_data.get("Worker's comp revenue")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Totals; the field workersCompRevenue was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Totals; the field workersCompRevenue had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // General expenditure
            this.generalExpenditure = ((Number)json_data.get("General expenditure")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Totals; the field generalExpenditure was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Totals; the field generalExpenditure had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Other insurance trust revenue
            this.otherInsuranceTrustRevenue = ((Number)json_data.get("Other insurance trust revenue")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Totals; the field otherInsuranceTrustRevenue was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Totals; the field otherInsuranceTrustRevenue had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}