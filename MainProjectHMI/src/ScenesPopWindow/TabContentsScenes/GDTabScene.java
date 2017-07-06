package ScenesPopWindow.TabContentsScenes;

import Scenes.EnterGDScene;
import Scenes.OnUserLogInScene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GDTabScene {

    public static Scene getScene(){
        Scene scene ;

       //Base Pane.
        VBox basePane = new VBox(10);

        //Header VBox here ......................
        VBox headerVBox = new VBox(10);
        HBox headerHBox = new HBox();
        headerHBox.setStyle("-fx-background-color: #000000");
        headerHBox.setAlignment(Pos.CENTER);
        Label doLabel = new Label("Do's of Group Disscussion");
        TextArea doTextArea = new TextArea("1. speak when ur turn comes\n2.\n3.");
        doTextArea.setEditable(false);
        doTextArea.setWrapText(true);
        headerHBox.getChildren().add(doLabel);
        headerVBox.getChildren().addAll(headerHBox,doTextArea);


        //footer HBox here.......................
        VBox footerVBox = new VBox(10);
        HBox footerHBox = new HBox();
        footerHBox.setStyle("-fx-background-color: #000000");
        footerHBox.setAlignment(Pos.CENTER);
        Label dontLabel = new Label("Dont's of Group Disscussion");
        TextArea dontTextArea = new TextArea("1. speak when ur turn comes\n2.\n3.");
        dontTextArea.setEditable(false);
        dontTextArea.setWrapText(true);
        footerHBox.getChildren().add(dontLabel);
        footerVBox.getChildren().addAll(footerHBox,dontTextArea);


        Button enterGD = new Button("Enter Group Disscussion");

        basePane.setAlignment(Pos.CENTER);
        basePane.getChildren().addAll(headerVBox, footerVBox, enterGD);
        basePane.setPadding(new Insets(30,20,0,20));
        scene = new Scene(basePane,400,400);
        enterGD.setOnAction(e -> {
            OnUserLogInScene.getWindow().setScene(EnterGDScene.getScene());
        });

        return scene;
    }
}
