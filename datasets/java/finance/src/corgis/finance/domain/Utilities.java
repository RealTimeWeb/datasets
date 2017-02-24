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
public class Utilities {
	
    // Total amount spent on operation and maintenance of water supply system including acquisition and distribution of water to the general public or to other local governments for domestic or industrial use. Acquisition and distribution of water for irrigation of agricultural lands are classified under Natural resources.
    private Integer waterUtilityTotalExpenditure;
    // Total amount spent on the operation and maintenance of gas supply systems including acquisition and distribution of natural gas.
    private Integer gasUtilityTotalExpenditure;
    // Amount spent on current operation of government owned and operated water supply, electric light and power, gas supply, or transit system. Government revenue, expenditure, and debt relating to utility facilities leased to other governments or persons, and other commercial type activities of governments, such as port facilities, airports, housing projects, radio stations, steam plants, ferries, abattoirs, etc., are classified as general government activities.
    private Integer utilitiesCurrentOperation;
    // Total amount spent on government owned and operated water supply, electric light and power, gas supply, or transit system. Government revenue, expenditure, and debt relating to utility facilities leased to other governments or persons, and other commercial type activities of governments, such as port facilities, airports, housing projects, radio stations, steam plants, ferries, abattoirs, etc., are classified as general government activities.
    private Integer utilitiesTotalExpenditure;
    // Total amount spent on equipment and land in support of utilities.
    private Integer utilitiesEquipmentAndLand;
    // Total amount spent on construction for utilities.
    private Integer utilitiesConstruction;
    // Interest earned on various utilities.
    private Integer utilitiesInterestTotal;
    // Total amount spent on the construction, maintenance, and operation of public mass transit systems--bus, commuter rail, light rail, or subway systems. Excludes systems established solely to transport elementary and secondary school pupils. Ferry systems are classified under Highways.
    private Integer transitUtilityTotalExpenditure;
    // Total amount spent on operation and maintenance of electric power system including production or acquisition and distribution of electric power.
    private Integer electricUtilityTotalExpenditure;
    
    
    /*
     * @return 
     */
    public Integer getWaterUtilityTotalExpenditure() {
        return this.waterUtilityTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getGasUtilityTotalExpenditure() {
        return this.gasUtilityTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getUtilitiesCurrentOperation() {
        return this.utilitiesCurrentOperation;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getUtilitiesTotalExpenditure() {
        return this.utilitiesTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getUtilitiesEquipmentAndLand() {
        return this.utilitiesEquipmentAndLand;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getUtilitiesConstruction() {
        return this.utilitiesConstruction;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getUtilitiesInterestTotal() {
        return this.utilitiesInterestTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getTransitUtilityTotalExpenditure() {
        return this.transitUtilityTotalExpenditure;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getElectricUtilityTotalExpenditure() {
        return this.electricUtilityTotalExpenditure;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Utilities.
	
	 * @return String
	 */
	public String toString() {
		return "Utilities[" +waterUtilityTotalExpenditure+", "+gasUtilityTotalExpenditure+", "+utilitiesCurrentOperation+", "+utilitiesTotalExpenditure+", "+utilitiesEquipmentAndLand+", "+utilitiesConstruction+", "+utilitiesInterestTotal+", "+transitUtilityTotalExpenditure+", "+electricUtilityTotalExpenditure+"]";
	}
	
	/**
	 * Internal constructor to create a Utilities from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Utilities(JSONObject json_data) {
        try {// Water Utility Total Expenditure
            this.waterUtilityTotalExpenditure = ((Number)json_data.get("Water Utility Total Expenditure")).intValue();// Gas Utility Total Expenditure
            this.gasUtilityTotalExpenditure = ((Number)json_data.get("Gas Utility Total Expenditure")).intValue();// Utilities Current Operation
            this.utilitiesCurrentOperation = ((Number)json_data.get("Utilities Current Operation")).intValue();// Utilities Total Expenditure
            this.utilitiesTotalExpenditure = ((Number)json_data.get("Utilities Total Expenditure")).intValue();// Utilities Equipment and Land
            this.utilitiesEquipmentAndLand = ((Number)json_data.get("Utilities Equipment and Land")).intValue();// Utilities Construction
            this.utilitiesConstruction = ((Number)json_data.get("Utilities Construction")).intValue();// Utilities Interest Total
            this.utilitiesInterestTotal = ((Number)json_data.get("Utilities Interest Total")).intValue();// Transit Utility Total Expenditure
            this.transitUtilityTotalExpenditure = ((Number)json_data.get("Transit Utility Total Expenditure")).intValue();// Electric Utility Total Expenditure
            this.electricUtilityTotalExpenditure = ((Number)json_data.get("Electric Utility Total Expenditure")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Utilities; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Utilities; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}