package Models;

import Utils.*;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.util.ArrayList;

/**
 * Created by staLker on 04-07-2017.
 */
public class User{
    public static final String ID_PROPERTY_STRING = "_id_";
    public static final String USERNAME_PROPERTY_STRING = "_userName_";
    public static final String NAME_PROPERTY_STRING = "_name_";


    private int id;//4 digit
    private SimpleIntegerProperty _id_;
    private SimpleStringProperty _userName_;
    private SimpleStringProperty _name_;
    private String firstName;//15 char max
    private String lastName;//15 char mar
    private String eMail;//30 char max
    private long contact;//10 bigint
    private String gender;//6 char max
    private String userName;//20 char max
    private String password;//10 char max
    private String state;//25 char max
    private String city;//25 char max
    private String homeTown;//25 char max
    private Image userImage;//not now
    private DOB dob;//see DOB
    private String bio;//large string
    private ArrayList<Education> educationList = new ArrayList<>(4);//create education table
    private String about;//large string
    private ArrayList<Skill> skillArrayList = new ArrayList<>(6);//create skill table
    private ArrayList<Training> trainingsArrayList = new ArrayList<>(6);//create training table
    private ArrayList<Project> projectArrayList = new ArrayList<>(6);//create project table
    private ArrayList<Internship> internshipArrayList = new ArrayList<>(2);//create internship table
    private ArrayList<Job> jobArrayList = new ArrayList<>(3);//create job table.


    public void setUserDetails(String firstName, String lastName, String eMail, Long contact, String gender, String userName, String password, String state, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this._name_ = new SimpleStringProperty(this.firstName+" "+this.lastName);
        this.eMail = eMail;
        this.contact = contact;
        this.gender = gender;
        this.userName = userName;
        this._userName_ = new SimpleStringProperty(this.userName);
        this.password = password;
        this.state = state;
        this.city = city;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) { this.id = id;}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {return eMail;}

    public void setEmail(String eMail) {this.eMail = eMail;}

    public Long getContact() {
        return contact;
    }

    public void setContact(Long contact) {
        this.contact = contact;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void printUser(){
        System.out.println("Id : "+this.id+"\nfirstName : "+firstName+"\nlastName : "+lastName+"\neMail : "+eMail+"\ncontact : "+contact+"\ngender : "+gender+"\nuserName : "+userName+"\npassword : "+this.password+"\nstate : "+this.state+"\ncity : "+this.city);
    }
    public void setContact(long contact) {this.contact = contact;}

    public Image getUserImage() {
        return userImage;
    }

    public void setUserImage(Image userImage) {
        this.userImage = userImage;
    }

    public DOB getDob() {
        return dob;
    }

    public void setDob(DOB dob) {
        this.dob = dob;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public ArrayList<Education> getEducation() {return educationList;}

    public void setEducation(ArrayList<Education> education) {
        this.educationList = education;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public int get_id_() {
        return _id_.get();
    }

    public SimpleIntegerProperty _id_Property() {
        return _id_;
    }

    public void set_id_(int _id_) {
        this._id_.set(_id_);
    }

    public String get_userName_() {
        return _userName_.get();
    }

    public SimpleStringProperty _userName_Property() {
        return _userName_;
    }

    public void set_userName_(String _userName_) {
        this._userName_.set(_userName_);
    }

    public String get_name_() {
        return _name_.get();
    }

    public SimpleStringProperty _name_Property() {
        return _name_;
    }

    public void set_name_(String _name_) {
        this._name_.set(_name_);
    }

    public void personalityUpdate(Image userImage, String firstName, String lastName, String userName, String gender,
                                  String eMail, String contact, DOB dob, String bio, ArrayList<Education> educationList,
                                  String homeTown, String city, String state, String about) {
        this.userImage = userImage;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.gender = gender;
        this.eMail = eMail;
        this.contact = Long.parseLong(contact);
        this.dob = dob;
        this.bio = bio;
        this.educationList = educationList;
        this.homeTown = homeTown;
        this.city = city;
        this.state = state;
        this.about = about;
    }

    public ArrayList<Skill> getSkillArrayList() {
        return skillArrayList;
    }

    public void setSkillArrayList(ArrayList<Skill> skillArrayList) {
        this.skillArrayList = skillArrayList;
    }

    public ArrayList<Training> getTrainingsArrayList() {return trainingsArrayList;}

    public void setTrainingsArrayList(ArrayList<Training> trainingsArrayList) {this.trainingsArrayList = trainingsArrayList;}

    public ArrayList<Project> getProjectArrayList() {return projectArrayList;}

    public void setProjectArrayList(ArrayList<Project> projectArrayList) {this.projectArrayList = projectArrayList;}

    public ArrayList<Internship> getInternshipArrayList() {return internshipArrayList;}

    public void setInternshipArrayList(ArrayList<Internship> internshipArrayList) {this.internshipArrayList = internshipArrayList;}

    public ArrayList<Job> getJobArrayList() {return jobArrayList;}

    public void setJobArrayList(ArrayList<Job> jobArrayList) {this.jobArrayList = jobArrayList;}
}
