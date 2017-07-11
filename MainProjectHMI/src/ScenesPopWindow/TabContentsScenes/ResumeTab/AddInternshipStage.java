package ScenesPopWindow.TabContentsScenes.ResumeTab;

import Models.User;
import Models.UserLab;
import Scenes.OnUserLogInScene;
import Utils.Internship;
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
public class AddInternshipStage {
    private static boolean isSavePressed = false;
    public static boolean show(){
        UserLab userLab = UserLab.get();
        String userName = OnUserLogInScene.getUserName();
        User user = userLab.getUserByUserName(userName);


        Stage window = new Stage();


        GridPane internshipGridPane = new GridPane();
        internshipGridPane.setVgap(20);
        internshipGridPane.setHgap(20);

        Label internshipTitleLabel = new Label("Title : ");
        TextField internshipTitleTextField = new TextField();
        internshipTitleTextField.setPromptText("enter internship title");
        internshipTitleTextField.setMaxWidth(300);

        Label internshipOrganizationLabel = new Label("Organization : ");
        TextField internshipOrganizationTextField = new TextField();
        internshipOrganizationTextField.setPromptText("enter internship Organization");

        CheckBox workFromHomeInternshipCheckbox = new CheckBox("Work from home Internship");
        workFromHomeInternshipCheckbox.setStyle("-fx-text-fill: white");

        Label internshipLocationLabel = new Label("Location : ");
        TextField internshipLocationTextField = new TextField();
        internshipLocationTextField.setPromptText("enter internship location");

        Label internshipDescriptionLabel = new Label("Description : ");
        TextArea internshipDescriptionTextArea = new TextArea();
        internshipDescriptionTextArea.setPromptText("enter internship description");
        internshipDescriptionTextArea.setMaxWidth(300);
        internshipDescriptionTextArea.setMaxHeight(60);

        GridPane.setConstraints(internshipTitleLabel,0,0);
        GridPane.setConstraints(internshipTitleTextField,1,0);
        GridPane.setConstraints(internshipOrganizationLabel,0,1);
        GridPane.setConstraints(internshipOrganizationTextField,1,1);
        GridPane.setConstraints(workFromHomeInternshipCheckbox,1,2);
        GridPane.setConstraints(internshipLocationLabel,0,3);
        GridPane.setConstraints(internshipLocationTextField,1,3);
        GridPane.setConstraints(internshipDescriptionLabel,0,4);
        GridPane.setConstraints(internshipDescriptionTextArea,1,4);
        GridPane.setValignment(internshipDescriptionLabel, VPos.TOP);

        internshipGridPane.getChildren().addAll(internshipTitleLabel,internshipTitleTextField,internshipOrganizationLabel,internshipOrganizationTextField,workFromHomeInternshipCheckbox,internshipLocationLabel,internshipLocationTextField,internshipDescriptionLabel,internshipDescriptionTextArea);

        HBox gridPaneHBox = new HBox();
        gridPaneHBox.getChildren().addAll(internshipGridPane);
        gridPaneHBox.setAlignment(Pos.CENTER);
        gridPaneHBox.setPadding(new Insets(30,10,10,10));

        Button saveButton = new Button("Save!");

        DataAdditionValidation.validate(internshipTitleTextField,internshipOrganizationTextField,workFromHomeInternshipCheckbox,internshipLocationTextField,internshipDescriptionTextArea,saveButton,"Work from home internship");


        saveButton.setOnAction(e ->{
            isSavePressed = true;
            user.getInternshipArrayList().add(new Internship(internshipTitleTextField.getText(),internshipOrganizationTextField.getText(),internshipLocationTextField.getText(),workFromHomeInternshipCheckbox.isSelected(),internshipDescriptionTextArea.getText()));
            window.close();
        });


        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(gridPaneHBox,saveButton);



        Scene scene = new Scene(root,500,370);
        scene.getStylesheets().add("Themes/Nevike.css");
        window.setScene(scene);
        window.setTitle("Internship");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setResizable(false);
        window.showAndWait();

        return isSavePressed;

    }
}
