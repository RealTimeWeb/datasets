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
	
    // Comprises payments made to beneficiaries under basic provisions of unemployment compensation programs and special program payments, such as for extended benefits triggered by economic conditions.
    private Integer unemploymentCompTotalExpenditure;
    // Total cash and securities related to unemployment compensation.
    private Integer unemploymentCompTotalCashAndSecurities;
    // Total amount spent on administration of unemployment compensation, public employment offices, and related services, and veterans' readjustment allowances.
    private Integer employmentSecurityAdministrationExpenditureTotal;
    // Total cash and securities related to employee retirement.
    private Integer employeeRetirementTotalCashAndSecurities;
    // Money paid to other governments for the administration of unemployment compensation, public employment offices, and related services, and veterans' readjustment allowances.
    private Integer employmentSecurityAdministrationIntergovernmental;
    // Total amount spent on cash payments to beneficiaries (including withdrawals of contributions) of government-administered employee-retirement systems, local government contributions to state-administered employee-retirement systems, and noncontributory gratuities paid to former employees; these are classed under General expenditure.
    private Integer employeeRetirementTotalExpenditure;
    
    
    /**
     * Comprises payments made to beneficiaries under basic provisions of unemployment compensation programs and special program payments, such as for extended benefits triggered by economic conditions.
     * @return Integer
     */
    public Integer getUnemploymentCompTotalExpenditure() {
        return this.unemploymentCompTotalExpenditure;
    }
    
    
    
    /**
     * Total cash and securities related to unemployment compensation.
     * @return Integer
     */
    public Integer getUnemploymentCompTotalCashAndSecurities() {
        return this.unemploymentCompTotalCashAndSecurities;
    }
    
    
    
    /**
     * Total amount spent on administration of unemployment compensation, public employment offices, and related services, and veterans' readjustment allowances.
     * @return Integer
     */
    public Integer getEmploymentSecurityAdministrationExpenditureTotal() {
        return this.employmentSecurityAdministrationExpenditureTotal;
    }
    
    
    
    /**
     * Total cash and securities related to employee retirement.
     * @return Integer
     */
    public Integer getEmployeeRetirementTotalCashAndSecurities() {
        return this.employeeRetirementTotalCashAndSecurities;
    }
    
    
    
    /**
     * Money paid to other governments for the administration of unemployment compensation, public employment offices, and related services, and veterans' readjustment allowances.
     * @return Integer
     */
    public Integer getEmploymentSecurityAdministrationIntergovernmental() {
        return this.employmentSecurityAdministrationIntergovernmental;
    }
    
    
    
    /**
     * Total amount spent on cash payments to beneficiaries (including withdrawals of contributions) of government-administered employee-retirement systems, local government contributions to state-administered employee-retirement systems, and noncontributory gratuities paid to former employees; these are classed under General expenditure.
     * @return Integer
     */
    public Integer getEmployeeRetirementTotalExpenditure() {
        return this.employeeRetirementTotalExpenditure;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Employment.
	
	 * @return String
	 */
	public String toString() {
		return "Employment[" +unemploymentCompTotalExpenditure+", "+unemploymentCompTotalCashAndSecurities+", "+employmentSecurityAdministrationExpenditureTotal+", "+employeeRetirementTotalCashAndSecurities+", "+employmentSecurityAdministrationIntergovernmental+", "+employeeRetirementTotalExpenditure+"]";
	}
	
	/**
	 * Internal constructor to create a Employment from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Employment(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Unemployment Comp Total Expenditure
            this.unemploymentCompTotalExpenditure = ((Number)json_data.get("Unemployment Comp Total Expenditure")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Employment; the field unemploymentCompTotalExpenditure was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Employment; the field unemploymentCompTotalExpenditure had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Unemployment Comp Total Cash and Securities
            this.unemploymentCompTotalCashAndSecurities = ((Number)json_data.get("Unemployment Comp Total Cash and Securities")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Employment; the field unemploymentCompTotalCashAndSecurities was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Employment; the field unemploymentCompTotalCashAndSecurities had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Employment Security Administration Expenditure Total
            this.employmentSecurityAdministrationExpenditureTotal = ((Number)json_data.get("Employment Security Administration Expenditure Total")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Employment; the field employmentSecurityAdministrationExpenditureTotal was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Employment; the field employmentSecurityAdministrationExpenditureTotal had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Employee Retirement Total Cash and Securities
            this.employeeRetirementTotalCashAndSecurities = ((Number)json_data.get("Employee Retirement Total Cash and Securities")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Employment; the field employeeRetirementTotalCashAndSecurities was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Employment; the field employeeRetirementTotalCashAndSecurities had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Employment Security Administration Intergovernmental
            this.employmentSecurityAdministrationIntergovernmental = ((Number)json_data.get("Employment Security Administration Intergovernmental")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Employment; the field employmentSecurityAdministrationIntergovernmental was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Employment; the field employmentSecurityAdministrationIntergovernmental had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Employee Retirement Total Expenditure
            this.employeeRetirementTotalExpenditure = ((Number)json_data.get("Employee Retirement Total Expenditure")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Employment; the field employeeRetirementTotalExpenditure was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Employment; the field employeeRetirementTotalExpenditure had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}