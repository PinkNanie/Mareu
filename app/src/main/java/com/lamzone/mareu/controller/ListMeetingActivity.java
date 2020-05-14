package com.lamzone.mareu.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.lamzone.mareu.R;
import com.lamzone.mareu.model.Meeting;
import com.lamzone.mareu.service.DummyMeetingApiService;
import com.lamzone.mareu.service.DummyMeetingGenerator;
import com.lamzone.mareu.service.MeetingApiService;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ListMeetingActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    private MeetingApiService mApiService;
    private List<Meeting> mMeetingList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_meeting);
        ButterKnife.bind(this);
        mApiService = DummyMeetingApiService.getInstance();
        mMeetingList = DummyMeetingGenerator.DUMMY_MEETING;

        setSupportActionBar(mToolbar);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.filter_hour:
                mApiService.filterByHour("");
                return true;
            case R.id.filter_meetingRoom:
                mApiService.filterByMeetingRoom("");
                return true;
            default: return super.onOptionsItemSelected(item);
        }
    }

    @OnClick
            (R.id.fab)
    void addMeeting() {
        Intent addMeetingActivity = new Intent(ListMeetingActivity.this, AddMeetingActivity.class);
        startActivity(addMeetingActivity);
    }



}
