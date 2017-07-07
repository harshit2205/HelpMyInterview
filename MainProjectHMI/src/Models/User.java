package Models;

import Utils.DOB;
import Utils.Education;
import javafx.scene.image.Image;

/**
 * Created by staLker on 04-07-2017.
 */
public class User{
    private int id;
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
    private Education education;
    private String homeTown;
    private String about;



    public User() {
        this.id = 1000 + (int)(Math.random() * 8999);
    }


    public void setUserDetails(String firstName, String lastName, String eMail, Long contact, String gender, String userName, String password, String state, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
        this.contact = contact;
        this.gender = gender;
        this.userName = userName;
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

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
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
}
