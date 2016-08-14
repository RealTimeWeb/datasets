package corgis.baseball;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import corgis.baseball.domain.*;

import java.sql.*;

/**
 * {'overview': 'This database contains pitching, hitting, and fielding statistics for Major League Baseball from 1871 through 2012. It includes data from the two current leagues (American and National), the four other major leagues (American Association, Union Association, Players League, and Federal League), and the National Association of 1871-1875.\nThis database was created by Sean Lahman, who pioneered the effort to make baseball statistics freely available to the general public. What started as a one man effort in 1994 has grown tremendously, and now a team of researchers have collected their efforts to make this the largest and most accurate source for baseball statistics available anywhere. (See Acknowledgements below for a list of the key contributors to this project.)\nNone of what we have done would have been possible without the pioneering work of Hy Turkin, S.C. Thompson, David Neft, and Pete Palmer (among others). All baseball fans owe a debt of gratitude to the people who have worked so hard to build the tremendous set of data that we have today. Our thanks also to the many members of the Society for American Baseball Research who have helped us over the years. We strongly urge you to support and join their efforts. Please vist their website (www.sabr.org).\n', 'short': 'This database contains pitching, hitting, and fielding statistics for Major League Baseball from 1871 through 2012. It includes data from the two current leagues (American and National), the four other major leagues (American Association, Union Assoc'}
 */
public class BaseballLibrary {
    private String databasePath;
	private Connection connection;
    private JSONParser parser;
    private final int HARDWARE = 1000;
    
    public static void main(String[] args) {
        System.out.println("Testing Baseball");
        BaseballLibrary baseballLibrary = new BaseballLibrary();
        
        
        System.out.println("Testing production GetPlayerByName");
        Player a_player_1_production = baseballLibrary.getPlayerByName("'Jon Edward Zuber'");
        
        
        
        
        System.out.println("Testing production GetPlayers");
        ArrayList<Player> list_of_player_2_production = baseballLibrary.getPlayers(false);
        
        
        System.out.println("Testing test GetPlayers");
        ArrayList<Player> list_of_player_2_test = baseballLibrary.getPlayers(true);
        
        
        
        System.out.println("Testing production GetTeamByName");
        Team a_team_3_production = baseballLibrary.getTeamByName("'Philadelphia Phillies'");
        
        
        
        
        System.out.println("Testing production GetTeams");
        ArrayList<Team> list_of_team_4_production = baseballLibrary.getTeams(false);
        
        
        System.out.println("Testing test GetTeams");
        ArrayList<Team> list_of_team_4_test = baseballLibrary.getTeams(true);
        
        
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
	public BaseballLibrary() {
        this.databasePath = "baseball.db";
        this.connectToDatabase(this.databasePath);
	}
	
    /**
     * Create a connection to the database file, stored explicitly somewhere.
     * @param databasePath The filename of the database file.
     */
	public BaseballLibrary(String databasePath) {
        this.databasePath = databasePath;
        this.connectToDatabase(this.databasePath);
	}
    
    
    
    
    /**
     * Returns information about a single player
    
     * @param name The name of the player.
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
                    parsed = new Teams((JSONObject)this.parser.parse(raw_result));
                    
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
    
    
    /**
     * Returns information about all the players.
    
     * @return a list[player]
     */
	public ArrayList<Player> getPlayers() {
        return this.getPlayers(true);
    }
    
    
    /**
     * Returns information about all the players.
    
     * @return a list[player]
     */
	public ArrayList<Player> getPlayers(boolean test) {
        String query;
        if (test) {
            query = String.format("SELECT data FROM players LIMIT %d", this.HARDWARE);
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
                    parsed = new Teams((JSONObject)this.parser.parse(raw_result));
                    
                } else {
                    parsed = new Teams((JSONObject)this.parser.parse(raw_result));
                    
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
     * Returns information about a single team
    
     * @param name The name of the team.
     * @return a team
     */
	public Team getTeamByName(String name) {
        String query;
        boolean test = false;
        if (test) {
            query = String.format("", this.HARDWARE);
        } else {
            query = "SELECT data FROM teams WHERE name=? COLLATE NOCASE LIMIT 1";
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
        
        Team result = null;
        try {
            while (rs.next()) {
                String raw_result = rs.getString(1);
                Team parsed = null;
                if (test) {
                    
                } else {
                    parsed = new Teams((JSONObject)this.parser.parse(raw_result));
                    
                }
                
                result = parsed;
                
            }
        } catch (SQLException e) {
            System.err.println("Could not iterate through query.");
    		e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Could not convert the response from getTeamByName; a parser error occurred.");
    		e.printStackTrace();
        }
        return result;
	}
    
    
    /**
     * Returns information about all the teams.
    
     * @return a list[team]
     */
	public ArrayList<Team> getTeams() {
        return this.getTeams(true);
    }
    
    
    /**
     * Returns information about all the teams.
    
     * @return a list[team]
     */
	public ArrayList<Team> getTeams(boolean test) {
        String query;
        if (test) {
            query = String.format("SELECT data FROM teams LIMIT %d", this.HARDWARE);
        } else {
            query = "SELECT data FROM teams";
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
        
        ArrayList<Team> result = new ArrayList<Team>();
        try {
            while (rs.next()) {
                String raw_result = rs.getString(1);
                Team parsed = null;
                if (test) {
                    parsed = new Teams((JSONObject)this.parser.parse(raw_result));
                    
                } else {
                    parsed = new Teams((JSONObject)this.parser.parse(raw_result));
                    
                }
                
                result.add(parsed);
                
            }
        } catch (SQLException e) {
            System.err.println("Could not iterate through query.");
    		e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Could not convert the response from getTeams; a parser error occurred.");
    		e.printStackTrace();
        }
        return result;
	}
    
}