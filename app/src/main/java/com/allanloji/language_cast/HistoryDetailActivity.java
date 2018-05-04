package com.allanloji.language_cast;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

public class HistoryDetailActivity extends Activity {
    private TextView title, direction, date, description;
    private SimpleDraweeView image;

    private String historyTitle, historyDirection, historyDate, historyDescription, eventImage, eventLatitude, eventLongitude;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_detail);

        title = (TextView) findViewById(R.id.historyDetailTitle);
        direction = (TextView) findViewById(R.id.historyDetailDirection);
        date = (TextView) findViewById(R.id.historyDetailDate);
        description = (TextView) findViewById(R.id.historyDetailDescription);
        image = findViewById(R.id.historyDetailImg);

        historyTitle = (String) getIntent().getSerializableExtra("history_title");
        historyDirection = (String) getIntent().getSerializableExtra("history_direction");
        historyDate = (String) getIntent().getSerializableExtra("history_date");
        historyDescription = (String) getIntent().getSerializableExtra("history_description");

        eventImage = (String) getIntent().getSerializableExtra("history_image");
        eventLatitude = (String) getIntent().getSerializableExtra("history_latitude");
        eventLongitude = (String) getIntent().getSerializableExtra("history_longitude");

        Uri uri = Uri.parse(eventImage);
        image.setImageURI(uri);

        title.setText(historyTitle);
        direction.setText(historyDirection);
        date.setText(historyDate);
        description.setText(historyDescription);
        description.setMovementMethod(new ScrollingMovementMethod());
    }

    public void seeLocation(View v){
        Intent intent = new Intent(this, MapsActivity.class);
        intent.putExtra("history_title", historyTitle);
        intent.putExtra("history_latitude", eventLatitude);
        intent.putExtra("history_longitude", eventLongitude);
        startActivity(intent);
    }
}
