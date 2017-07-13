package DAO;

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

    public Connection getConnection() throws SQLException {
        final String DURL = "jdbc:mysql://localhost:3306/HelpMyInterviewDB";
        final String userName = "root";
        final String password = "mysql461";


        if(connection == null){
                connection = DriverManager.getConnection(DURL, userName, password);
        }
        return connection;
    }
}
