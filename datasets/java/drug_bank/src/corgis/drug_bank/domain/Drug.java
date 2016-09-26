package corgis.drug_bank.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.drug_bank.domain.Properties;

/**
 * 
 */
public class Drug {
	
    private String inchikey;
    private String name;
    private ArrayList<Proteins> proteins;
    private Properties properties;
    private ArrayList<String> atcCodes;
    private ArrayList<String> groups;
    private String inchi;
    private String type;
    private String id;
    private ArrayList<String> categories;
    
    
    /*
     * @return 
     */
    public String getInchikey() {
        return this.inchikey;
    }
    
    
    
    /*
     * @return 
     */
    public String getName() {
        return this.name;
    }
    
    
    
    /*
     * @return 
     */
    public ArrayList<Proteins> getProteins() {
        return this.proteins;
    }
    
    
    
    /*
     * @return 
     */
    public Properties getProperties() {
        return this.properties;
    }
    
    
    
    /*
     * @return 
     */
    public ArrayList<String> getAtcCodes() {
        return this.atcCodes;
    }
    
    
    
    /*
     * @return 
     */
    public ArrayList<String> getGroups() {
        return this.groups;
    }
    
    
    
    /*
     * @return 
     */
    public String getInchi() {
        return this.inchi;
    }
    
    
    
    /*
     * @return 
     */
    public String getType() {
        return this.type;
    }
    
    
    
    /*
     * @return 
     */
    public String getId() {
        return this.id;
    }
    
    
    
    /*
     * @return 
     */
    public ArrayList<String> getCategories() {
        return this.categories;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Drug.
	
	 * @return String
	 */
	public String toString() {
		return "Drug[" +inchikey+", "+name+", "+proteins+", "+properties+", "+atcCodes+", "+groups+", "+inchi+", "+type+", "+id+", "+categories+"]";
	}
	
	/**
	 * Internal constructor to create a Drug from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Drug(JSONObject json_data) {
        try {// inchikey
            this.inchikey = (String)json_data.get("inchikey");// name
            this.name = (String)json_data.get("name");// proteins
            this.proteins = new ArrayList<Proteins>();
            Iterator<Object> proteinsIter = ((List<Object>)json_data.get("proteins")).iterator();
            while (proteinsIter.hasNext()) {
                this.proteins.add(new Proteins((JSONObject)proteinsIter.next()));
            }// properties
            this.properties = new Properties((JSONObject)json_data.get("properties"));// atc codes
            this.atcCodes = new ArrayList<String>();
            Iterator<Object> atcCodesIter = ((List<Object>)json_data.get("atc codes")).iterator();
            while (atcCodesIter.hasNext()) {
                this.atcCodes.add(new String((String)atcCodesIter.next()));
            }// groups
            this.groups = new ArrayList<String>();
            Iterator<Object> groupsIter = ((List<Object>)json_data.get("groups")).iterator();
            while (groupsIter.hasNext()) {
                this.groups.add(new String((String)groupsIter.next()));
            }// inchi
            this.inchi = (String)json_data.get("inchi");// type
            this.type = (String)json_data.get("type");// id
            this.id = (String)json_data.get("id");// categories
            this.categories = new ArrayList<String>();
            Iterator<Object> categoriesIter = ((List<Object>)json_data.get("categories")).iterator();
            while (categoriesIter.hasNext()) {
                this.categories.add(new String((String)categoriesIter.next()));
            }
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Drug; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Drug; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}