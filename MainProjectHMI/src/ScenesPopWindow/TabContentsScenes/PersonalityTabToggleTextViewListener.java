package ScenesPopWindow.TabContentsScenes;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Created by staLker on 09-07-2017.
 */
public class PersonalityTabToggleTextViewListener {
    public static void toggle(TextField eMailTextField, Button editEmailButton, TextField contactTextField, Button editContactButton, TextField homeTownTextField, Button homeTownEditButton, TextField currentCityTextField, Button currentCityEditButton, TextField stateTextField, Button stateEditButton) {
        editEmailButton.setOnAction(e -> {
            toggleTextField(eMailTextField);
        });
        editContactButton.setOnAction(e ->{
            toggleTextField(contactTextField);
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
}
