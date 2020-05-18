package com.lamzone.mareu.controller;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import com.lamzone.mareu.R;
import com.lamzone.mareu.model.Meeting;
import com.lamzone.mareu.model.Participant;
import com.lamzone.mareu.service.DummyMeetingApiService;
import com.lamzone.mareu.service.DummyMeetingRoomApiService;
import com.lamzone.mareu.service.DummyMeetingRoomGenerator;
import com.lamzone.mareu.service.MeetingApiService;
import com.lamzone.mareu.service.MeetingRoomApiService;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class AddMeetingActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener , AdapterView.OnItemSelectedListener, DatePickerDialog.OnDateSetListener {

    @BindView(R.id.spinner)
    Spinner mSpinner;
    @BindView(R.id.button_TP)
    Button mButtonTP;
    @BindView(R.id.time)
    TextView mTime;
    @BindView(R.id.subject)
    EditText mSubject;
    @BindView(R.id.participants)
    EditText mParticipants;
    @BindView(R.id.add_Meeting)
    Button mAddMeeting_btn;
    @BindView(R.id.button_DP)
    Button mButtonDP;
    @BindView(R.id.date)
    TextView mDate;

    private MeetingApiService mApiService;
    private MeetingRoomApiService mRoomApiServiceApiService = DummyMeetingRoomApiService.getInstance();
    private Participant mParticipant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_meeting);
        ButterKnife.bind(this);
        mApiService = DummyMeetingApiService.getInstance();

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, DummyMeetingRoomGenerator.DUMMY_MEETINGROOM);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(adapter);
        mSpinner.setOnItemSelectedListener(this);

        mButtonTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(),"time picker");
            }
        });

        mButtonDP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(),"date picker");
            }
        });


        mSubject.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mAddMeeting_btn.setEnabled(s.length() > 0);
            }
        });
    }

    public void onItemSelected (AdapterView<?> parent, View view, int position, long id) {
        Object item = parent.getItemAtPosition(position);
    }


    public void onNothingSelected(AdapterView<?> parent) {}


    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        mTime.setText(hourOfDay + "h"  + minute);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String currentDateString = DateFormat.getDateInstance().format(c.getTime());
        mDate.setText(currentDateString);

    }

    @OnClick(R.id.add_Meeting)
    void addMeeting(){
        mParticipant = new Participant("");
        List<Participant> participantMeetingList = new ArrayList<>();
        String participants = mParticipants.getText().toString();
        String[] allParticipants = participants.split(",");
        for (String string:allParticipants){
            Participant participant= new Participant(string);
            participantMeetingList.add(participant);
        }

        Meeting meeting = new Meeting (
                mTime.getText().toString(),
                mDate.getText().toString(),
                mSpinner.getSelectedItem().toString(),
                mSubject.getText().toString(),
                participantMeetingList);
        mApiService.createMeeting(meeting);
        finish();
    }


}
