package com.babycount.fpapp.babycount;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements BabyCount {

    private Intent activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button spanish = (Button) findViewById(R.id.btnSpanish);
        Button english = (Button) findViewById(R.id.btnEnglish);
        Button china = (Button) findViewById(R.id.btnChinies);
        Button japan = (Button) findViewById(R.id.btnJapan);
        activity = new Intent(MainActivity.this, CountActivity.class);
        final Locale localeSpanish = new Locale("es", "ES");

        spanish.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                activity.putExtra(LOCALE_KEY, localeSpanish);
                startActivity(activity);
            }

        });

        english.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                activity.putExtra(LOCALE_KEY, Locale.US);
                startActivity(activity);
            }

        });

        japan.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                activity.putExtra(LOCALE_KEY, Locale.JAPAN);
                startActivity(activity);
            }

        });
    }
}
