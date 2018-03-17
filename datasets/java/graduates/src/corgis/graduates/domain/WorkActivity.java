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
	
    // The number of people with a degree in this major during this year, who describe their primary work activity (more than 10% of their time) as involving teaching.
    private Integer teaching;
    // The number of people with a degree in this major during this year, who describe their primary work activity (more than 10% of their time) as involving Development.
    private Integer development;
    // The number of people with a degree in this major during this year, who describe their primary work activity (more than 10% of their time) as involving managing or supervising either people or projects.
    private Integer managingSupervisingPeopleProjects;
    // The number of people with a degree in this major during this year, who describe their primary work activity (more than 10% of their time) as involving professional service.
    private Integer professionalService;
    // The number of people with a degree in this major during this year, who describe their primary work activity (more than 10% of their time) as involving productions, operations, or maintenance.
    private Integer productionsOperationsMaintenance;
    // The number of people with a degree in this major during this year, who describe their primary work activity (more than 10% of their time) as involving Applied Research.
    private Integer appliedResearch;
    // The number of people with a degree in this major during this year, who describe their primary work activity (more than 10% of their time) as involving sales, purchasing, or marketing.
    private Integer salesPurchasingMarketing;
    // The number of people with a degree in this major during this year, who describe their primary work activity (more than 10% of their time) as involving Computer Applications.
    private Integer computerApplications;
    // The number of people with a degree in this major during this year, who describe their primary work activity (more than 10% of their time) as involving Basic Research.
    private Integer basicResearch;
    // The number of people with a degree in this major during this year, who describe their primary work activity (more than 10% of their time) as involving qualitity or productivity management.
    private Integer qualitityProductivityManagement;
    // The number of people with a degree in this major during this year, who describe their primary work activity (more than 10% of their time) as involving something not involved in any of the other categories.
    private Integer other;
    // The number of people with a degree in this major during this year, who describe their primary work activity (more than 10% of their time) as involving Human Resources.
    private Integer humanResources;
    // The number of people with a degree in this major during this year, who describe their primary work activity (more than 10% of their time) as involving Accounting, Finance, or Contracts.
    private Integer accountingFinanceContracts;
    // The number of people with a degree in this major during this year, who describe their primary work activity (more than 10% of their time) as involving Design.
    private Integer design;
    
    
    /**
     * The number of people with a degree in this major during this year, who describe their primary work activity (more than 10% of their time) as involving teaching.
     * @return Integer
     */
    public Integer getTeaching() {
        return this.teaching;
    }
    
    
    
    /**
     * The number of people with a degree in this major during this year, who describe their primary work activity (more than 10% of their time) as involving Development.
     * @return Integer
     */
    public Integer getDevelopment() {
        return this.development;
    }
    
    
    
    /**
     * The number of people with a degree in this major during this year, who describe their primary work activity (more than 10% of their time) as involving managing or supervising either people or projects.
     * @return Integer
     */
    public Integer getManagingSupervisingPeopleProjects() {
        return this.managingSupervisingPeopleProjects;
    }
    
    
    
    /**
     * The number of people with a degree in this major during this year, who describe their primary work activity (more than 10% of their time) as involving professional service.
     * @return Integer
     */
    public Integer getProfessionalService() {
        return this.professionalService;
    }
    
    
    
    /**
     * The number of people with a degree in this major during this year, who describe their primary work activity (more than 10% of their time) as involving productions, operations, or maintenance.
     * @return Integer
     */
    public Integer getProductionsOperationsMaintenance() {
        return this.productionsOperationsMaintenance;
    }
    
    
    
    /**
     * The number of people with a degree in this major during this year, who describe their primary work activity (more than 10% of their time) as involving Applied Research.
     * @return Integer
     */
    public Integer getAppliedResearch() {
        return this.appliedResearch;
    }
    
    
    
    /**
     * The number of people with a degree in this major during this year, who describe their primary work activity (more than 10% of their time) as involving sales, purchasing, or marketing.
     * @return Integer
     */
    public Integer getSalesPurchasingMarketing() {
        return this.salesPurchasingMarketing;
    }
    
    
    
    /**
     * The number of people with a degree in this major during this year, who describe their primary work activity (more than 10% of their time) as involving Computer Applications.
     * @return Integer
     */
    public Integer getComputerApplications() {
        return this.computerApplications;
    }
    
    
    
    /**
     * The number of people with a degree in this major during this year, who describe their primary work activity (more than 10% of their time) as involving Basic Research.
     * @return Integer
     */
    public Integer getBasicResearch() {
        return this.basicResearch;
    }
    
    
    
    /**
     * The number of people with a degree in this major during this year, who describe their primary work activity (more than 10% of their time) as involving qualitity or productivity management.
     * @return Integer
     */
    public Integer getQualitityProductivityManagement() {
        return this.qualitityProductivityManagement;
    }
    
    
    
    /**
     * The number of people with a degree in this major during this year, who describe their primary work activity (more than 10% of their time) as involving something not involved in any of the other categories.
     * @return Integer
     */
    public Integer getOther() {
        return this.other;
    }
    
    
    
    /**
     * The number of people with a degree in this major during this year, who describe their primary work activity (more than 10% of their time) as involving Human Resources.
     * @return Integer
     */
    public Integer getHumanResources() {
        return this.humanResources;
    }
    
    
    
    /**
     * The number of people with a degree in this major during this year, who describe their primary work activity (more than 10% of their time) as involving Accounting, Finance, or Contracts.
     * @return Integer
     */
    public Integer getAccountingFinanceContracts() {
        return this.accountingFinanceContracts;
    }
    
    
    
    /**
     * The number of people with a degree in this major during this year, who describe their primary work activity (more than 10% of their time) as involving Design.
     * @return Integer
     */
    public Integer getDesign() {
        return this.design;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this WorkActivity.
	
	 * @return String
	 */
	public String toString() {
		return "WorkActivity[" +teaching+", "+development+", "+managingSupervisingPeopleProjects+", "+professionalService+", "+productionsOperationsMaintenance+", "+appliedResearch+", "+salesPurchasingMarketing+", "+computerApplications+", "+basicResearch+", "+qualitityProductivityManagement+", "+other+", "+humanResources+", "+accountingFinanceContracts+", "+design+"]";
	}
	
	/**
	 * Internal constructor to create a WorkActivity from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public WorkActivity(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Teaching
            this.teaching = ((Number)json_data.get("Teaching")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a WorkActivity; the field teaching was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a WorkActivity; the field teaching had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Development
            this.development = ((Number)json_data.get("Development")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a WorkActivity; the field development was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a WorkActivity; the field development had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Managing/Supervising People/Projects
            this.managingSupervisingPeopleProjects = ((Number)json_data.get("Managing/Supervising People/Projects")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a WorkActivity; the field managingSupervisingPeopleProjects was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a WorkActivity; the field managingSupervisingPeopleProjects had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Professional Service
            this.professionalService = ((Number)json_data.get("Professional Service")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a WorkActivity; the field professionalService was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a WorkActivity; the field professionalService had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Productions/Operations/Maintenance
            this.productionsOperationsMaintenance = ((Number)json_data.get("Productions/Operations/Maintenance")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a WorkActivity; the field productionsOperationsMaintenance was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a WorkActivity; the field productionsOperationsMaintenance had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Applied Research
            this.appliedResearch = ((Number)json_data.get("Applied Research")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a WorkActivity; the field appliedResearch was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a WorkActivity; the field appliedResearch had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Sales, Purchasing, Marketing
            this.salesPurchasingMarketing = ((Number)json_data.get("Sales, Purchasing, Marketing")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a WorkActivity; the field salesPurchasingMarketing was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a WorkActivity; the field salesPurchasingMarketing had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Computer Applications
            this.computerApplications = ((Number)json_data.get("Computer Applications")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a WorkActivity; the field computerApplications was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a WorkActivity; the field computerApplications had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Basic Research
            this.basicResearch = ((Number)json_data.get("Basic Research")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a WorkActivity; the field basicResearch was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a WorkActivity; the field basicResearch had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Qualitity/Productivity Management
            this.qualitityProductivityManagement = ((Number)json_data.get("Qualitity/Productivity Management")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a WorkActivity; the field qualitityProductivityManagement was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a WorkActivity; the field qualitityProductivityManagement had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Other
            this.other = ((Number)json_data.get("Other")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a WorkActivity; the field other was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a WorkActivity; the field other had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Human Resources
            this.humanResources = ((Number)json_data.get("Human Resources")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a WorkActivity; the field humanResources was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a WorkActivity; the field humanResources had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Accounting/Finance/Contracts
            this.accountingFinanceContracts = ((Number)json_data.get("Accounting/Finance/Contracts")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a WorkActivity; the field accountingFinanceContracts was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a WorkActivity; the field accountingFinanceContracts had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Design
            this.design = ((Number)json_data.get("Design")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a WorkActivity; the field design was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a WorkActivity; the field design had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}