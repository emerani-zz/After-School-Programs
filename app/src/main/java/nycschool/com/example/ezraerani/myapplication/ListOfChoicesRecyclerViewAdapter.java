package nycschool.com.example.ezraerani.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ezraerani on 9/23/16.
 */

public class ListOfChoicesRecyclerViewAdapter extends
        RecyclerView.Adapter<ListOfChoicesRecyclerViewAdapter.IndivActivityHolder> {


    @Override
    public IndivActivityHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(IndivActivityHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class IndivActivityHolder extends RecyclerView.ViewHolder {

        public IndivActivityHolder(View itemView) {
            super(itemView);
        }
    }
}
