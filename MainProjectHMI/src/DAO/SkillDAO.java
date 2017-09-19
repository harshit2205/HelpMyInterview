package DAO;

import Beans.Models.Education;
import Beans.Models.Skill;
import java.sql.*;
import java.util.ArrayList;

public class SkillDAO {

    private static SkillDAO skillDAO;
    private Connection connection;
    private Statement statement;

    private SkillDAO() {
        try {
            connection = DaoFactory.getDaoFactoryInstance().getConnection();
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SkillDAO getSkillDAOInstance(){
        if(skillDAO == null){
            skillDAO = new SkillDAO();
        }
        return skillDAO;
    }

    public ArrayList<Skill> getSkill(String userName){
        String query = "SELECT * FROM skill WHERE userName = \'" + userName + "\';";
        Skill skill = null;
        ArrayList<Skill> skillList = new ArrayList<>();
        try {
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                skill = new Skill(rs.getString("skillName"),
                        rs.getString("experiance"));
                skillList.add(skill);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return skillList;
    }

    public void insertSkill(Skill skill, String userName){
        String query = "INSERT INTO skill ( userName, skillName, experiance)" + " VALUES(?,?,?)";
        System.out.println("insert skill: " + query);
        PreparedStatement preparedStmt = null;
            try {
                preparedStmt = connection.prepareStatement(query);
                preparedStmt.setString(1, userName);
                preparedStmt.setString(2, skill.getSkillName());
                preparedStmt.setString(3, skill.getExperience());
                preparedStmt.execute();
            } catch (SQLException e) {
                e.printStackTrace();
        }
    }

    public void updateSkill(ArrayList<Skill> skillList, String userName){

        for (int i = 0; i < skillList.size(); i++) {
            String query = "UPDATE skill SET skillName = \'" + skillList.get(i).getSkillName() +
                    "\', experiance = \'" + skillList.get(i).getExperience() +
                    "\' WHERE userName = \'" + userName + "\' ;";

            System.out.println("update skill: " + query);

            try {
                statement.executeUpdate(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public String findUserData(String userName){
        String name = "";
        String query = "SELECT userName FROM skill WHERE userName = \'" + userName + "\';";
        System.out.println("find skill row: " + query);

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

    public boolean ifSkillExists(String userName) {
        String name = findUserData(userName);
        System.out.println(userName + "    " + name);
        if (name.equals(userName)) {
            System.out.println("username exists");
            return true;
        } else {
            System.out.println("username doesnt exists");
            return false;
        }
    }
}
