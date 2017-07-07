package Scenes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class EnterGDScene {
    public static Scene getScene(){
        Scene scene ;
        VBox vBox = new VBox(20);

        //Logout Button.
        HBox headerBox = new HBox();
        headerBox.setAlignment(Pos.CENTER_RIGHT);
        Button backButton = new Button("Back");
        headerBox.getChildren().add(backButton);
        backButton.setOnAction(e -> { OnUserLogInScene.passControl(OnUserLogInScene.getWindow());});


        //topics of G.D :
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        Label topicsLabel = new Label("Topics for Group Discussion");
        hBox.setStyle("-fx-background-color: #000000");
        hBox.getChildren().add(topicsLabel);

        //List View.......
        ListView<String> listview = new ListView();
        ObservableList<String> list = FXCollections.observableArrayList();
        list.add("India Now");
        list.add("more");
        listview.setEditable(false);
        listview.setPadding(new Insets(0,10,0,10));
        listview.setItems(list);

        // Enter Group Disscussion.
        Button enterButton = new Button("Enter LIVE Group Discussion");
        vBox.setPadding(new Insets(0,10,10,10));
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(headerBox,hBox,listview,enterButton);

        scene = new Scene(vBox,700,600);
        scene.getStylesheets().add("Themes/Nevike.css");
        return scene;
    }
}
