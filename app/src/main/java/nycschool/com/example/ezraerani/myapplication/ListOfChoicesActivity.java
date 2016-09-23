package nycschool.com.example.ezraerani.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

/**
 * Created by ezraerani on 4/22/16.
 */
public class ListOfChoicesActivity extends AppCompatActivity {

    public interface OnAfterSchoolActivitySelectedListener {
        void onAfterSchoolActivitySelected(AfterSchoolActivity activity);
    }

    private AdapterListFragment myAdapterList;
    ArrayList<AfterSchoolActivity> actArrayList;
    OnAfterSchoolActivitySelectedListener listener;

    @BindView(R.id.filteredActivitiesRV)
    RecyclerView recyclerView;
    // TODO: 9/23/16 implement recyclerview

    View view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_fragment);

        ButterKnife.bind(this, view);

    }

    @OnItemClick(R.id.filteredActivitiesRV)
    public void itemClicked(int position) {
        // TODO: 9/23/16 render detail fragment activity and start from here.  set approp values in dao
    }
}

