package Beans.Utils;

/**
 * Created by staLker on 11-07-2017.
 */
public class Job {
    private String profile;
    private String organization;
    private boolean workFromHome;
    private String location;
    private String description;

    public Job() {
    }

    public Job(String profile, String organization, boolean workFromHome, String location, String description) {
        this.profile = profile;
        this.organization = organization;
        this.workFromHome = workFromHome;
        this.location = location;
        this.description = description;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public boolean isWorkFromHome() {
        return workFromHome;
    }

    public void setWorkFromHome(boolean workFromHome) {
        this.workFromHome = workFromHome;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
