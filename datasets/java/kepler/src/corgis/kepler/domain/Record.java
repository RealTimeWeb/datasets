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
public class Record {
	
    private String koi_List_Flag;
    private Double dec_Err;
    private String kepoi_Name;
    private String kepler_Name;
    private String tm_Designation;
    private Double ra_Err;
    private String last_Update;
    private Double ra;
    private Integer kepid;
    private String dec_Str;
    private Double dec;
    private String ra_Str;
    private String alt_Name;
    
    
    /*
     * @return 
     */
    public String getKoi_List_Flag() {
        return this.koi_List_Flag;
    }
    
    
    
    /*
     * @return 
     */
    public Double getDec_Err() {
        return this.dec_Err;
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
    public String getKepler_Name() {
        return this.kepler_Name;
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
    public Double getRa_Err() {
        return this.ra_Err;
    }
    
    
    
    /*
     * @return 
     */
    public String getLast_Update() {
        return this.last_Update;
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
    public Integer getKepid() {
        return this.kepid;
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
    public Double getDec() {
        return this.dec;
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
    public String getAlt_Name() {
        return this.alt_Name;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Record.
	
	 * @return String
	 */
	public String toString() {
		return "Record[" +koi_List_Flag+", "+dec_Err+", "+kepoi_Name+", "+kepler_Name+", "+tm_Designation+", "+ra_Err+", "+last_Update+", "+ra+", "+kepid+", "+dec_Str+", "+dec+", "+ra_Str+", "+alt_Name+"]";
	}
	
	/**
	 * Internal constructor to create a Record from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Record(JSONObject json_data) {
        try {// koi_list_flag
            this.koi_List_Flag = (String)json_data.get("koi_list_flag");// dec_err
            this.dec_Err = (Double)json_data.get("dec_err");// kepoi_name
            this.kepoi_Name = (String)json_data.get("kepoi_name");// kepler_name
            this.kepler_Name = (String)json_data.get("kepler_name");// tm_designation
            this.tm_Designation = (String)json_data.get("tm_designation");// ra_err
            this.ra_Err = (Double)json_data.get("ra_err");// last_update
            this.last_Update = (String)json_data.get("last_update");// ra
            this.ra = (Double)json_data.get("ra");// kepid
            this.kepid = new Integer(((Long)json_data.get("kepid")).intValue());// dec_str
            this.dec_Str = (String)json_data.get("dec_str");// dec
            this.dec = (Double)json_data.get("dec");// ra_str
            this.ra_Str = (String)json_data.get("ra_str");// alt_name
            this.alt_Name = (String)json_data.get("alt_name");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Record; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Record; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}