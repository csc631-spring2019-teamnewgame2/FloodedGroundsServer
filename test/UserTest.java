package test;

import database.AccessObjectImplementation.UserDAOImpl;
import database.AccessObjects.UserDAO;
import database.Models.User;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class UserTest {
    private int ID;
    private String [] userNames = {"u4","u5","u6"};
    private long[] userIDs = new long[3];
    private String email = "test@email.mail";
    private String password = "testPassword";
    private String password2 = "changedPassword";
    private Timestamp joined;
    private Timestamp lastOnline;
    private int played;
    private int won;
    private int lost;
    private UserDAO dao;
    private User user;

    public UserTest(){
        dao = new UserDAOImpl();
    }

    public boolean testCreate(){
        try {
            for (int i = 0; i < 3; i++) {
                user = dao.createUser(new User(userNames[i], email + "" + i, password));
                userIDs[i] = user.getID();
            }
            System.out.println(user.getID());
        }
        catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean testGetUserByID(){
        boolean success = true;
        try {
            for (int i = 0; i < 3; i++) {
                user = dao.getUserByID(userIDs[i]);
                if (!user.getUserName().equals(userNames[i])) success = false;
            }
            System.out.println(user.getID());
        }
        catch(SQLException e) {
            e.printStackTrace();
            success = false;
        }
        return success;
    }

    public boolean testUpdate(){
        boolean success = false;
        lastOnline = Timestamp.valueOf(LocalDateTime.now());
        user.setLastOnline(lastOnline);
        try {
            dao.updateUser(user);
            success = true;
        }
        catch(SQLException e){
            e.printStackTrace();
        }

        return success;
    }

    public boolean testUpdatePassword(){
        boolean success = false;
        lastOnline = Timestamp.valueOf(LocalDateTime.now());
        try {
            dao.updateUserPassword(user,password,password2);
            success = true;
        }
        catch(SQLException e){
            e.printStackTrace();
        }

        return success;
    }

    public boolean testValidateCredentials(){
        boolean success = false;
        lastOnline = Timestamp.valueOf(LocalDateTime.now());
        String username = user.getUserName();
        String pw = user.getPassword();
        try {
            user = dao.validateUserCredentials(username, pw);
            if(user.getUserName().equals(username))
                success = true;
        }
        catch(SQLException e){
            e.printStackTrace();
        }

        return success;
    }
}
