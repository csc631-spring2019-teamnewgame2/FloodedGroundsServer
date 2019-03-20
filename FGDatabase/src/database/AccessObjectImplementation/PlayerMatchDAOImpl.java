/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.AccessObjectImplementation;

import database.AccessObjects.PlayerMatchDAO;
import database.Models.PlayerMatch;
import java.util.ArrayList;
import java.util.List;




/**
 *
 * @author Travis
 */
public class PlayerMatchDAOImpl implements PlayerMatchDAO {
    @Override
    public PlayerMatch getPlayerMatchByID(int ID){
        return new PlayerMatch();
    }
    
    @Override
    public List<PlayerMatch> getAllPlayerMatchesByPlayerID(int ID){
        return new ArrayList<>();
    }
}
