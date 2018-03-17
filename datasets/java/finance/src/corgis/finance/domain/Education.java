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
	
    // Total amount spent on elementary schools.
    private Integer elementarySecondaryTotalExpenditure;
    // Total amount spent on equipment and land for educational purposes.
    private Integer educationEquipmentAndLand;
    // Total amount spent on assistance and subsidies for education.
    private Integer edcationAssistanceAndSubsidies;
    // Total amount spent on equipment for educational purposes.
    private Integer educationEquipment;
    // Total amount spent on schools, colleges, and other educational institutions (e.g., for blind, deaf, and other handicapped individuals), and educational programs for adults, veterans, and other special classes. State institutions of higher education includes activities of institutions operated by the state, except that agricultural extension services and experiment stations are classified under Natural resources and hospitals serving the public are classified under Hospitals. Revenue and expenditure for dormitories, cafeterias, athletic events, bookstores, and other auxiliary enterprises financed mainly through charges for services are reported on a gross basis.
    private Integer educationTotal;
    // Direct expenditure for compensation of own officers and employees and for supplies, materials, and contractual services except amounts for capital outlay related to education.
    private Integer educationOtherCurrentOperation;
    // Total amount spent on education that is not elsewhere classified.
    private Integer educationNecExpenditureTotal;
    // Money paid to other governments for educational purposes.
    private Integer educationIntergovernmental;
    // Money paid to other governments for higher education that is not elsewhere classified.
    private Integer higherEducationNecIntergovernmental;
    // Total amount spent on construction for educational purposes.
    private Integer educationConstruction;
    // Total amount spent on auxliary higher education enterprises.
    private Integer higherEducationAuxilliaryTotalExpenditure;
    // Total amount spent on higher education that is not elsewhere classified.
    private Integer higherEducationNecTotalExpenditure;
    // Money paid to other governments for elementary schools.
    private Integer elementarySecondaryIntergovernmental;
    // Money paid to other governments for education that is not elsewhere classified.
    private Integer educationNecIntergovernmental;
    
    
    /**
     * Total amount spent on elementary schools.
     * @return Integer
     */
    public Integer getElementarySecondaryTotalExpenditure() {
        return this.elementarySecondaryTotalExpenditure;
    }
    
    
    
    /**
     * Total amount spent on equipment and land for educational purposes.
     * @return Integer
     */
    public Integer getEducationEquipmentAndLand() {
        return this.educationEquipmentAndLand;
    }
    
    
    
    /**
     * Total amount spent on assistance and subsidies for education.
     * @return Integer
     */
    public Integer getEdcationAssistanceAndSubsidies() {
        return this.edcationAssistanceAndSubsidies;
    }
    
    
    
    /**
     * Total amount spent on equipment for educational purposes.
     * @return Integer
     */
    public Integer getEducationEquipment() {
        return this.educationEquipment;
    }
    
    
    
    /**
     * Total amount spent on schools, colleges, and other educational institutions (e.g., for blind, deaf, and other handicapped individuals), and educational programs for adults, veterans, and other special classes. State institutions of higher education includes activities of institutions operated by the state, except that agricultural extension services and experiment stations are classified under Natural resources and hospitals serving the public are classified under Hospitals. Revenue and expenditure for dormitories, cafeterias, athletic events, bookstores, and other auxiliary enterprises financed mainly through charges for services are reported on a gross basis.
     * @return Integer
     */
    public Integer getEducationTotal() {
        return this.educationTotal;
    }
    
    
    
    /**
     * Direct expenditure for compensation of own officers and employees and for supplies, materials, and contractual services except amounts for capital outlay related to education.
     * @return Integer
     */
    public Integer getEducationOtherCurrentOperation() {
        return this.educationOtherCurrentOperation;
    }
    
    
    
    /**
     * Total amount spent on education that is not elsewhere classified.
     * @return Integer
     */
    public Integer getEducationNecExpenditureTotal() {
        return this.educationNecExpenditureTotal;
    }
    
    
    
    /**
     * Money paid to other governments for educational purposes.
     * @return Integer
     */
    public Integer getEducationIntergovernmental() {
        return this.educationIntergovernmental;
    }
    
    
    
    /**
     * Money paid to other governments for higher education that is not elsewhere classified.
     * @return Integer
     */
    public Integer getHigherEducationNecIntergovernmental() {
        return this.higherEducationNecIntergovernmental;
    }
    
    
    
    /**
     * Total amount spent on construction for educational purposes.
     * @return Integer
     */
    public Integer getEducationConstruction() {
        return this.educationConstruction;
    }
    
    
    
    /**
     * Total amount spent on auxliary higher education enterprises.
     * @return Integer
     */
    public Integer getHigherEducationAuxilliaryTotalExpenditure() {
        return this.higherEducationAuxilliaryTotalExpenditure;
    }
    
    
    
    /**
     * Total amount spent on higher education that is not elsewhere classified.
     * @return Integer
     */
    public Integer getHigherEducationNecTotalExpenditure() {
        return this.higherEducationNecTotalExpenditure;
    }
    
    
    
    /**
     * Money paid to other governments for elementary schools.
     * @return Integer
     */
    public Integer getElementarySecondaryIntergovernmental() {
        return this.elementarySecondaryIntergovernmental;
    }
    
    
    
    /**
     * Money paid to other governments for education that is not elsewhere classified.
     * @return Integer
     */
    public Integer getEducationNecIntergovernmental() {
        return this.educationNecIntergovernmental;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Education.
	
	 * @return String
	 */
	public String toString() {
		return "Education[" +elementarySecondaryTotalExpenditure+", "+educationEquipmentAndLand+", "+edcationAssistanceAndSubsidies+", "+educationEquipment+", "+educationTotal+", "+educationOtherCurrentOperation+", "+educationNecExpenditureTotal+", "+educationIntergovernmental+", "+higherEducationNecIntergovernmental+", "+educationConstruction+", "+higherEducationAuxilliaryTotalExpenditure+", "+higherEducationNecTotalExpenditure+", "+elementarySecondaryIntergovernmental+", "+educationNecIntergovernmental+"]";
	}
	
	/**
	 * Internal constructor to create a Education from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Education(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Elementary Secondary Total Expenditure
            this.elementarySecondaryTotalExpenditure = ((Number)json_data.get("Elementary Secondary Total Expenditure")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Education; the field elementarySecondaryTotalExpenditure was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Education; the field elementarySecondaryTotalExpenditure had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Education Equipment and Land
            this.educationEquipmentAndLand = ((Number)json_data.get("Education Equipment and Land")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Education; the field educationEquipmentAndLand was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Education; the field educationEquipmentAndLand had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Edcation Assistance and Subsidies
            this.edcationAssistanceAndSubsidies = ((Number)json_data.get("Edcation Assistance and Subsidies")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Education; the field edcationAssistanceAndSubsidies was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Education; the field edcationAssistanceAndSubsidies had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Education Equipment
            this.educationEquipment = ((Number)json_data.get("Education Equipment")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Education; the field educationEquipment was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Education; the field educationEquipment had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Education Total
            this.educationTotal = ((Number)json_data.get("Education Total")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Education; the field educationTotal was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Education; the field educationTotal had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Education Other Current Operation
            this.educationOtherCurrentOperation = ((Number)json_data.get("Education Other Current Operation")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Education; the field educationOtherCurrentOperation was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Education; the field educationOtherCurrentOperation had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Education-NEC Expenditure Total
            this.educationNecExpenditureTotal = ((Number)json_data.get("Education-NEC Expenditure Total")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Education; the field educationNecExpenditureTotal was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Education; the field educationNecExpenditureTotal had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Education Intergovernmental
            this.educationIntergovernmental = ((Number)json_data.get("Education Intergovernmental")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Education; the field educationIntergovernmental was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Education; the field educationIntergovernmental had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Higher Education-NEC Intergovernmental
            this.higherEducationNecIntergovernmental = ((Number)json_data.get("Higher Education-NEC Intergovernmental")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Education; the field higherEducationNecIntergovernmental was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Education; the field higherEducationNecIntergovernmental had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Education Construction
            this.educationConstruction = ((Number)json_data.get("Education Construction")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Education; the field educationConstruction was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Education; the field educationConstruction had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Higher Education-Auxilliary Total Expenditure
            this.higherEducationAuxilliaryTotalExpenditure = ((Number)json_data.get("Higher Education-Auxilliary Total Expenditure")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Education; the field higherEducationAuxilliaryTotalExpenditure was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Education; the field higherEducationAuxilliaryTotalExpenditure had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Higher Education-NEC Total Expenditure
            this.higherEducationNecTotalExpenditure = ((Number)json_data.get("Higher Education-NEC Total Expenditure")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Education; the field higherEducationNecTotalExpenditure was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Education; the field higherEducationNecTotalExpenditure had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Elementary Secondary Intergovernmental
            this.elementarySecondaryIntergovernmental = ((Number)json_data.get("Elementary Secondary Intergovernmental")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Education; the field elementarySecondaryIntergovernmental was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Education; the field elementarySecondaryIntergovernmental had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Education-NEC Intergovernmental
            this.educationNecIntergovernmental = ((Number)json_data.get("Education-NEC Intergovernmental")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Education; the field educationNecIntergovernmental was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Education; the field educationNecIntergovernmental had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}