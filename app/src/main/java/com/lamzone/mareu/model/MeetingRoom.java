package com.lamzone.mareu.model;

import androidx.annotation.NonNull;

public class MeetingRoom {

    private String mMeetingRoom;
    private int mMeetingRoomIndex;

    public MeetingRoom(String meetingRoom, int meetingRoomIndex) {
        mMeetingRoom = meetingRoom;
        mMeetingRoomIndex = meetingRoomIndex;
    }

    public String getMeetingRoom() {
        return mMeetingRoom;
    }

    public void setMeetingRoom(String meetingRoom) {
        mMeetingRoom = meetingRoom;
    }

    public int getMeetingRoomIndex() {
        return mMeetingRoomIndex;
    }

    public void setMeetingRoomIndex(int meetingRoomIndex) {
        mMeetingRoomIndex = meetingRoomIndex;
    }

    @NonNull
    @Override
    public String toString() {
        return String.format(mMeetingRoom);
    }
}


