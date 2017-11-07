package corgis.video_games;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import corgis.video_games.domain.*;

import java.sql.*;

/**
 * <i>This dataset requires special permission to use.</i><br><br>
Originally collected by Dr. Joe Cox, this dataset has information about the sales and playtime of over a thousand video games released between 2004 and 2010. The playtime information was collected from crowd-sourced data on "How Long to Beat".<br><br>
Some more information can be found <a href="https://researchportal.port.ac.uk/portal/en/publications/what-makes-a-blockbuster-video-game(a6d848fe-38ae-4584-8c95-a0f735ec9b4c).html">here</a>.

 */
public class VideoGamesLibrary {
    private String databasePath;
	private Connection connection;
    private JSONParser parser;
    private final int HARDWARE = 1000;
    
    public static void main(String[] args) {
        System.out.println("Testing VideoGames");
        VideoGamesLibrary videoGamesLibrary = new VideoGamesLibrary();
        
        
        System.out.println("Testing production GetGames");
        ArrayList<VideoGames> list_of_video_games_1_production = videoGamesLibrary.getGames(false);
        
        
        System.out.println("Testing test GetGames");
        ArrayList<VideoGames> list_of_video_games_1_test = videoGamesLibrary.getGames(true);
        
        
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
	public VideoGamesLibrary() {
        this.databasePath = "video_games.db";
        this.connectToDatabase(this.databasePath);
	}
	
    /**
     * Create a connection to the database file, stored explicitly somewhere.
     * @param databasePath The filename of the database file.
     */
	public VideoGamesLibrary(String databasePath) {
        this.databasePath = databasePath;
        this.connectToDatabase(this.databasePath);
	}
    
    
    
    /**
     * Returns information about all the games
    
     * @return a list[video games]
     */
	public ArrayList<VideoGames> getGames() {
        return this.getGames(true);
    }
    
    
    /**
     * Returns information about all the games
    
     * @return a list[video games]
     */
	public ArrayList<VideoGames> getGames(boolean test) {
        String query;
        if (test) {
            query = String.format("SELECT data FROM video_games LIMIT %d", this.HARDWARE);
        } else {
            query = "SELECT data FROM video_games";
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
        
        ArrayList<VideoGames> result = new ArrayList<VideoGames>();
        try {
            while (rs.next()) {
                String raw_result = rs.getString(1);
                VideoGames parsed = null;
                if (test) {
                    parsed = new VideoGame(((JSONObject)this.parser.parse(raw_result)));
                    
                } else {
                    parsed = new VideoGame(((JSONObject)this.parser.parse(raw_result)));
                    
                }
                
                result.add(parsed);
                
            }
        } catch (SQLException e) {
            System.err.println("Could not iterate through query.");
    		e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Could not convert the response from getGames; a parser error occurred.");
    		e.printStackTrace();
        }
        return result;
	}
    
}