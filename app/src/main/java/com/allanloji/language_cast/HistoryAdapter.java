package com.allanloji.language_cast;

import android.graphics.Movie;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.allanloji.language_cast.pojo.News;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.MyViewHolder>{
    private List<News> historyList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, date, direction;
        public SimpleDraweeView img;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.historyTitle);
            date = (TextView) view.findViewById(R.id.historyDate);
            direction = (TextView) view.findViewById(R.id.historyDirection);
            img = view.findViewById(R.id.historyImage);
        }
    }


    public HistoryAdapter(List<News> historyList) {
        this.historyList = historyList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.history_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        News history = historyList.get(position);
        holder.title.setText(history.getTitle());
        holder.date.setText(history.getDate());
        holder.direction.setText(history.getDirection());
        Uri uri = Uri.parse(history.getImage());
        holder.img.setImageURI(uri);
    }

    @Override
    public int getItemCount() {
        return historyList.size();
    }
}
