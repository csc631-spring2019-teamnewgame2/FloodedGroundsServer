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
    private Timestamp joinDate;
    private Timestamp lastLogin;
    private int gamesPlayed;
    private int wins;
    private int losses;

    public User() {
    }

    public User(int ID,
            String userName, String email, String password,
            Timestamp joinDate, Timestamp lastLogin,
            int gamesPlayed, int wins, int losses) {
        this.ID = ID;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.joinDate = joinDate;
        this.lastLogin = lastLogin;
        this.gamesPlayed = gamesPlayed;
        this.wins = wins;
        this.losses = losses;
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

    public Timestamp getJoinDate() {
        return this.joinDate;
    }

    public Timestamp getLasLogin() {
        return this.lastLogin;
    }

    public int getGamesPlayed() {
        return this.gamesPlayed;
    }

    public int getWins() {
        return this.wins;
    }

    public int getLosses() {
        return this.losses;
    }

    public int setID(int id) {
        return this.ID = id;
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

    public Timestamp setJoinDate(Timestamp joinDate) {
        return this.joinDate = joinDate;
    }

    public Timestamp setLasLogin(Timestamp lastLogin) {
        return this.lastLogin = lastLogin;
    }

    public int setGamesPlayed(int gamesPlayed) {
        return this.gamesPlayed = gamesPlayed;
    }

    public int setWins(int wins) {
        return this.wins = wins;
    }

    public int setLosses(int losses) {
        return this.losses = losses;
    }
}
