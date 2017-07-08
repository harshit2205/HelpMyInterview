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
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

import static Utils.ValidationUtils.formatErrorText;

/**
 * Created by staLker on 07-07-2017.
 */
public class UserLoginSceneListener {

    public static void listen(Stage window, TextField inputUsername, Text userNameErrorText, PasswordField inputPassword, Text passwordErrorText, Text entryErrorText, Button loginButton, Button signUpButton, MenuItem managerLoginMenuItem, MenuItem aboutMenuItem, MenuItem helpMenuItem, MenuItem exitMenuItem) {
        UserLab userLab = UserLab.get();


        formatErrorText(userNameErrorText);
        formatErrorText(passwordErrorText);
        entryErrorText.setVisible(false);
        entryErrorText.setFont(javafx.scene.text.Font.font(null, FontWeight.SEMI_BOLD,15));
        entryErrorText.getStyleClass().add("text-error");


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
                else {
                    showErrorMessage(userNameErrorText,passwordErrorText,entryErrorText,"invalid username or password");
                }

            }
            else {
                if(inputUsername.getText().intern()!=""){
                    showErrorMessage(userNameErrorText,passwordErrorText,entryErrorText,"user not registered");
                }
                else {
                    showErrorMessage(userNameErrorText,passwordErrorText,entryErrorText,"input a username and password");

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
    private static void showErrorMessage(Text un,Text pswd,Text entry,String message){
        un.setVisible(true);
        pswd.setVisible(true);
        entry.setVisible(true);
        entry.setText(message);

    }
}
