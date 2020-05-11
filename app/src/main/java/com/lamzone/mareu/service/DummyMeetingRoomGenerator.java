package com.lamzone.mareu.service;

import com.lamzone.mareu.model.MeetingRoom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DummyMeetingRoomGenerator {

    public static List<MeetingRoom> DUMMY_MEETINGROOM = Arrays.asList(

            new MeetingRoom("Réunion A",0),
            new MeetingRoom("Réunion B",1),
            new MeetingRoom("Réunion C",2),
            new MeetingRoom("Réunion D",3),
            new MeetingRoom("Réunion E",4),
            new MeetingRoom("Réunion F",5),
            new MeetingRoom("Réunion G",6),
            new MeetingRoom("Réunion H",7),
            new MeetingRoom("Réunion I",8),
            new MeetingRoom("Réunion J",9)
    );

    static List<MeetingRoom> generateMeetingRoom(){
        return new ArrayList<>(DUMMY_MEETINGROOM);
    }
}
