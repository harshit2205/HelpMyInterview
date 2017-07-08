package ScenesPopWindow.TabContentsScenes;

import Models.User;
import Models.UserLab;
import Scenes.OnUserLogInScene;
import Utils.DOB;
import Utils.Education;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.*;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import static Utils.ValidationUtils.formatErrorText;


/**
 * Created by staLker on 06-07-2017.
 */
public class PersonalityTabListener {


    public static void listen(ImageView profilePicture, Button editProfilePictureButton, TextField firstNameTextField, TextField lastNameTextField, TextField userNameTextField, ComboBox<String> genderComboBox, TextField eMailTextField, Button editEmailButton, TextField contactTextField, Button editContactButton, ComboBox<String> selectDayComboBox, ComboBox<String> selectMonthComboBox, ComboBox<String> selectYearComboBox, TextArea bioTextArea, ComboBox<String> degree1ComboBox, TextField course1TextField, TextField degree1TextField, ComboBox<String> degree2ComboBox, TextField course2TextField, TextField degree2TextField, ComboBox<String> degree3ComboBox, TextField course3TextField, TextField degree3TextField, ComboBox<String> degree4ComboBox, TextField course4TextField, TextField degree4TextField, TextField homeTownTextField, Button homeTownEditButton, TextField currentCityTextField, Button currentCityEditButton, TextField stateTextField, Button stateEditButton, TextArea aboutYourselfTextArea, CheckBox acceptCheckBox, Button saveButton, Text firstNameErrorText, Text lastNameErrorText, Text emailErrorText, Text contactErrorText, Text monthErrorText, Text yearErrorText, Text degree1ErrorText, Text degree2ErrorText, Text degree3ErrorText, Text degree4ErrorText) {

        UserLab userLab = UserLab.get();
        String userName = OnUserLogInScene.getUserName();
        User user = userLab.getUserByUserName(userName);

        saveButton.setDisable(true);

        addDegreeList(degree1ComboBox);
        addDegreeList(degree2ComboBox);
        addDegreeList(degree3ComboBox);
        addDegreeList(degree4ComboBox);

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

        if(user.getUserImage()!=null){
            profilePicture.setImage(user.getUserImage());
        }
        firstNameTextField.setText(user.getFirstName());
        lastNameTextField.setText(user.getLastName());
        userNameTextField.setText(userName);
        genderComboBox.setValue(user.getGender());
        eMailTextField.setText(user.getEmail());
        contactTextField.setText(user.getContact().toString());
        if (user.getDob()!=null){
            selectDayComboBox.setValue(user.getDob().getDate());
            selectMonthComboBox.setValue(user.getDob().getMonth());
            selectYearComboBox.setValue(user.getDob().getYear());
        }
        selectMonthComboBox.setDisable(true);
        selectYearComboBox.setDisable(true);
        if(user.getBio()!=null){
            bioTextArea.setText(user.getBio());
        }
        bioTextArea.setWrapText(true);
        if(user.getHomeTown()!=null){
            homeTownTextField.setText(user.getHomeTown());
        }
        if(user.getEducation().size()>0){
            degree1ComboBox.setValue(user.getEducation().get(0).getDegree());
            course1TextField.setText(user.getEducation().get(0).getCourse());
            degree1TextField.setText(user.getEducation().get(0).getInstitution());
        }
        if(user.getEducation().size()>1){
            degree2ComboBox.setValue(user.getEducation().get(1).getDegree());
            course2TextField.setText(user.getEducation().get(1).getCourse());
            degree2TextField.setText(user.getEducation().get(1).getInstitution());
        }
        if(user.getEducation().size()>2){
            degree3ComboBox.setValue(user.getEducation().get(2).getDegree());
            course3TextField.setText(user.getEducation().get(2).getCourse());
            degree3TextField.setText(user.getEducation().get(2).getInstitution());
        }
        if(user.getEducation().size()>3){
            degree4ComboBox.setValue(user.getEducation().get(3).getDegree());
            course4TextField.setText(user.getEducation().get(3).getCourse());
            degree4TextField.setText(user.getEducation().get(3).getInstitution());
        }

        currentCityTextField.setText(user.getCity());
        stateTextField.setText(user.getState());
        if(user.getAbout()!=null){
            aboutYourselfTextArea.setText(user.getAbout());
        }

        aboutYourselfTextArea.setWrapText(true);


////////////////////////----------------------------------------->listeners beyond this line----------------------------->


        ////////////------>personal detail listener/////////
        editProfilePictureButton.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Select Profile Picture");
            fileChooser.setInitialDirectory(
                    new File(System.getProperty("user.home"))
            );
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                    new FileChooser.ExtensionFilter("PNG", "*.png")
            );
            File selectedFile = fileChooser.showOpenDialog(null);
            try {
                BufferedImage bufferedImage = ImageIO.read(selectedFile);
                Image image = SwingFXUtils.toFXImage(bufferedImage, null);
                profilePicture.setImage(image);
            } catch (IOException ex) {
                Logger.getLogger(PersonalityTabListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        firstNameTextField.textProperty().addListener(((observable, oldValue, newValue) -> {

        }));
        lastNameTextField.textProperty().addListener(((observable, oldValue, newValue) -> {

        }));
        editEmailButton.setOnAction(e -> {
            toggleTextField(eMailTextField);
        });
        editContactButton.setOnAction(e ->{
             toggleTextField(contactTextField);
        });
        selectDayComboBox.setOnAction(e -> {
            selectMonthComboBox.setDisable(false);
        });
        selectMonthComboBox.setOnAction(e -> {
            selectYearComboBox.setDisable(false);
        });
        //////////////////////--------------->personal detail end////////////


        ///////////////////------------>education listener///////

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




        /////////---------------->education ends///////////



        ////////////------------------->location stars/////////////
        homeTownEditButton.setOnAction(e -> {
            toggleTextField(homeTownTextField);
        });
        currentCityEditButton.setOnAction(e -> {
            toggleTextField(currentCityTextField);
        });
        stateEditButton.setOnAction(e ->{
            toggleTextField(stateTextField);
        });



        ///////////////////////////---------------->location ends/////////




        acceptCheckBox.setOnAction(e -> {
            if(acceptCheckBox.isSelected()){
                saveButton.setDisable(false);
            }
            else {
                saveButton.setDisable(true);
            }
        });

        saveButton.setOnAction(e -> {
            ArrayList<Education> educationList = new ArrayList<>(4);
            if(degree1TextField.getText()!=null)
                educationList.add(new Education(degree1ComboBox.getValue(),course1TextField.getText(),degree1TextField.getText()));
            if(degree2TextField.getText()!=null)
                educationList.add(new Education(degree2ComboBox.getValue(),course2TextField.getText(),degree2TextField.getText()));
            if(degree3TextField.getText()!=null)
                educationList.add(new Education(degree3ComboBox.getValue(),course3TextField.getText(),degree3TextField.getText()));
            if(degree4TextField.getText()!=null)
                educationList.add(new Education(degree4ComboBox.getValue(),course4TextField.getText(),degree4TextField.getText()));
            user.personalityUpdate(
                    profilePicture.getImage(),
                    firstNameTextField.getText(),
                    lastNameTextField.getText(),
                    userNameTextField.getText(),
                    genderComboBox.getValue(),
                    eMailTextField.getText(),
                    contactTextField.getText(),
                    new DOB(selectDayComboBox.getValue(),selectMonthComboBox.getValue(),selectYearComboBox.getValue()),
                    bioTextArea.getText(),
                    educationList,
                    homeTownTextField.getText(),
                    currentCityTextField.getText(),
                    stateTextField.getText(),
                    aboutYourselfTextArea.getText()
            );

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
    private static void checkIfDegreeChanged(TextField textField,boolean isEdited){

    }

    private static void onErrorMakeRed(Text errorText){
        errorText.setVisible(true);
    }
    private  static void onCorrectMakeInvisible(Text errorText){
        errorText.setVisible(false);
    }
}
