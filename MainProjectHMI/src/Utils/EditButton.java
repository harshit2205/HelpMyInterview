package Utils;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Created by USER on 7/9/2017.
 */
public class EditButton extends Button {
    public EditButton(String text, TextField textField){
        setText(text);
        setOnAction(e -> {
            textField.setDisable(!textField.isDisabled());
        });
    }




}
