package corgis.aids.domain;

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
public class PeopleLivingWithHiv {
	
    // 15-24 Years Old
    private Double hivPrevalenceAmongYoungWomen;
    // 0-14 Years Old
    private Integer childrenLivingWithHiv;
    private Integer peopleLivingWithHiv;
    // 15+ Years Old
    private Integer femaleAdultsLivingWithHiv;
    // 15-24 Years Old
    private Double hivPrevalenceAmongYoungMen;
    // 15+ Years Old
    private Integer adultsLivingWithHiv;
    // 15+ Years Old
    private Integer maleAdultsLivingWithHiv;
    // 15-49 Years Old
    private Double hivPrevalenceAmongAdults;
    
    
    /*
     * @return 
     */
    public Double getHivPrevalenceAmongYoungWomen() {
        return this.hivPrevalenceAmongYoungWomen;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getChildrenLivingWithHiv() {
        return this.childrenLivingWithHiv;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getPeopleLivingWithHiv() {
        return this.peopleLivingWithHiv;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getFemaleAdultsLivingWithHiv() {
        return this.femaleAdultsLivingWithHiv;
    }
    
    
    
    /*
     * @return 
     */
    public Double getHivPrevalenceAmongYoungMen() {
        return this.hivPrevalenceAmongYoungMen;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getAdultsLivingWithHiv() {
        return this.adultsLivingWithHiv;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getMaleAdultsLivingWithHiv() {
        return this.maleAdultsLivingWithHiv;
    }
    
    
    
    /*
     * @return 
     */
    public Double getHivPrevalenceAmongAdults() {
        return this.hivPrevalenceAmongAdults;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this PeopleLivingWithHiv.
	
	 * @return String
	 */
	public String toString() {
		return "PeopleLivingWithHiv[" +hivPrevalenceAmongYoungWomen+", "+childrenLivingWithHiv+", "+peopleLivingWithHiv+", "+femaleAdultsLivingWithHiv+", "+hivPrevalenceAmongYoungMen+", "+adultsLivingWithHiv+", "+maleAdultsLivingWithHiv+", "+hivPrevalenceAmongAdults+"]";
	}
	
	/**
	 * Internal constructor to create a PeopleLivingWithHiv from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public PeopleLivingWithHiv(JSONObject json_data) {
        try {// HIV Prevalence Among Young Women
            this.hivPrevalenceAmongYoungWomen = (Double)json_data.get("HIV Prevalence Among Young Women");// Children Living with HIV
            this.childrenLivingWithHiv = new Integer(((Long)json_data.get("Children Living with HIV")).intValue());// People Living with HIV
            this.peopleLivingWithHiv = new Integer(((Long)json_data.get("People Living with HIV")).intValue());// Female Adults Living with HIV
            this.femaleAdultsLivingWithHiv = new Integer(((Long)json_data.get("Female Adults Living with HIV")).intValue());// HIV Prevalence Among Young Men
            this.hivPrevalenceAmongYoungMen = (Double)json_data.get("HIV Prevalence Among Young Men");// Adults Living with HIV
            this.adultsLivingWithHiv = new Integer(((Long)json_data.get("Adults Living with HIV")).intValue());// Male Adults Living with HIV
            this.maleAdultsLivingWithHiv = new Integer(((Long)json_data.get("Male Adults Living with HIV")).intValue());// HIV Prevalence Among Adults
            this.hivPrevalenceAmongAdults = (Double)json_data.get("HIV Prevalence Among Adults");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a PeopleLivingWithHiv; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a PeopleLivingWithHiv; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}