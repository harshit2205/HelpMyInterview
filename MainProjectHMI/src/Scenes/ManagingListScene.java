package Scenes;

import Delete.DemoPojo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ManagingListScene {

    private static ObservableList<DemoPojo> list;
    private static TableView table = null;


    static void passControl(Stage window){
        VBox parentPaneVbox = new VBox(10);
        HBox topbarHBox = new HBox();
        HBox optionsHbox = new HBox(50);
        topbarHBox.setAlignment(Pos.CENTER_RIGHT);
        topbarHBox.setPadding(new Insets(10,10,20,10));

        list = FXCollections.observableArrayList();
        for(int i = 1 ; i <= 50 ; i++){
            list.add(new DemoPojo(i,"username"+i,"harshit"));
        }

        if(ifTableExists()){
            createTable();
        }


        Button editButton = new Button("Edit");
        editButton.setDisable(true);
        Button deleteButton = new Button("delete");
        deleteButton.setDisable(true);
        Button logoutButton = new Button("Logout!");
        editButton.setOnAction(e -> {});
        deleteButton.setOnAction(e -> {
            ObservableList<DemoPojo> selectedItems =  table.getSelectionModel().getSelectedItems();
            // code for updating in the sql
            table.getItems().removeAll(selectedItems);
        });
        table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
                deleteButton.setDisable(false);
                editButton.setDisable(false);
        });

        logoutButton.setOnAction(e -> {ManagerLoginScene.passControl(window);});
        topbarHBox.getChildren().add(logoutButton);

        optionsHbox.setAlignment(Pos.CENTER);
        optionsHbox.getChildren().addAll(editButton,deleteButton);

        parentPaneVbox.setPadding(new Insets(10,10,10,10));
        parentPaneVbox.getChildren().addAll(topbarHBox,table,optionsHbox);
        Scene scene = new Scene(parentPaneVbox,600,600);
        scene.getStylesheets().add("Themes/Nevike.css");
        window.setScene(scene);
        window.show();
    }





    private static boolean ifTableExists(){
        if(table == null){
        return true;}
        else{
            return false;}
    }

    private static void createTable(){
        table = new TableView();

        TableColumn<DemoPojo, Integer> idColumn = new TableColumn("Id");
        idColumn.setCellValueFactory(
                new PropertyValueFactory<DemoPojo, Integer>("id"));
        TableColumn<DemoPojo, String> usernameColumn = new TableColumn("User Name");
        usernameColumn.setCellValueFactory(
                new PropertyValueFactory<DemoPojo, String>("userName"));
        TableColumn<DemoPojo, String> nameColumn = new TableColumn("Name");
        nameColumn.setCellValueFactory(
                new PropertyValueFactory<DemoPojo, String>("name"));

        table.setItems(list);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.getColumns().addAll(idColumn, usernameColumn, nameColumn);
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

}
