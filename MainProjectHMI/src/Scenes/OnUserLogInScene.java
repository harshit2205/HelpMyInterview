package Scenes;

import ScenesPopWindow.AboutScene;
import ScenesPopWindow.HelpScene;
import ScenesPopWindow.TabContentsScenes.GDTabScene;
import ScenesPopWindow.TabContentsScenes.PersonalityTabScene;
import ScenesPopWindow.TabContentsScenes.ResumeTabScene;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class OnUserLogInScene {

    private static Stage window;


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


        ImageView facebookIcon = new ImageView(new Image("/ImageResource/facebook_logo.png"));
        facebookIcon.setFitWidth(13);
        facebookIcon.setFitHeight(13);
        ImageView instagramIcon = new ImageView(new Image("/ImageResource/instagram_logo.png"));
        instagramIcon.setFitWidth(13);
        instagramIcon.setFitHeight(13);
        ImageView twitterIcon = new ImageView(new Image("/ImageResource/twitter_logo.png"));
        twitterIcon.setFitWidth(13);
        twitterIcon.setFitHeight(13);




        HBox footerHbox = new HBox(7);
        footerHbox.getChildren().addAll(facebookIcon,twitterIcon,instagramIcon);
        AnchorPane.setBottomAnchor(footerHbox,0.0);
        footerHbox.setPadding(new Insets(3,3,3,3));
        footerHbox.setStyle("-fx-background-color: #000000");
        footerHbox.setMinWidth(700);





        personalityTab.setContent(PersonalityTabScene.getScene().getRoot());
        resumeTab.setContent(ResumeTabScene.getScene().getRoot());
        gdTab.setContent(GDTabScene.getScene().getRoot());
        aboutTab.setContent(AboutScene.getScene().getRoot());
        helpTab.setContent(HelpScene.getScene().getRoot());



        logOutButton.setOnAction(e -> {UserLoginScene.passControl(window);});






        anchorPane.getChildren().addAll(tabPane,hBox,footerHbox);
        Scene scene = new Scene(anchorPane,700,600);
        scene.getStylesheets().add("Themes/Nevike.css");
        window.setScene(scene);
        window.show();

    }

    public static Stage getWindow() {
        return window;
    }
}
