package Scenes;

import Models.User;
import Models.UserLab;
import ScenesPopWindow.AboutScene;
import ScenesPopWindow.HelpScene;
import ScenesPopWindow.OnUserSignUpScene;
import Stages.PopUpStage;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Created by staLker on 07-07-2017.
 */
public class UserLoginSceneListener {

    public static void listen(Stage window, TextField inputUsername, PasswordField inputPassword, Button loginButton, Button signUpButton, MenuItem managerLoginMenuItem, MenuItem aboutMenuItem, MenuItem helpMenuItem, MenuItem exitMenuItem) {
        UserLab userLab = UserLab.get();

        exitMenuItem.setOnAction(e -> {
            window.close();
        });




        loginButton.setOnAction(e -> {
            User user = userLab.getUserByUserName(inputUsername.getText());
            if(user!=null){
                if(user.getPassword().intern()==inputPassword.getText().intern()){
                    OnUserLogInScene.setUserName(inputUsername.getText());
                    OnUserLogInScene.passControl(window);

                }

            }

        });




        managerLoginMenuItem.setOnAction(e -> ManagerLoginScene.passControl(window));
        aboutMenuItem.setOnAction(e -> {
            PopUpStage.show("About HMI", AboutScene.getScene());
        });
        helpMenuItem.setOnAction(e -> {
            PopUpStage.show("HMI Forum", HelpScene.getScene());
        });
        signUpButton.setOnAction(e -> {
            PopUpStage.show("Registration", OnUserSignUpScene.getScene());
        });

    }
}
