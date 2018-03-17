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
	
    // Payments to employees, suppliers, contractors, beneficiaries, and other final recipients of government payments (i.e., all expenditure other than Intergovernmental expenditure) for public welfare.
    private Integer publicWelfareDirectExpenditure;
    // Direct expenditure for compensation of own officers and employees and for supplies, materials, and contractual services except amounts for capital outlay related to public welfare.
    private Integer publicWelfareOtherCurrentOperation;
    // Total amount spent on support of and assistance to needy persons contingent upon their need. Excludes pensions to former employees and other benefits not contingent on need. Expenditures under this heading include: Cash assistance paid directly to needy persons under the categorical programs (Old Age Assistance, Temporary Assistance for Needy Families (TANF) and under any other welfare programs; Vendor payments made directly to private purveyors for medical care, burials, and other commodities and services provided under welfare programs; and provision and operation by the government of welfare institutions. Other public welfare includes payments to other governments for welfare purposes, amounts for administration, support of private welfare agencies, and other public welfare services. Health and hospital services provided directly by the government through its own hospitals and health agencies, and any payments to other governments for such purposes are classed under those functional headings rather than here.
    private Integer publicWelfareTotalExpenditure;
    // Money paid to other governments for the public welfare.
    private Integer publicWelfareIntergovernmental;
    // Assistance and subsidies related to public welfare.
    private Integer publicWelfareAssistanceAndSubsidies;
    // Total amount spent on construction for public welfare.
    private Integer publicWelfareConstruction;
    // Total amount spent on equipment and land for public welfare.
    private Integer publicWelfareEquipmentAndLand;
    
    
    /**
     * Payments to employees, suppliers, contractors, beneficiaries, and other final recipients of government payments (i.e., all expenditure other than Intergovernmental expenditure) for public welfare.
     * @return Integer
     */
    public Integer getPublicWelfareDirectExpenditure() {
        return this.publicWelfareDirectExpenditure;
    }
    
    
    
    /**
     * Direct expenditure for compensation of own officers and employees and for supplies, materials, and contractual services except amounts for capital outlay related to public welfare.
     * @return Integer
     */
    public Integer getPublicWelfareOtherCurrentOperation() {
        return this.publicWelfareOtherCurrentOperation;
    }
    
    
    
    /**
     * Total amount spent on support of and assistance to needy persons contingent upon their need. Excludes pensions to former employees and other benefits not contingent on need. Expenditures under this heading include: Cash assistance paid directly to needy persons under the categorical programs (Old Age Assistance, Temporary Assistance for Needy Families (TANF) and under any other welfare programs; Vendor payments made directly to private purveyors for medical care, burials, and other commodities and services provided under welfare programs; and provision and operation by the government of welfare institutions. Other public welfare includes payments to other governments for welfare purposes, amounts for administration, support of private welfare agencies, and other public welfare services. Health and hospital services provided directly by the government through its own hospitals and health agencies, and any payments to other governments for such purposes are classed under those functional headings rather than here.
     * @return Integer
     */
    public Integer getPublicWelfareTotalExpenditure() {
        return this.publicWelfareTotalExpenditure;
    }
    
    
    
    /**
     * Money paid to other governments for the public welfare.
     * @return Integer
     */
    public Integer getPublicWelfareIntergovernmental() {
        return this.publicWelfareIntergovernmental;
    }
    
    
    
    /**
     * Assistance and subsidies related to public welfare.
     * @return Integer
     */
    public Integer getPublicWelfareAssistanceAndSubsidies() {
        return this.publicWelfareAssistanceAndSubsidies;
    }
    
    
    
    /**
     * Total amount spent on construction for public welfare.
     * @return Integer
     */
    public Integer getPublicWelfareConstruction() {
        return this.publicWelfareConstruction;
    }
    
    
    
    /**
     * Total amount spent on equipment and land for public welfare.
     * @return Integer
     */
    public Integer getPublicWelfareEquipmentAndLand() {
        return this.publicWelfareEquipmentAndLand;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this PublicWelfare.
	
	 * @return String
	 */
	public String toString() {
		return "PublicWelfare[" +publicWelfareDirectExpenditure+", "+publicWelfareOtherCurrentOperation+", "+publicWelfareTotalExpenditure+", "+publicWelfareIntergovernmental+", "+publicWelfareAssistanceAndSubsidies+", "+publicWelfareConstruction+", "+publicWelfareEquipmentAndLand+"]";
	}
	
	/**
	 * Internal constructor to create a PublicWelfare from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public PublicWelfare(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Public Welfare Direct Expenditure
            this.publicWelfareDirectExpenditure = ((Number)json_data.get("Public Welfare Direct Expenditure")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a PublicWelfare; the field publicWelfareDirectExpenditure was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a PublicWelfare; the field publicWelfareDirectExpenditure had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Public Welfare Other Current Operation
            this.publicWelfareOtherCurrentOperation = ((Number)json_data.get("Public Welfare Other Current Operation")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a PublicWelfare; the field publicWelfareOtherCurrentOperation was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a PublicWelfare; the field publicWelfareOtherCurrentOperation had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Public Welfare Total Expenditure
            this.publicWelfareTotalExpenditure = ((Number)json_data.get("Public Welfare Total Expenditure")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a PublicWelfare; the field publicWelfareTotalExpenditure was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a PublicWelfare; the field publicWelfareTotalExpenditure had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Public Welfare Intergovernmental
            this.publicWelfareIntergovernmental = ((Number)json_data.get("Public Welfare Intergovernmental")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a PublicWelfare; the field publicWelfareIntergovernmental was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a PublicWelfare; the field publicWelfareIntergovernmental had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Public Welfare Assistance and Subsidies
            this.publicWelfareAssistanceAndSubsidies = ((Number)json_data.get("Public Welfare Assistance and Subsidies")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a PublicWelfare; the field publicWelfareAssistanceAndSubsidies was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a PublicWelfare; the field publicWelfareAssistanceAndSubsidies had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Public Welfare Construction
            this.publicWelfareConstruction = ((Number)json_data.get("Public Welfare Construction")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a PublicWelfare; the field publicWelfareConstruction was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a PublicWelfare; the field publicWelfareConstruction had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Public Welfare Equipment and Land
            this.publicWelfareEquipmentAndLand = ((Number)json_data.get("Public Welfare Equipment and Land")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a PublicWelfare; the field publicWelfareEquipmentAndLand was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a PublicWelfare; the field publicWelfareEquipmentAndLand had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}