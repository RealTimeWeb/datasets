package corgis.music.domain;

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
public class Song {
	
    // Estimation of the mode the song.
    private Integer mode;
    // Unknown field.
    private Double artist_Mbtags;
    // Average start time of each beat, measured in beats.
    private Double beats_Start;
    // Time of the end of the fade in, at the beginning of the song.
    private Double end_Of_Fade_In;
    // A measure of the song's popularity, when downloaded (in December 2010). Measured on a scale of 0 to 1.
    private Double hotttnesss;
    // Average start time of each bar, measured in bars.
    private Double bars_Start;
    // Tempo in BPM.
    private Double tempo;
    // Year when this song was released, according to musicbrainz.org.
    private Integer year;
    // Average start time of each tatum, measured in tatums.
    private Double tatums_Start;
    // General loudness of the track
    private Double loudness;
    // Confidence of the time signature estimation
    private Double time_Signature_Confidence;
    // Confidence value (between 0 and 1) associated with each tatum.
    private Double tatums_Confidence;
    // Duration of the track in seconds.
    private Double duration;
    // Estimation of the key the song is in. Keys can be from 0 to 11.
    private Double key;
    // A uniquely identifying number for the song.
    private String id;
    // Confidence value (between 0 and 1) of the mode estimation.
    private Double mode_Confidence;
    // Name of the song.
    private Integer title;
    // Time signature of the song, i.e. usual number of beats per bar.
    private Double time_Signature;
    // Number of tags for the artist on mbtags.
    private Double artist_Mbtags_Count;
    // Confidence value (between 0 and 1) associated with each bar.
    private Double bars_Confidence;
    // Average confidence interval of the beats.
    private Double beats_Confidence;
    // Confidence value (between 0 and 1) of the key estimation.
    private Double key_Confidence;
    // Start time of the fade out, in seconds, at the end of the song.
    private Double start_Of_Fade_Out;
    
    
    /*
     * @return 
     */
    public Integer getMode() {
        return this.mode;
    }
    
    
    
    /*
     * @return 
     */
    public Double getArtist_Mbtags() {
        return this.artist_Mbtags;
    }
    
    
    
    /*
     * @return 
     */
    public Double getBeats_Start() {
        return this.beats_Start;
    }
    
    
    
    /*
     * @return 
     */
    public Double getEnd_Of_Fade_In() {
        return this.end_Of_Fade_In;
    }
    
    
    
    /*
     * @return 
     */
    public Double getHotttnesss() {
        return this.hotttnesss;
    }
    
    
    
    /*
     * @return 
     */
    public Double getBars_Start() {
        return this.bars_Start;
    }
    
    
    
    /*
     * @return 
     */
    public Double getTempo() {
        return this.tempo;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getYear() {
        return this.year;
    }
    
    
    
    /*
     * @return 
     */
    public Double getTatums_Start() {
        return this.tatums_Start;
    }
    
    
    
    /*
     * @return 
     */
    public Double getLoudness() {
        return this.loudness;
    }
    
    
    
    /*
     * @return 
     */
    public Double getTime_Signature_Confidence() {
        return this.time_Signature_Confidence;
    }
    
    
    
    /*
     * @return 
     */
    public Double getTatums_Confidence() {
        return this.tatums_Confidence;
    }
    
    
    
    /*
     * @return 
     */
    public Double getDuration() {
        return this.duration;
    }
    
    
    
    /*
     * @return 
     */
    public Double getKey() {
        return this.key;
    }
    
    
    
    /*
     * @return 
     */
    public String getId() {
        return this.id;
    }
    
    
    
    /*
     * @return 
     */
    public Double getMode_Confidence() {
        return this.mode_Confidence;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getTitle() {
        return this.title;
    }
    
    
    
    /*
     * @return 
     */
    public Double getTime_Signature() {
        return this.time_Signature;
    }
    
    
    
    /*
     * @return 
     */
    public Double getArtist_Mbtags_Count() {
        return this.artist_Mbtags_Count;
    }
    
    
    
    /*
     * @return 
     */
    public Double getBars_Confidence() {
        return this.bars_Confidence;
    }
    
    
    
    /*
     * @return 
     */
    public Double getBeats_Confidence() {
        return this.beats_Confidence;
    }
    
    
    
    /*
     * @return 
     */
    public Double getKey_Confidence() {
        return this.key_Confidence;
    }
    
    
    
    /*
     * @return 
     */
    public Double getStart_Of_Fade_Out() {
        return this.start_Of_Fade_Out;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Song.
	
	 * @return String
	 */
	public String toString() {
		return "Song[" +mode+", "+artist_Mbtags+", "+beats_Start+", "+end_Of_Fade_In+", "+hotttnesss+", "+bars_Start+", "+tempo+", "+year+", "+tatums_Start+", "+loudness+", "+time_Signature_Confidence+", "+tatums_Confidence+", "+duration+", "+key+", "+id+", "+mode_Confidence+", "+title+", "+time_Signature+", "+artist_Mbtags_Count+", "+bars_Confidence+", "+beats_Confidence+", "+key_Confidence+", "+start_Of_Fade_Out+"]";
	}
	
	/**
	 * Internal constructor to create a Song from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Song(JSONObject json_data) {
        //System.out.println(json_data);
        
        try {
            // mode
            this.mode = ((Number)json_data.get("mode")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Song; the field mode was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Song; the field mode had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // artist_mbtags
            this.artist_Mbtags = ((Number)json_data.get("artist_mbtags")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Song; the field artist_Mbtags was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Song; the field artist_Mbtags had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // beats_start
            this.beats_Start = ((Number)json_data.get("beats_start")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Song; the field beats_Start was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Song; the field beats_Start had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // end_of_fade_in
            this.end_Of_Fade_In = ((Number)json_data.get("end_of_fade_in")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Song; the field end_Of_Fade_In was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Song; the field end_Of_Fade_In had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // hotttnesss
            this.hotttnesss = ((Number)json_data.get("hotttnesss")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Song; the field hotttnesss was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Song; the field hotttnesss had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // bars_start
            this.bars_Start = ((Number)json_data.get("bars_start")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Song; the field bars_Start was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Song; the field bars_Start had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // tempo
            this.tempo = ((Number)json_data.get("tempo")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Song; the field tempo was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Song; the field tempo had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // year
            this.year = ((Number)json_data.get("year")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Song; the field year was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Song; the field year had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // tatums_start
            this.tatums_Start = ((Number)json_data.get("tatums_start")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Song; the field tatums_Start was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Song; the field tatums_Start had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // loudness
            this.loudness = ((Number)json_data.get("loudness")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Song; the field loudness was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Song; the field loudness had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // time_signature_confidence
            this.time_Signature_Confidence = ((Number)json_data.get("time_signature_confidence")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Song; the field time_Signature_Confidence was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Song; the field time_Signature_Confidence had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // tatums_confidence
            this.tatums_Confidence = ((Number)json_data.get("tatums_confidence")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Song; the field tatums_Confidence was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Song; the field tatums_Confidence had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // duration
            this.duration = ((Number)json_data.get("duration")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Song; the field duration was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Song; the field duration had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // key
            this.key = ((Number)json_data.get("key")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Song; the field key was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Song; the field key had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // id
            this.id = (String)json_data.get("id");
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Song; the field id was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Song; the field id had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // mode_confidence
            this.mode_Confidence = ((Number)json_data.get("mode_confidence")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Song; the field mode_Confidence was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Song; the field mode_Confidence had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // title
            this.title = ((Number)json_data.get("title")).intValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Song; the field title was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Song; the field title had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // time_signature
            this.time_Signature = ((Number)json_data.get("time_signature")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Song; the field time_Signature was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Song; the field time_Signature had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // artist_mbtags_count
            this.artist_Mbtags_Count = ((Number)json_data.get("artist_mbtags_count")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Song; the field artist_Mbtags_Count was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Song; the field artist_Mbtags_Count had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // bars_confidence
            this.bars_Confidence = ((Number)json_data.get("bars_confidence")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Song; the field bars_Confidence was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Song; the field bars_Confidence had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // beats_confidence
            this.beats_Confidence = ((Number)json_data.get("beats_confidence")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Song; the field beats_Confidence was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Song; the field beats_Confidence had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // key_confidence
            this.key_Confidence = ((Number)json_data.get("key_confidence")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Song; the field key_Confidence was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Song; the field key_Confidence had the wrong structure.");
    		e.printStackTrace();
        }
        
        try {
            // start_of_fade_out
            this.start_Of_Fade_Out = ((Number)json_data.get("start_of_fade_out")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Song; the field start_Of_Fade_Out was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Song; the field start_Of_Fade_Out had the wrong structure.");
    		e.printStackTrace();
        }
        
	}	
}