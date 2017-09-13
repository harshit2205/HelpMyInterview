package GUI.Scenes;

import DAO.UserDAO;
import Beans.Models.User;
import GUI.Stages.ConfirmationDialog;
import Beans.Utils.EditButton;
import Beans.Utils.FormattedText;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.*;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class ManagingEditScene {

    public static void passControl(Stage window,String username) {

        User user = UserDAO.getUserDAOInstance().findUser(username);


        //user Image .............
        ImageView userImage = null;
         userImage = new ImageView(new Image("/GUI/ImageResource/userImage.jpg"));
        userImage.setFitHeight(140);
        userImage.setFitWidth(120);



        //Labels ..................
        Label nameLabel = new Label("Name :");
        Label dobLabel = new Label("Date of Birth :");
        Label emailLabel = new Label("Email :");
        Label contactlabel = new Label("Contact Number :");
        Label userNameLabel = new Label("Username :");
        Label passwordLabel = new Label("Password :");

        //........
        FormattedText firstNameText = new FormattedText("First Name");
        FormattedText dobText =new FormattedText("date of birth");
        FormattedText emailText = new FormattedText("email");
        FormattedText contactText = new FormattedText("contact number");
        TextField userNameField = new TextField("User Name");
        userNameField.setDisable(true);
        TextField passwordField = new TextField("Password");
        passwordField.setDisable(true);

        //Buttons......
        Button backButton = new Button("Back");
        EditButton editUserName = new EditButton("edit",userNameField);
        EditButton editPassword = new EditButton("edit",passwordField);
        Button changeButton = new Button("Save!");

        //listeners.........
        backButton.setOnAction(e -> ManagingListScene.passControl(window));
        changeButton.setOnAction(e ->{
            if(new ConfirmationDialog().confirmationUtility("Confirmation!", "Are u sure to Edit")){
                // wrte your code for changiing crredential here..............

            }
        }) ;



        //connecting data............
//        User user = UserLab.get().getUserByUserName(username);

        if(user.getUserImage()!= null){
        userImage.setImage(user.getUserImage());
        }
        firstNameText.setText(user.getFirstName()+" "+user.getLastName());
        if(user.getDob()!= null){
            dobText.setText(user.getDob().getDate()+"/"+user.getDob().getMonth()+"/"+user.getDob().getYear());
        }
        emailText.setText(user.getEmail());
        contactText.setText(Long.toString(user.getContact()));
        userNameField.setText(user.getUserName());
        passwordField.setText(user.getPassword());

        //UI..............

        //root Pane. ..................
        VBox rootPane = new VBox(10);
        rootPane.setPadding(new Insets(10,10,10,10));
        rootPane.setAlignment(Pos.CENTER);

        //header HBox for Button..............
        HBox headerHBox = new HBox();
        headerHBox.setAlignment(Pos.CENTER_RIGHT);
        headerHBox.getChildren().addAll(backButton);



        Text titleText = new Text("Enter your Details");
        titleText.setFont(Font.font(null, FontWeight.EXTRA_BOLD,30));
        titleText.setFill(Paint.valueOf("#01a0e4"));
        HBox titleTextHBox = new HBox();
        titleTextHBox.setStyle("-fx-background-color: #000000");
        titleTextHBox.setPadding(new Insets(0,10,10,10));
        titleTextHBox.getChildren().add(titleText);
        titleTextHBox.setAlignment(Pos.CENTER);

        //editor Pane..................
        GridPane editorPane = new GridPane();
        editorPane.setPadding(new Insets(10,0,20,0));
        editorPane.setHgap(20);
        editorPane.setVgap(10);

        editorPane.add(nameLabel,0,0);
        editorPane.add(dobLabel,0,1);
        editorPane.add(emailLabel,0,2);
        editorPane.add(contactlabel,0,3);
        editorPane.add(userNameLabel,0,4);
        editorPane.add(passwordLabel,0,5);
        editorPane.add(firstNameText,1,0,2,1);
        editorPane.add(dobText,1,1,2,1);
        editorPane.add(emailText,1,2,2,1);
        editorPane.add(contactText,1,3,2,1);
        editorPane.add(userNameField,1,4);
        editorPane.add(passwordField,1,5);
        editorPane.add(editUserName,2,4);
        editorPane.add(editPassword,2,5);

        HBox panel = new HBox(40);
        panel.getChildren().addAll(userImage,editorPane);
        panel.setAlignment(Pos.CENTER);

        HBox changeButtonPane = new HBox();
        changeButtonPane.setAlignment(Pos.CENTER);
        changeButtonPane.getChildren().addAll(changeButton);

        rootPane.getChildren().addAll(headerHBox,titleTextHBox,userImage,panel,changeButtonPane);

        Scene scene = new Scene(rootPane,600,600);
        scene.getStylesheets().add("GUI/Themes/Nevike.css");
        window.setScene(scene);

    }
}
