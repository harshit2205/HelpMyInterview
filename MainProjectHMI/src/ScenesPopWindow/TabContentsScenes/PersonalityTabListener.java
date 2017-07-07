package ScenesPopWindow.TabContentsScenes;

import Models.User;
import Models.UserLab;
import Scenes.OnUserLogInScene;
import Utils.Education;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

/**
 * Created by staLker on 06-07-2017.
 */
public class PersonalityTabListener {

    public static void listen(ImageView profilePicture, Button editProfilePictureButton, TextField firstNameTextField, TextField lastNameTextField, TextField userNameTextField, Button editUsernameButton, ComboBox<String> genderComboBox, TextField eMailTextField, Button editEmailButton, TextField contactTextField, Button editContactButton, ComboBox<String> selectDayComboBox, ComboBox<String> selectMonthComboBox, ComboBox<String> selectYearComboBox, TextArea bioTextArea, ComboBox<String> degree1ComboBox, TextField course1TextField, TextField degree1TextField, ComboBox<String> degree2ComboBox, TextField course2TextField, TextField degree2TextField, ComboBox<String> degree3ComboBox, TextField course3TextField, TextField degree3TextField, ComboBox<String> degree4ComboBox, TextField course4TextField, TextField degree4TextField, TextField homeTownTextField, Button homeTownEditButton, TextField currentCityTextField, Button currentCityEditButton, TextField stateTextField, Button stateEditButton, TextArea aboutYourselfTextArea, CheckBox acceptCheckBox, Button saveButton) {

        UserLab userLab = UserLab.get();
        String userName = OnUserLogInScene.getUserName();
        User user = userLab.getUserByUserName(userName);

        saveButton.setDisable(true);

        addDegreeList(degree1ComboBox);
        addDegreeList(degree2ComboBox);
        addDegreeList(degree3ComboBox);
        addDegreeList(degree4ComboBox);



        firstNameTextField.setText(user.getFirstName());
        lastNameTextField.setText(user.getLastName());
        userNameTextField.setText(userName);
        eMailTextField.setText(user.getEmail());
        contactTextField.setText(user.getContact().toString());
        genderComboBox.setValue(user.getGender());
        bioTextArea.setText(user.getBio());
        homeTownTextField.setText(user.getCity());
        currentCityTextField.setText(user.getCity());
        stateTextField.setText(user.getState());




        editUsernameButton.setOnAction(e -> {
            toggleTextField(userNameTextField);
        });
        editEmailButton.setOnAction(e -> {
            toggleTextField(eMailTextField);
        });
        editContactButton.setOnAction(e ->{
             toggleTextField(contactTextField);
        });

        degree1ComboBox.setOnAction(e -> {
            if(degree1ComboBox.getSelectionModel().getSelectedItem()!=null){
                course1TextField.setDisable(false);
            }

        });
        course1TextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.intern()!=""){
                degree1TextField.setDisable(false);
            }
            else {
                degree1TextField.setDisable(true);
            }
        });
        degree2ComboBox.setOnAction(e -> {
            if(degree2ComboBox.getSelectionModel().getSelectedItem()!=null){
                course2TextField.setDisable(false);
            }

        });
        course2TextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.intern()!=""){
                degree2TextField.setDisable(false);
            }
            else {
                degree2TextField.setDisable(true);
            }
        });
        degree3ComboBox.setOnAction(e -> {
            if(degree3ComboBox.getSelectionModel().getSelectedItem()!=null){
                course3TextField.setDisable(false);
            }

        });
        course3TextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.intern()!=""){
                degree3TextField.setDisable(false);
            }
            else {
                degree3TextField.setDisable(true);
            }
        });
        degree4ComboBox.setOnAction(e -> {
            if(degree4ComboBox.getSelectionModel().getSelectedItem()!=null){
                course4TextField.setDisable(false);
            }

        });
        course4TextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.intern()!=""){
                degree4TextField.setDisable(false);
            }
            else {
                degree4TextField.setDisable(true);
            }
        });
        homeTownEditButton.setOnAction(e -> {
            toggleTextField(homeTownTextField);
        });
        currentCityEditButton.setOnAction(e -> {
            toggleTextField(currentCityTextField);
        });
        stateEditButton.setOnAction(e ->{
            toggleTextField(stateTextField);
        });
        acceptCheckBox.setOnAction(e -> {
            if(acceptCheckBox.isSelected()){
                saveButton.setDisable(false);
            }
            else {
                saveButton.setDisable(true);
            }
        });


    }
    private static void toggleTextField(TextField textField){

            if(textField.isDisable()){
                textField.setDisable(false);
            }
            else {
                textField.setDisable(true);
            }
    }
    private static void TextField(ComboBox<String> comboBox){
    }
    private static void addDegreeList(ComboBox<String> comboBox){
        comboBox.getItems().addAll(Education.getAllDegree());
    }
}
