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
public class Match {

    private int ID;
    private int endState;
    private int endTime;

    // foreign key values
    private int monster;
    private int player1;
    private int player2;
    private int player3;

    public Match() {
    }

    public Match(int ID, int endState, int endTime,
            int monster, int player1, int player2, int player3) {
        this.ID = ID;
        this.endState = endState;
        this.endTime = endTime;
        this.monster = monster;
        this.player1 = player1;
        this.player2 = player2;
        this.player3 = player3;
    }

    public int getID() {
        return this.ID;
    }

    public int getEndState() {
        return this.endState;
    }

    public int getEndTime() {
        return this.endTime;
    }

    public int getMonster() {
        return this.monster;
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

    public int setEndState(int endState) {
        return this.endState = endState;
    }

    public int setEndTime(int endTime) {
        return this.endTime = endTime;
    }

    public int setMonster(int monster) {
        return this.monster = monster;
    }

    public int setPlayer1(int player1) {
        return this.player1 = player1;
    }

    public int setPlayer2(int player2) {
        return this.player2 = player2;
    }

    public int setPlayer3(int player3) {
        return this.player3 = player3;
    }
}
