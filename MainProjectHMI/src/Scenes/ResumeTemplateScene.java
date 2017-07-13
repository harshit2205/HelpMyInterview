package Scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


/**
 * Created by staLker on 13-07-2017.
 */
public class ResumeTemplateScene {
    public static Scene getScene(){

        Text titleText = new Text("Select a layout");
        titleText.setFont(Font.font(null, FontWeight.EXTRA_BOLD,30));
        titleText.setFill(Paint.valueOf("#01a0e4"));

        HBox hBoxBackButton = new HBox();
        Button backButton = new Button("<");
        backButton.getStyleClass().add("button-round");
        hBoxBackButton.getChildren().add(backButton);
        hBoxBackButton.setPadding(new Insets(10,0,0,10));
        backButton.setOnAction(e -> { OnUserLogInScene.passControl(OnUserLogInScene.getWindow());});

        HBox titleTextHBox = new HBox();
        titleTextHBox.setAlignment(Pos.CENTER);
        titleTextHBox.setStyle("-fx-background-color: #000000");
        titleTextHBox.setPadding(new Insets(0,10,10,10));
        titleTextHBox.getChildren().add(titleText);

        GridPane templateGridPane = new GridPane();
        templateGridPane.setHgap(20);
        templateGridPane.setVgap(20);
        ImageView templateOne = new ImageView(new Image("ImageResource/ResumeTemplates/template_one.png"));
        ImageView templateTwo = new ImageView(new Image("ImageResource/ResumeTemplates/template_two.png"));
        ImageView templateThree = new ImageView(new Image("ImageResource/ResumeTemplates/template_three.png"));
        ImageView templateFour = new ImageView(new Image("ImageResource/ResumeTemplates/template_four.png"));
        ImageView templateFive = new ImageView(new Image("ImageResource/ResumeTemplates/template_five.png"));
        ImageView templateSix = new ImageView(new Image("ImageResource/ResumeTemplates/template_six.jpg"));



        templateOne.setFitWidth(150);
        templateOne.setFitHeight(200);
        templateTwo.setFitWidth(150);
        templateTwo.setFitHeight(200);
        templateThree.setFitWidth(150);
        templateThree.setFitHeight(200);
        templateFour.setFitWidth(150);
        templateFour.setFitHeight(200);
        templateFive.setFitWidth(150);
        templateFive.setFitHeight(200);
        templateSix.setFitWidth(150);
        templateSix.setFitHeight(200);


        GridPane.setConstraints(templateOne,0,0);
        GridPane.setConstraints(templateTwo,1,0);
        GridPane.setConstraints(templateThree,2,0);
        GridPane.setConstraints(templateFour,0,1);
        GridPane.setConstraints(templateFive,1,1);
        GridPane.setConstraints(templateSix,2,1);
        VBox.setMargin(templateGridPane,new Insets(0,0,0,50));

        templateGridPane.getChildren().addAll(templateOne,templateTwo,templateThree,templateFour,templateFive,templateSix);

        Button generateButton = new Button("Generate!");

        VBox root = new VBox(10);
        root.getChildren().addAll(hBoxBackButton,titleTextHBox,templateGridPane,generateButton);
        root.setAlignment(Pos.TOP_CENTER);

        Scene scene = new Scene(root,600,600);
        scene.getStylesheets().add("Themes/Nevike.css");
        return scene;
    }
}
