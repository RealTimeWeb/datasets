package corgis.drug_bank.domain;

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
public class Proteins {
	
    private String category;
    private String entrezGeneId;
    private ArrayList<String> pubmedIds;
    private ArrayList<String> actions;
    private String knownAction;
    private String organism;
    private String uniprotId;
    
    
    /*
     * @return 
     */
    public String getCategory() {
        return this.category;
    }
    
    
    
    /*
     * @return 
     */
    public String getEntrezGeneId() {
        return this.entrezGeneId;
    }
    
    
    
    /*
     * @return 
     */
    public ArrayList<String> getPubmedIds() {
        return this.pubmedIds;
    }
    
    
    
    /*
     * @return 
     */
    public ArrayList<String> getActions() {
        return this.actions;
    }
    
    
    
    /*
     * @return 
     */
    public String getKnownAction() {
        return this.knownAction;
    }
    
    
    
    /*
     * @return 
     */
    public String getOrganism() {
        return this.organism;
    }
    
    
    
    /*
     * @return 
     */
    public String getUniprotId() {
        return this.uniprotId;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Proteins.
	
	 * @return String
	 */
	public String toString() {
		return "Proteins[" +category+", "+entrezGeneId+", "+pubmedIds+", "+actions+", "+knownAction+", "+organism+", "+uniprotId+"]";
	}
	
	/**
	 * Internal constructor to create a Proteins from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Proteins(JSONObject json_data) {
        try {// category
            this.category = (String)json_data.get("category");// entrez gene id
            this.entrezGeneId = (String)json_data.get("entrez gene id");// pubmed ids
            this.pubmedIds = new ArrayList<String>();
            Iterator<Object> pubmedIdsIter = ((List<Object>)json_data.get("pubmed ids")).iterator();
            while (pubmedIdsIter.hasNext()) {
                this.pubmedIds.add(new String((String)pubmedIdsIter.next()));
            }// actions
            this.actions = new ArrayList<String>();
            Iterator<Object> actionsIter = ((List<Object>)json_data.get("actions")).iterator();
            while (actionsIter.hasNext()) {
                this.actions.add(new String((String)actionsIter.next()));
            }// known action
            this.knownAction = (String)json_data.get("known action");// organism
            this.organism = (String)json_data.get("organism");// uniprot id
            this.uniprotId = (String)json_data.get("uniprot id");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Proteins; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Proteins; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}