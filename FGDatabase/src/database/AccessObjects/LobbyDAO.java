/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.AccessObjects;

import database.Models.Lobby;
import database.Models.User;
import java.util.List;

/**
 *
 * @author Travis
 */
public interface LobbyDAO {
    public Lobby getLobbyByID(int ID);
    public List<Lobby> getAllLobbies();
    public Lobby getLobbyByName(String name);
    public Lobby getLobbyByOwner(User owner);
}
