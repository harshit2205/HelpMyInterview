package ScenesPopWindow.TabContentsScenes.ResumeTab;

import javafx.scene.control.*;

/**
 * Created by staLker on 11-07-2017.
 */
public class DataAdditionValidation {
    private static boolean titleVal = false;
    private static boolean organizationVal = false;
    private static boolean checkboxVal = false;
    private static boolean locationVal = false;
    private static boolean descriptionVal = false;
    private static Button saveButton;
    private static boolean linkVal = false;

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

    public static void validate(TextField title, TextField organization, CheckBox checkbox, TextField location, TextArea description, Button saveButton, String message) {
        saveButton.setDisable(true);
        titleVal = false;
        organizationVal = false;
        checkboxVal = false;
        locationVal = false;
        descriptionVal = false;
        DataAdditionValidation.saveButton = saveButton;
        title.textProperty().addListener((observable, oldValue, newValue) -> {
            titleVal = newValue.intern()!="";
            checkIfAllFilledOne();
        });
        organization.textProperty().addListener((observable, oldValue, newValue) -> {
            organizationVal = newValue.intern()!="";
            checkIfAllFilledOne();
        });
        checkbox.setOnAction(e -> {
            if(checkbox.isSelected()){
                location.setText(message);
                location.setDisable(true);
                checkboxVal = true;
            }
            else {
                location.setText("");
                location.setDisable(false);
                checkboxVal = false;
            }
            checkIfAllFilledOne();
        });
        location.textProperty().addListener((observable, oldValue, newValue) -> {
            locationVal = newValue.intern()!="";
            checkIfAllFilledOne();
        });
        description.textProperty().addListener((observable, oldValue, newValue) -> {
            descriptionVal = newValue.intern()!="";
            checkIfAllFilledOne();
        });
    }
    public static void validate(TextField projectTitleTextField, TextField projectLinkTextField, TextArea projectDescriptionTextArea, Button saveButton) {
        saveButton.setDisable(true);
        titleVal = false;
        linkVal = false;
        descriptionVal = false;
        DataAdditionValidation.saveButton = saveButton;
        projectTitleTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            titleVal = newValue.intern()!="";
            checkIfAllFilledTwo();
        });
        projectLinkTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            linkVal = newValue.intern()!="";
            checkIfAllFilledTwo();
        });
        projectDescriptionTextArea.textProperty().addListener((observable, oldValue, newValue) -> {
            descriptionVal = newValue.intern()!="";
            checkIfAllFilledTwo();
        });
    }

    private static void checkIfAllFilledOne() {
        if(titleVal&&organizationVal&&(locationVal||checkboxVal)&&descriptionVal){
            saveButton.setDisable(false);
        }
        else {
            saveButton.setDisable(true);
        }
    }
    private static void checkIfAllFilledTwo() {
        if(titleVal&&linkVal&&descriptionVal){
            saveButton.setDisable(false);
        }
        else {
            saveButton.setDisable(true);
        }
    }


}
