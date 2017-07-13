package Beans.Utils;

/**
 * Created by staLker on 11-07-2017.
 */
public class Internship {
    private String titleOfInternship;
    private String organization;
    private String location;
    private boolean workFromHome;
    private String description;

    public Internship() {
    }

    public Internship(String titleOfInternship, String organization, String location, boolean workFromHome, String description) {
        this.titleOfInternship = titleOfInternship;
        this.organization = organization;
        this.location = location;
        this.workFromHome = workFromHome;
        this.description = description;
    }

    public String getTitleOfInternship() {
        return titleOfInternship;
    }

    public void setTitleOfInternship(String titleOfInternship) {
        this.titleOfInternship = titleOfInternship;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isWorkFromHome() {
        return workFromHome;
    }

    public void setWorkFromHome(boolean workFromHome) {
        this.workFromHome = workFromHome;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
