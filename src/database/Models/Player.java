package database.Models;

// Other Imports
import core.GameClient;
import metadata.Constants;

import java.util.ArrayList;
import java.util.Random;

/**
 * The Player class holds important information about the player including, most
 * importantly, the account. Such information includes the username, password,
 * email, and the player ID.
 */
public class Player {
    //A list of all of the players
    private static ArrayList<Player> players;
    //List of characters that a new client can take.
    private static ArrayList<String> availableCharacters;
    //The next id to be assigned to a player
    private static int id = 0;

    private int player_id;
    private String username;
    private String password;
    private String character;
    private GameClient client; // References GameClient instance

    //On startup, populate the vector with the possible characters
    static
    {
        players = new ArrayList<>();
        availableCharacters = new ArrayList<>(Constants.characters.keySet());
    }

    //Create a new player id
    public static int generatePlayerID()
    {
        id++;
        return id;
    }

    public static void removePlayer(Player player)
    {
        //Add the character a client was playing back when they disconnect
        availableCharacters.add(player.character);

        //Remove them from the player list
        players.remove(player);
    }

    public static ArrayList<Player> getPlayers()
    {
        return players;
    }

    public Player(int player_id) {
        this.player_id = player_id;
        //Add itself to the player list
        players.add(this);
    }

    public Player(int player_id, String username, String password) {
        this.player_id = player_id;
        this.username = username;
        this.password = password;

        //Choose a random character and assign it to this player
        Random rand = new Random();
        int randomIndex = rand.nextInt(availableCharacters.size());
        this.character = availableCharacters.get(randomIndex);
        availableCharacters.remove(randomIndex);

        //Add itself to the player list
        players.add(this);
    }

    public int getID() {
        return player_id;
    }

    public int setID(int player_id) {
        return this.player_id = player_id;
    }

    public String getPassword() {
        return password;
    }

    public String setPassword(String password) {
        return this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String setUsername(String username) {
        return this.username = username;
    }

    public GameClient getClient() {
        return client;
    }

    public GameClient setClient(GameClient client) {
        return this.client = client;
    }

    public String getCharacter() {
        return character;
    }

    @Override
    public String toString() {
        return "Player{" +
                "player_id=" + player_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
