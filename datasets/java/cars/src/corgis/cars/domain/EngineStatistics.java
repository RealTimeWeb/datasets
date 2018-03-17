package corgis.cars.domain;

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
public class EngineStatistics {
	
    // A measure of the engine's power. A unit of power equal to 550 foot-pounds per second (745.7 watts).
    private Integer horsepower;
    // The torque of the engine, measured in lb/ft. When an engine is said to make "200 lb-ft of torque", it means that 200 pounds of force on a 1-foot lever is needed to stop its motion.
    private Integer torque;
    
    
    /**
     * A measure of the engine's power. A unit of power equal to 550 foot-pounds per second (745.7 watts).
     * @return Integer
     */
    public Integer getHorsepower() {
        return this.horsepower;
    }
    
    
    
    /**
     * The torque of the engine, measured in lb/ft. When an engine is said to make "200 lb-ft of torque", it means that 200 pounds of force on a 1-foot lever is needed to stop its motion.
     * @return Integer
     */
    public Integer getTorque() {
        return this.torque;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this EngineStatistics.
	
	 * @return String
	 */
	public String toString() {
		return "EngineStatistics[" +horsepower+", "+torque+"]";
	}
	
	/**
	 * Internal constructor to create a EngineStatistics from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public EngineStatistics(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Horsepower
            this.horsepower = ((Number)json_data.get("Horsepower")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a EngineStatistics; the field horsepower was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a EngineStatistics; the field horsepower had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Torque
            this.torque = ((Number)json_data.get("Torque")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a EngineStatistics; the field torque was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a EngineStatistics; the field torque had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}