package DAO;

import Beans.Models.User;
import Beans.Models.UserCredential;
import Beans.Models.UserUpdate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

/**
 * Created by USER on 7/11/2017.
 */
public class UserDAO {

    private static UserDAO userDAO;
    private Connection connection;
    private Statement statement;

    private UserDAO(){
     //initialisation.
        try {
            connection = DaoFactory.getDaoFactoryInstance().getConnection();
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static UserDAO getUserDAOInstance(){
        if(userDAO == null){
            userDAO = new UserDAO();
        }
        return userDAO;
    }

    public void insertUser(User user) {

        try {
            CallableStatement insertStatement = connection.prepareCall("{call Insertprocedure(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            System.out.println("Callable statement object created");
            insertStatement.setInt(1,user.getId());
            insertStatement.setString(2,user.getFirstName());
            insertStatement.setString(3,user.getLastName());
            insertStatement.setString(4,user.getEmail());
            insertStatement.setLong(5,user.getContact());
            insertStatement.setString(6,user.getGender());
            insertStatement.setString(7,user.getUserName());
            insertStatement.setString(8,user.getPassword());
            insertStatement.setString(9,user.getState());
            insertStatement.setString(10,user.getCity());
            insertStatement.setString(11,user.getBio());
            insertStatement.setDate(12,user.getDob());
            insertStatement.setString(13,user.getHomeTown());
            insertStatement.setString(14,user.getAbout());
            insertStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public boolean deleteUser(String userName) {
        return false;
    }

    public User findUser(String userName) {
        User user = null;
        String query = "SELECT * FROM user WHERE userName = \'"+userName+"\' ;";
        System.out.println(query);
        try {
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()){
                user = new User();
                user.setId(rs.getInt("userId"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setEmail(rs.getString("eMail"));
                user.setContact(rs.getLong("contact"));
                user.setGender(rs.getString("gender"));
                user.setUserName(rs.getString("userName"));
                user.setPassword(rs.getString("password"));
                user.setState(rs.getString("state"));
                user.setCity(rs.getString("city"));
                user.setBio(rs.getString("bio"));
                user.setHomeTown(rs.getString("homeTown"));
                user.setAbout(rs.getString("about"));
                user.setDob(rs.getDate("dob"));
                break;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public ObservableList<User> allUsers(){
        ObservableList<User> users = FXCollections.observableArrayList();
        String query = "SELECT * FROM user;";
        try {
            ResultSet rs = statement.executeQuery(query);

            while(rs.next()){
                User user = new User();
                user.setUserDetails(rs.getString("firstName")
                        ,rs.getString("lastName")
                        ,rs.getString("eMail")
                        ,rs.getLong("contact")
                        ,rs.getString("gender")
                        ,rs.getString("userName")
                        ,rs.getString("password")
                        ,rs.getString("state")
                        ,rs.getString("city"));
               users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public boolean ifUserExists(String userName){
         User user = findUser(userName);
         return user!=null;
    }

    public void updateUserCreadentials(UserCredential userCredential,String prevUserName){
        String query = "UPDATE user SET userName = \'"+userCredential.getUserName()+
                "\', password = \'"+userCredential.getPassword()+
                "\' WHERE userName = \'"+prevUserName+";";
        System.out.println(query);

        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(UserUpdate userUpdate){
        String query = "UPDATE user SET  firstName = \'"+ userUpdate.getFirstName()+
                "\', lastName = \'"+userUpdate.getLastName() +
                "\', eMail = \'"+userUpdate.geteMail()+
                "\', gender = \'"+userUpdate.getGender()+
                "\', state = \'"+userUpdate.getState()+
                "\', city = \'"+userUpdate.getCurrentCity()+
                "\', bio = \'"+userUpdate.getBio()+
                "\', dob = \'"+userUpdate.getDob() +
                "\', about = \'"+userUpdate.getAbout()+
                "\', homeTown = \'"+userUpdate.getHomeTown()+
                "\' WHERE userName = \'"+userUpdate.getUserName()+"\';";


        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
