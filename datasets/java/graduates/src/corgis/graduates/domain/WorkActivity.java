package corgis.graduates.domain;

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
public class WorkActivity {
	
    // The number of people with a degree in this major during this year, who describe their primary work activity (more than 10% of their time) as involving Development.
    private Integer development;
    // The number of people with a degree in this major during this year, who describe their primary work activity (more than 10% of their time) as involving professional service.
    private Integer professionalService;
    // The number of people with a degree in this major during this year, who describe their primary work activity (more than 10% of their time) as involving Applied Research.
    private Integer appliedResearch;
    // The number of people with a degree in this major during this year, who describe their primary work activity (more than 10% of their time) as involving managing or supervising either people or projects.
    private Integer managingSupervisingPeopleProjects;
    // The number of people with a degree in this major during this year, who describe their primary work activity (more than 10% of their time) as involving Computer Applications.
    private Integer computerApplications;
    // The number of people with a degree in this major during this year, who describe their primary work activity (more than 10% of their time) as involving Human Resources.
    private Integer humanResources;
    // The number of people with a degree in this major during this year, who describe their primary work activity (more than 10% of their time) as involving productions, operations, or maintenance.
    private Integer productionsOperationsMaintenance;
    // The number of people with a degree in this major during this year, who describe their primary work activity (more than 10% of their time) as involving sales, purchasing, or marketing.
    private Integer salesPurchasingMarketing;
    // The number of people with a degree in this major during this year, who describe their primary work activity (more than 10% of their time) as involving qualitity or productivity management.
    private Integer qualitityProductivityManagement;
    // The number of people with a degree in this major during this year, who describe their primary work activity (more than 10% of their time) as involving Design.
    private Integer design;
    // The number of people with a degree in this major during this year, who describe their primary work activity (more than 10% of their time) as involving Accounting, Finance, or Contracts.
    private Integer accountingFinanceContracts;
    // The number of people with a degree in this major during this year, who describe their primary work activity (more than 10% of their time) as involving teaching.
    private Integer teaching;
    // The number of people with a degree in this major during this year, who describe their primary work activity (more than 10% of their time) as involving Basic Research.
    private Integer basicResearch;
    // The number of people with a degree in this major during this year, who describe their primary work activity (more than 10% of their time) as involving something not involved in any of the other categories.
    private Integer other;
    
    
    /*
     * @return 
     */
    public Integer getDevelopment() {
        return this.development;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getProfessionalService() {
        return this.professionalService;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getAppliedResearch() {
        return this.appliedResearch;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getManagingSupervisingPeopleProjects() {
        return this.managingSupervisingPeopleProjects;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getComputerApplications() {
        return this.computerApplications;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getHumanResources() {
        return this.humanResources;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getProductionsOperationsMaintenance() {
        return this.productionsOperationsMaintenance;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getSalesPurchasingMarketing() {
        return this.salesPurchasingMarketing;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getQualitityProductivityManagement() {
        return this.qualitityProductivityManagement;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getDesign() {
        return this.design;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getAccountingFinanceContracts() {
        return this.accountingFinanceContracts;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getTeaching() {
        return this.teaching;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getBasicResearch() {
        return this.basicResearch;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getOther() {
        return this.other;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this WorkActivity.
	
	 * @return String
	 */
	public String toString() {
		return "WorkActivity[" +development+", "+professionalService+", "+appliedResearch+", "+managingSupervisingPeopleProjects+", "+computerApplications+", "+humanResources+", "+productionsOperationsMaintenance+", "+salesPurchasingMarketing+", "+qualitityProductivityManagement+", "+design+", "+accountingFinanceContracts+", "+teaching+", "+basicResearch+", "+other+"]";
	}
	
	/**
	 * Internal constructor to create a WorkActivity from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public WorkActivity(JSONObject json_data) {
        try {// Development
            this.development = ((Number)json_data.get("Development")).intValue();// Professional Service
            this.professionalService = ((Number)json_data.get("Professional Service")).intValue();// Applied Research
            this.appliedResearch = ((Number)json_data.get("Applied Research")).intValue();// Managing/Supervising People/Projects
            this.managingSupervisingPeopleProjects = ((Number)json_data.get("Managing/Supervising People/Projects")).intValue();// Computer Applications
            this.computerApplications = ((Number)json_data.get("Computer Applications")).intValue();// Human Resources
            this.humanResources = ((Number)json_data.get("Human Resources")).intValue();// Productions/Operations/Maintenance
            this.productionsOperationsMaintenance = ((Number)json_data.get("Productions/Operations/Maintenance")).intValue();// Sales, Purchasing, Marketing
            this.salesPurchasingMarketing = ((Number)json_data.get("Sales, Purchasing, Marketing")).intValue();// Qualitity/Productivity Management
            this.qualitityProductivityManagement = ((Number)json_data.get("Qualitity/Productivity Management")).intValue();// Design
            this.design = ((Number)json_data.get("Design")).intValue();// Accounting/Finance/Contracts
            this.accountingFinanceContracts = ((Number)json_data.get("Accounting/Finance/Contracts")).intValue();// Teaching
            this.teaching = ((Number)json_data.get("Teaching")).intValue();// Basic Research
            this.basicResearch = ((Number)json_data.get("Basic Research")).intValue();// Other
            this.other = ((Number)json_data.get("Other")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a WorkActivity; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a WorkActivity; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}