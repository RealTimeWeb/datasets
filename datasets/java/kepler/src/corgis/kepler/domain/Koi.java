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
public class Koi {
	
    private Double koi_Smet;
    private Double koi_Ror_Errone;
    private Double koi_Ror_Errtwo;
    private String kepoi_Name;
    private Double koi_Srad;
    private Double koi_Period;
    private Double koi_Period_Errone;
    private Double koi_Period_Errtwo;
    private Double koi_Sma_Errone;
    private Double koi_Sma_Errtwo;
    private String koi_Disposition;
    private String koi_Sparprov;
    private String dec_Str;
    private Double koi_Impact;
    private Double koi_Duration_Errtwo;
    private Double koi_Duration_Errone;
    private String koi_Pdisposition;
    private Double koi_Ror;
    private Double koi_Prad_Errone;
    private Double koi_Prad_Errtwo;
    private Double koi_Prad;
    private Double koi_Smet_Errone;
    private Double koi_Timezerobk;
    private Double koi_Incl_Errtwo;
    private Double koi_Incl_Errone;
    private Double koi_Dor;
    private Double koi_Sma;
    private Double koi_Teq_Errone;
    private Double koi_Teq_Errtwo;
    private Double koi_Depth;
    private Double koi_Dor_Errtwo;
    private Double koi_Dor_Errone;
    private Double koi_Teq;
    private String koi_Longp_Errtwo;
    private String koi_Longp_Errone;
    private Double koi_Depth_Errtwo;
    private Double koi_Slogg_Errtwo;
    private Double koi_Incl;
    private Double koi_Steff;
    private Double koi_Smet_Errtwo;
    private Double koi_Depth_Errone;
    private Integer koi_Eccen;
    private Integer kepid;
    private Double koi_Ingress_Errtwo;
    private String koi_Eccen_Errtwo;
    private Double koi_Slogg_Errone;
    private String ra_Str;
    private Double koi_Sage;
    private Double koi_Sage_Errtwo;
    private Double koi_Impact_Errtwo;
    private Double koi_Impact_Errone;
    private Double koi_Timezerobk_Errtwo;
    private Double koi_Sage_Errone;
    private Double koi_Timezerobk_Errone;
    private Double koi_Smass;
    private Double koi_Smass_Errone;
    private String koi_Eccen_Errone;
    private Double koi_Slogg;
    private Double koi_Srad_Errtwo;
    private Double koi_Srad_Errone;
    private Double koi_Smass_Errtwo;
    private String koi_Longp;
    private Double koi_Duration;
    private String koi_Vet_Stat;
    private Double koi_Ingress_Errone;
    private Double koi_Steff_Errtwo;
    private String koi_Vet_Date;
    private Double koi_Ingress;
    private Double koi_Steff_Errone;
    
    
    /*
     * @return 
     */
    public Double getKoi_Smet() {
        return this.koi_Smet;
    }
    
    
    
    /*
     * @return 
     */
    public Double getKoi_Ror_Errone() {
        return this.koi_Ror_Errone;
    }
    
    
    
    /*
     * @return 
     */
    public Double getKoi_Ror_Errtwo() {
        return this.koi_Ror_Errtwo;
    }
    
    
    
    /*
     * @return 
     */
    public String getKepoi_Name() {
        return this.kepoi_Name;
    }
    
    
    
    /*
     * @return 
     */
    public Double getKoi_Srad() {
        return this.koi_Srad;
    }
    
    
    
    /*
     * @return 
     */
    public Double getKoi_Period() {
        return this.koi_Period;
    }
    
    
    
    /*
     * @return 
     */
    public Double getKoi_Period_Errone() {
        return this.koi_Period_Errone;
    }
    
    
    
    /*
     * @return 
     */
    public Double getKoi_Period_Errtwo() {
        return this.koi_Period_Errtwo;
    }
    
    
    
    /*
     * @return 
     */
    public Double getKoi_Sma_Errone() {
        return this.koi_Sma_Errone;
    }
    
    
    
    /*
     * @return 
     */
    public Double getKoi_Sma_Errtwo() {
        return this.koi_Sma_Errtwo;
    }
    
    
    
    /*
     * @return 
     */
    public String getKoi_Disposition() {
        return this.koi_Disposition;
    }
    
    
    
    /*
     * @return 
     */
    public String getKoi_Sparprov() {
        return this.koi_Sparprov;
    }
    
    
    
    /*
     * @return 
     */
    public String getDec_Str() {
        return this.dec_Str;
    }
    
    
    
    /*
     * @return 
     */
    public Double getKoi_Impact() {
        return this.koi_Impact;
    }
    
    
    
    /*
     * @return 
     */
    public Double getKoi_Duration_Errtwo() {
        return this.koi_Duration_Errtwo;
    }
    
    
    
    /*
     * @return 
     */
    public Double getKoi_Duration_Errone() {
        return this.koi_Duration_Errone;
    }
    
    
    
    /*
     * @return 
     */
    public String getKoi_Pdisposition() {
        return this.koi_Pdisposition;
    }
    
    
    
    /*
     * @return 
     */
    public Double getKoi_Ror() {
        return this.koi_Ror;
    }
    
    
    
    /*
     * @return 
     */
    public Double getKoi_Prad_Errone() {
        return this.koi_Prad_Errone;
    }
    
    
    
    /*
     * @return 
     */
    public Double getKoi_Prad_Errtwo() {
        return this.koi_Prad_Errtwo;
    }
    
    
    
    /*
     * @return 
     */
    public Double getKoi_Prad() {
        return this.koi_Prad;
    }
    
    
    
    /*
     * @return 
     */
    public Double getKoi_Smet_Errone() {
        return this.koi_Smet_Errone;
    }
    
    
    
    /*
     * @return 
     */
    public Double getKoi_Timezerobk() {
        return this.koi_Timezerobk;
    }
    
    
    
    /*
     * @return 
     */
    public Double getKoi_Incl_Errtwo() {
        return this.koi_Incl_Errtwo;
    }
    
    
    
    /*
     * @return 
     */
    public Double getKoi_Incl_Errone() {
        return this.koi_Incl_Errone;
    }
    
    
    
    /*
     * @return 
     */
    public Double getKoi_Dor() {
        return this.koi_Dor;
    }
    
    
    
    /*
     * @return 
     */
    public Double getKoi_Sma() {
        return this.koi_Sma;
    }
    
    
    
    /*
     * @return 
     */
    public Double getKoi_Teq_Errone() {
        return this.koi_Teq_Errone;
    }
    
    
    
    /*
     * @return 
     */
    public Double getKoi_Teq_Errtwo() {
        return this.koi_Teq_Errtwo;
    }
    
    
    
    /*
     * @return 
     */
    public Double getKoi_Depth() {
        return this.koi_Depth;
    }
    
    
    
    /*
     * @return 
     */
    public Double getKoi_Dor_Errtwo() {
        return this.koi_Dor_Errtwo;
    }
    
    
    
    /*
     * @return 
     */
    public Double getKoi_Dor_Errone() {
        return this.koi_Dor_Errone;
    }
    
    
    
    /*
     * @return 
     */
    public Double getKoi_Teq() {
        return this.koi_Teq;
    }
    
    
    
    /*
     * @return 
     */
    public String getKoi_Longp_Errtwo() {
        return this.koi_Longp_Errtwo;
    }
    
    
    
    /*
     * @return 
     */
    public String getKoi_Longp_Errone() {
        return this.koi_Longp_Errone;
    }
    
    
    
    /*
     * @return 
     */
    public Double getKoi_Depth_Errtwo() {
        return this.koi_Depth_Errtwo;
    }
    
    
    
    /*
     * @return 
     */
    public Double getKoi_Slogg_Errtwo() {
        return this.koi_Slogg_Errtwo;
    }
    
    
    
    /*
     * @return 
     */
    public Double getKoi_Incl() {
        return this.koi_Incl;
    }
    
    
    
    /*
     * @return 
     */
    public Double getKoi_Steff() {
        return this.koi_Steff;
    }
    
    
    
    /*
     * @return 
     */
    public Double getKoi_Smet_Errtwo() {
        return this.koi_Smet_Errtwo;
    }
    
    
    
    /*
     * @return 
     */
    public Double getKoi_Depth_Errone() {
        return this.koi_Depth_Errone;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getKoi_Eccen() {
        return this.koi_Eccen;
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
    public Double getKoi_Ingress_Errtwo() {
        return this.koi_Ingress_Errtwo;
    }
    
    
    
    /*
     * @return 
     */
    public String getKoi_Eccen_Errtwo() {
        return this.koi_Eccen_Errtwo;
    }
    
    
    
    /*
     * @return 
     */
    public Double getKoi_Slogg_Errone() {
        return this.koi_Slogg_Errone;
    }
    
    
    
    /*
     * @return 
     */
    public String getRa_Str() {
        return this.ra_Str;
    }
    
    
    
    /*
     * @return 
     */
    public Double getKoi_Sage() {
        return this.koi_Sage;
    }
    
    
    
    /*
     * @return 
     */
    public Double getKoi_Sage_Errtwo() {
        return this.koi_Sage_Errtwo;
    }
    
    
    
    /*
     * @return 
     */
    public Double getKoi_Impact_Errtwo() {
        return this.koi_Impact_Errtwo;
    }
    
    
    
    /*
     * @return 
     */
    public Double getKoi_Impact_Errone() {
        return this.koi_Impact_Errone;
    }
    
    
    
    /*
     * @return 
     */
    public Double getKoi_Timezerobk_Errtwo() {
        return this.koi_Timezerobk_Errtwo;
    }
    
    
    
    /*
     * @return 
     */
    public Double getKoi_Sage_Errone() {
        return this.koi_Sage_Errone;
    }
    
    
    
    /*
     * @return 
     */
    public Double getKoi_Timezerobk_Errone() {
        return this.koi_Timezerobk_Errone;
    }
    
    
    
    /*
     * @return 
     */
    public Double getKoi_Smass() {
        return this.koi_Smass;
    }
    
    
    
    /*
     * @return 
     */
    public Double getKoi_Smass_Errone() {
        return this.koi_Smass_Errone;
    }
    
    
    
    /*
     * @return 
     */
    public String getKoi_Eccen_Errone() {
        return this.koi_Eccen_Errone;
    }
    
    
    
    /*
     * @return 
     */
    public Double getKoi_Slogg() {
        return this.koi_Slogg;
    }
    
    
    
    /*
     * @return 
     */
    public Double getKoi_Srad_Errtwo() {
        return this.koi_Srad_Errtwo;
    }
    
    
    
    /*
     * @return 
     */
    public Double getKoi_Srad_Errone() {
        return this.koi_Srad_Errone;
    }
    
    
    
    /*
     * @return 
     */
    public Double getKoi_Smass_Errtwo() {
        return this.koi_Smass_Errtwo;
    }
    
    
    
    /*
     * @return 
     */
    public String getKoi_Longp() {
        return this.koi_Longp;
    }
    
    
    
    /*
     * @return 
     */
    public Double getKoi_Duration() {
        return this.koi_Duration;
    }
    
    
    
    /*
     * @return 
     */
    public String getKoi_Vet_Stat() {
        return this.koi_Vet_Stat;
    }
    
    
    
    /*
     * @return 
     */
    public Double getKoi_Ingress_Errone() {
        return this.koi_Ingress_Errone;
    }
    
    
    
    /*
     * @return 
     */
    public Double getKoi_Steff_Errtwo() {
        return this.koi_Steff_Errtwo;
    }
    
    
    
    /*
     * @return 
     */
    public String getKoi_Vet_Date() {
        return this.koi_Vet_Date;
    }
    
    
    
    /*
     * @return 
     */
    public Double getKoi_Ingress() {
        return this.koi_Ingress;
    }
    
    
    
    /*
     * @return 
     */
    public Double getKoi_Steff_Errone() {
        return this.koi_Steff_Errone;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Koi.
	
	 * @return String
	 */
	public String toString() {
		return "Koi[" +koi_Smet+", "+koi_Ror_Errone+", "+koi_Ror_Errtwo+", "+kepoi_Name+", "+koi_Srad+", "+koi_Period+", "+koi_Period_Errone+", "+koi_Period_Errtwo+", "+koi_Sma_Errone+", "+koi_Sma_Errtwo+", "+koi_Disposition+", "+koi_Sparprov+", "+dec_Str+", "+koi_Impact+", "+koi_Duration_Errtwo+", "+koi_Duration_Errone+", "+koi_Pdisposition+", "+koi_Ror+", "+koi_Prad_Errone+", "+koi_Prad_Errtwo+", "+koi_Prad+", "+koi_Smet_Errone+", "+koi_Timezerobk+", "+koi_Incl_Errtwo+", "+koi_Incl_Errone+", "+koi_Dor+", "+koi_Sma+", "+koi_Teq_Errone+", "+koi_Teq_Errtwo+", "+koi_Depth+", "+koi_Dor_Errtwo+", "+koi_Dor_Errone+", "+koi_Teq+", "+koi_Longp_Errtwo+", "+koi_Longp_Errone+", "+koi_Depth_Errtwo+", "+koi_Slogg_Errtwo+", "+koi_Incl+", "+koi_Steff+", "+koi_Smet_Errtwo+", "+koi_Depth_Errone+", "+koi_Eccen+", "+kepid+", "+koi_Ingress_Errtwo+", "+koi_Eccen_Errtwo+", "+koi_Slogg_Errone+", "+ra_Str+", "+koi_Sage+", "+koi_Sage_Errtwo+", "+koi_Impact_Errtwo+", "+koi_Impact_Errone+", "+koi_Timezerobk_Errtwo+", "+koi_Sage_Errone+", "+koi_Timezerobk_Errone+", "+koi_Smass+", "+koi_Smass_Errone+", "+koi_Eccen_Errone+", "+koi_Slogg+", "+koi_Srad_Errtwo+", "+koi_Srad_Errone+", "+koi_Smass_Errtwo+", "+koi_Longp+", "+koi_Duration+", "+koi_Vet_Stat+", "+koi_Ingress_Errone+", "+koi_Steff_Errtwo+", "+koi_Vet_Date+", "+koi_Ingress+", "+koi_Steff_Errone+"]";
	}
	
	/**
	 * Internal constructor to create a Koi from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Koi(JSONObject json_data) {
        try {// koi_smet
            this.koi_Smet = (Double)json_data.get("koi_smet");// koi_ror_err1
            this.koi_Ror_Errone = (Double)json_data.get("koi_ror_err1");// koi_ror_err2
            this.koi_Ror_Errtwo = (Double)json_data.get("koi_ror_err2");// kepoi_name
            this.kepoi_Name = (String)json_data.get("kepoi_name");// koi_srad
            this.koi_Srad = (Double)json_data.get("koi_srad");// koi_period
            this.koi_Period = (Double)json_data.get("koi_period");// koi_period_err1
            this.koi_Period_Errone = (Double)json_data.get("koi_period_err1");// koi_period_err2
            this.koi_Period_Errtwo = (Double)json_data.get("koi_period_err2");// koi_sma_err1
            this.koi_Sma_Errone = (Double)json_data.get("koi_sma_err1");// koi_sma_err2
            this.koi_Sma_Errtwo = (Double)json_data.get("koi_sma_err2");// koi_disposition
            this.koi_Disposition = (String)json_data.get("koi_disposition");// koi_sparprov
            this.koi_Sparprov = (String)json_data.get("koi_sparprov");// dec_str
            this.dec_Str = (String)json_data.get("dec_str");// koi_impact
            this.koi_Impact = (Double)json_data.get("koi_impact");// koi_duration_err2
            this.koi_Duration_Errtwo = (Double)json_data.get("koi_duration_err2");// koi_duration_err1
            this.koi_Duration_Errone = (Double)json_data.get("koi_duration_err1");// koi_pdisposition
            this.koi_Pdisposition = (String)json_data.get("koi_pdisposition");// koi_ror
            this.koi_Ror = (Double)json_data.get("koi_ror");// koi_prad_err1
            this.koi_Prad_Errone = (Double)json_data.get("koi_prad_err1");// koi_prad_err2
            this.koi_Prad_Errtwo = (Double)json_data.get("koi_prad_err2");// koi_prad
            this.koi_Prad = (Double)json_data.get("koi_prad");// koi_smet_err1
            this.koi_Smet_Errone = (Double)json_data.get("koi_smet_err1");// koi_time0bk
            this.koi_Timezerobk = (Double)json_data.get("koi_time0bk");// koi_incl_err2
            this.koi_Incl_Errtwo = (Double)json_data.get("koi_incl_err2");// koi_incl_err1
            this.koi_Incl_Errone = (Double)json_data.get("koi_incl_err1");// koi_dor
            this.koi_Dor = (Double)json_data.get("koi_dor");// koi_sma
            this.koi_Sma = (Double)json_data.get("koi_sma");// koi_teq_err1
            this.koi_Teq_Errone = (Double)json_data.get("koi_teq_err1");// koi_teq_err2
            this.koi_Teq_Errtwo = (Double)json_data.get("koi_teq_err2");// koi_depth
            this.koi_Depth = (Double)json_data.get("koi_depth");// koi_dor_err2
            this.koi_Dor_Errtwo = (Double)json_data.get("koi_dor_err2");// koi_dor_err1
            this.koi_Dor_Errone = (Double)json_data.get("koi_dor_err1");// koi_teq
            this.koi_Teq = (Double)json_data.get("koi_teq");// koi_longp_err2
            this.koi_Longp_Errtwo = (String)json_data.get("koi_longp_err2");// koi_longp_err1
            this.koi_Longp_Errone = (String)json_data.get("koi_longp_err1");// koi_depth_err2
            this.koi_Depth_Errtwo = (Double)json_data.get("koi_depth_err2");// koi_slogg_err2
            this.koi_Slogg_Errtwo = (Double)json_data.get("koi_slogg_err2");// koi_incl
            this.koi_Incl = (Double)json_data.get("koi_incl");// koi_steff
            this.koi_Steff = (Double)json_data.get("koi_steff");// koi_smet_err2
            this.koi_Smet_Errtwo = (Double)json_data.get("koi_smet_err2");// koi_depth_err1
            this.koi_Depth_Errone = (Double)json_data.get("koi_depth_err1");// koi_eccen
            this.koi_Eccen = new Integer(((Long)json_data.get("koi_eccen")).intValue());// kepid
            this.kepid = new Integer(((Long)json_data.get("kepid")).intValue());// koi_ingress_err2
            this.koi_Ingress_Errtwo = (Double)json_data.get("koi_ingress_err2");// koi_eccen_err2
            this.koi_Eccen_Errtwo = (String)json_data.get("koi_eccen_err2");// koi_slogg_err1
            this.koi_Slogg_Errone = (Double)json_data.get("koi_slogg_err1");// ra_str
            this.ra_Str = (String)json_data.get("ra_str");// koi_sage
            this.koi_Sage = (Double)json_data.get("koi_sage");// koi_sage_err2
            this.koi_Sage_Errtwo = (Double)json_data.get("koi_sage_err2");// koi_impact_err2
            this.koi_Impact_Errtwo = (Double)json_data.get("koi_impact_err2");// koi_impact_err1
            this.koi_Impact_Errone = (Double)json_data.get("koi_impact_err1");// koi_time0bk_err2
            this.koi_Timezerobk_Errtwo = (Double)json_data.get("koi_time0bk_err2");// koi_sage_err1
            this.koi_Sage_Errone = (Double)json_data.get("koi_sage_err1");// koi_time0bk_err1
            this.koi_Timezerobk_Errone = (Double)json_data.get("koi_time0bk_err1");// koi_smass
            this.koi_Smass = (Double)json_data.get("koi_smass");// koi_smass_err1
            this.koi_Smass_Errone = (Double)json_data.get("koi_smass_err1");// koi_eccen_err1
            this.koi_Eccen_Errone = (String)json_data.get("koi_eccen_err1");// koi_slogg
            this.koi_Slogg = (Double)json_data.get("koi_slogg");// koi_srad_err2
            this.koi_Srad_Errtwo = (Double)json_data.get("koi_srad_err2");// koi_srad_err1
            this.koi_Srad_Errone = (Double)json_data.get("koi_srad_err1");// koi_smass_err2
            this.koi_Smass_Errtwo = (Double)json_data.get("koi_smass_err2");// koi_longp
            this.koi_Longp = (String)json_data.get("koi_longp");// koi_duration
            this.koi_Duration = (Double)json_data.get("koi_duration");// koi_vet_stat
            this.koi_Vet_Stat = (String)json_data.get("koi_vet_stat");// koi_ingress_err1
            this.koi_Ingress_Errone = (Double)json_data.get("koi_ingress_err1");// koi_steff_err2
            this.koi_Steff_Errtwo = (Double)json_data.get("koi_steff_err2");// koi_vet_date
            this.koi_Vet_Date = (String)json_data.get("koi_vet_date");// koi_ingress
            this.koi_Ingress = (Double)json_data.get("koi_ingress");// koi_steff_err1
            this.koi_Steff_Errone = (Double)json_data.get("koi_steff_err1");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Koi; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Koi; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}