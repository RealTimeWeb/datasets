package corgis.skyscrapers.domain;

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
public class Purposes {
	
    private Boolean bridge;
    private Boolean industrial;
    private Boolean office;
    private Boolean library;
    private Boolean education;
    private Boolean religious;
    private Boolean telecommunications;
    private Boolean belltower;
    private Boolean residential;
    private Boolean hospital;
    private Boolean other;
    private Boolean exhibition;
    private Boolean servicedApartments;
    private Boolean multiple;
    private Boolean government;
    private Boolean hotel;
    private Boolean commercial;
    private Boolean abandoned;
    private Boolean observation;
    private Boolean airTrafficControlTower;
    private Boolean casino;
    private Boolean retail;
    private Boolean museum;
    
    
    /*
     * @return 
     */
    public Boolean getBridge() {
        return this.bridge;
    }
    
    
    
    /*
     * @return 
     */
    public Boolean getIndustrial() {
        return this.industrial;
    }
    
    
    
    /*
     * @return 
     */
    public Boolean getOffice() {
        return this.office;
    }
    
    
    
    /*
     * @return 
     */
    public Boolean getLibrary() {
        return this.library;
    }
    
    
    
    /*
     * @return 
     */
    public Boolean getEducation() {
        return this.education;
    }
    
    
    
    /*
     * @return 
     */
    public Boolean getReligious() {
        return this.religious;
    }
    
    
    
    /*
     * @return 
     */
    public Boolean getTelecommunications() {
        return this.telecommunications;
    }
    
    
    
    /*
     * @return 
     */
    public Boolean getBelltower() {
        return this.belltower;
    }
    
    
    
    /*
     * @return 
     */
    public Boolean getResidential() {
        return this.residential;
    }
    
    
    
    /*
     * @return 
     */
    public Boolean getHospital() {
        return this.hospital;
    }
    
    
    
    /*
     * @return 
     */
    public Boolean getOther() {
        return this.other;
    }
    
    
    
    /*
     * @return 
     */
    public Boolean getExhibition() {
        return this.exhibition;
    }
    
    
    
    /*
     * @return 
     */
    public Boolean getServicedApartments() {
        return this.servicedApartments;
    }
    
    
    
    /*
     * @return 
     */
    public Boolean getMultiple() {
        return this.multiple;
    }
    
    
    
    /*
     * @return 
     */
    public Boolean getGovernment() {
        return this.government;
    }
    
    
    
    /*
     * @return 
     */
    public Boolean getHotel() {
        return this.hotel;
    }
    
    
    
    /*
     * @return 
     */
    public Boolean getCommercial() {
        return this.commercial;
    }
    
    
    
    /*
     * @return 
     */
    public Boolean getAbandoned() {
        return this.abandoned;
    }
    
    
    
    /*
     * @return 
     */
    public Boolean getObservation() {
        return this.observation;
    }
    
    
    
    /*
     * @return 
     */
    public Boolean getAirTrafficControlTower() {
        return this.airTrafficControlTower;
    }
    
    
    
    /*
     * @return 
     */
    public Boolean getCasino() {
        return this.casino;
    }
    
    
    
    /*
     * @return 
     */
    public Boolean getRetail() {
        return this.retail;
    }
    
    
    
    /*
     * @return 
     */
    public Boolean getMuseum() {
        return this.museum;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Purposes.
	
	 * @return String
	 */
	public String toString() {
		return "Purposes[" +bridge+", "+industrial+", "+office+", "+library+", "+education+", "+religious+", "+telecommunications+", "+belltower+", "+residential+", "+hospital+", "+other+", "+exhibition+", "+servicedApartments+", "+multiple+", "+government+", "+hotel+", "+commercial+", "+abandoned+", "+observation+", "+airTrafficControlTower+", "+casino+", "+retail+", "+museum+"]";
	}
	
	/**
	 * Internal constructor to create a Purposes from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Purposes(JSONObject json_data) {
        try {// bridge
            this.bridge = (Boolean)json_data.get("bridge");// industrial
            this.industrial = (Boolean)json_data.get("industrial");// office
            this.office = (Boolean)json_data.get("office");// library
            this.library = (Boolean)json_data.get("library");// education
            this.education = (Boolean)json_data.get("education");// religious
            this.religious = (Boolean)json_data.get("religious");// telecommunications
            this.telecommunications = (Boolean)json_data.get("telecommunications");// belltower
            this.belltower = (Boolean)json_data.get("belltower");// residential
            this.residential = (Boolean)json_data.get("residential");// hospital
            this.hospital = (Boolean)json_data.get("hospital");// other
            this.other = (Boolean)json_data.get("other");// exhibition
            this.exhibition = (Boolean)json_data.get("exhibition");// serviced apartments
            this.servicedApartments = (Boolean)json_data.get("serviced apartments");// multiple
            this.multiple = (Boolean)json_data.get("multiple");// government
            this.government = (Boolean)json_data.get("government");// hotel
            this.hotel = (Boolean)json_data.get("hotel");// commercial
            this.commercial = (Boolean)json_data.get("commercial");// abandoned
            this.abandoned = (Boolean)json_data.get("abandoned");// observation
            this.observation = (Boolean)json_data.get("observation");// air traffic control tower
            this.airTrafficControlTower = (Boolean)json_data.get("air traffic control tower");// casino
            this.casino = (Boolean)json_data.get("casino");// retail
            this.retail = (Boolean)json_data.get("retail");// museum
            this.museum = (Boolean)json_data.get("museum");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Purposes; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Purposes; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}