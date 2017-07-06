/**
 * Created by staLker on 30-06-2017.
 */

import Scenes.*;
import javafx.application.Application;
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
