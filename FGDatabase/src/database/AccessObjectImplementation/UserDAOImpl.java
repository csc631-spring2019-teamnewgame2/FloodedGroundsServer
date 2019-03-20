/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.AccessObjectImplementation;

import database.AccessObjects.UserDAO;
import database.Models.User;

/**
 *
 * @author Travis
 */
public class UserDAOImpl implements UserDAO {
    
    @Override
    public User getUserByID(int ID){
        return new User();
    }
    
    @Override
    public boolean createUser(User user){
        return true;
    }
    
    @Override
    public boolean updateUser(User user){
        return true;
    }
    
    @Override
    public boolean deleteUser(User user){
        return true;
    }
}
