/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.AccessObjects;

import database.Models.User;

/**
 *
 * @author Travis
 */
public interface UserDAO {
    public User getUserByID(int ID);
    public boolean createUser(User user);
    public boolean updateUser(User user);
    public boolean deleteUser(User user);
}
