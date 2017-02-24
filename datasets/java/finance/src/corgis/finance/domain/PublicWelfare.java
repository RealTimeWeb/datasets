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
public class PublicWelfare {
	
    // Total amount spent on equipment and land for public welfare.
    private Integer publicWelfareEquipmentAndLand;
    // Money paid to other governments for the public welfare.
    private Integer publicWelfareIntergovernmental;
    // Direct expenditure for compensation of own officers and employees and for supplies, materials, and contractual services except amounts for capital outlay related to public welfare.
    private Integer publicWelfareOtherCurrentOperation;
    // Payments to employees, suppliers, contractors, beneficiaries, and other final recipients of government payments (i.e., all expenditure other than Intergovernmental expenditure) for public welfare.
    private Integer publicWelfareDirectExpenditure;
    // Total amount spent on construction for public welfare.
    private Integer publicWelfareConstruction;
    // Total amount spent on support of and assistance to needy persons contingent upon their need. Excludes pensions to former employees and other benefits not contingent on need. Expenditures under this heading include: Cash assistance paid directly to needy persons under the categorical programs (Old Age Assistance, Temporary Assistance for Needy Families (TANF) and under any other welfare programs; Vendor payments made directly to private purveyors for medical care, burials, and other commodities and services provided under welfare programs; and provision and operation by the government of welfare institutions. Other public welfare includes payments to other governments for welfare purposes, amounts for administration, support of private welfare agencies, and other public welfare services. Health and hospital services provided directly by the government through its own hospitals and health agencies, and any payments to other governments for such purposes are classed under those functional headings rather than here.
    private Integer publicWelfareTotalExpenditure;
    // Assistance and subsidies related to public welfare.
    private Integer publicWelfareAssistanceAndSubsidies;
    
    
    /*
     * @return 
     */
    public Integer getPublicWelfareEquipmentAndLand() {
        return this.publicWelfareEquipmentAndLand;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getPublicWelfareIntergovernmental() {
        return this.publicWelfareIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getPublicWelfareOtherCurrentOperation() {
        return this.publicWelfareOtherCurrentOperation;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getPublicWelfareDirectExpenditure() {
        return this.publicWelfareDirectExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getPublicWelfareConstruction() {
        return this.publicWelfareConstruction;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getPublicWelfareTotalExpenditure() {
        return this.publicWelfareTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getPublicWelfareAssistanceAndSubsidies() {
        return this.publicWelfareAssistanceAndSubsidies;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this PublicWelfare.
	
	 * @return String
	 */
	public String toString() {
		return "PublicWelfare[" +publicWelfareEquipmentAndLand+", "+publicWelfareIntergovernmental+", "+publicWelfareOtherCurrentOperation+", "+publicWelfareDirectExpenditure+", "+publicWelfareConstruction+", "+publicWelfareTotalExpenditure+", "+publicWelfareAssistanceAndSubsidies+"]";
	}
	
	/**
	 * Internal constructor to create a PublicWelfare from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public PublicWelfare(JSONObject json_data) {
        try {// Public Welfare Equipment and Land
            this.publicWelfareEquipmentAndLand = ((Number)json_data.get("Public Welfare Equipment and Land")).intValue();// Public Welfare Intergovernmental
            this.publicWelfareIntergovernmental = ((Number)json_data.get("Public Welfare Intergovernmental")).intValue();// Public Welfare Other Current Operation
            this.publicWelfareOtherCurrentOperation = ((Number)json_data.get("Public Welfare Other Current Operation")).intValue();// Public Welfare Direct Expenditure
            this.publicWelfareDirectExpenditure = ((Number)json_data.get("Public Welfare Direct Expenditure")).intValue();// Public Welfare Construction
            this.publicWelfareConstruction = ((Number)json_data.get("Public Welfare Construction")).intValue();// Public Welfare Total Expenditure
            this.publicWelfareTotalExpenditure = ((Number)json_data.get("Public Welfare Total Expenditure")).intValue();// Public Welfare Assistance and Subsidies
            this.publicWelfareAssistanceAndSubsidies = ((Number)json_data.get("Public Welfare Assistance and Subsidies")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a PublicWelfare; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a PublicWelfare; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}