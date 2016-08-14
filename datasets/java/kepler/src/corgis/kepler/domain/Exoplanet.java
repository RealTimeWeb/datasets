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
public class Exoplanet {
	
    private Integer pl_Orbsmaxlim;
    private Integer pl_Msinin;
    private Double pl_Orbpererrtwo;
    private Integer pl_Orbeccenlim;
    private Double pl_Msinij;
    private Integer pl_Massjlim;
    private Double pl_Massjerrone;
    private Integer pl_Orbsmaxn;
    private Integer st_Teffblend;
    private Double st_Rad;
    private String pl_Letter;
    private Integer pl_Massn;
    private Integer st_Radblend;
    private Double pl_Massj;
    private Integer st_Distlim;
    private Integer st_Posn;
    private Double pl_Orbsmaxerrone;
    private Double pl_Orbsmaxerrtwo;
    private Integer pl_Msinijlim;
    private Double st_Raderr;
    private Double pl_Dens;
    private Double pl_Orbsmax;
    private Double pl_Denserrtwo;
    private Double pl_Denserrone;
    private String hip_Name;
    private Integer pl_Pnum;
    private Integer st_Radn;
    private Double st_Vjerr;
    private Double pl_Orbeccenerrone;
    private Double pl_Orbeccenerrtwo;
    private Double st_Decerr;
    private Double pl_Radjerrtwo;
    private Double st_Teff;
    private String pl_Discmethod;
    private Double pl_Radjerrone;
    private String hd_Name;
    private String pl_Hostname;
    private Double pl_Massjerrtwo;
    private Double ra;
    private Integer st_Radlim;
    private Integer st_Tefflim;
    private Integer pl_Orbeccenn;
    private Double st_Raerr;
    private Double st_Mass;
    private Integer pl_Ttvflag;
    private Integer st_Masslim;
    private Double pl_Radj;
    private Integer st_Massblend;
    private Integer st_Massn;
    private Integer pl_Densn;
    private Double st_Tefferr;
    private Integer st_Vjlim;
    private Integer st_Vjblend;
    private Integer pl_Denslim;
    private Integer pl_Radjlim;
    private String dec_Str;
    private Double pl_Msinijerrone;
    private Integer pl_Orbpern;
    private Double pl_Msinijerrtwo;
    private String ra_Str;
    private Integer st_Distn;
    private Double pl_Orbincl;
    private Integer pl_Orbperlim;
    private Integer st_Teffn;
    private Double pl_Orbeccen;
    private Double pl_Orbinclerrtwo;
    private Double pl_Orbinclerrone;
    private Double st_Dist;
    private Double pl_Orbpererrone;
    private Double st_Masserr;
    private Integer pl_Radn;
    private Double st_Disterrone;
    private Integer pl_Kepflag;
    private Double pl_Orbper;
    private Double st_Disterrtwo;
    private Integer pl_Orbincln;
    private Double dec;
    private Integer pl_Orbincllim;
    private Double st_Vj;
    
    
    /*
     * @return 
     */
    public Integer getPl_Orbsmaxlim() {
        return this.pl_Orbsmaxlim;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getPl_Msinin() {
        return this.pl_Msinin;
    }
    
    
    
    /*
     * @return 
     */
    public Double getPl_Orbpererrtwo() {
        return this.pl_Orbpererrtwo;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getPl_Orbeccenlim() {
        return this.pl_Orbeccenlim;
    }
    
    
    
    /*
     * @return 
     */
    public Double getPl_Msinij() {
        return this.pl_Msinij;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getPl_Massjlim() {
        return this.pl_Massjlim;
    }
    
    
    
    /*
     * @return 
     */
    public Double getPl_Massjerrone() {
        return this.pl_Massjerrone;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getPl_Orbsmaxn() {
        return this.pl_Orbsmaxn;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getSt_Teffblend() {
        return this.st_Teffblend;
    }
    
    
    
    /*
     * @return 
     */
    public Double getSt_Rad() {
        return this.st_Rad;
    }
    
    
    
    /*
     * @return 
     */
    public String getPl_Letter() {
        return this.pl_Letter;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getPl_Massn() {
        return this.pl_Massn;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getSt_Radblend() {
        return this.st_Radblend;
    }
    
    
    
    /*
     * @return 
     */
    public Double getPl_Massj() {
        return this.pl_Massj;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getSt_Distlim() {
        return this.st_Distlim;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getSt_Posn() {
        return this.st_Posn;
    }
    
    
    
    /*
     * @return 
     */
    public Double getPl_Orbsmaxerrone() {
        return this.pl_Orbsmaxerrone;
    }
    
    
    
    /*
     * @return 
     */
    public Double getPl_Orbsmaxerrtwo() {
        return this.pl_Orbsmaxerrtwo;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getPl_Msinijlim() {
        return this.pl_Msinijlim;
    }
    
    
    
    /*
     * @return 
     */
    public Double getSt_Raderr() {
        return this.st_Raderr;
    }
    
    
    
    /*
     * @return 
     */
    public Double getPl_Dens() {
        return this.pl_Dens;
    }
    
    
    
    /*
     * @return 
     */
    public Double getPl_Orbsmax() {
        return this.pl_Orbsmax;
    }
    
    
    
    /*
     * @return 
     */
    public Double getPl_Denserrtwo() {
        return this.pl_Denserrtwo;
    }
    
    
    
    /*
     * @return 
     */
    public Double getPl_Denserrone() {
        return this.pl_Denserrone;
    }
    
    
    
    /*
     * @return 
     */
    public String getHip_Name() {
        return this.hip_Name;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getPl_Pnum() {
        return this.pl_Pnum;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getSt_Radn() {
        return this.st_Radn;
    }
    
    
    
    /*
     * @return 
     */
    public Double getSt_Vjerr() {
        return this.st_Vjerr;
    }
    
    
    
    /*
     * @return 
     */
    public Double getPl_Orbeccenerrone() {
        return this.pl_Orbeccenerrone;
    }
    
    
    
    /*
     * @return 
     */
    public Double getPl_Orbeccenerrtwo() {
        return this.pl_Orbeccenerrtwo;
    }
    
    
    
    /*
     * @return 
     */
    public Double getSt_Decerr() {
        return this.st_Decerr;
    }
    
    
    
    /*
     * @return 
     */
    public Double getPl_Radjerrtwo() {
        return this.pl_Radjerrtwo;
    }
    
    
    
    /*
     * @return 
     */
    public Double getSt_Teff() {
        return this.st_Teff;
    }
    
    
    
    /*
     * @return 
     */
    public String getPl_Discmethod() {
        return this.pl_Discmethod;
    }
    
    
    
    /*
     * @return 
     */
    public Double getPl_Radjerrone() {
        return this.pl_Radjerrone;
    }
    
    
    
    /*
     * @return 
     */
    public String getHd_Name() {
        return this.hd_Name;
    }
    
    
    
    /*
     * @return 
     */
    public String getPl_Hostname() {
        return this.pl_Hostname;
    }
    
    
    
    /*
     * @return 
     */
    public Double getPl_Massjerrtwo() {
        return this.pl_Massjerrtwo;
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
    public Integer getSt_Radlim() {
        return this.st_Radlim;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getSt_Tefflim() {
        return this.st_Tefflim;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getPl_Orbeccenn() {
        return this.pl_Orbeccenn;
    }
    
    
    
    /*
     * @return 
     */
    public Double getSt_Raerr() {
        return this.st_Raerr;
    }
    
    
    
    /*
     * @return 
     */
    public Double getSt_Mass() {
        return this.st_Mass;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getPl_Ttvflag() {
        return this.pl_Ttvflag;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getSt_Masslim() {
        return this.st_Masslim;
    }
    
    
    
    /*
     * @return 
     */
    public Double getPl_Radj() {
        return this.pl_Radj;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getSt_Massblend() {
        return this.st_Massblend;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getSt_Massn() {
        return this.st_Massn;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getPl_Densn() {
        return this.pl_Densn;
    }
    
    
    
    /*
     * @return 
     */
    public Double getSt_Tefferr() {
        return this.st_Tefferr;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getSt_Vjlim() {
        return this.st_Vjlim;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getSt_Vjblend() {
        return this.st_Vjblend;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getPl_Denslim() {
        return this.pl_Denslim;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getPl_Radjlim() {
        return this.pl_Radjlim;
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
    public Double getPl_Msinijerrone() {
        return this.pl_Msinijerrone;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getPl_Orbpern() {
        return this.pl_Orbpern;
    }
    
    
    
    /*
     * @return 
     */
    public Double getPl_Msinijerrtwo() {
        return this.pl_Msinijerrtwo;
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
    public Integer getSt_Distn() {
        return this.st_Distn;
    }
    
    
    
    /*
     * @return 
     */
    public Double getPl_Orbincl() {
        return this.pl_Orbincl;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getPl_Orbperlim() {
        return this.pl_Orbperlim;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getSt_Teffn() {
        return this.st_Teffn;
    }
    
    
    
    /*
     * @return 
     */
    public Double getPl_Orbeccen() {
        return this.pl_Orbeccen;
    }
    
    
    
    /*
     * @return 
     */
    public Double getPl_Orbinclerrtwo() {
        return this.pl_Orbinclerrtwo;
    }
    
    
    
    /*
     * @return 
     */
    public Double getPl_Orbinclerrone() {
        return this.pl_Orbinclerrone;
    }
    
    
    
    /*
     * @return 
     */
    public Double getSt_Dist() {
        return this.st_Dist;
    }
    
    
    
    /*
     * @return 
     */
    public Double getPl_Orbpererrone() {
        return this.pl_Orbpererrone;
    }
    
    
    
    /*
     * @return 
     */
    public Double getSt_Masserr() {
        return this.st_Masserr;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getPl_Radn() {
        return this.pl_Radn;
    }
    
    
    
    /*
     * @return 
     */
    public Double getSt_Disterrone() {
        return this.st_Disterrone;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getPl_Kepflag() {
        return this.pl_Kepflag;
    }
    
    
    
    /*
     * @return 
     */
    public Double getPl_Orbper() {
        return this.pl_Orbper;
    }
    
    
    
    /*
     * @return 
     */
    public Double getSt_Disterrtwo() {
        return this.st_Disterrtwo;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getPl_Orbincln() {
        return this.pl_Orbincln;
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
    public Integer getPl_Orbincllim() {
        return this.pl_Orbincllim;
    }
    
    
    
    /*
     * @return 
     */
    public Double getSt_Vj() {
        return this.st_Vj;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Exoplanet.
	
	 * @return String
	 */
	public String toString() {
		return "Exoplanet[" +pl_Orbsmaxlim+", "+pl_Msinin+", "+pl_Orbpererrtwo+", "+pl_Orbeccenlim+", "+pl_Msinij+", "+pl_Massjlim+", "+pl_Massjerrone+", "+pl_Orbsmaxn+", "+st_Teffblend+", "+st_Rad+", "+pl_Letter+", "+pl_Massn+", "+st_Radblend+", "+pl_Massj+", "+st_Distlim+", "+st_Posn+", "+pl_Orbsmaxerrone+", "+pl_Orbsmaxerrtwo+", "+pl_Msinijlim+", "+st_Raderr+", "+pl_Dens+", "+pl_Orbsmax+", "+pl_Denserrtwo+", "+pl_Denserrone+", "+hip_Name+", "+pl_Pnum+", "+st_Radn+", "+st_Vjerr+", "+pl_Orbeccenerrone+", "+pl_Orbeccenerrtwo+", "+st_Decerr+", "+pl_Radjerrtwo+", "+st_Teff+", "+pl_Discmethod+", "+pl_Radjerrone+", "+hd_Name+", "+pl_Hostname+", "+pl_Massjerrtwo+", "+ra+", "+st_Radlim+", "+st_Tefflim+", "+pl_Orbeccenn+", "+st_Raerr+", "+st_Mass+", "+pl_Ttvflag+", "+st_Masslim+", "+pl_Radj+", "+st_Massblend+", "+st_Massn+", "+pl_Densn+", "+st_Tefferr+", "+st_Vjlim+", "+st_Vjblend+", "+pl_Denslim+", "+pl_Radjlim+", "+dec_Str+", "+pl_Msinijerrone+", "+pl_Orbpern+", "+pl_Msinijerrtwo+", "+ra_Str+", "+st_Distn+", "+pl_Orbincl+", "+pl_Orbperlim+", "+st_Teffn+", "+pl_Orbeccen+", "+pl_Orbinclerrtwo+", "+pl_Orbinclerrone+", "+st_Dist+", "+pl_Orbpererrone+", "+st_Masserr+", "+pl_Radn+", "+st_Disterrone+", "+pl_Kepflag+", "+pl_Orbper+", "+st_Disterrtwo+", "+pl_Orbincln+", "+dec+", "+pl_Orbincllim+", "+st_Vj+"]";
	}
	
	/**
	 * Internal constructor to create a Exoplanet from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Exoplanet(JSONObject json_data) {
        try {// pl_orbsmaxlim
            this.pl_Orbsmaxlim = new Integer(((Long)json_data.get("pl_orbsmaxlim")).intValue());// pl_msinin
            this.pl_Msinin = new Integer(((Long)json_data.get("pl_msinin")).intValue());// pl_orbpererr2
            this.pl_Orbpererrtwo = (Double)json_data.get("pl_orbpererr2");// pl_orbeccenlim
            this.pl_Orbeccenlim = new Integer(((Long)json_data.get("pl_orbeccenlim")).intValue());// pl_msinij
            this.pl_Msinij = (Double)json_data.get("pl_msinij");// pl_massjlim
            this.pl_Massjlim = new Integer(((Long)json_data.get("pl_massjlim")).intValue());// pl_massjerr1
            this.pl_Massjerrone = (Double)json_data.get("pl_massjerr1");// pl_orbsmaxn
            this.pl_Orbsmaxn = new Integer(((Long)json_data.get("pl_orbsmaxn")).intValue());// st_teffblend
            this.st_Teffblend = new Integer(((Long)json_data.get("st_teffblend")).intValue());// st_rad
            this.st_Rad = (Double)json_data.get("st_rad");// pl_letter
            this.pl_Letter = (String)json_data.get("pl_letter");// pl_massn
            this.pl_Massn = new Integer(((Long)json_data.get("pl_massn")).intValue());// st_radblend
            this.st_Radblend = new Integer(((Long)json_data.get("st_radblend")).intValue());// pl_massj
            this.pl_Massj = (Double)json_data.get("pl_massj");// st_distlim
            this.st_Distlim = new Integer(((Long)json_data.get("st_distlim")).intValue());// st_posn
            this.st_Posn = new Integer(((Long)json_data.get("st_posn")).intValue());// pl_orbsmaxerr1
            this.pl_Orbsmaxerrone = (Double)json_data.get("pl_orbsmaxerr1");// pl_orbsmaxerr2
            this.pl_Orbsmaxerrtwo = (Double)json_data.get("pl_orbsmaxerr2");// pl_msinijlim
            this.pl_Msinijlim = new Integer(((Long)json_data.get("pl_msinijlim")).intValue());// st_raderr
            this.st_Raderr = (Double)json_data.get("st_raderr");// pl_dens
            this.pl_Dens = (Double)json_data.get("pl_dens");// pl_orbsmax
            this.pl_Orbsmax = (Double)json_data.get("pl_orbsmax");// pl_denserr2
            this.pl_Denserrtwo = (Double)json_data.get("pl_denserr2");// pl_denserr1
            this.pl_Denserrone = (Double)json_data.get("pl_denserr1");// hip_name
            this.hip_Name = (String)json_data.get("hip_name");// pl_pnum
            this.pl_Pnum = new Integer(((Long)json_data.get("pl_pnum")).intValue());// st_radn
            this.st_Radn = new Integer(((Long)json_data.get("st_radn")).intValue());// st_vjerr
            this.st_Vjerr = (Double)json_data.get("st_vjerr");// pl_orbeccenerr1
            this.pl_Orbeccenerrone = (Double)json_data.get("pl_orbeccenerr1");// pl_orbeccenerr2
            this.pl_Orbeccenerrtwo = (Double)json_data.get("pl_orbeccenerr2");// st_decerr
            this.st_Decerr = (Double)json_data.get("st_decerr");// pl_radjerr2
            this.pl_Radjerrtwo = (Double)json_data.get("pl_radjerr2");// st_teff
            this.st_Teff = (Double)json_data.get("st_teff");// pl_discmethod
            this.pl_Discmethod = (String)json_data.get("pl_discmethod");// pl_radjerr1
            this.pl_Radjerrone = (Double)json_data.get("pl_radjerr1");// hd_name
            this.hd_Name = (String)json_data.get("hd_name");// pl_hostname
            this.pl_Hostname = (String)json_data.get("pl_hostname");// pl_massjerr2
            this.pl_Massjerrtwo = (Double)json_data.get("pl_massjerr2");// ra
            this.ra = (Double)json_data.get("ra");// st_radlim
            this.st_Radlim = new Integer(((Long)json_data.get("st_radlim")).intValue());// st_tefflim
            this.st_Tefflim = new Integer(((Long)json_data.get("st_tefflim")).intValue());// pl_orbeccenn
            this.pl_Orbeccenn = new Integer(((Long)json_data.get("pl_orbeccenn")).intValue());// st_raerr
            this.st_Raerr = (Double)json_data.get("st_raerr");// st_mass
            this.st_Mass = (Double)json_data.get("st_mass");// pl_ttvflag
            this.pl_Ttvflag = new Integer(((Long)json_data.get("pl_ttvflag")).intValue());// st_masslim
            this.st_Masslim = new Integer(((Long)json_data.get("st_masslim")).intValue());// pl_radj
            this.pl_Radj = (Double)json_data.get("pl_radj");// st_massblend
            this.st_Massblend = new Integer(((Long)json_data.get("st_massblend")).intValue());// st_massn
            this.st_Massn = new Integer(((Long)json_data.get("st_massn")).intValue());// pl_densn
            this.pl_Densn = new Integer(((Long)json_data.get("pl_densn")).intValue());// st_tefferr
            this.st_Tefferr = (Double)json_data.get("st_tefferr");// st_vjlim
            this.st_Vjlim = new Integer(((Long)json_data.get("st_vjlim")).intValue());// st_vjblend
            this.st_Vjblend = new Integer(((Long)json_data.get("st_vjblend")).intValue());// pl_denslim
            this.pl_Denslim = new Integer(((Long)json_data.get("pl_denslim")).intValue());// pl_radjlim
            this.pl_Radjlim = new Integer(((Long)json_data.get("pl_radjlim")).intValue());// dec_str
            this.dec_Str = (String)json_data.get("dec_str");// pl_msinijerr1
            this.pl_Msinijerrone = (Double)json_data.get("pl_msinijerr1");// pl_orbpern
            this.pl_Orbpern = new Integer(((Long)json_data.get("pl_orbpern")).intValue());// pl_msinijerr2
            this.pl_Msinijerrtwo = (Double)json_data.get("pl_msinijerr2");// ra_str
            this.ra_Str = (String)json_data.get("ra_str");// st_distn
            this.st_Distn = new Integer(((Long)json_data.get("st_distn")).intValue());// pl_orbincl
            this.pl_Orbincl = (Double)json_data.get("pl_orbincl");// pl_orbperlim
            this.pl_Orbperlim = new Integer(((Long)json_data.get("pl_orbperlim")).intValue());// st_teffn
            this.st_Teffn = new Integer(((Long)json_data.get("st_teffn")).intValue());// pl_orbeccen
            this.pl_Orbeccen = (Double)json_data.get("pl_orbeccen");// pl_orbinclerr2
            this.pl_Orbinclerrtwo = (Double)json_data.get("pl_orbinclerr2");// pl_orbinclerr1
            this.pl_Orbinclerrone = (Double)json_data.get("pl_orbinclerr1");// st_dist
            this.st_Dist = (Double)json_data.get("st_dist");// pl_orbpererr1
            this.pl_Orbpererrone = (Double)json_data.get("pl_orbpererr1");// st_masserr
            this.st_Masserr = (Double)json_data.get("st_masserr");// pl_radn
            this.pl_Radn = new Integer(((Long)json_data.get("pl_radn")).intValue());// st_disterr1
            this.st_Disterrone = (Double)json_data.get("st_disterr1");// pl_kepflag
            this.pl_Kepflag = new Integer(((Long)json_data.get("pl_kepflag")).intValue());// pl_orbper
            this.pl_Orbper = (Double)json_data.get("pl_orbper");// st_disterr2
            this.st_Disterrtwo = (Double)json_data.get("st_disterr2");// pl_orbincln
            this.pl_Orbincln = new Integer(((Long)json_data.get("pl_orbincln")).intValue());// dec
            this.dec = (Double)json_data.get("dec");// pl_orbincllim
            this.pl_Orbincllim = new Integer(((Long)json_data.get("pl_orbincllim")).intValue());// st_vj
            this.st_Vj = (Double)json_data.get("st_vj");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Exoplanet; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Exoplanet; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}