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
public class Production {
	
    private Double crudeOil;
    private Double fossilFuels;
    private Double naturalGas;
    private Double nuclear;
    private Double totalRenewable;
    private Double biomass;
    private Double hydroelectric;
    private Double naturalGasPlantLiquids;
    private Double geothermal;
    private Double coal;
    private Double solar;
    private Double total;
    private Double wind;
    
    
    /*
     * @return 
     */
    public Double getCrudeOil() {
        return this.crudeOil;
    }
    
    
    
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
    public Double getNaturalGasPlantLiquids() {
        return this.naturalGasPlantLiquids;
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
    public Double getCoal() {
        return this.coal;
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
	 * Creates a string based representation of this Production.
	
	 * @return String
	 */
	public String toString() {
		return "Production[" +crudeOil+", "+fossilFuels+", "+naturalGas+", "+nuclear+", "+totalRenewable+", "+biomass+", "+hydroelectric+", "+naturalGasPlantLiquids+", "+geothermal+", "+coal+", "+solar+", "+total+", "+wind+"]";
	}
	
	/**
	 * Internal constructor to create a Production from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Production(JSONObject json_data) {
        try {// crude oil
            this.crudeOil = ((Number)json_data.get("crude oil")).doubleValue();// fossil fuels
            this.fossilFuels = ((Number)json_data.get("fossil fuels")).doubleValue();// natural gas
            this.naturalGas = ((Number)json_data.get("natural gas")).doubleValue();// nuclear
            this.nuclear = ((Number)json_data.get("nuclear")).doubleValue();// total renewable
            this.totalRenewable = ((Number)json_data.get("total renewable")).doubleValue();// biomass
            this.biomass = ((Number)json_data.get("biomass")).doubleValue();// hydroelectric
            this.hydroelectric = ((Number)json_data.get("hydroelectric")).doubleValue();// natural gas plant liquids
            this.naturalGasPlantLiquids = ((Number)json_data.get("natural gas plant liquids")).doubleValue();// geothermal
            this.geothermal = ((Number)json_data.get("geothermal")).doubleValue();// coal
            this.coal = ((Number)json_data.get("coal")).doubleValue();// solar
            this.solar = ((Number)json_data.get("solar")).doubleValue();// total
            this.total = ((Number)json_data.get("total")).doubleValue();// wind
            this.wind = ((Number)json_data.get("wind")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Production; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Production; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}