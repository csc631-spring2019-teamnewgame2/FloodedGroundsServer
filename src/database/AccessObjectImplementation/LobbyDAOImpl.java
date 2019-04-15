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
 * @author Travis
 */
public class LobbyDAOImpl implements LobbyDAO {
    @Override
    public List<Lobby> getAllLobbies() {
        String query = "SELECT * FROM lobby";

        List<Lobby> lobbyList = new ArrayList<>();
        Lobby lobby = null;
        ResultSet rs = null;
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = DCM.getDataSource().getConnection();
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                int ID = rs.getInt("ID");
                String name = rs.getString("name");
                String password = rs.getString("password");
                int privacy = rs.getInt("privacy");
                int owner = rs.getInt("owner");
                int player1 = rs.getInt("player1");
                int player2 = rs.getInt("player2");
                int player3 = rs.getInt("player3");
                lobby = new Lobby(ID, name, password, privacy, owner, player1, player2, player3);
                lobbyList.add(lobby);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lobbyList;
    }

    @Override
    public Lobby getLobbyByID(int ID) {
        String query = "SELECT * FROM lobby WHERE ID = ?";

        Lobby lobby = null;
        ResultSet rs = null;
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = DCM.getDataSource().getConnection();
            ps = connection.prepareStatement(query);
            ps.setInt(1, ID);
            rs = ps.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String password = rs.getString("password");
                int privacy = rs.getInt("privacy");
                int owner = rs.getInt("owner");
                int player1 = rs.getInt("player1");
                int player2 = rs.getInt("player2");
                int player3 = rs.getInt("player3");
                lobby = new Lobby(ID, name, password, privacy,
                        owner, player1, player2, player3);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lobby;
    }

    @Override
    public Lobby getLobbyByName(String name) {
        String query = "SELECT * FROM lobby WHERE name = ?";

        Lobby lobby = null;
        ResultSet rs = null;
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = DCM.getDataSource().getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, name);
            rs = ps.executeQuery();

            while (rs.next()) {
                int ID = rs.getInt("ID");

                String password = rs.getString("password");
                int privacy = rs.getInt("privacy");
                int owner = rs.getInt("owner");
                int player1 = rs.getInt("player1");
                int player2 = rs.getInt("player2");
                int player3 = rs.getInt("player3");
                lobby = new Lobby(ID, name, password, privacy, owner, player1, player2, player3);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lobby;
    }

    @Override
    public Lobby getLobbyByOwner(User owner) {
        String query = "SELECT * FROM lobby WHERE owner = ?";

        Lobby lobby = null;
        ResultSet rs = null;
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = DCM.getDataSource().getConnection();
            ps = connection.prepareStatement(query);
            ps.setLong(1, owner.getID());

            rs = ps.executeQuery();

            while (rs.next()) {
                int ID = rs.getInt("ID");
                String name = rs.getString("name");
                String password = rs.getString("password");
                int privacy = rs.getInt("privacy");
                long player1 = rs.getLong("player1");
                long player2 = rs.getLong("player2");
                long player3 = rs.getLong("player3");
                lobby = new Lobby(ID, name, password, privacy, owner.getID(), player1, player2, player3);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lobby;
    }

    @Override
    public boolean createLobby(Lobby lobby, User user) {
        boolean success = false;
        String query = "INSERT INTO Lobby(ID, name, privacy, password, owner) VALUES(?,?,?,?,?)";

        try {
            Connection connection = DCM.getDataSource().getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setLong(1, lobby.getID());
            ps.setString(2, lobby.getName());
            ps.setInt(3, lobby.getPrivacy());
            ps.setString(4, lobby.getPassword());
            ps.setLong(5, user.getID());
            ps.executeUpdate();
            ps.close();
            success = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }

    @Override
    public boolean addPlayerToLobby(Lobby lobby, User user) {
        boolean success = false;
        int playerNum = 0;
        String query = "";
        for (int i = 1; i < 4; i++) {
            if (lobby.getPlayer(i) == 0) {
                query = "UPDATE Lobby SET `player" + i + "` = ? WHERE `ID` = ?";
                success = true;
                break;
            }
        }

        if (success) {
            success = false;
            ResultSet rs = null;
            Connection connection = null;
            PreparedStatement ps = null;

            try {
                connection = DCM.getDataSource().getConnection();
                ps = connection.prepareStatement(query);
                ps.setLong(1, user.getID());
                ps.setInt(2, lobby.getID());
                ps.executeUpdate();
                ps.close();
                success = true;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return success;
    }

    @Override
    public boolean deleteLobby(Lobby lobby, User user) {
        boolean success = false;
        String query = "DELETE FROM Lobby WHERE ID = ? AND owner = ?";
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = DCM.getDataSource().getConnection();
            ps = connection.prepareStatement(query);
            ps.setInt(1, lobby.getID());
            ps.setLong(2, user.getID());
            ps.executeUpdate();
            ps.close();
            success = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }
}
