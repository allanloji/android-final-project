package com.allanloji.language_cast;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by allan on 10/04/18.
 */
class RecyclerViewHolder extends RecyclerView.ViewHolder{
    public ImageView imageView;
    public TextView txtDescription;

    public RecyclerViewHolder(View itemView) {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.newsImage);
        txtDescription = (TextView) itemView.findViewById(R.id.txtDescription);
    }
}

public class NewsRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    private List<Event> listEvents = new ArrayList<Event>();

    public NewsRecyclerViewAdapter(List<Event> listEvents) {
        this.listEvents = listEvents;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View eventView = inflater.inflate(R.layout.news_layout, parent, false);
        return new RecyclerViewHolder(eventView);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.imageView.setImageResource(listEvents.get(position).getImageID());
        holder.txtDescription.setText(listEvents.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return listEvents.size();
    }
}
