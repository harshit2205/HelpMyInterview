package Beans.Models;

/**
 * Created by USER on 7/13/2017.
 */
public class Education {
    String userName;
    String degree;
    String course;
    String institution;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public Education(String userNAme, String degree, String coarseName, String institution) {

        this.userName = userNAme;
        this.degree = degree;
        this.course = coarseName;
        this.institution = institution;
    }


}
