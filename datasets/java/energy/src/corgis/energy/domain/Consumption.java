package corgis.energy.domain;

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
public class Consumption {
	
    private Double fossilFuels;
    private Double naturalGas;
    private Double nuclear;
    private Double totalRenewable;
    private Double petroleum;
    private Double biomass;
    private Double hydroelectric;
    private Double coal;
    private Double geothermal;
    private Double solar;
    private Double total;
    private Double wind;
    
    
    /*
     * @return 
     */
    public Double getFossilFuels() {
        return this.fossilFuels;
    }
    
    
    
    /*
     * @return 
     */
    public Double getNaturalGas() {
        return this.naturalGas;
    }
    
    
    
    /*
     * @return 
     */
    public Double getNuclear() {
        return this.nuclear;
    }
    
    
    
    /*
     * @return 
     */
    public Double getTotalRenewable() {
        return this.totalRenewable;
    }
    
    
    
    /*
     * @return 
     */
    public Double getPetroleum() {
        return this.petroleum;
    }
    
    
    
    /*
     * @return 
     */
    public Double getBiomass() {
        return this.biomass;
    }
    
    
    
    /*
     * @return 
     */
    public Double getHydroelectric() {
        return this.hydroelectric;
    }
    
    
    
    /*
     * @return 
     */
    public Double getCoal() {
        return this.coal;
    }
    
    
    
    /*
     * @return 
     */
    public Double getGeothermal() {
        return this.geothermal;
    }
    
    
    
    /*
     * @return 
     */
    public Double getSolar() {
        return this.solar;
    }
    
    
    
    /*
     * @return 
     */
    public Double getTotal() {
        return this.total;
    }
    
    
    
    /*
     * @return 
     */
    public Double getWind() {
        return this.wind;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Consumption.
	
	 * @return String
	 */
	public String toString() {
		return "Consumption[" +fossilFuels+", "+naturalGas+", "+nuclear+", "+totalRenewable+", "+petroleum+", "+biomass+", "+hydroelectric+", "+coal+", "+geothermal+", "+solar+", "+total+", "+wind+"]";
	}
	
	/**
	 * Internal constructor to create a Consumption from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Consumption(JSONObject json_data) {
        try {// fossil fuels
            this.fossilFuels = (Double)json_data.get("fossil fuels");// natural gas
            this.naturalGas = (Double)json_data.get("natural gas");// nuclear
            this.nuclear = (Double)json_data.get("nuclear");// total renewable
            this.totalRenewable = (Double)json_data.get("total renewable");// petroleum
            this.petroleum = (Double)json_data.get("petroleum");// biomass
            this.biomass = (Double)json_data.get("biomass");// hydroelectric
            this.hydroelectric = (Double)json_data.get("hydroelectric");// coal
            this.coal = (Double)json_data.get("coal");// geothermal
            this.geothermal = (Double)json_data.get("geothermal");// solar
            this.solar = (Double)json_data.get("solar");// total
            this.total = (Double)json_data.get("total");// wind
            this.wind = (Double)json_data.get("wind");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Consumption; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Consumption; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}