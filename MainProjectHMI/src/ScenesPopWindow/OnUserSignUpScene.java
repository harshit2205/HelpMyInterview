package ScenesPopWindow;

import Models.EntryValidation;
import Models.User;
import Utils.Cities;
import Utils.States;
import javafx.geometry.Insets;
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
    private static boolean firstNameVal = false;
    private static boolean lastNameVal = false;
    private static boolean eMailVal = false;
    private static boolean contactVal = false;
    private static boolean userNameVal = false;
    private static boolean passwordVal = false;
    private static boolean genderVal = false;
    private static boolean stateVal = false;
    private static boolean cityVal = false;
    private static boolean acceptTermVal = false;
    private static Button registerButton;
    public static Scene getScene(){

        VBox root = new VBox(70);

        Text titleText = new Text("Enter your Details");
        titleText.setFont(Font.font(null, FontWeight.EXTRA_BOLD,30));
        titleText.setFill(Paint.valueOf("#01a0e4"));
        HBox titleTextHBox = new HBox();
        titleTextHBox.setStyle("-fx-background-color: #000000");
        titleTextHBox.setPadding(new Insets(10,10,10,10));
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
        maleRadioButton.setUserData("Male");
        maleRadioButton.setToggleGroup(genderToggleGroup);
        RadioButton femaleRadioButton = new RadioButton("Female");
        femaleRadioButton.setUserData("Female");
        femaleRadioButton.setToggleGroup(genderToggleGroup);
        HBox genderRadioButtonHBox = new HBox(15);
        genderRadioButtonHBox.getChildren().addAll(maleRadioButton,femaleRadioButton);
        usernameTextField.setPromptText("enter a username");
        PasswordField passwordTextField = new PasswordField();
        passwordTextField.setPromptText("set your Password");
        PasswordField repeatPasswordTextField = new PasswordField();
        repeatPasswordTextField.setPromptText("re-enter the Password");
        ComboBox<String> statesComboBox = new ComboBox<>(States.getAllStates());
        statesComboBox.setPromptText("select states");
        ComboBox<String> cityComboBox = new ComboBox<String>(Cities.getAllCities());
        cityComboBox.setPromptText("select city");
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
        HBox cityComboBoxErrorHBox = setErrorHBox(cityComboBox);
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




        registerButton = new Button("Register!");
        registerButton.setDisable(true);


        firstNameTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if(EntryValidation.isFirstNameValid(newValue)){
                onCorrectMakeInvisible(firstNameErrorHBox);
                firstNameVal=true;
            }
            else if(!EntryValidation.isFirstNameValid(newValue)){
                onErrorMakeRed(firstNameErrorHBox);
                firstNameVal=false;
            }
            checkIfAllTrue();
        });
        lastNameTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if(EntryValidation.isLastNameValid(newValue)){
                onCorrectMakeInvisible(lastNameErrorHBox);
                lastNameVal=true;
            }
            else if(!EntryValidation.isFirstNameValid(newValue)){
                onErrorMakeRed(lastNameErrorHBox);
                lastNameVal=false;
            }
            checkIfAllTrue();
        });
        eMailTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if(EntryValidation.isEmailValid(newValue)){
                onCorrectMakeInvisible(eMailErrorHBox);
                eMailVal=true;
            }
            else if(!EntryValidation.isEmailValid(newValue)){
                onErrorMakeRed(eMailErrorHBox);
                eMailVal=false;
            }
            checkIfAllTrue();
        });
        contactTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if(EntryValidation.isContactValid(Long.parseLong(newValue))){
                onCorrectMakeInvisible(contactErrorHBox);
                contactVal=true;
            }
            else if(!EntryValidation.isContactValid(Long.parseLong(newValue))){
                onErrorMakeRed(contactErrorHBox);
                contactVal=false;
            }
            checkIfAllTrue();
        });
        genderToggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if(genderToggleGroup.getSelectedToggle() != null){
                onCorrectMakeInvisible(genderErrorHBox);
                genderVal=true;
            }

            checkIfAllTrue();
        });
        usernameTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if(genderToggleGroup.getSelectedToggle() != null){
                onCorrectMakeInvisible(genderErrorHBox);
                genderVal=true;
            }
            else {
                onErrorMakeRed(genderErrorHBox);
                genderVal=false;
            }
            if(EntryValidation.isUserNameValid(newValue)){
                onCorrectMakeInvisible(userNameErrorHBox);
                userNameVal=true;
            }
            else if(!EntryValidation.isUserNameValid(newValue)){
                onErrorMakeRed(userNameErrorHBox);
                userNameVal=false;
            }
            checkIfAllTrue();
        });
        repeatPasswordTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if(EntryValidation.isPasswordValid(passwordTextField.getText(),newValue)){
                onCorrectMakeInvisible(passwordErrorHBox);
                onCorrectMakeInvisible(repeatPasswordErrorHBox);
                passwordVal=true;
            }
            else if(!EntryValidation.isPasswordValid(passwordTextField.getText(),newValue)){
                onErrorMakeRed(passwordErrorHBox);
                onErrorMakeRed(repeatPasswordErrorHBox);
                passwordVal=false;
            }
            checkIfAllTrue();

        });
        statesComboBox.setOnAction(e -> {
            if(statesComboBox.getSelectionModel().getSelectedItem()!=null){
                stateVal = true;
                onCorrectMakeInvisible(stateComboBoxErrorHBox);
            }
            else {
                stateVal = false;
                onErrorMakeRed(stateComboBoxErrorHBox);
            }
            checkIfAllTrue();
        });
        cityComboBox.setOnAction(e -> {
            if(cityComboBox.getSelectionModel().getSelectedItem()!=null){
                onCorrectMakeInvisible(cityComboBoxErrorHBox);
                cityVal = true;
            }
            else {
                cityVal = false;
                onErrorMakeRed(cityComboBoxErrorHBox);
            }
            checkIfAllTrue();
        });
        acceptCheckBox.selectedProperty().addListener(e -> {
            acceptTermVal = acceptCheckBox.isSelected();
            if(acceptTermVal){
                onCorrectMakeInvisible(acceptCheckBoxErrorHBox);
            }
            else{
                onErrorMakeRed(acceptCheckBoxErrorHBox);
            }
            checkIfAllTrue();
        });


        registerButton.setOnAction(e -> {
            User user = new User();

            user.setUserDetails(
                    firstNameTextField.getText(),
                    lastNameTextField.getText(),
                    eMailTextField.getText(),
                    Long.parseLong(contactTextField.getText()),
                    genderToggleGroup.getSelectedToggle().getUserData().toString(),
                    usernameTextField.getText(),
                    passwordTextField.getText(),
                    statesComboBox.getValue(),
                    cityComboBox.getValue()
            );

            user.printUser();

        });

        root.getChildren().addAll(titleTextHBox,formPane,acceptCheckBoxErrorHBox,registerButton);
        root.setAlignment(Pos.CENTER);

        OnUserSignUpSceneListener.listen(firstNameTextField,lastNameTextField,eMailTextField,contactTextField,genderToggleGroup,usernameTextField,passwordTextField,repeatPasswordTextField,statesComboBox,cityComboBox,registerButton);


        return new Scene(root,500,900);
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

    private static void onErrorMakeRed(HBox hBox){
//        if(hBox.getChildren().get(0)instanceof TextField) {
//            if(hBox.getChildren().get(0).getStyleClass().contains("text-field-normal")){
//                hBox.getChildren().get(0).getStyleClass().remove("text-field-normal");
//                hBox.getChildren().get(0).getStyleClass().add("text-field-error");
//            }
//        }
        hBox.getChildren().get(1).setVisible(true);
    }
    private  static void onCorrectMakeInvisible(HBox hBox){
//        if(hBox.getChildren().get(0)instanceof TextField) {
//            if(hBox.getChildren().get(0).getStyleClass().contains("text-field-error")){
//                hBox.getChildren().get(0).getStyleClass().remove("text-field-error");
//                hBox.getChildren().get(0).getStyleClass().add("text-field-normal");
//            }
//        }
        hBox.getChildren().get(1).setVisible(false);
    }

    private static void checkIfAllTrue(){
        if(firstNameVal&&lastNameVal &&eMailVal &&contactVal &&userNameVal &&passwordVal &&genderVal&&stateVal&&cityVal&&acceptTermVal){
            registerButton.setDisable(false);
        }
        else {
            registerButton.setDisable(true);
        }
    }
}
