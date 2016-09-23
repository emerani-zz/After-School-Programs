package nycschool.com.example.ezraerani.myapplication;

import java.util.ArrayList;

/**
 * Created by ezraerani on 4/22/16.
 */
public interface DOAInterface {



    public ArrayList<Borough> getAllBoroughs();
    public ArrayList<Program> getAllPrograms();
    public ArrayList<AgeGroup> getAllAgeGroups();
    public ArrayList getFilteredDataSetList();
    public String getAPIData();
    public void distributeData(String rawJSONData);

}
