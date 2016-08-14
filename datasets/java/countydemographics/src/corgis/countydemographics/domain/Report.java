package corgis.countydemographics.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.countydemographics.domain.Ethnicities;
import corgis.countydemographics.domain.Age;
import corgis.countydemographics.domain.Miscellaneous;
import corgis.countydemographics.domain.Sales;
import corgis.countydemographics.domain.Income;
import corgis.countydemographics.domain.Education;
import corgis.countydemographics.domain.Employment;
import corgis.countydemographics.domain.Housing;
import corgis.countydemographics.domain.Population;

/**
 * 
 */
public class Report {
	
    // percent, 2014
    private Ethnicities ethnicities;
    // percent, 2014
    private Age age;
    private Miscellaneous miscellaneous;
    // 2007
    private Sales sales;
    private String county;
    private String state;
    // 2009-2013
    private Income income;
    // percent, 2009-2013
    private Education education;
    private Employment employment;
    private Housing housing;
    private Population population;
    
    
    /*
     * @return 
     */
    public Ethnicities getEthnicities() {
        return this.ethnicities;
    }
    
    
    
    /*
     * @return 
     */
    public Age getAge() {
        return this.age;
    }
    
    
    
    /*
     * @return 
     */
    public Miscellaneous getMiscellaneous() {
        return this.miscellaneous;
    }
    
    
    
    /*
     * @return 
     */
    public Sales getSales() {
        return this.sales;
    }
    
    
    
    /*
     * @return 
     */
    public String getCounty() {
        return this.county;
    }
    
    
    
    /*
     * @return 
     */
    public String getState() {
        return this.state;
    }
    
    
    
    /*
     * @return 
     */
    public Income getIncome() {
        return this.income;
    }
    
    
    
    /*
     * @return 
     */
    public Education getEducation() {
        return this.education;
    }
    
    
    
    /*
     * @return 
     */
    public Employment getEmployment() {
        return this.employment;
    }
    
    
    
    /*
     * @return 
     */
    public Housing getHousing() {
        return this.housing;
    }
    
    
    
    /*
     * @return 
     */
    public Population getPopulation() {
        return this.population;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Report.
	
	 * @return String
	 */
	public String toString() {
		return "Report[" +ethnicities+", "+age+", "+miscellaneous+", "+sales+", "+county+", "+state+", "+income+", "+education+", "+employment+", "+housing+", "+population+"]";
	}
	
	/**
	 * Internal constructor to create a Report from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Report(JSONObject json_data) {
        try {// Ethnicities
            this.ethnicities = new Ethnicities((JSONObject)json_data.get("Ethnicities"));// Age
            this.age = new Age((JSONObject)json_data.get("Age"));// Miscellaneous
            this.miscellaneous = new Miscellaneous((JSONObject)json_data.get("Miscellaneous"));// Sales
            this.sales = new Sales((JSONObject)json_data.get("Sales"));// County
            this.county = (String)json_data.get("County");// State
            this.state = (String)json_data.get("State");// Income
            this.income = new Income((JSONObject)json_data.get("Income"));// Education
            this.education = new Education((JSONObject)json_data.get("Education"));// Employment
            this.employment = new Employment((JSONObject)json_data.get("Employment"));// Housing
            this.housing = new Housing((JSONObject)json_data.get("Housing"));// Population
            this.population = new Population((JSONObject)json_data.get("Population"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Report; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Report; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}