package GUI.Scenes;

import Controller.ImageSlider.ImageSlider;
import Listener.UserLoginSceneListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by staLker on 30-06-2017.
 */
public class UserLoginScene {

    public static void passControl(Stage window){

        HBox imageHMIHBox = new HBox(10);
        HBox userNameHBox = new HBox(10);
        HBox passwordHBox = new HBox(10);
        HBox bothButtonHBox = new HBox(10);
        VBox loginPanelHBox = new VBox(0);
        HBox imageSliderHBox = ImageSlider.getLayout();
        VBox root = new VBox(0);
        HBox imageLoginPanel = new HBox(10);

        Label userNameLabel = new Label("Username :");
        Label passwordLabel = new Label("Password :");
        TextField inputUsername = new TextField();
        PasswordField inputPassword = new PasswordField();
        Button loginButton = new Button("Login!");
        Button signUpButton = new Button("SignUp!");
        signUpButton.getStyleClass().add("button-blue");
        inputPassword.setPromptText("Enter your password");
        inputUsername.setPromptText("Enter your username");
        ImageView logoImageView = new ImageView(new Image("/GUI/ImageResource/logo.png"));
        logoImageView.setFitHeight(120);
        logoImageView.setFitWidth(215);

        ImageView optionIcon = new ImageView(new Image("/GUI/ImageResource/option_image.png"));
        optionIcon.setFitHeight(15);
        optionIcon.setFitWidth(20);

        Menu menu = new Menu();
        menu.setGraphic(optionIcon);
        MenuItem managerLoginMenuItem = new MenuItem("Manager Login");
        MenuItem aboutMenuItem = new MenuItem("About");
        MenuItem helpMenuItem = new MenuItem("Help");
        MenuItem exitMenuItem = new MenuItem("Exit");
        menu.getItems().addAll(
                managerLoginMenuItem,
                new SeparatorMenuItem(),
                aboutMenuItem,
                helpMenuItem,
                new SeparatorMenuItem(),
                exitMenuItem
        );




        MenuBar menuBar = new MenuBar();
        menuBar.setBackground(Background.EMPTY);
        menuBar.getMenus().add(menu);

        HBox optionMenuHBox = new HBox();
        optionMenuHBox.getChildren().add(menuBar);
        optionMenuHBox.setPadding(new Insets(5,0,0,550));
        //optionMenuHBox.setStyle("-fx-background-color: #fded02");

        HBox runnableTextHBox = new HBox();
        runnableTextHBox.getChildren().add(new Text("One day this text will run in bold and white....."));
        runnableTextHBox.setStyle("-fx-background-color: #f80367");
//        HBox coloredHBoxOne = new HBox();
//        coloredHBoxOne.getChildren().add(new Text(""));
//        coloredHBoxOne.setStyle("-fx-background-color: #01a0e4");
        HBox coloredHBoxTwo = new HBox();
        coloredHBoxTwo.getChildren().add(new Text(""));
        coloredHBoxTwo.setStyle("-fx-background-color: transparent");

        Text userNameErrorText = new Text("*");
        Text passwordErrorText = new Text("*");
        Text entryErrorText = new Text();
        userNameHBox.getChildren().addAll(userNameLabel,inputUsername,userNameErrorText);
        passwordHBox.getChildren().addAll(passwordLabel,inputPassword,passwordErrorText);
        imageHMIHBox.getChildren().add(logoImageView);
        bothButtonHBox.getChildren().addAll(loginButton,signUpButton);
        loginPanelHBox.setPadding(new Insets(10,10,10,10));
        bothButtonHBox.setPadding(new Insets(10,10,10,90));
        imageHMIHBox.setPadding(new Insets(10,0,0,40));
        loginPanelHBox.setAlignment(Pos.CENTER);
        VBox userNameAndPasswordHBox = new VBox(10);
        userNameAndPasswordHBox.getChildren().addAll(userNameHBox,passwordHBox);
        loginPanelHBox.getChildren().addAll(userNameAndPasswordHBox,entryErrorText,bothButtonHBox);
        imageLoginPanel.getChildren().addAll(imageHMIHBox,loginPanelHBox);
        imageLoginPanel.setPadding(new Insets(10,10,10,10));
        imageLoginPanel.setStyle("-fx-background-color: #090300");
        imageSliderHBox.setPadding(new Insets(10,0,10,0));
        VBox.setMargin(imageSliderHBox,new Insets(10,0,0,0));
        imageSliderHBox.setStyle("-fx-background-color: #090300");
        root.getChildren().addAll(optionMenuHBox,imageLoginPanel,coloredHBoxTwo,imageSliderHBox,runnableTextHBox);

        root.setAlignment(Pos.CENTER);


        UserLoginSceneListener.listen(
                window,
                inputUsername,userNameErrorText,
                inputPassword,passwordErrorText,
                entryErrorText,
                loginButton,
                signUpButton,
                managerLoginMenuItem,
                aboutMenuItem,
                helpMenuItem,
                exitMenuItem
        );




        Scene scene = new Scene(root,600,600);
        scene.getStylesheets().add("GUI/Themes/Nevike.css");
        window.setScene(scene);
        window.show();
    }




}
