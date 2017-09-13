package Beans.Models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

/**
 * Created by staLker on 07-07-2017.
 */
public class Education {
    private String degree;
    private String course;
    private String institution;

    public Education() {
        //empty constructor was made intentionally.
    }

    public Education(String degree, String course, String institution) {
        this.degree = degree;
        this.course = course;
        this.institution = institution;
    }

    public static ObservableList<String> getAllDegree(){
        ArrayList<String> allDegrees = new ArrayList<>();
        allDegrees.add("High-School");
        allDegrees.add("Intermediate");
        allDegrees.add("Graduation");
        allDegrees.add("Post-Graduation");
        allDegrees.add("Phd");
        allDegrees.add("Other");
        return FXCollections.observableList(allDegrees);
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
}
