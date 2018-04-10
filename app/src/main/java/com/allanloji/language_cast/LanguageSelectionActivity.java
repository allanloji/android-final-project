package com.allanloji.language_cast;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Toast;

public class LanguageSelectionActivity extends Activity {
    private Button button;
    private GridLayout mainGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_selection);

        mainGrid = (GridLayout) findViewById(R.id.mainGrid);
        setToggleEvent(mainGrid);

    }

    private void setToggleEvent(GridLayout mainGrid){
        for (int i = 0; i < mainGrid.getChildCount(); i++){
            final CardView cardView = (CardView)mainGrid.getChildAt(i);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   if (cardView.getCardBackgroundColor().getDefaultColor() == -1){
                       cardView.setCardBackgroundColor(Color.parseColor("#47AAE3"));

                   }else {
                       cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));

                   }
                }
            });
        }
    }

    private void setSingleEvent(GridLayout mainGrid){

    }

    public void AcceptLanguage(View view){
        Intent it = new Intent( LanguageSelectionActivity.this, MainActivity.class);
        startActivity(it);
    }
}
