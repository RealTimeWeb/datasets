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
	
    private Integer insuranceTrustRevenue;
    private Integer capitalOutlay;
    private Integer stateIntergovernmental;
    private Integer miscellaneous;
    private Integer charges;
    private Integer construction;
    private Integer expenditure;
    private Integer generalRevenue;
    private Integer miscellaneousCommercialActivity;
    private Integer otherInsuranceTrustRevenue;
    private Integer workersCompRevenue;
    private Integer equipmentAndLand;
    private Integer unemploymentCompRevenue;
    private Integer selectiveSalesTax;
    private Integer salesTax;
    private Integer licenseTax;
    private Integer federalIntergovernmental;
    private Integer generalExpenditure;
    private Integer utilityRevenue;
    private Integer revenue;
    private Integer tax;
    private Integer localIntergovernmental;
    private Integer intergovernmental;
    private Integer employeeRetirementRevenue;
    
    
    /*
     * @return 
     */
    public Integer getInsuranceTrustRevenue() {
        return this.insuranceTrustRevenue;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getCapitalOutlay() {
        return this.capitalOutlay;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getStateIntergovernmental() {
        return this.stateIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getMiscellaneous() {
        return this.miscellaneous;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getCharges() {
        return this.charges;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getConstruction() {
        return this.construction;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getExpenditure() {
        return this.expenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getGeneralRevenue() {
        return this.generalRevenue;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getMiscellaneousCommercialActivity() {
        return this.miscellaneousCommercialActivity;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getOtherInsuranceTrustRevenue() {
        return this.otherInsuranceTrustRevenue;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getWorkersCompRevenue() {
        return this.workersCompRevenue;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getEquipmentAndLand() {
        return this.equipmentAndLand;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getUnemploymentCompRevenue() {
        return this.unemploymentCompRevenue;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getSelectiveSalesTax() {
        return this.selectiveSalesTax;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getSalesTax() {
        return this.salesTax;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getLicenseTax() {
        return this.licenseTax;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getFederalIntergovernmental() {
        return this.federalIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getGeneralExpenditure() {
        return this.generalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getUtilityRevenue() {
        return this.utilityRevenue;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getRevenue() {
        return this.revenue;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getTax() {
        return this.tax;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getLocalIntergovernmental() {
        return this.localIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getIntergovernmental() {
        return this.intergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getEmployeeRetirementRevenue() {
        return this.employeeRetirementRevenue;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Totals.
	
	 * @return String
	 */
	public String toString() {
		return "Totals[" +insuranceTrustRevenue+", "+capitalOutlay+", "+stateIntergovernmental+", "+miscellaneous+", "+charges+", "+construction+", "+expenditure+", "+generalRevenue+", "+miscellaneousCommercialActivity+", "+otherInsuranceTrustRevenue+", "+workersCompRevenue+", "+equipmentAndLand+", "+unemploymentCompRevenue+", "+selectiveSalesTax+", "+salesTax+", "+licenseTax+", "+federalIntergovernmental+", "+generalExpenditure+", "+utilityRevenue+", "+revenue+", "+tax+", "+localIntergovernmental+", "+intergovernmental+", "+employeeRetirementRevenue+"]";
	}
	
	/**
	 * Internal constructor to create a Totals from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Totals(JSONObject json_data) {
        try {// Insurance trust  revenue
            this.insuranceTrustRevenue = ((Number)json_data.get("Insurance trust  revenue")).intValue();// Capital outlay
            this.capitalOutlay = ((Number)json_data.get("Capital outlay")).intValue();// State intergovernmental
            this.stateIntergovernmental = ((Number)json_data.get("State intergovernmental")).intValue();// Miscellaneous
            this.miscellaneous = ((Number)json_data.get("Miscellaneous")).intValue();// Charges
            this.charges = ((Number)json_data.get("Charges")).intValue();// Construction
            this.construction = ((Number)json_data.get("Construction")).intValue();// Expenditure
            this.expenditure = ((Number)json_data.get("Expenditure")).intValue();// General revenue
            this.generalRevenue = ((Number)json_data.get("General revenue")).intValue();// Miscellaneous commercial activity
            this.miscellaneousCommercialActivity = ((Number)json_data.get("Miscellaneous commercial activity")).intValue();// Other insurance trust revenue
            this.otherInsuranceTrustRevenue = ((Number)json_data.get("Other insurance trust revenue")).intValue();// Worker's comp revenue
            this.workersCompRevenue = ((Number)json_data.get("Worker's comp revenue")).intValue();// Equipment and land
            this.equipmentAndLand = ((Number)json_data.get("Equipment and land")).intValue();// Unemployment comp revenue
            this.unemploymentCompRevenue = ((Number)json_data.get("Unemployment comp revenue")).intValue();// Selective sales tax
            this.selectiveSalesTax = ((Number)json_data.get("Selective sales tax")).intValue();// Sales tax
            this.salesTax = ((Number)json_data.get("Sales tax")).intValue();// License tax
            this.licenseTax = ((Number)json_data.get("License tax")).intValue();// Federal intergovernmental
            this.federalIntergovernmental = ((Number)json_data.get("Federal intergovernmental")).intValue();// General expenditure
            this.generalExpenditure = ((Number)json_data.get("General expenditure")).intValue();// Utility revenue
            this.utilityRevenue = ((Number)json_data.get("Utility revenue")).intValue();// Revenue
            this.revenue = ((Number)json_data.get("Revenue")).intValue();// Tax
            this.tax = ((Number)json_data.get("Tax")).intValue();// Local intergovernmental
            this.localIntergovernmental = ((Number)json_data.get("Local intergovernmental")).intValue();// Intergovernmental
            this.intergovernmental = ((Number)json_data.get("Intergovernmental")).intValue();// Employee retirement revenue
            this.employeeRetirementRevenue = ((Number)json_data.get("Employee retirement revenue")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Totals; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Totals; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}