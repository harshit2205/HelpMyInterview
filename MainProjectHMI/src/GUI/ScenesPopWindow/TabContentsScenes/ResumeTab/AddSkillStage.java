package GUI.ScenesPopWindow.TabContentsScenes.ResumeTab;

import Beans.Models.User;
import Beans.Models.UserLab;
import GUI.Scenes.OnUserLogInScene;
import Beans.Utils.ExperienceLevel;
import Beans.Utils.Skill;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by staLker on 09-07-2017.
 */
public class AddSkillStage {
    private static boolean isSavePressed = false;
    public static boolean show(){
        UserLab userLab = UserLab.get();
        String userName = OnUserLogInScene.getUserName();
        User user = OnUserLogInScene.getLoggedInUser();

        Stage window = new Stage();


        HBox skillAndExperienceHBox = new HBox(10);
        TextField skillNameTextField = new TextField();
        skillNameTextField.setMaxWidth(300);
        skillNameTextField.setPromptText("Ex.Adobe Photoshop");
        ComboBox<String> experienceLevelComboBox = new ComboBox<>(ExperienceLevel.getAllLevels());
        experienceLevelComboBox.setPromptText("Experience");
        skillAndExperienceHBox.getChildren().addAll(skillNameTextField,experienceLevelComboBox);
        skillAndExperienceHBox.setAlignment(Pos.CENTER);


        Button focus = new Button();
        focus.setStyle("-fx-background-color: transparent");



        Button saveButton = new Button("Save");

        DataAdditionValidation.validate(skillNameTextField,experienceLevelComboBox,saveButton);


        saveButton.setOnAction(e -> {
            if(skillNameTextField.getText().intern()!=""){
                isSavePressed = true;
                user.getSkillArrayList().add(new Skill(skillNameTextField.getText(),experienceLevelComboBox.getValue()));
            }
            window.close();
        });




        VBox root = new VBox(50);
        root.getChildren().addAll(focus,skillAndExperienceHBox,saveButton);

        root.setAlignment(Pos.TOP_CENTER);







        Scene scene = new Scene(root,500,250);
        scene.getStylesheets().add("GUI/Themes/Nevike.css");
        window.setScene(scene);
        window.setTitle("Skills");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setResizable(false);
        window.showAndWait();
        return isSavePressed;
    }
}
