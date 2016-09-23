package nycschool.com.example.ezraerani.myapplication;

import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ezraerani on 4/22/16.
 */
public class SelectorForm extends DialogFragment {

    private static final String TAG = SelectorForm.class.getSimpleName();

    public interface OnFilterParametersSelectedListener {
        void addParametersToDataFilter(ArrayList<String> chosenParameters, String category);
    }


    private ArrayAdapter<String> adapter;
    ArrayList<String> data;
    @BindView(R.id.list) ListView listView;
    Context ctx;
    String filterType;
    OnFilterParametersSelectedListener onFilterParametersSelectedListener;

    View view;

    public SelectorForm() {
        ctx = getActivity();
    }

    public static SelectorForm newInstance() {
        SelectorForm fragment = new SelectorForm();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.selector_form, null);
        ButterKnife.bind(this, view);

        Log.d(TAG, "pre-getArgs");

        data = DataAccess.getInstance().getSelectedFilterSubset();

        Log.d(TAG, "post-getArgs");


        adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_multiple_choice, data);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        return view;

    }

    @OnClick(R.id.submitSelectorForm)
    public void submitSelections(View view) {
        SparseBooleanArray checked = listView.getCheckedItemPositions();
        for (int i = listView.getCount() - 1; i >= 0; i--) {

            if (checked.get(i) == false) {

                data.remove(i);
            }
        }

        onFilterParametersSelectedListener = (OnFilterParametersSelectedListener) getActivity();
        onFilterParametersSelectedListener.addParametersToDataFilter(data, filterType);
//                Log.d("PARAMETER_SUBMISSION", data.get(0).toString());
        dismiss();
    }










}
