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
    /**
     *
     * @param ID
     * @return
     */
    public Lobby getLobbyByID(int ID);

    /**
     *
     * @return
     */
    public List<Lobby> getAllLobbies();

    /**
     *
     * @param name
     * @return
     */
    public Lobby getLobbyByName(String name);

    /**
     *
     * @param owner
     * @return
     */
    public Lobby getLobbyByOwner(User owner);

    /**
     *
     * @param lobby
     * @param user
     * @return
     */
    public boolean createLobby(Lobby lobby, User user);

    /**
     * Adds a player to an existing lobby, returning true on success, and false on failure
     *
     * @param lobby The lobby you wish to add a player to
     * @param user  A user object representing the player to add to the lobby
     * @return true on success, false otherwise
     */
    public boolean addPlayerToLobby(Lobby lobby, User user);

    /**
     *
     * @param lobby
     * @param user
     * @return
     */
    public boolean deleteLobby(Lobby lobby, User user);
}
