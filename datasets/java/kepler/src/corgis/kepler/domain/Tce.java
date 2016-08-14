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
public class Tce {
	
    private Integer tce_Plnt_Num;
    private Double tce_Incl_Err;
    private Double tce_Steff;
    private Double tce_Ingress;
    private Integer tce_Longp;
    private Double tce_Sma;
    private Integer tce_Eccen_Err;
    private Double tce_Duration;
    private Double tce_Slogg_Err;
    private String tce_Sradius_Prov;
    private Double tce_Depth;
    private Double tce_Ror_Err;
    private Double tce_Timezerobk;
    private Double tce_Impact_Err;
    private String tce_Steff_Prov;
    private Double tce_Period;
    private Double tce_Ror;
    private String tce_Smet_Prov;
    private Double tce_Eqt_Err;
    private Double tce_Duration_Err;
    private Double tce_Ingress_Err;
    private Double tce_Period_Err;
    private Double tce_Eqt;
    private Integer tce_Eccen;
    private Double tce_Sradius_Err;
    private Double tce_Dor;
    private Double tce_Prad_Err;
    private Double tce_Sma_Err;
    private Double tce_Timezerobk_Err;
    private Integer kepid;
    private Double tce_Impact;
    private Double tce_Depth_Err;
    private Double tce_Prad;
    private String tce_Slogg_Prov;
    private Double tce_Smet;
    private Integer tce_Longp_Err;
    private Double tce_Sradius;
    private Double tce_Slogg;
    private Double tce_Steff_Err;
    private String rowupdate;
    private Double tce_Incl;
    private Double tce_Smet_Err;
    private Double tce_Dor_Err;
    
    
    /*
     * @return 
     */
    public Integer getTce_Plnt_Num() {
        return this.tce_Plnt_Num;
    }
    
    
    
    /*
     * @return 
     */
    public Double getTce_Incl_Err() {
        return this.tce_Incl_Err;
    }
    
    
    
    /*
     * @return 
     */
    public Double getTce_Steff() {
        return this.tce_Steff;
    }
    
    
    
    /*
     * @return 
     */
    public Double getTce_Ingress() {
        return this.tce_Ingress;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getTce_Longp() {
        return this.tce_Longp;
    }
    
    
    
    /*
     * @return 
     */
    public Double getTce_Sma() {
        return this.tce_Sma;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getTce_Eccen_Err() {
        return this.tce_Eccen_Err;
    }
    
    
    
    /*
     * @return 
     */
    public Double getTce_Duration() {
        return this.tce_Duration;
    }
    
    
    
    /*
     * @return 
     */
    public Double getTce_Slogg_Err() {
        return this.tce_Slogg_Err;
    }
    
    
    
    /*
     * @return 
     */
    public String getTce_Sradius_Prov() {
        return this.tce_Sradius_Prov;
    }
    
    
    
    /*
     * @return 
     */
    public Double getTce_Depth() {
        return this.tce_Depth;
    }
    
    
    
    /*
     * @return 
     */
    public Double getTce_Ror_Err() {
        return this.tce_Ror_Err;
    }
    
    
    
    /*
     * @return 
     */
    public Double getTce_Timezerobk() {
        return this.tce_Timezerobk;
    }
    
    
    
    /*
     * @return 
     */
    public Double getTce_Impact_Err() {
        return this.tce_Impact_Err;
    }
    
    
    
    /*
     * @return 
     */
    public String getTce_Steff_Prov() {
        return this.tce_Steff_Prov;
    }
    
    
    
    /*
     * @return 
     */
    public Double getTce_Period() {
        return this.tce_Period;
    }
    
    
    
    /*
     * @return 
     */
    public Double getTce_Ror() {
        return this.tce_Ror;
    }
    
    
    
    /*
     * @return 
     */
    public String getTce_Smet_Prov() {
        return this.tce_Smet_Prov;
    }
    
    
    
    /*
     * @return 
     */
    public Double getTce_Eqt_Err() {
        return this.tce_Eqt_Err;
    }
    
    
    
    /*
     * @return 
     */
    public Double getTce_Duration_Err() {
        return this.tce_Duration_Err;
    }
    
    
    
    /*
     * @return 
     */
    public Double getTce_Ingress_Err() {
        return this.tce_Ingress_Err;
    }
    
    
    
    /*
     * @return 
     */
    public Double getTce_Period_Err() {
        return this.tce_Period_Err;
    }
    
    
    
    /*
     * @return 
     */
    public Double getTce_Eqt() {
        return this.tce_Eqt;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getTce_Eccen() {
        return this.tce_Eccen;
    }
    
    
    
    /*
     * @return 
     */
    public Double getTce_Sradius_Err() {
        return this.tce_Sradius_Err;
    }
    
    
    
    /*
     * @return 
     */
    public Double getTce_Dor() {
        return this.tce_Dor;
    }
    
    
    
    /*
     * @return 
     */
    public Double getTce_Prad_Err() {
        return this.tce_Prad_Err;
    }
    
    
    
    /*
     * @return 
     */
    public Double getTce_Sma_Err() {
        return this.tce_Sma_Err;
    }
    
    
    
    /*
     * @return 
     */
    public Double getTce_Timezerobk_Err() {
        return this.tce_Timezerobk_Err;
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
    public Double getTce_Impact() {
        return this.tce_Impact;
    }
    
    
    
    /*
     * @return 
     */
    public Double getTce_Depth_Err() {
        return this.tce_Depth_Err;
    }
    
    
    
    /*
     * @return 
     */
    public Double getTce_Prad() {
        return this.tce_Prad;
    }
    
    
    
    /*
     * @return 
     */
    public String getTce_Slogg_Prov() {
        return this.tce_Slogg_Prov;
    }
    
    
    
    /*
     * @return 
     */
    public Double getTce_Smet() {
        return this.tce_Smet;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getTce_Longp_Err() {
        return this.tce_Longp_Err;
    }
    
    
    
    /*
     * @return 
     */
    public Double getTce_Sradius() {
        return this.tce_Sradius;
    }
    
    
    
    /*
     * @return 
     */
    public Double getTce_Slogg() {
        return this.tce_Slogg;
    }
    
    
    
    /*
     * @return 
     */
    public Double getTce_Steff_Err() {
        return this.tce_Steff_Err;
    }
    
    
    
    /*
     * @return 
     */
    public String getRowupdate() {
        return this.rowupdate;
    }
    
    
    
    /*
     * @return 
     */
    public Double getTce_Incl() {
        return this.tce_Incl;
    }
    
    
    
    /*
     * @return 
     */
    public Double getTce_Smet_Err() {
        return this.tce_Smet_Err;
    }
    
    
    
    /*
     * @return 
     */
    public Double getTce_Dor_Err() {
        return this.tce_Dor_Err;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Tce.
	
	 * @return String
	 */
	public String toString() {
		return "Tce[" +tce_Plnt_Num+", "+tce_Incl_Err+", "+tce_Steff+", "+tce_Ingress+", "+tce_Longp+", "+tce_Sma+", "+tce_Eccen_Err+", "+tce_Duration+", "+tce_Slogg_Err+", "+tce_Sradius_Prov+", "+tce_Depth+", "+tce_Ror_Err+", "+tce_Timezerobk+", "+tce_Impact_Err+", "+tce_Steff_Prov+", "+tce_Period+", "+tce_Ror+", "+tce_Smet_Prov+", "+tce_Eqt_Err+", "+tce_Duration_Err+", "+tce_Ingress_Err+", "+tce_Period_Err+", "+tce_Eqt+", "+tce_Eccen+", "+tce_Sradius_Err+", "+tce_Dor+", "+tce_Prad_Err+", "+tce_Sma_Err+", "+tce_Timezerobk_Err+", "+kepid+", "+tce_Impact+", "+tce_Depth_Err+", "+tce_Prad+", "+tce_Slogg_Prov+", "+tce_Smet+", "+tce_Longp_Err+", "+tce_Sradius+", "+tce_Slogg+", "+tce_Steff_Err+", "+rowupdate+", "+tce_Incl+", "+tce_Smet_Err+", "+tce_Dor_Err+"]";
	}
	
	/**
	 * Internal constructor to create a Tce from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Tce(JSONObject json_data) {
        try {// tce_plnt_num
            this.tce_Plnt_Num = new Integer(((Long)json_data.get("tce_plnt_num")).intValue());// tce_incl_err
            this.tce_Incl_Err = (Double)json_data.get("tce_incl_err");// tce_steff
            this.tce_Steff = (Double)json_data.get("tce_steff");// tce_ingress
            this.tce_Ingress = (Double)json_data.get("tce_ingress");// tce_longp
            this.tce_Longp = new Integer(((Long)json_data.get("tce_longp")).intValue());// tce_sma
            this.tce_Sma = (Double)json_data.get("tce_sma");// tce_eccen_err
            this.tce_Eccen_Err = new Integer(((Long)json_data.get("tce_eccen_err")).intValue());// tce_duration
            this.tce_Duration = (Double)json_data.get("tce_duration");// tce_slogg_err
            this.tce_Slogg_Err = (Double)json_data.get("tce_slogg_err");// tce_sradius_prov
            this.tce_Sradius_Prov = (String)json_data.get("tce_sradius_prov");// tce_depth
            this.tce_Depth = (Double)json_data.get("tce_depth");// tce_ror_err
            this.tce_Ror_Err = (Double)json_data.get("tce_ror_err");// tce_time0bk
            this.tce_Timezerobk = (Double)json_data.get("tce_time0bk");// tce_impact_err
            this.tce_Impact_Err = (Double)json_data.get("tce_impact_err");// tce_steff_prov
            this.tce_Steff_Prov = (String)json_data.get("tce_steff_prov");// tce_period
            this.tce_Period = (Double)json_data.get("tce_period");// tce_ror
            this.tce_Ror = (Double)json_data.get("tce_ror");// tce_smet_prov
            this.tce_Smet_Prov = (String)json_data.get("tce_smet_prov");// tce_eqt_err
            this.tce_Eqt_Err = (Double)json_data.get("tce_eqt_err");// tce_duration_err
            this.tce_Duration_Err = (Double)json_data.get("tce_duration_err");// tce_ingress_err
            this.tce_Ingress_Err = (Double)json_data.get("tce_ingress_err");// tce_period_err
            this.tce_Period_Err = (Double)json_data.get("tce_period_err");// tce_eqt
            this.tce_Eqt = (Double)json_data.get("tce_eqt");// tce_eccen
            this.tce_Eccen = new Integer(((Long)json_data.get("tce_eccen")).intValue());// tce_sradius_err
            this.tce_Sradius_Err = (Double)json_data.get("tce_sradius_err");// tce_dor
            this.tce_Dor = (Double)json_data.get("tce_dor");// tce_prad_err
            this.tce_Prad_Err = (Double)json_data.get("tce_prad_err");// tce_sma_err
            this.tce_Sma_Err = (Double)json_data.get("tce_sma_err");// tce_time0bk_err
            this.tce_Timezerobk_Err = (Double)json_data.get("tce_time0bk_err");// kepid
            this.kepid = new Integer(((Long)json_data.get("kepid")).intValue());// tce_impact
            this.tce_Impact = (Double)json_data.get("tce_impact");// tce_depth_err
            this.tce_Depth_Err = (Double)json_data.get("tce_depth_err");// tce_prad
            this.tce_Prad = (Double)json_data.get("tce_prad");// tce_slogg_prov
            this.tce_Slogg_Prov = (String)json_data.get("tce_slogg_prov");// tce_smet
            this.tce_Smet = (Double)json_data.get("tce_smet");// tce_longp_err
            this.tce_Longp_Err = new Integer(((Long)json_data.get("tce_longp_err")).intValue());// tce_sradius
            this.tce_Sradius = (Double)json_data.get("tce_sradius");// tce_slogg
            this.tce_Slogg = (Double)json_data.get("tce_slogg");// tce_steff_err
            this.tce_Steff_Err = (Double)json_data.get("tce_steff_err");// rowupdate
            this.rowupdate = (String)json_data.get("rowupdate");// tce_incl
            this.tce_Incl = (Double)json_data.get("tce_incl");// tce_smet_err
            this.tce_Smet_Err = (Double)json_data.get("tce_smet_err");// tce_dor_err
            this.tce_Dor_Err = (Double)json_data.get("tce_dor_err");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Tce; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Tce; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}