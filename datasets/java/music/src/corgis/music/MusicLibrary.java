package corgis.music;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import corgis.music.domain.*;

import java.sql.*;

/**
 * This library comes from the Million Song Dataset, which used a company called the Echo Nest to derive data points about one million popular contemporary songs.  The Million Song Dataset is a collaboration between the Echo Nest and LabROSA, a laboratory working towards intelligent machine listening.  The project was also funded in part by the National Science Foundation of America (NSF) to provide a large data set to evaluate research related to algorithms on a commercial size while promoting further research into the Music Information Retrieval field.  The data contains standard information about the songs such as artist name, title, and year released.  Additionally, the data contains more advanced information; for example, the length of the song, how many musical bars long the song is, and how long the fade in to the song was.

 */
public class MusicLibrary {
    private String databasePath;
	private Connection connection;
    private JSONParser parser;
    private final int HARDWARE = 1000;
    
    public static void main(String[] args) {
        System.out.println("Testing Music");
        MusicLibrary musicLibrary = new MusicLibrary();
        
        
        System.out.println("Testing production GetSongs");
        ArrayList<Music> list_of_music_1_production = musicLibrary.getSongs(false);
        
        
        System.out.println("Testing test GetSongs");
        ArrayList<Music> list_of_music_1_test = musicLibrary.getSongs(true);
        
        
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
	public MusicLibrary() {
        this.databasePath = "music.db";
        this.connectToDatabase(this.databasePath);
	}
	
    /**
     * Create a connection to the database file, stored explicitly somewhere.
     * @param databasePath The filename of the database file.
     */
	public MusicLibrary(String databasePath) {
        this.databasePath = databasePath;
        this.connectToDatabase(this.databasePath);
	}
    
    
    
    /**
     * Gets a list of all the songs in the database.
    
     * @return a list[music]
     */
	public ArrayList<Music> getSongs() {
        return this.getSongs(true);
    }
    
    
    /**
     * Gets a list of all the songs in the database.
    
     * @return a list[music]
     */
	public ArrayList<Music> getSongs(boolean test) {
        String query;
        if (test) {
            query = String.format("SELECT data FROM music LIMIT %d", this.HARDWARE);
        } else {
            query = "SELECT data FROM music";
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
        
        ArrayList<Music> result = new ArrayList<Music>();
        try {
            while (rs.next()) {
                String raw_result = rs.getString(1);
                Music parsed = null;
                if (test) {
                    parsed = new Music(((JSONObject)this.parser.parse(raw_result)));
                    
                } else {
                    parsed = new Music(((JSONObject)this.parser.parse(raw_result)));
                    
                }
                
                result.add(parsed);
                
            }
        } catch (SQLException e) {
            System.err.println("Could not iterate through query.");
    		e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Could not convert the response from getSongs; a parser error occurred.");
    		e.printStackTrace();
        }
        return result;
	}
    
}