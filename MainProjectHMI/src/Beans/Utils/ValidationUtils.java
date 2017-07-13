package Beans.Utils;

import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * Created by staLker on 08-07-2017.
 */
public class ValidationUtils {
    public static HBox setErrorHBox(Parent parent){
        Text errorText = new Text("*");
        HBox hBox = new HBox(2);
        errorText.setVisible(false);
        errorText.setFont(Font.font(null, FontWeight.EXTRA_BOLD,23));
        errorText.getStyleClass().add("text-error");
        hBox.getChildren().addAll(parent,errorText);
        return hBox;
    }

    public static void onErrorMakeRed(HBox hBox){
//        if(hBox.getChildren().get(0)instanceof TextField) {
//            if(hBox.getChildren().get(0).getStyleClass().contains("text-field-normal")){
//                hBox.getChildren().get(0).getStyleClass().remove("text-field-normal");
//                hBox.getChildren().get(0).getStyleClass().add("text-field-error");
//            }
//        }
        hBox.getChildren().get(1).setVisible(true);
    }
    public static void onCorrectMakeInvisible(HBox hBox){
//        if(hBox.getChildren().get(0)instanceof TextField) {
//            if(hBox.getChildren().get(0).getStyleClass().contains("text-field-error")){
//                hBox.getChildren().get(0).getStyleClass().remove("text-field-error");
//                hBox.getChildren().get(0).getStyleClass().add("text-field-normal");
//            }
//        }
        hBox.getChildren().get(1).setVisible(false);
    }
    public static void formatErrorText(Text errorText){
        errorText.setVisible(false);
        errorText.setFont(javafx.scene.text.Font.font(null,FontWeight.EXTRA_BOLD,23));
        errorText.getStyleClass().add("text-error");

    }
}
