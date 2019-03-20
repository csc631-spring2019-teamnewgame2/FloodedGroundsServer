/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.AccessObjects;

import database.Models.Match;
import java.util.List;

/**
 *
 * @author Travis
 */
public interface MatchDAO {
    public Match getMatchByID(int ID);
    public List<Match> getMatchesByUserID(int ID);
}
