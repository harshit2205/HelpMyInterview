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

    private EducationDAO() {
        try {
            connection = DaoFactory.getDaoFactoryInstance().getConnection();
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static EducationDAO getEducationDAOInstance() {
        if (educationDAO == null) {
            educationDAO = new EducationDAO();
        }
        return educationDAO;
    }

    public ArrayList<Education> getEducation(String userName) {

        String query = "SELECT * FROM education WHERE userName = \'" + userName + "\';";
        Education education;
        ArrayList<Education> educationList = new ArrayList<>();

        try {
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                education = new Education(rs.getString("degree"),
                        rs.getString("courseName"),
                        rs.getString("institution"));
                educationList.add(education);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return educationList;
    }

    public void insertEducation(ArrayList<Education> educationlist, String userName) {
        String query = "INSERT INTO education ( userName, degree, courseName, institution, eduIndex)" + " VALUES(?,?,?,?,?)";
        System.out.println("insert education: " + query);
        PreparedStatement preparedStmt = null;
        for (int i = 0; i < educationlist.size(); i++) {
            try {
                preparedStmt = connection.prepareStatement(query);
                preparedStmt.setString(1, userName);
                preparedStmt.setString(2, educationlist.get(i).getDegree());
                preparedStmt.setString(3, educationlist.get(i).getCourse());
                preparedStmt.setString(4, educationlist.get(i).getInstitution());
                preparedStmt.setInt(5, i);
                preparedStmt.execute();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateEducation(ArrayList<Education> educationlist, String userName) {

        for (int i = 0; i < educationlist.size(); i++) {
            String query = "UPDATE education SET degree = \'" + educationlist.get(i).getDegree() +
                    "\', courseName = \'" + educationlist.get(i).getCourse() +
                    "\', institution = \'" + educationlist.get(i).getInstitution() +
                    "\' WHERE userName = \'" + userName + "\' AND eduIndex = " + i + ";";

            System.out.println("update education: " + query);

            try {
                statement.executeUpdate(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public String findUserName(String userName) {
        String name = "";
        String query = "SELECT * FROM education WHERE userName = \'" + userName + "\';";
        System.out.println("find education row: " + query);

        ResultSet rs = null;

        try {
            rs = statement.executeQuery(query);
            while(rs.next()){
                System.out.println(rs.getString("userName"));
            name = rs.getString("userName");
            break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return name;
    }

    public boolean ifEducationExists(String userName) {
        String name = findUserName(userName);
        System.out.println(userName+"    "+name);
        if (name.equals(userName)) {
            System.out.println("username exists");
            return true;
        }else{
            System.out.println("username doesnt exists");
            return false;
        }
    }
}
