package nycschool.com.example.ezraerani.myapplication;

import java.util.ArrayList;

/**
 * Created by ezraerani on 4/22/16.
 */
public class Borough {

    String boroughName;
    ArrayList <AfterSchoolActivity> activitiesInBorough;

    public Borough(String boroughName) {
        this.boroughName = boroughName;
    }

    public String getBoroughName() {
        return boroughName;
    }

    public void setBoroughName(String boroughName) {
        this.boroughName = boroughName;
    }

    public ArrayList<AfterSchoolActivity> getActivitiesInBorough() {
        return activitiesInBorough;
    }

    public void setActivitiesInBorough(ArrayList<AfterSchoolActivity> activitiesInBorough) {
        this.activitiesInBorough = activitiesInBorough;
    }
}
