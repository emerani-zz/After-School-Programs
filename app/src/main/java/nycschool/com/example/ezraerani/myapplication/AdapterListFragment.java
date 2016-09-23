package nycschool.com.example.ezraerani.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ezraerani on 4/25/16.
 */
public class AdapterListFragment extends ArrayAdapter<AfterSchoolActivity> {

        private  Context ctx;
        private  ArrayList<AfterSchoolActivity> actArrayList;


        public AdapterListFragment (Context ctx, ArrayList<AfterSchoolActivity> actArrayList){
            super(ctx, R.layout.row_view, actArrayList);
            this.ctx = ctx;
            this.actArrayList = actArrayList;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {


            LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowView = inflater.inflate(R.layout.row_view, parent, false);
            TextView siteTextView = (TextView) rowView.findViewById(R.id.sitetext);
            TextView activeTextView = (TextView) rowView.findViewById(R.id.activetext);

            siteTextView.setText(actArrayList.get(position).getSiteName());
            activeTextView.setText(actArrayList.get(position).getProgram());





            return rowView;
        }

}
