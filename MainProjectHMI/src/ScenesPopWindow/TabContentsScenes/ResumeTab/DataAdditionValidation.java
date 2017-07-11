package ScenesPopWindow.TabContentsScenes.ResumeTab;

import javafx.scene.control.*;

/**
 * Created by staLker on 11-07-2017.
 */
public class DataAdditionValidation {
    public static void validate(TextField skillNameTextField, ComboBox<String> experienceLevelComboBox, Button saveButton){
        experienceLevelComboBox.setDisable(true);
        saveButton.setDisable(true);
        skillNameTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.intern()!=""){
                experienceLevelComboBox.setDisable(false);
            }
            else {
                experienceLevelComboBox.setDisable(true);
                saveButton.setDisable(true);
            }
        });
        experienceLevelComboBox.setOnAction(e -> {
            saveButton.setDisable(false);
        });
    }

    public static void validate(TextField trainingProgramTextField, TextField organizationTextField, CheckBox onlineTrainingCheckbox, TextField locationTextField, TextArea descriptionTextArea, Button saveButton) {
        saveButton.setDisable(true);
        trainingProgramTextField.textProperty().addListener((observable, oldValue, newValue) -> {
                saveButton.setDisable(newValue.intern()=="");
        });
        organizationTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            saveButton.setDisable(newValue.intern()=="");
        });
        onlineTrainingCheckbox.setOnAction(e -> {
            locationTextField.setDisable(onlineTrainingCheckbox.isSelected());
        });
        locationTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            saveButton.setDisable(newValue.intern()=="");
        });
        descriptionTextArea.textProperty().addListener((observable, oldValue, newValue) -> {
            saveButton.setDisable(newValue.intern()=="");
        });
    }
}
