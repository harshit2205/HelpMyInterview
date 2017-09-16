package Listener;

import Beans.Utils.EntryValidation;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import static Beans.Utils.ValidationUtils.formatErrorText;

/**
 * Created by staLker on 09-07-2017.
 */
public class PersonalityTabValidationListener {
    private static boolean firstNameVal = true;
    private static boolean lastNameVal = true;
    private static boolean emailVal = true;
    private static boolean contactVal = true;
    private static boolean yearVal = true;
    private static boolean monthVal = true;
    private static boolean deg1Val = true;
    private static boolean deg2Val = true;
    private static boolean deg3Val = true;
    private static boolean deg4Val = true;
    private static boolean acceptVal = false;
    private static Button saveButton;
    public static void validateAndListen(TextField firstNameTextField, TextField lastNameTextField,
                                         TextField eMailTextField, TextField contactTextField,
                                         ComboBox<Integer> selectDayComboBox, ComboBox<Integer> selectMonthComboBox, ComboBox<Integer> selectYearComboBox,
                                         ComboBox<String> degree1ComboBox, TextField course1TextField, TextField aggregate1TextField, TextField degree1TextField,
                                         ComboBox<String> degree2ComboBox, TextField course2TextField, TextField aggregate2TextField, TextField degree2TextField,
                                         ComboBox<String> degree3ComboBox, TextField course3TextField, TextField aggregate3TextField, TextField degree3TextField,
                                         ComboBox<String> degree4ComboBox, TextField course4TextField, TextField aggregate4TextField, TextField degree4TextField,
                                         CheckBox acceptCheckBox, Button saveButton, Text firstNameErrorText, Text lastNameErrorText, Text emailErrorText,
                                         Text contactErrorText, Text monthErrorText, Text yearErrorText, Text degree1ErrorText, Text degree2ErrorText,
                                         Text degree3ErrorText, Text degree4ErrorText) {
        PersonalityTabValidationListener.saveButton = saveButton;

        formatErrorText(firstNameErrorText);
        formatErrorText(lastNameErrorText);
        formatErrorText(emailErrorText);
        formatErrorText(contactErrorText);
        formatErrorText(monthErrorText);
        formatErrorText(yearErrorText);
        formatErrorText(degree1ErrorText);
        formatErrorText(degree2ErrorText);
        formatErrorText(degree3ErrorText);
        formatErrorText(degree4ErrorText);

        acceptCheckBox.setOnAction(e -> {
            acceptVal = acceptCheckBox.isSelected();
            checkIfAllTrue();
        });
        firstNameTextField.textProperty().addListener(((observable, oldValue, newValue) ->{
            if(EntryValidation.isFirstNameValid(newValue)){
                onCorrectMakeInvisible(firstNameErrorText);
                firstNameVal=true;
            }
            else if(!EntryValidation.isFirstNameValid(newValue)){
                onErrorMakeRed(firstNameErrorText);
                firstNameVal=false;
            }
            checkIfAllTrue();
        } ));
        lastNameTextField.textProperty().addListener(((observable, oldValue, newValue) ->{
            if(EntryValidation.isLastNameValid(newValue)){
                onCorrectMakeInvisible(lastNameErrorText);
                lastNameVal=true;
            }
            else if(!EntryValidation.isLastNameValid(newValue)){
                onErrorMakeRed(lastNameErrorText);
                lastNameVal=false;
            }
            checkIfAllTrue();
        } ));
        eMailTextField.textProperty().addListener(((observable, oldValue, newValue) ->{
            if(EntryValidation.isEmailValid(newValue)){
                onCorrectMakeInvisible(emailErrorText);
                emailVal=true;
            }
            else if(!EntryValidation.isEmailValid(newValue)){
                onErrorMakeRed(emailErrorText);
                emailVal=false;
            }
            checkIfAllTrue();
        } ));
        contactTextField.textProperty().addListener(((observable, oldValue, newValue) ->{
            if(EntryValidation.isContactValid(Long.parseLong(newValue))){
                onCorrectMakeInvisible(contactErrorText);
                contactVal=true;
            }
            else if(!EntryValidation.isContactValid(Long.parseLong(newValue))){
                onErrorMakeRed(contactErrorText);
                contactVal=false;
            }
            checkIfAllTrue();
        } ));
        selectDayComboBox.setOnAction(e -> {
            selectMonthComboBox.setDisable(false);
            onErrorMakeRed(monthErrorText);
            monthVal = false;
            checkIfAllTrue();
        });
        selectMonthComboBox.setOnAction(e -> {
            selectYearComboBox.setDisable(false);
            onCorrectMakeInvisible(monthErrorText);
            monthVal = true;
            onErrorMakeRed(yearErrorText);
            yearVal = false;
            checkIfAllTrue();
        });
        selectYearComboBox.setOnAction(e -> {
            onCorrectMakeInvisible(yearErrorText);
            yearVal = true;
            checkIfAllTrue();
        });



        degree1ComboBox.setOnAction(e -> {
            course1TextField.setDisable(false);
            onErrorMakeRed(degree1ErrorText);
            deg1Val=false;
            checkIfAllTrue();
        });
        course1TextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.intern()!=""){
                aggregate1TextField.setDisable(false);

            }
            else {
                aggregate1TextField.setDisable(true);
            }
            checkIfAllTrue();
        });
        aggregate1TextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.intern()!=""){
                degree1TextField.setDisable(false);
            }
            else {
                degree1TextField.setDisable(true);
            }
            checkIfAllTrue();
        });
        degree1TextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.intern()!=""){
                onCorrectMakeInvisible(degree1ErrorText);
                deg1Val = true;
            }
            else {
                onErrorMakeRed(degree1ErrorText);
                deg1Val = false;
            }
            checkIfAllTrue();
        });



        degree2ComboBox.setOnAction(e -> {
            course2TextField.setDisable(false);
            onErrorMakeRed(degree2ErrorText);
            deg2Val = false;
            checkIfAllTrue();
        });
        course2TextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.intern()!=""){
                aggregate2TextField.setDisable(false);

            }
            else {
                aggregate2TextField.setDisable(true);
            }
            checkIfAllTrue();
        });
        aggregate2TextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.intern()!=""){
                degree2TextField.setDisable(false);
            }
            else {
                degree2TextField.setDisable(true);
            }
            checkIfAllTrue();
        });
        degree2TextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.intern()!=""){
                onCorrectMakeInvisible(degree2ErrorText);
                deg2Val = true;

            }
            else {
                onErrorMakeRed(degree2ErrorText);
                deg2Val = false;
            }
            checkIfAllTrue();
        });



        degree3ComboBox.setOnAction(e -> {
            course3TextField.setDisable(false);
            onErrorMakeRed(degree3ErrorText);
            deg3Val = false;
            checkIfAllTrue();
        });
        course3TextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.intern()!=""){
                aggregate3TextField.setDisable(false);

            }
            else {
                aggregate3TextField.setDisable(true);
            }
            checkIfAllTrue();
        });
        aggregate3TextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.intern()!=""){
                degree3TextField.setDisable(false);
            }
            else {
                degree3TextField.setDisable(true);
            }
            checkIfAllTrue();
        });
        degree3TextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.intern()!=""){
                onCorrectMakeInvisible(degree3ErrorText);
                deg3Val = true;
            }
            else {
                onErrorMakeRed(degree3ErrorText);
                deg3Val = false;
            }
            checkIfAllTrue();
        });



        degree4ComboBox.setOnAction(e -> {
            course4TextField.setDisable(false);
            onErrorMakeRed(degree4ErrorText);
            deg4Val = false;
            checkIfAllTrue();
        });
        course4TextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.intern()!=""){
                aggregate4TextField.setDisable(false);

            }
            else {
                aggregate4TextField.setDisable(true);
            }
            checkIfAllTrue();
        });
        aggregate2TextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.intern()!=""){
                degree4TextField.setDisable(false);
            }
            else {
                degree4TextField.setDisable(true);
            }
            checkIfAllTrue();
        });
        degree4TextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.intern()!=""){
                onCorrectMakeInvisible(degree4ErrorText);
                deg4Val = true;
            }
            else {
                onErrorMakeRed(degree4ErrorText);
                deg4Val = false;
            }
            checkIfAllTrue();
        });

    }


    private static void onErrorMakeRed(Text errorText){
        errorText.setVisible(true);
    }
    private  static void onCorrectMakeInvisible(Text errorText){
        errorText.setVisible(false);
    }
    private static void checkIfAllTrue(){
        if(firstNameVal&&lastNameVal&&contactVal&&emailVal&&deg1Val&&deg2Val&&deg3Val&&deg4Val&&acceptVal){
            saveButton.setDisable(false);
        }
        else {
            saveButton.setDisable(true);
        }
    }
}
