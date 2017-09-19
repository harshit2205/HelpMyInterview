package DAO;


import Beans.Models.Education;
import Beans.Models.Project;

import java.sql.*;
import java.util.ArrayList;

/**
 * made by harshit
 */

public class ProjectDAO {

    private static ProjectDAO projectDAO;
    private Connection connection;
    private Statement statement;

    private ProjectDAO(){
        try {
            connection = DaoFactory.getDaoFactoryInstance().getConnection();
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ProjectDAO getProjectDAOInstance(){
        if(projectDAO == null){
            projectDAO = new ProjectDAO();
        }
        return projectDAO;
    }

    public ArrayList<Project> getProject(String userName){
        String query = "SELECT * FROM project WHERE userName = \'" + userName + "\';";
        Project project = null;
        ArrayList<Project> projectList = new ArrayList<>();
        try {
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                project = new Project(rs.getString("projectTitle"),
                        rs.getString("projectURL"),
                        rs.getBoolean("projectOnGoing"),
                        rs.getString("projectDescription"));
                projectList.add(project);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projectList;
    }

    public void insertProject(Project project, String userName){
        String query = "INSERT INTO project ( userName, projectTitle, projectURL, projectOnGoing, projectDescription)" + " VALUES(?,?,?,?,?)";
        System.out.println("insert project: " + query);
        PreparedStatement preparedStmt = null;
            try {
                preparedStmt = connection.prepareStatement(query);
                preparedStmt.setString(1, userName);
                preparedStmt.setString(2, project.getProjectTitle());
                preparedStmt.setString(3, project.getProjectURL());
                preparedStmt.setBoolean(4, project.isProjectOnGoing());
                preparedStmt.setString(5, project.getProjectDescription());
                preparedStmt.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    public void updateProject(ArrayList<Project> projectList, String userName){

        for (int i = 0; i < projectList.size(); i++) {
            String query = "UPDATE project SET projectTitle = \'" + projectList.get(i).getProjectTitle() +
                    "\', projectURL = \'" + projectList.get(i).getProjectURL() +
                    "\', projectOnGoing = \'" + projectList.get(i).isProjectOnGoing() +
                    "\', projectDescription = \'" + projectList.get(i).getProjectDescription() +
                    "\' WHERE userName = \'" + userName + "\';";

            System.out.println("update project: " + query);

            try {
                statement.executeUpdate(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public String findUserName(String userName) {
        String name = "";
        String query = "SELECT userName FROM project WHERE userName = \'" + userName + "\';";
        System.out.println("find project row: " + query);

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

    public boolean ifProjectExists(String userName) {
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
