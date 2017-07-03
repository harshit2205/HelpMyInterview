package Scenes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ManagingListScene {
//this class will be edited by harshit

    private static ListView<String> listView;
    private static ObservableList<String> list;

    public static void passControl(Stage window){
        VBox parentPaneHbox = new VBox();
        parentPaneHbox.setAlignment(Pos.CENTER);

        list = FXCollections.observableArrayList();
        for(int i = 1 ; i <= 5 ; i++){
            list.add(i+" : userno"+i);
        }
        listView = new ListView<>(list);
        listView.setPadding(new Insets(0,20,0,20));
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);


        Button editButton = new Button("Edit");
        Button deleteButton = new Button("delete");
        editButton.setOnAction(e -> {});
        deleteButton.setOnAction(e -> {});
        HBox optionsHbox = new HBox(50);
        optionsHbox.setAlignment(Pos.CENTER);
        optionsHbox.setPadding(new Insets(20,0,10,0));
        optionsHbox.getChildren().addAll(editButton,deleteButton);

        parentPaneHbox.getChildren().addAll(listView,optionsHbox);
        Scene scene = new Scene(parentPaneHbox,600,600);
        scene.getStylesheets().add("Themes/Nevike.css");
        window.setScene(scene);
        window.show();
    }


    private void renewList(){
        listView.setItems(list);
    }

}
