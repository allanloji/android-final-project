package com.allanloji.language_cast;


import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.allanloji.language_cast.pojo.News;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;


public class EventDetailActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
    private TextView title, direction, date, description;
    private Button bttn;
    private SimpleDraweeView image;
    private YouTubePlayerView youTubePlayerView;
    private String key="AIzaSyCd8f1McFmDKTTH5pIWYu7MbONzct0Wh2I";
    private String uri = "k0FFKbI6VLk";
    private YouTubePlayer player;

    private String eventTitle, eventDirection, eventDate, eventDescription, eventImage, eventId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);

        title = (TextView) findViewById(R.id.eventDetailTitle);
        direction = (TextView) findViewById(R.id.eventDetailDirection);
        date = (TextView) findViewById(R.id.eventDetailDate);
        description = (TextView) findViewById(R.id.eventDetailDescription);
        bttn = (Button) findViewById(R.id.eventDetailBttn);
        image = findViewById(R.id.eventDetailImg);

        eventTitle = (String) getIntent().getSerializableExtra("event_title");
        eventDirection = (String) getIntent().getSerializableExtra("event_direction");
        eventDate = (String) getIntent().getSerializableExtra("event_date");
        eventDescription = (String) getIntent().getSerializableExtra("event_description");
        eventImage = (String) getIntent().getSerializableExtra("event_image");
        eventId = (String) getIntent().getSerializableExtra("event_id");

        Uri uri = Uri.parse(eventImage);
        image.setImageURI(uri);

        title.setText(eventTitle);
        direction.setText(eventDirection);
        date.setText(eventDate);
        description.setText(eventDescription);
        description.setMovementMethod(new ScrollingMovementMethod());
        if(ProfileSingleton.getInstance().getHistoryList().size() > 0) {
            boolean found = false;
            int i = 0;
            while (!found && i<ProfileSingleton.getInstance().getHistoryList().size()) {
                if (ProfileSingleton.getInstance().getHistoryList().get(i).getId().equals(eventId)) {
                    found = true;
                    bttn.setVisibility(View.INVISIBLE);
                } else {
                    bttn.setVisibility(View.VISIBLE);
                }
                i++;
            }
        }

        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.videoView);
        youTubePlayerView.initialize(key, this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        this.player = youTubePlayer;
        if(!b){
            youTubePlayer.cueVideo(uri);
        }

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(this, "Youtube Error Not Available", Toast.LENGTH_LONG).show();

    }

    public void Assist(View v){
        News news = new News(eventImage, eventTitle, eventDate, eventDescription,eventDirection);
        news.setId(eventId);
        news.setLatitude((String) getIntent().getSerializableExtra("event_lat"));
        news.setLongitude((String) getIntent().getSerializableExtra("event_long"));
        ProfileSingleton.getInstance().getHistoryList().add(news);
        Toast toast = Toast.makeText(getApplicationContext(), "Se ha registrado este evento", Toast.LENGTH_SHORT);
        toast.show();

    }
}
