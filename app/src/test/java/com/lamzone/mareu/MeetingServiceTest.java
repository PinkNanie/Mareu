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
    public void filterByDateWithSuccess(){
        List<Meeting> meetings = service.getMeeting();
        meetings.clear();
        meetings.add(new Meeting("","15 mai 2020","","",null));
        meetings.add(new Meeting("","16 mai 2020","","",null));
        List<Meeting> filteredDateMeeting = service.filterByDate("15 mai 2020");
        assertTrue(filteredDateMeeting.size()==1);
        assertTrue(filteredDateMeeting.get(0).getDate().equals("15 mai 2020"));
    }

    @Test
    public void filterByMeetingRoomWithSuccess() {
        List<Meeting> meetings = service.getMeeting();
        meetings.clear();
        meetings.add(new Meeting("","","A","",null));
        meetings.add(new Meeting("","","B","",null));
        List<Meeting> filteredMeetings = service.filterByMeetingRoom("A");
        assertTrue(filteredMeetings.size()== 1);
        assertTrue(filteredMeetings.get(0).getLocation().equals("A"));
    }


}
