package Dao;

import Models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by USER on 7/11/2017.
 */
public class JDBCUserDAO  {

    private Connection connection;

    public JDBCUserDAO(){
     //initialisation.
        try {
            connection = DaoFactory.getDaoFactoryInstance().getConnection();
            Statement statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int insertUser(User user) {

//        try {
//            PreparedStatement preparedStatement = connection
//                    .prepareStatement("insert into User" +
//                            "(user_id, first_name, last_name, email, contact, gender" +
//                            ", user_name, password, state, city, userimage, " +
//                            "dob, bio) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
//            preparedStatement.setInt(1,user.getId());
//            preparedStatement.setString(2,user.getFirstName());
//            preparedStatement.setString(3,user.getLastName());
//            preparedStatement.setString(4,user.getEmail());
//            preparedStatement.setBi();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        return 0;
    }

    public boolean deleteUser(String userName) {
        return false;
    }

    public User findUser(String UserName) {
        return null;
    }

    public boolean updateUser(User user) {
        return false;
    }

    public boolean ifUserExists(String userName){
        return false;
    }
}
