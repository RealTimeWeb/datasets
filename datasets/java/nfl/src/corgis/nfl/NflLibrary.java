package corgis.nfl;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import corgis.nfl.domain.*;

import java.sql.*;

/**
 * {'overview': 'Information about NFL games and players.\n', 'short': 'Information about NFL games and players.\n'}
 */
public class NflLibrary {
    private String databasePath;
	private Connection connection;
    private JSONParser parser;
    private final int HARDWARE = 1000;
    
    public static void main(String[] args) {
        System.out.println("Testing Nfl");
        NflLibrary nflLibrary = new NflLibrary();
        
        
        System.out.println("Testing production GetGamesByHomeTeam");
        ArrayList<Game> list_of_game_1_production = nflLibrary.getGamesByHomeTeam("\"St. Louis Cardinals\"");
        
        
        
        
        System.out.println("Testing production GetGamesByAwayTeam");
        ArrayList<Game> list_of_game_2_production = nflLibrary.getGamesByAwayTeam("\"St. Louis Cardinals\"");
        
        
        
        
        System.out.println("Testing production GetGames");
        ArrayList<Game> list_of_game_3_production = nflLibrary.getGames(false);
        
        
        System.out.println("Testing test GetGames");
        ArrayList<Game> list_of_game_3_test = nflLibrary.getGames(true);
        
        
        
        System.out.println("Testing production GetPlayers");
        ArrayList<Player> list_of_player_4_production = nflLibrary.getPlayers(false);
        
        
        System.out.println("Testing test GetPlayers");
        ArrayList<Player> list_of_player_4_test = nflLibrary.getPlayers(true);
        
        
        
        System.out.println("Testing production GetPlayerByName");
        Player a_player_5_production = nflLibrary.getPlayerByName("'Ameer Abdullah'");
        
        
        
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
	public NflLibrary() {
        this.databasePath = "nfl.db";
        this.connectToDatabase(this.databasePath);
	}
	
    /**
     * Create a connection to the database file, stored explicitly somewhere.
     * @param databasePath The filename of the database file.
     */
	public NflLibrary(String databasePath) {
        this.databasePath = databasePath;
        this.connectToDatabase(this.databasePath);
	}
    
    
    
    
    /**
     * Returns information about a single football game.
    
     * @param home_Team The name of the football team (e.g., "St. Louis Cardinals")
     * @return a list[game]
     */
	public ArrayList<Game> getGamesByHomeTeam(String home_Team) {
        String query;
        boolean test = false;
        if (test) {
            query = String.format("", this.HARDWARE);
        } else {
            query = "SELECT data from games WHERE home_team=? COLLATE NOCASE";
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
            preparedQuery.setString(1, home_Team);
        } catch (SQLException e) {
            System.err.println("Could not build prepare argument: home_team");
    		e.printStackTrace();
        }
        try {
            rs = preparedQuery.executeQuery();
        } catch (SQLException e) {
            System.err.println("Could not execute query.");
    		e.printStackTrace();
        }
        
        ArrayList<Game> result = new ArrayList<Game>();
        try {
            while (rs.next()) {
                String raw_result = rs.getString(1);
                Game parsed = null;
                if (test) {
                    
                } else {
                    parsed = new Games((JSONObject)this.parser.parse(raw_result));
                    
                }
                
                result.add(parsed);
                
            }
        } catch (SQLException e) {
            System.err.println("Could not iterate through query.");
    		e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Could not convert the response from getGamesByHomeTeam; a parser error occurred.");
    		e.printStackTrace();
        }
        return result;
	}
    
    
    
    /**
     * Returns information about a single football game.
    
     * @param away_Team The name of the football team (e.g., "St. Louis Cardinals")
     * @return a list[game]
     */
	public ArrayList<Game> getGamesByAwayTeam(String away_Team) {
        String query;
        boolean test = false;
        if (test) {
            query = String.format("", this.HARDWARE);
        } else {
            query = "SELECT data from games WHERE away_team=? COLLATE NOCASE";
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
            preparedQuery.setString(1, away_Team);
        } catch (SQLException e) {
            System.err.println("Could not build prepare argument: away_team");
    		e.printStackTrace();
        }
        try {
            rs = preparedQuery.executeQuery();
        } catch (SQLException e) {
            System.err.println("Could not execute query.");
    		e.printStackTrace();
        }
        
        ArrayList<Game> result = new ArrayList<Game>();
        try {
            while (rs.next()) {
                String raw_result = rs.getString(1);
                Game parsed = null;
                if (test) {
                    
                } else {
                    parsed = new Games((JSONObject)this.parser.parse(raw_result));
                    
                }
                
                result.add(parsed);
                
            }
        } catch (SQLException e) {
            System.err.println("Could not iterate through query.");
    		e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Could not convert the response from getGamesByAwayTeam; a parser error occurred.");
    		e.printStackTrace();
        }
        return result;
	}
    
    
    /**
     * Returns information about a single football game.
    
     * @return a list[game]
     */
	public ArrayList<Game> getGames() {
        return this.getGames(true);
    }
    
    
    /**
     * Returns information about a single football game.
    
     * @return a list[game]
     */
	public ArrayList<Game> getGames(boolean test) {
        String query;
        if (test) {
            query = String.format("SELECT data from games LIMIT %d", this.HARDWARE);
        } else {
            query = "SELECT data FROM games";
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
        
        ArrayList<Game> result = new ArrayList<Game>();
        try {
            while (rs.next()) {
                String raw_result = rs.getString(1);
                Game parsed = null;
                if (test) {
                    parsed = new Games((JSONObject)this.parser.parse(raw_result));
                    
                } else {
                    parsed = new Games((JSONObject)this.parser.parse(raw_result));
                    
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
    
    
    /**
     * Returns information about all the football players.
    
     * @return a list[player]
     */
	public ArrayList<Player> getPlayers() {
        return this.getPlayers(true);
    }
    
    
    /**
     * Returns information about all the football players.
    
     * @return a list[player]
     */
	public ArrayList<Player> getPlayers(boolean test) {
        String query;
        if (test) {
            query = String.format("SELECT data from players LIMIT %d", this.HARDWARE);
        } else {
            query = "SELECT data FROM players";
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
        
        ArrayList<Player> result = new ArrayList<Player>();
        try {
            while (rs.next()) {
                String raw_result = rs.getString(1);
                Player parsed = null;
                if (test) {
                    parsed = new Games((JSONObject)this.parser.parse(raw_result));
                    
                } else {
                    parsed = new Games((JSONObject)this.parser.parse(raw_result));
                    
                }
                
                result.add(parsed);
                
            }
        } catch (SQLException e) {
            System.err.println("Could not iterate through query.");
    		e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Could not convert the response from getPlayers; a parser error occurred.");
    		e.printStackTrace();
        }
        return result;
	}
    
    
    
    /**
     * Returns information about a single football player
    
     * @param name The name of the player (e.g., "Ameer Abdullah")
     * @return a player
     */
	public Player getPlayerByName(String name) {
        String query;
        boolean test = false;
        if (test) {
            query = String.format("", this.HARDWARE);
        } else {
            query = "SELECT data FROM players WHERE name=? COLLATE NOCASE LIMIT 1";
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
            preparedQuery.setString(1, name);
        } catch (SQLException e) {
            System.err.println("Could not build prepare argument: name");
    		e.printStackTrace();
        }
        try {
            rs = preparedQuery.executeQuery();
        } catch (SQLException e) {
            System.err.println("Could not execute query.");
    		e.printStackTrace();
        }
        
        Player result = null;
        try {
            while (rs.next()) {
                String raw_result = rs.getString(1);
                Player parsed = null;
                if (test) {
                    
                } else {
                    parsed = new Games((JSONObject)this.parser.parse(raw_result));
                    
                }
                
                result = parsed;
                
            }
        } catch (SQLException e) {
            System.err.println("Could not iterate through query.");
    		e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Could not convert the response from getPlayerByName; a parser error occurred.");
    		e.printStackTrace();
        }
        return result;
	}
    
}