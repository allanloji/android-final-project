package com.allanloji.language_cast;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LanguageSelectionActivity extends Activity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_selection);

    }

    public void AcceptLanguage(View view){
        Intent it = new Intent( LanguageSelectionActivity.this, MainActivity.class);
        startActivity(it);
    }
}
