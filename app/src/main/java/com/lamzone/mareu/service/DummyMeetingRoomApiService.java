package com.lamzone.mareu.service;

import com.lamzone.mareu.model.MeetingRoom;

import java.util.List;

public class DummyMeetingRoomApiService implements MeetingRoomApiService {

    private DummyMeetingRoomApiService() {

    }

    private static DummyMeetingRoomApiService singleton = new DummyMeetingRoomApiService();

    public static DummyMeetingRoomApiService getInstance(){
        return singleton;
    }

    private List<MeetingRoom> meetingRooms = DummyMeetingRoomGenerator.generateMeetingRoom();

    /**
     * Get all Meeting
     * @return {@link java.util.List}
     */

    public List<MeetingRoom> getMeetingRoom() {
        return meetingRooms;
    }

    /**
     * Deletes a meeting
     * @param meetingRoom
     */
    public void deleteMeetingRoom (MeetingRoom meetingRoom){
        meetingRooms.remove(meetingRoom);
    }

    /**
     * {@inheritDoc}
     *
     * @param meetingRoom
     */

    public void createMeetingRoom(MeetingRoom meetingRoom) {
        meetingRooms.add(meetingRoom);
    }
}
