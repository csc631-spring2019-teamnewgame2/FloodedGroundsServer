/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.AccessObjectImplementation;

import database.AccessObjects.UserMatchDAO;
import database.DCM;
import database.Models.Match;
import database.Models.UserMatch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Travis
 */
public class UserMatchDAOImpl implements UserMatchDAO {
    @Override
    public UserMatch getUserMatchByID(int ID) {
        String query = "SELECT * FROM match WHERE ID = ?";

        UserMatch userMatch = null;
        ResultSet rs = null;
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = DCM.getDataSource().getConnection();
            ps = connection.prepareStatement(query);
            ps.setInt(1, ID);
            rs = ps.executeQuery();

            while (rs.next()) {
                int role = rs.getInt("role");
                int attacksMade = rs.getInt("attacksMade");
                int attacksHit = rs.getInt("attacksHit");
                int timesDowned = rs.getInt("timesDowned");
                int aliveAtEnd = rs.getInt("aliveAtEnd");
                int matchID = rs.getInt("matchID");
                int playerID = rs.getInt("playerID");
                userMatch = new UserMatch(ID, role, attacksMade, attacksHit,
                        timesDowned, aliveAtEnd, matchID, playerID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userMatch;
    }

    @Override
    public List<UserMatch> getAllUserMatchesByUserID(int userID) {
        String query = "SELECT * FROM match WHERE userID = ?";

        List<UserMatch> userMatchList = new ArrayList<>();
        UserMatch userMatch = null;
        ResultSet rs = null;
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = DCM.getDataSource().getConnection();
            ps = connection.prepareStatement(query);
            ps.setInt(1, userID);
            rs = ps.executeQuery();

            while (rs.next()) {
                int ID = rs.getInt("ID");
                int role = rs.getInt("role");
                int attacksMade = rs.getInt("attacksMade");
                int attacksHit = rs.getInt("attacksHit");
                int timesDowned = rs.getInt("timesDowned");
                int aliveAtEnd = rs.getInt("aliveAtEnd");
                int matchID = rs.getInt("matchID");
                userMatch = new UserMatch(ID, role, attacksMade, attacksHit,
                        timesDowned, aliveAtEnd, matchID, userID);
                userMatchList.add(userMatch);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userMatchList;
    }
}
