package corgis.food.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import corgis.food.domain.MajorMinerals;
import corgis.food.domain.Fat;
import corgis.food.domain.Vitamins;
import corgis.food.domain.HouseholdWeights;

/**
 * 
 */
public class Data {
	
    private MajorMinerals majorMinerals;
    // Manganese is a chemical element with symbol Mn and atomic number 25. In biology, manganese(II) ions function as cofactors for a large variety of enzymes with many functions. Manganese enzymes are particularly essential in detoxification of superoxide free radicals in organisms that must deal with elemental oxygen. Manganese also functions in the oxygen-evolving complex of photosynthetic plants. The element is a required trace mineral for all known living organisms but is a neurotoxin. In larger amounts, and apparently with far greater effectiveness through inhalation, it can cause a poisoning in mammals with neurological damage that is sometimes irreversible. Measured in milligrams (mg).
    private Double manganese;
    // Alpha Carotene is a form of carotene with a Beta-ionone ring at one end and an Alpha-ionone ring at the opposite end. It is the second most common form of carotene. Alpha Carotene is common in yellow-orange and dark-green vegetables. Measured in micrograms (mcg).
    private Integer alphaCarotene;
    // Also known as vitamin B3 and nicotinic acid, is an organic compound with the formula C6H5NO 2 and, depending on the definition used, one of the 20 to 80 essential human nutrients. Measured in miligrams (mg).
    private Double niacin;
    // Retinol, also known as Vitamin A1, is a vitamin found in food and used as a dietary supplement. As a supplement it is used to treat and prevent vitamin A deficiency. Measured in micrograms (mcg).
    private Integer retinol;
    // Lycopene is a bright red carotene and carotenoid pigment and phytochemical found in tomatoes and other red fruits and vegetables, such as red carrots, watermelons, gac, and papayas, although not in strawberries, or cherries. Although lycopene is chemically a carotene, it has no vitamin A activity. Foods that are not red may also contain lycopene, such as asparagus and parsley. Measured in micrograms (mcg).
    private Integer lycopene;
    // A water-soluble vitamin. Humans make choline in the liver. Whether dietary or supplemental choline is beneficial or harmful to humans is undefined. Measured in milligrams (mg).
    private Integer choline;
    private Fat fat;
    // Riboflavin, also known as vitamin B2, is a vitamin found in food and used as a dietary supplement. It is nearly always well tolerated. Normal doses are safe during pregnancy. Riboflavin is in the vitamin B group. It is required by the body for cellular respiration. Food sources include eggs, green vegetables, milk, and meat. Measured in milligrams (mg).
    private Double riboflavin;
    // Pantothenic acid, also called vitamin B5 (a B vitamin), is a water-soluble vitamin. Pantothenic acid is an essential nutrient. Animals require pantothenic acid to synthesize coenzyme-A (CoA), as well as to synthesize and metabolize proteins, carbohydrates, and fats. Measured in milligrams (mg).
    private Double pantothenicAcid;
    // Thiamin (or thiamine) is one of the water-soluble B vitamins. It is also known as vitamin B1. Thiamin is naturally present in some foods, added to some food products, and available as a dietary supplement. This vitamin plays a critical role in energy metabolism and, therefore, in the growth, development, and function of cells. Measured in milligrams (mg).
    private Double thiamin;
    // The amount of water in the food. Measured in grams (g).
    private Double water;
    // In food science and in many informal contexts, the term carbohydrate often means any food that is particularly rich in the complex carbohydrate starch (such as cereals, bread and pasta) or simple carbohydrates, such as sugar (found in candy, jams, and desserts). Carbohydrates are found in wide variety of foods. The important sources are cereals (wheat, maize, rice), potatoes, sugarcane, fruits, table sugar(sucrose), bread, milk, etc. Starch and sugar are the important carbohydrates in our diet. Starch is abundant in potatoes, maize, rice and other cereals. Sugar appears in our diet mainly as sucrose(table sugar) which is added to drinks and many prepared foods such as jam, biscuits and cakes. Glucose and fructose are found naturally in many fruits and some vegetables. Glycogen is carbohydrate found in the liver and muscles (as animal source). Cellulose in the cell wall of all plant tissue is a carbohydrate. It is important in our diet as fibre which helps to maintain a healthy digestive system. Measured in grams (g) by difference.
    private Double carbohydrate;
    // The percentage of the food item that is inedible and should be treated as refuse. Given as a decimal percentage.
    private Integer refusePercentage;
    private Vitamins vitamins;
    // The total number of kilocalories in this food item. A kilocalorie is a unit of energy of 1000 calories (equal to 1 large calorie).
    private Integer kilocalories;
    // An organic molecule that is a sterol (or modified steroid), a type of lipid molecule, and is biosynthesized by all animal cells, because it is an essential structural component of all animal cell membranes; essential to maintain both membrane structural integrity and fluidity. Cholesterol enables animal cells to dispense with a cell wall (to protect membrane integrity and cell viability), thereby allowing animal cells to change shape and animals to move (unlike bacteria and plant cells, which are restricted by their cell walls). Since all animal cells manufacture cholesterol, all animal-based foods contain cholesterol in varying amounts. Measured in milligrams (mg).
    private Integer cholesterol;
    // Selenium is a chemical element with symbol Se and atomic number 34. Selenium salts are toxic in large amounts, but trace amounts are necessary for cellular function in many organisms, including all animals. Measured in micrograms (mcg).
    private Double selenium;
    // An organic, strongly colored red-orange pigment abundant in plants and fruits. Measured in micrograms (mcg).
    private Integer betaCarotene;
    // Dietary fiber or roughage is the indigestible portion of food derived from plants. It has two main components: soluble fiber and insoluble fiber. Measured in grams (g).
    private Double fiber;
    // Ash or mineral content is the portion of the food or any organic material that remains after it is burned at very high temperatures. The ash constituents include potassium, sodium, calcium and magnesium, which are present in larger amounts as well as smaller quantities of aluminum, iron, copper, manganese or zinc, arsenic, iodine, fluorine and other elements present in traces. Ash content represents the total mineral content in foods. Although minerals represent a small proportion of dry matter, often less than 7% of the total, they play an important role from a physicochemical, technological and nutritional point of view. Measured in grams (g).
    private Double ash;
    // Proteins are essential nutrients for the human body. They are one of the building blocks of body tissue, and can also serve as a fuel source. As a fuel, proteins provide as much energy density as carbohydrates: 4 kcal (17 kJ) per gram; in contrast, lipids provide 9 kcal (37 kJ) per gram. There are nine essential amino acids which humans must obtain from their diet in order to prevent protein-energy malnutrition and resulting death. Humans need the essential amino acids in certain ratios. Dietary sources of protein include both animals and plants: meats, dairy products, fish and eggs as well as grains, legumes and nuts. Measured in grams (g).
    private Double protein;
    // Lutein is synthesized only by plants and like other xanthophylls is found in high quantities in green leafy vegetables such as spinach, kale and yellow carrots. Zeaxanthin is one of the most common carotenoid alcohols found in nature. It is important in the xanthophyll cycle. Synthesized in plants and some micro-organisms, it is the pigment that gives paprika (made from bell peppers), corn, saffron, wolfberries, and many other plants and microbes their characteristic color. This combined quantity of these two compounds is measured in micrograms (mcg).
    private Integer luteinAndZeaxanthin;
    // Cryptoxanthin is a natural carotenoid pigment. It has been isolated from a variety of sources including the petals and flowers of plants in the genus Physalis, orange rind, papaya, egg yolk, butter, apples, and bovine blood serum. In the human body, cryptoxanthin is converted to vitamin A (retinol) and is, therefore, considered a provitamin A. As with other carotenoids, cryptoxanthin is an antioxidant and may help prevent free radical damage to cells and DNA, as well as stimulate the repair of oxidative damage to DNA. Measured in micrograms (mcg).
    private Integer betaCryptoxanthin;
    // Sugar is the generalized name for sweet, short-chain, soluble carbohydrates, many of which are used in food. They are composed of carbon, hydrogen, and oxygen. There are various types of sugar derived from different sources. Simple sugars are called monosaccharides and include glucose (also known as dextrose), fructose, and galactose. The table or granulated sugar most customarily used as food is sucrose, a disaccharide. (In the body, sucrose hydrolyses into fructose and glucose.) Other disaccharides include maltose and lactose. Longer chains of sugars are called oligosaccharides. Chemically-different substances may also have a sweet taste, but are not classified as sugars. Some are used as lower-calorie food substitutes for sugar, described as artificial sweeteners. Measure in grams (g).
    private Double sugarTotal;
    private HouseholdWeights householdWeights;
    
    
    /**
     * 
     * @return MajorMinerals
     */
    public MajorMinerals getMajorMinerals() {
        return this.majorMinerals;
    }
    
    
    
    /**
     * Manganese is a chemical element with symbol Mn and atomic number 25. In biology, manganese(II) ions function as cofactors for a large variety of enzymes with many functions. Manganese enzymes are particularly essential in detoxification of superoxide free radicals in organisms that must deal with elemental oxygen. Manganese also functions in the oxygen-evolving complex of photosynthetic plants. The element is a required trace mineral for all known living organisms but is a neurotoxin. In larger amounts, and apparently with far greater effectiveness through inhalation, it can cause a poisoning in mammals with neurological damage that is sometimes irreversible. Measured in milligrams (mg).
     * @return Double
     */
    public Double getManganese() {
        return this.manganese;
    }
    
    
    
    /**
     * Alpha Carotene is a form of carotene with a Beta-ionone ring at one end and an Alpha-ionone ring at the opposite end. It is the second most common form of carotene. Alpha Carotene is common in yellow-orange and dark-green vegetables. Measured in micrograms (mcg).
     * @return Integer
     */
    public Integer getAlphaCarotene() {
        return this.alphaCarotene;
    }
    
    
    
    /**
     * Also known as vitamin B3 and nicotinic acid, is an organic compound with the formula C6H5NO 2 and, depending on the definition used, one of the 20 to 80 essential human nutrients. Measured in miligrams (mg).
     * @return Double
     */
    public Double getNiacin() {
        return this.niacin;
    }
    
    
    
    /**
     * Retinol, also known as Vitamin A1, is a vitamin found in food and used as a dietary supplement. As a supplement it is used to treat and prevent vitamin A deficiency. Measured in micrograms (mcg).
     * @return Integer
     */
    public Integer getRetinol() {
        return this.retinol;
    }
    
    
    
    /**
     * Lycopene is a bright red carotene and carotenoid pigment and phytochemical found in tomatoes and other red fruits and vegetables, such as red carrots, watermelons, gac, and papayas, although not in strawberries, or cherries. Although lycopene is chemically a carotene, it has no vitamin A activity. Foods that are not red may also contain lycopene, such as asparagus and parsley. Measured in micrograms (mcg).
     * @return Integer
     */
    public Integer getLycopene() {
        return this.lycopene;
    }
    
    
    
    /**
     * A water-soluble vitamin. Humans make choline in the liver. Whether dietary or supplemental choline is beneficial or harmful to humans is undefined. Measured in milligrams (mg).
     * @return Integer
     */
    public Integer getCholine() {
        return this.choline;
    }
    
    
    
    /**
     * 
     * @return Fat
     */
    public Fat getFat() {
        return this.fat;
    }
    
    
    
    /**
     * Riboflavin, also known as vitamin B2, is a vitamin found in food and used as a dietary supplement. It is nearly always well tolerated. Normal doses are safe during pregnancy. Riboflavin is in the vitamin B group. It is required by the body for cellular respiration. Food sources include eggs, green vegetables, milk, and meat. Measured in milligrams (mg).
     * @return Double
     */
    public Double getRiboflavin() {
        return this.riboflavin;
    }
    
    
    
    /**
     * Pantothenic acid, also called vitamin B5 (a B vitamin), is a water-soluble vitamin. Pantothenic acid is an essential nutrient. Animals require pantothenic acid to synthesize coenzyme-A (CoA), as well as to synthesize and metabolize proteins, carbohydrates, and fats. Measured in milligrams (mg).
     * @return Double
     */
    public Double getPantothenicAcid() {
        return this.pantothenicAcid;
    }
    
    
    
    /**
     * Thiamin (or thiamine) is one of the water-soluble B vitamins. It is also known as vitamin B1. Thiamin is naturally present in some foods, added to some food products, and available as a dietary supplement. This vitamin plays a critical role in energy metabolism and, therefore, in the growth, development, and function of cells. Measured in milligrams (mg).
     * @return Double
     */
    public Double getThiamin() {
        return this.thiamin;
    }
    
    
    
    /**
     * The amount of water in the food. Measured in grams (g).
     * @return Double
     */
    public Double getWater() {
        return this.water;
    }
    
    
    
    /**
     * In food science and in many informal contexts, the term carbohydrate often means any food that is particularly rich in the complex carbohydrate starch (such as cereals, bread and pasta) or simple carbohydrates, such as sugar (found in candy, jams, and desserts). Carbohydrates are found in wide variety of foods. The important sources are cereals (wheat, maize, rice), potatoes, sugarcane, fruits, table sugar(sucrose), bread, milk, etc. Starch and sugar are the important carbohydrates in our diet. Starch is abundant in potatoes, maize, rice and other cereals. Sugar appears in our diet mainly as sucrose(table sugar) which is added to drinks and many prepared foods such as jam, biscuits and cakes. Glucose and fructose are found naturally in many fruits and some vegetables. Glycogen is carbohydrate found in the liver and muscles (as animal source). Cellulose in the cell wall of all plant tissue is a carbohydrate. It is important in our diet as fibre which helps to maintain a healthy digestive system. Measured in grams (g) by difference.
     * @return Double
     */
    public Double getCarbohydrate() {
        return this.carbohydrate;
    }
    
    
    
    /**
     * The percentage of the food item that is inedible and should be treated as refuse. Given as a decimal percentage.
     * @return Integer
     */
    public Integer getRefusePercentage() {
        return this.refusePercentage;
    }
    
    
    
    /**
     * 
     * @return Vitamins
     */
    public Vitamins getVitamins() {
        return this.vitamins;
    }
    
    
    
    /**
     * The total number of kilocalories in this food item. A kilocalorie is a unit of energy of 1000 calories (equal to 1 large calorie).
     * @return Integer
     */
    public Integer getKilocalories() {
        return this.kilocalories;
    }
    
    
    
    /**
     * An organic molecule that is a sterol (or modified steroid), a type of lipid molecule, and is biosynthesized by all animal cells, because it is an essential structural component of all animal cell membranes; essential to maintain both membrane structural integrity and fluidity. Cholesterol enables animal cells to dispense with a cell wall (to protect membrane integrity and cell viability), thereby allowing animal cells to change shape and animals to move (unlike bacteria and plant cells, which are restricted by their cell walls). Since all animal cells manufacture cholesterol, all animal-based foods contain cholesterol in varying amounts. Measured in milligrams (mg).
     * @return Integer
     */
    public Integer getCholesterol() {
        return this.cholesterol;
    }
    
    
    
    /**
     * Selenium is a chemical element with symbol Se and atomic number 34. Selenium salts are toxic in large amounts, but trace amounts are necessary for cellular function in many organisms, including all animals. Measured in micrograms (mcg).
     * @return Double
     */
    public Double getSelenium() {
        return this.selenium;
    }
    
    
    
    /**
     * An organic, strongly colored red-orange pigment abundant in plants and fruits. Measured in micrograms (mcg).
     * @return Integer
     */
    public Integer getBetaCarotene() {
        return this.betaCarotene;
    }
    
    
    
    /**
     * Dietary fiber or roughage is the indigestible portion of food derived from plants. It has two main components: soluble fiber and insoluble fiber. Measured in grams (g).
     * @return Double
     */
    public Double getFiber() {
        return this.fiber;
    }
    
    
    
    /**
     * Ash or mineral content is the portion of the food or any organic material that remains after it is burned at very high temperatures. The ash constituents include potassium, sodium, calcium and magnesium, which are present in larger amounts as well as smaller quantities of aluminum, iron, copper, manganese or zinc, arsenic, iodine, fluorine and other elements present in traces. Ash content represents the total mineral content in foods. Although minerals represent a small proportion of dry matter, often less than 7% of the total, they play an important role from a physicochemical, technological and nutritional point of view. Measured in grams (g).
     * @return Double
     */
    public Double getAsh() {
        return this.ash;
    }
    
    
    
    /**
     * Proteins are essential nutrients for the human body. They are one of the building blocks of body tissue, and can also serve as a fuel source. As a fuel, proteins provide as much energy density as carbohydrates: 4 kcal (17 kJ) per gram; in contrast, lipids provide 9 kcal (37 kJ) per gram. There are nine essential amino acids which humans must obtain from their diet in order to prevent protein-energy malnutrition and resulting death. Humans need the essential amino acids in certain ratios. Dietary sources of protein include both animals and plants: meats, dairy products, fish and eggs as well as grains, legumes and nuts. Measured in grams (g).
     * @return Double
     */
    public Double getProtein() {
        return this.protein;
    }
    
    
    
    /**
     * Lutein is synthesized only by plants and like other xanthophylls is found in high quantities in green leafy vegetables such as spinach, kale and yellow carrots. Zeaxanthin is one of the most common carotenoid alcohols found in nature. It is important in the xanthophyll cycle. Synthesized in plants and some micro-organisms, it is the pigment that gives paprika (made from bell peppers), corn, saffron, wolfberries, and many other plants and microbes their characteristic color. This combined quantity of these two compounds is measured in micrograms (mcg).
     * @return Integer
     */
    public Integer getLuteinAndZeaxanthin() {
        return this.luteinAndZeaxanthin;
    }
    
    
    
    /**
     * Cryptoxanthin is a natural carotenoid pigment. It has been isolated from a variety of sources including the petals and flowers of plants in the genus Physalis, orange rind, papaya, egg yolk, butter, apples, and bovine blood serum. In the human body, cryptoxanthin is converted to vitamin A (retinol) and is, therefore, considered a provitamin A. As with other carotenoids, cryptoxanthin is an antioxidant and may help prevent free radical damage to cells and DNA, as well as stimulate the repair of oxidative damage to DNA. Measured in micrograms (mcg).
     * @return Integer
     */
    public Integer getBetaCryptoxanthin() {
        return this.betaCryptoxanthin;
    }
    
    
    
    /**
     * Sugar is the generalized name for sweet, short-chain, soluble carbohydrates, many of which are used in food. They are composed of carbon, hydrogen, and oxygen. There are various types of sugar derived from different sources. Simple sugars are called monosaccharides and include glucose (also known as dextrose), fructose, and galactose. The table or granulated sugar most customarily used as food is sucrose, a disaccharide. (In the body, sucrose hydrolyses into fructose and glucose.) Other disaccharides include maltose and lactose. Longer chains of sugars are called oligosaccharides. Chemically-different substances may also have a sweet taste, but are not classified as sugars. Some are used as lower-calorie food substitutes for sugar, described as artificial sweeteners. Measure in grams (g).
     * @return Double
     */
    public Double getSugarTotal() {
        return this.sugarTotal;
    }
    
    
    
    /**
     * 
     * @return HouseholdWeights
     */
    public HouseholdWeights getHouseholdWeights() {
        return this.householdWeights;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Data.
	
	 * @return String
	 */
	public String toString() {
		return "Data[" +majorMinerals+", "+manganese+", "+alphaCarotene+", "+niacin+", "+retinol+", "+lycopene+", "+choline+", "+fat+", "+riboflavin+", "+pantothenicAcid+", "+thiamin+", "+water+", "+carbohydrate+", "+refusePercentage+", "+vitamins+", "+kilocalories+", "+cholesterol+", "+selenium+", "+betaCarotene+", "+fiber+", "+ash+", "+protein+", "+luteinAndZeaxanthin+", "+betaCryptoxanthin+", "+sugarTotal+", "+householdWeights+"]";
	}
	
	/**
	 * Internal constructor to create a Data from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Data(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // Major Minerals
            this.majorMinerals = new MajorMinerals((JSONObject)json_data.get("Major Minerals"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field majorMinerals was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field majorMinerals had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Manganese
            this.manganese = ((Number)json_data.get("Manganese")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field manganese was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field manganese had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Alpha Carotene
            this.alphaCarotene = ((Number)json_data.get("Alpha Carotene")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field alphaCarotene was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field alphaCarotene had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Niacin
            this.niacin = ((Number)json_data.get("Niacin")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field niacin was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field niacin had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Retinol
            this.retinol = ((Number)json_data.get("Retinol")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field retinol was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field retinol had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Lycopene
            this.lycopene = ((Number)json_data.get("Lycopene")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field lycopene was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field lycopene had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Choline
            this.choline = ((Number)json_data.get("Choline")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field choline was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field choline had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Fat
            this.fat = new Fat((JSONObject)json_data.get("Fat"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field fat was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field fat had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Riboflavin
            this.riboflavin = ((Number)json_data.get("Riboflavin")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field riboflavin was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field riboflavin had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Pantothenic Acid
            this.pantothenicAcid = ((Number)json_data.get("Pantothenic Acid")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field pantothenicAcid was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field pantothenicAcid had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Thiamin
            this.thiamin = ((Number)json_data.get("Thiamin")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field thiamin was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field thiamin had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Water
            this.water = ((Number)json_data.get("Water")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field water was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field water had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Carbohydrate
            this.carbohydrate = ((Number)json_data.get("Carbohydrate")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field carbohydrate was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field carbohydrate had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Refuse Percentage
            this.refusePercentage = ((Number)json_data.get("Refuse Percentage")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field refusePercentage was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field refusePercentage had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Vitamins
            this.vitamins = new Vitamins((JSONObject)json_data.get("Vitamins"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field vitamins was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field vitamins had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Kilocalories
            this.kilocalories = ((Number)json_data.get("Kilocalories")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field kilocalories was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field kilocalories had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Cholesterol
            this.cholesterol = ((Number)json_data.get("Cholesterol")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field cholesterol was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field cholesterol had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Selenium
            this.selenium = ((Number)json_data.get("Selenium")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field selenium was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field selenium had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Beta Carotene
            this.betaCarotene = ((Number)json_data.get("Beta Carotene")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field betaCarotene was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field betaCarotene had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Fiber
            this.fiber = ((Number)json_data.get("Fiber")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field fiber was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field fiber had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Ash
            this.ash = ((Number)json_data.get("Ash")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field ash was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field ash had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Protein
            this.protein = ((Number)json_data.get("Protein")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field protein was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field protein had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Lutein and Zeaxanthin
            this.luteinAndZeaxanthin = ((Number)json_data.get("Lutein and Zeaxanthin")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field luteinAndZeaxanthin was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field luteinAndZeaxanthin had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Beta Cryptoxanthin
            this.betaCryptoxanthin = ((Number)json_data.get("Beta Cryptoxanthin")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field betaCryptoxanthin was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field betaCryptoxanthin had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Sugar Total
            this.sugarTotal = ((Number)json_data.get("Sugar Total")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field sugarTotal was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field sugarTotal had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // Household Weights
            this.householdWeights = new HouseholdWeights((JSONObject)json_data.get("Household Weights"));
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Data; the field householdWeights was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Data; the field householdWeights had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}