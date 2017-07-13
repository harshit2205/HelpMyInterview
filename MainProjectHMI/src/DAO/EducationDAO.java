package DAO;

import Beans.Models.Education;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by USER on 7/13/2017.
 */
public class EducationDAO {

    private static EducationDAO educationDAO;
    private Connection connection;
    private Statement statement;

    private EducationDAO(){
        try {
            connection = DaoFactory.getDaoFactoryInstance().getConnection();
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static EducationDAO getEducationDAOInstance(){
        if(educationDAO == null){
            educationDAO = new EducationDAO();
        }
        return educationDAO;
    }

    public ArrayList<Education> getEducation(String userName){
        String query = "SELECT * FROM education WHERE userName = /'"+userName+"/';";
        Education education ;
        ArrayList<Education> educationList = new ArrayList<>();

        try {
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                education = new Education(rs.getString("userName"),
                        rs.getString("degree"),
                        rs.getString("courseName"),
                        rs.getString("institution"));
                educationList.add(education);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return educationList;
    }

    public void insertEducation(Education education){
        String query = "INSERT INTO education VALUES( /'"+education.getUserName()+"/',/'"+
                education.getDegree()+ "/',/'" +
                        education.getCourse()+"/', /'"+
                education.getInstitution()+"/';";



    }
}
