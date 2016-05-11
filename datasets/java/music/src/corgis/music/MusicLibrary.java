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
 * {'overview': 'The Music library has data about a multitude of songs and artists.\n', 'short': 'The Music library has data about a multitude of songs and artists.'}
 */
public class MusicLibrary {
    private String databasePath;
	private Connection connection;
    private JSONParser parser;
    private final int HARDWARE = 1000;
    
    public static void main(String[] args) {
        System.out.println("Testing Music");
        MusicLibrary musicLibrary = new MusicLibrary();
        
        
        System.out.println("Testing production GetSongByName");
        Music a_music_1_production = musicLibrary.getSongByName("I Didn't Mean To");
        System.out.println(a_music_1_production); 
        
        
        
        System.out.println("Testing production GetSongsByArtist");
        ArrayList<Music> list_of_music_2_production = musicLibrary.getSongsByArtist("Aerosmith", false);
        
        
        System.out.println("Testing test GetSongsByArtist");
        ArrayList<Music> list_of_music_2_test = musicLibrary.getSongsByArtist("Aerosmith", true);
        
        
        
        System.out.println("Testing production GetSongs");
        ArrayList<Music> list_of_music_3_production = musicLibrary.getSongs(false);
        
        
        System.out.println("Testing test GetSongs");
        ArrayList<Music> list_of_music_3_test = musicLibrary.getSongs(true);
        
        
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
     * Given the title of a song, returns information about the song.
    
     * @param title The title of the song.
     * @return a music
     */
	public Music getSongByName(String title) {
        String query;
        boolean test = false;
        if (test) {
            query = String.format("", this.HARDWARE);
        } else {
            query = "SELECT data FROM music WHERE title=? LIMIT 1";
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
            preparedQuery.setString(1, title);
        } catch (SQLException e) {
            System.err.println("Could not build prepare argument: title");
    		e.printStackTrace();
        }
        try {
            rs = preparedQuery.executeQuery();
        } catch (SQLException e) {
            System.err.println("Could not execute query.");
    		e.printStackTrace();
        }
        
        Music result = null;
        try {
            while (rs.next()) {
                String raw_result = rs.getString(1);
                Music parsed = null;
                if (test) {
                    
                } else {
                    parsed = new Music((JSONObject)this.parser.parse(raw_result));
                    
                }
                
                result = parsed;
                
            }
        } catch (SQLException e) {
            System.err.println("Could not iterate through query.");
    		e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Could not convert the response from getSongByName; a parser error occurred.");
    		e.printStackTrace();
        }
        return result;
	}
    
    
    /**
     * Given the name of an artist, returns all the songs by that artist in the database.
    
     * @param artist The name of the artist or band.
     * @return a list[music]
     */
	public ArrayList<Music> getSongsByArtist(String artist) {
        return this.getSongsByArtist(artist, true);
    }
    
    
    /**
     * Given the name of an artist, returns all the songs by that artist in the database.
    
     * @param artist The name of the artist or band.
     * @return a list[music]
     */
	public ArrayList<Music> getSongsByArtist(String artist, boolean test) {
        String query;
        if (test) {
            query = String.format("SELECT data FROM music WHERE artist=? LIMIT %d", this.HARDWARE);
        } else {
            query = "SELECT data FROM music WHERE artist=?";
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
            preparedQuery.setString(1, artist);
        } catch (SQLException e) {
            System.err.println("Could not build prepare argument: artist");
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
                    parsed = new Music((JSONObject)this.parser.parse(raw_result));
                    
                } else {
                    parsed = new Music((JSONObject)this.parser.parse(raw_result));
                    
                }
                
                result.add(parsed);
                
            }
        } catch (SQLException e) {
            System.err.println("Could not iterate through query.");
    		e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Could not convert the response from getSongsByArtist; a parser error occurred.");
    		e.printStackTrace();
        }
        return result;
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
                    parsed = new Music((JSONObject)this.parser.parse(raw_result));
                    
                } else {
                    parsed = new Music((JSONObject)this.parser.parse(raw_result));
                    
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