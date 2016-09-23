package nycschool.com.example.ezraerani.myapplication;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by ezraerani on 4/22/16.
 */
public class DataAccess {

    private static DataAccess instance = new DataAccess();
    private static final String BASE_URL = "https://data.cityofnewyork.us/resource/btx2-u66x.json";

    HttpURLConnection con;
    BufferedReader reader;


    ArrayList<AfterSchoolActivity> masterActivityList;
    FilteredDataSet filteredDataSet;
    HashMap<String, ArrayList<AfterSchoolActivity>> boroughHashMap;
    HashMap<String, ArrayList<AfterSchoolActivity>> programHashMap;
    HashMap<String, ArrayList<AfterSchoolActivity>> ageGroupHashMap;




    private DataAccess() {
        boroughHashMap = new HashMap<>();
        programHashMap = new HashMap<>();
        ageGroupHashMap = new HashMap<>();
        filteredDataSet = new FilteredDataSet();
    }


    public static DataAccess getInstance() {
        return instance;
    }




    public ArrayList getFilteredDataSetList() {
        return filteredDataSet.getList();
    }


    public String getAPIData() {


        try {

            URL object = new URL(BASE_URL);
            con = (HttpURLConnection) object.openConnection();
            con.setRequestMethod("GET");
            con.connect();

            InputStream stream = con.getInputStream();
            reader = new BufferedReader(new InputStreamReader(stream));

            StringBuffer buffer = new StringBuffer();

            String line = "";

            while ((line = reader.readLine()) != null) {
                buffer.append(line + "\n");
            }

            return buffer.toString();


        } catch (Exception e) {
            Log.d("CATCH_HTTP_REQUEST", "CALLED");
            e.printStackTrace();
        } finally {
            if (con != null) {
                con.disconnect();
            }
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }



    public void distributeData(String rawJSONData) {

        JSONArray jarray;
        JSONObject jsonObject;

        try {
            jarray = new JSONArray(rawJSONData);

            for (int i = 0; i < jarray.length(); i++) {
                jsonObject = jarray.getJSONObject(i);
                AfterSchoolActivity newActivity = new AfterSchoolActivity(
                        jsonObject.optString("agency", null),
                        jsonObject.optString("contact_number", null),
                        jsonObject.optString("grade_level_age_group",null),
                        jsonObject.optString("borough_community", null),
                        jsonObject.optString("program", null),
                        jsonObject.optString("site_name", null),
                        jsonObject.optString("location_1_location", null) + ", " + jsonObject.optString(
                                "location_1_zip", null),
                        jsonObject.optString("program_type", null)
                        );

                addToBorough(newActivity);
                addToAgeGroup(newActivity);
                addToProgram(newActivity);
//                filteredDataSet.addSingleToList(newActivity);



            }


        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    public void addToBorough(AfterSchoolActivity activity) {
        if (!boroughHashMap.containsKey(activity.getBorough())) {
            boroughHashMap.put(activity.getBorough(), new ArrayList<AfterSchoolActivity>());
            boroughHashMap.get(activity.getBorough()).add(activity);
        } else {
            boroughHashMap.get(activity.getBorough()).add(activity);
        }
    }

    public void addToProgram(AfterSchoolActivity activity) {
        if (!programHashMap.containsKey(activity.getProgram())) {
            programHashMap.put(activity.getProgram(), new ArrayList<AfterSchoolActivity>());
            programHashMap.get(activity.getProgram()).add(activity);
        } else {
            programHashMap.get(activity.getProgram()).add(activity);
        }
    }

    public void addToAgeGroup(AfterSchoolActivity activity) {
        if (!ageGroupHashMap.containsKey(activity.getAgeGroup())) {
            ageGroupHashMap.put(activity.getAgeGroup(), new ArrayList<AfterSchoolActivity>());
            ageGroupHashMap.get(activity.getAgeGroup()).add(activity);
        } else {
            ageGroupHashMap.get(activity.getAgeGroup()).add(activity);
        }
    }

    public void addToMasterActivityList(AfterSchoolActivity activity) {
        masterActivityList.add(activity);
    }

    public void addBoroughSubsetToFilteredDataSet(ArrayList<String> boroughNames) {

        for (String name : boroughNames) {
            filteredDataSet.addMultipleToList(boroughHashMap.get(name));
        }

    }

    public void addProgramSubsettoFilteredDataSet(ArrayList<String> programNames) {

        for (String name : programNames) {
            filteredDataSet.addMultipleToList(programHashMap.get(name));
        }
    }

    public void filterOutBoroughs(ArrayList<String> selectedBoroughs) {

        for (String selectedBoroughName : selectedBoroughs) {
            for (AfterSchoolActivity activity : filteredDataSet.getList()) {
                if (activity.getBorough() != selectedBoroughName) {
                    filteredDataSet.getList().remove(activity);
                }
            }
        }

    }

    public void filterOutPrograms(ArrayList<String> selectedPrograms) {

        for (String selectedProgramName : selectedPrograms) {
            for (AfterSchoolActivity activity : filteredDataSet.getList()) {
                if (activity.getProgram() != selectedProgramName) {
                    filteredDataSet.getList().remove(activity);
                }
            }
        }
    }

    public void filterOutAgeGroups(ArrayList<String> selectedAgeGroups) {

        for (String selectedAgeGroup : selectedAgeGroups) {
            for (AfterSchoolActivity activity : filteredDataSet.getList()) {
                if (activity.getAgeGroup() != selectedAgeGroup) {
                    filteredDataSet.getList().remove(activity);
                }
            }
        }
    }

    public ArrayList<String> getBoroughs() {
        ArrayList<String> boroughNames = new ArrayList<>();
        Iterator iterator = boroughHashMap.keySet().iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            boroughNames.add(key);
        }
        return boroughNames;
    }

    public ArrayList<String> getAgeGroups() {
        ArrayList<String> ageGroupNames = new ArrayList<>();
        Iterator iterator = ageGroupHashMap.keySet().iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            ageGroupNames.add(key);
        }
        return ageGroupNames;
    }

    public ArrayList<String> getPrograms() {
        ArrayList<String> programNames = new ArrayList<>();
        Iterator iterator = programHashMap.keySet().iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            programNames.add(key);
        }
        return programNames;
    }

    public ArrayList<AfterSchoolActivity> finalActivitiesList(HashMap<String, ArrayList<String>>
                                                                      selectedFilterParameters) {


        Iterator iterator = selectedFilterParameters.keySet().iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            if (!selectedFilterParameters.containsKey("BOROUGHS")) {
                addBoroughSubsetToFilteredDataSet(getBoroughs());
            } else {
                addBoroughSubsetToFilteredDataSet(selectedFilterParameters.get("BOROUGHS"));
            }
//            if (key == "BOROUGHS") {
//                filterOutBoroughs(selectedFilterParameters.get("BOROUGHS"));
//            } else if (key == "PROGRAMS") {
//                filterOutPrograms(selectedFilterParameters.get("PROGRAMS"));
//            } else if (key == "AGEGROUPS") {
//                filterOutAgeGroups(selectedFilterParameters.get("AGEGROUPS"));
//            }
        }

        return filteredDataSet.getList();
    }
}
