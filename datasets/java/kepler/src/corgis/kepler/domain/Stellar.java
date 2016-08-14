package corgis.kepler.domain;

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
public class Stellar {
	
    private String st_Delivname;
    private Integer teff;
    private Integer nconfp;
    private Integer teff_Errtwo;
    private Integer nkoi;
    private Integer teff_Errone;
    private Double logg;
    private Double radius;
    private String feh_Prov;
    private String st_Vet_Date_Str;
    private String teff_Prov;
    private Double radius_Errone;
    private Double radius_Errtwo;
    private Double logg_Errtwo;
    private Integer ntce;
    private Double feh;
    private Double ra;
    private Double mass;
    private Double kepmag;
    private String logg_Prov;
    private Double logg_Errone;
    private Double dens_Errone;
    private Double dens_Errtwo;
    private Integer kepid;
    private String prov_Sec;
    private Double mass_Errone;
    private Double mass_Errtwo;
    private Double dens;
    private Integer st_Quarters;
    private String tm_Designation;
    private Double dec;
    private Double feh_Errtwo;
    private Double feh_Errone;
    
    
    /*
     * @return 
     */
    public String getSt_Delivname() {
        return this.st_Delivname;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getTeff() {
        return this.teff;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getNconfp() {
        return this.nconfp;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getTeff_Errtwo() {
        return this.teff_Errtwo;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getNkoi() {
        return this.nkoi;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getTeff_Errone() {
        return this.teff_Errone;
    }
    
    
    
    /*
     * @return 
     */
    public Double getLogg() {
        return this.logg;
    }
    
    
    
    /*
     * @return 
     */
    public Double getRadius() {
        return this.radius;
    }
    
    
    
    /*
     * @return 
     */
    public String getFeh_Prov() {
        return this.feh_Prov;
    }
    
    
    
    /*
     * @return 
     */
    public String getSt_Vet_Date_Str() {
        return this.st_Vet_Date_Str;
    }
    
    
    
    /*
     * @return 
     */
    public String getTeff_Prov() {
        return this.teff_Prov;
    }
    
    
    
    /*
     * @return 
     */
    public Double getRadius_Errone() {
        return this.radius_Errone;
    }
    
    
    
    /*
     * @return 
     */
    public Double getRadius_Errtwo() {
        return this.radius_Errtwo;
    }
    
    
    
    /*
     * @return 
     */
    public Double getLogg_Errtwo() {
        return this.logg_Errtwo;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getNtce() {
        return this.ntce;
    }
    
    
    
    /*
     * @return 
     */
    public Double getFeh() {
        return this.feh;
    }
    
    
    
    /*
     * @return 
     */
    public Double getRa() {
        return this.ra;
    }
    
    
    
    /*
     * @return 
     */
    public Double getMass() {
        return this.mass;
    }
    
    
    
    /*
     * @return 
     */
    public Double getKepmag() {
        return this.kepmag;
    }
    
    
    
    /*
     * @return 
     */
    public String getLogg_Prov() {
        return this.logg_Prov;
    }
    
    
    
    /*
     * @return 
     */
    public Double getLogg_Errone() {
        return this.logg_Errone;
    }
    
    
    
    /*
     * @return 
     */
    public Double getDens_Errone() {
        return this.dens_Errone;
    }
    
    
    
    /*
     * @return 
     */
    public Double getDens_Errtwo() {
        return this.dens_Errtwo;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getKepid() {
        return this.kepid;
    }
    
    
    
    /*
     * @return 
     */
    public String getProv_Sec() {
        return this.prov_Sec;
    }
    
    
    
    /*
     * @return 
     */
    public Double getMass_Errone() {
        return this.mass_Errone;
    }
    
    
    
    /*
     * @return 
     */
    public Double getMass_Errtwo() {
        return this.mass_Errtwo;
    }
    
    
    
    /*
     * @return 
     */
    public Double getDens() {
        return this.dens;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getSt_Quarters() {
        return this.st_Quarters;
    }
    
    
    
    /*
     * @return 
     */
    public String getTm_Designation() {
        return this.tm_Designation;
    }
    
    
    
    /*
     * @return 
     */
    public Double getDec() {
        return this.dec;
    }
    
    
    
    /*
     * @return 
     */
    public Double getFeh_Errtwo() {
        return this.feh_Errtwo;
    }
    
    
    
    /*
     * @return 
     */
    public Double getFeh_Errone() {
        return this.feh_Errone;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Stellar.
	
	 * @return String
	 */
	public String toString() {
		return "Stellar[" +st_Delivname+", "+teff+", "+nconfp+", "+teff_Errtwo+", "+nkoi+", "+teff_Errone+", "+logg+", "+radius+", "+feh_Prov+", "+st_Vet_Date_Str+", "+teff_Prov+", "+radius_Errone+", "+radius_Errtwo+", "+logg_Errtwo+", "+ntce+", "+feh+", "+ra+", "+mass+", "+kepmag+", "+logg_Prov+", "+logg_Errone+", "+dens_Errone+", "+dens_Errtwo+", "+kepid+", "+prov_Sec+", "+mass_Errone+", "+mass_Errtwo+", "+dens+", "+st_Quarters+", "+tm_Designation+", "+dec+", "+feh_Errtwo+", "+feh_Errone+"]";
	}
	
	/**
	 * Internal constructor to create a Stellar from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Stellar(JSONObject json_data) {
        try {// st_delivname
            this.st_Delivname = (String)json_data.get("st_delivname");// teff
            this.teff = new Integer(((Long)json_data.get("teff")).intValue());// nconfp
            this.nconfp = new Integer(((Long)json_data.get("nconfp")).intValue());// teff_err2
            this.teff_Errtwo = new Integer(((Long)json_data.get("teff_err2")).intValue());// nkoi
            this.nkoi = new Integer(((Long)json_data.get("nkoi")).intValue());// teff_err1
            this.teff_Errone = new Integer(((Long)json_data.get("teff_err1")).intValue());// logg
            this.logg = (Double)json_data.get("logg");// radius
            this.radius = (Double)json_data.get("radius");// feh_prov
            this.feh_Prov = (String)json_data.get("feh_prov");// st_vet_date_str
            this.st_Vet_Date_Str = (String)json_data.get("st_vet_date_str");// teff_prov
            this.teff_Prov = (String)json_data.get("teff_prov");// radius_err1
            this.radius_Errone = (Double)json_data.get("radius_err1");// radius_err2
            this.radius_Errtwo = (Double)json_data.get("radius_err2");// logg_err2
            this.logg_Errtwo = (Double)json_data.get("logg_err2");// ntce
            this.ntce = new Integer(((Long)json_data.get("ntce")).intValue());// feh
            this.feh = (Double)json_data.get("feh");// ra
            this.ra = (Double)json_data.get("ra");// mass
            this.mass = (Double)json_data.get("mass");// kepmag
            this.kepmag = (Double)json_data.get("kepmag");// logg_prov
            this.logg_Prov = (String)json_data.get("logg_prov");// logg_err1
            this.logg_Errone = (Double)json_data.get("logg_err1");// dens_err1
            this.dens_Errone = (Double)json_data.get("dens_err1");// dens_err2
            this.dens_Errtwo = (Double)json_data.get("dens_err2");// kepid
            this.kepid = new Integer(((Long)json_data.get("kepid")).intValue());// prov_sec
            this.prov_Sec = (String)json_data.get("prov_sec");// mass_err1
            this.mass_Errone = (Double)json_data.get("mass_err1");// mass_err2
            this.mass_Errtwo = (Double)json_data.get("mass_err2");// dens
            this.dens = (Double)json_data.get("dens");// st_quarters
            this.st_Quarters = new Integer(((Long)json_data.get("st_quarters")).intValue());// tm_designation
            this.tm_Designation = (String)json_data.get("tm_designation");// dec
            this.dec = (Double)json_data.get("dec");// feh_err2
            this.feh_Errtwo = (Double)json_data.get("feh_err2");// feh_err1
            this.feh_Errone = (Double)json_data.get("feh_err1");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Stellar; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Stellar; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}