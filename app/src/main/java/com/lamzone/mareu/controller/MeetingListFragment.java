package com.lamzone.mareu.controller;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lamzone.mareu.R;
import com.lamzone.mareu.event.DeleteMeetingEvent;
import com.lamzone.mareu.model.Meeting;
import com.lamzone.mareu.service.MeetingApiService;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import butterknife.BindView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MeetingListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MeetingListFragment extends Fragment {

    @BindView(R.id.fragment_meeting_list)
    RecyclerView mRecyclerView;

    private MeetingApiService mApiService;
    private List <Meeting> mMeetings;
    MyMeetingRecyclerViewAdapter mRecyclerViewAdapter;

    public MeetingListFragment() {
        // Required empty public constructor
    }


    public static MeetingListFragment newInstance() {
        MeetingListFragment fragment = new MeetingListFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_meeting_list, container, false);
        Context context = view.getContext();
        mRecyclerView = (RecyclerView) view;
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        return view;
    }

    /**
     * Init the list of meetings
     */

    private void initList() {
        mMeetings = mApiService.getMeeting();
        mRecyclerView.setAdapter(new MyMeetingRecyclerViewAdapter(mMeetings));
    }

    @Override
    public void onResume() {
        super.onResume();
        initList();
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    /**
     * Fired if the user clicks on a delete button
     * @param event
     **/

    @Subscribe
    public void onDeleteMeeting(DeleteMeetingEvent event) {
        mApiService.deleteMeeting(event.meeting);
        initList();
    }



}
