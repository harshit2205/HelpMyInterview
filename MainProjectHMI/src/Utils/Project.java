package Utils;

/**
 * Created by staLker on 10-07-2017.
 */
public class Project {
    private String projectTitle;
    private String projectURL;
    private boolean projectOnGoing;
    private String projectDescription;

    public Project() {
    }

    public Project(String projectTitle, String projectURL, boolean projectOnGoing, String projectDescription) {
        this.projectTitle = projectTitle;
        this.projectURL = projectURL;
        this.projectOnGoing = projectOnGoing;
        this.projectDescription = projectDescription;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public String getProjectURL() {
        return projectURL;
    }

    public void setProjectURL(String projectURL) {
        this.projectURL = projectURL;
    }

    public boolean isProjectOnGoing() {
        return projectOnGoing;
    }

    public void setProjectOnGoing(boolean projectOnGoing) {
        this.projectOnGoing = projectOnGoing;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }
}
