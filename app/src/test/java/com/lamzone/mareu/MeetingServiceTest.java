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
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
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



}