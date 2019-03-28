/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.AccessObjectImplementation;

import database.AccessObjects.MatchDAO;
import database.DCM;
import database.Models.Lobby;
import database.Models.Match;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Travis
 */
public class MatchDAOImpl implements MatchDAO {
    @Override
    public Match getMatchByID(int ID) {
        String query = "SELECT * FROM match WHERE ID = ?";

        Match match = null;
        ResultSet rs = null;
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = DCM.getDataSource().getConnection();
            ps = connection.prepareStatement(query);
            ps.setInt(1, ID);
            rs = ps.executeQuery();

            while (rs.next()) {
                int endState = rs.getInt("endState");
                int endTime = rs.getInt("endTime");
                int monster = rs.getInt("monster");
                int player1 = rs.getInt("player1");
                int player2 = rs.getInt("player2");
                int player3 = rs.getInt("player3");
                match = new Match(ID, endState, endTime,
                        monster, player1, player2, player3);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return match;
    }

    @Override
    public List<Match> getMatchesByUserID(int userID) {
        String query = "SELECT * FROM match WHERE (monster = ? OR player1 = ? OR player2 = ? OR player3 = ?)";

        List<Match> matchList = new ArrayList<>();
        Match match = null;
        ResultSet rs = null;
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = DCM.getDataSource().getConnection();
            ps = connection.prepareStatement(query);
            ps.setInt(1, userID);
            ps.setInt(2, userID);
            ps.setInt(3, userID);
            ps.setInt(4, userID);
            rs = ps.executeQuery();

            while (rs.next()) {
                int ID = rs.getInt("id");
                int endState = rs.getInt("endState");
                int endTime = rs.getInt("endTime");
                int monster = rs.getInt("monster");
                int player1 = rs.getInt("player1");
                int player2 = rs.getInt("player2");
                int player3 = rs.getInt("player3");
                match = new Match(ID, endState, endTime,
                        monster, player1, player2, player3);
                matchList.add(match);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return matchList;
    }
}
