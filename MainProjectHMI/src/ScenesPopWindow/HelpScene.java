package ScenesPopWindow;

import Utils.HyperText;
import javafx.geometry.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.*;


public class HelpScene {
    public static Scene getScene(){


        VBox labelVBox = new VBox(10);
        VBox textFieldVBox = new VBox(10);
        HBox forumPaneWithoutButtonHBox = new HBox(20);
        VBox forumPanelCompleteVBox = new VBox(10);
        VBox allInVBox = new VBox(30);
        HBox facebookPane = new HBox(5);
        HBox instagramPane = new HBox(5);
        HBox twitterPane = new HBox(5);
        VBox linksVBox = new VBox(5);
        linksVBox.setAlignment(Pos.TOP_LEFT);
        linksVBox.setPadding(new Insets(0,10,0,10));
        forumPaneWithoutButtonHBox.setPadding(new Insets(0,0,0,0));

        Label mailIdLabel = new Label("e-mail :");
        Label descriptionLabel = new Label("Description :");
        TextField mailTextField = new TextField();
        mailTextField.setPromptText("enter your mail");
        TextArea descriptionTextArea = new TextArea();
        descriptionTextArea.setMaxWidth(280);
        descriptionTextArea.setMaxHeight(100);
        descriptionTextArea.setPromptText("specify your problem ");

        Hyperlink gitHubDocumentationLink = new Hyperlink("https://github.com/HMI-Documentation");
        Hyperlink gitHubForum = new Hyperlink("https://github.com/HMI-CommunityForum");
        Hyperlink websiteForum = new Hyperlink("https://help-MI.in/forum");
        Button submitQueryButton = new Button("Submit");
        gitHubDocumentationLink.setOnAction(e -> HyperText.openWebPage("https://github.com/manu461/Nasscomm-Ariscent/tree/master/MainProjectHMI"));
        gitHubForum.setOnAction(e -> HyperText.openWebPage("https://github.com/"));
        websiteForum.setOnAction(e -> HyperText.openWebPage("https://twitter.com/"));
        submitQueryButton.setOnAction(e -> {});

        ImageView forumLogoImageView = new ImageView(new Image("/ImageResource/github_logo.png"));
        forumLogoImageView.setFitWidth(20);
        forumLogoImageView.setFitHeight(20);
        ImageView documentationLogoImageView = new ImageView(new Image("/ImageResource/github_logo.png"));
        documentationLogoImageView.setFitWidth(20);
        documentationLogoImageView.setFitHeight(20);
        ImageView websiteForumLogoImageView = new ImageView(new Image("/ImageResource/forum_logo.png"));
        websiteForumLogoImageView.setFitWidth(20);
        websiteForumLogoImageView.setFitHeight(20);

        facebookPane.getChildren().addAll(forumLogoImageView, gitHubDocumentationLink);facebookPane.setAlignment(Pos.CENTER_LEFT);
        instagramPane.getChildren().addAll(documentationLogoImageView, gitHubForum);instagramPane.setAlignment(Pos.CENTER_LEFT);
        twitterPane.getChildren().addAll(websiteForumLogoImageView, websiteForum);twitterPane.setAlignment(Pos.CENTER_LEFT);

        linksVBox.getChildren().addAll(facebookPane,instagramPane,twitterPane);

        labelVBox.getChildren().addAll(mailIdLabel,descriptionLabel);
        textFieldVBox.getChildren().addAll(mailTextField,descriptionTextArea);

        forumPaneWithoutButtonHBox.setAlignment(Pos.CENTER_LEFT);
        forumPaneWithoutButtonHBox.getChildren().addAll(labelVBox,textFieldVBox);
        forumPanelCompleteVBox.getChildren().addAll(forumPaneWithoutButtonHBox,submitQueryButton);
        forumPanelCompleteVBox.setStyle("-fx-background-color: #000000");
        forumPanelCompleteVBox.setAlignment(Pos.CENTER);
        forumPanelCompleteVBox.setPadding(new Insets(10,10,10,10));
        allInVBox.setAlignment(Pos.TOP_CENTER);
        allInVBox.getChildren().addAll(linksVBox,forumPanelCompleteVBox);

        return new Scene(allInVBox,400,350);
    }
}
