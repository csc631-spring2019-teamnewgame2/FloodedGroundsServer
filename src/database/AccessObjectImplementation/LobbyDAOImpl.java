/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.AccessObjectImplementation;

import database.AccessObjects.LobbyDAO;
import database.DCM;
import database.Models.Lobby;
import database.Models.User;

import java.sql.*;
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

    @Override
    public boolean createLobby(Lobby lobby, User user){
        boolean success = false;
        String query = "INSERT INTO Lobby(ID, name, privacy, password, owner) VALUES(?,?,?,?,?)";
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = DCM.getDataSource().getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(2, lobby.getName());
            ps.setInt(3, lobby.getPrivacy());
            ps.setString(4, lobby.getPassword());
            ps.setInt(5, user.getID());
            ps.executeUpdate();
            ps.close();
            success = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }

    @Override
    public boolean deleteLobby(Lobby lobby, User user){
        boolean success = false;
        String query = "DELETE FROM Lobby WHERE ID = ? AND owner = ?";
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = DCM.getDataSource().getConnection();
            ps = connection.prepareStatement(query);
            ps.setInt(1, lobby.getID());
            ps.setInt(2, user.getID());
            ps.executeUpdate();
            ps.close();
            success = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }
}
