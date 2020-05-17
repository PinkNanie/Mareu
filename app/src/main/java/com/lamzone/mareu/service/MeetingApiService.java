package com.lamzone.mareu.service;

import com.lamzone.mareu.model.Meeting;
import com.lamzone.mareu.model.MeetingRoom;

import java.util.List;

/**
 * Meeting API client
 */

public interface MeetingApiService {
    /**
     * Get all Meeting
     * @return {@link java.util.List}
     */

    List<Meeting> getMeeting();


    /**
     * Deletes a meeting
     * @param meeting
     */
    void deleteMeeting (Meeting meeting);


    /**
     * {@inheritDoc}
     *
     * @param meeting
     */

    void createMeeting (Meeting meeting);

    List<Meeting> filterByMeetingRoom(String meetingRoom);

    List<Meeting> filterByHour(String hour);
}
