package Listener;

import Beans.Utils.EntryValidation;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;

import static Beans.Utils.ValidationUtils.onCorrectMakeInvisible;
import static Beans.Utils.ValidationUtils.onErrorMakeRed;

/**
 * Created by staLker on 08-07-2017.
 */
public class OnUserSignUpValidationListener {
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
    public static void validateAndListen(Button registerButton, TextField firstNameTextField, HBox firstNameErrorHBox, TextField lastNameTextField, HBox lastNameErrorHBox, TextField eMailTextField, HBox eMailErrorHBox, TextField contactTextField, HBox contactErrorHBox, ToggleGroup genderToggleGroup, HBox genderErrorHBox, TextField usernameTextField, HBox userNameErrorHBox, PasswordField passwordTextField, PasswordField repeatPasswordTextField, HBox passwordErrorHBox, HBox repeatPasswordErrorHBox, ComboBox<String> statesComboBox, HBox stateComboBoxErrorHBox, ComboBox<String> cityComboBox, HBox cityComboBoxErrorHBox, HBox acceptCheckBoxErrorHBox, CheckBox acceptCheckBox) {

        OnUserSignUpValidationListener.registerButton = registerButton;

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
