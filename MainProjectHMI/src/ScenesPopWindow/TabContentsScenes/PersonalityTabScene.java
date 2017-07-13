package ScenesPopWindow.TabContentsScenes;

import Utils.DOB;
import Utils.EditButton;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

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
        HBox firstNameTextFieldHBox = new HBox(2);
        Text firstNameErrorText = new Text("*");
        TextField firstNameTextField = new TextField();
        firstNameTextFieldHBox.getChildren().addAll(firstNameTextField,firstNameErrorText);

        HBox lastNameTextFieldHBox = new HBox(2);
        Text lastNameErrorText = new Text("*");
        TextField lastNameTextField = new TextField();
        lastNameTextFieldHBox.getChildren().addAll(lastNameTextField,lastNameErrorText);


        Label userNameLabel = new Label("Username :");
        TextField userNameTextField = new TextField();
        userNameTextField.setDisable(true);

        Label genderLabel = new Label("Gender : ");
        ComboBox<String> genderComboBox = new ComboBox<>();
        genderComboBox.setPromptText("Gender");
        genderComboBox.getItems().addAll("Male","Female");


        Label emailLabel = new Label("Email : ");
        HBox emailTextFieldHBox = new HBox(2);
        Text emailErrorText = new Text("*");
        TextField eMailTextField = new TextField();
        emailTextFieldHBox.getChildren().addAll(eMailTextField,emailErrorText);
        eMailTextField.setDisable(true);
        EditButton editEmailButton = new EditButton("Edit",eMailTextField);


        Label contactLabel = new Label("Contact : ");
        HBox contactTextFieldHBox = new HBox(2);
        Text contactErrorText = new Text("*");
        TextField contactTextField = new TextField();
        contactTextFieldHBox.getChildren().addAll(contactTextField,contactErrorText);
        contactTextField.setDisable(true);
        EditButton editContactButton = new EditButton("Edit",contactTextField);

        Label dobLabel = new Label("DOB : ");
        ComboBox<Integer> selectDayComboBox = new ComboBox<>(DOB.getAllDateList());
        selectDayComboBox.setPromptText("Day");
        HBox monthComboBoxHBox = new HBox(2);
        Text monthErrorText = new Text("*");
        ComboBox<Integer> selectMonthComboBox = new ComboBox<>(DOB.getAllMonthList());
        monthComboBoxHBox.getChildren().addAll(selectMonthComboBox,monthErrorText);
        selectMonthComboBox.setPromptText("Month");
        HBox yearComboBoxHBox = new HBox(2);
        Text yearErrorText = new Text("*");
        ComboBox<Integer> selectYearComboBox = new ComboBox<>(DOB.getAllYears());
        yearComboBoxHBox.getChildren().addAll(selectYearComboBox,yearErrorText);
        selectYearComboBox.setPromptText("Year");
        HBox dateSelectHBox = new HBox(10);
        dateSelectHBox.getChildren().addAll(selectDayComboBox,monthComboBoxHBox);



        GridPane personalGrid = new GridPane();
        personalGrid.setHgap(10);
        personalGrid.setVgap(10);
        GridPane.setConstraints(nameLabel,0,0);
        GridPane.setConstraints(firstNameTextFieldHBox,1,0 );
        GridPane.setConstraints(lastNameTextFieldHBox,2,0);
        GridPane.setConstraints(userNameLabel,0,1);
        GridPane.setConstraints(userNameTextField,1,1);
        GridPane.setConstraints(genderLabel,0,2);
        GridPane.setConstraints(genderComboBox,1,2);
        GridPane.setConstraints(emailLabel,0,3);
        GridPane.setConstraints(emailTextFieldHBox,1,3);
        GridPane.setConstraints(editEmailButton,2,3);
        GridPane.setConstraints(contactLabel,0,4);
        GridPane.setConstraints(contactTextFieldHBox,1,4);
        GridPane.setConstraints(editContactButton,2,4);
        GridPane.setConstraints(dobLabel,0,5);
        GridPane.setConstraints(dateSelectHBox,1,5);
        GridPane.setConstraints(yearComboBoxHBox,2,5);

        personalGrid.getChildren().addAll(
                nameLabel,firstNameTextFieldHBox,lastNameTextFieldHBox,
                userNameLabel,userNameTextField,
                genderLabel,genderComboBox,
                emailLabel,emailTextFieldHBox,editEmailButton,
                contactLabel,contactTextFieldHBox,editContactButton,
                dobLabel,dateSelectHBox,yearComboBoxHBox
                );


        VBox profilePictureVBox = new VBox(10);
        profilePictureVBox.setAlignment(Pos.CENTER);
        profilePictureVBox.getChildren().addAll(profilePicture,editProfilePictureButton);

//        GridPane completePersonalGrid = new GridPane();
//        completePersonalGrid.setVgap(10);
//        completePersonalGrid.setHgap(20);
//        //GridPane.setConstraints(personalDetailLabel,0,0);
//        GridPane.setConstraints(profilePictureVBox,0,1);
//        GridPane.setConstraints(personalGrid,1,1);
//
//        completePersonalGrid.getChildren().addAll(profilePictureVBox,personalGrid);
        HBox personalGridHbox = new HBox();
        personalGridHbox.getChildren().add(personalGrid);
        personalGridHbox.setPadding(new Insets(20,0,0,50));
        VBox completePersonalGrid = new VBox(10);
        completePersonalGrid.getChildren().addAll(profilePictureVBox,personalGridHbox);



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
        bioTextArea.setMaxWidth(500);
        //GridPane.setConstraints(bioLabel,0,0);
        GridPane.setConstraints(bioTextArea,0,1);
        GridPane bioGridPane = new GridPane();
        bioGridPane.setVgap(10);
        bioGridPane.setHgap(40);
        bioGridPane.getChildren().add(bioTextArea);
        GridPane.setMargin(bioTextArea,new Insets(0,0,0,40));

        ///------------------------------------->bio ends<---------------------------//







        Label educationLabel = new Label("Education");
        HBox educationLabelHBox = new HBox();
        educationLabelHBox.getChildren().add(educationLabel);
        educationLabelHBox.setStyle("-fx-background-color: #000000");
        educationLabelHBox.setAlignment(Pos.CENTER);
///------------------------------------->education starts<---------------------------//


        ComboBox<String> degree1ComboBox = new ComboBox<>();
        degree1ComboBox.setPromptText("Select Degree");
        degree1ComboBox.setMaxWidth(145);
        TextField course1TextField = new TextField();
        course1TextField.setMaxWidth(100);
        course1TextField.setPromptText("enter course");
        course1TextField.setDisable(true);
        TextField degree1TextField = new TextField();
        degree1TextField.setPromptText("enter name of institution");
        degree1TextField.setMinWidth(250);
        degree1TextField.setDisable(true);

        ComboBox<String> degree2ComboBox= new ComboBox<>();
        degree2ComboBox.setPromptText("Select Degree");
        degree2ComboBox.setMaxWidth(145);
        TextField course2TextField = new TextField();
        course2TextField.setMaxWidth(100);
        course2TextField.setPromptText("enter course");
        course2TextField.setDisable(true);
        TextField degree2TextField = new TextField();
        degree2TextField.setPromptText("enter name of nstitution");
        degree2TextField.setDisable(true);

        ComboBox<String> degree3ComboBox= new ComboBox<>();
        degree3ComboBox.setPromptText("Select Degree");
        degree3ComboBox.setMaxWidth(145);
        TextField course3TextField = new TextField();
        course3TextField.setMaxWidth(100);
        course3TextField.setPromptText("enter course");
        course3TextField.setDisable(true);
        TextField degree3TextField = new TextField();
        degree3TextField.setPromptText("enter name of institution");
        degree3TextField.setDisable(true);

        ComboBox<String> degree4ComboBox= new ComboBox<>();
        degree4ComboBox.setPromptText("Select Degree");
        degree4ComboBox.setMaxWidth(145);
        TextField course4TextField = new TextField();
        course4TextField.setMaxWidth(100);
        course4TextField.setPromptText("enter course");
        course4TextField.setDisable(true);
        TextField degree4TextField = new TextField();
        degree4TextField.setPromptText("enter name of institution");
        degree4TextField.setDisable(true);

        Text degree1ErrorText = new Text("*");
        Text degree2ErrorText = new Text("*");
        Text degree3ErrorText = new Text("*");
        Text degree4ErrorText = new Text("*");

        //GridPane.setConstraints(educationLabel,0,0);
        GridPane.setConstraints(degree1ComboBox,0,1);
        GridPane.setConstraints(course1TextField,1,1);
        GridPane.setConstraints(degree1TextField,2,1);
        GridPane.setConstraints(degree1ErrorText,3,1);

        GridPane.setConstraints(degree2ComboBox,0,2);
        GridPane.setConstraints(course2TextField,1,2);
        GridPane.setConstraints(degree2TextField,2,2);
        GridPane.setConstraints(degree2ErrorText,3,2);

        GridPane.setConstraints(degree3ComboBox,0,3);
        GridPane.setConstraints(course3TextField,1,3);
        GridPane.setConstraints(degree3TextField,2,3);
        GridPane.setConstraints(degree3ErrorText,3,3);

        GridPane.setConstraints(degree4ComboBox,0,4);
        GridPane.setConstraints(course4TextField,1,4);
        GridPane.setConstraints(degree4TextField,2,4);
        GridPane.setConstraints(degree4ErrorText,3,4);


        emailLabel.setAlignment(Pos.CENTER);

        GridPane educationGridPane = new GridPane();
        educationGridPane.setHgap(7);
        educationGridPane.setVgap(20);
        educationGridPane.getChildren().addAll(
                degree1ComboBox,course1TextField,degree1TextField,degree1ErrorText,
                degree2ComboBox,course2TextField,degree2TextField,degree2ErrorText,
                degree3ComboBox,course3TextField,degree3TextField,degree3ErrorText,
                degree4ComboBox,course4TextField,degree4TextField,degree4ErrorText);


        VBox.setMargin(educationGridPane,new Insets(0,0,0,40));
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
        EditButton homeTownEditButton = new EditButton("Edit",homeTownTextField);

        Label currentCityLabel = new Label("Current City : ");
        TextField currentCityTextField = new TextField();
        currentCityTextField.setPromptText("enter your current city");
        currentCityTextField.setDisable(true);
        EditButton currentCityEditButton = new EditButton("Edit",currentCityTextField);

        Label stateLabel = new Label("State : ");
        TextField stateTextField = new TextField();
        stateTextField.setPromptText("enter your state");
        stateTextField.setDisable(true);
        EditButton stateEditButton = new EditButton("Edit",stateTextField);

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
        VBox.setMargin(locationGridPane,new Insets(0,0,0,100));


        ///------------------------------------->location end<---------------------------//





        Label aboutLabel = new Label("About Yourself");
        HBox aboutLabelHBox = new HBox();
        aboutLabelHBox.getChildren().add(aboutLabel);
        aboutLabelHBox.setStyle("-fx-background-color: #000000");
        aboutLabelHBox.setAlignment(Pos.CENTER);

///------------------------------------->about start<---------------------------//



        TextArea aboutYourselfTextArea = new TextArea();
        aboutYourselfTextArea.setPromptText("write here something about yourself...");
        aboutYourselfTextArea.setMaxHeight(90);
        aboutYourselfTextArea.setMaxWidth(500);

        //GridPane.setConstraints(aboutLabel,0,0);
        GridPane.setConstraints(aboutYourselfTextArea,0,1);

        GridPane aboutGridPane = new GridPane();
        aboutGridPane.setHgap(40);
        aboutGridPane.setVgap(10);
        aboutGridPane.getChildren().add(aboutYourselfTextArea);
        VBox.setMargin(aboutGridPane,new Insets(0,0,0,40));


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

        VBox.setMargin(saveButton,new Insets(0,0,170,0));
        VBox.setMargin(bioLabelHBox,new Insets(60,0,0,0));
        VBox.setMargin(educationLabelHBox,new Insets(60,0,0,0));
        VBox.setMargin(locationDetailLabelHBox,new Insets(60,0,0,0));
        VBox.setMargin(aboutLabelHBox,new Insets(60,0,20,0));
        VBox.setMargin(acceptCheckBox,new Insets(60,0,20,0));

        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(10,0,10,0));
        vBox.setMinWidth(600);



        ScrollPane scrollPane = new ScrollPane();
        VBox.setVgrow(scrollPane, Priority.ALWAYS);
        scrollPane.setVmax(600);
        scrollPane.setPrefSize(600, 535);
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
                firstNameTextField,lastNameTextField,
                userNameTextField,
                genderComboBox,
                eMailTextField,
                contactTextField,
                selectDayComboBox,selectMonthComboBox,selectYearComboBox,
                bioTextArea,
                degree1ComboBox,course1TextField,degree1TextField,
                degree2ComboBox,course2TextField,degree2TextField,
                degree3ComboBox,course3TextField,degree3TextField,
                degree4ComboBox,course4TextField,degree4TextField,
                homeTownTextField,
                currentCityTextField,
                stateTextField,
                aboutYourselfTextArea,
                acceptCheckBox,
                saveButton,
                firstNameErrorText,lastNameErrorText,
                emailErrorText,
                contactErrorText,
                monthErrorText,yearErrorText,
                degree1ErrorText,degree2ErrorText,degree3ErrorText,degree4ErrorText
                );
        PersonalityTabValidationListener.validateAndListen(
                firstNameTextField,lastNameTextField,
                eMailTextField,
                contactTextField,
                selectDayComboBox,selectMonthComboBox,selectYearComboBox,
                degree1ComboBox,course1TextField,degree1TextField,
                degree2ComboBox,course2TextField,degree2TextField,
                degree3ComboBox,course3TextField,degree3TextField,
                degree4ComboBox,course4TextField,degree4TextField,
                acceptCheckBox,
                saveButton,
                firstNameErrorText,lastNameErrorText,
                emailErrorText,
                contactErrorText,
                monthErrorText,yearErrorText,
                degree1ErrorText,degree2ErrorText,degree3ErrorText,degree4ErrorText
        );



        return new Scene(root, 600, 600);

    }


}
