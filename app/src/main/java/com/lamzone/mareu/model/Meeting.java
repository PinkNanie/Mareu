package com.lamzone.mareu.model;


import android.graphics.Typeface;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;

import androidx.annotation.NonNull;

import java.util.List;

public class Meeting {

    private String mHour;
    private String mDate;
    private String mMeetingRoom;
    private String mSubject;
    private List<Participant> mParticipants;

    public Meeting(String hour, String date, String meetingRoom, String subject, List<Participant> participants) {
        this.mHour = hour;
        this.mDate = date;
        this.mMeetingRoom = meetingRoom;
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
        return mMeetingRoom;
    }

    public void setLocation(String mLocation) {
        this.mMeetingRoom = mLocation;
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

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }

    @NonNull
    @Override
    public String toString() {
        String result = mMeetingRoom + "-" + mHour + "-" + mSubject + "\n";
          return String.format(result);
    }

    public String participantsToString (){
        String result = "";
        for (Participant participant: mParticipants ){
            result = participant.getEmail() + ",";
        }
        return result.substring(0,result.length()-2);
    }
}


