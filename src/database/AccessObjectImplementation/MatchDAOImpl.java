/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.AccessObjectImplementation;

import database.AccessObjects.MatchDAO;
import database.Models.Match;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Travis
 */
public class MatchDAOImpl implements MatchDAO {
    @Override
    public Match getMatchByID(int ID) {
        return new Match();
    }
    
    @Override
    public List<Match> getMatchesByUserID(int ID) {
        return new ArrayList<>();
    }
}
