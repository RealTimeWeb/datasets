package corgis.state_demographics.domain;

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
public class Sales {
	
    // $100,000 of dollars
    private Integer merchantWholesalerSales;
    // $100,000 of dollars
    private Integer retailSales;
    private Integer retailSalesPerCapita;
    // $100,000 of dollars
    private Integer accommodationAndFoodServicesSales;
    
    
    /**
     * $100,000 of dollars
     * @return Integer
     */
    public Integer getMerchantWholesalerSales() {
        return this.merchantWholesalerSales;
    }
    
    
    
    /**
     * $100,000 of dollars
     * @return Integer
     */
    public Integer getRetailSales() {
        return this.retailSales;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getRetailSalesPerCapita() {
        return this.retailSalesPerCapita;
    }
    
    
    
    /**
     * $100,000 of dollars
     * @return Integer
     */
    public Integer getAccommodationAndFoodServicesSales() {
        return this.accommodationAndFoodServicesSales;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Sales.
	
	 * @return String
	 */
	public String toString() {
		return "Sales[" +merchantWholesalerSales+", "+retailSales+", "+retailSalesPerCapita+", "+accommodationAndFoodServicesSales+"]";
	}
	
	/**
	 * Internal constructor to create a Sales from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Sales(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Merchant Wholesaler Sales
            this.merchantWholesalerSales = ((Number)json_data.get("Merchant Wholesaler Sales")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Sales; the field merchantWholesalerSales was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Sales; the field merchantWholesalerSales had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Retail Sales
            this.retailSales = ((Number)json_data.get("Retail Sales")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Sales; the field retailSales was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Sales; the field retailSales had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Retail Sales per Capita
            this.retailSalesPerCapita = ((Number)json_data.get("Retail Sales per Capita")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Sales; the field retailSalesPerCapita was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Sales; the field retailSalesPerCapita had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Accommodation and Food Services Sales
            this.accommodationAndFoodServicesSales = ((Number)json_data.get("Accommodation and Food Services Sales")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Sales; the field accommodationAndFoodServicesSales was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Sales; the field accommodationAndFoodServicesSales had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}