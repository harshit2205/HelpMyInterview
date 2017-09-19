package DAO;

import Beans.Models.Internship;

import java.sql.*;
import java.util.ArrayList;

public class InternshipDAO {

    private static InternshipDAO internshipDAO;
    private Connection connection;
    private Statement statement;

    private InternshipDAO(){
        try {
            connection = DaoFactory.getDaoFactoryInstance().getConnection();
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static InternshipDAO getInternshipDAOInstance(){
        if(internshipDAO == null){
            internshipDAO = new InternshipDAO();
        }
        return internshipDAO;
    }

    public ArrayList<Internship> getInternship(String userName){
        String query = "SELECT * FROM Internship WHERE userName = \'" + userName + "\';";
        Internship internship;
        ArrayList<Internship> internshipList = new ArrayList<>();

        try {
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                internship = new Internship(rs.getString("title"),
                        rs.getString("organization"),
                        rs.getString("location"),
                        rs.getBoolean("workFromHome"),
                        rs.getString("description"));
                internshipList.add(internship);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return internshipList;
    }

    public void insertInternship(Internship internship, String userName){
        String query = "INSERT INTO internship ( userName, title, organization, location, workFromHome, description)" + " VALUES(?,?,?,?,?,?)";
        System.out.println("insert internship: " + query);
        PreparedStatement preparedStmt = null;
            try {
                preparedStmt = connection.prepareStatement(query);
                preparedStmt.setString(1, userName);
                preparedStmt.setString(2, internship.getTitleOfInternship());
                preparedStmt.setString(3, internship.getOrganization());
                preparedStmt.setString(4, internship.getLocation());
                preparedStmt.setBoolean(5, internship.isWorkFromHome());
                preparedStmt.setString(6, internship.getDescription());
                preparedStmt.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    public void updateInternship(ArrayList<Internship> internshipList, String userName){

        for (int i = 0; i < internshipList.size(); i++) {
            String query = "UPDATE internship SET title = \'" + internshipList.get(i).getTitleOfInternship() +
                    "\', organization = \'" + internshipList.get(i).getOrganization() +
                    "\', location = \'" + internshipList.get(i).getLocation() +
                    "\', workFromHome = \'" + internshipList.get(i).isWorkFromHome() +
                    "\', description = \'" +internshipList.get(i).getDescription() +
                    "\' WHERE userName = \'" + userName + "\';";

            System.out.println("update internship: " + query);
            try {
                statement.executeUpdate(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public String findUserName(String userName) {
        String name = "";
        String query = "SELECT userName FROM internship WHERE userName = \'" + userName + "\';";
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

    public boolean ifInternshipExists(String userName) {
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
