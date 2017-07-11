package Utils;

/**
 * Created by staLker on 09-07-2017.
 */
public class Training {
    private String trainingName;
    private String organizationName;
    private boolean trainingOnline;
    private String trainingLocation;
    private String description;

    public Training() {

    }

    public Training(String trainingName, String organizationName, boolean trainingOnline, String trainingLocation, String description) {
        this.trainingName = trainingName;
        this.organizationName = organizationName;
        this.trainingOnline = trainingOnline;
        this.trainingLocation = trainingLocation;
        this.description = description;
    }


    public String getTrainingName() {return trainingName;}

    public void setTrainingName(String trainingName) {
        this.trainingName = trainingName;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public boolean isTrainingOnline() {return trainingOnline;}

    public void setTrainingOnline(boolean trainingOnline) {this.trainingOnline = trainingOnline;}

    public String getTrainingLocation() {
        return trainingLocation;
    }

    public void setTrainingLocation(String trainingLocation) {
        this.trainingLocation = trainingLocation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
