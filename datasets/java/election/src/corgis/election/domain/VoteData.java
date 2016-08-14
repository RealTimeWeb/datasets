package corgis.election.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.election.domain.RandPaul;
import corgis.election.domain.RickSantorum;
import corgis.election.domain.MartinOmalley;
import corgis.election.domain.NoPreference;
import corgis.election.domain.ChrisChristie;
import corgis.election.domain.JebBush;
import corgis.election.domain.HillaryClinton;
import corgis.election.domain.JohnKasich;
import corgis.election.domain.DonaldTrump;
import corgis.election.domain.Uncommitted;
import corgis.election.domain.MikeHuckabee;
import corgis.election.domain.MarcoRubio;
import corgis.election.domain.BernieSanders;
import corgis.election.domain.CarlyFiorina;
import corgis.election.domain.BenCarson;
import corgis.election.domain.TedCruz;

/**
 * 
 */
public class VoteData {
	
    private RandPaul randPaul;
    private RickSantorum rickSantorum;
    private MartinOmalley martinOmalley;
    private NoPreference noPreference;
    private ChrisChristie chrisChristie;
    private JebBush jebBush;
    private HillaryClinton hillaryClinton;
    private JohnKasich johnKasich;
    private DonaldTrump donaldTrump;
    private Uncommitted uncommitted;
    private MikeHuckabee mikeHuckabee;
    private MarcoRubio marcoRubio;
    private BernieSanders bernieSanders;
    private CarlyFiorina carlyFiorina;
    private BenCarson benCarson;
    private TedCruz tedCruz;
    
    
    /*
     * @return 
     */
    public RandPaul getRandPaul() {
        return this.randPaul;
    }
    
    
    
    /*
     * @return 
     */
    public RickSantorum getRickSantorum() {
        return this.rickSantorum;
    }
    
    
    
    /*
     * @return 
     */
    public MartinOmalley getMartinOmalley() {
        return this.martinOmalley;
    }
    
    
    
    /*
     * @return 
     */
    public NoPreference getNoPreference() {
        return this.noPreference;
    }
    
    
    
    /*
     * @return 
     */
    public ChrisChristie getChrisChristie() {
        return this.chrisChristie;
    }
    
    
    
    /*
     * @return 
     */
    public JebBush getJebBush() {
        return this.jebBush;
    }
    
    
    
    /*
     * @return 
     */
    public HillaryClinton getHillaryClinton() {
        return this.hillaryClinton;
    }
    
    
    
    /*
     * @return 
     */
    public JohnKasich getJohnKasich() {
        return this.johnKasich;
    }
    
    
    
    /*
     * @return 
     */
    public DonaldTrump getDonaldTrump() {
        return this.donaldTrump;
    }
    
    
    
    /*
     * @return 
     */
    public Uncommitted getUncommitted() {
        return this.uncommitted;
    }
    
    
    
    /*
     * @return 
     */
    public MikeHuckabee getMikeHuckabee() {
        return this.mikeHuckabee;
    }
    
    
    
    /*
     * @return 
     */
    public MarcoRubio getMarcoRubio() {
        return this.marcoRubio;
    }
    
    
    
    /*
     * @return 
     */
    public BernieSanders getBernieSanders() {
        return this.bernieSanders;
    }
    
    
    
    /*
     * @return 
     */
    public CarlyFiorina getCarlyFiorina() {
        return this.carlyFiorina;
    }
    
    
    
    /*
     * @return 
     */
    public BenCarson getBenCarson() {
        return this.benCarson;
    }
    
    
    
    /*
     * @return 
     */
    public TedCruz getTedCruz() {
        return this.tedCruz;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this VoteData.
	
	 * @return String
	 */
	public String toString() {
		return "VoteData[" +randPaul+", "+rickSantorum+", "+martinOmalley+", "+noPreference+", "+chrisChristie+", "+jebBush+", "+hillaryClinton+", "+johnKasich+", "+donaldTrump+", "+uncommitted+", "+mikeHuckabee+", "+marcoRubio+", "+bernieSanders+", "+carlyFiorina+", "+benCarson+", "+tedCruz+"]";
	}
	
	/**
	 * Internal constructor to create a VoteData from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public VoteData(JSONObject json_data) {
        try {// Rand Paul
            this.randPaul = new RandPaul((JSONObject)json_data.get("Rand Paul"));// Rick Santorum
            this.rickSantorum = new RickSantorum((JSONObject)json_data.get("Rick Santorum"));// Martin O'Malley
            this.martinOmalley = new MartinOmalley((JSONObject)json_data.get("Martin O'Malley"));// No Preference
            this.noPreference = new NoPreference((JSONObject)json_data.get("No Preference"));// Chris Christie
            this.chrisChristie = new ChrisChristie((JSONObject)json_data.get("Chris Christie"));// Jeb Bush
            this.jebBush = new JebBush((JSONObject)json_data.get("Jeb Bush"));// Hillary Clinton
            this.hillaryClinton = new HillaryClinton((JSONObject)json_data.get("Hillary Clinton"));// John Kasich
            this.johnKasich = new JohnKasich((JSONObject)json_data.get("John Kasich"));// Donald Trump
            this.donaldTrump = new DonaldTrump((JSONObject)json_data.get("Donald Trump"));// Uncommitted
            this.uncommitted = new Uncommitted((JSONObject)json_data.get("Uncommitted"));// Mike Huckabee
            this.mikeHuckabee = new MikeHuckabee((JSONObject)json_data.get("Mike Huckabee"));// Marco Rubio
            this.marcoRubio = new MarcoRubio((JSONObject)json_data.get("Marco Rubio"));// Bernie Sanders
            this.bernieSanders = new BernieSanders((JSONObject)json_data.get("Bernie Sanders"));// Carly Fiorina
            this.carlyFiorina = new CarlyFiorina((JSONObject)json_data.get("Carly Fiorina"));// Ben Carson
            this.benCarson = new BenCarson((JSONObject)json_data.get("Ben Carson"));// Ted Cruz
            this.tedCruz = new TedCruz((JSONObject)json_data.get("Ted Cruz"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a VoteData; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a VoteData; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}