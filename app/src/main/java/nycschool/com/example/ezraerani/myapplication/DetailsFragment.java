package nycschool.com.example.ezraerani.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ezraerani on 4/22/16.
 */
public class DetailsFragment extends Fragment {


    private AfterSchoolActivity activity;

    @BindView(R.id.textViewSchool) TextView schoolText;
    @BindView(R.id.textViewActivity) TextView activityText;
    @BindView(R.id.textViewAddress) TextView addressText;
    @BindView(R.id.textViewPhone) TextView phoneText;

    // TODO: 9/23/16 implement map view where latlon != null

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View detailView = inflater.inflate(R.layout.details_fragment, container, false);
        ButterKnife.bind(this, detailView);
        activity = getArguments().getParcelable("DATA");

        schoolText.setText(activity.getSiteName());
        activityText.setText(activity.getProgram());
        addressText.setText(activity.getSiteAddress());
        phoneText.setText(activity.getContactNumber());

        return detailView;


    }
}
