package Utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnector {

    public static Connection connectToDB(){
        Connection connection = null;
        try

        {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "password");

        }catch(Exception e){
            System.out.println("System unable to connect to database : Connection object isnt formed");
        }
        return connection;
    }
}
