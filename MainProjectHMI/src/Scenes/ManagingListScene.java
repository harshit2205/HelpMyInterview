package Scenes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ManagingListScene {
//this class will be edited by harshit

    private static ListView<String> listView;
    private static ObservableList<String> list;
    private static TableView table = new TableView();// for table view.

    static void passControl(Stage window){
        VBox parentPaneHbox = new VBox(10);
        HBox topbarHBox = new HBox();
        topbarHBox.setAlignment(Pos.CENTER_RIGHT);
        topbarHBox.setPadding(new Insets(10,10,20,10));

        list = FXCollections.observableArrayList();
        for(int i = 1 ; i <= 50 ; i++){
            list.add(i+" : userno"+i);
        }
//        listView = new ListView<>();
//        listView.setItems(list);
//        listView.setPadding(new Insets(0,20,0,20));
//        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);


        Button editButton = new Button("Edit");
        Button deleteButton = new Button("delete");
        Button logoutButton = new Button("Logout!");
        editButton.setOnAction(e -> {});
        deleteButton.setOnAction(e -> {});
        logoutButton.setOnAction(e -> {ManagerLoginScene.passControl(window);});
        topbarHBox.getChildren().add(logoutButton);



        HBox optionsHbox = new HBox(50);
        optionsHbox.setAlignment(Pos.CENTER);
        optionsHbox.getChildren().addAll(editButton,deleteButton);

        parentPaneHbox.getChildren().addAll(topbarHBox,listView,optionsHbox);
        Scene scene = new Scene(parentPaneHbox,600,600);
        scene.getStylesheets().add("Themes/Nevike.css");
        window.setScene(scene);
        window.show();
    }


    private void renewList(){
        listView.setItems(list);
    }

}
