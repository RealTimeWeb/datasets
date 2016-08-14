package corgis.artinstitutemetadata.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.artinstitutemetadata.domain.ArtistInfo;
import corgis.artinstitutemetadata.domain.InstituteInfo;
import corgis.artinstitutemetadata.domain.Description;

/**
 * 
 */
public class Record {
	
    private ArtistInfo artistInfo;
    private String title;
    private InstituteInfo instituteInfo;
    private Description description;
    
    
    /*
     * @return 
     */
    public ArtistInfo getArtistInfo() {
        return this.artistInfo;
    }
    
    
    
    /*
     * @return 
     */
    public String getTitle() {
        return this.title;
    }
    
    
    
    /*
     * @return 
     */
    public InstituteInfo getInstituteInfo() {
        return this.instituteInfo;
    }
    
    
    
    /*
     * @return 
     */
    public Description getDescription() {
        return this.description;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Record.
	
	 * @return String
	 */
	public String toString() {
		return "Record[" +artistInfo+", "+title+", "+instituteInfo+", "+description+"]";
	}
	
	/**
	 * Internal constructor to create a Record from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Record(JSONObject json_data) {
        try {// Artist Info
            this.artistInfo = new ArtistInfo((JSONObject)json_data.get("Artist Info"));// Title
            this.title = (String)json_data.get("Title");// Institute Info
            this.instituteInfo = new InstituteInfo((JSONObject)json_data.get("Institute Info"));// Description
            this.description = new Description((JSONObject)json_data.get("Description"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Record; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Record; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}