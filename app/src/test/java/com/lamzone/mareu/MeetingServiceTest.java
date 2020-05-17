package com.lamzone.mareu;

import com.lamzone.mareu.model.Meeting;
import com.lamzone.mareu.service.DummyMeetingApiService;
import com.lamzone.mareu.service.DummyMeetingGenerator;
import com.lamzone.mareu.service.MeetingApiService;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Unit test on Meeting service
 */

@RunWith(JUnit4.class)
public class MeetingServiceTest {

    private MeetingApiService service;

    @Before
    public void setup() {
        service = DummyMeetingApiService.getNewInstanceApiService();
    }


    @Test
    public void getMeetingsWithSuccess() {
        List<Meeting> meetings = service.getMeeting();
        List<Meeting> expectedMeetings = DummyMeetingGenerator.DUMMY_MEETING;
        assertThat(meetings, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedMeetings.toArray()));
    }

    @Test
    public void  deleteMeetingWithSuccess() {
        Meeting meetingToDelete = service.getMeeting().get(0);
        service.deleteMeeting(meetingToDelete);
        assertFalse(service.getMeeting().contains(meetingToDelete));
    }

    @Test
    public void filterByHourWithSuccess(){
        List<Meeting> meetings = service.getMeeting();
        meetings.clear();
        meetings.add(new Meeting("14H0","","",null));
        meetings.add(new Meeting("16H0","","",null));
        List<Meeting> filteredHourMeeting = service.filterByHour("14H0");
        assertTrue(filteredHourMeeting.size()==1);
        assertTrue(filteredHourMeeting.get(0).getHour().equals("14H0"));
    }

    @Test
    public void filterByMeetingRoomWithSuccess() {
        List<Meeting> meetings = service.getMeeting();
        meetings.clear();
        meetings.add(new Meeting("","A","",null));
        meetings.add(new Meeting("","B","",null));
        List<Meeting> filteredMeetings = service.filterByMeetingRoom("A");
        assertTrue(filteredMeetings.size()== 1);
        assertTrue(filteredMeetings.get(0).getLocation().equals("A"));
    }


}
