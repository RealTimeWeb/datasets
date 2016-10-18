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
public class Employment {
	
    private Integer unemploymentCompTotalCashAndSecurities;
    private Integer employmentSecurityAdministrationExpenditureTotal;
    private Integer employeeRetirementTotalCashAndSecurities;
    private Integer employmentSecurityAdministrationIntergovernmental;
    private Integer employeeRetirementTotalExpenditure;
    private Integer unemploymentCompTotalExpenditure;
    
    
    /*
     * @return 
     */
    public Integer getUnemploymentCompTotalCashAndSecurities() {
        return this.unemploymentCompTotalCashAndSecurities;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getEmploymentSecurityAdministrationExpenditureTotal() {
        return this.employmentSecurityAdministrationExpenditureTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getEmployeeRetirementTotalCashAndSecurities() {
        return this.employeeRetirementTotalCashAndSecurities;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getEmploymentSecurityAdministrationIntergovernmental() {
        return this.employmentSecurityAdministrationIntergovernmental;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getEmployeeRetirementTotalExpenditure() {
        return this.employeeRetirementTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getUnemploymentCompTotalExpenditure() {
        return this.unemploymentCompTotalExpenditure;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Employment.
	
	 * @return String
	 */
	public String toString() {
		return "Employment[" +unemploymentCompTotalCashAndSecurities+", "+employmentSecurityAdministrationExpenditureTotal+", "+employeeRetirementTotalCashAndSecurities+", "+employmentSecurityAdministrationIntergovernmental+", "+employeeRetirementTotalExpenditure+", "+unemploymentCompTotalExpenditure+"]";
	}
	
	/**
	 * Internal constructor to create a Employment from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Employment(JSONObject json_data) {
        try {// Unemployment Comp Total Cash and Securities
            this.unemploymentCompTotalCashAndSecurities = ((Number)json_data.get("Unemployment Comp Total Cash and Securities")).intValue();// Employment Security Administration Expenditure Total
            this.employmentSecurityAdministrationExpenditureTotal = ((Number)json_data.get("Employment Security Administration Expenditure Total")).intValue();// Employee Retirement Total Cash and Securities
            this.employeeRetirementTotalCashAndSecurities = ((Number)json_data.get("Employee Retirement Total Cash and Securities")).intValue();// Employment Security Administration Intergovernmental
            this.employmentSecurityAdministrationIntergovernmental = ((Number)json_data.get("Employment Security Administration Intergovernmental")).intValue();// Employee Retirement Total Expenditure
            this.employeeRetirementTotalExpenditure = ((Number)json_data.get("Employee Retirement Total Expenditure")).intValue();// Unemployment Comp Total Expenditure
            this.unemploymentCompTotalExpenditure = ((Number)json_data.get("Unemployment Comp Total Expenditure")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Employment; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Employment; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}