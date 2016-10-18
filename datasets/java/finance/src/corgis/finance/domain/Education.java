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
public class Education {
	
    private Integer educationNecIntergovernmental;
    private Integer educationEquipment;
    private Integer edcationAssistanceAndSubsidies;
    private Integer educationNecExpenditureTotal;
    private Integer educationTotal;
    private Integer elementarySecondaryTotalExpenditure;
    private Integer educationEquipmentAndLand;
    private Integer higherEducationNecTotalExpenditure;
    private Integer educationConstruction;
    private Integer elementarySecondaryIntergovernmental;
    private Integer higherEducationNecIntergovernmental;
    private Integer educationIntergovernmental;
    private Integer higherEducationAuxilliaryTotalExpenditure;
    private Integer educationOtherCurrentOperation;
    
    
    /*
     * @return 
     */
    public Integer getEducationNecIntergovernmental() {
        return this.educationNecIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getEducationEquipment() {
        return this.educationEquipment;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getEdcationAssistanceAndSubsidies() {
        return this.edcationAssistanceAndSubsidies;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getEducationNecExpenditureTotal() {
        return this.educationNecExpenditureTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getEducationTotal() {
        return this.educationTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getElementarySecondaryTotalExpenditure() {
        return this.elementarySecondaryTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getEducationEquipmentAndLand() {
        return this.educationEquipmentAndLand;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getHigherEducationNecTotalExpenditure() {
        return this.higherEducationNecTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getEducationConstruction() {
        return this.educationConstruction;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getElementarySecondaryIntergovernmental() {
        return this.elementarySecondaryIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getHigherEducationNecIntergovernmental() {
        return this.higherEducationNecIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getEducationIntergovernmental() {
        return this.educationIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getHigherEducationAuxilliaryTotalExpenditure() {
        return this.higherEducationAuxilliaryTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getEducationOtherCurrentOperation() {
        return this.educationOtherCurrentOperation;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Education.
	
	 * @return String
	 */
	public String toString() {
		return "Education[" +educationNecIntergovernmental+", "+educationEquipment+", "+edcationAssistanceAndSubsidies+", "+educationNecExpenditureTotal+", "+educationTotal+", "+elementarySecondaryTotalExpenditure+", "+educationEquipmentAndLand+", "+higherEducationNecTotalExpenditure+", "+educationConstruction+", "+elementarySecondaryIntergovernmental+", "+higherEducationNecIntergovernmental+", "+educationIntergovernmental+", "+higherEducationAuxilliaryTotalExpenditure+", "+educationOtherCurrentOperation+"]";
	}
	
	/**
	 * Internal constructor to create a Education from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Education(JSONObject json_data) {
        try {// Education-NEC Intergovernmental
            this.educationNecIntergovernmental = ((Number)json_data.get("Education-NEC Intergovernmental")).intValue();// Education Equipment
            this.educationEquipment = ((Number)json_data.get("Education Equipment")).intValue();// Edcation Assistance and Subsidies
            this.edcationAssistanceAndSubsidies = ((Number)json_data.get("Edcation Assistance and Subsidies")).intValue();// Education-NEC Expenditure Total
            this.educationNecExpenditureTotal = ((Number)json_data.get("Education-NEC Expenditure Total")).intValue();// Education Total
            this.educationTotal = ((Number)json_data.get("Education Total")).intValue();// Elementary Secondary Total Expenditure
            this.elementarySecondaryTotalExpenditure = ((Number)json_data.get("Elementary Secondary Total Expenditure")).intValue();// Education Equipment and Land
            this.educationEquipmentAndLand = ((Number)json_data.get("Education Equipment and Land")).intValue();// Higher Education-NEC Total Expenditure
            this.higherEducationNecTotalExpenditure = ((Number)json_data.get("Higher Education-NEC Total Expenditure")).intValue();// Education Construction
            this.educationConstruction = ((Number)json_data.get("Education Construction")).intValue();// Elementary Secondary Intergovernmental
            this.elementarySecondaryIntergovernmental = ((Number)json_data.get("Elementary Secondary Intergovernmental")).intValue();// Higher Education-NEC Intergovernmental
            this.higherEducationNecIntergovernmental = ((Number)json_data.get("Higher Education-NEC Intergovernmental")).intValue();// Education Intergovernmental
            this.educationIntergovernmental = ((Number)json_data.get("Education Intergovernmental")).intValue();// Higher Education-Auxilliary Total Expenditure
            this.higherEducationAuxilliaryTotalExpenditure = ((Number)json_data.get("Higher Education-Auxilliary Total Expenditure")).intValue();// Education Other Current Operation
            this.educationOtherCurrentOperation = ((Number)json_data.get("Education Other Current Operation")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Education; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Education; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}