package ScenesPopWindow;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


/**
 * Created by staLker on 01-07-2017.
 */
public class OnUserSignUpScene {
    public static Scene getScene(){

//        HBox hBox = new HBox();
//        Label label = new Label("Registration form coming soon...");
//        hBox.getChildren().add(label);
//        hBox.setAlignment(Pos.CENTER);

        VBox root = new VBox(70);

        Text titleText = new Text("Enter your Detail");
        titleText.setFont(Font.font(null, FontWeight.EXTRA_BOLD,30));
        titleText.setFill(Paint.valueOf("#01a0e4"));
        HBox titleTextHBox = new HBox();
        titleTextHBox.getChildren().add(titleText);
        titleTextHBox.setAlignment(Pos.CENTER);


        GridPane formPane = new GridPane();
        formPane.setVgap(20);
        formPane.setHgap(5);


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
        ComboBox<String> statesComboBox = new ComboBox<>();
        statesComboBox.setPromptText("select states");
        ComboBox<String> citiesComboBox = new ComboBox<>();
        citiesComboBox.setPromptText("select city");
        CheckBox acceptCheckBox =  new CheckBox("Accept Terms & Conditions");
        acceptCheckBox.setStyle("-fx-text-fill: white");


        HBox firstNameErrorHBox = setErrorHBox(firstNameTextField);
        HBox lastNameErrorHBox = setErrorHBox(lastNameTextField);
        HBox eMailErrorHBox = setErrorHBox(eMailTextField);
        HBox contactErrorHBox = setErrorHBox(contactTextField);
        HBox genderErrorHBox = setErrorHBox(genderRadioButtonHBox);
        HBox userNameErrorHBox = setErrorHBox(usernameTextField);
        HBox passwordErrorHBox = setErrorHBox(passwordTextField);
        HBox repeatPasswordErrorHBox = setErrorHBox(repeatPasswordTextField);
        HBox stateComboBoxErrorHBox = setErrorHBox(statesComboBox);
        HBox cityComboBoxErrorHBox = setErrorHBox(citiesComboBox);
        HBox acceptCheckBoxErrorHBox = setErrorHBox(acceptCheckBox);
        acceptCheckBoxErrorHBox.setAlignment(Pos.CENTER);






        GridPane.setConstraints(firstNameLabel,0,0);
        GridPane.setConstraints(firstNameErrorHBox,1,0);

        GridPane.setConstraints(lastNameLabel,0,1);
        GridPane.setConstraints(lastNameErrorHBox,1,1);

        GridPane.setConstraints(eMailLabel,0,2);
        GridPane.setConstraints(eMailErrorHBox,1,2);

        GridPane.setConstraints(contactLabel,0,3);
        GridPane.setConstraints(contactErrorHBox,1,3);

        GridPane.setConstraints(genderLabel,0,4);
        GridPane.setConstraints(genderErrorHBox,1,4);

        GridPane.setConstraints(userNameLabel,0,5);
        GridPane.setConstraints(userNameErrorHBox,1,5);

        GridPane.setConstraints(passwordLabel,0,6);
        GridPane.setConstraints(passwordErrorHBox,1,6);

        GridPane.setConstraints(repeatPasswordLabel,0,7);
        GridPane.setConstraints(repeatPasswordErrorHBox,1,7);

        GridPane.setConstraints(stateLabel,0,8);
        GridPane.setConstraints(stateComboBoxErrorHBox,1,8);

        GridPane.setConstraints(cityLabel,0,9);
        GridPane.setConstraints(cityComboBoxErrorHBox,1,9);



        formPane.getChildren().addAll(
                firstNameLabel,
                firstNameErrorHBox,
                lastNameLabel,
                lastNameErrorHBox,
                eMailLabel,
                eMailErrorHBox,
                contactLabel,
                contactErrorHBox,
                genderLabel,
                genderErrorHBox,
                userNameLabel,
                userNameErrorHBox,
                passwordLabel,
                passwordErrorHBox,
                repeatPasswordLabel,
                repeatPasswordErrorHBox,
                stateLabel,
                stateComboBoxErrorHBox,
                cityLabel,
                cityComboBoxErrorHBox
        );
        formPane.setAlignment(Pos.TOP_CENTER);




        Button registerButton = new Button("Register!");


        registerButton.setOnAction(e -> {
            makeRed(firstNameErrorHBox);
            makeRed(lastNameErrorHBox);
            makeRed(eMailErrorHBox);
            makeRed(contactErrorHBox);
            makeRed(genderErrorHBox);
            makeRed(userNameErrorHBox);
            makeRed(passwordErrorHBox);
            makeRed(repeatPasswordErrorHBox);
            makeRed(stateComboBoxErrorHBox);
            makeRed(cityComboBoxErrorHBox);
            makeRed(acceptCheckBoxErrorHBox);
        });

        root.getChildren().addAll(titleTextHBox,formPane,acceptCheckBoxErrorHBox,registerButton);
        root.setAlignment(Pos.CENTER);


        Scene scene = new Scene(root,500,900);
        return scene;
    }



    private static HBox setErrorHBox(Parent parent){
        Text errorText = new Text("*");
        HBox hBox = new HBox(2);
        errorText.setVisible(false);
        errorText.setFont(Font.font(null,FontWeight.EXTRA_BOLD,23));
        errorText.getStyleClass().add("text-error");
        hBox.getChildren().addAll(parent,errorText);
        return hBox;
    }

    private static void makeRed(HBox hBox){
        if(hBox.getChildren().get(0)instanceof TextField) {
            hBox.getChildren().get(0).getStyleClass().add("text-field-error");
        }
        hBox.getChildren().get(1).setVisible(true);
    }
}
