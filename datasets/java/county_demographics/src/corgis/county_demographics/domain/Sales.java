package corgis.county_demographics.domain;

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
    private Integer retailSales;
    // $100,000 of dollars
    private Integer merchantWholesalerSales;
    // $100,000 of dollars
    private Integer accommodationAndFoodServicesSales;
    private Integer retailSalesPerCapita;
    
    
    /*
     * @return 
     */
    public Integer getRetailSales() {
        return this.retailSales;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getMerchantWholesalerSales() {
        return this.merchantWholesalerSales;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getAccommodationAndFoodServicesSales() {
        return this.accommodationAndFoodServicesSales;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getRetailSalesPerCapita() {
        return this.retailSalesPerCapita;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Sales.
	
	 * @return String
	 */
	public String toString() {
		return "Sales[" +retailSales+", "+merchantWholesalerSales+", "+accommodationAndFoodServicesSales+", "+retailSalesPerCapita+"]";
	}
	
	/**
	 * Internal constructor to create a Sales from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Sales(JSONObject json_data) {
        try {// Retail Sales
            this.retailSales = ((Number)json_data.get("Retail Sales")).intValue();// Merchant Wholesaler Sales
            this.merchantWholesalerSales = ((Number)json_data.get("Merchant Wholesaler Sales")).intValue();// Accommodation and Food Services Sales
            this.accommodationAndFoodServicesSales = ((Number)json_data.get("Accommodation and Food Services Sales")).intValue();// Retail Sales per Capita
            this.retailSalesPerCapita = ((Number)json_data.get("Retail Sales per Capita")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Sales; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Sales; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}