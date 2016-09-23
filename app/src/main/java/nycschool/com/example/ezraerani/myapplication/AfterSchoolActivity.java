package nycschool.com.example.ezraerani.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ezraerani on 4/22/16.
 */
public class AfterSchoolActivity implements Parcelable {

    public String agency, contactNumber, ageGroup, borough, program, siteName, siteAddress,
    programType;

    public AfterSchoolActivity(String agency, String contactNumber,
                               String ageGroup, String borough, String program,
                               String siteName, String siteAddress, String programType) {
        this.agency = agency;
        this.contactNumber = contactNumber;
        this.ageGroup = ageGroup;
        this.borough = borough;
        this.program = program;
        this.siteName = siteName;
        this.siteAddress = siteAddress;
        this.programType = programType;

    }

    protected AfterSchoolActivity(Parcel in) {
        agency = in.readString();
        contactNumber = in.readString();
        ageGroup = in.readString();
        borough = in.readString();
        program = in.readString();
        siteName = in.readString();
        siteAddress = in.readString();
        programType = in.readString();
    }

    public static final Creator<AfterSchoolActivity> CREATOR = new Creator<AfterSchoolActivity>() {
        @Override
        public AfterSchoolActivity createFromParcel(Parcel in) {
            return new AfterSchoolActivity(in);
        }

        @Override
        public AfterSchoolActivity[] newArray(int size) {
            return new AfterSchoolActivity[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(agency);
        dest.writeString(contactNumber);
        dest.writeString(ageGroup);
        dest.writeString(borough);
        dest.writeString(program);
        dest.writeString(siteName);
        dest.writeString(siteAddress);
        dest.writeString(programType);
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    public String getBorough() {
        return borough;
    }

    public void setBorough(String borough) {
        this.borough = borough;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteAddress() {
        return siteAddress;
    }

    public void setSiteAddress(String siteAddress) {
        this.siteAddress = siteAddress;
    }

    public String getProgramType() {
        return programType;
    }

    public void setProgramType(String programType) {
        this.programType = programType;
    }

    public static Creator<AfterSchoolActivity> getCREATOR() {
        return CREATOR;
    }
}
