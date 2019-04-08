/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.Models;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Travis
 */
public class Lobby {

    private int ID;
    private String name;
    private String password;
    private int privacy;

    // foreign key values -- move these to an array, instead
    //    private int owner;
    //    private int player1;
    //    private int player2;
    //    private int player3;

    // this is to store playerID in a easily accessible form
    private int[] players = new int[4];

    public Lobby() {
    }

    /**
     * @param ID
     * @param name
     * @param password
     * @param privacy
     * @param owner
     */
    public Lobby(int ID, String name, String password,
                 int privacy, int owner){
        this(ID, name, password, privacy, owner, 0,0,0);
    }

    public Lobby(int ID,
                 String name, String password,
                 int privacy, int owner,
                 int player1, int player2, int player3) {
        this.ID = ID;
        this.name = name;
        this.password = password;
        this.privacy = privacy;

        this.players[0] = owner;
        this.players[1] = player1;
        this.players[2] = player2;
        this.players[3] = player3;
    }

    public int getID() {
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

    public int getPlayer(int playerNum) {
        int playerID = 0;
        try {
            playerID = players[playerNum];
        }catch(IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return playerID;
    }

    public int getOwner() {
        return this.players[0];
    }

    public int getPlayer1() {
        return this.players[1];
    }

    public int getPlayer2() {
        return this.players[2];
    }

    public int getPlayer3() {
        return this.players[3];
    }

    public int setID(int ID) {
        return this.ID = ID;
    }

    public String setName(String name) {
        return this.name = name;
    }

    public String setPassword(String password) {
        return this.password = password;
    }

    public int setPrivacy(int privacy) {
        return this.privacy = privacy;
    }

    /**
     * @param playerNum the player you wish to set, 0 for owner, 1-3 for others
     * @param UserID    the playerID you wish to add to the object
     * @return
     */
    public int setPlayer(int playerNum, int UserID) throws IndexOutOfBoundsException {
        try {
            players[playerNum] = UserID;
        }catch(IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return playerNum;
    }

    public int setOwner(int owner) {
        players[0] = owner;
        return this.players[0];
    }

    public int setPlayer1(int player) {
        players[1] = player;
        return this.players[1];
    }

    public int setPlayer2(int player) {
        players[2] = player;
        return this.players[2];
    }

    public int setPlayer3(int player) {
        players[4] = player;
        return this.players[3];
    }
}