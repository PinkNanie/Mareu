package com.lamzone.mareu.service;

import com.lamzone.mareu.model.MeetingRoom;

import java.util.List;

public interface MeetingRoomApiService {

    /**
     * Get all Meeting
     * @return {@link java.util.List}
     */

    List<MeetingRoom> getMeetingRoom();

    /**
     * Deletes a meeting
     * @param meetingRoom
     */
    void deleteMeetingRoom (MeetingRoom meetingRoom);

    /**
     * {@inheritDoc}
     *
     * @param meetingRoom
     */

    void createMeetingRoom (MeetingRoom meetingRoom);
}
