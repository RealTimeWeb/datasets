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
	
    private Double key;
    private Double mode_Confidence;
    private Double artist_Mbtags_Count;
    private Double key_Confidence;
    private Double tatums_Start;
    private Integer year;
    private Double duration;
    private Double hotttnesss;
    private Double beats_Start;
    private Double time_Signature_Confidence;
    private String title;
    private Double bars_Confidence;
    private String id;
    private Double bars_Start;
    private String artist_Mbtags;
    private Double start_Of_Fade_Out;
    private Double tempo;
    private Double end_Of_Fade_In;
    private Double beats_Confidence;
    private Double tatums_Confidence;
    private Integer mode;
    private Double time_Signature;
    private Double loudness;
    
    
    /*
     * @return 
     */
    public Double getKey() {
        return this.key;
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
    public Double getArtist_Mbtags_Count() {
        return this.artist_Mbtags_Count;
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
    public Double getTatums_Start() {
        return this.tatums_Start;
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
    public Double getDuration() {
        return this.duration;
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
    public Double getBeats_Start() {
        return this.beats_Start;
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
    public String getTitle() {
        return this.title;
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
    public String getId() {
        return this.id;
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
    public String getArtist_Mbtags() {
        return this.artist_Mbtags;
    }
    
    
    
    /*
     * @return 
     */
    public Double getStart_Of_Fade_Out() {
        return this.start_Of_Fade_Out;
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
    public Double getEnd_Of_Fade_In() {
        return this.end_Of_Fade_In;
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
    public Double getTatums_Confidence() {
        return this.tatums_Confidence;
    }
    
    
    
    /*
     * @return 
     */
    public Integer getMode() {
        return this.mode;
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
    public Double getLoudness() {
        return this.loudness;
    }
    
    
    
	
	/**
	 * Creates a string based representation of this Song.
	
	 * @return String
	 */
	public String toString() {
		return "Song[" +key+", "+mode_Confidence+", "+artist_Mbtags_Count+", "+key_Confidence+", "+tatums_Start+", "+year+", "+duration+", "+hotttnesss+", "+beats_Start+", "+time_Signature_Confidence+", "+title+", "+bars_Confidence+", "+id+", "+bars_Start+", "+artist_Mbtags+", "+start_Of_Fade_Out+", "+tempo+", "+end_Of_Fade_In+", "+beats_Confidence+", "+tatums_Confidence+", "+mode+", "+time_Signature+", "+loudness+"]";
	}
	
	/**
	 * Internal constructor to create a Song from a  representation.
	 * @param json_data The raw json data that will be parsed.
	 */
    public Song(JSONObject json_data) {
        try {// key
            this.key = ((Number)json_data.get("key")).doubleValue();// mode_confidence
            this.mode_Confidence = ((Number)json_data.get("mode_confidence")).doubleValue();// artist_mbtags_count
            this.artist_Mbtags_Count = ((Number)json_data.get("artist_mbtags_count")).doubleValue();// key_confidence
            this.key_Confidence = ((Number)json_data.get("key_confidence")).doubleValue();// tatums_start
            this.tatums_Start = ((Number)json_data.get("tatums_start")).doubleValue();// year
            this.year = ((Number)json_data.get("year")).intValue();// duration
            this.duration = ((Number)json_data.get("duration")).doubleValue();// hotttnesss
            this.hotttnesss = ((Number)json_data.get("hotttnesss")).doubleValue();// beats_start
            this.beats_Start = ((Number)json_data.get("beats_start")).doubleValue();// time_signature_confidence
            this.time_Signature_Confidence = ((Number)json_data.get("time_signature_confidence")).doubleValue();// title
            this.title = (String)json_data.get("title");// bars_confidence
            this.bars_Confidence = ((Number)json_data.get("bars_confidence")).doubleValue();// id
            this.id = (String)json_data.get("id");// bars_start
            this.bars_Start = ((Number)json_data.get("bars_start")).doubleValue();// artist_mbtags
            this.artist_Mbtags = (String)json_data.get("artist_mbtags");// start_of_fade_out
            this.start_Of_Fade_Out = ((Number)json_data.get("start_of_fade_out")).doubleValue();// tempo
            this.tempo = ((Number)json_data.get("tempo")).doubleValue();// end_of_fade_in
            this.end_Of_Fade_In = ((Number)json_data.get("end_of_fade_in")).doubleValue();// beats_confidence
            this.beats_Confidence = ((Number)json_data.get("beats_confidence")).doubleValue();// tatums_confidence
            this.tatums_Confidence = ((Number)json_data.get("tatums_confidence")).doubleValue();// mode
            this.mode = ((Number)json_data.get("mode")).intValue();// time_signature
            this.time_Signature = ((Number)json_data.get("time_signature")).doubleValue();// loudness
            this.loudness = ((Number)json_data.get("loudness")).doubleValue();
        } catch (NullPointerException e) {
    		System.err.println("Could not convert the response to a Song; a field was missing.");
    		e.printStackTrace();
    	} catch (ClassCastException e) {
    		System.err.println("Could not convert the response to a Song; a field had the wrong structure.");
    		e.printStackTrace();
        }
	}	
}