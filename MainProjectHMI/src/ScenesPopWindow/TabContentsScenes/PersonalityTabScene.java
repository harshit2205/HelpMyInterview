package ScenesPopWindow.TabContentsScenes;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

import javax.xml.soap.Text;


/**
 * Created by staLker on 02-07-2017.
 */
public class PersonalityTabScene {


    public static Scene getScene() {

//
        Label personalDetailLabel = new Label("Personal Details");
        HBox personalDetailHBox = new HBox();
        personalDetailHBox.getChildren().add(personalDetailLabel);
        personalDetailHBox.setStyle("-fx-background-color: #000000");
        personalDetailHBox.setAlignment(Pos.CENTER);
///------------------------------------->personal detail start<---------------------------//


        ImageView profilePicture = new ImageView(new Image("/ImageResource/userImage.jpg"));
        profilePicture.setFitHeight(160);
        profilePicture.setFitWidth(140);
        Button editProfilePictureButton = new Button("Edit Image");


        Label nameLabel = new Label("Name :");
        TextField firstNameTextField = new TextField();
        TextField lastNameTextField = new TextField();

        Label userNameLabel = new Label("Username :");
        TextField userNameTextField = new TextField();
        userNameTextField.setDisable(true);
        Button editUsernameButton = new Button("Edit");

        Label genderLabel = new Label("Gender : ");
        ComboBox<String> genderChoiceBox = new ComboBox<>();


        Label emailLabel = new Label("Email : ");
        TextField eMailTextField = new TextField();
        eMailTextField.setDisable(true);
        Button editEmailButton = new Button("Edit");


        Label contactLabel = new Label("Contact : ");
        TextField contactTextField = new TextField();
        contactTextField.setDisable(true);
        Button editContactButton = new Button("Edit");

        Label dobLabel = new Label("DOB : ");
        ComboBox<String> selectDayComboBox = new ComboBox<>();
        selectDayComboBox.setPromptText("Day");
        ComboBox<String> selectMonthComboBox = new ComboBox<>();
        selectMonthComboBox.setPromptText("Month");
        ComboBox<String> selectYearComboBox = new ComboBox<>();
        selectYearComboBox.setPromptText("Year");
        HBox dateSelectHBox = new HBox(10);
        dateSelectHBox.getChildren().addAll(selectDayComboBox,selectMonthComboBox);



        GridPane personalGrid = new GridPane();
        personalGrid.setHgap(10);
        personalGrid.setVgap(10);
        GridPane.setConstraints(nameLabel,0,0);
        GridPane.setConstraints(firstNameTextField,1,0 );
        GridPane.setConstraints(lastNameTextField,2,0);
        GridPane.setConstraints(userNameLabel,0,1);
        GridPane.setConstraints(userNameTextField,1,1);
        GridPane.setConstraints(editUsernameButton,2,1);
        GridPane.setConstraints(genderLabel,0,2);
        GridPane.setConstraints(genderChoiceBox,1,2);
        GridPane.setConstraints(emailLabel,0,3);
        GridPane.setConstraints(eMailTextField,1,3);
        GridPane.setConstraints(editEmailButton,2,3);
        GridPane.setConstraints(contactLabel,0,4);
        GridPane.setConstraints(contactTextField,1,4);
        GridPane.setConstraints(editContactButton,2,4);
        GridPane.setConstraints(dobLabel,0,5);
        GridPane.setConstraints(dateSelectHBox,1,5);
        GridPane.setConstraints(selectYearComboBox,2,5);

        personalGrid.getChildren().addAll(
                nameLabel,firstNameTextField,lastNameTextField,
                userNameLabel,userNameTextField,editUsernameButton,
                genderLabel,genderChoiceBox,
                emailLabel,eMailTextField,editEmailButton,
                contactLabel,contactTextField,editContactButton,
                dobLabel,dateSelectHBox,selectYearComboBox
                );

        VBox profilePictureVBox = new VBox(10);
        profilePictureVBox.setAlignment(Pos.CENTER);
        profilePictureVBox.getChildren().addAll(profilePicture,editProfilePictureButton);

        GridPane completePersonalGrid = new GridPane();
        completePersonalGrid.setVgap(10);
        completePersonalGrid.setHgap(40);
        //GridPane.setConstraints(personalDetailLabel,0,0);
        GridPane.setConstraints(profilePictureVBox,0,1);
        GridPane.setConstraints(personalGrid,1,1);

        completePersonalGrid.getChildren().addAll(profilePictureVBox,personalGrid);



        //listeners





        ///------------------------------------->personal detail end<---------------------------//





        Label bioLabel = new Label("Bio");
        HBox bioLabelHBox = new HBox();
        bioLabelHBox.getChildren().add(bioLabel);
        bioLabelHBox.setStyle("-fx-background-color: #000000");
        bioLabelHBox.setAlignment(Pos.CENTER);
///------------------------------------->bio start<---------------------------//


        TextArea bioTextArea = new TextArea();
        bioTextArea.setPromptText("Edit your bio...");
        bioTextArea.setMaxHeight(60);
        bioTextArea.setMinWidth(640);
        //GridPane.setConstraints(bioLabel,0,0);
        GridPane.setConstraints(bioTextArea,0,1);
        GridPane bioGridPane = new GridPane();
        bioGridPane.setVgap(10);
        bioGridPane.setHgap(40);
        bioGridPane.getChildren().add(bioTextArea);

        ///------------------------------------->bio ends<---------------------------//







        Label educationLabel = new Label("Education");
        HBox educationLabelHBox = new HBox();
        educationLabelHBox.getChildren().add(educationLabel);
        educationLabelHBox.setStyle("-fx-background-color: #000000");
        educationLabelHBox.setAlignment(Pos.CENTER);
///------------------------------------->education starts<---------------------------//


        ComboBox<String> degree1ComboBox = new ComboBox<>();
        degree1ComboBox.setPromptText("Select Degree");
        TextField degree1TextField = new TextField();
        degree1TextField.setPromptText("Enter Institution");
        degree1TextField.setMinWidth(400);
        degree1TextField.setDisable(true);
        ComboBox<String> degree2ComboBox= new ComboBox<>();
        degree2ComboBox.setPromptText("Select Degree");
        TextField degree2TextField = new TextField();
        degree2TextField.setPromptText("Enter Institution");
        degree2TextField.setDisable(true);
        ComboBox<String> degree3ComboBox= new ComboBox<>();
        degree3ComboBox.setPromptText("Select Degree");
        TextField degree3TextField = new TextField();
        degree3TextField.setPromptText("Enter Institution");
        degree3TextField.setDisable(true);
        ComboBox<String> degree4ComboBox= new ComboBox<>();
        degree4ComboBox.setPromptText("Select Degree");
        TextField degree4TextField = new TextField();
        degree4TextField.setPromptText("Enter Institution");
        degree4TextField.setDisable(true);
        //GridPane.setConstraints(educationLabel,0,0);
        GridPane.setConstraints(degree1ComboBox,0,1);
        GridPane.setConstraints(degree1TextField,1,1);
        GridPane.setConstraints(degree2ComboBox,0,2);
        GridPane.setConstraints(degree2TextField,1,2);
        GridPane.setConstraints(degree3ComboBox,0,3);
        GridPane.setConstraints(degree3TextField,1,3);
        GridPane.setConstraints(degree4ComboBox,0,4);
        GridPane.setConstraints(degree4TextField,1,4);

        emailLabel.setAlignment(Pos.CENTER);

        GridPane educationGridPane = new GridPane();
        educationGridPane.setHgap(20);
        educationGridPane.setVgap(10);
        educationGridPane.getChildren().addAll(
                degree1ComboBox,degree1TextField,
                degree2ComboBox,degree2TextField,
                degree3ComboBox,degree3TextField,
                degree4ComboBox,degree4TextField);
        ///------------------------------------->education ends<---------------------------//





        Label locationDetailsLabel = new Label("Location Details");
        HBox locationDetailLabelHBox = new HBox();
        locationDetailLabelHBox.getChildren().add(locationDetailsLabel);
        locationDetailLabelHBox.setStyle("-fx-background-color: #000000");
        locationDetailLabelHBox.setAlignment(Pos.CENTER);
///------------------------------------->location start<---------------------------//



        Label homeTownLabel = new Label("Hometown : ");
        TextField homeTownTextField = new TextField();
        homeTownTextField.setPromptText("enter your hometown");
        homeTownTextField.setDisable(true);
        Button homeTownEditButton = new Button("Edit");

        Label currentCityLabel = new Label("Current City : ");
        TextField currentCityTextField = new TextField();
        currentCityTextField.setPromptText("enter your current city");
        currentCityTextField.setDisable(true);
        Button currentCityEditButton = new Button("Edit");

        Label stateLabel = new Label("State : ");
        TextField stateTextField = new TextField();
        stateTextField.setPromptText("enter your state");
        stateTextField.setDisable(true);
        Button stateEditButton = new Button("Edit");

        //GridPane.setConstraints(locationDetailsLabel,0,0);
        GridPane.setConstraints(homeTownLabel,0,1);
        GridPane.setConstraints(homeTownTextField,1,1);
        GridPane.setConstraints(homeTownEditButton,2,1);
        GridPane.setConstraints(currentCityLabel,0,2);
        GridPane.setConstraints(currentCityTextField,1,2);
        GridPane.setConstraints(currentCityEditButton,2,2);
        GridPane.setConstraints(stateLabel,0,3);
        GridPane.setConstraints(stateTextField,1,3);
        GridPane.setConstraints(stateEditButton,2,3);

        GridPane locationGridPane = new GridPane();
        locationGridPane.setVgap(10);
        locationGridPane.setHgap(10);
        locationGridPane.getChildren().addAll(
                homeTownLabel,homeTownTextField,homeTownEditButton,
                currentCityLabel,currentCityTextField,currentCityEditButton,
                stateLabel,stateTextField,stateEditButton
        );


        ///------------------------------------->location end<---------------------------//





        Label aboutLabel = new Label("About Yourself");
        HBox aboutLabelHBox = new HBox();
        aboutLabelHBox.getChildren().add(aboutLabel);
        aboutLabelHBox.setStyle("-fx-background-color: #000000");
        aboutLabelHBox.setAlignment(Pos.CENTER);

///------------------------------------->about start<---------------------------//



        TextArea aboutYourselfTextArea = new TextArea();
        aboutYourselfTextArea.setPromptText("write here something about yourself...");
        aboutYourselfTextArea.setMaxHeight(80);
        aboutYourselfTextArea.setMinWidth(640);
        //GridPane.setConstraints(aboutLabel,0,0);
        GridPane.setConstraints(aboutYourselfTextArea,0,1);

        GridPane aboutGridPane = new GridPane();
        aboutGridPane.setHgap(40);
        aboutGridPane.setVgap(10);
        aboutGridPane.getChildren().add(aboutYourselfTextArea);

        ///------------------------------------->about ends<---------------------------//


        CheckBox acceptCheckBox = new CheckBox("I assure that all details entered here are correct.");
        acceptCheckBox.setStyle("-fx-text-fill: white");

        Button saveButton = new Button("Save");



        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(
                personalDetailHBox,
                completePersonalGrid,
                bioLabelHBox,
                bioGridPane,
                educationLabelHBox,
                educationGridPane,
                locationDetailLabelHBox,
                locationGridPane,
                aboutLabelHBox,
                aboutGridPane,
                acceptCheckBox,
                saveButton
        );
        VBox.setMargin(saveButton,new Insets(0,0,70,0));
        VBox.setMargin(bioLabelHBox,new Insets(60,0,0,0));
        VBox.setMargin(educationLabelHBox,new Insets(60,0,0,0));
        VBox.setMargin(locationDetailLabelHBox,new Insets(60,0,0,0));
        VBox.setMargin(aboutLabelHBox,new Insets(60,0,0,0));
        VBox.setMargin(acceptCheckBox,new Insets(30,0,0,0));

        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(10,0,10,20));



        ScrollPane scrollPane = new ScrollPane();
        VBox.setVgrow(scrollPane, Priority.ALWAYS);
        scrollPane.setVmax(600);
        scrollPane.setPrefSize(700, 535);
        scrollPane.setContent(vBox);
        scrollPane.vvalueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                                Number old_val, Number new_val) {

            }
        });


        VBox root = new VBox();
        root.getChildren().addAll(scrollPane);


        PersonalityTabListener.listen(
                profilePicture,editProfilePictureButton,
                userNameTextField,editUsernameButton,
                genderChoiceBox,
                eMailTextField,editEmailButton,
                contactTextField,editContactButton,
                selectDayComboBox,selectMonthComboBox,selectYearComboBox,
                bioTextArea,
                degree1ComboBox,degree1TextField,
                degree2ComboBox,degree2TextField,
                degree3ComboBox,degree3TextField,
                degree4ComboBox,degree4TextField,
                homeTownTextField,homeTownEditButton,
                currentCityTextField,currentCityEditButton,
                stateTextField,stateEditButton,
                aboutYourselfTextArea,
                acceptCheckBox,
                saveButton
                );




        return new Scene(root, 700, 600);

    }


}
