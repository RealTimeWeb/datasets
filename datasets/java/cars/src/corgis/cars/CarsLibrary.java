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
 * This is a dataset about cars and how much fuel they use.

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
                    parsed = new Car(((JSONObject)this.parser.parse(raw_result)));
                    
                } else {
                    parsed = new Car(((JSONObject)this.parser.parse(raw_result)));
                    
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
    
}