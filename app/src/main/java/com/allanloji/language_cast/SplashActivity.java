package com.allanloji.language_cast;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent it = new Intent( SplashActivity.this, LoginActivity.class);
                startActivity(it);
                finish();
            }
        }, 5000);
    }
}
