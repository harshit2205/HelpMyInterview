package Models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by staLker on 05-07-2017.
 */
public class UserLab {
    private ArrayList<User> userList;
    public UserLab(){
        userList = new ArrayList<>();
        for (int i=0;i<100;i++){
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

    public ArrayList<User> getUserList() {
        return userList;
    }
}
