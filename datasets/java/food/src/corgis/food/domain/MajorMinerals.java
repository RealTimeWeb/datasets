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
public class MajorMinerals {
	
    // Calcium is a mineral needed to build and maintain strong bones and teeth. It is also very important for other physical functions, such as muscle control and blood circulation. Calcium is not made in the body - it must be absorbed from food. To effectively absorb calcium from food, Vitamin D is needed. Measured in milligrams (mg).
    private Integer calcium;
    // Phosphorus is an essential macromineral, included in almost all foods. Phosphorus is the second most abundant mineral nutrient in the body, after calcium. This mineral is part of all cells, especially cell membranes, and is essential to bone strength, because it's the main structural component of bones and teeth, as calcium phosphate. Phosphorus is also an important element in energy production. Measured in milligrams (mg).
    private Integer phosphorus;
    // Copper is an essential trace element that is vital to the health of all living things (humans, plants, animals, and microorganisms). In humans, copper is essential to the proper functioning of organs and metabolic processes. Measured in milligrams (mg).
    private Double copper;
    // Potassium is a mineral and electrolyte that helps nerves to function and muscles to contract, among many other tasks. Potassium sources include leafy greens, fruit from vines, root vegetables, and citrus fruits. Measured in milligrams (mg).
    private Integer potassium;
    // Zinc is found in cells throughout the body. It is needed for the body's defensive (immune) system to properly work. It plays a role in cell division, cell growth, wound healing, and the breakdown of carbohydrates. Zinc is also needed for the senses of smell and taste. Measured in milligrams (mg).
    private Double zinc;
    // Magnesium is an essential mineral for human nutrition. Magnesium is needed for more than 300 biochemical reactions in the body. It helps to maintain normal nerve and muscle function, supports a healthy immune system, keeps the heart beat steady, and helps bones remain strong. It also helps regulate blood glucose levels and aid in the production of energy and protein. There is ongoing research into the role of magnesium in preventing and managing disorders such as high blood pressure, heart disease, and diabetes. However, taking magnesium supplements is not currently recommended. Diets high in protein, calcium, or vitamin D will increase the need for magnesium. Most dietary magnesium comes from vegetables, such as dark green, leafy vegetables. Measured in milligrams (mg).
    private Integer magnesium;
    // Salt, also known as sodium chloride, is about 40 percent sodium and 60 percent chloride. It adds flavor to food and is also used as a preservative, binder, and stabilizer. The human body needs a very small amount of sodium - the primary element we get from salt - to conduct nerve impulses, contract and relax muscles, and maintain the proper balance of water and minerals. But too much sodium in the diet can lead to high blood pressure, heart disease, and stroke. Measured in milligrams (mg).
    private Integer sodium;
    // Iron is a mineral that is naturally present in many foods, added to some food products, and available as a dietary supplement. Dietary iron has two main forms: heme and nonheme. Plants and iron-fortified foods contain nonheme iron only, whereas meat, seafood, and poultry contain both heme and nonheme iron. Measured in milligrams (mg).
    private Double iron;
    
    
    /**
     * Calcium is a mineral needed to build and maintain strong bones and teeth. It is also very important for other physical functions, such as muscle control and blood circulation. Calcium is not made in the body - it must be absorbed from food. To effectively absorb calcium from food, Vitamin D is needed. Measured in milligrams (mg).
     * @return Integer
     */
    public Integer getCalcium() {
        return this.calcium;
    }
    
    
    
    /**
     * Phosphorus is an essential macromineral, included in almost all foods. Phosphorus is the second most abundant mineral nutrient in the body, after calcium. This mineral is part of all cells, especially cell membranes, and is essential to bone strength, because it's the main structural component of bones and teeth, as calcium phosphate. Phosphorus is also an important element in energy production. Measured in milligrams (mg).
     * @return Integer
     */
    public Integer getPhosphorus() {
        return this.phosphorus;
    }
    
    
    
    /**
     * Copper is an essential trace element that is vital to the health of all living things (humans, plants, animals, and microorganisms). In humans, copper is essential to the proper functioning of organs and metabolic processes. Measured in milligrams (mg).
     * @return Double
     */
    public Double getCopper() {
        return this.copper;
    }
    
    
    
    /**
     * Potassium is a mineral and electrolyte that helps nerves to function and muscles to contract, among many other tasks. Potassium sources include leafy greens, fruit from vines, root vegetables, and citrus fruits. Measured in milligrams (mg).
     * @return Integer
     */
    public Integer getPotassium() {
        return this.potassium;
    }
    
    
    
    /**
     * Zinc is found in cells throughout the body. It is needed for the body's defensive (immune) system to properly work. It plays a role in cell division, cell growth, wound healing, and the breakdown of carbohydrates. Zinc is also needed for the senses of smell and taste. Measured in milligrams (mg).
     * @return Double
     */
    public Double getZinc() {
        return this.zinc;
    }
    
    
    
    /**
     * Magnesium is an essential mineral for human nutrition. Magnesium is needed for more than 300 biochemical reactions in the body. It helps to maintain normal nerve and muscle function, supports a healthy immune system, keeps the heart beat steady, and helps bones remain strong. It also helps regulate blood glucose levels and aid in the production of energy and protein. There is ongoing research into the role of magnesium in preventing and managing disorders such as high blood pressure, heart disease, and diabetes. However, taking magnesium supplements is not currently recommended. Diets high in protein, calcium, or vitamin D will increase the need for magnesium. Most dietary magnesium comes from vegetables, such as dark green, leafy vegetables. Measured in milligrams (mg).
     * @return Integer
     */
    public Integer getMagnesium() {
        return this.magnesium;
    }
    
    
    
    /**
     * Salt, also known as sodium chloride, is about 40 percent sodium and 60 percent chloride. It adds flavor to food and is also used as a preservative, binder, and stabilizer. The human body needs a very small amount of sodium - the primary element we get from salt - to conduct nerve impulses, contract and relax muscles, and maintain the proper balance of water and minerals. But too much sodium in the diet can lead to high blood pressure, heart disease, and stroke. Measured in milligrams (mg).
     * @return Integer
     */
    public Integer getSodium() {
        return this.sodium;
    }
    
    
    
    /**
     * Iron is a mineral that is naturally present in many foods, added to some food products, and available as a dietary supplement. Dietary iron has two main forms: heme and nonheme. Plants and iron-fortified foods contain nonheme iron only, whereas meat, seafood, and poultry contain both heme and nonheme iron. Measured in milligrams (mg).
     * @return Double
     */
    public Double getIron() {
        return this.iron;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this MajorMinerals.
	
	 * @return String
	 */
	public String toString() {
		return "MajorMinerals[" +calcium+", "+phosphorus+", "+copper+", "+potassium+", "+zinc+", "+magnesium+", "+sodium+", "+iron+"]";
	}
	
	/**
	 * Internal constructor to create a MajorMinerals from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public MajorMinerals(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Calcium
            this.calcium = ((Number)json_data.get("Calcium")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a MajorMinerals; the field calcium was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a MajorMinerals; the field calcium had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Phosphorus
            this.phosphorus = ((Number)json_data.get("Phosphorus")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a MajorMinerals; the field phosphorus was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a MajorMinerals; the field phosphorus had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Copper
            this.copper = ((Number)json_data.get("Copper")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a MajorMinerals; the field copper was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a MajorMinerals; the field copper had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Potassium
            this.potassium = ((Number)json_data.get("Potassium")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a MajorMinerals; the field potassium was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a MajorMinerals; the field potassium had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Zinc
            this.zinc = ((Number)json_data.get("Zinc")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a MajorMinerals; the field zinc was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a MajorMinerals; the field zinc had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Magnesium
            this.magnesium = ((Number)json_data.get("Magnesium")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a MajorMinerals; the field magnesium was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a MajorMinerals; the field magnesium had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Sodium
            this.sodium = ((Number)json_data.get("Sodium")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a MajorMinerals; the field sodium was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a MajorMinerals; the field sodium had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Iron
            this.iron = ((Number)json_data.get("Iron")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a MajorMinerals; the field iron was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a MajorMinerals; the field iron had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}