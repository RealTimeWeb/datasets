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
public class Exports {
	
    private Double crudeOil;
    private Double petroleumProducts;
    private Double naturalGas;
    private Double electricity;
    private Double coalCoke;
    private Double coal;
    private Double total;
    private Double totalPetroleum;
    private Double biofuels;
    
    
    /*
     * @return 
     */
    public Double getCrudeOil() {
        return this.crudeOil;
    }
    
    
    
    /*
     * @return 
     */
    public Double getPetroleumProducts() {
        return this.petroleumProducts;
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
    public Double getElectricity() {
        return this.electricity;
    }
    
    
    
    /*
     * @return 
     */
    public Double getCoalCoke() {
        return this.coalCoke;
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
    public Double getTotal() {
        return this.total;
    }
    
    
    
    /*
     * @return 
     */
    public Double getTotalPetroleum() {
        return this.totalPetroleum;
    }
    
    
    
    /*
     * @return 
     */
    public Double getBiofuels() {
        return this.biofuels;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Exports.
	
	 * @return String
	 */
	public String toString() {
		return "Exports[" +crudeOil+", "+petroleumProducts+", "+naturalGas+", "+electricity+", "+coalCoke+", "+coal+", "+total+", "+totalPetroleum+", "+biofuels+"]";
	}
	
	/**
	 * Internal constructor to create a Exports from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Exports(JSONObject json_data) {
        try {// crude oil
            this.crudeOil = (Double)json_data.get("crude oil");// petroleum products
            this.petroleumProducts = (Double)json_data.get("petroleum products");// natural gas
            this.naturalGas = (Double)json_data.get("natural gas");// electricity
            this.electricity = (Double)json_data.get("electricity");// coal coke
            this.coalCoke = (Double)json_data.get("coal coke");// coal
            this.coal = (Double)json_data.get("coal");// total
            this.total = (Double)json_data.get("total");// total petroleum
            this.totalPetroleum = (Double)json_data.get("total petroleum");// biofuels
            this.biofuels = (Double)json_data.get("biofuels");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Exports; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Exports; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}