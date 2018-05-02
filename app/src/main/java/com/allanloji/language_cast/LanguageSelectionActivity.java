package com.allanloji.language_cast;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class LanguageSelectionActivity extends Activity {
    private Button button;
    private GridLayout mainGrid;
    private ArrayList<String> languages = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_selection);

        mainGrid = (GridLayout) findViewById(R.id.mainGrid);
        setToggleEvent(mainGrid);


    }

    private void setToggleEvent(GridLayout mainGrid){
        for (int i = 0; i < mainGrid.getChildCount(); i++){
            final int index = i;
            final CardView cardView = (CardView)mainGrid.getChildAt(i);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   if (cardView.getCardBackgroundColor().getDefaultColor() == -1){
                       cardView.setCardBackgroundColor(Color.parseColor("#47AAE3"));
                       languages.add(getLanguage(index));

                   }else {
                       cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                       languages.remove(getLanguage(index));

                   }
                }
            });
        }
    }

    private void setSingleEvent(GridLayout mainGrid){

    }

    private String getLanguage(int index){
        String language = "";
        switch (index){
            case 0:
                language = "Espanol";
                break;

            case 1:
                language = "Ingles";
            break;

            case 2:
                language = "Italiano";
            break;

            case 3:
                language =  "Frances";
            break;

            case 4:
                language = "Japones";
            break;

            case 5:
                language = "Chino";
            break;

            case 6:
                language = "Coreano";
            break;

            case 7:
                language = "Aleman";
            break;
        }

        return language;
    }

    public void AcceptLanguage(View view){
        Intent it = new Intent( LanguageSelectionActivity.this, MainActivity.class);
        Log.e("Lenguajes seleccionados", languages.toString());
        startActivity(it);
    }
}
