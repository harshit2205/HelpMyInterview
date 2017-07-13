package Beans.Utils;

/**
 * Created by staLker on 09-07-2017.
 */
public class Skill {
    private String skillName;
    private String experience;

    public Skill() {
    }

    public Skill(String skillName, String experience) {
        this.skillName = skillName;
        this.experience = experience;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }
}
