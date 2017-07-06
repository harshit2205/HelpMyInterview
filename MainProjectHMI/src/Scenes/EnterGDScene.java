package Scenes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/**
 * Created by USER on 7/6/2017.
 */
public class EnterGDScene {
    public static Scene getScene(){
        HBox hBox = new HBox();
        Label label = new Label("Topics of Group Disscussion : ");
        hBox.getChildren().add(label);



        Scene scene = new Scene(hBox,400,400);
        return scene;
    }
}
