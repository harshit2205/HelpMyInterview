package ScenesPopWindow.TabContentsScenes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/**
 * Created by staLker on 02-07-2017.
 */
public class GDTabScene {
    public static Scene getScene(){

        HBox hBox = new HBox();
        Label label = new Label("GD Tab coming soon...");
        hBox.getChildren().add(label);
        hBox.setAlignment(Pos.CENTER);



        Scene scene = new Scene(hBox,400,400);
        return scene;
    }
}
