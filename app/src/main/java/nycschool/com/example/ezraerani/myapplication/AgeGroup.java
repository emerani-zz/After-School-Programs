package nycschool.com.example.ezraerani.myapplication;

import java.util.ArrayList;

/**
 * Created by ezraerani on 4/22/16.
 */
public class AgeGroup {

    String ageGroupName;
    ArrayList<AfterSchoolActivity> activitiesInAgeGroup;

    public AgeGroup(String ageGroupName) {
        this.ageGroupName = ageGroupName;
    }

    public String getAgeGroupName() {
        return ageGroupName;
    }

    public void setAgeGroupName(String ageGroupName) {
        this.ageGroupName = ageGroupName;
    }

    public ArrayList<AfterSchoolActivity> getActivitiesInAgeGroup() {
        return activitiesInAgeGroup;
    }

    public void setActivitiesInAgeGroup(ArrayList<AfterSchoolActivity> activitiesInAgeGroup) {
        this.activitiesInAgeGroup = activitiesInAgeGroup;
    }
}
