package corgis.drugs.domain;

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
public class NeedTreatmentPastYear {
	
    // Percentage of the population that needs but has not received treatment for illicit drugs in the past year among this age group. Needing But Not Receiving Treatment refers to respondents classified as needing treatment for illicit drugs, but not receiving treatment for an illicit drug problem at a specialty facility (i.e., drug and alcohol rehabilitation facilities [inpatient or outpatient], hospitals [inpatient only], and mental health centers). Illicit Drugs include marijuana/hashish, cocaine (including crack), inhalants, hallucinogens, heroin, or prescription-type psychotherapeutics used nonmedically.
    private Double twosixplus;
    // Percentage of the population that needs but has not received treatment for illicit drugs in the past year among this age group. Needing But Not Receiving Treatment refers to respondents classified as needing treatment for illicit drugs, but not receiving treatment for an illicit drug problem at a specialty facility (i.e., drug and alcohol rehabilitation facilities [inpatient or outpatient], hospitals [inpatient only], and mental health centers). Illicit Drugs include marijuana/hashish, cocaine (including crack), inhalants, hallucinogens, heroin, or prescription-type psychotherapeutics used nonmedically.
    private Double oneeightTwofive;
    // Percentage of the population that needs but has not received treatment for illicit drugs in the past year among this age group. Needing But Not Receiving Treatment refers to respondents classified as needing treatment for illicit drugs, but not receiving treatment for an illicit drug problem at a specialty facility (i.e., drug and alcohol rehabilitation facilities [inpatient or outpatient], hospitals [inpatient only], and mental health centers). Illicit Drugs include marijuana/hashish, cocaine (including crack), inhalants, hallucinogens, heroin, or prescription-type psychotherapeutics used nonmedically.
    private Double onetwoOneseven;
    
    
    /*
     * @return 
     */
    public Double getTwosixplus() {
        return this.twosixplus;
    }
    
    
    
    /*
     * @return 
     */
    public Double getOneeightTwofive() {
        return this.oneeightTwofive;
    }
    
    
    
    /*
     * @return 
     */
    public Double getOnetwoOneseven() {
        return this.onetwoOneseven;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this NeedTreatmentPastYear.
	
	 * @return String
	 */
	public String toString() {
		return "NeedTreatmentPastYear[" +twosixplus+", "+oneeightTwofive+", "+onetwoOneseven+"]";
	}
	
	/**
	 * Internal constructor to create a NeedTreatmentPastYear from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public NeedTreatmentPastYear(JSONObject json_data) {
        try {// 26+
            this.twosixplus = ((Number)json_data.get("26+")).doubleValue();// 18-25
            this.oneeightTwofive = ((Number)json_data.get("18-25")).doubleValue();// 12-17
            this.onetwoOneseven = ((Number)json_data.get("12-17")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a NeedTreatmentPastYear; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a NeedTreatmentPastYear; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}