package com.lamzone.mareu.model;

import java.util.List;

public class Meeting {

    private String mHour;
    private String mLocation;
    private String mSubject;
    private List<Participant> mParticipants;

    public Meeting(String hour, String location, String subject, List<Participant> participants) {
        this.mHour = hour;
        this.mLocation = location;
        this.mSubject = subject;
        this.mParticipants = participants;
    }

    public String getHour() {
        return mHour;
    }

    public void setHour(String mHour) {
        this.mHour = mHour;
    }

    public String getLocation() {
        return mLocation;
    }

    public void setLocation(String mLocation) {
        this.mLocation = mLocation;
    }

    public String getSubject() {
        return mSubject;
    }

    public void setSubject(String mSubject) {
        this.mSubject = mSubject;
    }

    public List getParticipants() {
        return mParticipants;
    }

    public void setParticipants(List mParticipants) {
        this.mParticipants = mParticipants;
    }


}
