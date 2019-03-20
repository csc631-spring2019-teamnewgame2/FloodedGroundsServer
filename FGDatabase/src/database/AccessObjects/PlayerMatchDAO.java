/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.AccessObjects;

import database.Models.PlayerMatch;
import java.util.List;

/**
 *
 * @author Travis
 */
public interface PlayerMatchDAO {
    public PlayerMatch getPlayerMatchByID(int ID);
    public List<PlayerMatch> getAllPlayerMatchesByPlayerID(int ID);
}
