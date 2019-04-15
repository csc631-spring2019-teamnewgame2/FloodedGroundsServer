/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.AccessObjects;

import database.Models.User;

import java.sql.SQLException;

/**
 * @author Travis
 */
public interface UserDAO {
    /**
     * @param ID
     * @return
     */
    public User getUserByID(long ID) throws SQLException;

    /**
     * Validates User Credentials exist in database, and returns the relevant User
     * object, or null, if the User credentials don't match a database entry
     *
     * @param loginName A username or email
     * @param password
     * @return Valid User object, or null, if no User is found
     */
    public User validateUserCredentials(String loginName, String password) throws SQLException;

    /**
     * @param user
     * @return
     */
    public User createUser(User user) throws SQLException;

    /**
     * Updates LastOnline, Played, Won, and Lost values for the selected User in the Database
     *
     * @param user
     * @return
     */
    public boolean updateUser(User user) throws SQLException;

    /**
     *
     * @param user
     * @param newPassword
     * @return
     */
    public boolean updateUserPassword(User user, String oldPassword, String newPassword) throws SQLException;
}
