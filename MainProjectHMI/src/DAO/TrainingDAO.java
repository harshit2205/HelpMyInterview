package DAO;

import Beans.Models.Education;
import Beans.Models.Training;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by USER on 9/15/2017.
 */

public class TrainingDAO {

    private static TrainingDAO trainingDAO;
    private Connection connection;
    private Statement statement;

    private TrainingDAO(){
        try {
            connection = DaoFactory.getDaoFactoryInstance().getConnection();
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static TrainingDAO getTrainingDAOInstance(){
        if(trainingDAO == null){
            trainingDAO = new TrainingDAO();
        }
        return trainingDAO;
    }

    public ArrayList<Training> getTraining(String userName){
        String query = "SELECT * FROM training WHERE userName = \'" + userName + "\';";
        Training training = null;
        ArrayList<Training> trainingList = new ArrayList<>();

        try {
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                training = new Training(rs.getString("trainingName"),
                        rs.getString("organizationName"),
                        rs.getBoolean("trainingOnline"),
                        rs.getString("trainingLocation"),
                        rs.getString("description"));
                trainingList.add(training);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trainingList;
    }

    public void insertTraining(Training training, String userName){
        String query = "INSERT INTO training ( userName, trainingName, organizationName, trainingOnline, trainingLocation, description)"
                + " VALUES(?,?,?,?,?,?)";
        System.out.println("insert training: " + query);
        PreparedStatement preparedStmt = null;
            try {
                preparedStmt = connection.prepareStatement(query);
                preparedStmt.setString(1, userName);
                preparedStmt.setString(2, training.getTrainingName());
                preparedStmt.setString(3, training.getOrganizationName());
                preparedStmt.setBoolean(4, training.isTrainingOnline());
                preparedStmt.setString(6, training.getTrainingLocation());
                preparedStmt.setString(5, training.getDescription());
                preparedStmt.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    public void updateTraining(ArrayList<Training> trainingList, String userName){
        for (int i = 0; i < trainingList.size(); i++) {
            String query = "UPDATE training SET trainingName = \'" + trainingList.get(i).getTrainingName() +
                    "\', organizationName = \'" + trainingList.get(i).getOrganizationName() +
                    "\', trainingOnline = \'" + trainingList.get(i).isTrainingOnline() +
                    "\', trainingLocation = \'" + trainingList.get(i).getTrainingLocation() +
                    "\', description = \'" + trainingList.get(i).getDescription()+
                    "\' WHERE userName = \'" + userName + "\';";

            System.out.println("update training: " + query);
            try {
                statement.executeUpdate(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public String findUserName(String userName) {
        String name = "";
        String query = "SELECT userName FROM training WHERE userName = \'" + userName + "\';";
        System.out.println("find training row: " + query);

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

    public boolean ifTrainingExists(String userName) {
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
