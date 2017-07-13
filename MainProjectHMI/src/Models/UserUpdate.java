package Models;

import java.sql.Date;

/**
 * Created by USER on 7/13/2017.
 */
public class UserUpdate {
    private String userName;
    private String firstName;
    private String lastName;
    private String gender;
    private String eMail;
    private Date dob;
    private String bio;
    private String homeTown;
    private String currentCity;
    private String state;
    private String about;

    public UserUpdate(String userName, String firstName, String lastName, String gender, String eMail, Date dob, String bio, String homeTown, String currentCity, String state, String about) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.eMail = eMail;
        this.dob = dob;
        this.bio = bio;
        this.homeTown = homeTown;
        this.currentCity = currentCity;
        this.state = state;
        this.about = about;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public String getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(String currentCity) {
        this.currentCity = currentCity;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
