/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.AccessObjectImplementation;

import database.AccessObjects.LobbyDAO;
import database.Models.Lobby;
import database.Models.User;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Travis
 */
public class LobbyDAOImpl implements LobbyDAO {
    @Override
    public List<Lobby> getAllLobbies(){
        return new ArrayList<>();
    }       
    @Override
    public Lobby getLobbyByID(int ID){
        return new Lobby();
    }
             
    @Override
    public Lobby getLobbyByName(String name){
        return new Lobby();
    }
    
    @Override
    public Lobby getLobbyByOwner(User owner){
        return new Lobby();
    }    
}
