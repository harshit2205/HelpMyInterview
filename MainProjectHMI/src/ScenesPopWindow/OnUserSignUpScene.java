package ScenesPopWindow;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 * Created by staLker on 01-07-2017.
 */
public class OnUserSignUpScene {
    public static Scene getScene(){

//        HBox hBox = new HBox();
//        Label label = new Label("Registration form coming soon...");
//        hBox.getChildren().add(label);
//        hBox.setAlignment(Pos.CENTER);


        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);


        Label firstNameLabel = new Label("First Name: ");
        Label lastNameLabel = new Label("Last Name: ");
        Label eMailLabel = new Label("e-mail ID: ");
        Label contactLabel = new Label("Contact: ");
        Label genderLabel = new Label("Gender: ");
        Label userNameLabel = new Label("Username: ");
        Label passwordLabel = new Label("Password: ");
        Label repeatPasswordLabel = new Label("Repeat-Password: ");
        Label stateLabel = new Label("State: ");
        Label cityLabel = new Label("City: ");


        TextField firstNameTextField = new TextField();
        firstNameTextField.setPromptText("enter first name");
        TextField lastNameTextField = new TextField();
        lastNameTextField.setPromptText("enter last name");
        TextField eMailTextField = new TextField();
        eMailTextField.setPromptText("enter a valid e-mail");
        TextField contactTextField = new TextField();
        contactTextField.setPromptText("enter 10-digit contact");
        TextField usernameTextField = new TextField();
        ToggleGroup genderToggleGroup = new ToggleGroup();
        RadioButton maleRadioButton = new RadioButton("Male");
        maleRadioButton.setToggleGroup(genderToggleGroup);
        RadioButton femaleRadioButton = new RadioButton("Female");
        femaleRadioButton.setToggleGroup(genderToggleGroup);
        HBox genderRadioButtonHBox = new HBox(15);
        genderRadioButtonHBox.getChildren().addAll(maleRadioButton,femaleRadioButton);
        usernameTextField.setPromptText("enter a username");
        TextField passwordTextField = new TextField();
        passwordTextField.setPromptText("set your Password");
        TextField repeatPasswordTextField = new TextField();
        repeatPasswordTextField.setPromptText("re-enter the Password");

        GridPane.setConstraints(firstNameLabel,0,0);
        GridPane.setConstraints(firstNameTextField,1,0);
        GridPane.setConstraints(lastNameLabel,0,1);
        GridPane.setConstraints(lastNameTextField,1,1);
        GridPane.setConstraints(eMailLabel,0,2);
        GridPane.setConstraints(eMailTextField,1,2);
        GridPane.setConstraints(contactLabel,0,3);
        GridPane.setConstraints(contactTextField,1,3);
        GridPane.setConstraints(genderLabel,0,4);
        GridPane.setConstraints(genderRadioButtonHBox,1,4);
        GridPane.setConstraints(userNameLabel,0,5);
        GridPane.setConstraints(usernameTextField,1,5);
        GridPane.setConstraints(passwordLabel,0,6);
        GridPane.setConstraints(passwordTextField,1,6);
        GridPane.setConstraints(repeatPasswordLabel,0,7);
        GridPane.setConstraints(repeatPasswordTextField,1,7);
        GridPane.setConstraints(stateLabel,0,8);
        GridPane.setConstraints(cityLabel,0,9);

        gridPane.getChildren().addAll(
                firstNameLabel,
                firstNameTextField,
                lastNameLabel,
                lastNameTextField,
                eMailLabel,
                eMailTextField,
                contactLabel,
                contactTextField,
                genderLabel,
                genderRadioButtonHBox,
                userNameLabel,
                usernameTextField,
                passwordLabel,
                passwordTextField,
                repeatPasswordLabel,
                repeatPasswordTextField,
                stateLabel,
                cityLabel
        );


        Scene scene = new Scene(gridPane,500,900);
        return scene;
    }
}
