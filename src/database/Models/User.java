/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.Models;

import java.sql.*;

/**
 *
 * @author Travis
 */
public class User {

    private int ID;
    private String userName;
    private String email;
    private String password;
    private Timestamp joined;
    private Timestamp lastOnline;
    private int played;
    private int won;
    private int lost;

    public User() {
    }

    public User(String userName, String email, String password){
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public User(int ID,
                String userName, String email, String password,
                Timestamp joined, Timestamp lastOnline,
                int played, int won, int lost) {
        this.ID = ID;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.joined = joined;
        this.lastOnline = lastOnline;
        this.played = played;
        this.won = won;
        this.lost = lost;
    }

    public int getID() {
        return this.ID;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public Timestamp getJoined() {
        return this.joined;
    }

    public Timestamp getLasLogin() {
        return this.lastOnline;
    }

    public int getPlayed() {
        return this.played;
    }

    public int getWon() {
        return this.won;
    }

    public int getLost() {
        return this.lost;
    }

    public int setID(int ID) {
        return this.ID = ID;
    }

    public String setUserName(String userName) {
        return this.userName = userName;
    }

    public String setEmail(String email) {
        return this.email = email;
    }

    public String setPassword(String password) {
        return this.password = password;
    }

    public Timestamp setJoined(Timestamp joined) {
        return this.joined = joined;
    }

    public Timestamp setLastOnline(Timestamp lastOnline) {
        return this.lastOnline = lastOnline;
    }

    public int setPlayed(int played) {
        return this.played = played;
    }

    public int setWon(int won) {
        return this.won = won;
    }

    public int setLost(int lost) {
        return this.lost = lost;
    }
}
