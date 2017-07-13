package Beans.Models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

/**
 * Created by staLker on 05-07-2017.
 */
public class UserLab {
    private ArrayList<User> userList;
    private static UserLab userLab;
    private UserLab(){
        userList = new ArrayList<>();
        for (int i=0;i<2;i++){
            User user = new User();
            user.setUserDetails(
                    "Manu"+i,
                    "Rastogi"+i,
                    "manu461@gmail.com"+i,
                    Long.parseLong("8009898912"),
                    "Male",
                    "manu123"+i,
                    "manu123"+i,
                    "UP"+i,
                    "Agra"+i
            );
            userList.add(user);
        }

    }
    public static UserLab get(){
        if(userLab==null){
            userLab = new UserLab();
        }
        return userLab;
    }

    public ArrayList<User> getUserList() {
        return userList;
    }
    public ObservableList<User> getObservableUserList(){
        return FXCollections.observableList(userList);
    }

    public User getUserByUserName(String userName){
        User user = null;
        for (User i:userList){
            if(i.getUserName().intern()==userName.intern()){
                user = i;
            }

        }
        return user;
    }
}
