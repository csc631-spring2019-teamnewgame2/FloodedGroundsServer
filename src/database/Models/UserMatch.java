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
public class UserMatch {
    private int ID;
    private int role;
    private int attacksMade;
    private int attacksHit;
    private int timesDowned;
    private int aliveAtEnd;
    
    //foreign key vaules
    private int matchID;
    private int playerID;
    
    public int getID(){
        return this.ID;
    }
    
    public int getRole(){
        return this.role;
    }
    
    public int getAttacksMade(){
        return this.attacksMade;
    }
    
    public int getAttacksHit(){
        return this.attacksHit;
    }
    
    public int getTimesDowned(){
        return this.timesDowned;
    }
    
    public int getAliveAtEnd(){
        return this.aliveAtEnd;
    }
    
    public int getMatchID(){
        return this.matchID;
    }
    
    public int getPlayerID(){
        return this.playerID;
    }
    
    public int setID(int id){
        return this.ID = id;
    }
    
    public int setRole(int role){
        return this.role = role;
    }
    
    public int setAttacksMade(int attacksMade){
        return this.attacksMade = attacksMade;
    }
    
    public int setAttacksHit(int attacksHit){
        return this.attacksHit = attacksHit;
    }
    
    public int setTimesDowned(int timesDowned){
        return this.timesDowned = timesDowned;
    }
    
    public int setAliveAtEnd(int aliveAtEnd){
        return this.aliveAtEnd = aliveAtEnd;
    }
    
    public int setMatchID(int matchID){
        return this.matchID = matchID;
    }
    
    public int setPlayerID(int playerID){
        return this.playerID = playerID;
    }
}   
