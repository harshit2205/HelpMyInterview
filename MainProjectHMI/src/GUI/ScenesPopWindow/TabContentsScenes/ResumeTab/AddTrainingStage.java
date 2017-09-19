package GUI.ScenesPopWindow.TabContentsScenes.ResumeTab;

import Beans.Models.User;
import Beans.Models.UserLab;
import DAO.TrainingDAO;
import GUI.Scenes.OnUserLogInScene;
import Beans.Models.Training;
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
public class AddTrainingStage {
    private static boolean isSavePressed = false;
    public static boolean show(){
        String userName = OnUserLogInScene.getUserName();
        User user = OnUserLogInScene.getLoggedInUser();

        Stage window = new Stage();

        GridPane trainingGripPane = new GridPane();
        trainingGripPane.setVgap(20);
        trainingGripPane.setHgap(20);

        Label trainingProgramLabel = new Label("Training Program : ");
        TextField trainingProgramTextField = new TextField();
        trainingProgramTextField.setPromptText("enter training's name");
        trainingProgramTextField.setMaxWidth(300);

        Label organizationLabel = new Label("Organization : ");
        TextField organizationTextField = new TextField();
        organizationTextField.setPromptText("enter organizations name");

        CheckBox onlineTrainingCheckbox = new CheckBox("Online Training");
        onlineTrainingCheckbox.setStyle("-fx-text-fill: white");

        Label locationLabel = new Label("Location : ");
        TextField locationTextField = new TextField();
        locationTextField.setPromptText("enter location of training");

        Label descriptionLabel = new Label("Description : ");
        TextArea descriptionTextArea = new TextArea();
        descriptionTextArea.setPromptText("Short description about training");
        descriptionTextArea.setMaxWidth(300);
        descriptionTextArea.setMaxHeight(60);
        descriptionTextArea.setWrapText(true);

        GridPane.setConstraints(trainingProgramLabel,0,0);
        GridPane.setConstraints(trainingProgramTextField,1,0);
        GridPane.setConstraints(organizationLabel,0,1);
        GridPane.setConstraints(organizationTextField,1,1);
        GridPane.setConstraints(onlineTrainingCheckbox,1,2);
        GridPane.setConstraints(locationLabel,0,3);
        GridPane.setConstraints(locationTextField,1,3);
        GridPane.setConstraints(descriptionLabel,0,4);
        GridPane.setConstraints(descriptionTextArea,1,4);
        GridPane.setValignment(descriptionLabel, VPos.TOP);
        trainingGripPane.setMinWidth(500);

        trainingGripPane.getChildren().addAll(
                trainingProgramLabel,trainingProgramTextField,
                organizationLabel,organizationTextField,
                onlineTrainingCheckbox,
                locationLabel,locationTextField,
                descriptionLabel,descriptionTextArea
        );


        HBox gridPaneHBox = new HBox();
        gridPaneHBox.getChildren().add(trainingGripPane);
        gridPaneHBox.setAlignment(Pos.CENTER);
        gridPaneHBox.setPadding(new Insets(30,10,10,60));



        Button saveButton = new Button("Save");

        DataAdditionValidation.validate(trainingProgramTextField,organizationTextField,onlineTrainingCheckbox,locationTextField,descriptionTextArea,saveButton,"Online Training");

        saveButton.setOnAction(event -> {
            if(trainingProgramTextField.getText().intern()!=""){
                isSavePressed = true;
                Training training = new Training(trainingProgramTextField.getText(),
                        organizationTextField.getText(),
                        onlineTrainingCheckbox.isSelected(),
                        locationTextField.getText(),
                        descriptionTextArea.getText());
                user.getTrainingsArrayList().add(training);
                TrainingDAO.getTrainingDAOInstance().insertTraining(training,userName);
            }
            window.close();
        });




        VBox root = new VBox(20);
        root.getChildren().addAll(gridPaneHBox,saveButton);
        root.setAlignment(Pos.TOP_CENTER);




        Scene scene = new Scene(root,500,370);
        scene.getStylesheets().add("GUI/Themes/Nevike.css");
        window.setScene(scene);
        window.setTitle("Training");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setResizable(false);
        window.showAndWait();

        return isSavePressed;
    }
}
