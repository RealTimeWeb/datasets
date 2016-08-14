package corgis.kepler;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import corgis.kepler.domain.*;

import java.sql.*;

/**
 * {'overview': 'The NASA Exoplanet Archive is an online astronomical exoplanet and stellar catalog and data service that collates and cross-correlates astronomical data and information on exoplanets and their host stars and provides tools to work with these data. The Exoplanet Archive is dedicated to collecting and serving important public data sets involved in the search for and characterization of extrasolar planets and their host stars. The data include stellar parameters (such as positions, magnitudes, and temperatures), exoplanet parameters (such as masses and orbital parameters) and discovery/characterization data (such as published radial velocity curves, photometric light curves, images, and spectra).\n', 'short': 'The dataset has records about astronomical data and information on exoplanets and their host stars.'}
 */
public class KeplerLibrary {
    private String databasePath;
	private Connection connection;
    private JSONParser parser;
    private final int HARDWARE = 1000;
    
    public static void main(String[] args) {
        System.out.println("Testing Kepler");
        KeplerLibrary keplerLibrary = new KeplerLibrary();
        
        
        System.out.println("Testing production GetExoplanets");
        ArrayList<Exoplanet> list_of_exoplanet_1_production = keplerLibrary.getExoplanets(false);
        
        
        System.out.println("Testing test GetExoplanets");
        ArrayList<Exoplanet> list_of_exoplanet_1_test = keplerLibrary.getExoplanets(true);
        
        
        
        System.out.println("Testing production GetNameById");
        Record a_record_2_production = keplerLibrary.getNameById("\"11446443\"");
        
        
        
        
        System.out.println("Testing production GetObjectsOfInterest");
        ArrayList<Koi> list_of_koi_3_production = keplerLibrary.getObjectsOfInterest(false);
        
        
        System.out.println("Testing test GetObjectsOfInterest");
        ArrayList<Koi> list_of_koi_3_test = keplerLibrary.getObjectsOfInterest(true);
        
        
        
        System.out.println("Testing production GetStellar");
        ArrayList<Stellar> list_of_stellar_4_production = keplerLibrary.getStellar(false);
        
        
        System.out.println("Testing test GetStellar");
        ArrayList<Stellar> list_of_stellar_4_test = keplerLibrary.getStellar(true);
        
        
        
        System.out.println("Testing production GetThresholdCrossingEvents");
        ArrayList<Tce> list_of_tce_5_production = keplerLibrary.getThresholdCrossingEvents(false);
        
        
        System.out.println("Testing test GetThresholdCrossingEvents");
        ArrayList<Tce> list_of_tce_5_test = keplerLibrary.getThresholdCrossingEvents(true);
        
        
    }
    
    private void connectToDatabase(String databasePath) {
        this.connection = null;
        try {
            this.connection = DriverManager.getConnection("jdbc:sqlite:"+databasePath);
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        this.parser =  new JSONParser();
    }
	
    /**
     * Create a connection to the database file in its standard position.
     */
	public KeplerLibrary() {
        this.databasePath = "kepler.db";
        this.connectToDatabase(this.databasePath);
	}
	
    /**
     * Create a connection to the database file, stored explicitly somewhere.
     * @param databasePath The filename of the database file.
     */
	public KeplerLibrary(String databasePath) {
        this.databasePath = databasePath;
        this.connectToDatabase(this.databasePath);
	}
    
    
    
    /**
     * Returns information about Exoplanets discovered by Kepler. An exoplanet or extrasolar planet is a planet that orbits a star other than the Sun.
    
     * @return a list[exoplanet]
     */
	public ArrayList<Exoplanet> getExoplanets() {
        return this.getExoplanets(true);
    }
    
    
    /**
     * Returns information about Exoplanets discovered by Kepler. An exoplanet or extrasolar planet is a planet that orbits a star other than the Sun.
    
     * @return a list[exoplanet]
     */
	public ArrayList<Exoplanet> getExoplanets(boolean test) {
        String query;
        if (test) {
            query = String.format("SELECT data FROM exoplanets LIMIT %d", this.HARDWARE);
        } else {
            query = "SELECT data FROM exoplanets";
        }
        PreparedStatement preparedQuery = null;
        ResultSet rs = null;
        try {
            preparedQuery = this.connection.prepareStatement(query);
        } catch (SQLException e) {
            System.err.println("Could not build SQL query for local database.");
    		e.printStackTrace();
        }
        try {
            rs = preparedQuery.executeQuery();
        } catch (SQLException e) {
            System.err.println("Could not execute query.");
    		e.printStackTrace();
        }
        
        ArrayList<Exoplanet> result = new ArrayList<Exoplanet>();
        try {
            while (rs.next()) {
                String raw_result = rs.getString(1);
                Exoplanet parsed = null;
                if (test) {
                    parsed = new Exoplanet((JSONObject)this.parser.parse(raw_result));
                    
                } else {
                    parsed = new Exoplanet((JSONObject)this.parser.parse(raw_result));
                    
                }
                
                result.add(parsed);
                
            }
        } catch (SQLException e) {
            System.err.println("Could not iterate through query.");
    		e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Could not convert the response from getExoplanets; a parser error occurred.");
    		e.printStackTrace();
        }
        return result;
	}
    
    
    
    /**
     * Returns information about the name of a given target.
    
     * @param kepid Target identification number, as listed elsewhere in the data.
     * @return a record
     */
	public Record getNameById(String kepid) {
        String query;
        boolean test = false;
        if (test) {
            query = String.format("", this.HARDWARE);
        } else {
            query = "SELECT data FROM keplernames WHERE kepid=?";
        }
        PreparedStatement preparedQuery = null;
        ResultSet rs = null;
        try {
            preparedQuery = this.connection.prepareStatement(query);
        } catch (SQLException e) {
            System.err.println("Could not build SQL query for local database.");
    		e.printStackTrace();
        }
        try {
            preparedQuery.setString(1, kepid);
        } catch (SQLException e) {
            System.err.println("Could not build prepare argument: kepid");
    		e.printStackTrace();
        }
        try {
            rs = preparedQuery.executeQuery();
        } catch (SQLException e) {
            System.err.println("Could not execute query.");
    		e.printStackTrace();
        }
        
        Record result = null;
        try {
            while (rs.next()) {
                String raw_result = rs.getString(1);
                Record parsed = null;
                if (test) {
                    
                } else {
                    parsed = new Exoplanet((JSONObject)this.parser.parse(raw_result));
                    
                }
                
                result = parsed;
                
            }
        } catch (SQLException e) {
            System.err.println("Could not iterate through query.");
    		e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Could not convert the response from getNameById; a parser error occurred.");
    		e.printStackTrace();
        }
        return result;
	}
    
    
    /**
     * Returns the Kepler Objects of Interests (KOI), targets identified by the Kepler Project that displays at least one transit-like sequence within Kepler time-series photometry that appears to be of astrophysical origin and initially consistent with a planetary transit hypothesis.
    
     * @return a list[koi]
     */
	public ArrayList<Koi> getObjectsOfInterest() {
        return this.getObjectsOfInterest(true);
    }
    
    
    /**
     * Returns the Kepler Objects of Interests (KOI), targets identified by the Kepler Project that displays at least one transit-like sequence within Kepler time-series photometry that appears to be of astrophysical origin and initially consistent with a planetary transit hypothesis.
    
     * @return a list[koi]
     */
	public ArrayList<Koi> getObjectsOfInterest(boolean test) {
        String query;
        if (test) {
            query = String.format("SELECT data FROM koicumulative LIMIT %d", this.HARDWARE);
        } else {
            query = "SELECT data FROM koicumulative";
        }
        PreparedStatement preparedQuery = null;
        ResultSet rs = null;
        try {
            preparedQuery = this.connection.prepareStatement(query);
        } catch (SQLException e) {
            System.err.println("Could not build SQL query for local database.");
    		e.printStackTrace();
        }
        try {
            rs = preparedQuery.executeQuery();
        } catch (SQLException e) {
            System.err.println("Could not execute query.");
    		e.printStackTrace();
        }
        
        ArrayList<Koi> result = new ArrayList<Koi>();
        try {
            while (rs.next()) {
                String raw_result = rs.getString(1);
                Koi parsed = null;
                if (test) {
                    parsed = new Exoplanet((JSONObject)this.parser.parse(raw_result));
                    
                } else {
                    parsed = new Exoplanet((JSONObject)this.parser.parse(raw_result));
                    
                }
                
                result.add(parsed);
                
            }
        } catch (SQLException e) {
            System.err.println("Could not iterate through query.");
    		e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Could not convert the response from getObjectsOfInterest; a parser error occurred.");
    		e.printStackTrace();
        }
        return result;
	}
    
    
    /**
     * Returns stellar information about various objects of interest.
    
     * @return a list[stellar]
     */
	public ArrayList<Stellar> getStellar() {
        return this.getStellar(true);
    }
    
    
    /**
     * Returns stellar information about various objects of interest.
    
     * @return a list[stellar]
     */
	public ArrayList<Stellar> getStellar(boolean test) {
        String query;
        if (test) {
            query = String.format("SELECT data FROM stellartable LIMIT %d", this.HARDWARE);
        } else {
            query = "SELECT data FROM stellartable";
        }
        PreparedStatement preparedQuery = null;
        ResultSet rs = null;
        try {
            preparedQuery = this.connection.prepareStatement(query);
        } catch (SQLException e) {
            System.err.println("Could not build SQL query for local database.");
    		e.printStackTrace();
        }
        try {
            rs = preparedQuery.executeQuery();
        } catch (SQLException e) {
            System.err.println("Could not execute query.");
    		e.printStackTrace();
        }
        
        ArrayList<Stellar> result = new ArrayList<Stellar>();
        try {
            while (rs.next()) {
                String raw_result = rs.getString(1);
                Stellar parsed = null;
                if (test) {
                    parsed = new Exoplanet((JSONObject)this.parser.parse(raw_result));
                    
                } else {
                    parsed = new Exoplanet((JSONObject)this.parser.parse(raw_result));
                    
                }
                
                result.add(parsed);
                
            }
        } catch (SQLException e) {
            System.err.println("Could not iterate through query.");
    		e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Could not convert the response from getStellar; a parser error occurred.");
    		e.printStackTrace();
        }
        return result;
	}
    
    
    /**
     * Returns information about Threshold Crossing Events (TCE), sequences of transit-like features in the flux time series of a given target that resembles the signature of a transiting planet to a sufficient degree that the target is passed on for further analysis.
    
     * @return a list[tce]
     */
	public ArrayList<Tce> getThresholdCrossingEvents() {
        return this.getThresholdCrossingEvents(true);
    }
    
    
    /**
     * Returns information about Threshold Crossing Events (TCE), sequences of transit-like features in the flux time series of a given target that resembles the signature of a transiting planet to a sufficient degree that the target is passed on for further analysis.
    
     * @return a list[tce]
     */
	public ArrayList<Tce> getThresholdCrossingEvents(boolean test) {
        String query;
        if (test) {
            query = String.format("SELECT data FROM tce LIMIT %d", this.HARDWARE);
        } else {
            query = "SELECT data FROM tce";
        }
        PreparedStatement preparedQuery = null;
        ResultSet rs = null;
        try {
            preparedQuery = this.connection.prepareStatement(query);
        } catch (SQLException e) {
            System.err.println("Could not build SQL query for local database.");
    		e.printStackTrace();
        }
        try {
            rs = preparedQuery.executeQuery();
        } catch (SQLException e) {
            System.err.println("Could not execute query.");
    		e.printStackTrace();
        }
        
        ArrayList<Tce> result = new ArrayList<Tce>();
        try {
            while (rs.next()) {
                String raw_result = rs.getString(1);
                Tce parsed = null;
                if (test) {
                    parsed = new Exoplanet((JSONObject)this.parser.parse(raw_result));
                    
                } else {
                    parsed = new Exoplanet((JSONObject)this.parser.parse(raw_result));
                    
                }
                
                result.add(parsed);
                
            }
        } catch (SQLException e) {
            System.err.println("Could not iterate through query.");
    		e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Could not convert the response from getThresholdCrossingEvents; a parser error occurred.");
    		e.printStackTrace();
        }
        return result;
	}
    
}