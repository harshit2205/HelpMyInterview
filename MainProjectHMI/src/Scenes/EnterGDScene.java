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
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


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
        Text titleText = new Text("Enter your Details");
        titleText.setFont(Font.font(null, FontWeight.EXTRA_BOLD,30));
        titleText.setFill(Paint.valueOf("#01a0e4"));

        HBox titleTextHBox = new HBox();
        titleTextHBox.setAlignment(Pos.CENTER);
        titleTextHBox.setStyle("-fx-background-color: #000000");
        titleTextHBox.setPadding(new Insets(0,10,10,10));
        titleTextHBox.getChildren().add(titleText);

        //List View.......
        ListView<String> listview = new ListView();
        listview.setId("topicslist");
        listview.setEditable(true);
        listview.setPadding(new Insets(0,10,0,10));
        listview.setItems(fetchList());
        // stylying inline listView...................
        listview.setStyle("-fx-background-color: transparent;");


        // Enter Group Disscussion.
        Button enterButton = new Button("Enter LIVE Group Discussion");
        vBox.setPadding(new Insets(0,10,10,10));
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(headerBox,titleTextHBox,listview,enterButton);

        scene = new Scene(vBox,700,600);
        scene.getStylesheets().add("Themes/Nevike.css");
        return scene;
    }

    //function to fetch list of topics........................
    private static ObservableList<String> fetchList(){
        ObservableList<String> list = FXCollections.observableArrayList();
        list.add("What is the major cause of intense civil agitation in Kashmir?");
        list.add("How escalating pollution rate in India can be controlled?");
        list.add("Live in relations are increasing in India. What is the cause behind it?");
        list.add("The performance of India in sports has gone down. What can be a possible cause of it?");
        list.add("What can bring more development in India?");
        list.add("How criminalization can be checked in India?");
        list.add("Which plays crucial role in maintaining democracy in India?");
        list.add("Draught situations have effected which field of India?");
        list.add("What must be done to improve the education system of India?");
        list.add("Many bulk data websites have been banned by telecom authorities.");
        return list;

        //can also be used to fetch list from management
    }
}
