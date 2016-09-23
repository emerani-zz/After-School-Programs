package nycschool.com.example.ezraerani.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

/**
 * Created by ezraerani on 4/22/16.
 */
public class ListFragment extends android.support.v4.app.Fragment {

    public interface OnAfterSchoolActivitySelectedListener {
        void onAfterSchoolActivitySelected(AfterSchoolActivity activity);
    }

    private AdapterListFragment myAdapterList;
    ArrayList<AfterSchoolActivity> actArrayList;
    OnAfterSchoolActivitySelectedListener listener;

    @BindView(R.id.lv) ListView fragmentListView;
    // TODO: 9/23/16 implement recyclerview

    View view;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.list_fragment, container, false);
        ButterKnife.bind(this, view);
        actArrayList = getArguments().getParcelableArrayList("DATA");
        fragmentListView.setAdapter(new AdapterListFragment(this.getContext(), actArrayList));
//        fragmentListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                listener = (OnAfterSchoolActivitySelectedListener) getActivity();
//                listener.onAfterSchoolActivitySelected(actArrayList.get(position));
//            }
//        });
//        setListAdapter(new AdapterListFragment(getActivity(), actArrayList));

        return view;
    }

    @OnItemClick(R.id.lv)
    public void itemClicked(int position) {
        listener = (OnAfterSchoolActivitySelectedListener) getActivity();
        listener.onAfterSchoolActivitySelected(actArrayList.get(position));
    }



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }
}

