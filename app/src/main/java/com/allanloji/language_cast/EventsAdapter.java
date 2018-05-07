package com.allanloji.language_cast;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.allanloji.language_cast.pojo.Event;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.MyViewHolder> {
    private Context mContext;
    private List<Event> eventList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public SimpleDraweeView thumbnail;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            thumbnail = view.findViewById(R.id.thumbnail);
        }
    }


    public EventsAdapter(Context mContext, List<Event> eventList) {
        this.mContext = mContext;
        this.eventList = eventList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.events_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Event event = eventList.get(position);
        holder.title.setText(event.getTitle());
        Uri uri = Uri.parse(event.getImageID());
        holder.thumbnail.setImageURI(uri);


    }


    @Override
    public int getItemCount() {
        return eventList.size();
    }
}

