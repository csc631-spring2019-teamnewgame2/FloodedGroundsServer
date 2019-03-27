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

/**
 * @author Travis
 */
public class UserDAOImpl implements UserDAO {

    @Override
    public User getUserByID(int ID) {
        String query = "SELECT * FROM `users` WHERE `ID` = '" + ID + "'";

        User user = null;
        ResultSet rs = null;
        Connection connection = null;
        PreparedStatement pstmt = null;

        try {
            connection = DCM.getDataSource().getConnection();
            pstmt = connection.prepareStatement(query);
            rs = pstmt.executeQuery();

            while (rs != null && rs.next()) {
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
        String query = "SELECT * FROM `users` WHERE (`username` = '" +
                loginName + "' OR `email` = '" + loginName + "') AND `password` = '" + password + "'";

        User user = null;
        ResultSet rs = null;
        Connection connection = null;
        PreparedStatement pstmt = null;

        try {
            connection = DCM.getDataSource().getConnection();
            pstmt = connection.prepareStatement(query);
            rs = pstmt.executeQuery();
            while (rs != null && rs.next()) {
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
        return new User();
    }

    @Override
    public User updateUser(User user) {
        return new User();
    }

    @Override
    public User deleteUser(User user) {
        return new User();
    }
}
