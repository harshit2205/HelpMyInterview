package ScenesPopWindow.TabContentsScenes;

import javafx.scene.control.*;
import javafx.scene.image.ImageView;

/**
 * Created by staLker on 06-07-2017.
 */
public class PersonalityTabListener {

    public static void listen(ImageView profilePicture, Button editProfilePictureButton, TextField userNameTextField, Button editUsernameButton, ComboBox<String> genderChoiceBox, TextField eMailTextField, Button editEmailButton, TextField contactTextField, Button editContactButton, ComboBox<String> selectDayComboBox, ComboBox<String> selectMonthComboBox, ComboBox<String> selectYearComboBox, TextArea bioTextArea, ComboBox<String> degree1ComboBox, TextField degree1TextField, ComboBox<String> degree2ComboBox, TextField degree2TextField, ComboBox<String> degree3ComboBox, TextField degree3TextField, ComboBox<String> degree4ComboBox, TextField degree4TextField, TextField homeTownTextField, Button homeTownEditButton, TextField currentCityTextField, Button currentCityEditButton, TextField stateTextField, Button stateEditButton, TextArea aboutYourselfTextArea, CheckBox acceptCheckBox, Button saveButton) {



        addDegreeList(degree1ComboBox);
        addDegreeList(degree2ComboBox);
        addDegreeList(degree3ComboBox);
        addDegreeList(degree4ComboBox);


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
                degree1TextField.setDisable(false);
            }

        });
        degree2ComboBox.setOnAction(e -> {
            if(degree2ComboBox.getSelectionModel().getSelectedItem()!=null){
                degree2TextField.setDisable(false);
            }

        });
        degree3ComboBox.setOnAction(e -> {
            if(degree3ComboBox.getSelectionModel().getSelectedItem()!=null){
                degree3TextField.setDisable(false);
            }

        });
        degree4ComboBox.setOnAction(e -> {
            if(degree4ComboBox.getSelectionModel().getSelectedItem()!=null){
                degree4TextField.setDisable(false);
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
        comboBox.getItems().addAll("B-Tech.","M-Tech.");
    }
}
