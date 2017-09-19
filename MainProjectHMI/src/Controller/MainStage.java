package Controller; /**
 * Created by staLker on 30-06-2017.
 */

import GUI.Scenes.*;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class MainStage extends Application {

    public static void main(String[] args) {launch(args);}

    @Override
    public void start(Stage primaryStage) {
        Stage window = primaryStage;
        UserLoginScene.passControl(window);
        //window.setScene(scene);
        window.setResizable(false);
        window.setTitle("Help My Interview!");
        //window.setOpacity(0.93);
    }


}
