package com.allanloji.language_cast;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class HistoryDetailActivity extends Activity {
    private TextView title, direction, date, description;
    private Button bttn;

    private String historyTitle, historyDirection, historyDate, historyDescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_detail);

        title = (TextView) findViewById(R.id.historyDetailTitle);
        direction = (TextView) findViewById(R.id.historyDetailDirection);
        date = (TextView) findViewById(R.id.historyDetailDate);
        description = (TextView) findViewById(R.id.historyDetailDescription);
        bttn = (Button) findViewById(R.id.historyDetailBttn);

        historyTitle = (String) getIntent().getSerializableExtra("history_title");
        historyDirection = (String) getIntent().getSerializableExtra("history_direction");
        historyDate = (String) getIntent().getSerializableExtra("history_date");
        historyDescription = (String) getIntent().getSerializableExtra("history_description");

        title.setText(historyTitle);
        direction.setText(historyDirection);
        date.setText(historyDate);
        description.setText(historyDescription);
    }
}
