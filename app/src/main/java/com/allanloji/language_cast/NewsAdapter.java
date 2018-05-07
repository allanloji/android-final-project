package com.allanloji.language_cast;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.allanloji.language_cast.pojo.News;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder>{
    private List<News> newsList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, date;
        private SimpleDraweeView newsImage;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.newsTitle);
            date = (TextView) view.findViewById(R.id.newsDate);
            newsImage = view.findViewById(R.id.newsImage);
        }
    }


    public NewsAdapter(List<News> newsList) {
        this.newsList = newsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        News news = newsList.get(position);
        holder.title.setText(news.getTitle());
        holder.date.setText(news.getDate());
        Uri uri = Uri.parse(news.getImage());
        holder.newsImage.setImageURI(uri);
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }
}
