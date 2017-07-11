package ScenesPopWindow.TabContentsScenes;

import Scenes.EnterGDScene;
import Scenes.OnUserLogInScene;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 * Created by staLker on 30-06-2017.
 */

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
        Label doLabel = new Label("Do's of Group Discussion");
        TextArea doTextArea = new TextArea("1. Listen to the subject carefully.\n" +
                "2. Put down your thoughts on a paper.\n" +
                "3. Initiate the discussion if you know the subject well.\n" +
                "4. Listen to others if you don't know the subject.\n" +
                "5. Support your point with some facts and figures.\n" +
                "6. Make short contribution of 25-30 seconds 3-4 times.\n" +
                "7. Give others a chance to speak.\n" +
                "8. Speak politely and pleasantly. Respect contribution from other members.\n" +
                "9. Disagree politely and agree with what is right.\n" +
                "10. Summarize the discussion if the group has not reached a conclusion.\n");
        doTextArea.setEditable(false);
        doTextArea.setWrapText(true);
        headerHBox.getChildren().add(doLabel);
        headerVBox.getChildren().addAll(headerHBox,doTextArea);


        //footer HBox here.......................
        VBox footerVBox = new VBox(10);
        HBox footerHBox = new HBox();
        footerHBox.setStyle("-fx-background-color: #000000");
        footerHBox.setAlignment(Pos.CENTER);
        Label dontLabel = new Label("Don'ts of Group Discussion");
        TextArea dontTextArea = new TextArea("1. Initiate the discussion if you do not have sufficient knowledge about the given topic.\n" +
                "2. Over speak, intervene and snatch other's chance to speak.\n" +
                "3. Argue and shout during the GD.\n" +
                "4. Talk irrelevant things and distract the discussion.\n" +
                "5. Mention erratic statistics.\n" +
                "6. Try to dominate the discussion.\n" +
                "7. Put others in an embarrassing situation by asking them to speak if they don't want.\n");
        dontTextArea.setEditable(false);
        dontTextArea.setWrapText(true);
        footerHBox.getChildren().add(dontLabel);
        footerVBox.getChildren().addAll(footerHBox,dontTextArea);


        Button enterGD = new Button("Enter Group Discussion");
        enterGD.setOnAction(e -> {
            OnUserLogInScene.getWindow().setScene(EnterGDScene.getScene());
        });




        basePane.setAlignment(Pos.TOP_CENTER);
        basePane.getChildren().addAll(headerVBox, footerVBox, enterGD);
        basePane.setPadding(new Insets(10,20,20,20));
        basePane.setMinHeight(800);
        basePane.setMaxWidth(580);

        // Adding ScrollBar......................
        ScrollPane scrollPane = new ScrollPane();
        VBox.setVgrow(scrollPane, Priority.ALWAYS);
        scrollPane.setVmax(10000);
        scrollPane.setPrefSize(500, 600);

        scrollPane.setContent(basePane);
        scrollPane.vvalueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                                Number old_val, Number new_val) {

            }
        });

        VBox root = new VBox();
        root.getChildren().addAll(scrollPane);

        scene = new Scene(root,600,600);


        return scene;
    }
}
