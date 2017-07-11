package ScenesPopWindow.TabContentsScenes.ResumeTab;

import Models.User;
import Models.UserLab;
import Scenes.OnUserLogInScene;
import Utils.Internship;
import Utils.Job;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by staLker on 09-07-2017.
 */
public class AddJobStage {
    private static boolean isSavePressed = false;
    public static boolean show(){

        UserLab userLab = UserLab.get();
        String userName = OnUserLogInScene.getUserName();
        User user = userLab.getUserByUserName(userName);


        Stage window = new Stage();

        GridPane jobGridPane = new GridPane();
        jobGridPane.setVgap(20);
        jobGridPane.setHgap(20);




        Label jobProfileLabel = new Label("Profile : ");
        TextField jobProfileTextField = new TextField();
        jobProfileTextField.setPromptText("enter job profile");
        jobProfileTextField.setMaxWidth(300);

        Label jobOrganizationLabel = new Label("Organization : ");
        TextField jobOrganizationTextField = new TextField();
        jobOrganizationTextField.setPromptText("enter job Organization");

        CheckBox workFromHomeJobCheckbox = new CheckBox("Work from home job");
        workFromHomeJobCheckbox.setStyle("-fx-text-fill: white");

        Label jobLocationLabel = new Label("Location : ");
        TextField jobLocationTextField = new TextField();
        jobLocationTextField.setPromptText("enter job location");

        Label jobDescriptionLabel = new Label("Description : ");
        TextArea jobDescriptionTextArea = new TextArea();
        jobDescriptionTextArea.setPromptText("enter job description");
        jobDescriptionTextArea.setMaxWidth(300);
        jobDescriptionTextArea.setMaxHeight(60);

        GridPane.setConstraints(jobProfileLabel,0,0);
        GridPane.setConstraints(jobProfileTextField,1,0);
        GridPane.setConstraints(jobOrganizationLabel,0,1);
        GridPane.setConstraints(jobOrganizationTextField,1,1);
        GridPane.setConstraints(workFromHomeJobCheckbox,1,2);
        GridPane.setConstraints(jobLocationLabel,0,3);
        GridPane.setConstraints(jobLocationTextField,1,3);
        GridPane.setConstraints(jobDescriptionLabel,0,4);
        GridPane.setConstraints(jobDescriptionTextArea,1,4);
        GridPane.setValignment(jobDescriptionLabel, VPos.TOP);

        jobGridPane.getChildren().addAll(jobProfileLabel,jobProfileTextField,jobOrganizationLabel,jobOrganizationTextField,workFromHomeJobCheckbox,jobLocationLabel,jobLocationTextField,jobDescriptionLabel,jobDescriptionTextArea);



        HBox gridPaneHBox = new HBox();
        gridPaneHBox.getChildren().addAll(jobGridPane);
        gridPaneHBox.setAlignment(Pos.CENTER);
        gridPaneHBox.setPadding(new Insets(30,10,10,10));




        Button saveButton = new Button("Save!");
        DataAdditionValidation.validate(jobProfileTextField,jobOrganizationTextField,workFromHomeJobCheckbox,jobLocationTextField,jobDescriptionTextArea,saveButton,"Work from home job");


        saveButton.setOnAction(e ->{
            isSavePressed = true;
            user.getJobArrayList().add(new Job(jobProfileTextField.getText(),jobOrganizationTextField.getText(),workFromHomeJobCheckbox.isSelected(),jobLocationTextField.getText(),jobDescriptionTextArea.getText()));
            window.close();
        });

        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(gridPaneHBox,saveButton);


        Scene scene = new Scene(root,500,370);
        scene.getStylesheets().add("Themes/Nevike.css");
        window.setScene(scene);
        window.setTitle("Job");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setResizable(false);
        window.showAndWait();

        return isSavePressed;
    }
}
