package corgis.businesses;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import corgis.businesses.domain.*;

import java.sql.*;

/**
 * {'overview': "Yelp is providing all the data and reviews of the 250 closest businesses for 30 universities for students and academics to explore and research\nYelp's dataset includes information for businesses near these 30 schools: Brown University, California Institute of Technology, California Polytechnic State University, Carnegie Mellon University, Columbia University, Cornell University, Georgia Institute of Technology, Harvard University, Harvey Mudd College, Massachusetts Institute of Technology, Princeton University, Purdue University, Rensselaer Polytechnic Institute, Rice University, Stanford University, University of California - Los Angeles, University of California - San Diego, University of California at Berkeley, University of Illinois - Urbana-Champaign, University of Maryland - College Park, University of Massachusetts - Amherst, University of Michigan - Ann Arbor, University of North Carolina - Chapel Hill, University of Pennsylvania, University of Southern California, University of Texas - Austin, University of Washington, University of Waterloo, University of Wisconsin - Madison, and Virginia Tech.\n", 'short': 'Information about businesses around college cities, provided by Yelp.', 'citation': 'https://www.yelp.com/academic_dataset'}
 */
public class BusinessesLibrary {
    private String databasePath;
	private Connection connection;
    private JSONParser parser;
    private final int HARDWARE = 1000;
    
    public static void main(String[] args) {
        System.out.println("Testing Businesses");
        BusinessesLibrary businessesLibrary = new BusinessesLibrary();
        
        
        System.out.println("Testing production GetBusinessesByCity");
        ArrayList<Business> list_of_business_1_production = businessesLibrary.getBusinessesByCity("'blacksburg'", false);
        
        
        System.out.println("Testing test GetBusinessesByCity");
        ArrayList<Business> list_of_business_1_test = businessesLibrary.getBusinessesByCity("'blacksburg'", true);
        
        
        
        System.out.println("Testing production GetBusinessByName");
        ArrayList<Business> list_of_business_2_production = businessesLibrary.getBusinessByName("'subway'", false);
        
        
        System.out.println("Testing test GetBusinessByName");
        ArrayList<Business> list_of_business_2_test = businessesLibrary.getBusinessByName("'subway'", true);
        
        
        
        System.out.println("Testing production GetAllBusinesses");
        ArrayList<Business> list_of_business_3_production = businessesLibrary.getAllBusinesses(false);
        
        
        System.out.println("Testing test GetAllBusinesses");
        ArrayList<Business> list_of_business_3_test = businessesLibrary.getAllBusinesses(true);
        
        
        
        System.out.println("Testing production GetUserById");
        User a_user_4_production = businessesLibrary.getUserById("'UqNSytSc3hiYfKVCGwvLCg'");
        
        
        
        
        System.out.println("Testing production GetUsers");
        ArrayList<User> list_of_user_5_production = businessesLibrary.getUsers(false);
        
        
        System.out.println("Testing test GetUsers");
        ArrayList<User> list_of_user_5_test = businessesLibrary.getUsers(true);
        
        
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
	public BusinessesLibrary() {
        this.databasePath = "businesses.db";
        this.connectToDatabase(this.databasePath);
	}
	
    /**
     * Create a connection to the database file, stored explicitly somewhere.
     * @param databasePath The filename of the database file.
     */
	public BusinessesLibrary(String databasePath) {
        this.databasePath = databasePath;
        this.connectToDatabase(this.databasePath);
	}
    
    
    
    /**
     * Returns all the businesses in the given city.
    
     * @param city The name of the city.
     * @return a list[business]
     */
	public ArrayList<Business> getBusinessesByCity(String city) {
        return this.getBusinessesByCity(city, true);
    }
    
    
    /**
     * Returns all the businesses in the given city.
    
     * @param city The name of the city.
     * @return a list[business]
     */
	public ArrayList<Business> getBusinessesByCity(String city, boolean test) {
        String query;
        if (test) {
            query = String.format("SELECT data FROM businesses WHERE city=? COLLATE NOCASE LIMIT %d", this.HARDWARE);
        } else {
            query = "SELECT data FROM businesses WHERE city=? COLLATE NOCASE";
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
            preparedQuery.setString(1, city);
        } catch (SQLException e) {
            System.err.println("Could not build prepare argument: city");
    		e.printStackTrace();
        }
        try {
            rs = preparedQuery.executeQuery();
        } catch (SQLException e) {
            System.err.println("Could not execute query.");
    		e.printStackTrace();
        }
        
        ArrayList<Business> result = new ArrayList<Business>();
        try {
            while (rs.next()) {
                String raw_result = rs.getString(1);
                Business parsed = null;
                if (test) {
                    parsed = new Business((JSONObject)this.parser.parse(raw_result));
                    
                } else {
                    parsed = new Business((JSONObject)this.parser.parse(raw_result));
                    
                }
                
                result.add(parsed);
                
            }
        } catch (SQLException e) {
            System.err.println("Could not iterate through query.");
    		e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Could not convert the response from getBusinessesByCity; a parser error occurred.");
    		e.printStackTrace();
        }
        return result;
	}
    
    
    /**
     * Returns all the businesses with the given name (matches fuzzily, so 'subway' would match 'Subway' and 'The subway').
    
     * @param name The name of the business. It can be part of the name instead of the entire name.
     * @return a list[business]
     */
	public ArrayList<Business> getBusinessByName(String name) {
        return this.getBusinessByName(name, true);
    }
    
    
    /**
     * Returns all the businesses with the given name (matches fuzzily, so 'subway' would match 'Subway' and 'The subway').
    
     * @param name The name of the business. It can be part of the name instead of the entire name.
     * @return a list[business]
     */
	public ArrayList<Business> getBusinessByName(String name, boolean test) {
        String query;
        if (test) {
            query = String.format("SELECT data FROM businesses WHERE name LIKE ('%' || ? || '%') COLLATE NOCASE LIMIT %d", this.HARDWARE);
        } else {
            query = "SELECT data FROM businesses WHERE name LIKE ('%' || ? || '%') COLLATE NOCASE";
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
            preparedQuery.setString(1, name);
        } catch (SQLException e) {
            System.err.println("Could not build prepare argument: name");
    		e.printStackTrace();
        }
        try {
            rs = preparedQuery.executeQuery();
        } catch (SQLException e) {
            System.err.println("Could not execute query.");
    		e.printStackTrace();
        }
        
        ArrayList<Business> result = new ArrayList<Business>();
        try {
            while (rs.next()) {
                String raw_result = rs.getString(1);
                Business parsed = null;
                if (test) {
                    parsed = new Business((JSONObject)this.parser.parse(raw_result));
                    
                } else {
                    parsed = new Business((JSONObject)this.parser.parse(raw_result));
                    
                }
                
                result.add(parsed);
                
            }
        } catch (SQLException e) {
            System.err.println("Could not iterate through query.");
    		e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Could not convert the response from getBusinessByName; a parser error occurred.");
    		e.printStackTrace();
        }
        return result;
	}
    
    
    /**
     * Returns all the businesses in the database.
    
     * @return a list[business]
     */
	public ArrayList<Business> getAllBusinesses() {
        return this.getAllBusinesses(true);
    }
    
    
    /**
     * Returns all the businesses in the database.
    
     * @return a list[business]
     */
	public ArrayList<Business> getAllBusinesses(boolean test) {
        String query;
        if (test) {
            query = String.format("SELECT data FROM businesses LIMIT %d", this.HARDWARE);
        } else {
            query = "SELECT data FROM businesses";
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
        
        ArrayList<Business> result = new ArrayList<Business>();
        try {
            while (rs.next()) {
                String raw_result = rs.getString(1);
                Business parsed = null;
                if (test) {
                    parsed = new Business((JSONObject)this.parser.parse(raw_result));
                    
                } else {
                    parsed = new Business((JSONObject)this.parser.parse(raw_result));
                    
                }
                
                result.add(parsed);
                
            }
        } catch (SQLException e) {
            System.err.println("Could not iterate through query.");
    		e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Could not convert the response from getAllBusinesses; a parser error occurred.");
    		e.printStackTrace();
        }
        return result;
	}
    
    
    
    /**
     * Returns the information for a given user by their ID
    
     * @param userId A unique user id, given by the reviews of a business.
     * @return a user
     */
	public User getUserById(String userId) {
        String query;
        boolean test = false;
        if (test) {
            query = String.format("", this.HARDWARE);
        } else {
            query = "SELECT data FROM users WHERE uid=? LIMIT 1";
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
            preparedQuery.setString(1, userId);
        } catch (SQLException e) {
            System.err.println("Could not build prepare argument: user id");
    		e.printStackTrace();
        }
        try {
            rs = preparedQuery.executeQuery();
        } catch (SQLException e) {
            System.err.println("Could not execute query.");
    		e.printStackTrace();
        }
        
        User result = null;
        try {
            while (rs.next()) {
                String raw_result = rs.getString(1);
                User parsed = null;
                if (test) {
                    
                } else {
                    parsed = new Business((JSONObject)this.parser.parse(raw_result));
                    
                }
                
                result = parsed;
                
            }
        } catch (SQLException e) {
            System.err.println("Could not iterate through query.");
    		e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Could not convert the response from getUserById; a parser error occurred.");
    		e.printStackTrace();
        }
        return result;
	}
    
    
    /**
     * Returns all of the users in the database.
    
     * @return a list[user]
     */
	public ArrayList<User> getUsers() {
        return this.getUsers(true);
    }
    
    
    /**
     * Returns all of the users in the database.
    
     * @return a list[user]
     */
	public ArrayList<User> getUsers(boolean test) {
        String query;
        if (test) {
            query = String.format("SELECT data FROM users LIMIT %d", this.HARDWARE);
        } else {
            query = "SELECT data FROM users";
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
        
        ArrayList<User> result = new ArrayList<User>();
        try {
            while (rs.next()) {
                String raw_result = rs.getString(1);
                User parsed = null;
                if (test) {
                    parsed = new Business((JSONObject)this.parser.parse(raw_result));
                    
                } else {
                    parsed = new Business((JSONObject)this.parser.parse(raw_result));
                    
                }
                
                result.add(parsed);
                
            }
        } catch (SQLException e) {
            System.err.println("Could not iterate through query.");
    		e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Could not convert the response from getUsers; a parser error occurred.");
    		e.printStackTrace();
        }
        return result;
	}
    
}