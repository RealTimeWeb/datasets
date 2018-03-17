package corgis.food.domain;

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
public class Vitamins {
	
    // Vitamin B12, also called cobalamin, is a water-soluble vitamin that has a key role in the normal functioning of the brain and nervous system, and the formation of red blood cells. It is one of eight B vitamins. It is involved in the metabolism of every cell of the human body, especially affecting DNA synthesis, fatty acid and amino acid metabolism. No fungi, plants, nor animals (including humans) are capable of producing vitamin B12. Only bacteria and archaea have the enzymes needed for its synthesis. Proved sources of B12 are animal products (meat, fish, dairy products) and supplements. Measured in micrograms (mcg).
    private Double vitaminBonetwo;
    // Vitamin A is a fat soluble vitamin that is also a powerful antioxidant. Vitamin A plays a critical role in maintaining healthy vision, neurological function, healthy skin, and more. Measured in International Units.
    private Integer vitaminAIu;
    // Vitamin K (Phylloquinone) is a group of structurally similar, fat-soluble vitamins the human body requires for complete synthesis of certain proteins that are prerequisites for blood coagulation and which the body also needs for controlling binding of calcium in bones and other tissues. Measured in micrograms (mcg).
    private Double vitaminK;
    // Vitamin E refers to a group of compounds that include both tocopherols and tocotrienols, usually found in various oils (corn oil, soybean oil, wheat germ oil). Measured in milligrams (mg).
    private Double vitaminE;
    // Vitamin B6 is involved in many aspects of macronutrient metabolism, neurotransmitter synthesis, histamine synthesis, hemoglobin synthesis and function, and gene expression. Vitamin B6 is widely distributed in foods in both its free and bound forms. Measured in milligrams (mg).
    private Double vitaminBsix;
    // Vitamin A is a fat soluble vitamin that is also a powerful antioxidant. Vitamin A plays a critical role in maintaining healthy vision, neurological function, healthy skin, and more. Measured in retinol activity equivalents (micrograms, or mcg).
    private Integer vitaminARae;
    // Vitamin C, also known as ascorbic acid and L-ascorbic acid, is a vitamin found in food and used as a dietary supplement. Foods that contain vitamin C include citrus fruit, tomatoes, and potatoes. Measured in milligrams (mg).
    private Double vitaminC;
    
    
    /**
     * Vitamin B12, also called cobalamin, is a water-soluble vitamin that has a key role in the normal functioning of the brain and nervous system, and the formation of red blood cells. It is one of eight B vitamins. It is involved in the metabolism of every cell of the human body, especially affecting DNA synthesis, fatty acid and amino acid metabolism. No fungi, plants, nor animals (including humans) are capable of producing vitamin B12. Only bacteria and archaea have the enzymes needed for its synthesis. Proved sources of B12 are animal products (meat, fish, dairy products) and supplements. Measured in micrograms (mcg).
     * @return Double
     */
    public Double getVitaminBonetwo() {
        return this.vitaminBonetwo;
    }
    
    
    
    /**
     * Vitamin A is a fat soluble vitamin that is also a powerful antioxidant. Vitamin A plays a critical role in maintaining healthy vision, neurological function, healthy skin, and more. Measured in International Units.
     * @return Integer
     */
    public Integer getVitaminAIu() {
        return this.vitaminAIu;
    }
    
    
    
    /**
     * Vitamin K (Phylloquinone) is a group of structurally similar, fat-soluble vitamins the human body requires for complete synthesis of certain proteins that are prerequisites for blood coagulation and which the body also needs for controlling binding of calcium in bones and other tissues. Measured in micrograms (mcg).
     * @return Double
     */
    public Double getVitaminK() {
        return this.vitaminK;
    }
    
    
    
    /**
     * Vitamin E refers to a group of compounds that include both tocopherols and tocotrienols, usually found in various oils (corn oil, soybean oil, wheat germ oil). Measured in milligrams (mg).
     * @return Double
     */
    public Double getVitaminE() {
        return this.vitaminE;
    }
    
    
    
    /**
     * Vitamin B6 is involved in many aspects of macronutrient metabolism, neurotransmitter synthesis, histamine synthesis, hemoglobin synthesis and function, and gene expression. Vitamin B6 is widely distributed in foods in both its free and bound forms. Measured in milligrams (mg).
     * @return Double
     */
    public Double getVitaminBsix() {
        return this.vitaminBsix;
    }
    
    
    
    /**
     * Vitamin A is a fat soluble vitamin that is also a powerful antioxidant. Vitamin A plays a critical role in maintaining healthy vision, neurological function, healthy skin, and more. Measured in retinol activity equivalents (micrograms, or mcg).
     * @return Integer
     */
    public Integer getVitaminARae() {
        return this.vitaminARae;
    }
    
    
    
    /**
     * Vitamin C, also known as ascorbic acid and L-ascorbic acid, is a vitamin found in food and used as a dietary supplement. Foods that contain vitamin C include citrus fruit, tomatoes, and potatoes. Measured in milligrams (mg).
     * @return Double
     */
    public Double getVitaminC() {
        return this.vitaminC;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Vitamins.
	
	 * @return String
	 */
	public String toString() {
		return "Vitamins[" +vitaminBonetwo+", "+vitaminAIu+", "+vitaminK+", "+vitaminE+", "+vitaminBsix+", "+vitaminARae+", "+vitaminC+"]";
	}
	
	/**
	 * Internal constructor to create a Vitamins from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Vitamins(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Vitamin B12
            this.vitaminBonetwo = ((Number)json_data.get("Vitamin B12")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Vitamins; the field vitaminBonetwo was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Vitamins; the field vitaminBonetwo had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Vitamin A - IU
            this.vitaminAIu = ((Number)json_data.get("Vitamin A - IU")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Vitamins; the field vitaminAIu was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Vitamins; the field vitaminAIu had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Vitamin K
            this.vitaminK = ((Number)json_data.get("Vitamin K")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Vitamins; the field vitaminK was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Vitamins; the field vitaminK had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Vitamin E
            this.vitaminE = ((Number)json_data.get("Vitamin E")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Vitamins; the field vitaminE was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Vitamins; the field vitaminE had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Vitamin B6
            this.vitaminBsix = ((Number)json_data.get("Vitamin B6")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Vitamins; the field vitaminBsix was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Vitamins; the field vitaminBsix had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Vitamin A - RAE
            this.vitaminARae = ((Number)json_data.get("Vitamin A - RAE")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Vitamins; the field vitaminARae was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Vitamins; the field vitaminARae had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Vitamin C
            this.vitaminC = ((Number)json_data.get("Vitamin C")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Vitamins; the field vitaminC was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Vitamins; the field vitaminC had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}