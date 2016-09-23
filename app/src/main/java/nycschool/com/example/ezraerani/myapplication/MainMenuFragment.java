package nycschool.com.example.ezraerani.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ezraerani on 4/22/16.
 */
public class MainMenuFragment extends Fragment implements View.OnClickListener {

    View view;
    ShowSelectorForm callback;

    public interface ShowSelectorForm {
        void onFilterOptionSelected(String filter);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.main_fragment, container, false);
        ButterKnife.bind(this, view);
//
//
//        view.findViewById(R.id.btn_ageGroup).setOnClickListener(this);
//        view.findViewById(R.id.btn_program).setOnClickListener(this);
//        view.findViewById(R.id.btn_borough).setOnClickListener(this);
//        view.findViewById(R.id.btn_results).setOnClickListener(this);

        callback = (ShowSelectorForm) getActivity();

        return view;
    }
    @OnClick({R.id.btn_ageGroup, R.id.btn_program, R.id.btn_borough, R.id.btn_results})
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_borough:
                callback.onFilterOptionSelected("BOROUGHS");
                break;
            case R.id.btn_ageGroup:
                callback.onFilterOptionSelected("AGEGROUPS");
                break;
            case R.id.btn_program:
                callback.onFilterOptionSelected("PROGRAMS");
                break;
            case R.id.btn_results:
                callback.onFilterOptionSelected("RESULT");
                break;
            default:
                break;
        }

    }
}
