package corgis.cars;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import corgis.cars.domain.*;

import java.sql.*;

/**
 * {'overview': 'This is a dataset about cars and how much fuel they use.\n', 'short': 'This is a dataset about cars and how much fuel they use.\n'}
 */
public class CarsLibrary {
    private String databasePath;
	private Connection connection;
    private JSONParser parser;
    private final int HARDWARE = 1000;
    
    public static void main(String[] args) {
        System.out.println("Testing Cars");
        CarsLibrary carsLibrary = new CarsLibrary();
        
        
        System.out.println("Testing production GetCars");
        ArrayList<Car> list_of_car_1_production = carsLibrary.getCars(false);
        
        
        System.out.println("Testing test GetCars");
        ArrayList<Car> list_of_car_1_test = carsLibrary.getCars(true);
        
        
        
        System.out.println("Testing production GetCarsByYear");
        ArrayList<Car> list_of_car_2_production = carsLibrary.getCarsByYear("2001", false);
        
        
        System.out.println("Testing test GetCarsByYear");
        ArrayList<Car> list_of_car_2_test = carsLibrary.getCarsByYear("2001", true);
        
        
        
        System.out.println("Testing production GetCarsByMake");
        ArrayList<Car> list_of_car_3_production = carsLibrary.getCarsByMake("'Pontiac'", false);
        
        
        System.out.println("Testing test GetCarsByMake");
        ArrayList<Car> list_of_car_3_test = carsLibrary.getCarsByMake("'Pontiac'", true);
        
        
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
	public CarsLibrary() {
        this.databasePath = "cars.db";
        this.connectToDatabase(this.databasePath);
	}
	
    /**
     * Create a connection to the database file, stored explicitly somewhere.
     * @param databasePath The filename of the database file.
     */
	public CarsLibrary(String databasePath) {
        this.databasePath = databasePath;
        this.connectToDatabase(this.databasePath);
	}
    
    
    
    /**
     * Returns the complete list of cars.
    
     * @return a list[car]
     */
	public ArrayList<Car> getCars() {
        return this.getCars(true);
    }
    
    
    /**
     * Returns the complete list of cars.
    
     * @return a list[car]
     */
	public ArrayList<Car> getCars(boolean test) {
        String query;
        if (test) {
            query = String.format("SELECT data FROM cars LIMIT %d", this.HARDWARE);
        } else {
            query = "SELECT data FROM cars";
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
        
        ArrayList<Car> result = new ArrayList<Car>();
        try {
            while (rs.next()) {
                String raw_result = rs.getString(1);
                Car parsed = null;
                if (test) {
                    parsed = new Car((JSONObject)this.parser.parse(raw_result));
                    
                } else {
                    parsed = new Car((JSONObject)this.parser.parse(raw_result));
                    
                }
                
                result.add(parsed);
                
            }
        } catch (SQLException e) {
            System.err.println("Could not iterate through query.");
    		e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Could not convert the response from getCars; a parser error occurred.");
    		e.printStackTrace();
        }
        return result;
	}
    
    
    /**
     * Returns all the cars for a given year.
    
     * @param year The year as an integer, between 1921 and 2013.
     * @return a list[car]
     */
	public ArrayList<Car> getCarsByYear(Integer year) {
        return this.getCarsByYear(year, true);
    }
    
    
    /**
     * Returns all the cars for a given year.
    
     * @param year The year as an integer, between 1921 and 2013.
     * @return a list[car]
     */
	public ArrayList<Car> getCarsByYear(Integer year, boolean test) {
        String query;
        if (test) {
            query = String.format("SELECT data FROM cars WHERE year=? LIMIT %d", this.HARDWARE);
        } else {
            query = "SELECT data FROM cars WHERE year=?";
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
            preparedQuery.setInt(1, year);
        } catch (SQLException e) {
            System.err.println("Could not build prepare argument: year");
    		e.printStackTrace();
        }
        try {
            rs = preparedQuery.executeQuery();
        } catch (SQLException e) {
            System.err.println("Could not execute query.");
    		e.printStackTrace();
        }
        
        ArrayList<Car> result = new ArrayList<Car>();
        try {
            while (rs.next()) {
                String raw_result = rs.getString(1);
                Car parsed = null;
                if (test) {
                    parsed = new Car((JSONObject)this.parser.parse(raw_result));
                    
                } else {
                    parsed = new Car((JSONObject)this.parser.parse(raw_result));
                    
                }
                
                result.add(parsed);
                
            }
        } catch (SQLException e) {
            System.err.println("Could not iterate through query.");
    		e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Could not convert the response from getCarsByYear; a parser error occurred.");
    		e.printStackTrace();
        }
        return result;
	}
    
    
    /**
     * Returns all the cars of a certain make.
    
     * @param make The make of the cars
     * @return a list[car]
     */
	public ArrayList<Car> getCarsByMake(String make) {
        return this.getCarsByMake(make, true);
    }
    
    
    /**
     * Returns all the cars of a certain make.
    
     * @param make The make of the cars
     * @return a list[car]
     */
	public ArrayList<Car> getCarsByMake(String make, boolean test) {
        String query;
        if (test) {
            query = String.format("SELECT data FROM cars WHERE make=? COLLATE NOCASE LIMIT %d", this.HARDWARE);
        } else {
            query = "SELECT data FROM cars WHERE make=? COLLATE NOCASE";
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
            preparedQuery.setString(1, make);
        } catch (SQLException e) {
            System.err.println("Could not build prepare argument: make");
    		e.printStackTrace();
        }
        try {
            rs = preparedQuery.executeQuery();
        } catch (SQLException e) {
            System.err.println("Could not execute query.");
    		e.printStackTrace();
        }
        
        ArrayList<Car> result = new ArrayList<Car>();
        try {
            while (rs.next()) {
                String raw_result = rs.getString(1);
                Car parsed = null;
                if (test) {
                    parsed = new Car((JSONObject)this.parser.parse(raw_result));
                    
                } else {
                    parsed = new Car((JSONObject)this.parser.parse(raw_result));
                    
                }
                
                result.add(parsed);
                
            }
        } catch (SQLException e) {
            System.err.println("Could not iterate through query.");
    		e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Could not convert the response from getCarsByMake; a parser error occurred.");
    		e.printStackTrace();
        }
        return result;
	}
    
}