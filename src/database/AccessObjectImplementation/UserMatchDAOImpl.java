/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.AccessObjectImplementation;

import database.AccessObjects.UserMatchDAO;
import database.Models.UserMatch;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Travis
 */
public class UserMatchDAOImpl implements UserMatchDAO {
    @Override
    public UserMatch getUserMatchByID(int ID) {
        return new UserMatch();
    }

    @Override
    public List<UserMatch> getAllUserMatchesByUserID(int ID) {
        return new ArrayList<>();
    }
}
