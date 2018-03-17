package corgis.skyscrapers.domain;

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
public class Purposes {
	
    private Boolean servicedApartments;
    private Boolean hotel;
    private Boolean exhibition;
    private Boolean other;
    private Boolean government;
    private Boolean industrial;
    private Boolean library;
    private Boolean observation;
    private Boolean casino;
    private Boolean airTrafficControlTower;
    private Boolean bridge;
    private Boolean telecommunications;
    private Boolean commercial;
    private Boolean museum;
    private Boolean religious;
    private Boolean hospital;
    private Boolean abandoned;
    private Boolean education;
    private Boolean retail;
    private Boolean office;
    private Boolean belltower;
    private Boolean multiple;
    private Boolean residential;
    
    
    /**
     * 
     * @return Boolean
     */
    public Boolean getServicedApartments() {
        return this.servicedApartments;
    }
    
    
    
    /**
     * 
     * @return Boolean
     */
    public Boolean getHotel() {
        return this.hotel;
    }
    
    
    
    /**
     * 
     * @return Boolean
     */
    public Boolean getExhibition() {
        return this.exhibition;
    }
    
    
    
    /**
     * 
     * @return Boolean
     */
    public Boolean getOther() {
        return this.other;
    }
    
    
    
    /**
     * 
     * @return Boolean
     */
    public Boolean getGovernment() {
        return this.government;
    }
    
    
    
    /**
     * 
     * @return Boolean
     */
    public Boolean getIndustrial() {
        return this.industrial;
    }
    
    
    
    /**
     * 
     * @return Boolean
     */
    public Boolean getLibrary() {
        return this.library;
    }
    
    
    
    /**
     * 
     * @return Boolean
     */
    public Boolean getObservation() {
        return this.observation;
    }
    
    
    
    /**
     * 
     * @return Boolean
     */
    public Boolean getCasino() {
        return this.casino;
    }
    
    
    
    /**
     * 
     * @return Boolean
     */
    public Boolean getAirTrafficControlTower() {
        return this.airTrafficControlTower;
    }
    
    
    
    /**
     * 
     * @return Boolean
     */
    public Boolean getBridge() {
        return this.bridge;
    }
    
    
    
    /**
     * 
     * @return Boolean
     */
    public Boolean getTelecommunications() {
        return this.telecommunications;
    }
    
    
    
    /**
     * 
     * @return Boolean
     */
    public Boolean getCommercial() {
        return this.commercial;
    }
    
    
    
    /**
     * 
     * @return Boolean
     */
    public Boolean getMuseum() {
        return this.museum;
    }
    
    
    
    /**
     * 
     * @return Boolean
     */
    public Boolean getReligious() {
        return this.religious;
    }
    
    
    
    /**
     * 
     * @return Boolean
     */
    public Boolean getHospital() {
        return this.hospital;
    }
    
    
    
    /**
     * 
     * @return Boolean
     */
    public Boolean getAbandoned() {
        return this.abandoned;
    }
    
    
    
    /**
     * 
     * @return Boolean
     */
    public Boolean getEducation() {
        return this.education;
    }
    
    
    
    /**
     * 
     * @return Boolean
     */
    public Boolean getRetail() {
        return this.retail;
    }
    
    
    
    /**
     * 
     * @return Boolean
     */
    public Boolean getOffice() {
        return this.office;
    }
    
    
    
    /**
     * 
     * @return Boolean
     */
    public Boolean getBelltower() {
        return this.belltower;
    }
    
    
    
    /**
     * 
     * @return Boolean
     */
    public Boolean getMultiple() {
        return this.multiple;
    }
    
    
    
    /**
     * 
     * @return Boolean
     */
    public Boolean getResidential() {
        return this.residential;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Purposes.
	
	 * @return String
	 */
	public String toString() {
		return "Purposes[" +servicedApartments+", "+hotel+", "+exhibition+", "+other+", "+government+", "+industrial+", "+library+", "+observation+", "+casino+", "+airTrafficControlTower+", "+bridge+", "+telecommunications+", "+commercial+", "+museum+", "+religious+", "+hospital+", "+abandoned+", "+education+", "+retail+", "+office+", "+belltower+", "+multiple+", "+residential+"]";
	}
	
	/**
	 * Internal constructor to create a Purposes from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Purposes(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // serviced apartments
            this.servicedApartments = (Boolean)json_data.get("serviced apartments");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Purposes; the field servicedApartments was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Purposes; the field servicedApartments had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // hotel
            this.hotel = (Boolean)json_data.get("hotel");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Purposes; the field hotel was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Purposes; the field hotel had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // exhibition
            this.exhibition = (Boolean)json_data.get("exhibition");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Purposes; the field exhibition was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Purposes; the field exhibition had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // other
            this.other = (Boolean)json_data.get("other");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Purposes; the field other was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Purposes; the field other had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // government
            this.government = (Boolean)json_data.get("government");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Purposes; the field government was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Purposes; the field government had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // industrial
            this.industrial = (Boolean)json_data.get("industrial");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Purposes; the field industrial was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Purposes; the field industrial had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // library
            this.library = (Boolean)json_data.get("library");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Purposes; the field library was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Purposes; the field library had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // observation
            this.observation = (Boolean)json_data.get("observation");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Purposes; the field observation was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Purposes; the field observation had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // casino
            this.casino = (Boolean)json_data.get("casino");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Purposes; the field casino was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Purposes; the field casino had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // air traffic control tower
            this.airTrafficControlTower = (Boolean)json_data.get("air traffic control tower");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Purposes; the field airTrafficControlTower was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Purposes; the field airTrafficControlTower had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // bridge
            this.bridge = (Boolean)json_data.get("bridge");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Purposes; the field bridge was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Purposes; the field bridge had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // telecommunications
            this.telecommunications = (Boolean)json_data.get("telecommunications");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Purposes; the field telecommunications was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Purposes; the field telecommunications had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // commercial
            this.commercial = (Boolean)json_data.get("commercial");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Purposes; the field commercial was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Purposes; the field commercial had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // museum
            this.museum = (Boolean)json_data.get("museum");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Purposes; the field museum was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Purposes; the field museum had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // religious
            this.religious = (Boolean)json_data.get("religious");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Purposes; the field religious was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Purposes; the field religious had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // hospital
            this.hospital = (Boolean)json_data.get("hospital");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Purposes; the field hospital was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Purposes; the field hospital had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // abandoned
            this.abandoned = (Boolean)json_data.get("abandoned");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Purposes; the field abandoned was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Purposes; the field abandoned had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // education
            this.education = (Boolean)json_data.get("education");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Purposes; the field education was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Purposes; the field education had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // retail
            this.retail = (Boolean)json_data.get("retail");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Purposes; the field retail was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Purposes; the field retail had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // office
            this.office = (Boolean)json_data.get("office");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Purposes; the field office was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Purposes; the field office had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // belltower
            this.belltower = (Boolean)json_data.get("belltower");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Purposes; the field belltower was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Purposes; the field belltower had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // multiple
            this.multiple = (Boolean)json_data.get("multiple");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Purposes; the field multiple was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Purposes; the field multiple had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // residential
            this.residential = (Boolean)json_data.get("residential");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Purposes; the field residential was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Purposes; the field residential had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}