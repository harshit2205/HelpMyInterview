package Listener;

import DAO.UserDAO;
import Beans.Models.User;
import Beans.Models.UserUpdate;
import GUI.Scenes.OnUserLogInScene;
import Beans.Utils.Education;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.*;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;



public class PersonalityTabListener {

    private static String userImagePath ;
    public static void listen(ImageView profilePicture,
                              Button editProfilePictureButton,
                              TextField firstNameTextField,
                              TextField lastNameTextField,
                              TextField userNameTextField,
                              ComboBox<String> genderComboBox,
                              TextField eMailTextField,
                              TextField contactTextField,
                              ComboBox<Integer> selectDayComboBox,
                              ComboBox<Integer> selectMonthComboBox,
                              ComboBox<Integer> selectYearComboBox,
                              TextArea bioTextArea,
                              ComboBox<String> degree1ComboBox,
                              TextField course1TextField,
                              TextField degree1TextField,
                              ComboBox<String> degree2ComboBox,
                              TextField course2TextField,
                              TextField degree2TextField,
                              ComboBox<String> degree3ComboBox,
                              TextField course3TextField,
                              TextField degree3TextField,
                              ComboBox<String> degree4ComboBox,
                              TextField course4TextField,
                              TextField degree4TextField,
                              TextField homeTownTextField,
                              TextField currentCityTextField,
                              TextField stateTextField,
                              TextArea aboutYourselfTextArea,
                              CheckBox acceptCheckBox,
                              Button saveButton,
                              Text firstNameErrorText,
                              Text lastNameErrorText,
                              Text emailErrorText,
                              Text contactErrorText,
                              Text monthErrorText,
                              Text yearErrorText,
                              Text degree1ErrorText,
                              Text degree2ErrorText,
                              Text degree3ErrorText,
                              Text degree4ErrorText) {

//        UserLab userLab = UserLab.get();
        User user  = OnUserLogInScene.getLoggedInUser();


        saveButton.setDisable(true);

        addDegreeList(degree1ComboBox);
        addDegreeList(degree2ComboBox);
        addDegreeList(degree3ComboBox);
        addDegreeList(degree4ComboBox);



        if(user.getUserImage()!=null){
            profilePicture.setImage(user.getUserImage());
        }
        firstNameTextField.setText(user.getFirstName());
        lastNameTextField.setText(user.getLastName());

        userNameTextField.setText(user.getUserName());

        genderComboBox.setValue(user.getGender());

        eMailTextField.setText(user.getEmail());

        contactTextField.setText(user.getContact().toString());

//        int[] dob = HMICalendar.getCalendarInstance().getDate(user.getDob());
//        System.out.println(dob[0]+"-"+dob[1]+"-"+dob[2]);
//
//        if (user.getDob()!=null){
//            selectDayComboBox.setValue(dob[0]);
//            selectMonthComboBox.setValue(dob[1]);
//            selectYearComboBox.setValue(dob[2]);
//        }

        if(user.getBio()!=null){
            bioTextArea.setText(user.getBio());
        }
        bioTextArea.setWrapText(true);
        if(user.getHomeTown()!=null){
            homeTownTextField.setText(user.getHomeTown());
        }
        if(user.getEducation().size()>0){
            degree1ComboBox.setValue(user.getEducation().get(0).getDegree());
            course1TextField.setText(user.getEducation().get(0).getCourse());
            degree1TextField.setText(user.getEducation().get(0).getInstitution());
        }
        if(user.getEducation().size()>1){
            degree2ComboBox.setValue(user.getEducation().get(1).getDegree());
            course2TextField.setText(user.getEducation().get(1).getCourse());
            degree2TextField.setText(user.getEducation().get(1).getInstitution());
        }
        if(user.getEducation().size()>2){
            degree3ComboBox.setValue(user.getEducation().get(2).getDegree());
            course3TextField.setText(user.getEducation().get(2).getCourse());
            degree3TextField.setText(user.getEducation().get(2).getInstitution());
        }
        if(user.getEducation().size()>3){
            degree4ComboBox.setValue(user.getEducation().get(3).getDegree());
            course4TextField.setText(user.getEducation().get(3).getCourse());
            degree4TextField.setText(user.getEducation().get(3).getInstitution());
        }

        homeTownTextField.setText(user.getHomeTown());
        currentCityTextField.setText(user.getCity());
        stateTextField.setText(user.getState());
        if(user.getAbout()!=null){
            aboutYourselfTextArea.setText(user.getAbout());
        }

        aboutYourselfTextArea.setWrapText(true);



        editProfilePictureButton.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Select Profile Picture");
            fileChooser.setInitialDirectory(
                    new File(System.getProperty("user.home"))
            );
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                    new FileChooser.ExtensionFilter("PNG", "*.png")
            );
            File selectedFile = fileChooser.showOpenDialog(null);

            if (selectedFile != null) {
                try {
                    BufferedImage bufferedImage = ImageIO.read(selectedFile);
                    Image image = SwingFXUtils.toFXImage(bufferedImage,null);
                    profilePicture.setImage(image);
                    userImagePath = selectedFile.getPath();
                    System.out.println("Profile picture updated successfully");

                } catch (IOException ex) {
                    System.out.println("Try again! \nwe got some internal errors");
                }
            }
            else {
                System.out.println("no image selected");
            }

        });


        saveButton.setOnAction(e -> {
            ArrayList<Education> educationList = new ArrayList<>(4);
            if(degree1TextField.getText()!=null)
                educationList.add(new Education(degree1ComboBox.getValue(),course1TextField.getText(),degree1TextField.getText()));
            if(degree2TextField.getText()!=null)
                educationList.add(new Education(degree2ComboBox.getValue(),course2TextField.getText(),degree2TextField.getText()));
            if(degree3TextField.getText()!=null)
                educationList.add(new Education(degree3ComboBox.getValue(),course3TextField.getText(),degree3TextField.getText()));
            if(degree4TextField.getText()!=null)
                educationList.add(new Education(degree4ComboBox.getValue(),course4TextField.getText(),degree4TextField.getText()));

            //setting date..........................
            Date dmy = getDate(selectDayComboBox,selectYearComboBox,selectMonthComboBox);

            UserUpdate userUpdate = new UserUpdate(userNameTextField.getText(),
                    firstNameTextField.getText(),
                    lastNameTextField.getText(),
                    genderComboBox.getValue(),
                    eMailTextField.getText(),
                    dmy,
                    bioTextArea.getText(),
                    homeTownTextField.getText(),
                    currentCityTextField.getText(),
                    stateTextField.getText(),
                    aboutYourselfTextArea.getText());
            UserDAO.getUserDAOInstance().updateUser(userUpdate);
        });
    }

    private static void addDegreeList(ComboBox<String> comboBox){
        comboBox.getItems().addAll(Education.getAllDegree());
    }


    private static Date getDate(ComboBox<Integer> selectDayComboBox, ComboBox<Integer> selectYearComboBox, ComboBox<Integer> selectMonthComboBox){
        Date sqldob = null;

        // converting date selected into java.sql.Date..............

        String date = "01",month = "01",year = "2000";

        if(selectDayComboBox.getValue()!= null || selectMonthComboBox.getValue()!=null || selectYearComboBox.getValue()!=null){
            if(selectDayComboBox.getValue()<10){
                date = "0"+selectDayComboBox.getValue();
            }

            if(selectMonthComboBox.getValue()<10){
                month = "0"+selectMonthComboBox.getValue();
            }

            year = ""+selectYearComboBox.getValue();
        }
        String dobString = year+"-"+month+"-"+date;
        System.out.println(dobString);

        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date dob = null;
        try {
            dob = formatter.parse(dobString);
        } catch (ParseException e) {
            System.out.println("unable to Parse Date");
        }

        sqldob = new Date(dob.getTime());
        return sqldob;
    }


}
