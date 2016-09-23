package nycschool.com.example.ezraerani.myapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by ezraerani on 4/22/16.
 */
public class CustomArrayListAdapter extends ArrayAdapter {

    Context context;
    List<String> data;

    public CustomArrayListAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
        this.context = context;
        this.data = objects;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }
}
