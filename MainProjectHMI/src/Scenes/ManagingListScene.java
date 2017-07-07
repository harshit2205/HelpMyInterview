package Scenes;

import Delete.ConfirmBox;
import Delete.DemoPojo;
import Models.User;
import Models.UserLab;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 * Created by staLker on 30-06-2017.
 */

public class ManagingListScene {

    private static ObservableList<DemoPojo> list;
    private static TableView table;


    static void passControl(Stage window){
        VBox parentPaneVBox = new VBox(10);
        HBox topBarHBox = new HBox();


        Text titleText = new Text("Users-Details List");
        titleText.setFont(Font.font(null, FontWeight.EXTRA_BOLD,23));
        titleText.setFill(Paint.valueOf("#01a0e4"));
        HBox titleTextHBox = new HBox();
        titleTextHBox.setStyle("-fx-background-color: #000000");
        titleTextHBox.setPadding(new Insets(10,10,10,10));
        titleTextHBox.getChildren().add(titleText);
        titleTextHBox.setAlignment(Pos.CENTER);



        VBox optionsVBox = new VBox(10);
        topBarHBox.setAlignment(Pos.CENTER_RIGHT);
        topBarHBox.setPadding(new Insets(10,10,0,10));

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
            if(new ConfirmBox().confirmationUtility("Confirm delete!","Are you sure you want to \ndelete the user?")){
            ObservableList<DemoPojo> selectedItems =  table.getSelectionModel().getSelectedItems();
            // code for updating in the sql
            table.getItems().removeAll(selectedItems);}
        });

        table.getSelectionModel().getSelectedItems().addListener(new ListChangeListener<DemoPojo>(){
            @Override
            public void onChanged(  ListChangeListener.Change<? extends DemoPojo> changed){
                if( changed.getList().size() > 1){
                    editButton.setDisable(true);}
                    else{
                    deleteButton.setDisable(false);
                    editButton.setDisable(false);
                }
            }
        });
        table.setMaxHeight(330);
        VBox.setMargin(table,new Insets(30,10,30,10));



        logoutButton.setOnAction(e -> {ManagerLoginScene.passControl(window);});
        topBarHBox.getChildren().add(logoutButton);

        optionsVBox.setAlignment(Pos.CENTER);
        optionsVBox.getChildren().addAll(editButton,deleteButton);

        parentPaneVBox.setPadding(new Insets(0,0,0,0));
        parentPaneVBox.getChildren().addAll(topBarHBox,titleTextHBox,table,optionsVBox);
        Scene scene = new Scene(parentPaneVBox,600,600);
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
        table = new TableView<User>();

        TableColumn<User, Integer> idColumn = new TableColumn<>("Id");
        idColumn.setMaxWidth(1000);
        idColumn.setCellValueFactory(
                new PropertyValueFactory<>(User.ID_PROPERTY_STRING));
        TableColumn<User, String> usernameColumn = new TableColumn<>("Username");
        usernameColumn.setCellValueFactory(
                new PropertyValueFactory<>(User.USERNAME_PROPERTY_STRING));
        TableColumn<User, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(
                new PropertyValueFactory<>(User.NAME_PROPERTY_STRING));

        table.setItems(UserLab.get().getObservableUserList());
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.getColumns().addAll(idColumn, usernameColumn, nameColumn);
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

}
