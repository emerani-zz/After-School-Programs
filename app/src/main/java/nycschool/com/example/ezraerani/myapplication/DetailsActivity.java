package nycschool.com.example.ezraerani.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ezraerani on 4/22/16.
 */
public class DetailsActivity extends AppCompatActivity {


    private AfterSchoolActivity activity;

    @BindView(R.id.textViewSchool) TextView schoolText;
    @BindView(R.id.textViewActivity) TextView activityText;
    @BindView(R.id.textViewAddress) TextView addressText;
    @BindView(R.id.textViewPhone) TextView phoneText;

    // TODO: 9/23/16 implement map view where latlon != null


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_fragment);
        ButterKnife.bind(this);

        activity = DataAccess.getInstance().getSelectedActivity();

        schoolText.setText(activity.getSiteName());
        activityText.setText(activity.getProgram());
        addressText.setText(activity.getSiteAddress());
        phoneText.setText(activity.getContactNumber());


    }

}
