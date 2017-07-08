package Models;

import Utils.DOB;
import Utils.Education;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.Image;

import java.util.ArrayList;

/**
 * Created by staLker on 04-07-2017.
 */
public class User{
    public static final String ID_PROPERTY_STRING = "_id_";
    public static final String NAME_PROPERTY_STRING = "_userName_";
    public static final String USERNAME_PROPERTY_STRING = "_name_";


    private int id;
    private SimpleIntegerProperty _id_;
    private SimpleStringProperty _userName_;
    private SimpleStringProperty _name_;
    private String firstName;
    private String lastName;
    private String eMail;
    private long contact;
    private String gender;
    private String userName;
    private String password;
    private String state;
    private String city;
    private Image userImage;
    private DOB dob;
    private String bio;
    private ArrayList<Education> educationList = new ArrayList<>(4);
    private String homeTown;
    private String about;



    public User() {
        this.id = 1000 + (int)(Math.random() * 8999);
        this._id_ = new SimpleIntegerProperty(this.id);
    }


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
    public void setContact(long contact) {
        this.contact = contact;
    }

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
}
