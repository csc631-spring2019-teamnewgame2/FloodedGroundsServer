/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.Models;

/**
 * @author Travis
 */
public class Lobby {

    private long ID;
    private String name;
    private String password;
    private int privacy;
    private boolean passwordRequired;

    // foreign key values -- move these to an array, instead
    //    private int owner;
    //    private int player1;
    //    private int player2;
    //    private int player3;

    // this is to store playerID in a easily accessible form
    private long[] players = new long[4];

    public Lobby() {
    }

    /**
     * @param ID
     * @param name
     * @param password
     * @param privacy
     * @param owner
     */
    public Lobby(long ID, String name, String password,
                 int privacy, long owner){
        this(ID, name, password, privacy, owner, 0,0,0);
    }

    public Lobby(long ID,
                 String name, String password,
                 int privacy, long owner,
                 long player1, long player2, long player3) {
        this.ID = ID;
        this.name = name;
        this.password = password;
        this.privacy = privacy;

        this.players[0] = owner;
        this.players[1] = player1;
        this.players[2] = player2;
        this.players[3] = player3;
    }

    public long getID() {
        return this.ID;
    }

    public String getName() {
        return this.name;
    }

    public String getPassword() {
        return this.password;
    }

    public int getPrivacy() {
        return this.privacy;
    }

    public long getPlayer(int playerNum) {
        long playerID = 0;
        try {
            playerID = players[playerNum];
        }catch(IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return playerID;
    }

    public long getOwner() {
        return this.players[0];
    }

    public long getPlayer1() {
        return this.players[1];
    }

    public long getPlayer2() {
        return this.players[2];
    }

    public long getPlayer3() {
        return this.players[3];
    }

    public boolean getPasswordRequired() {
        return passwordRequired;
    }

    public void setPasswordRequired(boolean passwordRequired) {
        this.passwordRequired = passwordRequired;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPrivacy(int privacy) {
        this.privacy = privacy;
    }

    /**
     * @param playerNum the player you wish to set, 0 for owner, 1-3 for others
     * @param UserID    the playerID you wish to add to the object
     * @return
     */
    public void setPlayer(int playerNum, int UserID) {
        try {
            players[playerNum] = UserID;
        }catch(IndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }

    public void setOwner(int owner) {
        players[0] = owner;
    }

    public void setPlayer1(int player) {
        players[1] = player;
    }

    public void setPlayer2(int player) {
        players[2] = player;
    }

    public void setPlayer3(int player) {
        players[4] = player;
    }
}