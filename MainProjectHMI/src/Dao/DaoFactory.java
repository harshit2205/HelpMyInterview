package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory {

    private static DaoFactory daoFactory;
    private static Connection connection = null;

    public static DaoFactory getDaoFactoryInstance(){
        if(daoFactory == null){
            daoFactory = new DaoFactory();
        }
        return daoFactory;
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        final String DURL = "jdbc:oracle:thin:@localhost:1521:xe";
        final String userName = "root";
        final String password = "password";

        if(connection == null){
                Class.forName("jdbc:oracle:thin:@localhost:1521:xe");
                connection = DriverManager.getConnection(DURL, userName, password);
        }
        return connection;
    }
}
