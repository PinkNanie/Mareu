package com.lamzone.mareu.service;

import com.lamzone.mareu.model.Meeting;
import com.lamzone.mareu.model.Participant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DummyMeetingGenerator {

    public static List<Meeting> DUMMY_MEETING = Arrays.asList(

            new Meeting("14hoo", "Réunion A", "Peach", Arrays.asList(new Participant("maxime@lamzone.com"),new Participant("alex@lamzone.com"))),
            new Meeting("16h00", "Réunion B", "Mario", Arrays.asList(new Participant("paul@lamzone.com"),new Participant("viviane@lamzone.com"))),
            new Meeting("19h00", "Réunion C", "Luigi", Arrays.asList(new Participant("amandine@lamzone.com"),new Participant("luc@lamzone.com")))
    );

    static List<Meeting> generateMeeting(){
        return new ArrayList<>(DUMMY_MEETING);
    }
}

