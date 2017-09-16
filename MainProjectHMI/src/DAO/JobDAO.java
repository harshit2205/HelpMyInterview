package DAO;

import Beans.Models.Job;
import jdk.nashorn.internal.scripts.JO;

import java.sql.*;
import java.util.ArrayList;


public class JobDAO {
    private static JobDAO jobDAO;
    private Connection connection;
    private Statement statement;

    private JobDAO(){
        try {
            connection = DaoFactory.getDaoFactoryInstance().getConnection();
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static JobDAO getJobDAOInstance(){
        if(jobDAO == null){
            jobDAO = new JobDAO();
        }
        return jobDAO;
    }

    public ArrayList<Job> getJob(String userName){
        String query = "SELECT * FROM job WHERE userName = \'" + userName +"\' ;" ;
        Job job = null;
        ArrayList<Job> jobList = new ArrayList<>();
        try {
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                job = new Job(rs.getString("profile"),
                        rs.getString("organization"),
                        rs.getBoolean("wfhome"),
                        rs.getString("location"),
                        rs.getString("description"));
                jobList.add(job);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jobList;
    }

    public void insertJob(ArrayList<Job> jobList, String userName){
        String query = "INSERT INTO job ( userName, profile, organization, wfhome, location, description)" + " VALUES(?,?,?,?,?,?)";
        System.out.println("insert job: " + query);
        PreparedStatement preparedStmt = null;
        for (int i = 0; i < jobList.size(); i++) {
            try {
                preparedStmt = connection.prepareStatement(query);
                preparedStmt.setString(1, userName);
                preparedStmt.setString(2, jobList.get(i).getProfile());
                preparedStmt.setString(3, jobList.get(i).getOrganization());
                preparedStmt.setBoolean(4, jobList.get(i).isWorkFromHome());
                preparedStmt.setString(6, jobList.get(i).getLocation());
                preparedStmt.setString(5, jobList.get(i).getDescription());
                preparedStmt.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public void updateJob(ArrayList<Job> jobList, String userName){

        for (int i = 0; i < jobList.size(); i++) {
            String query = "UPDATE job SET profile = \'" + jobList.get(i).getProfile() +
                    "\', organization = \'" + jobList.get(i).getOrganization() +
                    "\', wfhome = \'" + jobList.get(i).isWorkFromHome() +
                    "\', location = \'" + jobList.get(i).getLocation() +
                    "\', description = \'" + jobList.get(i).getDescription() +
                    "\' WHERE userName = \'" + userName + "\';";

            System.out.println("update job: " + query);

            try {
                statement.executeUpdate(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public String findUserData(String userName){
        String name = "";
        String query = "SELECT userName FROM job WHERE userName = \'" + userName + "\';";
        System.out.println("find job row: " + query);

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

    public boolean ifJobExists(String userName) {
        String name = findUserData(userName);
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
