package com.lamzone.mareu.controller;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;


import com.lamzone.mareu.R;
import com.lamzone.mareu.model.Meeting;
import com.lamzone.mareu.service.DummyMeetingApiService;
import com.lamzone.mareu.service.DummyMeetingRoomGenerator;
import com.lamzone.mareu.service.MeetingApiService;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ListMeetingActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener, AdapterView.OnItemSelectedListener {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    private MeetingApiService mApiService;
    private MyMeetingRecyclerViewAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_meeting);
        ButterKnife.bind(this);
        mApiService = DummyMeetingApiService.getInstance();
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

        switch (item.getItemId()) {

            case R.id.filter_hour:
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(),"time picker");
                return true;
            case R.id.filter_meetingRoom:
                spinnerFilterMeetingRoom();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute){
        List<Meeting> meetings = mApiService.filterByHour(hourOfDay + "h" + minute);
        MeetingListFragment f = (MeetingListFragment) getSupportFragmentManager().getFragments().get(0);
        f.setMeetingList(meetings);
    }

    public void spinnerFilterMeetingRoom(){
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(ListMeetingActivity.this);
        View mView = getLayoutInflater().inflate(R.layout.spinner_filter_meetingroom, null);
        mBuilder.setTitle("Choisir une salle de réunion");
        Spinner mSpinner = mView.findViewById(R.id.spinner_Filter);

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, DummyMeetingRoomGenerator.DUMMY_MEETINGROOM);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(adapter);
        mSpinner.setOnItemSelectedListener(this);

        mBuilder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                List<Meeting> meetings = mApiService.filterByMeetingRoom(mSpinner.getSelectedItem().toString());
                MeetingListFragment f = (MeetingListFragment) getSupportFragmentManager().getFragments().get(0);
                f.setMeetingList(meetings);
            }
        });

        mBuilder.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                dialog.dismiss();

            }
        });

        mBuilder.setView(mView);
        AlertDialog dialog = mBuilder.create();
        dialog.show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Object item = parent.getItemAtPosition(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {}

    @OnClick
            (R.id.fab)
    void addMeeting() {
        Intent addMeetingActivity = new Intent(ListMeetingActivity.this, AddMeetingActivity.class);
        startActivity(addMeetingActivity);
    }
}
