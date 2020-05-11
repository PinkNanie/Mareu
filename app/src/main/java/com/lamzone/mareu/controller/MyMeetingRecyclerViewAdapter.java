package com.lamzone.mareu.controller;

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

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class MyMeetingRecyclerViewAdapter extends RecyclerView.Adapter<MyMeetingRecyclerViewAdapter.ViewHolder> {

    private final List<Meeting> mMeetings;

    public MyMeetingRecyclerViewAdapter(List<Meeting> items){
        mMeetings = items;
    }


    @Override
    public MyMeetingRecyclerViewAdapter.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_meeting, parent, false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(MyMeetingRecyclerViewAdapter.ViewHolder holder, int position) {

        Meeting meeting = mMeetings.get(position);
        holder.mMeetingName.setText(meeting.getLocation() + "-" + meeting.getHour() + "-" + meeting.getSubject() + meeting.getParticipants());
        Glide.with(holder.mCirclemeeting.getContext())
                .load(R.drawable.ic_brightness_1_black_24dp)
                .apply(RequestOptions.circleCropTransform())
                .into(holder.mCirclemeeting);


    }

    @Override
    public int getItemCount() {
        return mMeetings.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.item_list_meeting)
        public ImageView mCirclemeeting;
        @BindView(R.id.item_list_meetingName)
        public TextView mMeetingName;


        public ViewHolder(View view){
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
