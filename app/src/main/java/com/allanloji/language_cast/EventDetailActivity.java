package com.allanloji.language_cast;


import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;


public class EventDetailActivity extends Activity {
    private TextView title, direction, date, description;
    private Button bttn;

    private String eventTitle, eventDirection, eventDate, eventDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);

        title = (TextView) findViewById(R.id.eventDetailTitle);
        direction = (TextView) findViewById(R.id.eventDetailDirection);
        date = (TextView) findViewById(R.id.eventDetailDate);
        description = (TextView) findViewById(R.id.eventDetailDescription);
        bttn = (Button) findViewById(R.id.eventDetailBttn);

        eventTitle = (String) getIntent().getSerializableExtra("event_title");
        eventDirection = (String) getIntent().getSerializableExtra("event_direction");
        eventDate = (String) getIntent().getSerializableExtra("event_date");
        eventDescription = (String) getIntent().getSerializableExtra("event_description");

        title.setText(eventTitle);
        direction.setText(eventDirection);
        date.setText(eventDate);
        description.setText(eventDescription);


    }
}
