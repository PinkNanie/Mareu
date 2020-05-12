package com.lamzone.mareu.controller;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.lamzone.mareu.R;
import com.lamzone.mareu.model.Meeting;
import com.lamzone.mareu.model.Participant;

import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyMeetingRecyclerViewAdapter extends RecyclerView.Adapter<MyMeetingRecyclerViewAdapter.ViewHolder> {

    private final List<Meeting> mMeetings;


    public MyMeetingRecyclerViewAdapter(List<Meeting> items) {
        mMeetings = items;
    }


    @Override
    public MyMeetingRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_meeting, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(MyMeetingRecyclerViewAdapter.ViewHolder holder, int position) {

        Meeting meeting = mMeetings.get(position);
        holder.mMeetingName.setText(meeting.getLocation() + "-" + meeting.getHour() + "-" + meeting.getSubject() + "\n" + meeting.getParticipants().toString());
        Glide.with(holder.mCirclemeeting.getContext())
                .load(getRandomColorDrawable())
                .apply(RequestOptions.circleCropTransform())
                .into(holder.mCirclemeeting);


    }

    @Override
    public int getItemCount() {
        return mMeetings.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_list_meeting)
        public ImageView mCirclemeeting;
        @BindView(R.id.item_list_meetingName)
        public TextView mMeetingName;


        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }


    private ColorDrawable[] randomColorList = {

            new ColorDrawable(Color.parseColor("#FFCCCC")), new ColorDrawable(Color.parseColor("#B0E0E6")),
            new ColorDrawable(Color.parseColor("#FFFFCC")), new ColorDrawable(Color.parseColor("#D8BFD8")),
            new ColorDrawable(Color.parseColor("#CCFFCC")), new ColorDrawable(Color.parseColor("#BC8F8F")),
            new ColorDrawable(Color.parseColor("#99FFCC")), new ColorDrawable(Color.parseColor("#FFA500")),
            new ColorDrawable(Color.parseColor("#CC99FF")), new ColorDrawable(Color.parseColor("#BA55D3"))
    };

    public ColorDrawable getRandomColorDrawable() {
        int idx = new Random().nextInt(randomColorList.length);
        return randomColorList[idx];
    }


}
