package GUI.Scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by staLker on 30-06-2017.
 */
public class ManagerLoginScene {

    public static void passControl(Stage window) {


        GridPane gridPane = new GridPane();
        gridPane.setHgap(6);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(20,20,20,20));
        HBox hBoxForLogo = new HBox(10);
        HBox hBoxForLogin = new HBox(10);

        VBox vBoxRoot = new VBox(10);



        Label userNameLabel = new Label("Username :");

        //Image logoImage = new Image("logo.png");

        Label passwordLabel = new Label("Password :");

        TextField inputUsername = new TextField();
        inputUsername.setPromptText("Enter your username");

        PasswordField inputPassword = new PasswordField();
        inputPassword.setPromptText("Enter your password");

        Button loginButton = new Button("Login!");
        loginButton.setOnAction(e -> {
            ManagingListScene.passControl(window);
        });

//        ComboBox<String> themeChoice = new ComboBox<>();
//        themeChoice.getItems().addAll(NEVIKE_THEME,RESSBER_THEME);
//        themeChoice.setPromptText("Set Theme");

//        try {
//            logoImage = new Image(new FileInputStream("/ImageSlider/logo.png"));
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found\n");
//        }

        ImageView imageView = new ImageView(new Image("/GUI/ImageResource/logo.png"));
        imageView.setFitHeight(200);
        imageView.setFitWidth(400);


        GridPane.setConstraints(userNameLabel,0,1);
        GridPane.setConstraints(inputUsername,1,1);
        GridPane.setConstraints(passwordLabel,0,2);
        GridPane.setConstraints(inputPassword,1,2);
        GridPane.setConstraints(loginButton,1,3);
        //GridPane.setConstraints(themeChoice,1,7);
        //GridPane.setConstraints(imageView,1,0);


        hBoxForLogo.getChildren().add(imageView);
        hBoxForLogo.setPadding(new Insets(10,10,10,100));
        hBoxForLogin.setPadding(new Insets(10,10,10,120));
        gridPane.getChildren().addAll(userNameLabel,inputUsername,passwordLabel,inputPassword,loginButton);
        hBoxForLogin.getChildren().add(gridPane);
        VBox.setMargin(hBoxForLogin,new Insets(0,0,90,0));
        hBoxForLogin.setStyle("-fx-background-color: #090300");
        HBox hBoxBackButton = new HBox();
        Button backButton = new Button("<");
        backButton.getStyleClass().add("button-round");
        hBoxBackButton.getChildren().add(backButton);
        hBoxBackButton.setPadding(new Insets(20,10,50,10));
        vBoxRoot.getChildren().addAll(hBoxBackButton,hBoxForLogo,hBoxForLogin);
        vBoxRoot.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vBoxRoot,600,600);


//        themeChoice.setOnAction(e -> {
//            theme = themeChoice.getValue();
//            System.out.print(theme+" "+RESSBER_THEME+" "+NEVIKE_THEME+"\n");
//            if(theme.equals(RESSBER_THEME)){
//                scene.getStylesheets().remove("Nevike.css");
//                if(!scene.getStylesheets().contains("Ressber.css")) scene.getStylesheets().add("Ressber.css");
//
//            }
//            if(theme.equals(NEVIKE_THEME)){
//                scene.getStylesheets().remove("Ressber.css");
//                if(!scene.getStylesheets().contains("Nevike.css")) scene.getStylesheets().add("Nevike.css");
//            }
//        });



        backButton.setOnAction(e -> {UserLoginScene.passControl(window);});



        scene.getStylesheets().add("GUI/Themes/Nevike.css");
        window.setScene(scene);
        window.show();

    }


}
