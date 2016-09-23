package nycschool.com.example.ezraerani.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by ezraerani on 4/22/16.
 */
public class FilteredDataSet implements Parcelable {

    ArrayList<AfterSchoolActivity> list;

    public FilteredDataSet() {
        list = new ArrayList<>();
    }

    public ArrayList<AfterSchoolActivity> getList() {
        return list;
    }

    public void setList(ArrayList<AfterSchoolActivity> list) {
        this.list = list;
    }

    public void addSingleToList(AfterSchoolActivity activity) {
        list.add(activity);
    }

    public void addMultipleToList(ArrayList<AfterSchoolActivity> activities) {
        for (AfterSchoolActivity afterSchoolActivity : activities) {
            list.add(afterSchoolActivity);
        }
    }

    public void removeSingleFromList(AfterSchoolActivity activity) {
        if (list.contains(activity)) list.remove(activity);

    }

    protected FilteredDataSet(Parcel in) {
    }

    public static final Creator<FilteredDataSet> CREATOR = new Creator<FilteredDataSet>() {
        @Override
        public FilteredDataSet createFromParcel(Parcel in) {
            return new FilteredDataSet(in);
        }

        @Override
        public FilteredDataSet[] newArray(int size) {
            return new FilteredDataSet[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
