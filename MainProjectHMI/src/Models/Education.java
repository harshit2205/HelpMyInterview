package Models;

/**
 * Created by USER on 7/13/2017.
 */
public class Education {
    String userNAme;
    String degree;
    String coarseName;
    String institution;

    public String getUserNAme() {
        return userNAme;
    }

    public void setUserNAme(String userNAme) {
        this.userNAme = userNAme;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getCoarseName() {
        return coarseName;
    }

    public void setCoarseName(String coarseName) {
        this.coarseName = coarseName;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public Education(String userNAme, String degree, String coarseName, String institution) {

        this.userNAme = userNAme;
        this.degree = degree;
        this.coarseName = coarseName;
        this.institution = institution;
    }


}
