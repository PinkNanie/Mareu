package com.lamzone.mareu.service;

import com.lamzone.mareu.model.Meeting;

import java.util.List;

public class DummyMeetingApiService implements MeetingApiService {

    private DummyMeetingApiService() {

    }

    private static MeetingApiService service = new DummyMeetingApiService();

    public static MeetingApiService getInstance(){ return service;  }

    private List<Meeting> meetings = DummyMeetingGenerator.generateMeeting();


    /**
     * Get all Meeting
     * @return {@link java.util.List}
     */

    public List<Meeting> getMeeting() {
        return meetings;
    }

    /**
     * Deletes a meeting
     * @param meeting
     */
    public void deleteMeeting (Meeting meeting){
        meetings.remove(meeting);
    }

    /**
     * {@inheritDoc}
     *
     * @param meeting
     */
    @Override
    public void createMeeting(Meeting meeting) {
        meetings.add(meeting);
    }

    public static MeetingApiService getNewInstanceApiService(){
        return new DummyMeetingApiService();
    }

}
