package Utils;

import javafx.scene.control.TextField;

/**
 * Created by USER on 7/9/2017.
 */
public class BaseUtilities {
    public static void toggleTextField(TextField textField){

        if(textField.isDisable()){
            textField.setDisable(false);
        }
        else {
            textField.setDisable(true);
        }
    }
}
