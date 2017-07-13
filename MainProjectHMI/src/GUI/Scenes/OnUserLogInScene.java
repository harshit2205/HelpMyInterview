package GUI.Scenes;

import Beans.Models.User;
import GUI.ScenesPopWindow.AboutScene;
import GUI.ScenesPopWindow.HelpScene;
import GUI.ScenesPopWindow.TabContentsScenes.GDTabScene;
import GUI.ScenesPopWindow.TabContentsScenes.PersonalityTabScene;
import GUI.ScenesPopWindow.TabContentsScenes.ResumeTab.ResumeTabScene;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
/**
 * Created by staLker on 30-06-2017.
 */

public class OnUserLogInScene {

    private static Stage window;
    private static String userName;
    private static User loggedInUser;


    public static void passControl(Stage window){
        OnUserLogInScene.window = window;
        AnchorPane anchorPane = new AnchorPane();
        TabPane tabPane = new TabPane();
        Tab personalityTab = new Tab("Personality");
        Tab resumeTab = new Tab("Resume");
        Tab gdTab = new Tab("Group Discussion");
        Tab aboutTab = new Tab("About");
        Tab helpTab = new Tab("Help");
        tabPane.setTabMinWidth(10);




        personalityTab.setClosable(false);
        resumeTab.setClosable(false);
        gdTab.setClosable(false);
        aboutTab.setClosable(false);
        helpTab.setClosable(false);

        tabPane.getTabs().addAll(personalityTab,resumeTab,gdTab,aboutTab,helpTab);

        Button logOutButton = new Button("Logout!");
        HBox hBox = new HBox(logOutButton);
        AnchorPane.setRightAnchor(hBox,0.5);
        hBox.setPadding(new Insets(14,10,0,0));


        ImageView facebookIcon = new ImageView(new Image("/GUI/ImageResource/facebook_logo.png"));
        facebookIcon.setFitWidth(13);
        facebookIcon.setFitHeight(13);
        ImageView instagramIcon = new ImageView(new Image("/GUI/ImageResource/instagram_logo.png"));
        instagramIcon.setFitWidth(13);
        instagramIcon.setFitHeight(13);
        ImageView twitterIcon = new ImageView(new Image("/GUI/ImageResource/twitter_logo.png"));
        twitterIcon.setFitWidth(13);
        twitterIcon.setFitHeight(13);




        HBox footerHBox = new HBox(7);
        footerHBox.getChildren().addAll(facebookIcon,twitterIcon,instagramIcon);
        AnchorPane.setBottomAnchor(footerHBox,0.0);
        footerHBox.setPadding(new Insets(3,3,3,3));
        footerHBox.setStyle("-fx-background-color: #000000");
        footerHBox.setMinWidth(600);





        personalityTab.setContent(PersonalityTabScene.getScene().getRoot());
        resumeTab.setContent(ResumeTabScene.getScene().getRoot());
        gdTab.setContent(GDTabScene.getScene().getRoot());
        aboutTab.setContent(AboutScene.getScene().getRoot());
        helpTab.setContent(HelpScene.getScene().getRoot());



        logOutButton.setOnAction(e -> {UserLoginScene.passControl(window);});






        anchorPane.getChildren().addAll(tabPane,hBox,footerHBox);
        Scene scene = new Scene(anchorPane,600,600);
        scene.getStylesheets().add("GUI/Themes/Nevike.css");
        window.setScene(scene);
        window.show();

    }

    public static Stage getWindow() {
        return window;
    }

    public static String getUserName() {return userName;}

    public static User getLoggedInUser() {
        return loggedInUser;
    }

    public static void setUserName(String userName, User user) {
        OnUserLogInScene.userName = userName;
        OnUserLogInScene.loggedInUser = user;
    }
}
