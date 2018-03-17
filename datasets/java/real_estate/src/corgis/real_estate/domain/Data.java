package corgis.real_estate.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.real_estate.domain.History;
import corgis.real_estate.domain.Disabilities;

/**
 * 
 */
public class Data {
	
    private String ownedOrLeased;
    private String date;
    private History history;
    private Integer parkingSpaces;
    private String type;
    private String status;
    private Disabilities disabilities;
    
    
    /**
     * 
     * @return String
     */
    public String getOwnedOrLeased() {
        return this.ownedOrLeased;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getDate() {
        return this.date;
    }
    
    
    
    /**
     * 
     * @return History
     */
    public History getHistory() {
        return this.history;
    }
    
    
    
    /**
     * 
     * @return Integer
     */
    public Integer getParkingSpaces() {
        return this.parkingSpaces;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getType() {
        return this.type;
    }
    
    
    
    /**
     * 
     * @return String
     */
    public String getStatus() {
        return this.status;
    }
    
    
    
    /**
     * 
     * @return Disabilities
     */
    public Disabilities getDisabilities() {
        return this.disabilities;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Data.
	
	 * @return String
	 */
	public String toString() {
		return "Data[" +ownedOrLeased+", "+date+", "+history+", "+parkingSpaces+", "+type+", "+status+", "+disabilities+"]";
	}
	
	/**
	 * Internal constructor to create a Data from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Data(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // owned or leased
            this.ownedOrLeased = (String)json_data.get("owned or leased");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field ownedOrLeased was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field ownedOrLeased had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // date
            this.date = (String)json_data.get("date");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field date was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field date had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // history
            this.history = new History((JSONObject)json_data.get("history"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field history was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field history had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // parking spaces
            this.parkingSpaces = ((Number)json_data.get("parking spaces")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field parkingSpaces was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field parkingSpaces had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // type
            this.type = (String)json_data.get("type");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field type was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field type had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // status
            this.status = (String)json_data.get("status");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field status was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field status had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // disabilities
            this.disabilities = new Disabilities((JSONObject)json_data.get("disabilities"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field disabilities was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field disabilities had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}