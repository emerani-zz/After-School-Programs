package nycschool.com.example.ezraerani.myapplication;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends FragmentActivity implements
        ListOfChoicesActivity.OnAfterSchoolActivitySelectedListener,
        SelectorForm.OnFilterParametersSelectedListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    DataAccess dataAccess;
    InitDataSet initDataSet;
    HashMap<String, ArrayList<String>> selectedFilterParameters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_fragment);
        ButterKnife.bind(this);

        selectedFilterParameters = new HashMap<>();
        dataAccess = DataAccess.getInstance();

        initDataSet = new InitDataSet();
        initDataSet.execute();
    }

    @OnClick({R.id.btn_ageGroup, R.id.btn_program, R.id.btn_borough, R.id.btn_results})
    public void onFilterOptionSelected(View view) {
        Log.d(TAG, "onClick");
        switch (view.getId()) {
            case R.id.btn_borough:
                Log.d(TAG, "btn_borough");
                dataAccess.setSelectedFilterSubset(dataAccess.getBoroughs());
                break;
            case R.id.btn_program:
                Log.d(TAG, "btn_program");
                dataAccess.setSelectedFilterSubset(dataAccess.getPrograms());
                break;
            case R.id.btn_ageGroup:
                Log.d(TAG, "btn_ageGroup");
                dataAccess.setSelectedFilterSubset(dataAccess.getAgeGroups());
                break;
            case R.id.btn_results:
                resolveDataSetAndDisplayList();
            default:
                break;
        }
        SelectorForm selectorForm = SelectorForm.newInstance();
//        selectorForm.setStyle(DialogFragment.STYLE_NORMAL, R.style.CustomDialog);
        selectorForm.show(getSupportFragmentManager(), "selector_form");
//        getFragmentManager().executePendingTransactions();
    }

    @Override
    public void addParametersToDataFilter(ArrayList<String> chosenParameters, String category) {
        selectedFilterParameters.put(category, chosenParameters);
//        Log.d("PARAMETER_ADDED", category);
//        Log.d("PROOF", chosenParameters.get(0).toString());
//        Log.d("Hmap Success", Boolean.toString(selectedFilterParameters.containsKey(category)));
    }

    public void resolveDataSetAndDisplayList() {
//        ArrayList<AfterSchoolActivity> activities = dataAccess.finalActivitiesList
//                (selectedFilterParameters);
        startActivity(new Intent(this, ListOfChoicesActivity.class));
    }

    @Override
    public void onAfterSchoolActivitySelected(AfterSchoolActivity activity) {

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

        }
    }
}
