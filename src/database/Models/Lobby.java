/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.Models;

/**
 *
 * @author Travis
 */
public class Lobby {

    private int ID;
    private String name;
    private String password;
    private int privacy;
    
    // foreign key values
    private int owner;
    private int player1;
    private int player2;
    private int player3;

    public Lobby() {
    }

    public Lobby(int ID,
            String name, String password,
            int privacy, int owner,
            int player1, int player2, int player3) {
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

    public int getOwner() {
        return this.owner;
    }

    public int getPlayer1() {
        return this.player1;
    }

    public int getPlayer2() {
        return this.player2;
    }

    public int getPlayer3() {
        return this.player3;
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

    public int setOwner(int owner) {
        return this.owner = owner;
    }

    public int setPlayer1(int player) {
        return this.player1 = player;
    }

    public int setPlayer2(int player) {
        return this.player2 = player;
    }

    public int setPlayer3(int player) {
        return this.player3 = player;
    }

}
