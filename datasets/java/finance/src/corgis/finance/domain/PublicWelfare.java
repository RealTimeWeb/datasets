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
	
    private Integer publicWelfareEquipmentAndLand;
    private Integer publicWelfareIntergovernmental;
    private Integer publicWelfareOtherCurrentOperation;
    private Integer publicWelfareDirectExpenditure;
    private Integer publicWelfareConstruction;
    private Integer publicWelfareTotalExpenditure;
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
            this.publicWelfareEquipmentAndLand = new Integer(((Long)json_data.get("Public Welfare Equipment and Land")).intValue());// Public Welfare Intergovernmental
            this.publicWelfareIntergovernmental = new Integer(((Long)json_data.get("Public Welfare Intergovernmental")).intValue());// Public Welfare Other Current Operation
            this.publicWelfareOtherCurrentOperation = new Integer(((Long)json_data.get("Public Welfare Other Current Operation")).intValue());// Public Welfare Direct Expenditure
            this.publicWelfareDirectExpenditure = new Integer(((Long)json_data.get("Public Welfare Direct Expenditure")).intValue());// Public Welfare Construction
            this.publicWelfareConstruction = new Integer(((Long)json_data.get("Public Welfare Construction")).intValue());// Public Welfare Total Expenditure
            this.publicWelfareTotalExpenditure = new Integer(((Long)json_data.get("Public Welfare Total Expenditure")).intValue());// Public Welfare Assistance and Subsidies
            this.publicWelfareAssistanceAndSubsidies = new Integer(((Long)json_data.get("Public Welfare Assistance and Subsidies")).intValue());
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a PublicWelfare; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a PublicWelfare; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}