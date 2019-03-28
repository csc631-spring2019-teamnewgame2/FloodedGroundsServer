/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.AccessObjectImplementation;

import database.AccessObjects.UserDAO;
import database.DCM;
import database.Models.User;

import java.sql.*;
import java.time.LocalDateTime;

/**
 * @author Travis
 */
public class UserDAOImpl implements UserDAO {

    @Override
    public User getUserByID(int ID) {
        String query = "SELECT * FROM users WHERE ID = ?";

        User user = null;
        ResultSet rs = null;
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = DCM.getDataSource().getConnection();
            ps = connection.prepareStatement(query);
            ps.setInt(1, ID);

            rs = ps.executeQuery();

            while (rs.next()) {
                ID = rs.getInt("ID");
                String username = rs.getString("username");
                String email = rs.getString("email");
                String password = "";
                Timestamp joined = rs.getTimestamp("joined");
                Timestamp lastOnline = rs.getTimestamp("joined");
                int played = rs.getInt("played");
                int won = rs.getInt("won");
                int lost = rs.getInt("lost");
                user = new User(ID, username, email, password, joined, lastOnline, played, won, lost);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User validateUserCredentials(String loginName, String password) {
        String query = "SELECT * FROM users WHERE (username = ? OR email = ?) AND password = ?";

        User user = null;
        ResultSet rs = null;
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = DCM.getDataSource().getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, loginName);
            ps.setString(2, loginName);
            ps.setString(3, password);

            rs = ps.executeQuery();
            while (rs.next()) {
                int ID = rs.getInt("ID");
                String username = rs.getString("username");
                String email = rs.getString("email");
                Timestamp joined = rs.getTimestamp("joined");
                Timestamp lastOnline = rs.getTimestamp("joined");
                int played = rs.getInt("played");
                int won = rs.getInt("won");
                int lost = rs.getInt("lost");
                user = new User(ID, username, email, password, joined, lastOnline, played, won, lost);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User createUser(User user) {
        String query = "INSERT INTO Users(username, email, password) VALUES(?,?,?)";
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = DCM.getDataSource().getConnection();
            ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    user.setID(rs.getInt("ID"));
                    user.setJoined(rs.getTimestamp("joined"));
                    user.setLastOnline(rs.getTimestamp("lastOnline"));
                    user.setPlayed(rs.getInt("played"));
                    user.setWon(rs.getInt("won"));
                    user.setLost(rs.getInt("lost"));
                }
            } catch (SQLException s) {
                s.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean updateUser(User user) {
        boolean success = false;
        String query = "UPDATE Users Set `LastOnline` = ?, `Played` = ?, `Won` = ?, `Lost` = ? WHERE `ID` = ?";

        ResultSet rs = null;
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = DCM.getDataSource().getConnection();
            ps = connection.prepareStatement(query);
            ps.setTimestamp(1, Timestamp.valueOf(LocalDateTime.now()));
            ps.setInt(2, user.getPlayed());
            ps.setInt(3, user.getWon());
            ps.setInt(4, user.getLost());
            ps.executeUpdate();
            ps.close();
            success = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }

    @Override
    public boolean updateUserPassword(User user, String oldPassword, String newPassword) {

        boolean success = false;
        String query = "UPDATE Users Set password = ? WHERE ID = ?";

        ResultSet rs = null;
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            if (!(user.getPassword().equals(oldPassword)) ||
                    (validateUserCredentials(user.getUserName(), oldPassword) == null))
                return false;

            connection = DCM.getDataSource().getConnection();
            ps = connection.prepareStatement(query);
            ps.setString(1, newPassword);
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
