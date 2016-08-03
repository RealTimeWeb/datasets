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
	
    // int , general expenditure
    private Integer generalExpenditure;
    // int , utility revenue
    private Integer utilityRevenue;
    // int , tax
    private Integer tax;
    // int , miscellaneous commercial activity
    private Integer miscellaneousCommercialActivity;
    // int , intergovernmental
    private Integer intergovernmental;
    // int , employee retirement revenue
    private Integer employeeRetirementRevenue;
    // int , insurance trust  revenue
    private Integer insuranceTrustRevenue;
    // int , equipment and land
    private Integer equipmentAndLand;
    // int , revenue
    private Integer revenue;
    // int , local intergovernmental
    private Integer localIntergovernmental;
    // int , capital outlay
    private Integer capitalOutlay;
    // int , state intergovernmental
    private Integer stateIntergovernmental;
    // int , miscellaneous
    private Integer miscellaneous;
    // int , construction
    private Integer construction;
    // int , expenditure
    private Integer expenditure;
    // int , general revenue
    private Integer generalRevenue;
    // int , other insurance trust revenue
    private Integer otherInsuranceTrustRevenue;
    // int , worker's comp revenue
    private Integer workersCompRevenue;
    // int , charges
    private Integer charges;
    // int , unemployment comp revenue
    private Integer unemploymentCompRevenue;
    // int , selective sales tax
    private Integer selectiveSalesTax;
    // int , sales tax
    private Integer salesTax;
    // int , license tax
    private Integer licenseTax;
    // int , federal intergovernmental
    private Integer federalIntergovernmental;
    
    
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
    public Integer getTax() {
        return this.tax;
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
    public Integer getIntergovernmental() {
        return this.intergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getEmployeeRetirementRevenue() {
        return this.employeeRetirementRevenue;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getInsuranceTrustRevenue() {
        return this.insuranceTrustRevenue;
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
    public Integer getRevenue() {
        return this.revenue;
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
    public Integer getCharges() {
        return this.charges;
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
    
    
    
	
	/**
	 * Creates a string based representation of this Totals.
	
	 * @return String
	 */
	public String toString() {
		return "Totals[" +generalExpenditure+", "+utilityRevenue+", "+tax+", "+miscellaneousCommercialActivity+", "+intergovernmental+", "+employeeRetirementRevenue+", "+insuranceTrustRevenue+", "+equipmentAndLand+", "+revenue+", "+localIntergovernmental+", "+capitalOutlay+", "+stateIntergovernmental+", "+miscellaneous+", "+construction+", "+expenditure+", "+generalRevenue+", "+otherInsuranceTrustRevenue+", "+workersCompRevenue+", "+charges+", "+unemploymentCompRevenue+", "+selectiveSalesTax+", "+salesTax+", "+licenseTax+", "+federalIntergovernmental+"]";
	}
	
	/**
	 * Internal constructor to create a Totals from a  representation.
	 * @param map The raw json data that will be parsed.
	 * @return 
	 */
    public Totals(JSONObject json_data) {
        try {// general expenditure
            this.generalExpenditure = new Integer(((Long)json_data.get("general expenditure")).intValue());// utility revenue
            this.utilityRevenue = new Integer(((Long)json_data.get("utility revenue")).intValue());// tax
            this.tax = new Integer(((Long)json_data.get("tax")).intValue());// miscellaneous commercial activity
            this.miscellaneousCommercialActivity = new Integer(((Long)json_data.get("miscellaneous commercial activity")).intValue());// intergovernmental
            this.intergovernmental = new Integer(((Long)json_data.get("intergovernmental")).intValue());// employee retirement revenue
            this.employeeRetirementRevenue = new Integer(((Long)json_data.get("employee retirement revenue")).intValue());// insurance trust  revenue
            this.insuranceTrustRevenue = new Integer(((Long)json_data.get("insurance trust  revenue")).intValue());// equipment and land
            this.equipmentAndLand = new Integer(((Long)json_data.get("equipment and land")).intValue());// revenue
            this.revenue = new Integer(((Long)json_data.get("revenue")).intValue());// local intergovernmental
            this.localIntergovernmental = new Integer(((Long)json_data.get("local intergovernmental")).intValue());// capital outlay
            this.capitalOutlay = new Integer(((Long)json_data.get("capital outlay")).intValue());// state intergovernmental
            this.stateIntergovernmental = new Integer(((Long)json_data.get("state intergovernmental")).intValue());// miscellaneous
            this.miscellaneous = new Integer(((Long)json_data.get("miscellaneous")).intValue());// construction
            this.construction = new Integer(((Long)json_data.get("construction")).intValue());// expenditure
            this.expenditure = new Integer(((Long)json_data.get("expenditure")).intValue());// general revenue
            this.generalRevenue = new Integer(((Long)json_data.get("general revenue")).intValue());// other insurance trust revenue
            this.otherInsuranceTrustRevenue = new Integer(((Long)json_data.get("other insurance trust revenue")).intValue());// worker's comp revenue
            this.workersCompRevenue = new Integer(((Long)json_data.get("worker's comp revenue")).intValue());// charges
            this.charges = new Integer(((Long)json_data.get("charges")).intValue());// unemployment comp revenue
            this.unemploymentCompRevenue = new Integer(((Long)json_data.get("unemployment comp revenue")).intValue());// selective sales tax
            this.selectiveSalesTax = new Integer(((Long)json_data.get("selective sales tax")).intValue());// sales tax
            this.salesTax = new Integer(((Long)json_data.get("sales tax")).intValue());// license tax
            this.licenseTax = new Integer(((Long)json_data.get("license tax")).intValue());// federal intergovernmental
            this.federalIntergovernmental = new Integer(((Long)json_data.get("federal intergovernmental")).intValue());
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Totals; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Totals; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}