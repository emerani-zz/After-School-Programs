package nycschool.com.example.ezraerani.myapplication;

import java.util.ArrayList;

/**
 * Created by ezraerani on 4/22/16.
 */
public class Program {

    String programName;
    ArrayList<AfterSchoolActivity> activitiesOfProgram;

    public Program(String programName) {
        this.programName = programName;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public ArrayList<AfterSchoolActivity> getActivitiesOfProgram() {
        return activitiesOfProgram;
    }

    public void setActivitiesOfProgram(ArrayList<AfterSchoolActivity> activitiesOfProgram) {
        this.activitiesOfProgram = activitiesOfProgram;
    }
}
