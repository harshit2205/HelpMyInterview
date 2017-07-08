package Utils;


import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Created by USER on 7/9/2017.
 */
public class FormatButton extends Button {
    public FormatButton(String s, TextField textField){

        setText(s);

        setOnAction(e -> {
            if(textField.isDisable()){
            textField.setDisable(false);
            }
            else {
                textField.setDisable(true);
            }
        });
    }




}
