package nycschool.com.example.ezraerani.myapplication;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends FragmentActivity implements MainMenuFragment.ShowSelectorForm,
        ListFragment.OnAfterSchoolActivitySelectedListener, SelectorForm.OnFilterParametersSelectedListener{

    DataAccess dataAccess;

    InitDataSet initDataSet;
    FragmentTransaction fragmentTransaction;
    MainMenuFragment mainMenuFragment;
    HashMap<String, ArrayList<String>> selectedFilterParameters;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainMenuFragment = new MainMenuFragment();

        selectedFilterParameters = new HashMap<>();

//        fragmentTransaction = getSupportFragmentManager().beginTransaction();
//        fragmentTransaction.add(R.id.fragment_container, new MainMenuFragment()).commit();


        initDataSet = new InitDataSet();

        dataAccess = DataAccess.getInstance();

        initDataSet.execute();


    }

    @Override
    public void onFilterOptionSelected(String filter) {
        Log.d("onFilterOptionSelected", filter);
        SelectorForm selectorForm = new SelectorForm();
        Bundle bundle = new Bundle();
        bundle.putString("filterType", filter);

        switch (filter) {
            case "BOROUGHS":
                bundle.putStringArrayList("DATA", dataAccess.getBoroughs());
                selectorForm.setArguments(bundle);
                selectorForm.show(getFragmentManager(), "selector_form");
                break;
            case "PROGRAMS":
                bundle.putStringArrayList("DATA", dataAccess.getPrograms());
                selectorForm.setArguments(bundle);
                selectorForm.show(getFragmentManager(), "selector_form");
                break;
            case "AGEGROUPS":
                bundle.putStringArrayList("DATA", dataAccess.getAgeGroups());
                selectorForm.setArguments(bundle);
                selectorForm.show(getFragmentManager(), "selector_form");
                break;
            case "RESULT":
                resolveDataSetAndDisplayList();
            default:
                break;
        }

//        selectorForm.setArguments(bundle);
//        selectorForm.show(getFragmentManager(), "selector_form");
    }

    @Override
    public void onAfterSchoolActivitySelected(AfterSchoolActivity activity) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        DetailsFragment detailsFragment = new DetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("DATA", activity);
        detailsFragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.fragment_container, detailsFragment).commit();
    }

    @Override
    public void addParametersToDataFilter(ArrayList<String> chosenParameters, String category) {
        selectedFilterParameters.put(category, chosenParameters);
        Log.d("PARAMETER_ADDED", category);
        Log.d("PROOF", chosenParameters.get(0).toString());
        Log.d("Hmap Success", Boolean.toString(selectedFilterParameters.containsKey(category)));
    }

    public void resolveDataSetAndDisplayList() {
        ArrayList<AfterSchoolActivity> activities = dataAccess.finalActivitiesList(selectedFilterParameters);
        displayListOfSelectedActivities(activities);
    }

    public void displayListOfSelectedActivities(ArrayList<AfterSchoolActivity> activities) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        ListFragment listFragment = new ListFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("DATA", activities);
        listFragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.fragment_container, listFragment).commit();
    }

    public class InitDataSet extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... params) {
            String x = dataAccess.getAPIData();
            return x;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.d("JSON", s);
            dataAccess.distributeData(s);
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.fragment_container, mainMenuFragment).commit();



        }
    }
}
