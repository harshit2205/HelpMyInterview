package GUI.ScenesPopWindow.TabContentsScenes.ResumeTab;

import Beans.Models.User;
import GUI.Scenes.OnUserLogInScene;
import GUI.Scenes.ResumeTemplateScene;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class ResumeTabScene {
    private static User user;

    public static Scene getScene(){

        user = OnUserLogInScene.getLoggedInUser();


        VBox allIn = new VBox(10);




        Label onelinerLabel = new Label("One-Liner");
        HBox onelinerLabelHBox = new HBox();
        onelinerLabelHBox.getChildren().add(onelinerLabel);
        onelinerLabelHBox.setStyle("-fx-background-color: #000000");
        onelinerLabelHBox.setAlignment(Pos.CENTER);

        TextArea oneLinerTextArea = new TextArea();
        oneLinerTextArea.setWrapText(true);
        oneLinerTextArea.setMaxHeight(60);
        oneLinerTextArea.setMaxWidth(500);
        oneLinerTextArea.setPromptText("enter your one-liner here...");




        Label skillsLabel = new Label("Skills");
        HBox skillsLabelHBox = new HBox();
        skillsLabelHBox.getChildren().add(skillsLabel);
        skillsLabelHBox.setStyle("-fx-background-color: #000000");
        skillsLabelHBox.setAlignment(Pos.CENTER);

        VBox skillsVBox = new VBox(3);
        Button addSkillButton = new Button("+ Add Skill");
        skillsVBox.getChildren().add(addSkillButton);
        skillsVBox.setAlignment(Pos.CENTER_RIGHT);
        addSkillButton.setStyle("-fx-background-color: transparent");




        Label trainingLabel = new Label("Trainings Detail");
        HBox trainingLabelHBox = new HBox();
        trainingLabelHBox.getChildren().add(trainingLabel);
        trainingLabelHBox.setStyle("-fx-background-color: #000000");
        trainingLabelHBox.setAlignment(Pos.CENTER);

        VBox trainingsVBox = new VBox(10);
        Button addTrainingButton = new Button("+ Add Training");
        trainingsVBox.getChildren().add(addTrainingButton);
        trainingsVBox.setAlignment(Pos.CENTER_RIGHT);
        addTrainingButton.setStyle("-fx-background-color: transparent");




        Label projectsLabel = new Label("Projects Detail");
        HBox projectLabelHBox = new HBox();
        projectLabelHBox.getChildren().add(projectsLabel);
        projectLabelHBox.setStyle("-fx-background-color: #000000");
        projectLabelHBox.setAlignment(Pos.CENTER);

        VBox projectsVBox = new VBox(10);
        Button addProjectButton = new Button("+ Add Project");
        projectsVBox.getChildren().add(addProjectButton);
        projectsVBox.setAlignment(Pos.CENTER_RIGHT);
        addProjectButton.setStyle("-fx-background-color: transparent");




        Label internshipLabel = new Label("Internships Detail");
        HBox internshipLabelHBox = new HBox();
        internshipLabelHBox.getChildren().add(internshipLabel);
        internshipLabelHBox.setStyle("-fx-background-color: #000000");
        internshipLabelHBox.setAlignment(Pos.CENTER);

        VBox internshipVBox = new VBox(10);
        Button addInternshipButton= new Button("+ Add Internship");
        internshipVBox.getChildren().add(addInternshipButton);
        internshipVBox.setAlignment(Pos.CENTER_RIGHT);
        addInternshipButton.setStyle("-fx-background-color: transparent");




        Label jobLabel = new Label("Jobs Detail");
        HBox jobLabelHBox = new HBox();
        jobLabelHBox.getChildren().add(jobLabel);
        jobLabelHBox.setStyle("-fx-background-color: #000000");
        jobLabelHBox.setAlignment(Pos.CENTER);

        VBox jobVBox = new VBox(10);
        Button addJobButton = new Button("+ Add Job");
        jobVBox.getChildren().add(addJobButton);
        jobVBox.setAlignment(Pos.CENTER_RIGHT);
        addJobButton.setStyle("-fx-background-color: transparent");



///////////---------------->initial updations--------------------------

        updateSkillVBox(skillsVBox,addSkillButton);
        updateTrainingVBox(trainingsVBox,addTrainingButton);
        updateProjectVBox(projectsVBox,addProjectButton);
        updateInternshipVBox(internshipVBox,addInternshipButton);
        updateJobVBox(jobVBox,addJobButton);


///////////---------------->initial updations--------------------------






/////////---------------------------------->listeners.-------------------------------



        addSkillButton.setOnAction(e -> {
            user.getSkillArrayList().ensureCapacity(6);
            Boolean isSavePressed = AddSkillStage.show();
            if(isSavePressed){
                updateSkillVBox(skillsVBox,addSkillButton);
            }
        });

        addTrainingButton.setOnAction(e ->{
            Boolean isSavePressed = AddTrainingStage.show();
            if(isSavePressed){
                updateTrainingVBox(trainingsVBox,addTrainingButton);
            }
        });
        addProjectButton.setOnAction(e -> {
            Boolean isSavePressed = AddProjectStage.show();
            if(isSavePressed){
                updateProjectVBox(projectsVBox,addProjectButton);
            }
        });
        addInternshipButton.setOnAction(e -> {
            Boolean isSavePressed = AddInternshipStage.show();
            if(isSavePressed){
                updateInternshipVBox(internshipVBox,addInternshipButton);
            }
        });
        addJobButton.setOnAction(event -> {
            Boolean isSavePressed = AddJobStage.show();
            if(isSavePressed){
                updateJobVBox(jobVBox,addJobButton);
            }
        });

/////////---------------------------------->listeners.-------------------------------



        Button generateResumeButton = new Button("Generate resume!");
        generateResumeButton.setOnAction(event -> {
            OnUserLogInScene.getWindow().setScene(ResumeTemplateScene.getScene());
        });


        VBox.setMargin(generateResumeButton,new Insets(50,0,0,0));

        allIn.getChildren().addAll(
                skillsLabelHBox,skillsVBox,
                trainingLabelHBox,trainingsVBox,
                projectLabelHBox,projectsVBox,
                internshipLabelHBox,internshipVBox,
                jobLabelHBox,jobVBox,
                onelinerLabelHBox,oneLinerTextArea,
                generateResumeButton
        );

        allIn.setMinWidth(580);
        allIn.setMinHeight(10000);
        allIn.setAlignment(Pos.TOP_CENTER);

        ScrollPane scrollPane = new ScrollPane();
        VBox.setVgrow(scrollPane, Priority.ALWAYS);
        scrollPane.setVmax(100000);
        scrollPane.setPrefSize(600, 600);
        scrollPane.setContent(allIn);
        scrollPane.vvalueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                                Number old_val, Number new_val) {
            }
        });


        VBox root = new VBox();
        root.getChildren().addAll(scrollPane);


        return new Scene(root,600,600);
    }



    private static void updateSkillVBox(VBox skillsVBox,Button addSkillButton){
        skillsVBox.getChildren().clear();
        for (int i=0;i<user.getSkillArrayList().size();i++){
            Text skillName = new Text(user.getSkillArrayList().get(i).getSkillName());
            Text skillExperience = new Text(user.getSkillArrayList().get(i).getExperience());
            skillName.setFont(Font.font(null, FontWeight.SEMI_BOLD,22));
            skillExperience.setFont(Font.font(null, FontWeight.NORMAL, FontPosture.ITALIC,14));
            skillName.setFill(Paint.valueOf("#ffffff"));
            skillExperience.setFill(Paint.valueOf("#ffffff"));

            VBox vBox = new VBox();
            if(user.getSkillArrayList().get(i).getExperience().intern()=="Advanced")
                vBox.setStyle("-fx-background-color: #27ae61");
            else if(user.getSkillArrayList().get(i).getExperience().intern()=="Intermediate")
                vBox.setStyle("-fx-background-color: #e77e22");
            else if(user.getSkillArrayList().get(i).getExperience().intern()=="Beginner")
                vBox.setStyle("-fx-background-color: #e74b3c");
            vBox.setAlignment(Pos.CENTER);
            vBox.getChildren().addAll(skillName,skillExperience);
            vBox.setPadding(new Insets(0,0,10,0));
            skillsVBox.getChildren().addAll(vBox);

        }
        skillsVBox.getChildren().add(addSkillButton);
    }
    private static void updateTrainingVBox(VBox updateTrainingVBox,Button addTrainingButton){
        updateTrainingVBox.getChildren().clear();
        for (int i=0;i<user.getTrainingsArrayList().size();i++){
            Text trainingName = new Text(user.getTrainingsArrayList().get(i).getTrainingName());
            Text trainingOrganization = new Text(user.getTrainingsArrayList().get(i).getOrganizationName());
            trainingName.setFont(Font.font(null, FontWeight.SEMI_BOLD,22));
            trainingOrganization.setFont(Font.font(null, FontWeight.NORMAL, FontPosture.ITALIC,14));
            trainingName.setFill(Paint.valueOf("#ffffff"));
            trainingOrganization.setFill(Paint.valueOf("#ffffff"));
            VBox vBox = new VBox();
            vBox.setAlignment(Pos.CENTER);
            vBox.getChildren().addAll(trainingName,trainingOrganization);
            vBox.setPadding(new Insets(0,0,10,0));
            updateTrainingVBox.getChildren().add(vBox);
        }
        updateTrainingVBox.getChildren().add(addTrainingButton);
    }
    private static void updateProjectVBox(VBox projectsVBox, Button addProjectButton) {
        projectsVBox.getChildren().clear();
        for (int i=0;i<user.getProjectArrayList().size();i++){
            Text projectName = new Text(user.getProjectArrayList().get(i).getProjectTitle());
            Text projectUrl = new Text(user.getProjectArrayList().get(i).getProjectURL());
            projectName.setFont(Font.font(null, FontWeight.SEMI_BOLD,22));
            projectUrl.setFont(Font.font(null, FontWeight.NORMAL, FontPosture.ITALIC,14));
            projectName.setFill(Paint.valueOf("#ffffff"));
            projectUrl.setFill(Paint.valueOf("#01a0e4"));
            VBox vBox = new VBox();
            vBox.setAlignment(Pos.CENTER);
            vBox.getChildren().addAll(projectName,projectUrl);
            vBox.setPadding(new Insets(0,0,10,0));
            projectsVBox.getChildren().add(vBox);
        }
        projectsVBox.getChildren().add(addProjectButton);
    }
    private static void updateInternshipVBox(VBox internshipVBox, Button addInternshipButton) {
        internshipVBox.getChildren().clear();
        for (int i=0;i<user.getInternshipArrayList().size();i++){
            Text internshipName = new Text(user.getInternshipArrayList().get(i).getTitleOfInternship());
            Text internshipOrganization = new Text(user.getInternshipArrayList().get(i).getOrganization());
            internshipName.setFont(Font.font(null, FontWeight.SEMI_BOLD,22));
            internshipOrganization.setFont(Font.font(null, FontWeight.NORMAL, FontPosture.ITALIC,14));
            internshipName.setFill(Paint.valueOf("#ffffff"));
            internshipOrganization.setFill(Paint.valueOf("#ffffff"));
            VBox vBox = new VBox();
            vBox.setAlignment(Pos.CENTER);
            vBox.getChildren().addAll(internshipName,internshipOrganization);
            vBox.setPadding(new Insets(0,0,10,0));
            internshipVBox.getChildren().add(vBox);
        }
        internshipVBox.getChildren().add(addInternshipButton);
    }
    private static void updateJobVBox(VBox jobVBox, Button addJobButton) {
        jobVBox.getChildren().clear();
        for (int i=0;i<user.getJobArrayList().size();i++){
            Text jobProfile = new Text(user.getJobArrayList().get(i).getProfile());
            Text jobOrganization = new Text(user.getJobArrayList().get(i).getOrganization());
            jobProfile.setFont(Font.font(null, FontWeight.SEMI_BOLD,22));
            jobOrganization.setFont(Font.font(null, FontWeight.NORMAL, FontPosture.ITALIC,14));
            jobProfile.setFill(Paint.valueOf("#ffffff"));
            jobOrganization.setFill(Paint.valueOf("#ffffff"));
            VBox vBox = new VBox();
            vBox.setAlignment(Pos.CENTER);
            vBox.getChildren().addAll(jobProfile,jobOrganization);
            vBox.setPadding(new Insets(0,0,10,0));
            jobVBox.getChildren().add(vBox);
        }
        jobVBox.getChildren().add(addJobButton);
    }
}
