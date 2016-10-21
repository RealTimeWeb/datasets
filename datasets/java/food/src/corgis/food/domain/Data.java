package corgis.food.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.food.domain.MajorMinerals;
import corgis.food.domain.Vitamins;
import corgis.food.domain.Fat;
import corgis.food.domain.HouseholdWeights;

/**
 * 
 */
public class Data {
	
    private Double niacin;
    // In milligrams per 100 grams
    private MajorMinerals majorMinerals;
    // In milligrams per 100 grams
    private Vitamins vitamins;
    private Double carboydrate;
    private Double selenium;
    private Double thiamin;
    private Integer choline;
    private Integer betaCarotene;
    private Double fiber;
    private Integer refusePercentage;
    private Fat fat;
    private Double water;
    private Integer lycopene;
    private Double pantothenicAcid;
    private Double ash;
    private Integer alphaCarotene;
    private Integer retinol;
    private Double manganese;
    private Integer betaCryptoxanthin;
    private Double riboflavin;
    private Integer cholesterol;
    private Integer luteinAndZeaxanthin;
    private Integer kilocalories;
    private HouseholdWeights householdWeights;
    private Double sugarTotal;
    private Double protein;
    
    
    /*
     * @return 
     */
    public Double getNiacin() {
        return this.niacin;
    }
    
    
    
    /*
     * @return 
     */
    public MajorMinerals getMajorMinerals() {
        return this.majorMinerals;
    }
    
    
    
    /*
     * @return 
     */
    public Vitamins getVitamins() {
        return this.vitamins;
    }
    
    
    
    /*
     * @return 
     */
    public Double getCarboydrate() {
        return this.carboydrate;
    }
    
    
    
    /*
     * @return 
     */
    public Double getSelenium() {
        return this.selenium;
    }
    
    
    
    /*
     * @return 
     */
    public Double getThiamin() {
        return this.thiamin;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getCholine() {
        return this.choline;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getBetaCarotene() {
        return this.betaCarotene;
    }
    
    
    
    /*
     * @return 
     */
    public Double getFiber() {
        return this.fiber;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getRefusePercentage() {
        return this.refusePercentage;
    }
    
    
    
    /*
     * @return 
     */
    public Fat getFat() {
        return this.fat;
    }
    
    
    
    /*
     * @return 
     */
    public Double getWater() {
        return this.water;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getLycopene() {
        return this.lycopene;
    }
    
    
    
    /*
     * @return 
     */
    public Double getPantothenicAcid() {
        return this.pantothenicAcid;
    }
    
    
    
    /*
     * @return 
     */
    public Double getAsh() {
        return this.ash;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getAlphaCarotene() {
        return this.alphaCarotene;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getRetinol() {
        return this.retinol;
    }
    
    
    
    /*
     * @return 
     */
    public Double getManganese() {
        return this.manganese;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getBetaCryptoxanthin() {
        return this.betaCryptoxanthin;
    }
    
    
    
    /*
     * @return 
     */
    public Double getRiboflavin() {
        return this.riboflavin;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getCholesterol() {
        return this.cholesterol;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getLuteinAndZeaxanthin() {
        return this.luteinAndZeaxanthin;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getKilocalories() {
        return this.kilocalories;
    }
    
    
    
    /*
     * @return 
     */
    public HouseholdWeights getHouseholdWeights() {
        return this.householdWeights;
    }
    
    
    
    /*
     * @return 
     */
    public Double getSugarTotal() {
        return this.sugarTotal;
    }
    
    
    
    /*
     * @return 
     */
    public Double getProtein() {
        return this.protein;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Data.
	
	 * @return String
	 */
	public String toString() {
		return "Data[" +niacin+", "+majorMinerals+", "+vitamins+", "+carboydrate+", "+selenium+", "+thiamin+", "+choline+", "+betaCarotene+", "+fiber+", "+refusePercentage+", "+fat+", "+water+", "+lycopene+", "+pantothenicAcid+", "+ash+", "+alphaCarotene+", "+retinol+", "+manganese+", "+betaCryptoxanthin+", "+riboflavin+", "+cholesterol+", "+luteinAndZeaxanthin+", "+kilocalories+", "+householdWeights+", "+sugarTotal+", "+protein+"]";
	}
	
	/**
	 * Internal constructor to create a Data from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Data(JSONObject json_data) {
        try {// Niacin
            this.niacin = ((Number)json_data.get("Niacin")).doubleValue();// Major Minerals
            this.majorMinerals = new MajorMinerals((JSONObject)json_data.get("Major Minerals"));// Vitamins
            this.vitamins = new Vitamins((JSONObject)json_data.get("Vitamins"));// Carboydrate
            this.carboydrate = ((Number)json_data.get("Carboydrate")).doubleValue();// Selenium
            this.selenium = ((Number)json_data.get("Selenium")).doubleValue();// Thiamin
            this.thiamin = ((Number)json_data.get("Thiamin")).doubleValue();// Choline
            this.choline = ((Number)json_data.get("Choline")).intValue();// Beta Carotene
            this.betaCarotene = ((Number)json_data.get("Beta Carotene")).intValue();// Fiber
            this.fiber = ((Number)json_data.get("Fiber")).doubleValue();// Refuse Percentage
            this.refusePercentage = ((Number)json_data.get("Refuse Percentage")).intValue();// Fat
            this.fat = new Fat((JSONObject)json_data.get("Fat"));// Water
            this.water = ((Number)json_data.get("Water")).doubleValue();// Lycopene
            this.lycopene = ((Number)json_data.get("Lycopene")).intValue();// Pantothenic Acid
            this.pantothenicAcid = ((Number)json_data.get("Pantothenic Acid")).doubleValue();// Ash
            this.ash = ((Number)json_data.get("Ash")).doubleValue();// Alpha Carotene
            this.alphaCarotene = ((Number)json_data.get("Alpha Carotene")).intValue();// Retinol
            this.retinol = ((Number)json_data.get("Retinol")).intValue();// Manganese
            this.manganese = ((Number)json_data.get("Manganese")).doubleValue();// Beta Cryptoxanthin
            this.betaCryptoxanthin = ((Number)json_data.get("Beta Cryptoxanthin")).intValue();// Riboflavin
            this.riboflavin = ((Number)json_data.get("Riboflavin")).doubleValue();// Cholesterol
            this.cholesterol = ((Number)json_data.get("Cholesterol")).intValue();// Lutein and Zeaxanthin
            this.luteinAndZeaxanthin = ((Number)json_data.get("Lutein and Zeaxanthin")).intValue();// Kilocalories
            this.kilocalories = ((Number)json_data.get("Kilocalories")).intValue();// Household Weights
            this.householdWeights = new HouseholdWeights((JSONObject)json_data.get("Household Weights"));// Sugar Total
            this.sugarTotal = ((Number)json_data.get("Sugar Total")).doubleValue();// Protein
            this.protein = ((Number)json_data.get("Protein")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}